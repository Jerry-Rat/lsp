package cn.nt.video.controller;

import cn.nt.video.entity.Video;
import cn.nt.video.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Tomorrow
 */
@RestController
public class VideoController {

    @Autowired
    private VideoService videoService;

    @RequestMapping("/getVideo")
    public Video getVideo(Integer id) {
        return videoService.selectByPrimaryKey(id);
    }

    @RequestMapping("/getVideos")
    public List<Video> getVideos(@RequestParam("page") int page,
                                 @RequestParam("rows") int rows){
        return videoService.list4page(page,rows);
    }
}
