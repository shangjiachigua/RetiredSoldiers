package com.caifu.service.impl;

import com.caifu.pojo.JxActivityRoom;
import com.caifu.mapper.JxActivityRoomMapper;
import com.caifu.service.JxActivityRoomService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 * 军休活动室  服务实现类
 * </p>
 *
 * @author Tianwenwen
 * @since 2020-07-23
 */
@Service
public class JxActivityRoomServiceImpl extends ServiceImpl<JxActivityRoomMapper, JxActivityRoom> implements JxActivityRoomService {

    @Autowired
    private JxActivityRoomMapper jxActivityRoomMapper;

    @Override
    public void updateRoomById(String id, String roomName, String roomUrl) {
        JxActivityRoom room = new JxActivityRoom();
        room.setRoomNo(Integer.parseInt(id));
        room.setRoomName(roomName);
        room.setRoomUrl(roomUrl);
        room.setUpdateTime(new Date());
        jxActivityRoomMapper.updateById(room);
    }

    @Override
    public void add(String roomName, String roomUrl) {
        JxActivityRoom room = new JxActivityRoom();
        room.setCreateBy(1);
        room.setCreateTime(new Date());
        room.setRoomName(roomName);
        room.setRoomUrl(roomUrl);
        room.setStatus("1");
        room.setUpdateBy(1);
        room.setUpdateTime(new Date());
        jxActivityRoomMapper.insert(room);
    }

    @Override
    public void deleteRoomById(String id) {
        JxActivityRoom jxActivityRoom = new JxActivityRoom();
        jxActivityRoom.setRoomNo(Integer.parseInt(id));
        jxActivityRoom.setStatus("9");
        jxActivityRoomMapper.updateById(jxActivityRoom);
    }
}
