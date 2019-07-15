package com.xuecheng.manage_cms.service;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.QueryResult;
import com.xuecheng.manage_cms.dao.CmsPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author nereus
 * @version 1.0
 * @create 2019/7/16
 */
@Service
public class PageService {
    @Autowired
    CmsPageRepository cmsPageRepository;

    /**
     * 页面列表分页查询
     * @param page 当前页码,从1开始记录
     * @param size 页面显示个数
     * @param queryPageRequest 查询条件
     * @return 页面列表
     */
   public QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest){

       //分页参数
       if(page <=0){
           page = 1;
       }
       page = page - 1;
       if(size <=0){
           size = 10;
       }
       Pageable pageable = PageRequest.of(page,size);
       Page<CmsPage> all = cmsPageRepository.findAll(pageable);
       QueryResult queryResult = new QueryResult();
       queryResult.setList(all.getContent());//数据列表
       queryResult.setTotal(all.getTotalElements());//数据总记录数
       QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS,queryResult);

        return queryResponseResult;
    }

}
