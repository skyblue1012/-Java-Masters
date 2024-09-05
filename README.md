## 완료
- 로그인, 회원가입 기능 추가
# 2. vo

## User
- private String id;
- private String password;
- private String userName;
- private String category;
  
1. login 로그인 기능
2. signup 회원가입기능

## 예정
### back

- sql연결 부분
1. public Connection getConnection() throws SQLException;
2. public void closeAll(PreparedStatement ps, Connection conn) throws SQLException;
3. public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException;
- RecipeDAO 코드 구현  
1. Recipe landomRecipe(String category);
2. void addRecipe(String title, String userId, String category,String img, String recipeDesc);
3. ArrayList<Recipe> showMyRecipe(String userId);
4. void deleteRecipe(String userId);

## Recipe 
- private String title;
- private String userId;
- private String category;
- private String img;
- private String recipeDescription
  
### controller
- main page와 연결. 
### front
- mypage구현
