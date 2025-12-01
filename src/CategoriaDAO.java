import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {

    public void inserir(Categoria c) throws Exception {
        Connection conn = DAO.getConnection();
        String sql = "INSERT INTO categoria (nome, descricao) VALUES (?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, c.getNome());
        stmt.setString(2, c.getDescricao());
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            c.setId(rs.getInt(1));
        }
        rs.close();
        stmt.close();
        conn.close();
    }

    public List<Categoria> listar() throws Exception {
        Connection conn = DAO.getConnection();
        String sql = "SELECT idCategoria, nome, descricao FROM categoria";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        List<Categoria> lista = new ArrayList<>();
        while (rs.next()) {
            lista.add(new Categoria(
                rs.getInt("idCategoria"),
                rs.getString("nome"),
                rs.getString("descricao")
            ));
        }
        rs.close();
        stmt.close();
        conn.close();
        return lista;
    }

    public void atualizar(Categoria c) throws Exception {
        Connection conn = DAO.getConnection();
        String sql = "UPDATE categoria SET nome = ?, descricao = ? WHERE idCategoria = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, c.getNome());
        stmt.setString(2, c.getDescricao());
        stmt.setInt(3, c.getId());
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }

    public void deletar(int id) throws Exception {
        Connection conn = DAO.getConnection();
        String sql = "DELETE FROM categoria WHERE idCategoria = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }
}
