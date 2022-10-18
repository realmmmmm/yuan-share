package com.mmm.code;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.BeetlTemplateEngine;

import java.io.File;
import java.util.Collections;

public class MyCodeGenerator {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/lu_tale?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8&useSSL=false&useInformationSchema=true";

    private static final String DB_USER_NAME = "root";

    private static final String DB_PASSWORD = "hsp";

    private static final String JAVA_CODE_DIR = "yuan-fullstack\\yuan-fullstack-backend\\src\\main\\java\\";

    private static final String XML_FILE_DIR = "yuan-fullstack\\yuan-fullstack-backend\\src\\main\\resources\\mapper\\";

    public static void main(String[] args) {
        System.out.println("dir====>" + System.getProperty("user.dir"));
        //获取根目录 “E:\...\yuan-share”
        String rootDir = System.getProperty("user.dir");
        //设置java代码输出目录
        String codeOutputDir = rootDir + File.separator + JAVA_CODE_DIR;
        //设置xml文件输出目录
        String xmlOutputDir = rootDir + File.separator + XML_FILE_DIR;
        //代码生成
        FastAutoGenerator.create(DB_URL,DB_USER_NAME,DB_PASSWORD)
                .globalConfig(builder -> {
                    builder.author("mmm13123") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir(codeOutputDir); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.mmm") // 设置父包名
                            .moduleName("sys") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, xmlOutputDir)); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("t_users"); // 设置需要生成的表名
                    //        .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
                .templateEngine(new BeetlTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
