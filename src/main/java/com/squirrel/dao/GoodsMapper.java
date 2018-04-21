package com.squirrel.dao;


import com.squirrel.pojo.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface GoodsMapper {
    /**
     * 通过主键删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 添加物品
     * @param record
     * @return
     */
    int insert(Goods record);

    /**
     *
     * @param record
     * @return
     */
    int insertSelective(Goods record);

    /**
     * 通过id查询
     * @param id
     * @return
     */
    Goods selectByPrimaryKey(Integer id);

    /**
     * 通过主键更改信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Goods record);

    /**
     * 通过主键更改信息，包括大文本信息
     * @param record
     * @return
     */
    int updateByPrimaryKeyWithBLOBs(Goods record);

    /**
     * 通过主键更改信息
     * @param record
     * @return
     */
    int updateByPrimaryKey(Goods record);

    /**
     * 查询所有的商品
     * @return
     */
    List<Goods> selectAllGoods();

    List<Goods> searchGoods(@Param("name") String name, @Param("describle") String describle);

    /**
     * 根据商品分类的id，查询商品数量
     */
    int selectCountByCatelog(@Param("catelog_id") Integer catelog_id,
                             @Param("name") String name,
                             @Param("describle") String describle);

    /**
     * 根据商品分类的id，查询商品
     * @param catelog_id
     * @return
     */
    List<Goods> selectByCatelog(@Param("catelog_id") Integer catelog_id,
                                @Param("name") String name,
                                @Param("describle") String describle);

    /**
     * 根据时间先后获取商品信息，进行分页查询
     * 未在xml中实现
     * @return
     */
    List<Goods> selectByDate(int page,int maxResults);

    /**
     * 根据catelog_id查询商品信息，结果按擦亮时间排序，最新的在前
     * @return
     */
    List<Goods> selectByCatelogOrderByDate(@Param("catelogId")Integer catelogId,@Param("limit")Integer limit);

    /**
     * 查询登录用户的所有闲置商品
     * @param user_id
     * @return
     */
    List<Goods> getGoodsByUserId(Integer user_id);
}
