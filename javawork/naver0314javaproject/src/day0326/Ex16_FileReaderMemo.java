package day0326;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex16_FileReaderMemo {
	static final String FILENAME2 = "/Users/macbook/Desktop/naver0314/memo2.txt";
	static public void readMemo2() {
		BufferedReader br = null;
		FileReader fr = null;


		try {
			fr = new FileReader(FILENAME2);
			System.out.println("--memo2 파일을 읽습니다--");
			br = new BufferedReader(fr);
			while(true) {
				String line = br.readLine();
				//만약 데이터가 더 이상 없을 경우 null 값이 반환된다.
				if(line == null) {
					break;
				}
				System.out.println(line);


			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("--memo2 파일이 없습니다.--");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//나중에 열린 자원을 먼저 닫는다,.
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}


	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		readMemo2();


	}

}
