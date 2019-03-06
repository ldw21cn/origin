package net.wanho.controller;

import com.alibaba.fastjson.JSONObject;
import net.wanho.entity.Foo;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FooController {

    @RequestMapping("/foo")
    public ModelAndView foo(@Valid Foo foo , BindingResult bindingResult) {
        List<String> errorList = new ArrayList<>();
        if(bindingResult.hasErrors()){
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                errorList.add(fieldError.getDefaultMessage());
            }
            ModelAndView modelAndView = new ModelAndView("fail");
            modelAndView.addObject("error",errorList);
            return modelAndView;
        }
        return new ModelAndView("success");
    }

    @RequestMapping("/foo1")
    @ResponseBody
    public JSONObject foo1(@Valid Foo foo , BindingResult bindingResult) {
        JSONObject jsonObject = new JSONObject();
        List<String> errorList = new ArrayList<>();
        if(bindingResult.hasErrors()){
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                errorList.add(fieldError.getDefaultMessage());
            }
            jsonObject.put("status",400);
            jsonObject.put("errors",errorList);
            return jsonObject;
        }
        jsonObject.put("status",200);
        return jsonObject;
    }



}