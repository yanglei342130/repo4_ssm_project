package cn.itcast.controller;

import cn.itcast.domain.Role;
import cn.itcast.service.IRoleService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;
    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page",defaultValue = "1")Integer page,
                                @RequestParam(name = "size",defaultValue = "4")Integer size){

        ModelAndView mv = new ModelAndView();
        List<Role> roles = roleService.findAll(page, size);
        PageInfo pageInfo = new PageInfo(roles);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("role-list");
        return mv;
    }

    @RequestMapping("/save")
    public String save(Role role){
        roleService.save(role);
        return "redirect:/role/findAll";
    }
    @RolesAllowed("ADMIN")
    @RequestMapping("/findRolesByUid")
    public ModelAndView findRolesByUid(String uid){
        ModelAndView mv = new ModelAndView();
        List<Role> roleList = roleService.findByUid(uid);
        mv.addObject("uid",uid);
        mv.addObject("roleList",roleList);
        mv.setViewName("user-role-add");
        return mv;
    }

    @RequestMapping("/addPermissionToRole")
    public String addPermissionToRole(@RequestParam(name = "roleId") String rid,String[] ids){

        roleService.addPermissionToRole(rid,ids);
        return "redirect:/role/findAll";
    }

    @RequestMapping("/findByRId")
    public ModelAndView findByRId(String rid){
        ModelAndView mv = new ModelAndView();
        Role role = roleService.findByRId(rid);
        mv.addObject("role",role);
        mv.setViewName("role-show");
        return mv;
    }
}
