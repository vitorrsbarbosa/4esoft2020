package singleton.gerenciador;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GerenciadorDePropriedades {
    private static GerenciadorDePropriedades instance = new GerenciadorDePropriedades();
    private Properties propriedades;

    private GerenciadorDePropriedades(){
    }

    public static GerenciadorDePropriedades getInstance() {
        return instance;
    }


    public String getValorDaPropriedade(String propriedade) {
        if (this.propriedades == null || this.propriedades.isEmpty()) {
            this.propriedades = carregaPropriedadesDoArquivo();
        }
        return this.propriedades.getProperty(propriedade);
    }

    private Properties carregaPropriedadesDoArquivo() {
        try (InputStream input = AppGerenciadorDePropriedades.class.getResourceAsStream("config.properties")) {
            Properties properties = new Properties();
            properties.load(input);
            return properties;
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return  null;
    }
}