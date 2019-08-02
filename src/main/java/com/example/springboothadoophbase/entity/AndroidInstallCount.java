package com.example.springboothadoophbase.entity;

import lombok.Data;

import java.util.Date;

@Data
public class AndroidInstallCount {
    private Long id;

    private Integer count;

    private Date date;

    private String app;

    private String version;

    private String campaign;

    private String agency;

    private String country;

    private String mediaSource;

    private Date createTime;

    private Date updateTime;

}