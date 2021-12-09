package com.ruoyi.zfjl.controller;

import java.net.URLEncoder;
import java.util.List;

import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.config.ServerConfig;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.validation.CreateGroup;
import com.ruoyi.common.validation.EditGroup;
import com.ruoyi.zfjl.domain.Zfjl;
import com.ruoyi.zfjl.service.IZfjlService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 执法记录主Controller
 * 
 * @author ruoyi
 * @date 2021-12-07
 */
@Controller
@RequestMapping("/zfjl/zfjl")
public class ZfjlController extends BaseController
{
    private String prefix = "zfjl/zfjl";

    @Autowired
    private ServerConfig serverConfig;

    @Autowired
    private IZfjlService zfjlService;

    @Value("${preview.url}")
    private String previewUrl;

    @RequiresPermissions("zfjl:zfjl:view")
    @GetMapping()
    public String zfjl()
    {
        return prefix + "/zfjl";
    }

    /**
     * 查询执法记录主列表
     */
    @RequiresPermissions("zfjl:zfjl:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Zfjl zfjl)
    {
        startPage();
        List<Zfjl> list = zfjlService.selectZfjlList(zfjl);
        return getDataTable(list);
    }

    /**
     * 导出执法记录主列表
     */
    @RequiresPermissions("zfjl:zfjl:export")
    @Log(title = "执法记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Zfjl zfjl)
    {
        List<Zfjl> list = zfjlService.selectZfjlList(zfjl);
        ExcelUtil<Zfjl> util = new ExcelUtil<Zfjl>(Zfjl.class);
        return util.exportExcel(list, "执法记录主数据");
    }

    /**
     * 查看执法记录主
     */
    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") String id, ModelMap mmap)
    {
        Zfjl zfjl = zfjlService.selectZfjlById(id);
        mmap.put("zfjl", zfjl);
        mmap.put("previewUrl", previewUrl);
        mmap.put("serverBase", serverConfig.getUrl());
        return prefix + "/view";
    }

    /**
     * 新增执法记录主
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存执法记录主
     */
    @RequiresPermissions("zfjl:zfjl:add")
    @Log(title = "执法记录主", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@RequestBody @Validated(CreateGroup.class) Zfjl zfjl)
    {
        return toAjax(zfjlService.insertZfjl(zfjl));
    }

    /**
     * 修改执法记录主
     */
    @RequiresPermissions("zfjl:zfjl:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        Zfjl zfjl = zfjlService.selectZfjlById(id);
        mmap.put("zfjl", zfjl);
        return prefix + "/edit";
    }

    /**
     * 修改保存执法记录主
     */
    @RequiresPermissions("zfjl:zfjl:edit")
    @Log(title = "执法记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@RequestBody @Validated(EditGroup.class) Zfjl zfjl)
    {
        return toAjax(zfjlService.updateZfjl(zfjl));
    }

    /**
     * 删除执法记录主
     */
    @RequiresPermissions("zfjl:zfjl:remove")
    @Log(title = "执法记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(zfjlService.deleteZfjlByIds(ids));
    }

    /**
     * 上传文件（单个）
     */
    @PostMapping("/upload")
    @ResponseBody
    public AjaxResult uploadFile(MultipartFile file) throws Exception
    {
        try
        {
            // 上传文件路径
            String filePath = RuoYiConfig.getUploadPath() + "/zfjl";
            // 上传并返回新文件名称
            String fileName = FileUploadUtils.upload(filePath, file);

            AjaxResult ajax = AjaxResult.success();
            ajax.put("fileName", fileName);
            ajax.put("orgFileName", file.getOriginalFilename());
            ajax.put("url", fileName);
            return ajax;
        }
        catch (Exception e)
        {
            return AjaxResult.error(e.getMessage());
        }
    }
}
