package com.caifu.service;

import com.caifu.pojo.JxActivityRoom;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 军休活动室  服务类
 * </p>
 *
 * @author Tianwenwen
 * @since 2020-07-23
 */
public interface JxActivityRoomService extends IService<JxActivityRoom> {
    /**
     * 功能描述: 根据id修改活动室
     *
     * @param: [id, roomName, roomUrl]
     * @return: void
     * @auther: tian
     * @date: 2020/7/24 16:53
     */
    void updateRoomById(String id, String roomName, String roomUrl);

    /**
     * 功能描述: 新增活动室
     *
     * @param: [roomName, roomUrl]
     * @return: void
     * @auther: tian
     * @date: 2020/7/24 16:53
     */
    void add(String roomName, String roomUrl);

    /**
     *
     * 功能描述: 根据id删除活动室
     *
     * @param: [id]
     * @return: void
     * @auther: tian
     * @date: 2020/7/24 17:15
     */
    void deleteRoomById(String id);
}
