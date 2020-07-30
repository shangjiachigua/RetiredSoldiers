package com.caifu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.caifu.dto.JxInformationDto;
import com.caifu.pojo.JxInformation;

/**
 * <p>
 * 军休资料 服务类
 * </p>
 *
 * @author Tianwenwen
 * @since 2020-07-27
 */
public interface JxInformationService extends IService<JxInformation> {

    /**
     * 功能描述: 获取资料列表
     *
     * @param: [currentPage, pageSize, title, type]
     * @return: java.util.List<com.caifu.pojo.JxInformation>
     * @auther: tian
     * @date: 2020/7/27 10:20
     */
    IPage<JxInformation> getInformation(String currentPage, String pageSize, String title, String type);

    /**
     * 功能描述: 根据id删除资料
     *
     * @param: [id]
     * @return: void
     * @auther: tian
     * @date: 2020/7/27 11:27
     */
    void deleteById(String id);

    /**
     * 功能描述: 根据id修改资料
     *
     * @param: [jxInformationDto]
     * @return: void
     * @auther: tian
     * @date: 2020/7/27 15:42
     */
    void updateInformationById(JxInformationDto jxInformationDto);

    /**
     * 功能描述: 添加资料
     *
     * @param: [jxInformationDto]
     * @return: void
     * @auther: tian
     * @date: 2020/7/27 15:42
     */
    void add(JxInformationDto jxInformationDto);

    /**
     * 功能描述: 根据id获取资料
     *
     * @param: [id]
     * @return: com.caifu.pojo.JxInformation
     * @auther: tian
     * @date: 2020/7/27 16:42
     */
    JxInformation getInformationById(String id);
}
