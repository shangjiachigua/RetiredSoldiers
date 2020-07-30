package com.caifu.sys.sysController;

import com.caifu.util.Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Calendar;

/**
 * @Auther: Lyf
 * @Date: 2020/7/20 15:26
 * @Description:
 */

@Controller
@RequestMapping("/ueditor")
@PropertySource("classpath:definition.properties")
public class FileController {

    @Value("${file.upload.path}")
    private String fileUploadPath;
    @Value("${file.upload.result.path}")
    private String fileUploadResultPath;

    @RequestMapping(value = "/file")
    @ResponseBody
    public String file(HttpServletRequest request) {
        String s = "{\n" +
                "            \"imageActionName\": \"uploadimage\",\n" +
                "                \"imageFieldName\": \"file\", \n" +
                "                \"imageMaxSize\": 2048000, \n" +
                "                \"imageAllowFiles\": [\".png\", \".jpg\", \".jpeg\", \".gif\", \".bmp\"], \n" +
                "                \"imageCompressEnable\": true, \n" +
                "                \"imageCompressBorder\": 1600, \n" +
                "                \"imageInsertAlign\": \"none\", \n" +
                "                \"imageUrlPrefix\": \"\",\n" +
                "                \"imagePathFormat\": \"/ueditor/jsp/upload/image/{yyyy}{mm}{dd}/{time}{rand:6}\" }";
        return s;
    }

    @RequestMapping(value = "/imgUpdate")
    @ResponseBody
    public String imgUpdate(MultipartFile file, HttpServletRequest request) throws FileNotFoundException {
        if (file.isEmpty()) {
            return "error";
        }
        // 获取文件名
        String fileName = file.getOriginalFilename();
        // 获取文件的后缀名
        //String suffixName = fileName.substring(fileName.lastIndexOf("."));
        // 这里我使用随机字符串来重新命名图片
        //fileName = Calendar.getInstance().getTimeInMillis() + suffixName;
        String newFileName = Util.getNewFileName(fileName);
        String date = Util.dateToString(null,"yyyyMMdd");
        String newPath = fileUploadPath+date+"/ceshi/"+newFileName;
        String resultPath = fileUploadResultPath+date+"/ceshi/"+newFileName;


        //String realPath = request.getSession().getServletContext().getRealPath("images");

        //String path = "D:\\images\\" + fileName;//此处保存在本地了，你也可以保存在图片服务器，或者realPath做临时文件
        File dest = new File(newPath);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            String config = "{\"state\": \"SUCCESS\"," +
                    "\"url\": \"" + resultPath + "\"," +
                    "\"title\": \"" + fileName + "\"," +
                    "\"original\": \"" + fileName + "\"}";
            return config;
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "error";
    }


    /**
     * 通过url请求返回图像的字节流
     *
     */
    @RequestMapping("/images/{fileName}")
    public void getIcon(@PathVariable("fileName") String fileName, HttpServletRequest request, HttpServletResponse response) throws IOException {

        if (StringUtils.isEmpty(fileName)) {
            fileName = "";
        }
        //String path = "D:\\images\\" + fileName;
        String path = fileName;


        File file = new File(path);
        //判断文件是否存在如果不存在就返回默认图标
        if (!(file.exists() && file.canRead())) {
            file = new File(path);
        }

        FileInputStream inputStream = new FileInputStream(file);
        byte[] data = new byte[(int) file.length()];
        int length = inputStream.read(data);
        inputStream.close();
        response.setContentType("image/png");
        OutputStream stream = response.getOutputStream();
        stream.write(data);
        stream.flush();
        stream.close();
    }

    @RequestMapping(value = "/uploadContent.action")
    @ResponseBody
    public void uploadContent(HttpServletRequest request) {
        String content = request.getParameter("myContent");
        System.out.println(content);
        return;
    }
}
