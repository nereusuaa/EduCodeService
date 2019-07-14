package com.xuecheng.api.cms;

import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.model.response.QueryResponseResult;

/**
 * @author nereus
 * @version 1.0
 * @create 2019/7/14
 */
public interface CmsPageControllerApi {
    //页面查询
    public QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest);
}
