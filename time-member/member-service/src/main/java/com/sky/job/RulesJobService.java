package com.sky.job;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.sky.constants.Constants;
import com.sky.domain.TimeRewardInfo;
import com.sky.domain.TimeRules;
import com.sky.dto.MessageDTO;
import com.sky.mapper.TimeRewardInfoMapper;
import com.sky.mapper.TimeRulesMapper;
import com.sky.mapper.TimeTaskMapper;
import com.sky.server.WebSocketServer;
import com.sky.utils.IdGeneratorSnowflake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 用户奖赏规则扫描
 * @author sky
 * @create 2021-12-31 11:17
 */
@Service
public class RulesJobService {

    @Autowired
    private TimeRulesMapper rulesMapper;

    @Autowired
    private TimeTaskMapper taskMapper;

    @Autowired
    private TimeRewardInfoMapper rewardInfoMapper;

    // 每三秒扫描用户规则
    @Scheduled(cron = "0/3 * * * * ?")
    public void rulesJob() {
        // 待修改规则
        List<TimeRules> updateList = new ArrayList<>();

        // 扫描用户制定的启用规则
        List<TimeRules> rulesList = rulesMapper.selectList(new LambdaQueryWrapper<TimeRules>().eq(TimeRules::getStatus, Constants.STATUS_TRUE));

        rulesList.forEach(rule -> {
            // 如果截至时间小于当前时间，说明已超时 -> 发送超时惩罚
            if (rule.getDeadLine().before(new Date())) {
                try {
                    // 发送消息
                    WebSocketServer.sendInfo(new MessageDTO(rule.getPunishmentContent(), Constants.NOT_UNIQUE), String.valueOf(rule.getUserId()));
                    updateList.add(rule);
                    // 添加记录
                    this.insertUserReward(rule.getUserId(), rule.getPunishmentContent(), Constants.NOT_UNIQUE);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                // 今日需完成数
                int needCount = Integer.parseInt(rule.getNeedCount());

                // 获取用户今日完成数
                int doneCount = taskMapper.getUserTodayDoneCount(rule.getUserId());
                // 如果今日完成数大于等于应完成数
                if (doneCount >= needCount) {
                    try {
                        // 发送消息
                        WebSocketServer.sendInfo(new MessageDTO(rule.getRewardContent(), Constants.UNIQUE), String.valueOf(rule.getUserId()));
                        updateList.add(rule);
                        // 添加记录
                        this.insertUserReward(rule.getUserId(), rule.getRewardContent(), Constants.UNIQUE);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        // 消息发送完将该条规则设置成禁用
        updateList.forEach(item -> {
            item.setStatus(Constants.STATUS_FALSE);
            rulesMapper.updateById(item);
        });
    }

    private int insertUserReward(Long userId, String content, String type) {

        TimeRewardInfo rewardInfo = new TimeRewardInfo();

        rewardInfo.setId(IdGeneratorSnowflake.snowflakeId());
        rewardInfo.setUserId(userId);
        rewardInfo.setContent(content);
        rewardInfo.setType(type);
        rewardInfo.setCreateTime(new Date());

        return this.rewardInfoMapper.insert(rewardInfo);
    }
}
