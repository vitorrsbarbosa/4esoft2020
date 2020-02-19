package singleton.gerenciador;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GerenciadorDePropriedades {
    private static GerenciadorDePropriedades gerenciadorDePropriedades;

    public static GerenciadorDePropriedades getInstance() {
        if (gerenciadorDePropriedades == null){
            gerenciadorDePropriedades = new GerenciadorDePropriedades();
        }
        return gerenciadorDePropriedades;
    }

    public String getValorDaPropriedade(String propriedade) {
        try (InputStream inputStream = GerenciadorDePropriedades.class.getResourceAsStream("config.properties")) {
            Properties properties = new Properties();

            properties.load(inputStream);

            for (Object key : properties.keySet()) {
                System.out.println(key + " ==> " + properties.getProperty((String) key));
            }

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return propriedade;
    }
}