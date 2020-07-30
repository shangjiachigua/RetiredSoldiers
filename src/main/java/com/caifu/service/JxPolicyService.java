package com.caifu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.caifu.pojo.JxPolicy;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Tianwenwen
 * @since 2020-07-21
 */
public interface JxPolicyService extends IService<JxPolicy> {

    /**
     * 功能描述: 获取政策列表
     *
     * @param: [title]
     * @return: com.caifu.common.Result<com.caifu.pojo.JxPolicy>
     * @auther: tian
     * @date: 2020/7/21 17:55
     */
    IPage<JxPolicy> getPolicyList(String title, String currentPage, String pageSize);

    /**
     * 功能描述: 添加政策
     *
     * @param: [briefIntroduction, content, imgUrl, title]
     * @return: void
     * @auther: tian
     * @date: 2020/7/22 10:50
     */
    void add(String briefIntroduction, String content, String imgUrl, String title);

    /**
     * 功能描述: 根据id更新政策
     *
     * @param: [id, briefIntroduction, content, imgUrl, title]
     * @return: void
     * @auther: tian
     * @date: 2020/7/22 10:51
     */
    void updateById(Integer id, String briefIntroduction, String content, String imgUrl, String title);

    /**
     *
     * 功能描述: 根据id删除政策
     *
     * @param: [id]
     * @return: void
     * @auther: tian
     * @date: 2020/7/22 10:55
     */
    void deleteById(String id);

    /**
     *
     * 功能描述: 根据id查询政策
     *
     * @param: [id]
     * @return: com.caifu.pojo.JxPolicy
     * @auther: tian
     * @date: 2020/7/22 11:27
     */
    JxPolicy getPolicyById(String id);
}
