package cn.nt.video.service.impl;

import cn.nt.video.entity.Video;
import cn.nt.video.entity.VideoExample;
import cn.nt.video.mapper.VideoMapper;
import cn.nt.video.service.VideoService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    @Resource
    private VideoMapper videoMapper;

    @Override
    public long countByExample(VideoExample example) {
        return videoMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(VideoExample example) {
        return videoMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return videoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Video record) {
        return videoMapper.insert(record);
    }

    @Override
    public int insertSelective(Video record) {
        return videoMapper.insertSelective(record);
    }

    @Override
    public List<Video> selectByExample(VideoExample example) {
        return videoMapper.selectByExample(example);
    }

    @Override
    public Video selectByPrimaryKey(Integer id) {
        return videoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(Video record, VideoExample example) {
        return videoMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(Video record, VideoExample example) {
        return videoMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(Video record) {
        return videoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Video record) {
        return videoMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Video> list4page(Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        return videoMapper.list();
    }

}

