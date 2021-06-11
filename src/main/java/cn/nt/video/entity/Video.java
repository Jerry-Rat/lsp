package cn.nt.video.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * video
 */
@ApiModel(value = "cn-nt-video-entity-Video")
@Data
public class Video {
    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private Integer id;

    /**
     * title
     */
    @ApiModelProperty(value = "title")
    private String title;

    /**
     * url
     */
    @ApiModelProperty(value = "url")
    private String url;

    /**
     * img
     */
    @ApiModelProperty(value = "img")
    private String img;
}