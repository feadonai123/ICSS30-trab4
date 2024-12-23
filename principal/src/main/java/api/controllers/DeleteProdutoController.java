package api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;

import api.usecases.deleteProduto.DeleteProdutoUsecase;
import api.usecases.deleteProduto.DeleteProdutoOutput;
import api.usecases.deleteProduto.DeleteProdutoInput;
import errors.AplicationError;
import api.base.Controller;
import api.base.ApiResponse;

@CrossOrigin(origins = "*")
@RestController
public class DeleteProdutoController extends Controller<DeleteProdutoInput, DeleteProdutoOutput> {
    @DeleteMapping("/api/produto/{id}")
    public ApiResponse run(@PathVariable("id") String produtoId) throws AplicationError {
        DeleteProdutoInput input = new DeleteProdutoInput();
        input.setProdutoId(produtoId);
        return super.run(input);
    }

    public DeleteProdutoOutput exec(DeleteProdutoInput input) throws AplicationError {
        DeleteProdutoUsecase usecase = new DeleteProdutoUsecase();
        return usecase.run(input);
    }
}
