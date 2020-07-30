package com.caifu.mapper;

import com.caifu.pojo.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 菜单表 Mapper 接口
 * </p>
 *
 * @author Lyf
 * @since 2020-07-07
 */
@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    @Select("select b.* from sys_user_menu a left join sys_menu b on a.menu_no = b.menu_no left join sys_menu c on b.parent_no = c.menu_no where a.user_no = #{userNo} order by c.sort,b.sort")
    List<SysMenu> getMenuByUser(int userNo);

    @Select("select a.menu_no as \"id\",a.name as \"name\",a.parent_no as \"pid\", a.type as \"type\",case when exists (select 1 from sys_user_menu b where a.menu_no  = b.menu_no and b.user_no = #{userNo}) then 1 else 0 end as \"flag\" from sys_menu a left join sys_menu c on a.parent_no = c.menu_no where 1 = 1 order by c.sort,a.sort")
    List<Map<String,String>> getUserMenu(int userNo);
}
