package com.jas.expection;

/**
 * 重复秒杀异常(运行期异常)
 * Created by Jason.Meng on 2016/8/4.
 */
public class RepeatKillException extends SeckillExpection {

    /**
	 * 
	 */
	private static final long serialVersionUID = 9188485895852639366L;

	public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
