package br.wrr.Entregavel_2_Fabr.Models;

import javax.persistence.Column;

public class TelaLoginModel {

  @Column(nullable = true)
  private String usuariologar;
  private String senhalogar;

  public TelaLoginModel(String usuariologar, String senhalogar){
    this.usuariologar = usuariologar;
    this.senhalogar = senhalogar;
  }

  public String getUsuariologar() {
    return usuariologar;
  }

  public void setUsuariologar(String usuariologar) {
    this.usuariologar = usuariologar;
  }

  public String getSenhalogar() {
    return senhalogar;
  }

  public void setSenhalogar(String senhalogar) {
    this.senhalogar = senhalogar;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((senhalogar == null) ? 0 : senhalogar.hashCode());
    result = prime * result + ((usuariologar == null) ? 0 : usuariologar.hashCode());
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
    TelaLoginModel other = (TelaLoginModel) obj;
    if (senhalogar == null) {
      if (other.senhalogar != null)
        return false;
    } else if (!senhalogar.equals(other.senhalogar))
      return false;
    if (usuariologar == null) {
      if (other.usuariologar != null)
        return false;
    } else if (!usuariologar.equals(other.usuariologar))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "TelaLoginModel [usuariologar=" + usuariologar + ", senhalogar=" + senhalogar + "]";
  }

}
