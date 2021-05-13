package br.wrr.Entregavel_2_Fabr.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.wrr.Entregavel_2_Fabr.Models.NewCadastroModel;
import br.wrr.Entregavel_2_Fabr.Repositorys.NewCadastroRepository;

@CrossOrigin
@RestController
@RequestMapping("/conta")
public class NewCadastroController {

  @Autowired // declara o controle desse objeto para o spring boot
  private NewCadastroRepository newCadastroRepository;

  @GetMapping("/login")
  public List<NewCadastroModel> getNewCadastro(){
    return newCadastroRepository.findAll();
  }

/*   @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public NewCadastroModel postCadastro(@RequestBody NewCadastroModel newCadastroModel){
    return newCadastroRepository.save(newCadastroModel);
  } */


  NewCadastroModel newCadastroModel = new NewCadastroModel();

  // cadastro
  @GetMapping("/newcadastro/{usuario}/{email}/{senha}")
  @ResponseStatus(HttpStatus.CREATED)
  public NewCadastroModel getVerifica_user(@PathVariable String usuario, @PathVariable String email, @PathVariable String senha) {

    Optional<NewCadastroModel> verifica_usuario = newCadastroRepository.findByUsuario(usuario);
    Optional<NewCadastroModel> verifica_email = newCadastroRepository.findByEmail(email);
    /* Optional<NewCadastroModel> email_usuario = newCadastroRepository.findByEmailAndUsuario(email, usuario); */
    if (verifica_usuario.isEmpty() && verifica_email.isEmpty()) {

      System.out.println("Usuario disponível para cadastro!");
/*       verifica_usuario.setEmail(newCadastroModel.getEmail()); */
      /* usuariomodel.setUsuario(newCadastroModel.getUsuario()); */

      NewCadastroModel newcad = new NewCadastroModel();
      newcad.setUsuario(usuario);
      newcad.setEmail(email);
      newcad.setSenha(senha);
      return newCadastroRepository.save(newcad);
  // return newCadastroRepository.save(usuariomodel.orElseThrow(() -> new Exception("Exceção do Wagner!")))
    }else {
      System.out.println("Não foi possível realizar o cadastro, o usuario '" + usuario + "' ou email '" + email + "' já existem!");
      return null;
    }
  }


/*   @GetMapping("/{usuario}")
  public NewCadastroModel getVerifica_user(
      @PathVariable String usuario, @RequestBody NewCadastroModel newCadastroModel) {
    NewCadastroModel verifica_usuario = newCadastroRepository.findByUsuario(usuario);
    if (verifica_usuario == null) {
      System.out.println("Usuario disponível para cadastro!");

      return postCadastro(newCadastroModel);
    }
    System.out.println("Usuario indisponível para cadastro!");
    return verifica_usuario = null;
  } */

/*   public ModelAndView componente2(){

    return new ModelAndView("componente2.component")
  } */
}
