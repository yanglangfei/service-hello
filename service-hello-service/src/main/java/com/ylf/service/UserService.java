package com.ylf.service;

import com.ylf.model.User;

/**
 * @Author YangLF
 * @Date 2017/10/28
 */
public interface UserService {

    int addUser(User user);


    User  findUser(Long id);

}
