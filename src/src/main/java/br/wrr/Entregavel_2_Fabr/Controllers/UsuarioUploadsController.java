package br.wrr.Entregavel_2_Fabr.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.wrr.Entregavel_2_Fabr.Models.UsuarioUploadsModel;
import br.wrr.Entregavel_2_Fabr.Repositories.UsuarioUploadsRepository;
@RestController
@RequestMapping("/usuariouploads")
public class UsuarioUploadsController {

  @Autowired
  private UsuarioUploadsRepository usuariouploadsRepository;



  @GetMapping("/arquivos")
  public List<UsuarioUploadsModel> getUsuarioUploads(){
    return usuariouploadsRepository.findAll();
  }

  @PostMapping("/uploadarquivo")
  @ResponseStatus(HttpStatus.CREATED)
  public UsuarioUploadsModel uploadarquivo(@RequestBody UsuarioUploadsModel usuariouploadsModel){
    return usuariouploadsRepository.save(usuariouploadsModel);
  }

/*   @DeleteMapping("/video/{video}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteVideo(@PathVariable String video) {
    usuariouploadsRepository.delete(usuariouploadsRepository.getByVideo(video));
  }

  @DeleteMapping("/audio/{audio}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteAudio(@PathVariable String audio){
    usuariouploadsRepository.delete(usuariouploadsRepository.getByAudio(audio));
  } */

  @PutMapping("/atualizaaudio/{audio}")
  public UsuarioUploadsModel putAudio( @PathVariable String audio) {
  UsuarioUploadsModel audio_search = usuariouploadsRepository.findByAudio(audio);
    audio_search.setAudio(audio);
    return usuariouploadsRepository.save(audio_search);
  }

  @PutMapping("/atualizavideo/{video}")
  public UsuarioUploadsModel putVideo( @PathVariable String video) {
    UsuarioUploadsModel video_search = usuariouploadsRepository.findByAudio(video);
    video_search.setAudio(video);
    return usuariouploadsRepository.save(video_search);
  }

  @PutMapping("/removeaudio/{audio}")
  public void removeAudio(@PathVariable String audio) {
    UsuarioUploadsModel audio_search = usuariouploadsRepository.findByAudio(audio);
    if (audio_search != null) {
      audio_search.setAudio(null);
      usuariouploadsRepository.save(audio_search);
      return;
    }
  }

  @PutMapping("/removevideo/{video}")
  public void removeVideo(@PathVariable String video) {
    UsuarioUploadsModel video_search = usuariouploadsRepository.findByVideo(video);
    if (video_search != null) {
      video_search.setVideo(null);
      usuariouploadsRepository.save(video_search);
      return;
    }
/*     c.setTipo(cadastroindividuoModel.getTipo());

    return cadastroindividuoRepository.save(c); */
  }
}
