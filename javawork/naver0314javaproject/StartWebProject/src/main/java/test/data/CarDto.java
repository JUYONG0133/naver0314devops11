package test.data;

public class CarDto {
    private String model;
    private String photo;
    private int price;
    private int count;
    private String color;

    public CarDto() {
    }

    public CarDto(String model, String photo, int price, int count, String color) {
        this.model = model;
        this.photo = photo;
        this.price = price;
        this.count = count;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
/*
문제

"자동차 상점" 웹 페이지를 만드는 JSP 파일을 작성하십시오. 페이지에는 다양한 자동차(예: 세단, SUV, 스포츠카, 트럭)가 포함된 목록이 표시되어야 합니다. 각 자동차는 사진, 모델명, 가격, 수량을 포함해야 하며, 배경색은 자동차 유형에 따라 달라져야 합니다.

### 기본 설정

- 각 자동차는 `CarDto`라는 Java 클래스의 인스턴스로 표현됩니다. 이 클래스는 다음 속성을 가집니다:
  - `model`: 모델명 (문자열)
  - `photo`: 사진 파일의 이름 (문자열)
  - `price`: 가격 (정수)
  - `count`: 재고 수량 (정수)
  - `color`: 배경색 (문자열)

- 자동차 목록은 `ArrayList`로 관리하며, 초기에 네 가지 유형의 자동차로 채워집니다.

### 구현해야 할 항목

1. `CarDto` 클래스를 정의합니다.
2. 자동차 정보를 저장할 `ArrayList`를 생성하고, 초기 자동차 데이터로 채웁니다.
3. 각 자동차를 웹 페이지에 표시하기 위해 JSP에서 `ArrayList`를 반복 처리합니다.
4. 각 자동차를 독립된 `<div>` 태그 안에 배치하며, 해당 자동차의 배경색으로 설정된 색상으로 `<div>`의 배경색을 지정합니다.
5. 각 `<div>` 안에는 자동차의 사진, 모델명, 가격, 수량이 표시됩니다. 사진은 `<img>` 태그를 사용하여 표시합니다.


1. 각 자동차 목록에 "구매" 버튼을 추가합니다.
2. 버튼을 클릭하면 자바스크립트 함수를 호출하여, 해당 자동차의 모델명, 가격, 수량을 포함한 상세 정보를 페이지 하단에 동적으로 표시합니다.
3. 상세 정보와 함께 "구매하였습니다" 메시지를 표시합니다.

구현 상세
* JavaScript 함수 추가: purchaseCar라는 함수를 정의하고, 이 함수는 자동차 객체의 id를 매개변수로 받습니다. 이 함수는 해당 자동차의 상세 정보를 가져와 페이지 하단에 표시합니다.
* 자동차 정보 동적 표시: 선택한 자동차의 모델명, 가격, 수량 정보를 <div> 태그 내에 표시하며, "구매하였습니다" 메시지를 추가합니다.
* HTML 수정: 각 <div class="shop"> 안에 <button> 태그를 추가하여 "구매" 버튼을 만듭니다. 이 버튼은 onclick 이벤트에 purchaseCar() 함수를 호출하도록 설정합니다.

 */