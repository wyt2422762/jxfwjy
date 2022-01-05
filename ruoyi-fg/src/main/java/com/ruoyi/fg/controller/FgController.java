package com.ruoyi.fg.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import com.ruoyi.fg.domain.FgExecl;
import com.ruoyi.fg.util.FgExcelUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.fg.domain.Fg;
import com.ruoyi.fg.service.IFgService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

import javax.servlet.http.HttpServletResponse;

/**
 * 房改信息管理Controller
 * 
 * @author ruoyi
 * @date 2021-11-26
 */
@Controller
@RequestMapping("/fg/fg")
public class FgController extends BaseController
{
    private String prefix = "fg/fg";

    @Autowired
    private IFgService fgService;

    @RequiresPermissions("fg:fg:view")
    @GetMapping()
    public String fg()
    {
        return prefix + "/fg";
    }

    /**
     * 查询房改信息管理列表
     */
    @RequiresPermissions("fg:fg:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Fg fg)
    {
        startPage();
        List<Fg> list = fgService.selectFgList(fg);
        return getDataTable(list);
    }

    /**
     * 导出房改信息管理列表
     */
    @RequiresPermissions("fg:fg:export")
    @Log(title = "房改信息管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Fg fg)
    {
        List<Fg> list = fgService.selectFgList(fg);
        ExcelUtil<Fg> util = new ExcelUtil<>(Fg.class);
        return util.exportExcel(list, "房改信息管理数据");
    }

    /**
     * 新增房改信息管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存房改信息管理
     */
    @RequiresPermissions("fg:fg:add")
    @Log(title = "房改信息管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Fg fg)
    {
        fg.setCreateBy(getLoginName());
        return toAjax(fgService.insertFg(fg));
    }

    /**
     * 修改房改信息管理
     */
    @RequiresPermissions("fg:fg:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        Fg fg = fgService.selectFgById(id);
        mmap.put("fg", fg);
        return prefix + "/edit";
    }

    /**
     * 修改保存房改信息管理
     */
    @RequiresPermissions("fg:fg:edit")
    @Log(title = "房改信息管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Fg fg)
    {
        fg.setUpdateBy(getLoginName());
        return toAjax(fgService.updateFg(fg));
    }

    /**
     * 删除房改信息管理
     */
    @RequiresPermissions("fg:fg:remove")
    @Log(title = "房改信息管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(fgService.deleteFgByIds(ids));
    }

    /**
     * 房改信息excel模板导出
     */
    @RequiresPermissions("fg:fg:excel")
    @Log(title = "房改信息管理", businessType = BusinessType.EXPORT)
    @PostMapping("/excel/{id}")
    @ResponseBody
    public AjaxResult excel(HttpServletResponse response, @PathVariable("id") String id, ModelMap mmap)
    {
        Fg fg = fgService.selectFgById(id);
        FgExecl fgExecl = new FgExecl(fg);

        FgExcelUtil util = new FgExcelUtil();
        return util.exportExcel(fgExecl);
    }
}
