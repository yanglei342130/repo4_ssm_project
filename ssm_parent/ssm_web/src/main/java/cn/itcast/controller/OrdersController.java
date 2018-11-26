package cn.itcast.controller;

import cn.itcast.domain.Orders;
import cn.itcast.service.IOrdersService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private IOrdersService ordersService;
    /*@RequestMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView md = new ModelAndView();
        List<Orders> ordersList = ordersService.findAll();
        md.addObject("ordersList",ordersList);
        md.setViewName("orders-list");
        return md;
    }*/
//分页显示查询的结果
    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page,
                                @RequestParam(name = "size",required = true,defaultValue = "4") Integer size){
        ModelAndView md = new ModelAndView();
        List<Orders> ordersList = ordersService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(ordersList);
        md.addObject("pageInfo",pageInfo);
        md.setViewName("orders-page-list");
        return md;
    }
    @RequestMapping("/findById")
    public ModelAndView findById(String id){
        ModelAndView mv = new ModelAndView();
        Orders orders = ordersService.findById(id);
        mv.addObject("orders",orders);
        mv.setViewName("orders-show");
        return mv;
    }
}
