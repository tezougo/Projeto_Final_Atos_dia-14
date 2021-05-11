package br.wrr.Entregavel_2_Fabr.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.wrr.Entregavel_2_Fabr.Models.UsuarioUploadsModel;

@Repository
public interface UsuarioUploadsRepository extends JpaRepository<UsuarioUploadsModel, Long>{

  public UsuarioUploadsModel getByVideo(String video);
  public UsuarioUploadsModel getByAudio(String audio);
}
