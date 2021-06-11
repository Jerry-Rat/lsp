package cn.nt.video.spider;

import cn.nt.video.entity.Video;
import cn.nt.video.task.MySQLPipeline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author Tomorrow
 * @url http://www.xiaobi057.com/
 */
@Component
public class VideoSpider implements PageProcessor {

    @Autowired
    private MySQLPipeline mySQLPipeline;

    private String url = "http://www.xiaobi057.com/";

    private Site site = Site.me()
            //设置重试次数
            .setRetryTimes(3)
            //设置超时时间
            .setTimeOut(10 * 1000)
            //设置重试时间间隔
            .setRetrySleepTime(3000)
            //设置编码
            .setCharset("UTF-8");

    /**
     * 解析页面
     */
    @Override
    public void process(Page page) {
        Html html = page.getHtml();
        //获取视频详情的URL
        List<Selectable> list = html.xpath("//div[@id='list_videos_most_recent_videos_items']/div[@class='item']").nodes();

        if(list.size() == 0){
            //如果为空表示是详情页
            Video video = new Video();
            video.setTitle(html.xpath("//div[@class='info']/div[@class='item'][2]/em/text()").get().toString());
            video.setUrl(html.xpath("//div[@class='info']/div[@class='item'][5]/a").links().get().toString());
            video.setImg(html.xpath("//div[@class='player']").css("img", "src").get().toString());
            page.putField("video",video);
        }else {
            //如果不为空表示是列表页,放到队列中
            for (Selectable selectable : list) {
                String videoInfoList =  selectable.links().toString();
                //把获取到的URL地址放到任务队列中
                page.addTargetRequest(videoInfoList);
            }
            ////获取下一页的URL
            //String nextURL = page.getHtml().xpath("//li[@class='next']/a").links().get().toString();
            ////把获取到的URL地址放到任务队列中
            //page.addTargetRequest(nextURL);
        }
    }

    @Override
    public Site getSite() {
        return site;
    }

    //启动时执行一次
    @PostConstruct
    //每个月最后一天02:00执行
    @Scheduled(cron = "0 0 2 L * ?")
    public void getVideo() {
        Spider.create(new VideoSpider())
                .addUrl(url)
                .addPipeline(this.mySQLPipeline)
                .thread(5)
                .run();
    }
}
