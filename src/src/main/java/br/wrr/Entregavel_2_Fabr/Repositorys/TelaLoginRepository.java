package br.wrr.Entregavel_2_Fabr.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import br.wrr.Entregavel_2_Fabr.Models.TelaLoginModel;

public interface TelaLoginRepository extends JpaRepository<TelaLoginModel, String> { // usar email como parametro de identificacao

  public TelaLoginModel findByConta(String usuariologar, String senhalogar);

}
