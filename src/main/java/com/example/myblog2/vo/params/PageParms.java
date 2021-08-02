package com.example.myblog2.vo.params;

import lombok.Data;

/**
 * @author 软件工程10班 吕俊铭
 * @create 2021-08-03 0:25
 * Description:
 */
@Data
public class PageParms {
    private int page = 1;
    private int pageSize=10;
}
