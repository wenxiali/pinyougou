package com.cssl.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserDto {
    private String nick_Name;
    private String email;
    private String sex;
    private String head_pic;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date time;
    private String provinceid;
    private String cityid;
    private String areaid;
    private String job;

    public UserDto() {

    }


}
