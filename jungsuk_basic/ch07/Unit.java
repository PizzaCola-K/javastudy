package ch07;

abstract class Unit {
	int x, y;
	abstract void move(int x, int y);
	void stop() {/* ���� ��ġ�� ����*/}
}

class Marine extends Unit {
	void move(int x, int y) {
		System.out.println("Marine[x="+x+",y="+y+"]");
	}
	void stimPack() {/*������ ���*/}
}
class Tank extends Unit {
	void move(int x, int y) {
		System.out.println("Tank[x="+x+",y="+y+"]");
	}	
	void changeMode() {/*���ݸ�� ��ȯ*/}
}
class Dropship extends Unit {
	void move(int x, int y) {
		System.out.println("Dropship[x="+x+",y="+y+"]");
	}
	void load() {/*���õ� ����� �¿��.*/}
	void unload() {/*���õ� ����� ������.*/}
}