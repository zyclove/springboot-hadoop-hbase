package com.example.springboothadoophbase.entity;

import lombok.Data;

import java.util.Date;

@Data
public class ClientUploadInstallEvent {
    private Long id;

    private String packageName;

    private String version;

    private String androidId;

    private String system;

    private String country;

    private String mediaSource;

    private String appsflyerId;

    private String channel;

    private String campaign;

    private String ad;

    private String adset;

    private Date uploadTime1;

    private Date uploadTime2;

    private Date createTime;

    private String buildId;

    private String buildModel;

    private String languageCountry;

    private String rdidAdvertisingid;

    private Long eventTimestamp;

    private String agency;
}