package ch07;

class Point {
	int x, y;
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Point3D extends Point {
	int z;
	Point3D(int x, int y, int z) {
		super(x, y);
		this.z = z;
	}
}