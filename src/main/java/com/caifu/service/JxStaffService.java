package com.caifu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.caifu.pojo.JxStaff;

/**
 * <p>
 * 军休员工  服务类
 * </p>
 *
 * @author Tianwenwen
 * @since 2020-07-28
 */
public interface JxStaffService extends IService<JxStaff> {
    /**
     * 功能描述: 获取员工列表
     *
     * @param: []
     * @return: java.util.List<com.caifu.pojo.JxStaff>
     * @auther: tian
     * @date: 2020/7/28 16:40
     */
    IPage<JxStaff> getStaffList(String currentPage, String pageSize);

    /**
     * 功能描述: 根据id修改员工
     *
     * @param: [id, roomName, roomUrl, isExhibition]
     * @return: void
     * @auther: tian
     * @date: 2020/7/28 18:34
     */
    void updateRoomById(String id, String name, String photoUrl, String isExhibition);

    /**
     * 功能描述: 添加员工
     *
     * @param: [roomName, roomUrl, isExhibition]
     * @return: void
     * @auther: tian
     * @date: 2020/7/28 18:34
     */
    void add(String name, String photoUrl, String isExhibition);

    /**
     * 功能描述: 根据id删除员工
     *
     * @param: [id]
     * @return: void
     * @auther: tian
     * @date: 2020/7/28 18:46
     */
    void deleteById(String id);
}
