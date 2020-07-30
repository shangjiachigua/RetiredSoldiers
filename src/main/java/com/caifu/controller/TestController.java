package com.caifu.controller;

import com.caifu.util.Util;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @Auther: Lyf
 * @Date: 2020/7/20 11:28
 * @Description:
 */
@Controller
@RequestMapping("/test")
@PropertySource("classpath:definition.properties")
public class TestController {

    @Value("${file.upload.path}")
    private String fileUploadPath;
    @Value("${file.upload.result.path}")
    private String fileUploadResultPath;

    @RequestMapping("/index")
    public String index(){
        return "view/test/index";
    }

    @RequestMapping("/upload")
    @ResponseBody
    public void test() {
        try {
            FileItem fileItem = createFileItem("C:\\Users\\Lyf\\Desktop\\图片\\xiaotuzi.jpg");
            MultipartFile mfile = new CommonsMultipartFile(fileItem);

            String fileName = mfile.getOriginalFilename();
            String newFileName = Util.getNewFileName(fileName);

            String newPath = fileUploadPath+"/20200720/ceshi/"+newFileName;
            String resultPath = fileUploadResultPath+"20200720/ceshi/"+newFileName;

            File newFile = new File(newPath);
            mfile.transferTo(newFile);

            System.out.println(resultPath);
            File resultFile = new File(resultPath);
            if(resultFile.exists()){
                System.out.println("ok");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private static FileItem createFileItem(String filePath)
    {
        FileItemFactory factory = new DiskFileItemFactory(16, null);
        String textFieldName = "textField";
        int num = filePath.lastIndexOf(".");
        String extFile = filePath.substring(num);
        FileItem item = factory.createItem(textFieldName, "text/plain", true,
                "MyFileName" + extFile);
        File newfile = new File(filePath);
        int bytesRead = 0;
        byte[] buffer = new byte[8192];
        try
        {
            FileInputStream fis = new FileInputStream(newfile);
            OutputStream os = item.getOutputStream();
            while ((bytesRead = fis.read(buffer, 0, 8192))
                    != -1)
            {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            fis.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return item;
    }
}
