package com.jas.expection;

/**
 * 秒杀相关业务异常
 * Created by Jason.Meng on 2016/8/4.
 */
public class SeckillExpection extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -462332021693775990L;

	public SeckillExpection(String message) {
        super(message);
    }

    public SeckillExpection(String message, Throwable cause) {
        super(message, cause);
    }
}
