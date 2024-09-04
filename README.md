완료
로그인, 회원가입 기능 추가
User {
    private String id;
    private String password;
    private String userName;
    private String category;
    }
login 로그인 기능
signup 회원가입기능

예정
back
RecipeDAO 코드 구현
sql연결 부분
 public Connection getConnection() throws SQLException;
    public void closeAll(PreparedStatement ps, Connection conn) throws SQLException;
    public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException;
  
    Recipe landomRecipe(String category);
    void addRecipe(String title, String userId, String category,String img, String recipeDesc);
    ArrayList<Recipe> showMyRecipe(String userId);
    void deleteRecipe(String userId);

Recipe {
    private String title;
    private String userId;
    private String category;
    private String img;
    private String recipeDescription ;
}
controller
main page와 연결. 
front
mypage구현
