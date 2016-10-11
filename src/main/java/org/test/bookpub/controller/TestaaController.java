package org.test.bookpub.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.test.bookpub.PropertyBind.Isbn;
import org.test.bookpub.entity.Testaa;
import org.test.bookpub.repository.TestaaRepository;

/**
 * Created by zhangxingxing on 16/9/12.
 */
@Controller
public class TestaaController {

    private final Logger logger = LoggerFactory.getLogger(TestaaController.class);

    @Autowired
    private TestaaRepository testaaRepository;

    @RequestMapping("/findName/{id}")
    //@ResponseBody
    public String findName(@PathVariable("id")Testaa id, Model model) throws Exception {
        logger.info(id.toString());
        Testaa testaa = testaaRepository.findById(Long.valueOf(id.getId()));
        logger.info(testaa.getName());
//        throw new Exception("aaa");
//        return testaa.getName();
        model.addAttribute("name",testaa.getName());
        return "test";
    }

}
