package com.caifu.sys.sysController;

import com.caifu.util.UEditorUtil;
import com.caifu.util.Util;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * @Auther: Lyf
 * @Date: 2020/7/20 14:57
 * @Description:
 */
@Controller
@RequestMapping("/ueditor")
@PropertySource("classpath:definition.properties")
public class MyUeditorController {

    @Value("${file.upload.path}")
    private String fileUploadPath;
    @Value("${file.upload.result.path}")
    private String fileUploadResultPath;

    @RequestMapping("/fileUpload")
    @ResponseBody
    public Object fileUpload(@RequestParam(name = "action", required = false) String action, @RequestParam(name = "upfile", required = false) MultipartFile upfile, HttpServletRequest request) {
        JSONObject object = new JSONObject();
        if (action != null && action.equals("config")) {//获取配置文件
            return JSONObject.fromObject(UEditorUtil.UEDITOR_CONFIG);
        } else if (action != null && action.equals("fileUpload")) {//直接自定义上传：oss
            if (upfile != null) {
                //{state：”数据状态信息”，url：”图片回显路径”，title：”文件title”，original：”文件名称”}
                try {
                    String fileName = upfile.getOriginalFilename();
                    String newFileName = Util.getNewFileName(fileName);

                    String date = Util.dateToString(null,"yyyyMMdd");
                    String newPath = fileUploadPath+date+"/ceshi/"+newFileName;
                    String resultPath = fileUploadResultPath+date+"/ceshi/"+newFileName;

                    File newFile = new File(newPath);
                    upfile.transferTo(newFile);

                    JSONObject obj = new JSONObject();
                    obj.put("state",200);
                    obj.put("url",resultPath);
                    obj.put("title",fileName);
                    obj.put("original",fileName);
                    return obj;
                } catch (Exception e) {
                    e.printStackTrace();
                    object.put("state", "err");
                    return object;
                }
            } else {
                object.put("state", "文件为空");
                return object;
            }
        } else {
            object.put("state", "不支持该操作");
            return object;
        }
    }

}
