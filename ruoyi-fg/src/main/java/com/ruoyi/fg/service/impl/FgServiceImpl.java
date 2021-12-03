package com.ruoyi.fg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.fg.domain.FgFw;
import com.ruoyi.fg.mapper.FgMapper;
import com.ruoyi.fg.domain.Fg;
import com.ruoyi.fg.service.IFgService;
import com.ruoyi.common.core.text.Convert;

/**
 * 房改信息管理Service业务层处理
 *
 * @author ruoyi
 * @date 2021-11-26
 */
@Service
public class FgServiceImpl implements IFgService {
    @Autowired
    private FgMapper fgMapper;

    /**
     * 查询房改信息管理
     *
     * @param id 房改信息管理主键
     * @return 房改信息管理
     */
    @Override
    public Fg selectFgById(String id) {
        return fgMapper.selectFgById(id);
    }

    /**
     * 查询房改信息管理列表
     *
     * @param fg 房改信息管理
     * @return 房改信息管理
     */
    @Override
    public List<Fg> selectFgList(Fg fg) {
        return fgMapper.selectFgList(fg);
    }

    /**
     * 新增房改信息管理
     *
     * @param fg 房改信息管理
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertFg(Fg fg) {
        int rows = fgMapper.insertFg(fg);
        insertFgFw(fg);
        return rows;
    }

    /**
     * 修改房改信息管理
     *
     * @param fg 房改信息管理
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateFg(Fg fg) {
        fgMapper.deleteFgFwByFkFgid(fg.getId());
        insertFgFw(fg);
        return fgMapper.updateFg(fg);
    }

    /**
     * 批量删除房改信息管理
     *
     * @param ids 需要删除的房改信息管理主键
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteFgByIds(String ids) {
        fgMapper.deleteFgFwByFkFgids(Convert.toStrArray(ids));
        return fgMapper.deleteFgByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除房改信息管理信息
     *
     * @param id 房改信息管理主键
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteFgById(String id) {
        fgMapper.deleteFgFwByFkFgid(id);
        return fgMapper.deleteFgById(id);
    }

    /**
     * 新增房改房屋信息
     *
     * @param fg 房改信息管理对象
     */
    public void insertFgFw(Fg fg) {
        List<FgFw> fgFwList = fg.getFgFwList();
        String id = fg.getId();
        if (StringUtils.isNotNull(fgFwList)) {
            List<FgFw> list = new ArrayList<>();
            for (FgFw fgFw : fgFwList) {
                fgFw.setFkFgid(id);
                list.add(fgFw);
            }
            if (list.size() > 0) {
                fgMapper.batchFgFw(list);
            }
        }
    }
}
