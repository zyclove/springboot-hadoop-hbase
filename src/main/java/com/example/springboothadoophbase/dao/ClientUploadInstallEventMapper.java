package com.example.springboothadoophbase.dao;

import com.example.springboothadoophbase.entity.ClientUploadInstallEvent;
import com.example.springboothadoophbase.entity.ClientUploadInstallEventExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ClientUploadInstallEventMapper {
    int countByExample(ClientUploadInstallEventExample example);

    int deleteByExample(ClientUploadInstallEventExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ClientUploadInstallEvent record);

    int insertSelective(ClientUploadInstallEvent record);

    List<ClientUploadInstallEvent> selectByExample(ClientUploadInstallEventExample example);

    ClientUploadInstallEvent selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ClientUploadInstallEvent record, @Param("example") ClientUploadInstallEventExample example);

    int updateByExample(@Param("record") ClientUploadInstallEvent record, @Param("example") ClientUploadInstallEventExample example);

    int updateByPrimaryKeySelective(ClientUploadInstallEvent record);

    int updateByPrimaryKey(ClientUploadInstallEvent record);
}