package com.william.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "videos", schema = "flix_william", catalog = "")
public class VideosEntity {
    private int id;
    private String title;
    private String videoEmbed;
    private String videotrailerEmbed;
    private String imgVideo;
    private String description;
    private Double imdbScore;
    private int accountId;
    private int categoryId;
    private int statusVideo;
    private Timestamp createtime;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "video_embed")
    public String getVideoEmbed() {
        return videoEmbed;
    }

    public void setVideoEmbed(String videoEmbed) {
        this.videoEmbed = videoEmbed;
    }

    @Basic
    @Column(name = "videotrailer_embed")
    public String getVideotrailerEmbed() {
        return videotrailerEmbed;
    }

    public void setVideotrailerEmbed(String videotrailerEmbed) {
        this.videotrailerEmbed = videotrailerEmbed;
    }

    @Basic
    @Column(name = "img_video")
    public String getImgVideo() {
        return imgVideo;
    }

    public void setImgVideo(String imgVideo) {
        this.imgVideo = imgVideo;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "imdb_score")
    public Double getImdbScore() {
        return imdbScore;
    }

    public void setImdbScore(Double imdbScore) {
        this.imdbScore = imdbScore;
    }

    @Basic
    @Column(name = "accountId")
    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    @Basic
    @Column(name = "categoryId")
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Basic
    @Column(name = "status_video")
    public int getStatusVideo() {
        return statusVideo;
    }

    public void setStatusVideo(int statusVideo) {
        this.statusVideo = statusVideo;
    }

    @Basic
    @Column(name = "createtime")
    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VideosEntity that = (VideosEntity) o;
        return id == that.id && accountId == that.accountId && categoryId == that.categoryId && statusVideo == that.statusVideo && Objects.equals(title, that.title) && Objects.equals(videoEmbed, that.videoEmbed) && Objects.equals(videotrailerEmbed, that.videotrailerEmbed) && Objects.equals(imgVideo, that.imgVideo) && Objects.equals(description, that.description) && Objects.equals(imdbScore, that.imdbScore) && Objects.equals(createtime, that.createtime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, videoEmbed, videotrailerEmbed, imgVideo, description, imdbScore, accountId, categoryId, statusVideo, createtime);
    }
}
