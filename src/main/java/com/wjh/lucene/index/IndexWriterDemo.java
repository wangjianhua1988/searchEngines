package com.wjh.lucene.index;

/**
 * Created by TUPU360 on 2018/5/3.
 */

import com.wjh.lucene.ik.IKAnalyzer4Lucene7;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.File;
import java.io.IOException;

/***
 * lucene索引创建例子，IndexWriter主要功能是创建索引，合并索引，操作索引
 */
public class IndexWriterDemo {

    public static void main(String[] args) {

        try {
            /**
             * 为索引创建配置分词组件
             */
            Analyzer analyzer = new IKAnalyzer4Lucene7();

            //索引配置对象
            IndexWriterConfig config = new IndexWriterConfig(analyzer);
            //IndexWriter的打开模式，默认为CREATE_OR_APPEND，如果索引存在则打开进行扩充，否则新建
            config.setOpenMode(IndexWriterConfig.OpenMode.CREATE_OR_APPEND);

            Directory directory = FSDirectory.open((new File("D:/test/indextest")).toPath());

            IndexWriter writer = new IndexWriter(directory, config);

            //索引五个商品，包含 商品ID，商品名称，商品描述， 商品类别（多值）， 价格  商家（多值）；
            String product1 = "product1";
            String product_name_1 = "ThinkPad E470 笔记本电脑 20H1001TCD i5-7200U/Windows 10 家庭版/8GB/256GB SSD/石墨黑";
            String product_desc_1 = "第七代Kabylake智能英特尔® 酷睿™ i5 处理器 i5-7200U Windows 10 家庭版 (联想推荐使用Windows 10 专业版) 14.0英寸\n" +
                    "物理分辨率1366x768\n" +
                    "屏幕类型HD LED 背光显示屏\n" +
                    "显示比例16:9";
            String product_type1_1 = "笔记本电脑";






        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
