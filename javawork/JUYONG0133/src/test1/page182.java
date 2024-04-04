package test1;

public class page182 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int[][] mathScores = new int[2][3]; //각 반의 학생 수가 3명으로 동일할 경우 점수 저장을 위한 2차원 배열 생성


        for (int i = 0; i < mathScores.length; i++) { //반의 수 만큼 반복// 2칸 생성했으니 2번 반복
            for (int j = 0; j < mathScores[i].length; j++) { // 해당 반의 학생수 만큼 반복 // 3칸 생성했으니 3번 반복
                //ex 1반 1번, 1반 2번, 1반 3번; 2반 1번, 2반 2번, 3반 3번
                System.out.println("mathScroes [" + i + "][" + j + "] : " + mathScores[i][j]); //배열을 생성하고 값을 대입하지 않았으므로 초기값인 0이 출력
            }
        }
        System.out.println();

        mathScores[0][0] = 80;
        mathScores[0][1] = 83;
        mathScores[0][2] = 85;
        mathScores[1][0] = 86;
        mathScores[1][1] = 90;
        mathScores[1][2] = 92;
        //각 학생수에 값 대입
        //ex 1반 1번 학생 점수 = 80, 2반 2번 학생 점수 = 90;

        int totalStudent = 0;
        int totalMathSum = 0;
        //전체 학생의 수학 평균을 구하기 위한 변수 선언

        for (int i = 0; i < mathScores.length; i++) {
            totalStudent += mathScores[i].length;  // totalStudent에 총 학생수 대입(학생이 총몇명인지 계산)
            for (int j = 0; j < mathScores[i].length; j++) {

                totalMathSum += mathScores[i][j]; // 총 학생수의 값의 합산을 구한다(학생 총점 계산)
                //totalMathSum = totalMathSum + mathScores[i][j];
                //ex) 0 = 0+80;  80 = 80+83
            }
        }
        double totalMathAvg = (double) totalMathSum / totalStudent; //평균을 double형으로 선언했기 때문에 totalMathSum 이나 totalStudent 중 하나를 double 형으로 형번환 해줘야한다,
        System.out.println("전체 학생의 수학 평균 점수 : " + totalMathAvg);
        System.out.println();

        int[][] englishScores = new int[2][]; //각 반에 학생수가 다를 경우 점수 저장을 위한 2차원 배열 생성
        englishScores[0] = new int[2];  //ex) 1반 학생수는 2명, 2반 학생 수는 3명으로 생성
        englishScores[1] = new int[3];

        for (int i = 0; i < englishScores.length; i++) {
            for (int j = 0; j < englishScores[i].length; j++) {
                System.out.println("englishScroes [" + i + "][" + j + "] : " + englishScores[i][j]);
            }
        }
        System.out.println();

        englishScores[0][0] = 90;
        englishScores[0][1] = 91;
        englishScores[1][0] = 92;
        englishScores[1][1] = 93;
        englishScores[1][2] = 94;  // 각 학생에 영어 점수 값 대입

        //전체 학생의 영어 평균
        totalStudent = 0;
        int totalEnglishSum = 0;
        for (int i = 0; i < englishScores.length; i++) {
            totalStudent += englishScores[i].length; // 총 학생수 합산 (총학생수 구하기)
            for (int j = 0; j < englishScores[i].length; j++) {
                totalEnglishSum += englishScores[i][j]; //총 학생수의 영어점수 합산  (학생의 영어점수 총합)
            }
        }

        double totalEnglishAvg = (double) totalEnglishSum / totalStudent; //totalEnglishAvg를 double형으로 선언했기 때문에 totalEnglishSum  totalStudent 둘중하나를 double로 형변환 해줘야한

        System.out.println("전체 학생의 영어 점수 평균 : " + totalEnglishAvg);


    }

}
