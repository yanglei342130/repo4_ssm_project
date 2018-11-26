package cn.itcast.controller;

import cn.itcast.domain.Permission;
import cn.itcast.service.IPermissionService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private IPermissionService permissionService;
    @PreAuthorize("principal.username=='jack'")
    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page",defaultValue = "1")Integer page,
                                @RequestParam(name = "size",defaultValue = "4")Integer size){
        List<Permission> permissions = permissionService.findAll(page, size);
        PageInfo pageInfo = new PageInfo(permissions);
        ModelAndView md = new ModelAndView("permission-list","pageInfo",pageInfo);
        return md;
    }

    @RequestMapping("/save")
    public String save(Permission permission){

        permissionService.save(permission);
        return "redirect:/permission/findAll";
    }

    @RequestMapping("/findPermissionByRid")
    public ModelAndView findPermissionByRid(String rid){
        ModelAndView mv = new ModelAndView();
        List<Permission> permissionList = permissionService.findPermissionByRid(rid);
        mv.addObject("rid",rid);
        mv.addObject("permissionList",permissionList);
        mv.setViewName("role-permission-add");
        return mv;
    }
}
