import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface RecipeDAO {
    public Connection getConnection() throws SQLException;
    public void closeAll(PreparedStatement ps, Connection conn) throws SQLException;
    public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException;

    Recipe landomRecipe(String category);
    void addRecipe(String title, String userId, String category,String img, String recipeDesc);
    ArrayList<Recipe> showMyRecipe(String userId);
    void deleteRecipe(String userId);

}
