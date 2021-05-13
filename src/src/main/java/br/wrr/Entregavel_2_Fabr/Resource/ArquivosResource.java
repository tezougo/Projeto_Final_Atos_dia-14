package br.wrr.Entregavel_2_Fabr.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.wrr.Entregavel_2_Fabr.Storage.ArmazenaArquivos;

@RestController
@RequestMapping("/salvaarquivos")
public class ArquivosResource {

  @Autowired
  private ArmazenaArquivos armazenaArquivos;

  // salvando arquivo no local
  @PostMapping("/upload")
  public void postUpload(@RequestParam MultipartFile arquivoselecionado) {
    armazenaArquivos.salvarArquivos(arquivoselecionado);
  }
}
