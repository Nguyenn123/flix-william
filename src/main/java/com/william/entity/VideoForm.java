package com.william.entity;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class VideoForm {
    private String title;
    private MultipartFile videoEmbed;
    private MultipartFile videotrailerEmbed;
    private MultipartFile imgVideo;
    private String description;
    private Double imdbScore;
    private int accountId;
    private int categoryId;
    private int statusVideo;

    public VideoForm() {
    }

    public VideoForm(String title, MultipartFile videoEmbed, MultipartFile videotrailerEmbed, MultipartFile imgVideo, String description, Double imdbScore, int accountId, int categoryId, int statusVideo) {
        this.title = title;
        this.videoEmbed = videoEmbed;
        this.videotrailerEmbed = videotrailerEmbed;
        this.imgVideo = imgVideo;
        this.description = description;
        this.imdbScore = imdbScore;
        this.accountId = accountId;
        this.categoryId = categoryId;
        this.statusVideo = statusVideo;
    }

    public String getTitle() {
        return title;
    }

    public MultipartFile getVideoEmbed() {
        return videoEmbed;
    }

    public MultipartFile getVideotrailerEmbed() {
        return videotrailerEmbed;
    }

    public MultipartFile getImgVideo() {
        return imgVideo;
    }

    public String getDescription() {
        return description;
    }

    public Double getImdbScore() {
        return imdbScore;
    }

    public int getAccountId() {
        return accountId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public int getStatusVideo() {
        return statusVideo;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setVideoEmbed(MultipartFile videoEmbed) {
        this.videoEmbed = videoEmbed;
    }

    public void setVideotrailerEmbed(MultipartFile videotrailerEmbed) {
        this.videotrailerEmbed = videotrailerEmbed;
    }

    public void setImgVideo(MultipartFile imgVideo) {
        this.imgVideo = imgVideo;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImdbScore(Double imdbScore) {
        this.imdbScore = imdbScore;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setStatusVideo(int statusVideo) {
        this.statusVideo = statusVideo;
    }
}
