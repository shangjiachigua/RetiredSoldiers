package com.caifu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.caifu.pojo.JxBigscreenExhibition;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 军休大屏展示  服务类
 * </p>
 *
 * @author Tianwenwen
 * @since 2020-07-28
 */
public interface JxBigscreenExhibitionService extends IService<JxBigscreenExhibition> {

    /**
     * 功能描述: 获取大屏展示数据列表
     *
     * @param: []
     * @return: java.util.List<com.caifu.pojo.JxBigscreenExhibition>
     * @auther: tian
     * @date: 2020/7/28 13:20
     */
    IPage<JxBigscreenExhibition> getBigscreenList(String type, String currentPage, String pageSize);

    /**
     * 功能描述: 上传大屏展示图片
     *
     * @param: [file, type]
     * @return: void
     * @auther: tian
     * @date: 2020/7/28 13:52
     */
    void uploadImage(MultipartFile file, String type);

    /**
     * 功能描述: 根据id删除展示数据
     *
     * @param: [id]
     * @return: void
     * @auther: tian
     * @date: 2020/7/28 14:38
     */
    void deleteById(String id);

    /**
     *
     * 功能描述: 取消团片展示或不展示
     *
     * @param: [id, flag]
     * @return: void
     * @auther: tian
     * @date: 2020/7/28 14:48
     */
    void showOrNotShow(String id, String flag);
}
