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

//�ļ��ϴ�demo
@Controller
@RequestMapping("file")
public class fileController {
	
	@ResponseBody
	@RequestMapping("index")
	public String file(@RequestParam MultipartFile[] items_pic) throws  IOException{
		String result="���";
		// �����ϴ��ĵ���ͼƬ
        // ԭʼ����
		if(items_pic.length<0)
			return "δ�ϴ�ͼƬ";
        String originalFileName = items_pic[0].getOriginalFilename();
        // �ϴ�ͼƬ
        if (items_pic != null && originalFileName != null && originalFileName.length() > 0) {
            // �洢ͼƬ������·��
            String pic_path = "E:\\";
            // �µ�ͼƬ����
            String newFileName = "img"+ originalFileName.substring(originalFileName.lastIndexOf("."));
            // ��ͼƬ
            File newFile = new File(pic_path + newFileName);
            // ���ڴ��е�����д�����
            items_pic[0].transferTo(newFile);
        } else {
        	result="δѡ��ͼƬ";
        }
        
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        if(!file.isEmpty()) {
            //��ȡ�ļ�����
            String contentType = file.getContentType();
            if(!contentType.equals("")) {
                //���Զ��ļ����ͽ��м��
            }
            //��ȡinput���name����
            String name = file.getName();
            //��ȡ�ļ���������չ��
            String originFileName = file.getOriginalFilename();
            //��ȡ�ļ���չ��
            String extension = originFileName.substring(originFileName.lastIndexOf("."));
            System.out.println(extension);
            //��ȡ�ļ���С����λ�ֽ�
            long site = file.getSize();
            if(site > 1000000) {
                //���Զ��ļ���С���м��
            }
            String UPLOAD_DIR = "E:\\";
            //�����ļ��ϴ�����ļ�����·��������ȡϵͳʱ������ļ�����Ϊ�ļ���
            //���Ƽ���ôд������ֻ�Ǿ����ӣ���ôд���в�������
            //Ӧ�ò���һ�����㷨���ɶ�һ�޶��ĵ��ļ���
            String fileName = UPLOAD_DIR + "img" + extension;
            try {
                file.transferTo(new File(fileName));
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
        return "ִ�����";
	}
        
}
