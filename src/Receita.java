public class Receita {

    private int id;
    private String titulo;
    private String descricao;
    private Integer idCategoria;
    private Integer idUsuario;

    public Receita() { }

    public Receita(int id, String titulo, String descricao, Integer idCategoria, Integer idUsuario) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.idCategoria = idCategoria;
        this.idUsuario = idUsuario;
    }

    public Receita(String titulo, String descricao, Integer idCategoria, Integer idUsuario) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.idCategoria = idCategoria;
        this.idUsuario = idUsuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public String toString() {
        return id + " - " + titulo;
    }
}
