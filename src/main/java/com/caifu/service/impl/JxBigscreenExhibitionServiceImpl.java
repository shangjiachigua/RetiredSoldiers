package com.caifu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.caifu.mapper.JxBigscreenExhibitionMapper;
import com.caifu.pojo.JxBigscreenExhibition;
import com.caifu.service.JxBigscreenExhibitionService;
import com.caifu.util.Util;
import com.caifu.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;

/**
 * <p>
 * 军休大屏展示  服务实现类
 * </p>
 *
 * @author Tianwenwen
 * @since 2020-07-28
 */
@Service
@PropertySource("classpath:definition.properties")
public class JxBigscreenExhibitionServiceImpl extends ServiceImpl<JxBigscreenExhibitionMapper, JxBigscreenExhibition> implements JxBigscreenExhibitionService {

    @Value("${file.upload.path}")
    private String fileUploadPath;
    @Value("${file.upload.result.path}")
    private String fileUploadResultPath;

    @Autowired
    private JxBigscreenExhibitionMapper jxBigscreenExhibitionMapper;

    @Override
    public IPage<JxBigscreenExhibition> getBigscreenList(String type, String currentPage, String pageSize) {
        QueryWrapper<JxBigscreenExhibition> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type", type).eq("status", "1");
        Page<JxBigscreenExhibition> page = new Page<>(Long.parseLong(currentPage), Long.parseLong(pageSize));
        return jxBigscreenExhibitionMapper.selectPage(page, queryWrapper);
    }

    @Override
    public void uploadImage(MultipartFile file, String type) {
        try {
            String fileName = file.getOriginalFilename();
            System.out.println("fileName = " + fileName);
            String newFileName = null;
            if (Utils.isNotNull(fileName)) {
                newFileName = Util.getNewFileName(fileName);
            }

            String newPath = fileUploadPath + "/20200727/ceshi/" + newFileName;
            String resultPath = fileUploadResultPath + "20200727/ceshi/" + newFileName;

            File newFile = new File(newPath);
            if (!newFile.getParentFile().exists()) {
                newFile.mkdirs();
            }
            file.transferTo(newFile);
            System.out.println(resultPath);
            //保存上传图片之后的url
            JxBigscreenExhibition jxBigscreenExhibition = new JxBigscreenExhibition();
            jxBigscreenExhibition.setCreateBy(1);
            jxBigscreenExhibition.setCreateTime(new Date());
            jxBigscreenExhibition.setImgUrl(resultPath);
            //是否展示(1.否  2.是）默认否 如果type==2 默认为是
            //荣誉展示页类型
            String honour = "2";
            //欢迎页类型
            String welcome = "1";
            if (welcome.equals(type)) {
                jxBigscreenExhibition.setIsExhibition("1");
            } else if (honour.equals(type)) {
                jxBigscreenExhibition.setIsExhibition("2");
            }
            jxBigscreenExhibition.setStatus("1");
            jxBigscreenExhibition.setType(type);
            jxBigscreenExhibition.setUpdateBy(1);
            jxBigscreenExhibition.setUpdateTime(new Date());
            jxBigscreenExhibitionMapper.insert(jxBigscreenExhibition);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(String id) {
        JxBigscreenExhibition jxBigscreenExhibition = new JxBigscreenExhibition();
        jxBigscreenExhibition.setId(Integer.parseInt(id));
        jxBigscreenExhibition.setStatus("9");
        jxBigscreenExhibitionMapper.updateById(jxBigscreenExhibition);
    }

    @Override
    public void showOrNotShow(String id, String flag) {
        JxBigscreenExhibition jxBigscreenExhibition = new JxBigscreenExhibition();
        jxBigscreenExhibition.setId(Integer.parseInt(id));
        jxBigscreenExhibition.setIsExhibition(flag);
        jxBigscreenExhibitionMapper.updateById(jxBigscreenExhibition);
    }
}
