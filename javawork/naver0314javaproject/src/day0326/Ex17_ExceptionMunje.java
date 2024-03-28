package day0326;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;

/*
 * score.txt 를 읽어서 총갯수와 총점, 평균을 구하시오.
 * 단, 점수에문자가 있는 경우 갯수에서 제외하고 총점에서도 제외하고 출력이 되게 하기
 * 
 * '
 * 
 * ex)
 * 개수 ; 13개
 * 총점 : 990
 * 평균 : 79.99
 */
public class Ex17_ExceptionMunje {
	static final String FILENAME2 = "/Users/macbook/Desktop/naver0314/score.txt";

	static public void readMemo3() {
		BufferedReader br = null;
		FileReader fr = null;
		int sum=0;
		int count=0;
		int num = 0;
		try {
			fr = new FileReader(FILENAME2);
			System.out.println("--score 파일을 읽습니다--");
			br = new BufferedReader(fr);
			while(true) {
				String line = br.readLine();
				//만약 데이터가 더 이상 없을 경우 null 값이 반환된다.
				if(line == null) {
					break;
				}
				try {
				num = Integer.parseInt(line);
				count++;
				sum+=num;
				}catch(NumberFormatException e) {
					// TODO: handle exception
					System.out.println("문자가 포함되어 있습니다"+e.getMessage());
				}
				//System.out.println(num);
			//	sum += num;
				//				System.out.println(num);
				//				System.out.println();
				//				System.out.println(count);
			}
				
				//System.out.println(sum);
//				for(int i = 0; i < count; i++) {
//
//					sum = sum + num;
//					//System.out.println(sum);
//				}
//			

			System.out.println("개수 : "+count);
			System.out.println("총점 : "+sum);
			
			NumberFormat nf = NumberFormat.getInstance();
			nf.setMaximumFractionDigits(2);
			System.out.println("평균 : "+nf.format((double)sum/count));;
			System.out.printf("평균 : %3.2f",(double)sum/count);



		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("--score 파일이 없습니다.--");
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
		readMemo3();
	}

}
