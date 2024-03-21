package day0321;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex07_Study701 {

	public static void main(String[] args) {
		String []members= {
				"강하윤","공병현","김도훈","김우형","김정호",
				"김창인","민경진","박민지","박보민","박주용",
				"박한경","배동우","서정현","손가원","시바타유니",
				"신완철","우태형","유상곤","이가현","이병현",
				"이장우","이현성","정민석","정상혁","정진욱",
				"정환용","최시현","허승필","황재웅",""
		};
		String[][] arr = new String[6][5];
		int ran[] = new int[30];
		Loop:
			for(int i=0; i < members.length; i++) {
				ran[i] = (int)(Math.random()*30);
				for(int j=0; j<i; j++) {
					if(ran[i]==ran[j]) {
						i--;
						continue Loop;
						//break;
					}
				}
			}
		int idx = 0;
		for(int i= 0; i<arr.length; i++) {
			for(int j=0;j<arr[i].length; j++) {
				arr[i][j] = members[ran[idx++]];
			}
		}
		Date to = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM 월 dd일 ");
		System.out.print("\t"+sdf.format(to));
		System.out.println("===701 스터디팀===");
		for(int i = 0; i<arr.length; i++) {
			System.out.printf("%d 조 : \t",i+1);
			for(int j = 0; j<arr[i].length; j++) {
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
		}
	}

}


