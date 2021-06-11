package cn.nt.video.task;

import cn.nt.video.entity.Video;
import cn.nt.video.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

/**
 * @author Tomorrow
 */
@Component
public class MySQLPipeline implements Pipeline {
    @Autowired
    private VideoService videoService;

    @Override
    public void process(ResultItems resultItems, Task task) {
        //获取封装好的数据
        Video video = resultItems.get("video");
        if (video != null){
            videoService.insert(video);
        }
    }
}
