package ch09;


class SutdaCard {
	int num;
	boolean isKwang;
	SutdaCard() {
		this(1,true);
	}
	SutdaCard(int num, boolean isKwang){
		this.num = num;
		this.isKwang = isKwang;
	}

	public boolean equals(Object obj) {
		if(obj instanceof SutdaCard) {
			if(((SutdaCard)obj).num == this.num && ((SutdaCard)obj).isKwang == this.isKwang)
				return true;
		}
		return false;
	}
	
	public String toString() {
		return num+(isKwang? "K" : "");
	}
}