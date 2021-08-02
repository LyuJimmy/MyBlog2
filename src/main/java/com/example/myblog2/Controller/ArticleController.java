package com.example.myblog2.Controller;

import com.example.myblog2.service.ArticleService;
import com.example.myblog2.vo.Result;
import com.example.myblog2.vo.params.PageParms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 软件工程10班 吕俊铭
 * @create 2021-08-03 0:23
 * Description:
 */
//Json数据进行交互
@RestController
@RequestMapping("/articles")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @PostMapping()
     public Result listArticle(@RequestBody PageParms pageParms){

        return articleService.listArticle(pageParms);
    }
}
