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
import com.ruoyi.system.domain.AppuserInfo;
import com.ruoyi.system.service.IAppuserInfoService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户管理Controller
 * 
 * @author ruoyi
 * @date 2023-04-13
 */
@Controller
@RequestMapping("/system/info")
public class AppuserInfoController extends BaseController
{
    private String prefix = "system/info";

    @Autowired
    private IAppuserInfoService appuserInfoService;

    @RequiresPermissions("system:info:view")
    @GetMapping()
    public String info()
    {
        return prefix + "/info";
    }

    /**
     * 查询用户管理列表
     */
    @RequiresPermissions("system:info:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(AppuserInfo appuserInfo)
    {
        startPage();
        List<AppuserInfo> list = appuserInfoService.selectAppuserInfoList(appuserInfo);
        return getDataTable(list);
    }

    /**
     * 导出用户管理列表
     */
    @RequiresPermissions("system:info:export")
    @Log(title = "用户管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(AppuserInfo appuserInfo)
    {
        List<AppuserInfo> list = appuserInfoService.selectAppuserInfoList(appuserInfo);
        ExcelUtil<AppuserInfo> util = new ExcelUtil<AppuserInfo>(AppuserInfo.class);
        return util.exportExcel(list, "用户管理数据");
    }

    /**
     * 新增用户管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存用户管理
     */
    @RequiresPermissions("system:info:add")
    @Log(title = "用户管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(AppuserInfo appuserInfo)
    {
        return toAjax(appuserInfoService.insertAppuserInfo(appuserInfo));
    }

    /**
     * 修改用户管理
     */
    @RequiresPermissions("system:info:edit")
    @GetMapping("/edit/{userId}")
    public String edit(@PathVariable("userId") Long userId, ModelMap mmap)
    {
        AppuserInfo appuserInfo = appuserInfoService.selectAppuserInfoByUserId(userId);
        mmap.put("appuserInfo", appuserInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存用户管理
     */
    @RequiresPermissions("system:info:edit")
    @Log(title = "用户管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(AppuserInfo appuserInfo)
    {
        return toAjax(appuserInfoService.updateAppuserInfo(appuserInfo));
    }

    /**
     * 删除用户管理
     */
    @RequiresPermissions("system:info:remove")
    @Log(title = "用户管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(appuserInfoService.deleteAppuserInfoByUserIds(ids));
    }
}
