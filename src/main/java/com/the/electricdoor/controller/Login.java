package com.the.electricdoor.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.the.electricdoor.dto.LoginDto;
import com.the.electricdoor.service.UserService;

@Controller
public class Login {

    @Autowired
    UserService userService;
    
    @PostMapping("/login")
    @ResponseBody
    public LoginDto login(String user_name, String passwd){

        boolean rs = userService.login(user_name, passwd);

        LoginDto dto = new LoginDto();

        if(rs==true){
        //dto的 result = ture;    
        dto.setResult(rs);
        //生成token后传入redis中去；
        String uuid = UUID.randomUUID().toString();
        userService.addToken(uuid, user_name);
        //token赋值给dto
        dto.setToken(uuid);
        dto.setMessage("成功");
        }else{
            dto.setMessage("失败");
        }
        
        //写入redis uuid: user_name
        return dto;
    }

    @PostMapping("/test")
    @ResponseBody
    public String test(){
        return "test";
    }



    //实现对目标房间查询的API(接口)
    @PostMapping("/search_room")
    @ResponseBody
    public String search(String hotel_id) {

        
        return "";
    }

}