package com.sky.service;


import com.sky.domain.TimeEvent;
import com.sky.dto.TimeEventDTO;

import java.util.List;

/**
 * @author sky
 * @create 2021-12-21 15:18
 */
public interface TimeEventService {
    
    int addTask(TimeEventDTO dto);

    int update(TimeEventDTO dto);

    int delete(Long id);

    List<TimeEventDTO> list(TimeEventDTO dto);

    TimeEvent getOne(Long id);
}
