package br.wrr.Entregavel_2_Fabr.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.wrr.Entregavel_2_Fabr.Models.NewCadastroModel;
import br.wrr.Entregavel_2_Fabr.Repositorys.NewCadastroRepository;

@RestController
@RequestMapping("/newcadastro")
public class NewCadastroController {

  @Autowired // declara o controle desse objeto para o spring boot
  private NewCadastroRepository newCadastroRepository;

  @GetMapping
  public List<NewCadastroModel> getNewCadastro(){

    return newCadastroRepository.findAll();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public NewCadastroModel postCadastro(@RequestBody NewCadastroModel newCadastroModel){
    return newCadastroRepository.save(newCadastroModel);
  }

  @GetMapping("/{usuario}")
  public NewCadastroModel getVerifica_user(
      @PathVariable String usuario, @RequestBody NewCadastroModel newCadastroModel) {
    NewCadastroModel verifica_usuario = newCadastroRepository.findByUsuario(usuario);
    if (verifica_usuario == null) {
      System.out.println("Usuario disponível para cadastro!");

      return postCadastro(newCadastroModel);
    }
    System.out.println("Usuario indisponível para cadastro!");
    return verifica_usuario = null;
  }

/*   public ModelAndView componente2(){

    return new ModelAndView("componente2.component")
  } */
}
