package br.wrr.Entregavel_2_Fabr.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.wrr.Entregavel_2_Fabr.Models.TelaLoginModel;

@Repository
public interface TelaLoginRepository extends JpaRepository<TelaLoginModel, String> { // usar email como parametro de identificacao

  public TelaLoginModel findByUsuariologarAndSenhalogar(String usuariologar, String senhalogar);

}
