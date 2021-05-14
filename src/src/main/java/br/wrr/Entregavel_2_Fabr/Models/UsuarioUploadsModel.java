package br.wrr.Entregavel_2_Fabr.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UsuarioUploadsModel {

  @Id
  @Column(nullable = false)
  private Long id_uploads;

  @Column(nullable = true)
  private String video;
  private String audio;


  public UsuarioUploadsModel(Long id_uploads, String video, String audio) {
    this.id_uploads = id_uploads;
    this.video = video;
    this.audio = audio;
  }


  public Long getId_uploads() {
    return id_uploads;
  }


  public void setId_uploads(Long id_uploads) {
    this.id_uploads = id_uploads;
  }


  public String getVideo() {
    return video;
  }

  public void setVideo(String video) {
    this.video = video;
  }

  public String getAudio() {
    return audio;
  }

  public void setAudio(String audio) {
    this.audio = audio;
  }


  public UsuarioUploadsModel(){

  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((audio == null) ? 0 : audio.hashCode());
    result = prime * result + ((id_uploads == null) ? 0 : id_uploads.hashCode());
    result = prime * result + ((video == null) ? 0 : video.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    UsuarioUploadsModel other = (UsuarioUploadsModel) obj;
    if (audio == null) {
      if (other.audio != null)
        return false;
    } else if (!audio.equals(other.audio))
      return false;
    if (id_uploads == null) {
      if (other.id_uploads != null)
        return false;
    } else if (!id_uploads.equals(other.id_uploads))
      return false;
    if (video == null) {
      if (other.video != null)
        return false;
    } else if (!video.equals(other.video))
      return false;
    return true;
  }

public UsuarioUploadsModel save(UsuarioUploadsModel usuariouploadsModel) {
    return null;
}

}
