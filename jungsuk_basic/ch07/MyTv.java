package ch07;


class MyTv {
	private boolean isPowerOn;
	private int channel;
	private int volume;
	
	final int MAX_VOLUME = 100;
	final int MIN_VOLUME = 0;
	final int MAX_CHANNEL = 100;
	final int MIN_CHANNEL = 1;
		
	public void setChannel(int channel) {
		if(MIN_CHANNEL <= channel && channel <= MAX_CHANNEL) {
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
	
}