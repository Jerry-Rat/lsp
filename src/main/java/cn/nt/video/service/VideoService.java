package cn.nt.video.service;

import cn.nt.video.entity.Video;
import cn.nt.video.entity.VideoExample;

import java.util.List;

public interface VideoService {


    long countByExample(VideoExample example);

    int deleteByExample(VideoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Video record);

    int insertSelective(Video record);

    List<Video> selectByExample(VideoExample example);

    Video selectByPrimaryKey(Integer id);

    int updateByExampleSelective(Video record, VideoExample example);

    int updateByExample(Video record, VideoExample example);

    int updateByPrimaryKeySelective(Video record);

    int updateByPrimaryKey(Video record);

    List<Video> list4page(Integer page, Integer rows);
}

