package com.raorao;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

//文件上传demo
@Controller
@RequestMapping("file")
public class fileController {
	
	@ResponseBody
	@RequestMapping("index")
	public String file(@RequestParam MultipartFile[] items_pic) throws  IOException{
		String result="完成";
		// 处理上传的单个图片
        // 原始名称
		if(items_pic.length<0)
			return "未上传图片";
        String originalFileName = items_pic[0].getOriginalFilename();
        // 上传图片
        if (items_pic != null && originalFileName != null && originalFileName.length() > 0) {
            // 存储图片的物理路径
            String pic_path = "E:\\";
            // 新的图片名称
            String newFileName = "img"+ originalFileName.substring(originalFileName.lastIndexOf("."));
            // 新图片
            File newFile = new File(pic_path + newFileName);
            // 将内存中的数据写入磁盘
            items_pic[0].transferTo(newFile);
        } else {
        	result="未选择图片";
        }
        
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        if(!file.isEmpty()) {
            //获取文件类型
            String contentType = file.getContentType();
            if(!contentType.equals("")) {
                //可以对文件类型进行检查
            }
            //获取input域的name属性
            String name = file.getName();
            //获取文件名，带扩展名
            String originFileName = file.getOriginalFilename();
            //获取文件扩展名
            String extension = originFileName.substring(originFileName.lastIndexOf("."));
            System.out.println(extension);
            //获取文件大小，单位字节
            long site = file.getSize();
            if(site > 1000000) {
                //可以对文件大小进行检查
            }
            String UPLOAD_DIR = "E:\\";
            //构造文件上传后的文件绝对路径，这里取系统时间戳＋文件名作为文件名
            //不推荐这么写，这里只是举例子，这么写会有并发问题
            //应该采用一定的算法生成独一无二的的文件名
            String fileName = UPLOAD_DIR + "img" + extension;
            try {
                file.transferTo(new File(fileName));
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
        return "执行完成";
	}
        
}
