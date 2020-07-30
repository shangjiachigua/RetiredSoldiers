package com.caifu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.caifu.dto.JxJournalismDto;
import com.caifu.pojo.JxJournalism;
import com.github.pagehelper.PageInfo;

/**
 * <p>
 * 新闻信息表 服务类
 * </p>
 *
 * @author Tianwenwen
 * @since 2020-07-22
 */
public interface JxJournalismService extends IService<JxJournalism> {

    /**
     * 功能描述:获取新闻列表
     *
     * @param: []
     * @return: com.github.pagehelper.PageInfo<com.caifu.dto.JxJournalismDto>
     * @auther: tian
     * @date: 2020/7/22 14:40
     */
    PageInfo<JxJournalismDto> getNewsList(String title, String isTop, String currentPage, String pageSize);

    /**
     * 功能描述:根据id删除新闻
     *
     * @param: [id]
     * @return: void
     * @auther: tian
     * @date: 2020/7/22 15:12
     */
    void deleteById(String id);

    /**
     * 功能描述:根据id查询新闻
     *
     * @param: [id]
     * @return: com.caifu.pojo.JxPolicy
     * @auther: tian
     * @date: 2020/7/22 15:13
     */

    JxJournalism getPolicyById(String id);

    /**
     * 功能描述: 查询推荐新闻总记录
     *
     * @param: []
     * @return: java.lang.Integer
     * @auther: tian
     * @date: 2020/7/22 16:13
     */
    Integer countGrass();

    /**
     * 功能描述: 取消或推荐
     *
     * @param: [id]
     * @return: void
     * @auther: tian
     * @date: 2020/7/22 16:24
     */
    void grassOrCancel(String id, String isTop);

    void updateById(Integer id, String briefIntroduction, String content, String imgUrl, String title);

    void add(String briefIntroduction, String content, String imgUrl, String title);
}
