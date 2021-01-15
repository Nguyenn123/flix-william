package com.william.controller.AdminController;

import com.william.entity.AccountEntity;
import com.william.entity.VideoForm;
import com.william.entity.VideosEntity;
import com.william.service.IVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

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
    public ModelAndView addNewVideo(HttpSession session) {
        ModelAndView modelAndView;
        Optional<AccountEntity> logged = (Optional<AccountEntity>) session.getAttribute("userLogged");

        if(logged == null){
            modelAndView = new ModelAndView("redirect:/login");
        } else {
            if(logged.get().getRole() == 10001){
                modelAndView = new ModelAndView("/backend/add-item");
                modelAndView.addObject("product", new VideoForm());
            }
            else {
                modelAndView = new ModelAndView("/backend/404");
            }
        }
        return modelAndView;
    }

    @RequestMapping("/catalog")
    public ModelAndView Video(HttpSession session) {
        ModelAndView modelAndView = null;
        Optional<AccountEntity> logged = (Optional<AccountEntity>) session.getAttribute("userLogged");
        if(logged == null){
            modelAndView = new ModelAndView("redirect:/login");
        } else {
            if(logged.get().getRole() == 10001){
                modelAndView = new ModelAndView("/backend/catalog");
            }
            else {
                modelAndView = new ModelAndView("/backend/404");
            }
        }
        return modelAndView;
    }

    @PostMapping("/create")
    public RedirectView createProduct(@ModelAttribute VideoForm videoForm) {
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
        product1.setCategoryId(videoForm.getCategoryId());
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


    @PostMapping("/edit")
    public RedirectView createProduct(@RequestParam int id,
                                      @ModelAttribute VideoForm videoForm) {

        Optional<VideosEntity> product2 = (Optional<VideosEntity>) videoService.findById(id);
        VideosEntity product1 = product2.get();
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
        if (imgVideo.equals("")) {
            product1.setImgVideo(product2.get().getImgVideo());
        } else {
            product1.setImgVideo(imgVideo);
        }

        if (fileVideo.equals("")) {
            product1.setVideoEmbed(product2.get().getVideoEmbed());
        } else {
            product1.setVideoEmbed(fileVideo);
        }

        if (fileVideoTrailer.equals("")) {
            product1.setVideotrailerEmbed(product2.get().getVideotrailerEmbed());
        } else {
            product1.setVideotrailerEmbed(fileVideoTrailer);
        }

        product1.setAccountId(videoForm.getAccountId());
        product1.setCategoryId(videoForm.getAccountId());
        product1.setDescription(videoForm.getDescription());
        product1.setTitle(videoForm.getTitle());
//        product1.setVideoEmbed(fileVideo);
        product1.setStatusVideo(videoForm.getStatusVideo());
//        product1.setVideotrailerEmbed(fileVideoTrailer);
        product1.setImdbScore(videoForm.getImdbScore());
        product1.setCreatetime(Timestamp.valueOf(LocalDateTime.now()));
        videoService.save(product1);
        return new RedirectView("");
    }
}
