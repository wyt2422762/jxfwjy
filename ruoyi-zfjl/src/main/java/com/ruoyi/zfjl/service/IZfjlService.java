package com.ruoyi.zfjl.service;

import java.util.List;
import com.ruoyi.zfjl.domain.Zfjl;

/**
 * 执法记录主Service接口
 * 
 * @author ruoyi
 * @date 2021-12-07
 */
public interface IZfjlService
{
    /**
     * 查询执法记录主
     * 
     * @param id 执法记录主主键
     * @return 执法记录主
     */
    Zfjl selectZfjlById(String id);

    /**
     * 查询执法记录主列表
     * 
     * @param zfjl 执法记录主
     * @return 执法记录主集合
     */
    List<Zfjl> selectZfjlList(Zfjl zfjl);

    /**
     * 新增执法记录主
     * 
     * @param zfjl 执法记录主
     * @return 结果
     */
    int insertZfjl(Zfjl zfjl);

    /**
     * 修改执法记录主
     * 
     * @param zfjl 执法记录主
     * @return 结果
     */
    int updateZfjl(Zfjl zfjl);

    /**
     * 批量删除执法记录主
     * 
     * @param ids 需要删除的执法记录主主键集合
     * @return 结果
     */
    int deleteZfjlByIds(String ids);

    /**
     * 删除执法记录主信息
     * 
     * @param id 执法记录主主键
     * @return 结果
     */
    int deleteZfjlById(String id);
}
