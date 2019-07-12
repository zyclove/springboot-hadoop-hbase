package com.example.springboothadoophbase.entity;

import java.util.Date;

public class ClientUploadInstallEvent {
    private Long id;

    private String event;

    private String packageName;

    private String version;

    private String androidId;

    private String system;

    private String country;

    private String mediaSource;

    private String adjustId;

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

    private String creative;

    private String adgroup;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event == null ? null : event.trim();
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName == null ? null : packageName.trim();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public String getAndroidId() {
        return androidId;
    }

    public void setAndroidId(String androidId) {
        this.androidId = androidId == null ? null : androidId.trim();
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system == null ? null : system.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getMediaSource() {
        return mediaSource;
    }

    public void setMediaSource(String mediaSource) {
        this.mediaSource = mediaSource == null ? null : mediaSource.trim();
    }

    public String getAdjustId() {
        return adjustId;
    }

    public void setAdjustId(String adjustId) {
        this.adjustId = adjustId == null ? null : adjustId.trim();
    }

    public String getAppsflyerId() {
        return appsflyerId;
    }

    public void setAppsflyerId(String appsflyerId) {
        this.appsflyerId = appsflyerId == null ? null : appsflyerId.trim();
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel == null ? null : channel.trim();
    }

    public String getCampaign() {
        return campaign;
    }

    public void setCampaign(String campaign) {
        this.campaign = campaign == null ? null : campaign.trim();
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad == null ? null : ad.trim();
    }

    public String getAdset() {
        return adset;
    }

    public void setAdset(String adset) {
        this.adset = adset == null ? null : adset.trim();
    }

    public Date getUploadTime1() {
        return uploadTime1;
    }

    public void setUploadTime1(Date uploadTime1) {
        this.uploadTime1 = uploadTime1;
    }

    public Date getUploadTime2() {
        return uploadTime2;
    }

    public void setUploadTime2(Date uploadTime2) {
        this.uploadTime2 = uploadTime2;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getBuildId() {
        return buildId;
    }

    public void setBuildId(String buildId) {
        this.buildId = buildId == null ? null : buildId.trim();
    }

    public String getBuildModel() {
        return buildModel;
    }

    public void setBuildModel(String buildModel) {
        this.buildModel = buildModel == null ? null : buildModel.trim();
    }

    public String getLanguageCountry() {
        return languageCountry;
    }

    public void setLanguageCountry(String languageCountry) {
        this.languageCountry = languageCountry == null ? null : languageCountry.trim();
    }

    public String getRdidAdvertisingid() {
        return rdidAdvertisingid;
    }

    public void setRdidAdvertisingid(String rdidAdvertisingid) {
        this.rdidAdvertisingid = rdidAdvertisingid == null ? null : rdidAdvertisingid.trim();
    }

    public Long getEventTimestamp() {
        return eventTimestamp;
    }

    public void setEventTimestamp(Long eventTimestamp) {
        this.eventTimestamp = eventTimestamp;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency == null ? null : agency.trim();
    }

    public String getCreative() {
        return creative;
    }

    public void setCreative(String creative) {
        this.creative = creative == null ? null : creative.trim();
    }

    public String getAdgroup() {
        return adgroup;
    }

    public void setAdgroup(String adgroup) {
        this.adgroup = adgroup == null ? null : adgroup.trim();
    }
}