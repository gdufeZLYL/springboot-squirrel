package com.squirrel.service;

import com.squirrel.pojo.Goods;
import com.squirrel.util.DateUtil;
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
public class GoodsServiceTest {

    private static Log LOG = LogFactory.getLog(GoodsServiceTest.class);

    @Autowired
    private GoodsService goodsService;

//    @Test
//    public void addGood() throws Exception {
//        Goods goods = new Goods();
//        goods.setCatelogId(4);
//        goods.setUserId(3);
//        goods.setName("《Effetive Java》");
//        goods.setPrice(32f);
//        goods.setRealPrice(69f);
//        goods.setCommetNum(0);
//        goods.setDescrible("京东购买");
//        goodsService.addGood(goods, 2);
//    }
//
//    @Test
//    public void getGoodsByPrimaryKey() throws Exception {
//        Goods goods = goodsService.getGoodsByPrimaryKey(49);
//        LOG.info("goods = " + goods);
//    }
//
//    @Test
//    public void updateGoodsByPrimaryKeyWithBLOBs() throws Exception {
//        Goods goods = goodsService.getGoodsByPrimaryKey(48);
//        goods.setName("图书1");
//        goodsService.updateGoodsByPrimaryKeyWithBLOBs(goods.getId(), goods);
//    }
//
//    @Test
//    public void deleteGoodsByPrimaryKey() throws Exception {
//        goodsService.deleteGoodsByPrimaryKey(49);
//    }
//
//    @Test
//    public void getAllGoods() throws Exception {
//        List<Goods> goodsList = goodsService.getAllGoods();
//        for (Goods goods : goodsList) {
//            LOG.info("goods = " + goods);
//        }
//    }
//
//    @Test
//    public void searchGoods() throws Exception {
//        List<Goods> goodsList = goodsService.searchGoods("spring", "spring");
//        for (Goods goods : goodsList) {
//            LOG.info("goods = " + goods);
//        }
//    }
//
//    @Test
//    public void getGoodsByCatelog() throws Exception {
//        int categoryId = 3;
//        String str = "spring";
//        List<Goods> goodsList = goodsService.getGoodsByCatelog(categoryId, str, str);
//        for (Goods goods : goodsList) {
//            LOG.info("goods = " + goods);
//        }
//    }
//
//    @Test
//    public void getGoodsByCatelogOrderByDate() throws Exception {
//        int categoryId = 3;
//        List<Goods> goodsList = goodsService.getGoodsByCatelogOrderByDate(categoryId, 3);
//        for (Goods goods : goodsList) {
//            LOG.info("goods = " + goods);
//        }
//    }
//
//    @Test
//    public void getGoodsByUserId() throws Exception {
//        int userId = 2;
//        List<Goods> goodsList = goodsService.getGoodsByUserId(userId);
//        for (Goods goods : goodsList) {
//            LOG.info("goods = " + goods);
//        }
//    }

}