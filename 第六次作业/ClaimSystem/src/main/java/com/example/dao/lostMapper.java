package com.example.dao;

import com.example.pojo.User;
import com.example.pojo.lost;

import java.util.List;

public interface lostMapper {
    List<lost> getLostMessage();


    List<lost> getLostMessageByDate(String lost_date);


    int addLost(lost lost);


    int updateLost(lost lost);


    int deleteLost(int lost_id);

    List<lost> getLostMessageByType(String lost_name);
}
