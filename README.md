# 보드게임 리스트

## | 프로그램 구조
![2024-09-05 15_21_10-work05_BackEnd - Eclipse IDE](https://github.com/user-attachments/assets/f8385835-6c4e-4aba-be37-ba56102529a9)

---

- Table

![2024-09-05 17_16_16-image_capture](https://github.com/user-attachments/assets/ab7e8eb3-968d-4169-8fa9-e70e281d2b47)

---
- VO
```
private int number;
private String name;
private float level;
private int price;
private String designer;
private String publisher;
```
---

- DAO
```
void registerBoardGame(BoardGame vo) throws SQLException;
ArrayList<BoardGame> showAllBoardGame() throws SQLException;	
```
---

- Front
```
boardgame_list.jsp
register_result.jsp
register.jsp
```

## | 구현

### 1. 보드게임 리스트
![2024-09-05 15_03_18-Insert title here - Chrome](https://github.com/user-attachments/assets/61d5387f-f2b2-4090-bc03-60f9647dc2d5)
---

### 2.  보드게임 등록화면
![2024-09-05 15_06_19-Insert title here - Chrome](https://github.com/user-attachments/assets/0386e280-05e6-4b2f-9347-ee2b20cd9248)
---

### 3. 보드게임 등록 성공화면
![2024-09-05 15_06_12-BoardGameList - Chrome](https://github.com/user-attachments/assets/5fd0281f-b454-41d3-9f30-9a25b9ddc71c)
