package com.worstEzreal.tess.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Desc
 *
 * @date 2018/7/2
 */
@Controller
public class IndexController {
    @RequestMapping("/index")
    public String index() {
        return "home";
    }
}
