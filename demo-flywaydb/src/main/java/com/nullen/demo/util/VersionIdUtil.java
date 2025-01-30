package com.nullen.demo.util;

import cn.hutool.core.util.IdUtil;

/**
 * @author Nullen
 */
public class VersionIdUtil {


    public static String generateLatestId() {



        return String.valueOf(IdUtil.getSnowflakeNextId());
    }
}
