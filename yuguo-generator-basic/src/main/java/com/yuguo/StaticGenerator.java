package com.yuguo;

import cn.hutool.core.io.FileUtil;

import java.io.File;

public class StaticGenerator {
    public static void main(String[] args) {
        // 获取整个项目的根路径 这里容易出错，注意观察项目所在位置
        String projectPath = System.getProperty("user.dir");
        File parentFile = new File(projectPath).getParentFile();
        // 输入路径 示例模版路径
        String inputPath =  new File(parentFile, "yuguo-generator-demo/acm-template").getAbsolutePath();
        // 输出路径 目标路径
        String outputPath = projectPath;
        copyFilesByHutool(inputPath, outputPath);
    }

    /**
     * 通过hutool 拷贝静态文件
     * @param inputPath 目标文件
     * @param outputPath 拷贝到的路径
     */
    public static void copyFilesByHutool(String inputPath, String outputPath){
        FileUtil.copy(inputPath, outputPath, false);
    }
}
