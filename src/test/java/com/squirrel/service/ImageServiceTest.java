package com.squirrel.service;

import com.squirrel.pojo.Image;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.font.ImageGraphicAttribute;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
public class ImageServiceTest {

    private static Log LOG = LogFactory.getLog(ImageServiceTest.class);

    @Autowired
    private ImageService imageService;

//    @Test
//    public void insert() throws Exception {
//        Image image = new Image();
//        image.setGoodsId(49);
//        image.setImgUrl("sdadasd");
//        imageService.insert(image);
//    }
//
//    @Test
//    public void getImagesByGoodsPrimaryKey() throws Exception {
//        List<Image> images = imageService.getImagesByGoodsPrimaryKey(48);
//        for (Image image : images) {
//            LOG.info("image = " + image);
//        }
//    }
//
//    @Test
//    public void deleteImagesByGoodsPrimaryKey() throws Exception {
//        int result = imageService.deleteImagesByGoodsPrimaryKey(49);
//        LOG.info("result = " + result);
//    }

}