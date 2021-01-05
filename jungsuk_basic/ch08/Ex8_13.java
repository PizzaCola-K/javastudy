package ch08;

public class Ex8_13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			install();
		} catch (InstallException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	static void install() throws InstallException{
		try {
			startInstall();
			copyFiles();
		} catch (SpaceException2 e) {
			// TODO: handle exception
			InstallException ie = new InstallException("설치 중 예외 발생");
			ie.initCause(e);
			throw ie;
		} catch (MemoryException2 e) {
			// TODO: handle exception
			InstallException ie = new InstallException("설치 중 예외 발생");
			ie.initCause(e);
			throw ie;
		} finally {
			deleteTempFiles();
		}
	}
	
	static void startInstall() throws SpaceException2, MemoryException2 {
		if(!enoughSpace()) {
			throw new SpaceException2("설치할 공간이 부족합니다.");
		}
		if(!enoughMemory()) {
			throw new MemoryException2("메모리가 부족합니다.");
		}
	}
	
	static void copyFiles() {
		/*copy files*/
	}
	static void deleteTempFiles() {
		/*delete temp files*/
	}
	static boolean enoughSpace() {
		return false;
	}
	static boolean enoughMemory() {
		return true;
	}
}

class InstallException extends Exception {
	InstallException(String msg){
		super(msg);
	}
}

class SpaceException2 extends Exception {
	SpaceException2(String msg){
		super(msg);
	}
}

class MemoryException2 extends Exception {
	MemoryException2(String msg){
		super(msg);
	}
}