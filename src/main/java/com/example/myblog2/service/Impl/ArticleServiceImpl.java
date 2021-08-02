package com.example.myblog2.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.myblog2.dao.mapper.ArticleMapper;
import com.example.myblog2.dao.pojo.Article;
import com.example.myblog2.service.ArticleService;
import com.example.myblog2.vo.ArticleVo;
import com.example.myblog2.vo.Result;
import com.example.myblog2.vo.params.PageParms;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 软件工程10班 吕俊铭
 * @create 2021-08-03 0:38
 * Description:
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;
    @Override
    public Result listArticle(PageParms pageParms) {
        //分页查询article表 得出结果
        Page<Article> articlePage = new Page<>(pageParms.getPage(),pageParms.getPageSize());
        //查询条件
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        //先通过置顶排序 再通过时间
        queryWrapper.orderByDesc(Article::getWeight);
        queryWrapper.orderByDesc(Article::getCreateDate);
        Page<Article> selectPage = articleMapper.selectPage(articlePage, queryWrapper);
        List<Article> records = selectPage.getRecords();
        List<ArticleVo> articleVoList = copyList(records);
        return Result.success(articleVoList);


    }

    private List<ArticleVo> copyList(List<Article> records) {
        ArrayList<ArticleVo> articleVoList = new ArrayList<>();
        for (Article record : records) {
            ArticleVo articleVo = copy(record);
            articleVoList.add(articleVo);
        }
        return articleVoList;
    }

    private ArticleVo copy(Article article){
        ArticleVo articleVo = new ArticleVo();
        BeanUtils.copyProperties(article,articleVo);
        articleVo.setCreateDate(new DateTime(article.getCreateDate()).toString("yyyy-MM-dd HH:mm"));
        return articleVo;
    }

}
