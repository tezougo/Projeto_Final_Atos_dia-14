package br.wrr.Entregavel_2_Fabr.Storage;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class ArmazenaArquivos {

  @Value("${Entregavel_2_Fabr.ArmazenaArquivos.raiz}")
  private String raiz;

  @Value("{Entregavel_2_Fabr.ArmazenaArquivos.diretorio-arquivos}")
  private String diretorioArquivos;

  public void salvarArquivos(MultipartFile arquivos){
    this.salvar(this.diretorioArquivos, arquivos);
  }

  public void salvar(String diretorio, MultipartFile arquivo){
    Path diretorioPath = Paths.get(this.raiz, diretorio);
    Path arquivoPath = diretorioPath.resolve(arquivo.getOriginalFilename());

    try {
      Files.createDirectories(diretorioPath);
      arquivo.transferTo(arquivoPath.toFile());

    } catch (Exception e) {
      throw new RuntimeException("Erro, arquivo não pode ser salvo!");
    }
  }
}
