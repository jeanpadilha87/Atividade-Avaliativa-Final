import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IngredienteDAO {

    public void inserir(Ingrediente i) throws Exception {
        Connection conn = DAO.getConnection();
        String sql = "INSERT INTO ingrediente (nome) VALUES (?)";
        PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, i.getNome());
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            i.setId(rs.getInt(1));
        }
        rs.close();
        stmt.close();
        conn.close();
    }

    public List<Ingrediente> listar() throws Exception {
        Connection conn = DAO.getConnection();
        String sql = "SELECT idIngrediente, nome FROM ingrediente";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        List<Ingrediente> lista = new ArrayList<>();
        while (rs.next()) {
            lista.add(new Ingrediente(
                rs.getInt("idIngrediente"),
                rs.getString("nome")
            ));
        }
        rs.close();
        stmt.close();
        conn.close();
        return lista;
    }

    public void atualizar(Ingrediente i) throws Exception {
        Connection conn = DAO.getConnection();
        String sql = "UPDATE ingrediente SET nome = ? WHERE idIngrediente = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, i.getNome());
        stmt.setInt(2, i.getId());
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }

    public void deletar(int id) throws Exception {
        Connection conn = DAO.getConnection();
        String sql = "DELETE FROM ingrediente WHERE idIngrediente = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }
}
