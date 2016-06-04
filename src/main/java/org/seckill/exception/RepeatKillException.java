package org.seckill.exception;

/**
 * ÷ÿ—}√Îö¢Æê≥£
 * @author Quan
 *
 */
public class RepeatKillException extends SeckillException{
	
	public RepeatKillException(String message){
		super(message);
	}
	
	public RepeatKillException(String message,Throwable cause){
		super(message,cause);
	}
}
