package cn.itcast.controller;

import cn.itcast.domain.UserInfo;
import cn.itcast.service.IUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page", defaultValue = "1", required = true) Integer page,
                                @RequestParam(name = "size", defaultValue = "4", required = true) Integer size) {
        ModelAndView mv = new ModelAndView();
        List<UserInfo> users = userService.findAll(page, size);
        PageInfo pageInfo = new PageInfo(users);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("user-list");
        return mv;
    }

    @RequestMapping("/save")
    public String save(UserInfo userInfo) {
        userService.save(userInfo);
        return "redirect:/user/findAll";
    }

    @RequestMapping("/findById")
    public ModelAndView findById(String id) {

        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = userService.findById(id);
        mv.addObject("user", userInfo);
        mv.setViewName("user-show");
        return mv;
    }

    @RequestMapping("/addRoleToUser")
    public String addRoleToUser(String userId,String[] ids){

        userService.addRoleToUser(userId,ids);
        return "redirect:/user/findAll";
    }

    @RequestMapping("/findByCondition")
    public ModelAndView findByCondition(@RequestParam(name = "page", defaultValue = "1", required = true) Integer page,
                                        @RequestParam(name = "size", defaultValue = "4", required = true) Integer size,String username){
       if (username == null){
           username="";
       }
        ModelAndView mv = new ModelAndView();
        List<UserInfo> userInfoList =  userService.findByCondition(page,size,username);
        PageInfo pageInfo = new PageInfo(userInfoList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("user-list");
        return mv;
    }
}
