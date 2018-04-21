package com.squirrel.service;

import com.squirrel.pojo.Goods;

import java.util.List;
import java.util.Map;

public interface GoodsService {
    /**
     * 发布商品
     * @param goods
     * @param duration 允许上架时长
     */
    public int addGood(Goods goods , Integer duration);

    /**
     * 通过主键获取商品
     * @param goodsId
     * @return
     */
    public Goods getGoodsByPrimaryKey(Integer goodsId);

    /**
     * 更新商品信息
     * @param goods
     */
    public void updateGoodsByPrimaryKeyWithBLOBs(int goodsId ,Goods goods);

    /**
     * 通过主键删除商品
     * @param id
     */
    public void deleteGoodsByPrimaryKey(Integer id);

    /**
     * 获取所有商品信息
     */
    public List<Goods> getAllGoods();

    List<Goods> searchGoods(String name, String describle);


    /**
     * 通过商品分类获取商品信息
     */
    public List<Goods> getGoodsByCatelog(Integer id,String name,String describle);

    /**
     * 根据分类id,并进行时间排序,获取前limit个结果
     * @param catelogId
     * @param limit
     * @return
     */
    public List<Goods> getGoodsByCatelogOrderByDate(Integer catelogId,Integer limit);

    /**
     * 根据用户的id，查询出该用户的所有闲置
     * @param user_id
     * @return
     */
    public List<Goods> getGoodsByUserId(Integer user_id);

    /**
     * 根据商品分类,名称描述模糊查询分页获取
     * @param pageNum
     * @param pageSize
     * @param catelogId
     * @param name
     * @param describle
     * @return
     */
    Map<String, Object> getGoodsByCatelogIdAndNameAndDescrible(
            int pageNum, int pageSize, int catelogId,
            String name, String describle);

}
