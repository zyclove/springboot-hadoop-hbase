package com.example.springboothadoophbase.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClientUploadInstallEventExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ClientUploadInstallEventExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPackageNameIsNull() {
            addCriterion("package_name is null");
            return (Criteria) this;
        }

        public Criteria andPackageNameIsNotNull() {
            addCriterion("package_name is not null");
            return (Criteria) this;
        }

        public Criteria andPackageNameEqualTo(String value) {
            addCriterion("package_name =", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameNotEqualTo(String value) {
            addCriterion("package_name <>", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameGreaterThan(String value) {
            addCriterion("package_name >", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameGreaterThanOrEqualTo(String value) {
            addCriterion("package_name >=", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameLessThan(String value) {
            addCriterion("package_name <", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameLessThanOrEqualTo(String value) {
            addCriterion("package_name <=", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameLike(String value) {
            addCriterion("package_name like", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameNotLike(String value) {
            addCriterion("package_name not like", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameIn(List<String> values) {
            addCriterion("package_name in", values, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameNotIn(List<String> values) {
            addCriterion("package_name not in", values, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameBetween(String value1, String value2) {
            addCriterion("package_name between", value1, value2, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameNotBetween(String value1, String value2) {
            addCriterion("package_name not between", value1, value2, "packageName");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(String value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(String value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(String value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(String value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(String value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(String value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLike(String value) {
            addCriterion("version like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotLike(String value) {
            addCriterion("version not like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<String> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<String> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(String value1, String value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(String value1, String value2) {
            addCriterion("version not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andAndroidIdIsNull() {
            addCriterion("android_id is null");
            return (Criteria) this;
        }

        public Criteria andAndroidIdIsNotNull() {
            addCriterion("android_id is not null");
            return (Criteria) this;
        }

        public Criteria andAndroidIdEqualTo(String value) {
            addCriterion("android_id =", value, "androidId");
            return (Criteria) this;
        }

        public Criteria andAndroidIdNotEqualTo(String value) {
            addCriterion("android_id <>", value, "androidId");
            return (Criteria) this;
        }

        public Criteria andAndroidIdGreaterThan(String value) {
            addCriterion("android_id >", value, "androidId");
            return (Criteria) this;
        }

        public Criteria andAndroidIdGreaterThanOrEqualTo(String value) {
            addCriterion("android_id >=", value, "androidId");
            return (Criteria) this;
        }

        public Criteria andAndroidIdLessThan(String value) {
            addCriterion("android_id <", value, "androidId");
            return (Criteria) this;
        }

        public Criteria andAndroidIdLessThanOrEqualTo(String value) {
            addCriterion("android_id <=", value, "androidId");
            return (Criteria) this;
        }

        public Criteria andAndroidIdLike(String value) {
            addCriterion("android_id like", value, "androidId");
            return (Criteria) this;
        }

        public Criteria andAndroidIdNotLike(String value) {
            addCriterion("android_id not like", value, "androidId");
            return (Criteria) this;
        }

        public Criteria andAndroidIdIn(List<String> values) {
            addCriterion("android_id in", values, "androidId");
            return (Criteria) this;
        }

        public Criteria andAndroidIdNotIn(List<String> values) {
            addCriterion("android_id not in", values, "androidId");
            return (Criteria) this;
        }

        public Criteria andAndroidIdBetween(String value1, String value2) {
            addCriterion("android_id between", value1, value2, "androidId");
            return (Criteria) this;
        }

        public Criteria andAndroidIdNotBetween(String value1, String value2) {
            addCriterion("android_id not between", value1, value2, "androidId");
            return (Criteria) this;
        }

        public Criteria andSystemIsNull() {
            addCriterion("system is null");
            return (Criteria) this;
        }

        public Criteria andSystemIsNotNull() {
            addCriterion("system is not null");
            return (Criteria) this;
        }

        public Criteria andSystemEqualTo(String value) {
            addCriterion("system =", value, "system");
            return (Criteria) this;
        }

        public Criteria andSystemNotEqualTo(String value) {
            addCriterion("system <>", value, "system");
            return (Criteria) this;
        }

        public Criteria andSystemGreaterThan(String value) {
            addCriterion("system >", value, "system");
            return (Criteria) this;
        }

        public Criteria andSystemGreaterThanOrEqualTo(String value) {
            addCriterion("system >=", value, "system");
            return (Criteria) this;
        }

        public Criteria andSystemLessThan(String value) {
            addCriterion("system <", value, "system");
            return (Criteria) this;
        }

        public Criteria andSystemLessThanOrEqualTo(String value) {
            addCriterion("system <=", value, "system");
            return (Criteria) this;
        }

        public Criteria andSystemLike(String value) {
            addCriterion("system like", value, "system");
            return (Criteria) this;
        }

        public Criteria andSystemNotLike(String value) {
            addCriterion("system not like", value, "system");
            return (Criteria) this;
        }

        public Criteria andSystemIn(List<String> values) {
            addCriterion("system in", values, "system");
            return (Criteria) this;
        }

        public Criteria andSystemNotIn(List<String> values) {
            addCriterion("system not in", values, "system");
            return (Criteria) this;
        }

        public Criteria andSystemBetween(String value1, String value2) {
            addCriterion("system between", value1, value2, "system");
            return (Criteria) this;
        }

        public Criteria andSystemNotBetween(String value1, String value2) {
            addCriterion("system not between", value1, value2, "system");
            return (Criteria) this;
        }

        public Criteria andCountryIsNull() {
            addCriterion("country is null");
            return (Criteria) this;
        }

        public Criteria andCountryIsNotNull() {
            addCriterion("country is not null");
            return (Criteria) this;
        }

        public Criteria andCountryEqualTo(String value) {
            addCriterion("country =", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotEqualTo(String value) {
            addCriterion("country <>", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThan(String value) {
            addCriterion("country >", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThanOrEqualTo(String value) {
            addCriterion("country >=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThan(String value) {
            addCriterion("country <", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThanOrEqualTo(String value) {
            addCriterion("country <=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLike(String value) {
            addCriterion("country like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotLike(String value) {
            addCriterion("country not like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryIn(List<String> values) {
            addCriterion("country in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotIn(List<String> values) {
            addCriterion("country not in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryBetween(String value1, String value2) {
            addCriterion("country between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotBetween(String value1, String value2) {
            addCriterion("country not between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andMediaSourceIsNull() {
            addCriterion("media_source is null");
            return (Criteria) this;
        }

        public Criteria andMediaSourceIsNotNull() {
            addCriterion("media_source is not null");
            return (Criteria) this;
        }

        public Criteria andMediaSourceEqualTo(String value) {
            addCriterion("media_source =", value, "mediaSource");
            return (Criteria) this;
        }

        public Criteria andMediaSourceNotEqualTo(String value) {
            addCriterion("media_source <>", value, "mediaSource");
            return (Criteria) this;
        }

        public Criteria andMediaSourceGreaterThan(String value) {
            addCriterion("media_source >", value, "mediaSource");
            return (Criteria) this;
        }

        public Criteria andMediaSourceGreaterThanOrEqualTo(String value) {
            addCriterion("media_source >=", value, "mediaSource");
            return (Criteria) this;
        }

        public Criteria andMediaSourceLessThan(String value) {
            addCriterion("media_source <", value, "mediaSource");
            return (Criteria) this;
        }

        public Criteria andMediaSourceLessThanOrEqualTo(String value) {
            addCriterion("media_source <=", value, "mediaSource");
            return (Criteria) this;
        }

        public Criteria andMediaSourceLike(String value) {
            addCriterion("media_source like", value, "mediaSource");
            return (Criteria) this;
        }

        public Criteria andMediaSourceNotLike(String value) {
            addCriterion("media_source not like", value, "mediaSource");
            return (Criteria) this;
        }

        public Criteria andMediaSourceIn(List<String> values) {
            addCriterion("media_source in", values, "mediaSource");
            return (Criteria) this;
        }

        public Criteria andMediaSourceNotIn(List<String> values) {
            addCriterion("media_source not in", values, "mediaSource");
            return (Criteria) this;
        }

        public Criteria andMediaSourceBetween(String value1, String value2) {
            addCriterion("media_source between", value1, value2, "mediaSource");
            return (Criteria) this;
        }

        public Criteria andMediaSourceNotBetween(String value1, String value2) {
            addCriterion("media_source not between", value1, value2, "mediaSource");
            return (Criteria) this;
        }

        public Criteria andAppsflyerIdIsNull() {
            addCriterion("appsflyer_id is null");
            return (Criteria) this;
        }

        public Criteria andAppsflyerIdIsNotNull() {
            addCriterion("appsflyer_id is not null");
            return (Criteria) this;
        }

        public Criteria andAppsflyerIdEqualTo(String value) {
            addCriterion("appsflyer_id =", value, "appsflyerId");
            return (Criteria) this;
        }

        public Criteria andAppsflyerIdNotEqualTo(String value) {
            addCriterion("appsflyer_id <>", value, "appsflyerId");
            return (Criteria) this;
        }

        public Criteria andAppsflyerIdGreaterThan(String value) {
            addCriterion("appsflyer_id >", value, "appsflyerId");
            return (Criteria) this;
        }

        public Criteria andAppsflyerIdGreaterThanOrEqualTo(String value) {
            addCriterion("appsflyer_id >=", value, "appsflyerId");
            return (Criteria) this;
        }

        public Criteria andAppsflyerIdLessThan(String value) {
            addCriterion("appsflyer_id <", value, "appsflyerId");
            return (Criteria) this;
        }

        public Criteria andAppsflyerIdLessThanOrEqualTo(String value) {
            addCriterion("appsflyer_id <=", value, "appsflyerId");
            return (Criteria) this;
        }

        public Criteria andAppsflyerIdLike(String value) {
            addCriterion("appsflyer_id like", value, "appsflyerId");
            return (Criteria) this;
        }

        public Criteria andAppsflyerIdNotLike(String value) {
            addCriterion("appsflyer_id not like", value, "appsflyerId");
            return (Criteria) this;
        }

        public Criteria andAppsflyerIdIn(List<String> values) {
            addCriterion("appsflyer_id in", values, "appsflyerId");
            return (Criteria) this;
        }

        public Criteria andAppsflyerIdNotIn(List<String> values) {
            addCriterion("appsflyer_id not in", values, "appsflyerId");
            return (Criteria) this;
        }

        public Criteria andAppsflyerIdBetween(String value1, String value2) {
            addCriterion("appsflyer_id between", value1, value2, "appsflyerId");
            return (Criteria) this;
        }

        public Criteria andAppsflyerIdNotBetween(String value1, String value2) {
            addCriterion("appsflyer_id not between", value1, value2, "appsflyerId");
            return (Criteria) this;
        }

        public Criteria andChannelIsNull() {
            addCriterion("channel is null");
            return (Criteria) this;
        }

        public Criteria andChannelIsNotNull() {
            addCriterion("channel is not null");
            return (Criteria) this;
        }

        public Criteria andChannelEqualTo(String value) {
            addCriterion("channel =", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotEqualTo(String value) {
            addCriterion("channel <>", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelGreaterThan(String value) {
            addCriterion("channel >", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelGreaterThanOrEqualTo(String value) {
            addCriterion("channel >=", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelLessThan(String value) {
            addCriterion("channel <", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelLessThanOrEqualTo(String value) {
            addCriterion("channel <=", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelLike(String value) {
            addCriterion("channel like", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotLike(String value) {
            addCriterion("channel not like", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelIn(List<String> values) {
            addCriterion("channel in", values, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotIn(List<String> values) {
            addCriterion("channel not in", values, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelBetween(String value1, String value2) {
            addCriterion("channel between", value1, value2, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotBetween(String value1, String value2) {
            addCriterion("channel not between", value1, value2, "channel");
            return (Criteria) this;
        }

        public Criteria andCampaignIsNull() {
            addCriterion("campaign is null");
            return (Criteria) this;
        }

        public Criteria andCampaignIsNotNull() {
            addCriterion("campaign is not null");
            return (Criteria) this;
        }

        public Criteria andCampaignEqualTo(String value) {
            addCriterion("campaign =", value, "campaign");
            return (Criteria) this;
        }

        public Criteria andCampaignNotEqualTo(String value) {
            addCriterion("campaign <>", value, "campaign");
            return (Criteria) this;
        }

        public Criteria andCampaignGreaterThan(String value) {
            addCriterion("campaign >", value, "campaign");
            return (Criteria) this;
        }

        public Criteria andCampaignGreaterThanOrEqualTo(String value) {
            addCriterion("campaign >=", value, "campaign");
            return (Criteria) this;
        }

        public Criteria andCampaignLessThan(String value) {
            addCriterion("campaign <", value, "campaign");
            return (Criteria) this;
        }

        public Criteria andCampaignLessThanOrEqualTo(String value) {
            addCriterion("campaign <=", value, "campaign");
            return (Criteria) this;
        }

        public Criteria andCampaignLike(String value) {
            addCriterion("campaign like", value, "campaign");
            return (Criteria) this;
        }

        public Criteria andCampaignNotLike(String value) {
            addCriterion("campaign not like", value, "campaign");
            return (Criteria) this;
        }

        public Criteria andCampaignIn(List<String> values) {
            addCriterion("campaign in", values, "campaign");
            return (Criteria) this;
        }

        public Criteria andCampaignNotIn(List<String> values) {
            addCriterion("campaign not in", values, "campaign");
            return (Criteria) this;
        }

        public Criteria andCampaignBetween(String value1, String value2) {
            addCriterion("campaign between", value1, value2, "campaign");
            return (Criteria) this;
        }

        public Criteria andCampaignNotBetween(String value1, String value2) {
            addCriterion("campaign not between", value1, value2, "campaign");
            return (Criteria) this;
        }

        public Criteria andAdIsNull() {
            addCriterion("ad is null");
            return (Criteria) this;
        }

        public Criteria andAdIsNotNull() {
            addCriterion("ad is not null");
            return (Criteria) this;
        }

        public Criteria andAdEqualTo(String value) {
            addCriterion("ad =", value, "ad");
            return (Criteria) this;
        }

        public Criteria andAdNotEqualTo(String value) {
            addCriterion("ad <>", value, "ad");
            return (Criteria) this;
        }

        public Criteria andAdGreaterThan(String value) {
            addCriterion("ad >", value, "ad");
            return (Criteria) this;
        }

        public Criteria andAdGreaterThanOrEqualTo(String value) {
            addCriterion("ad >=", value, "ad");
            return (Criteria) this;
        }

        public Criteria andAdLessThan(String value) {
            addCriterion("ad <", value, "ad");
            return (Criteria) this;
        }

        public Criteria andAdLessThanOrEqualTo(String value) {
            addCriterion("ad <=", value, "ad");
            return (Criteria) this;
        }

        public Criteria andAdLike(String value) {
            addCriterion("ad like", value, "ad");
            return (Criteria) this;
        }

        public Criteria andAdNotLike(String value) {
            addCriterion("ad not like", value, "ad");
            return (Criteria) this;
        }

        public Criteria andAdIn(List<String> values) {
            addCriterion("ad in", values, "ad");
            return (Criteria) this;
        }

        public Criteria andAdNotIn(List<String> values) {
            addCriterion("ad not in", values, "ad");
            return (Criteria) this;
        }

        public Criteria andAdBetween(String value1, String value2) {
            addCriterion("ad between", value1, value2, "ad");
            return (Criteria) this;
        }

        public Criteria andAdNotBetween(String value1, String value2) {
            addCriterion("ad not between", value1, value2, "ad");
            return (Criteria) this;
        }

        public Criteria andAdsetIsNull() {
            addCriterion("adset is null");
            return (Criteria) this;
        }

        public Criteria andAdsetIsNotNull() {
            addCriterion("adset is not null");
            return (Criteria) this;
        }

        public Criteria andAdsetEqualTo(String value) {
            addCriterion("adset =", value, "adset");
            return (Criteria) this;
        }

        public Criteria andAdsetNotEqualTo(String value) {
            addCriterion("adset <>", value, "adset");
            return (Criteria) this;
        }

        public Criteria andAdsetGreaterThan(String value) {
            addCriterion("adset >", value, "adset");
            return (Criteria) this;
        }

        public Criteria andAdsetGreaterThanOrEqualTo(String value) {
            addCriterion("adset >=", value, "adset");
            return (Criteria) this;
        }

        public Criteria andAdsetLessThan(String value) {
            addCriterion("adset <", value, "adset");
            return (Criteria) this;
        }

        public Criteria andAdsetLessThanOrEqualTo(String value) {
            addCriterion("adset <=", value, "adset");
            return (Criteria) this;
        }

        public Criteria andAdsetLike(String value) {
            addCriterion("adset like", value, "adset");
            return (Criteria) this;
        }

        public Criteria andAdsetNotLike(String value) {
            addCriterion("adset not like", value, "adset");
            return (Criteria) this;
        }

        public Criteria andAdsetIn(List<String> values) {
            addCriterion("adset in", values, "adset");
            return (Criteria) this;
        }

        public Criteria andAdsetNotIn(List<String> values) {
            addCriterion("adset not in", values, "adset");
            return (Criteria) this;
        }

        public Criteria andAdsetBetween(String value1, String value2) {
            addCriterion("adset between", value1, value2, "adset");
            return (Criteria) this;
        }

        public Criteria andAdsetNotBetween(String value1, String value2) {
            addCriterion("adset not between", value1, value2, "adset");
            return (Criteria) this;
        }

        public Criteria andUploadTime1IsNull() {
            addCriterion("upload_time1 is null");
            return (Criteria) this;
        }

        public Criteria andUploadTime1IsNotNull() {
            addCriterion("upload_time1 is not null");
            return (Criteria) this;
        }

        public Criteria andUploadTime1EqualTo(Date value) {
            addCriterion("upload_time1 =", value, "uploadTime1");
            return (Criteria) this;
        }

        public Criteria andUploadTime1NotEqualTo(Date value) {
            addCriterion("upload_time1 <>", value, "uploadTime1");
            return (Criteria) this;
        }

        public Criteria andUploadTime1GreaterThan(Date value) {
            addCriterion("upload_time1 >", value, "uploadTime1");
            return (Criteria) this;
        }

        public Criteria andUploadTime1GreaterThanOrEqualTo(Date value) {
            addCriterion("upload_time1 >=", value, "uploadTime1");
            return (Criteria) this;
        }

        public Criteria andUploadTime1LessThan(Date value) {
            addCriterion("upload_time1 <", value, "uploadTime1");
            return (Criteria) this;
        }

        public Criteria andUploadTime1LessThanOrEqualTo(Date value) {
            addCriterion("upload_time1 <=", value, "uploadTime1");
            return (Criteria) this;
        }

        public Criteria andUploadTime1In(List<Date> values) {
            addCriterion("upload_time1 in", values, "uploadTime1");
            return (Criteria) this;
        }

        public Criteria andUploadTime1NotIn(List<Date> values) {
            addCriterion("upload_time1 not in", values, "uploadTime1");
            return (Criteria) this;
        }

        public Criteria andUploadTime1Between(Date value1, Date value2) {
            addCriterion("upload_time1 between", value1, value2, "uploadTime1");
            return (Criteria) this;
        }

        public Criteria andUploadTime1NotBetween(Date value1, Date value2) {
            addCriterion("upload_time1 not between", value1, value2, "uploadTime1");
            return (Criteria) this;
        }

        public Criteria andUploadTime2IsNull() {
            addCriterion("upload_time2 is null");
            return (Criteria) this;
        }

        public Criteria andUploadTime2IsNotNull() {
            addCriterion("upload_time2 is not null");
            return (Criteria) this;
        }

        public Criteria andUploadTime2EqualTo(Date value) {
            addCriterion("upload_time2 =", value, "uploadTime2");
            return (Criteria) this;
        }

        public Criteria andUploadTime2NotEqualTo(Date value) {
            addCriterion("upload_time2 <>", value, "uploadTime2");
            return (Criteria) this;
        }

        public Criteria andUploadTime2GreaterThan(Date value) {
            addCriterion("upload_time2 >", value, "uploadTime2");
            return (Criteria) this;
        }

        public Criteria andUploadTime2GreaterThanOrEqualTo(Date value) {
            addCriterion("upload_time2 >=", value, "uploadTime2");
            return (Criteria) this;
        }

        public Criteria andUploadTime2LessThan(Date value) {
            addCriterion("upload_time2 <", value, "uploadTime2");
            return (Criteria) this;
        }

        public Criteria andUploadTime2LessThanOrEqualTo(Date value) {
            addCriterion("upload_time2 <=", value, "uploadTime2");
            return (Criteria) this;
        }

        public Criteria andUploadTime2In(List<Date> values) {
            addCriterion("upload_time2 in", values, "uploadTime2");
            return (Criteria) this;
        }

        public Criteria andUploadTime2NotIn(List<Date> values) {
            addCriterion("upload_time2 not in", values, "uploadTime2");
            return (Criteria) this;
        }

        public Criteria andUploadTime2Between(Date value1, Date value2) {
            addCriterion("upload_time2 between", value1, value2, "uploadTime2");
            return (Criteria) this;
        }

        public Criteria andUploadTime2NotBetween(Date value1, Date value2) {
            addCriterion("upload_time2 not between", value1, value2, "uploadTime2");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andBuildIdIsNull() {
            addCriterion("build_id is null");
            return (Criteria) this;
        }

        public Criteria andBuildIdIsNotNull() {
            addCriterion("build_id is not null");
            return (Criteria) this;
        }

        public Criteria andBuildIdEqualTo(String value) {
            addCriterion("build_id =", value, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdNotEqualTo(String value) {
            addCriterion("build_id <>", value, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdGreaterThan(String value) {
            addCriterion("build_id >", value, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdGreaterThanOrEqualTo(String value) {
            addCriterion("build_id >=", value, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdLessThan(String value) {
            addCriterion("build_id <", value, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdLessThanOrEqualTo(String value) {
            addCriterion("build_id <=", value, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdLike(String value) {
            addCriterion("build_id like", value, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdNotLike(String value) {
            addCriterion("build_id not like", value, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdIn(List<String> values) {
            addCriterion("build_id in", values, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdNotIn(List<String> values) {
            addCriterion("build_id not in", values, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdBetween(String value1, String value2) {
            addCriterion("build_id between", value1, value2, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdNotBetween(String value1, String value2) {
            addCriterion("build_id not between", value1, value2, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildModelIsNull() {
            addCriterion("build_model is null");
            return (Criteria) this;
        }

        public Criteria andBuildModelIsNotNull() {
            addCriterion("build_model is not null");
            return (Criteria) this;
        }

        public Criteria andBuildModelEqualTo(String value) {
            addCriterion("build_model =", value, "buildModel");
            return (Criteria) this;
        }

        public Criteria andBuildModelNotEqualTo(String value) {
            addCriterion("build_model <>", value, "buildModel");
            return (Criteria) this;
        }

        public Criteria andBuildModelGreaterThan(String value) {
            addCriterion("build_model >", value, "buildModel");
            return (Criteria) this;
        }

        public Criteria andBuildModelGreaterThanOrEqualTo(String value) {
            addCriterion("build_model >=", value, "buildModel");
            return (Criteria) this;
        }

        public Criteria andBuildModelLessThan(String value) {
            addCriterion("build_model <", value, "buildModel");
            return (Criteria) this;
        }

        public Criteria andBuildModelLessThanOrEqualTo(String value) {
            addCriterion("build_model <=", value, "buildModel");
            return (Criteria) this;
        }

        public Criteria andBuildModelLike(String value) {
            addCriterion("build_model like", value, "buildModel");
            return (Criteria) this;
        }

        public Criteria andBuildModelNotLike(String value) {
            addCriterion("build_model not like", value, "buildModel");
            return (Criteria) this;
        }

        public Criteria andBuildModelIn(List<String> values) {
            addCriterion("build_model in", values, "buildModel");
            return (Criteria) this;
        }

        public Criteria andBuildModelNotIn(List<String> values) {
            addCriterion("build_model not in", values, "buildModel");
            return (Criteria) this;
        }

        public Criteria andBuildModelBetween(String value1, String value2) {
            addCriterion("build_model between", value1, value2, "buildModel");
            return (Criteria) this;
        }

        public Criteria andBuildModelNotBetween(String value1, String value2) {
            addCriterion("build_model not between", value1, value2, "buildModel");
            return (Criteria) this;
        }

        public Criteria andLanguageCountryIsNull() {
            addCriterion("language_country is null");
            return (Criteria) this;
        }

        public Criteria andLanguageCountryIsNotNull() {
            addCriterion("language_country is not null");
            return (Criteria) this;
        }

        public Criteria andLanguageCountryEqualTo(String value) {
            addCriterion("language_country =", value, "languageCountry");
            return (Criteria) this;
        }

        public Criteria andLanguageCountryNotEqualTo(String value) {
            addCriterion("language_country <>", value, "languageCountry");
            return (Criteria) this;
        }

        public Criteria andLanguageCountryGreaterThan(String value) {
            addCriterion("language_country >", value, "languageCountry");
            return (Criteria) this;
        }

        public Criteria andLanguageCountryGreaterThanOrEqualTo(String value) {
            addCriterion("language_country >=", value, "languageCountry");
            return (Criteria) this;
        }

        public Criteria andLanguageCountryLessThan(String value) {
            addCriterion("language_country <", value, "languageCountry");
            return (Criteria) this;
        }

        public Criteria andLanguageCountryLessThanOrEqualTo(String value) {
            addCriterion("language_country <=", value, "languageCountry");
            return (Criteria) this;
        }

        public Criteria andLanguageCountryLike(String value) {
            addCriterion("language_country like", value, "languageCountry");
            return (Criteria) this;
        }

        public Criteria andLanguageCountryNotLike(String value) {
            addCriterion("language_country not like", value, "languageCountry");
            return (Criteria) this;
        }

        public Criteria andLanguageCountryIn(List<String> values) {
            addCriterion("language_country in", values, "languageCountry");
            return (Criteria) this;
        }

        public Criteria andLanguageCountryNotIn(List<String> values) {
            addCriterion("language_country not in", values, "languageCountry");
            return (Criteria) this;
        }

        public Criteria andLanguageCountryBetween(String value1, String value2) {
            addCriterion("language_country between", value1, value2, "languageCountry");
            return (Criteria) this;
        }

        public Criteria andLanguageCountryNotBetween(String value1, String value2) {
            addCriterion("language_country not between", value1, value2, "languageCountry");
            return (Criteria) this;
        }

        public Criteria andRdidAdvertisingidIsNull() {
            addCriterion("rdid_advertisingid is null");
            return (Criteria) this;
        }

        public Criteria andRdidAdvertisingidIsNotNull() {
            addCriterion("rdid_advertisingid is not null");
            return (Criteria) this;
        }

        public Criteria andRdidAdvertisingidEqualTo(String value) {
            addCriterion("rdid_advertisingid =", value, "rdidAdvertisingid");
            return (Criteria) this;
        }

        public Criteria andRdidAdvertisingidNotEqualTo(String value) {
            addCriterion("rdid_advertisingid <>", value, "rdidAdvertisingid");
            return (Criteria) this;
        }

        public Criteria andRdidAdvertisingidGreaterThan(String value) {
            addCriterion("rdid_advertisingid >", value, "rdidAdvertisingid");
            return (Criteria) this;
        }

        public Criteria andRdidAdvertisingidGreaterThanOrEqualTo(String value) {
            addCriterion("rdid_advertisingid >=", value, "rdidAdvertisingid");
            return (Criteria) this;
        }

        public Criteria andRdidAdvertisingidLessThan(String value) {
            addCriterion("rdid_advertisingid <", value, "rdidAdvertisingid");
            return (Criteria) this;
        }

        public Criteria andRdidAdvertisingidLessThanOrEqualTo(String value) {
            addCriterion("rdid_advertisingid <=", value, "rdidAdvertisingid");
            return (Criteria) this;
        }

        public Criteria andRdidAdvertisingidLike(String value) {
            addCriterion("rdid_advertisingid like", value, "rdidAdvertisingid");
            return (Criteria) this;
        }

        public Criteria andRdidAdvertisingidNotLike(String value) {
            addCriterion("rdid_advertisingid not like", value, "rdidAdvertisingid");
            return (Criteria) this;
        }

        public Criteria andRdidAdvertisingidIn(List<String> values) {
            addCriterion("rdid_advertisingid in", values, "rdidAdvertisingid");
            return (Criteria) this;
        }

        public Criteria andRdidAdvertisingidNotIn(List<String> values) {
            addCriterion("rdid_advertisingid not in", values, "rdidAdvertisingid");
            return (Criteria) this;
        }

        public Criteria andRdidAdvertisingidBetween(String value1, String value2) {
            addCriterion("rdid_advertisingid between", value1, value2, "rdidAdvertisingid");
            return (Criteria) this;
        }

        public Criteria andRdidAdvertisingidNotBetween(String value1, String value2) {
            addCriterion("rdid_advertisingid not between", value1, value2, "rdidAdvertisingid");
            return (Criteria) this;
        }

        public Criteria andEventTimestampIsNull() {
            addCriterion("event_timestamp is null");
            return (Criteria) this;
        }

        public Criteria andEventTimestampIsNotNull() {
            addCriterion("event_timestamp is not null");
            return (Criteria) this;
        }

        public Criteria andEventTimestampEqualTo(Long value) {
            addCriterion("event_timestamp =", value, "eventTimestamp");
            return (Criteria) this;
        }

        public Criteria andEventTimestampNotEqualTo(Long value) {
            addCriterion("event_timestamp <>", value, "eventTimestamp");
            return (Criteria) this;
        }

        public Criteria andEventTimestampGreaterThan(Long value) {
            addCriterion("event_timestamp >", value, "eventTimestamp");
            return (Criteria) this;
        }

        public Criteria andEventTimestampGreaterThanOrEqualTo(Long value) {
            addCriterion("event_timestamp >=", value, "eventTimestamp");
            return (Criteria) this;
        }

        public Criteria andEventTimestampLessThan(Long value) {
            addCriterion("event_timestamp <", value, "eventTimestamp");
            return (Criteria) this;
        }

        public Criteria andEventTimestampLessThanOrEqualTo(Long value) {
            addCriterion("event_timestamp <=", value, "eventTimestamp");
            return (Criteria) this;
        }

        public Criteria andEventTimestampIn(List<Long> values) {
            addCriterion("event_timestamp in", values, "eventTimestamp");
            return (Criteria) this;
        }

        public Criteria andEventTimestampNotIn(List<Long> values) {
            addCriterion("event_timestamp not in", values, "eventTimestamp");
            return (Criteria) this;
        }

        public Criteria andEventTimestampBetween(Long value1, Long value2) {
            addCriterion("event_timestamp between", value1, value2, "eventTimestamp");
            return (Criteria) this;
        }

        public Criteria andEventTimestampNotBetween(Long value1, Long value2) {
            addCriterion("event_timestamp not between", value1, value2, "eventTimestamp");
            return (Criteria) this;
        }

        public Criteria andAgencyIsNull() {
            addCriterion("agency is null");
            return (Criteria) this;
        }

        public Criteria andAgencyIsNotNull() {
            addCriterion("agency is not null");
            return (Criteria) this;
        }

        public Criteria andAgencyEqualTo(String value) {
            addCriterion("agency =", value, "agency");
            return (Criteria) this;
        }

        public Criteria andAgencyNotEqualTo(String value) {
            addCriterion("agency <>", value, "agency");
            return (Criteria) this;
        }

        public Criteria andAgencyGreaterThan(String value) {
            addCriterion("agency >", value, "agency");
            return (Criteria) this;
        }

        public Criteria andAgencyGreaterThanOrEqualTo(String value) {
            addCriterion("agency >=", value, "agency");
            return (Criteria) this;
        }

        public Criteria andAgencyLessThan(String value) {
            addCriterion("agency <", value, "agency");
            return (Criteria) this;
        }

        public Criteria andAgencyLessThanOrEqualTo(String value) {
            addCriterion("agency <=", value, "agency");
            return (Criteria) this;
        }

        public Criteria andAgencyLike(String value) {
            addCriterion("agency like", value, "agency");
            return (Criteria) this;
        }

        public Criteria andAgencyNotLike(String value) {
            addCriterion("agency not like", value, "agency");
            return (Criteria) this;
        }

        public Criteria andAgencyIn(List<String> values) {
            addCriterion("agency in", values, "agency");
            return (Criteria) this;
        }

        public Criteria andAgencyNotIn(List<String> values) {
            addCriterion("agency not in", values, "agency");
            return (Criteria) this;
        }

        public Criteria andAgencyBetween(String value1, String value2) {
            addCriterion("agency between", value1, value2, "agency");
            return (Criteria) this;
        }

        public Criteria andAgencyNotBetween(String value1, String value2) {
            addCriterion("agency not between", value1, value2, "agency");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}