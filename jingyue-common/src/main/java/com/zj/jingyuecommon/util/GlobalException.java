package com.zj.jingyuecommon.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GlobalException extends RuntimeException {
    public static final Logger LOGGER= LoggerFactory.getLogger(GlobalException.class);
    public GlobalException(String msg){
        LOGGER.info(msg);

    }
    public GlobalException(String msg,Exception e){
        LOGGER.info(msg+"===原因==="+e.getCause());
    }
}
