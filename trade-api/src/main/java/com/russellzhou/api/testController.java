package com.russellzhou.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author： zhoudewei
 * @date： 2023/2/19 15:35
 * @description：
 * @version： v1.0
 */
@RestController
@RequestMapping(value = "/test")
public class testController {

    @GetMapping(value = "/testApi")
    public String testApi(){
        return "Russell Zhou";
    }
}
