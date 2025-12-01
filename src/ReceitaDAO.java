import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReceitaDAO {

    public void inserir(Receita r) throws Exception {
        Connection conn = DAO.getConnection();
        String sql = "INSERT INTO receita (titulo, descricao, idCategoria, idUsuario) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, r.getTitulo());
        stmt.setString(2, r.getDescricao());
        if (r.getIdCategoria() == null) {
            stmt.setNull(3, java.sql.Types.INTEGER);
        } else {
            stmt.setInt(3, r.getIdCategoria());
        }
        if (r.getIdUsuario() == null) {
            stmt.setNull(4, java.sql.Types.INTEGER);
        } else {
            stmt.setInt(4, r.getIdUsuario());
        }
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            r.setId(rs.getInt(1));
        }
        rs.close();
        stmt.close();
        conn.close();
    }

    public List<Receita> listar() throws Exception {
        Connection conn = DAO.getConnection();
        String sql = "SELECT idReceita, titulo, descricao, idCategoria, idUsuario FROM receita";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        List<Receita> lista = new ArrayList<>();
        while (rs.next()) {
            Integer idCat = (Integer) rs.getObject("idCategoria");
            Integer idUsu = (Integer) rs.getObject("idUsuario");
            lista.add(new Receita(
                rs.getInt("idReceita"),
                rs.getString("titulo"),
                rs.getString("descricao"),
                idCat,
                idUsu
            ));
        }
        rs.close();
        stmt.close();
        conn.close();
        return lista;
    }

    public void atualizar(Receita r) throws Exception {
        Connection conn = DAO.getConnection();
        String sql = "UPDATE receita SET titulo = ?, descricao = ?, idCategoria = ?, idUsuario = ? WHERE idReceita = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, r.getTitulo());
        stmt.setString(2, r.getDescricao());
        if (r.getIdCategoria() == null) {
            stmt.setNull(3, java.sql.Types.INTEGER);
        } else {
            stmt.setInt(3, r.getIdCategoria());
        }
        if (r.getIdUsuario() == null) {
            stmt.setNull(4, java.sql.Types.INTEGER);
        } else {
            stmt.setInt(4, r.getIdUsuario());
        }
        stmt.setInt(5, r.getId());
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }

    public void deletar(int id) throws Exception {
        Connection conn = DAO.getConnection();
        String sql = "DELETE FROM receita WHERE idReceita = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }
}
