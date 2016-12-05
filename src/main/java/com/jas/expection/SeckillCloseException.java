package com.jas.expection;

/**
 * 秒杀关闭异常
 * Created by Jason.Meng on 2016/8/4.
 */
public class SeckillCloseException extends SeckillExpection {

    /**
	 * 
	 */
	private static final long serialVersionUID = -7277100093754409532L;

	public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
