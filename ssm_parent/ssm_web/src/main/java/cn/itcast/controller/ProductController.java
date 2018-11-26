package cn.itcast.controller;

import cn.itcast.domain.Product;
import cn.itcast.service.IProductService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;
  /*  @RequestMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView md = new ModelAndView();
        List<Product> products = productService.findAll();
        md.addObject("productList",products);
        md.setViewName("product-list1");
        return md;
    }*/
  //分页查询
    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")Integer page,
                                @RequestParam(name = "size",required = true,defaultValue = "4")Integer size){
        ModelAndView md = new ModelAndView();
        List<Product> products = productService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(products);
        md.addObject("pageInfo",pageInfo);
        md.setViewName("product-list1");
        return md;
    }
    @RequestMapping("/insertOne")
    public String insertOne(Product product){
        productService.insertOne(product);
        return "redirect:/product/findAll";
    }

}
