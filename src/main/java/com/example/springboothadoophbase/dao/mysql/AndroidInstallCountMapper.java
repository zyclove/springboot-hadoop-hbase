package com.example.springboothadoophbase.dao.mysql;

import com.example.springboothadoophbase.entity.AndroidInstallCount;
import com.example.springboothadoophbase.entity.AndroidInstallCountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AndroidInstallCountMapper {
    int countByExample(AndroidInstallCountExample example);

    int deleteByExample(AndroidInstallCountExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AndroidInstallCount record);

    int insertSelective(AndroidInstallCount record);

    List<AndroidInstallCount> selectByExample(AndroidInstallCountExample example);

    AndroidInstallCount selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AndroidInstallCount record, @Param("example") AndroidInstallCountExample example);

    int updateByExample(@Param("record") AndroidInstallCount record, @Param("example") AndroidInstallCountExample example);

    int updateByPrimaryKeySelective(AndroidInstallCount record);

    int updateByPrimaryKey(AndroidInstallCount record);


}