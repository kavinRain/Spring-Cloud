package com.vue.web.ui.service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.spring.cloud.common.beans.Page;
import com.spring.cloud.common.utils.DateUtil;
import com.vue.web.ui.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/7.
 */
@Service
public class UserService {


    public Map<String, Object> queryUserList(Page<User> page, String name) {
        Map<String,Object> result = Maps.newHashMap();
        result.put("total",100);
        result.put("users",buildUserList(20));
        return result;
    }

    private List<User> buildUserList(int userSize) {
        List<User> users = Lists.newArrayList();
        for(int i = 1 ;i<=userSize;i++){
            users.add(new User("name"+i,(i % 2)==2?1:0,i, DateUtil.getReqDate(),i+"号地球村"));
        }
        return users;
    }
}
