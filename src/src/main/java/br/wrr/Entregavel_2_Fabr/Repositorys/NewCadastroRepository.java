package br.wrr.Entregavel_2_Fabr.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.wrr.Entregavel_2_Fabr.Models.NewCadastroModel;

@Repository
public interface NewCadastroRepository extends JpaRepository<NewCadastroModel, Long>{

  public NewCadastroModel findByUsuario(String usuario);
  public NewCadastroModel findByEmail(String email);
  public NewCadastroModel getByEmail(String email);
}
