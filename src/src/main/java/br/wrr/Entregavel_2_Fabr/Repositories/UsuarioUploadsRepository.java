package br.wrr.Entregavel_2_Fabr.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.wrr.Entregavel_2_Fabr.Models.UsuarioUploadsModel;

@Repository
public interface UsuarioUploadsRepository extends JpaRepository<UsuarioUploadsModel, Long>{

  public UsuarioUploadsModel findByVideo(String video);
  public UsuarioUploadsModel findByAudio(String audio);
}
