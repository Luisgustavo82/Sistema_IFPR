package dados;

import com.fasterxml.jackson.dataformat.xml.anntation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.anntation.JacksonXmlRootElement;
import java.util.Map;
import modelos.Usuario;

@JacksonXmlRootElement(localName = "root")
public class UserMap{
    
    int index = 0;
    
    @JacksonXmlProperty(localName = "usuario")
    @JacksonXmlElementWrapper(localName = "usuarios")
    public static Map<Integer, Usuario> usuarios = (Map<Integer, Usuario>) Mock.makeUsuarios();
    
    @Override
    public boolean next(){
        return index < usuarios.size();
    }
    
    @Override
    public Usuario next() {
        if (this.hasNext()){
            return usuarios.get(index++);
        }
        return null;
    }
    @Override
    public void reset(){
        index = 0;
    }

    private boolean hasNext() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
