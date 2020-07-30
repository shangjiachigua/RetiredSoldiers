package com.caifu.controller;

import com.caifu.util.Util;
import net.sf.json.JSONObject;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author tianwenwen
 * @version 1.0.0
 * @ClassName ImageController.java
 * @createTime 2020年07月22日 09:25
 **/
@Controller
@RequestMapping("image")
@PropertySource("classpath:definition.properties")
public class ImageController {
    @Value("${file.upload.path}")
    private String fileUploadPath;
    @Value("${file.upload.result.path}")
    private String fileUploadResultPath;

    @RequestMapping("/upload")
    @ResponseBody
    public String upload(MultipartFile file) {
        JSONObject result = new JSONObject();
        try {
            String fileName = file.getOriginalFilename();
            System.out.println("fileName = " + fileName);
            String newFileName = Util.getNewFileName(fileName);

            String newPath = fileUploadPath + "/20200720/ceshi/" + newFileName;
            String resultPath = fileUploadResultPath + "20200720/ceshi/" + newFileName;

            File newFile = new File(newPath);
            if (!newFile.getParentFile().exists()) {
                newFile.mkdirs();
            }
            file.transferTo(newFile);

            System.out.println(resultPath);
            File resultFile = new File(resultPath);
            if (resultFile.exists()) {
                System.out.println("ok");
            }
            result.put("code", "0000");
            result.put("resultPath", resultPath);
            result.put("msg", "上传成功");
        } catch (Exception e) {
            result.put("code", "9999");
            result.put("msg", "网络异常");
            e.printStackTrace();
        }
        return result.toString();
    }

    private static FileItem createFileItem(String filePath) {
        FileItemFactory factory = new DiskFileItemFactory(16, null);
        String textFieldName = "textField";
        int num = filePath.lastIndexOf(".");
        String extFile = filePath.substring(num);
        FileItem item = factory.createItem(textFieldName, "text/plain", true,
                "MyFileName" + extFile);
        File newfile = new File(filePath);
        int bytesRead = 0;
        byte[] buffer = new byte[8192];
        try {
            FileInputStream fis = new FileInputStream(newfile);
            OutputStream os = item.getOutputStream();
            while ((bytesRead = fis.read(buffer, 0, 8192))
                    != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return item;
    }
}
