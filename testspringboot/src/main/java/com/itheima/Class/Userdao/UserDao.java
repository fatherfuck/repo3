package com.itheima.Class.Userdao;

import com.itheima.Class.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface UserDao extends JpaSpecificationExecutor<User>,JpaRepository<User,Long>{
    public List<User> findAll();
}
