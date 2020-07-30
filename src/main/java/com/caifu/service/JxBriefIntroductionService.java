package com.caifu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.caifu.common.Result;
import com.caifu.pojo.JxBriefIntroduction;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Tianwenwen
 * @since 2020-07-21
 */
public interface JxBriefIntroductionService extends IService<JxBriefIntroduction> {

    /**
     * 功能描述:添加军休中心介绍
     *
     * @param: []
     * @return: void
     * @auther: tian
     * @date: 2020/7/21 13:36
     */
    void add(String content);

    /**
     * 功能描述: 获取军休中心介绍
     *
     * @param: []
     * @return: com.caifu.common.Result<com.caifu.pojo.JxBriefIntroduction>
     * @auther: tian
     * @date: 2020/7/21 16:08
     */
    Result<JxBriefIntroduction> getIntroduction();

    /**
     * 功能描述: 根基id删除军休中心介绍
     *
     * @param: [id]
     * @return: void
     * @auther: tian
     * @date: 2020/7/21 16:08
     */
    void deleteById(String id);

    /**
     * 功能描述: 根据id获取军休中心介绍
     *
     * @param: [id]
     * @return: com.caifu.common.Result<com.caifu.pojo.JxBriefIntroduction>
     * @auther: tian
     * @date: 2020/7/21 17:44
     */
    Result<JxBriefIntroduction> getIntroductionById(String id);

    /**
     * 功能描述: 根据id修改军休中心介绍
     *
     * @param: [id]
     * @return: void
     * @auther: tian
     * @date: 2020/7/21 17:43
     */
    void updateById(String id,String content);
}
