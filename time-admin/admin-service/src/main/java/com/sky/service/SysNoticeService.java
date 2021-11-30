package com.sky.service;


import com.sky.dto.NoticeDTO;
import com.sky.vo.DataGridView;

/**
 * @author sky
 * @create 2021-11-29 23:05
 */
public interface SysNoticeService {

    // 分页查询公告
    DataGridView listNoticePage(NoticeDTO noticeDto);

    // 添加
    int addNotice(NoticeDTO noticeDto);

    // 修改
    int updateNotice(NoticeDTO noticeDto);

    // 删除
    int deleteNoticeByIds(Long[] noticeIds);

    NoticeDTO getOne(Long noticeId);
}
