package org.seckill.dto;

/**
 * ��¶��ɱ��ַDTO
 * @author Quan
 *
 */
public class Exposer {
	
	private boolean exposer; //�Ƿ�����ɱ
	private String md5;
	private long seckillId;
	private long now;  //ϵͳʱ��
	private long start;
	private long end;
	
	@Override
	public String toString() {
		return "Exposer [exposer=" + exposer + ", md5=" + md5 + ", seckillId=" + seckillId + ", now=" + now + ", start="
				+ start + ", end=" + end + "]";
	}

	public Exposer(boolean exposer, String md5, long seckillId) {
		super();
		this.exposer = exposer;
		this.md5 = md5;
		this.seckillId = seckillId;
	}

	public Exposer(boolean exposer, long seckillId,long now, long start, long end) {
		super();
		this.exposer = exposer;
		this.now = now;
		this.start = start;
		this.end = end;
		this.seckillId = seckillId;
	}

	public Exposer(boolean exposer, long seckillId) {
		super();
		this.exposer = exposer;
		this.seckillId = seckillId;
	}

	public boolean isExposer() {
		return exposer;
	}

	public void setExposer(boolean exposer) {
		this.exposer = exposer;
	}

	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

	public long getSeckillId() {
		return seckillId;
	}

	public void setSeckillId(long seckillId) {
		this.seckillId = seckillId;
	}

	public long getNow() {
		return now;
	}

	public void setNow(long now) {
		this.now = now;
	}

	public long getStart() {
		return start;
	}

	public void setStart(long start) {
		this.start = start;
	}

	public long getEnd() {
		return end;
	}

	public void setEnd(long end) {
		this.end = end;
	}
	
}
