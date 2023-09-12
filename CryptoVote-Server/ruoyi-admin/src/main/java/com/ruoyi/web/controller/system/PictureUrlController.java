package com.ruoyi.web.controller.system;

import java.util.List;
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
import com.ruoyi.system.domain.PictureUrl;
import com.ruoyi.system.service.IPictureUrlService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 轮播图Controller
 * 
 * @author chris
 * @date 2023-04-09
 */
@Controller
@RequestMapping("/system/url")
public class PictureUrlController extends BaseController
{
    private String prefix = "system/url";

    @Autowired
    private IPictureUrlService pictureUrlService;

    @RequiresPermissions("system:url:view")
    @GetMapping()
    public String url()
    {
        return prefix + "/url";
    }

    /**
     * 查询轮播图列表
     */
    @RequiresPermissions("system:url:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PictureUrl pictureUrl)
    {
        startPage();
        List<PictureUrl> list = pictureUrlService.selectPictureUrlList(pictureUrl);
        return getDataTable(list);
    }

    /**
     * 导出轮播图列表
     */
    @RequiresPermissions("system:url:export")
    @Log(title = "轮播图", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PictureUrl pictureUrl)
    {
        List<PictureUrl> list = pictureUrlService.selectPictureUrlList(pictureUrl);
        ExcelUtil<PictureUrl> util = new ExcelUtil<PictureUrl>(PictureUrl.class);
        return util.exportExcel(list, "轮播图数据");
    }

    /**
     * 新增轮播图
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存轮播图
     */
    @RequiresPermissions("system:url:add")
    @Log(title = "轮播图", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(PictureUrl pictureUrl)
    {
        return toAjax(pictureUrlService.insertPictureUrl(pictureUrl));
    }

    /**
     * 修改轮播图
     */
    @RequiresPermissions("system:url:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        PictureUrl pictureUrl = pictureUrlService.selectPictureUrlById(id);
        mmap.put("pictureUrl", pictureUrl);
        return prefix + "/edit";
    }

    /**
     * 修改保存轮播图
     */
    @RequiresPermissions("system:url:edit")
    @Log(title = "轮播图", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(PictureUrl pictureUrl)
    {
        return toAjax(pictureUrlService.updatePictureUrl(pictureUrl));
    }

    /**
     * 删除轮播图
     */
    @RequiresPermissions("system:url:remove")
    @Log(title = "轮播图", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(pictureUrlService.deletePictureUrlByIds(ids));
    }
}
