package com.example.demo.service;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.dao.UserMapper;
import com.example.demo.entity.UserEntity;

@SpringBootTest
class UserServiceTest {
    
   @Autowired
    private UserService userService;
    
   @MockBean
   private UserMapper userMapper;
   
   @Test
   void findByIdでユーザーが取得できる() {
        UserEntity user = new UserEntity();
        user.setId(1);
        user.setName("桜");
                
        when(userMapper.getOne(1)).thenReturn(user);
        
        UserEntity result = userService.findById(1);
                
        assertEquals("桜", result.getName());
   }
}