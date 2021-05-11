package br.wrr.Entregavel_2_Fabr.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.wrr.Entregavel_2_Fabr.Models.TelaLoginModel;
import br.wrr.Entregavel_2_Fabr.Repositorys.TelaLoginRepository;

@RestController
@RequestMapping("/login")
public class TelaLoginController {

/////////////////////////

TelaLoginModel telaloginModel = new TelaLoginModel(null, null);

@Autowired // instancia a variavel a baixo com a classe repository e todos os metodos
           // disponíveis pela extends do jparepository
private TelaLoginRepository telaLoginRepository;

/* @ApiOperation(value = "Individuos cadastrados", response = Iterable.class, tags = "getAll") */
@GetMapping // é usa quando utilizado o metodo get através do extends JpaRepository, fazendo
            // vir direto aqui \/
public List<TelaLoginModel> getAll() {
  return telaLoginRepository.findAll(); // após o autowired é possível usar o metodo findall entre outros
}

/* @ApiOperation(value = "Individuo cadastrado", response = Iterable.class, tags = "getTipo")
@GetMapping("/{tipo}") // é usado quando utilizado o metodo get através do extends JpaRepository, fazendo
                       // vir direto aqui \/
public List<CadastroIndividuoModel> getAllTipos(@PathVariable String tipo) {
  return cadastroindividuoRepository.findAllByTipo(tipo); // após o autowired é possível usar o metodo findall entre
  // outros
} */

public TelaLoginController(TelaLoginRepository telaLoginRepository) {
        this.telaLoginRepository = telaLoginRepository;
    }

/* @ApiOperation(value = "Cadastra nome_individuo/tipo", response = Iterable.class, tags = "PostNome/Tipo")
@PostMapping("/cadastro") // é usado quando utilizado o metodo post através do extends JpaRepository,
// fazendo vir direto aqui \/
@ResponseStatus(HttpStatus.CREATED)
public CadastroIndividuoModel postCadastro(@RequestBody CadastroIndividuoModel cadastro) {
  // o requestbody é utilizado para converter em um objeto java do tipo UrnaModel
  return cadastroindividuoRepository.save(cadastro);
} */

// @ResponseBody // para não navegar para uma página, se não colocar ele ira
// procurar uma página
/* @ApiOperation(value = "Exclui o cadastro informando o id", response = Iterable.class, tags = "Deletar cadastro")
@DeleteMapping("/{nome}")
@ResponseStatus(HttpStatus.NO_CONTENT)
public void deleteCadastro(@PathVariable String nome) {

  cadastroindividuoRepository.delete(cadastroindividuoRepository.getByNome(nome));
}
 */
/* @ApiOperation(value = "Retorna o cadastro atualizado", response = Iterable.class, tags = "PutTipo") */
@GetMapping("/{usuariologar},{senhalogar}")
public TelaLoginModel verificaUsuario(@RequestBody TelaLoginModel TelaLoginModel,
    @PathVariable String usuariologar, String senhalogar) {
  TelaLoginModel verifica = telaLoginRepository.findByConta(usuariologar, senhalogar);
  if (verifica == null) {
    System.out.println("Usuario ou senha incorretos!");
    return null;
  }
  System.out.println("Usuario encontrado!");
  return new TelaLoginModel( usuariologar, senhalogar);
  // se não for nulo entao existe um usuário e então loga no banco

/*   verifica.setTipo(cadastroindividuoModel.getTipo());

  return cadastroindividuoRepository.save(c); */
}

/////////////////////////

/*   @GetMapping("")
  public ModelAndView component(){

    return new ModelAndView("app.component") }*/
}

