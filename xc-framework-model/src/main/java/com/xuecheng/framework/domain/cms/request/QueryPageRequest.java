package com.xuecheng.framework.domain.cms.request;

import com.xuecheng.framework.model.request.RequestData;
import lombok.Data;

/**
 * @author nereus
 * @version 1.0
 * @create on 2019/7/14
 */
@Data
public class QueryPageRequest extends RequestData {
    //接收页面查询的查询条件
    //站点id
    private String siteId;
    //页面id
    private String pageID;
    //页面名称
    private String pageName;
    //别名
    private String pageAliase;
    //模版id
    private String templateId;

}
