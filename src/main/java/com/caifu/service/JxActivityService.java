package com.caifu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.caifu.dto.JxActivityDto;
import com.caifu.pojo.JxActivity;
import com.caifu.pojo.JxActivityMenber;
import com.caifu.pojo.JxActivityRoom;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * <p>
 * 军休活动  服务类
 * </p>
 *
 * @author Tianwenwen
 * @since 2020-07-23
 */
public interface JxActivityService extends IService<JxActivity> {

    /**
     * 功能描述: 根据状态、名称获取活动列表
     *
     * @param: [title, currentPage, pageSize, status]
     * @return: com.github.pagehelper.PageInfo<com.caifu.dto.JxActivityDto>
     * @auther: tian
     * @date: 2020/7/23 11:26
     */
    PageInfo<JxActivityDto> getActivityList(String title, String currentPage, String pageSize, String status);

    /**
     * 功能描述: 根据id取消发布
     *
     * @param: [id]
     * @return: void
     * @auther: tian
     * @date: 2020/7/23 13:49
     */
    void cancelPublish(String id);

    /**
     * 功能描述: 根据id发布活动
     *
     * @param: [id]
     * @return: void
     * @auther: tian
     * @date: 2020/7/23 13:49
     */
    void publish(String id);

    /**
     * 功能描述: 根据id删除
     *
     * @param: [id]
     * @return: void
     * @auther: tian
     * @date: 2020/7/23 13:56
     */
    void deleteById(String id);

    /**
     * 功能描述:根据id获取活动详情
     *
     * @param: [id]
     * @return: com.caifu.dto.JxActivityDto
     * @auther: tian
     * @date: 2020/7/23 14:40
     */
    JxActivityDto getActivityInfoById(String id);

    /**
     * 功能描述:根据活动id查询参加活动人数
     *
     * @param: [activityId]
     * @return: com.baomidou.mybatisplus.extension.plugins.pagination.Page<com.caifu.pojo.JxActivityMenber>
     * @auther: tian
     * @date: 2020/7/23 15:20
     */
    IPage<JxActivityMenber> getPersonInfoByActivityId(String name, String activityId, String currentPage, String pageSize);

    /**
     * 功能描述: 根据id获取所有参加活动人数
     *
     * @param: [activityId]
     * @return: java.util.List<com.caifu.pojo.JxActivityMenber>
     * @auther: tian
     * @date: 2020/7/23 16:45
     */
    List<JxActivityMenber> getExportExcelList(String activityId);

    /**
     * 功能描述: 获取活动室列表
     *
     * @param: []
     * @return: java.util.List<com.caifu.pojo.JxActivityRoom>
     * @auther: tian
     * @date: 2020/7/23 18:06
     */
    IPage<JxActivityRoom> getActivityRoom(String currentPage, String pageSize);

    /**
     * 功能描述: 根据id查询JxActivityRoom
     *
     * @param: [id]
     * @return: com.caifu.pojo.JxActivityRoom
     * @auther: tian
     * @date: 2020/7/23 19:04
     */
    JxActivityRoom getActivityRoomById(String id);

    /**
     * 功能描述: 新增活动
     *
     * @param: []
     * @return: void
     * @auther: tian
     * @date: 2020/7/24 10:21
     */
    void add(JxActivity activity);

    /**
     * 功能描述: 根据id修改活动信息
     *
     * @param: []
     * @return: void
     * @auther: tian
     * @date: 2020/7/24 10:21
     */
    void updateActivityById(JxActivity activity);

    JxActivity getActivityById(String id);

    List<JxActivityRoom> getActivityRoomList();
}
