import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            testarUsuario();
            // Para testar outras entidades, descomente:
            // testarCategoria();
            // testarIngrediente();
            // testarReceita();
            // testarComentario();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void testarUsuario() throws Exception {
        UsuarioDAO dao = new UsuarioDAO();

        System.out.println("== Teste Usuario ==");

        Usuario u = new Usuario("Jean", "jean@email");
        dao.inserir(u);
        System.out.println("Inserido ID: " + u.getId());

        List<Usuario> lista = dao.listar();
        for (Usuario x : lista) {
            System.out.println(x);
        }

        u.setNome("Jean Atualizado");
        dao.atualizar(u);
        System.out.println("Atualizado.");

        dao.deletar(u.getId());
        System.out.println("Deletado.");
    }

    private static void testarCategoria() throws Exception {
        CategoriaDAO dao = new CategoriaDAO();
        System.out.println("== Teste Categoria ==");

        Categoria c = new Categoria("Massas", "Receitas de massa");
        dao.inserir(c);
        System.out.println("Inserido ID: " + c.getId());

        for (Categoria x : dao.listar()) {
            System.out.println(x);
        }

        c.setNome("Massas Italianas");
        dao.atualizar(c);
        System.out.println("Atualizado.");

        dao.deletar(c.getId());
        System.out.println("Deletado.");
    }

    private static void testarIngrediente() throws Exception {
        IngredienteDAO dao = new IngredienteDAO();
        System.out.println("== Teste Ingrediente ==");

        Ingrediente i = new Ingrediente("Farinha");
        dao.inserir(i);
        System.out.println("Inserido ID: " + i.getId());

        for (Ingrediente x : dao.listar()) {
            System.out.println(x);
        }

        i.setNome("Farinha de Trigo");
        dao.atualizar(i);
        System.out.println("Atualizado.");

        dao.deletar(i.getId());
        System.out.println("Deletado.");
    }

    private static void testarReceita() throws Exception {
        ReceitaDAO dao = new ReceitaDAO();
        System.out.println("== Teste Receita ==");

        Receita r = new Receita("Bolo Simples", "Misturar tudo", null, null);
        dao.inserir(r);
        System.out.println("Inserido ID: " + r.getId());

        for (Receita x : dao.listar()) {
            System.out.println(x);
        }

        r.setTitulo("Bolo Atualizado");
        dao.atualizar(r);
        System.out.println("Atualizado.");

        dao.deletar(r.getId());
        System.out.println("Deletado.");
    }

    private static void testarComentario() throws Exception {
        ComentarioDAO dao = new ComentarioDAO();
        System.out.println("== Teste Comentario ==");

        // Aqui suponho que exista receita id=1 e usuario id=1
        Comentario c = new Comentario(1, 1, "Muito bom!");
        dao.inserir(c);
        System.out.println("Inserido ID: " + c.getId());

        for (Comentario x : dao.listar()) {
            System.out.println(x);
        }

        c.setConteudo("Excelente!");
        dao.atualizar(c);
        System.out.println("Atualizado.");

        dao.deletar(c.getId());
        System.out.println("Deletado.");
    }
}
