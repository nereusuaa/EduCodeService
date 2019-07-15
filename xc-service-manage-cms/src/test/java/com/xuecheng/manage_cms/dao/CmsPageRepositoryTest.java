package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.CmsPageParam;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author nereus
 * @version 1.0
 * @create 2019/7/15
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CmsPageRepositoryTest {

    @Autowired
    CmsPageRepository cmsPageRepository;

    @Test
    public void testFindAll(){
       List<CmsPage> all = cmsPageRepository.findAll();
        System.out.println(all);
    }

    //分页查询
    @Test
    public void testFindPage(){

      //分页参数
      int page = 1;//从0开始
      int size = 10;
      Pageable pageable = PageRequest.of(page,size);
      Page<CmsPage> all = cmsPageRepository.findAll(pageable);
      System.out.println(all);
    }

    //添加
    @Test
    public void testInsert(){
        //定义实体类
        CmsPage cmsPage = new CmsPage();
        cmsPage.setSiteId("s01");
        cmsPage.setTemplateId("t01");
        cmsPage.setPageName("测试页面");
        cmsPage.setPageCreateTime(new Date());
        List<CmsPageParam> cmsPageParams = new ArrayList<>();
        CmsPageParam cmsPageParam = new CmsPageParam();
        cmsPageParam.setPageParamName("param1");
        cmsPageParam.setPageParamValue("value1");
        cmsPageParams.add(cmsPageParam);
        cmsPage.setPageParams(cmsPageParams);
        cmsPageRepository.save(cmsPage);
        System.out.println(cmsPage);
    }

    //删除
    @Test
    public void testDelete() {
        cmsPageRepository.deleteById("5abefd525b05aa293098fca6");
    }

    //修改
    @Test
    public void testUpdate() {

/*        关于Optional：
        Optional是jdk1.8引入的类型，Optional是一个容器对象，它包括了我们需要的对象，使用isPresent方法判断所包
        含对象是否为空，isPresent方法返回false则表示Optional包含对象为空，否则可以使用get()取出对象进行操作。
        Optional的优点是：
        1、提醒你非空判断。
        2、将对象非空检测标准化。*/

        //查询对象
        Optional<CmsPage> optional = cmsPageRepository.findById("5abefd525b05aa293098fca6");
        if(optional.isPresent()){
            CmsPage cmsPage = optional.get();
            //设置要修改的值
            cmsPage.setPageName("测试页面01");
            //修改
            cmsPageRepository.save(cmsPage);
        }
    }

    @Test
    //自定义方法 根据页面名称查询
    public void testFindByPageName(){
        CmsPage cmsPage = cmsPageRepository.findByPageName("index2.html");
        System.out.println(cmsPage);
    }

}
