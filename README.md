주제 : 커피 주문 프로그램<br>
제공하는 서비스 : 회원가입, 로그인 / 커피 주문, 주문 취소, 주문 내역 확인 <br><br>

flow figma image <br>
https://www.figma.com/design/ZGF9a7DbxJLA0oPgghqUVq/Untitled?node-id=0-1&t=NKjObx58r3eGYEg1-1 <br>
table description<br>
OrderList<br>
![OrderList Table](https://github.com/user-attachments/assets/278abe4f-64b0-4058-a769-9005beacab40)<br>
User Table<br>
![User Table](https://github.com/user-attachments/assets/4068eb1c-0712-44a6-8e33-b849c5f853c5)<br>
Product Table<br>
![Product Table](https://github.com/user-attachments/assets/7dbece87-09fe-4ef8-b8c9-8596f8d28603)<br>
Order_Product Table<br>
![order_product Table](https://github.com/user-attachments/assets/7ff3dd2b-3508-4cd7-985b-b94f1fbb1164)<br>
VO Description<br>

User VO<br>
![User VO](https://github.com/user-attachments/assets/6c9e887a-1faf-47d5-8449-0db44dd8914e)<br>
Order VO<br>
![Order VO](https://github.com/user-attachments/assets/d6b355ff-f916-46b5-a7b2-c73784c18e06)<br>
Product VO<br>
![Product VO](https://github.com/user-attachments/assets/4e4ea2d1-43ec-4535-a60d-715eae518bac)<br>

어려웠던 부분 : idCheck 기능을 ajax를 통해 연결하는 것.<br>
개선할 부분: MVC 패턴의 개발 방식을 Factory Method 방식으로 바꾸는 것, <br>
Order 로직에서 Order_Product 테이블에 값을 넣기 전에 orderid 값을<Br>
방금 생성한 Order table에서 받아올 때 
String query2="SELECT orderId FROM orderlist WHERE User_id = ? AND totalPrice=?";
이렇게 유저 아이디와 주문 총 금액으로 id를 특정하는데 ,
이것을 자동생성되는 주문시간을 받아와서 년월일 시분 단위로 비교해서 orderid를 가져오도록 바꿀 필요가 있다.
* 초까지 일치하게 설정할 경우 처리과정상에서 소요되는 시간으로 인해 orderid 값을 가져오지 못 할 것 같다.





