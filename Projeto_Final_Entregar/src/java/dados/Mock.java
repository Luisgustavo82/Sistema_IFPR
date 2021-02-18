package dados;

import java.util.ArrayList;
import modelos.Projeto;
import modelos.Usuario;

public class Mock {
    static private ArrayList<Usuario> usuarios;
    
    public static ArrayList<Usuario> makeUsuarios(){
                    
        usuarios = new ArrayList(0);

        for(int i=0; i< 10; i++){
            int id = Usuario.lastId + 1;
            Usuario.lastId++;

            Usuario user = new Usuario();
            user.setId(id);
            user.setNome("Fulano"+id+" de Tal");
            user.setEmail("fulano"+id+"@detal.com");
            user.setIdade(30);
            user.setSenha("123"+id);
            user.setProjetos(Mock.makeProjetos());

            user.setBiografia(
                    "Desenvolvedor de Software com 10 de experiência no mercado de "
                            + "produtos de gestão e análise financeira, atuando principalmente"
                            + "com tecnologias Java EE para desenvolvimento de aplicações web e mobile. "
                            + "Experiência em gestão de equipes com metodologia ágil com SCRUM. Graduação "
                            + "em Análise e Desenvolvimento de Sistemas (2010), pós-graduação em Sistemas para"
                            + " Internet (2011) e Gestão de Projetos (2012), certificações ativas OCAJP, OCPJP, OCPJAD e OCMJEA."
            );

            usuarios.add(user);                
        }
        
        return usuarios;
    }
    
    private static ArrayList<Projeto> makeProjetos(){
        ArrayList<Projeto> projetos = new ArrayList();
        
        for(int i=0; i< 2; i++) {
            Projeto p = new Projeto();
            int id = Projeto.lastId + 1;
            Projeto.lastId++;
            
            p.setId(id);            
            p.setTitulo("Plataforma de Análise de Centro de Custos " + id);
            p.setResumo(
                    "Projeto que visou integrar informações do ERP de empresas e fornecer "
                            + "relatório detalhado da distribuição do custo de fabricação "
                            + "por setores da planta industrial. A plataforma foi implementada "
                            + "como uma aplicação Web, permitindo a consulta segura pela cadeia "
                            + "estratégica de resultados em tempo real. Neste projeto, atuei como "
                            + "gestor imediato da equipe de desenvolvimento, não só negociando prazos e metas, "
                            + "mas também decidindo tencologias adequadas às funcionalidades acordadas. "
            );

            p.setLink("https://github.com/gutolpn/");
            p.setCliente("https://londrina.ifpr.edu.br/");
            p.setImagem("https://i.pinimg.com/736x/62/4c/20/624c20fc8b1e5b4e8dca497cc5d29107.jpg");
            
            projetos.add(p);
        }
        
        return projetos;
    }
}
