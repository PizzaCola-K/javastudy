package ch08;

import java.io.File;

class Ex8_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			File f = createFile(args[0]);
			System.out.println(f.getName()+"파일이 성공적으로 생성되었습니다.");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage()+" 다시 입력해주시기 바랍니다.");
		}
	}
	static File createFile(String fileName) throws Exception {
		if(fileName == null || fileName.equals(""))
			throw new Exception("파일 이름이 유효하지 않습니다.");
		File f = new File(fileName);
		f.createNewFile();
		return f;
	}
}
