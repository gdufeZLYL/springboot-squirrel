package com.squirrel.service;

import com.squirrel.pojo.Catelog;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
public class CatelogServiceTest {

    private static Log LOG = LogFactory.getLog(CatelogServiceTest.class);

    @Autowired
    private CatelogService catelogService;

//    @Test
//    public void getAllCatelog() throws Exception {
//        List<Catelog> catelogs = catelogService.getAllCatelog();
//        LOG.info("size = " + catelogs.size());
//        for (Catelog catelog : catelogs) {
//            LOG.info("catelog = " + catelog);
//        }
//    }
//
//    @Test
//    public void getCount() throws Exception {
//    }
//
//    @Test
//    public void selectByPrimaryKey() throws Exception {
//        Catelog catelog = catelogService.selectByPrimaryKey(1);
//        LOG.info("catelog = " + catelog);
//    }
//
//    @Test
//    public void updateByPrimaryKey() throws Exception {
//        Catelog catelog = catelogService.selectByPrimaryKey(1);
//        catelog.setNumber(8);
//        catelogService.updateByPrimaryKey(catelog);
//    }
//
//    @Test
//    public void updateCatelogNum() throws Exception {
//        catelogService.updateCatelogNum(1, 7);
//    }

}