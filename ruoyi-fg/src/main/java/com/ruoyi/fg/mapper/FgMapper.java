package com.ruoyi.fg.mapper;

import java.util.List;
import com.ruoyi.fg.domain.Fg;
import com.ruoyi.fg.domain.FgFw;

/**
 * 房改信息管理Mapper接口
 * 
 * @author ruoyi
 * @date 2021-11-26
 */
public interface FgMapper 
{
    /**
     * 查询房改信息管理
     * 
     * @param id 房改信息管理主键
     * @return 房改信息管理
     */
    Fg selectFgById(String id);

    /**
     * 查询房改信息管理列表
     * 
     * @param fg 房改信息管理
     * @return 房改信息管理集合
     */
    List<Fg> selectFgList(Fg fg);

    /**
     * 新增房改信息管理
     * 
     * @param fg 房改信息管理
     * @return 结果
     */
    int insertFg(Fg fg);

    /**
     * 修改房改信息管理
     * 
     * @param fg 房改信息管理
     * @return 结果
     */
    int updateFg(Fg fg);

    /**
     * 删除房改信息管理
     * 
     * @param id 房改信息管理主键
     * @return 结果
     */
    int deleteFgById(String id);

    /**
     * 批量删除房改信息管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteFgByIds(String[] ids);

    /**
     * 批量删除房改房屋
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteFgFwByFkFgids(String[] ids);
    
    /**
     * 批量新增房改房屋
     * 
     * @param fgFwList 房改房屋列表
     * @return 结果
     */
    int batchFgFw(List<FgFw> fgFwList);
    

    /**
     * 通过房改信息管理主键删除房改房屋信息
     * 
     * @param id 房改信息管理ID
     * @return 结果
     */
    int deleteFgFwByFkFgid(String id);
}
