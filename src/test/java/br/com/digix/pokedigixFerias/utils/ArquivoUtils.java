package br.com.digix.pokedigixFerias.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ArquivoUtils {

    public static byte[] abrirArquivo(String caminhoPath) throws IOException {
        return Files.readAllBytes(Paths.get(caminhoPath));
    }

}
