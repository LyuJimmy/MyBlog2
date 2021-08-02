package com.example.myblog2.service;

import com.example.myblog2.vo.Result;
import com.example.myblog2.vo.params.PageParms;

/**
 * @author JIMMY
 */

public interface ArticleService {
    /**
     * @author JIMMY
     * pageParms: 分页
     * 分页查询文章列表
     */
    Result listArticle(PageParms pageParms);
}
