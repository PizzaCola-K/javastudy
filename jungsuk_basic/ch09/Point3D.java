package ch09;

class Point3D {
	int x,y,z;
	
	Point3D(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	Point3D(){
		this(0,0,0);
	}
	public boolean equals(Object obj) {
		if(obj instanceof Point3D) {
			Point3D objP = (Point3D)obj;
			if(x==objP.x && y==objP.y && z==objP.z)
				return true;
		}
		return false;
	}
	public String toString() {
		return "["+x+","+y+","+z+"]";
	}
}
