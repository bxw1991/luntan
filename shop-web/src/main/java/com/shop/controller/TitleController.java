//package com.shop.controller;
//
//import com.shop.common.utils.WrapMapper;
//import com.shop.common.utils.Wrapper;
//import com.shop.domain.Title;
//import com.shop.dto.TitleDto;
//import com.shop.mapper.TitleMapper;
//import com.sun.org.apache.regexp.internal.RE;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.servlet.http.HttpServletRequest;
//import java.io.File;
//import java.io.IOException;
//
//@RestController
//@RequestMapping("/title")
//@Slf4j
//public class TitleController {
//    @Autowired
//    private TitleMapper titleMapper;
//
//    @PostMapping("/publish")
//    public Wrapper publishTitle(TitleDto titleDto, HttpServletRequest request) {
//        Title title = new Title();
//        BeanUtils.copyProperties(titleDto,title);
//        titleMapper.insert(title);
//        return WrapMapper.ok();
//    }
//
//    @PostMapping("/uploadImage")
//    public Wrapper uploadImage(HttpServletRequest request, @RequestParam(value = "file")MultipartFile multipartFile) throws IOException {
//        String realPath = request.getSession().getServletContext().getRealPath("/upload/");
//        log.info(realPath);
//        if (multipartFile != null){
//            String originalFilename = multipartFile.getOriginalFilename();
//            int i = originalFilename.lastIndexOf(".");
//            String type = StringUtils.substring(originalFilename, i+1);
//            if (StringUtils.equalsIgnoreCase(type,"jpg") || StringUtils.equalsIgnoreCase(type,"jpeg") ||
//                StringUtils.equalsIgnoreCase(type,"png") || StringUtils.equalsIgnoreCase(type,"png")){
//                String path = realPath +  String.valueOf(System.currentTimeMillis()) + originalFilename;
//                File file = new File(path);
//                if (!file.getParentFile().exists()) {
//                    file.getParentFile().mkdirs();
//                }
//                multipartFile.transferTo(file);
//                return WrapMapper.ok(path);
//            }
//            return WrapMapper.error("文件格式错误");
//        }
//        return WrapMapper.error("上传图片信息为空");
//    }
//
//}
