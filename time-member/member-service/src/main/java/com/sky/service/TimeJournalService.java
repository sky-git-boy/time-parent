package com.sky.service;

import com.sky.domain.TimeJournal;
import com.sky.dto.TimeJournalDTO;
import com.sky.vo.DataGridView;

/**
 * @author sky
 * @create 2021-12-03 11:51
 */
public interface TimeJournalService {

    // 添加
    int add(TimeJournalDTO dto);

    int update(TimeJournalDTO dto);

    DataGridView listPage(TimeJournalDTO dto);

    TimeJournal getOne(String recordId);
}
