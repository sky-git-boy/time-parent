package com.sky.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mysql.cj.protocol.x.Notice;
import com.sky.domain.SysNotice;
import com.sky.dto.NoticeDTO;
import com.sky.vo.DataGridView;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.mapper.SysNoticeMapper;
import com.sky.service.SysNoticeService;

import java.util.Arrays;
import java.util.Date;

/**
 * @author sky
 * @create 2021-11-29 23:05
 */
@Service
public class SysNoticeServiceImpl implements SysNoticeService {

    @Autowired
    private SysNoticeMapper noticeMapper;

    @Override
    public DataGridView listNoticePage(NoticeDTO noticeDto) {
        Page<SysNotice> page = new Page<>(noticeDto.getPageNum(), noticeDto.getPageSize());
        QueryWrapper<SysNotice> qw = new QueryWrapper<>();
        // 查询条件
        qw.like(StringUtils.isNotBlank(noticeDto.getNoticeTitle()), SysNotice.COL_NOTICE_TITLE, noticeDto.getNoticeTitle());
        qw.eq(StringUtils.isNotBlank(noticeDto.getNoticeType()), SysNotice.COL_NOTICE_TYPE, noticeDto.getNoticeType());
        qw.eq(StringUtils.isNotBlank(noticeDto.getStatus()), SysNotice.COL_STATUS, noticeDto.getStatus());
        qw.orderByDesc(SysNotice.COL_CREATE_TIME);
        this.noticeMapper.selectPage(page, qw);
        return new DataGridView(page.getTotal(), page.getRecords());
    }

    @Override
    public int addNotice(NoticeDTO noticeDto) {
        SysNotice notice = new SysNotice();
        BeanUtils.copyProperties(noticeDto, notice);
        notice.setCreateBy(noticeDto.getSimpleUser().getUserId());
        notice.setCreateTime(new Date());
        return this.noticeMapper.insert(notice);
    }

    @Override
    public int updateNotice(NoticeDTO noticeDto) {
        SysNotice notice = new SysNotice();
        BeanUtils.copyProperties(noticeDto, notice);
        notice.setUpdateBy(noticeDto.getSimpleUser().getUserId());
        notice.setUpdateTime(new Date());
        return this.noticeMapper.updateById(notice);
    }

    @Override
    public int deleteNoticeByIds(Long[] noticeIds) {
        if (noticeIds != null && noticeIds.length > 0) {
            return this.noticeMapper.deleteBatchIds(Arrays.asList(noticeIds));
        } else {
            return 0;
        }
    }

    @Override
    public NoticeDTO getOne(Long noticeId) {
        SysNotice notice = this.noticeMapper.selectById(noticeId);
        NoticeDTO dto = new NoticeDTO();
        BeanUtils.copyProperties(notice, dto);
        return dto;
    }
}
