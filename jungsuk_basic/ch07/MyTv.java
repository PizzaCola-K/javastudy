package ch07;


class MyTv {
	final int MAX_VOLUME = 100;
	final int MIN_VOLUME = 0;
	final int MAX_CHANNEL = 100;
	final int MIN_CHANNEL = 1;
	
	private boolean isPowerOn = false;
	private int channel = MIN_CHANNEL;
	private int prevChannel = MIN_CHANNEL;
	private int volume = MIN_VOLUME;
	
		
	public void setChannel(int channel) {
		if(MIN_CHANNEL <= channel && channel <= MAX_CHANNEL) {
			this.prevChannel = this.channel;
			this.channel = channel;
		}
	}
	public void setVolume(int volume) {
		if(MIN_VOLUME <= volume && volume <= MAX_VOLUME) {
			this.volume = volume;
		}
	}
	public int getChannel() {return channel;}
	public int getVolume() {return volume;}
	
	void gotoPrevChannel() {
		int tmpChannel = this.channel;
		this.channel = this.prevChannel;
		this.prevChannel = tmpChannel;
	}
	
}