package br.wrr.Entregavel_2_Fabr.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.wrr.Entregavel_2_Fabr.Models.NewCadastroModel;

@Repository
public interface NewCadastroRepository extends JpaRepository<NewCadastroModel, Long>{

  public Optional<NewCadastroModel> findByUsuario(String usuario);
  public Optional<NewCadastroModel> findByEmail(String email);
  public Optional<NewCadastroModel> findByEmailAndUsuario(String email, String usuario);

}
