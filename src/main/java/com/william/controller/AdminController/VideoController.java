package com.william.controller.AdminController;

import com.william.entity.VideoForm;
import com.william.entity.VideosEntity;
import com.william.service.IVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/admin")
public class VideoController {
    @Autowired
    private IVideoService videoService;

    @Value("${upload.path}")
    private String fileUploadImg;

    @Value("D:\\williamStream\\src\\main\\resources\\static\\database\\videos\\")
    private String fileUploadVideo;

    @Value("D:\\williamStream\\src\\main\\resources\\static\\database\\videosTrailer\\")
    private String fileUploadVideoTrailer;

    @RequestMapping("/new-video")
    public ModelAndView addNewVideo(){
        ModelAndView modelAndView = new ModelAndView("/backend/add-item");
        modelAndView.addObject("product", new VideoForm());
        return modelAndView;
    }

    @RequestMapping("/videos")
    public ModelAndView Video(){
        ModelAndView modelAndView = new ModelAndView("/backend/catalog");
        return modelAndView;
    }

    @PostMapping("/create")
    public RedirectView createProduct(@ModelAttribute VideoForm videoForm){
        VideosEntity product1 = new VideosEntity();
        MultipartFile Fileimg = videoForm.getImgVideo();
        MultipartFile FileVideo = videoForm.getVideoEmbed();
        MultipartFile FileVideoTrailer = videoForm.getVideotrailerEmbed();
        String imgVideo = Fileimg.getOriginalFilename();
        String fileVideo = FileVideo.getOriginalFilename();
        String fileVideoTrailer = FileVideoTrailer.getOriginalFilename();
        try {
            FileCopyUtils.copy(videoForm.getImgVideo().getBytes(), new File(this.fileUploadImg + imgVideo));
            FileCopyUtils.copy(videoForm.getVideoEmbed().getBytes(), new File(this.fileUploadVideo + fileVideo));
            FileCopyUtils.copy(videoForm.getVideotrailerEmbed().getBytes(), new File(this.fileUploadVideoTrailer + fileVideoTrailer));
        } catch (IOException e) {
            e.printStackTrace();
        }
        product1.setImgVideo(imgVideo);
        product1.setAccountId(videoForm.getAccountId());
        product1.setCategoryId(videoForm.getAccountId());
        product1.setDescription(videoForm.getDescription());
        product1.setTitle(videoForm.getTitle());
        product1.setVideoEmbed(fileVideo);
        product1.setStatusVideo(videoForm.getStatusVideo());
        product1.setVideotrailerEmbed(fileVideoTrailer);
        product1.setImdbScore(videoForm.getImdbScore());
        product1.setCreatetime(Timestamp.valueOf(LocalDateTime.now()));
        videoService.save(product1);
        return new RedirectView("");
    }
}
