package br.wrr.Entregavel_2_Fabr.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.wrr.Entregavel_2_Fabr.Models.UsuarioUploadsModel;
import br.wrr.Entregavel_2_Fabr.Repositorys.UsuarioUploadsRepository;

@RestController
@RequestMapping("/usuariouploads")
public class UsuarioUploadsController {

  @Autowired
  private UsuarioUploadsRepository usuariouploadsRepository;

  @GetMapping
  public List<UsuarioUploadsModel> getUsuarioUploads(){

    return usuariouploadsRepository.findAll();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public UsuarioUploadsModel uploadarquivo(@RequestBody UsuarioUploadsModel usuariouploadsModel){

    return usuariouploadsModel.save(usuariouploadsModel);
  }

  @DeleteMapping("/{video}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteVideo(@PathVariable String video) {

    usuariouploadsRepository.delete(usuariouploadsRepository.getByVideo(video));
  }

  @DeleteMapping("/{audio}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteAudio(@PathVariable String audio) {

    usuariouploadsRepository.delete(usuariouploadsRepository.getByAudio(audio));
  }
}
