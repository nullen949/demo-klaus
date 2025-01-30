package com.nullen.demo.generator.util;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;

import java.nio.file.Paths;

/**
 * @author Silas
 */
public class MpGeneratorUtil {

    public static void main(String[] args) {
        generator();
    }

    public static void generator() {
        FastAutoGenerator.create(
                        "jdbc:mysql://192.168.110.245:3306/sg_ams?useUnicode=true&useSSL=false&characterEncoding=utf-8&allowPublicKeyRetrieval=true",
                        "root",
                        "root")
                .globalConfig(builder -> builder
                        .author("Baomidou")
                        .outputDir(Paths.get(System.getProperty("user.dir")) + "/demo-code-generator/src/main/java")
                        .commentDate("yyyy-MM-dd"))
                .packageConfig(builder -> builder
                        .parent("com.nullen.demo.generator")
                        .entity("entity")
                        .mapper("mapper")
                        .service("service")
                        .serviceImpl("service.impl")
                        .xml("mapper.xml"))
                .strategyConfig(builder -> builder
                        .entityBuilder()
                        .enableLombok())
                // .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }
}
