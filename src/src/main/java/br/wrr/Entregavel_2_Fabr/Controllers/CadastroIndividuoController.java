package br.wrr.Entregavel_2_Fabr.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.wrr.Entregavel_2_Fabr.Models.CadastroIndividuoModel;
import br.wrr.Entregavel_2_Fabr.Repositorys.CadastroIndividuoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Swagger2RestController", description = "Acessar as funções disponíveis swagger além de realizar o controle dos dados")
@RestController
@RequestMapping("/cadastroindividuo") // para dizer qual a url, quando o spring deve chamar essa página
public class CadastroIndividuoController {

    CadastroIndividuoModel cadastroindividuoModel = new CadastroIndividuoModel();

    @Autowired // instancia a variavel a baixo com a classe repository e todos os metodos
               // disponíveis pela extends do jparepository
    private CadastroIndividuoRepository cadastroindividuoRepository;

    @ApiOperation(value = "Individuos cadastrados", response = Iterable.class, tags = "getAllIndividuos")
    @GetMapping // é usa quando utilizado o metodo get através do extends JpaRepository, fazendo
                // vir direto aqui \/
    public List<CadastroIndividuoModel> getAllIndividuos() {
        return cadastroindividuoRepository.findAll(); // após o autowired é possível usar o metodo findall entre outros
    }

    @ApiOperation(value = "Individuo cadastrado", response = Iterable.class, tags = "getTipo")
    @GetMapping("/{tipo}") // é usa quando utilizado o metodo get através do extends JpaRepository, fazendo
                           // vir direto aqui \/
    public List<CadastroIndividuoModel> getAllTipos(@PathVariable String tipo) {
        return cadastroindividuoRepository.findAllByTipo(tipo); // após o autowired é possível usar o metodo findall entre
        // outros
    }

    public CadastroIndividuoController(CadastroIndividuoRepository cadastroindividuoRepository) {
        this.cadastroindividuoRepository = cadastroindividuoRepository;
    }

    @ApiOperation(value = "Cadastra nome_individuo/tipo", response = Iterable.class, tags = "PostNome/Tipo")
    @PostMapping("/cadastro") // é usado quando utilizado o metodo post através do extends JpaRepository,
    // fazendo vir direto aqui \/
    @ResponseStatus(HttpStatus.CREATED)
    public CadastroIndividuoModel postCadastro(@RequestBody CadastroIndividuoModel cadastro) {
        // o requestbody é utilizado para converter em um objeto java do tipo UrnaModel
        return cadastroindividuoRepository.save(cadastro);
    }

    // @ResponseBody // para não navegar para uma página, se não colocar ele ira
    // procurar uma página
    @ApiOperation(value = "Exclui o cadastro informando o id", response = Iterable.class, tags = "Deletar cadastro")
    @DeleteMapping("/{nome}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCadastro(@PathVariable String nome) {
        
        cadastroindividuoRepository.delete(cadastroindividuoRepository.getByNome(nome));
    }

    @ApiOperation(value = "Retorna o cadastro atualizado", response = Iterable.class, tags = "PutTipo")
    @PutMapping("/{nome}")
    public CadastroIndividuoModel putCadastro(@RequestBody CadastroIndividuoModel cadastroindividuoModel, @PathVariable String nome) {
        CadastroIndividuoModel c = cadastroindividuoRepository.findByNome(nome);
        if (c == null) {
            return null;
        }
        c.setTipo(cadastroindividuoModel.getTipo());

        return cadastroindividuoRepository.save(c);
    }
}
