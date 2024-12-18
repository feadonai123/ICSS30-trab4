package api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import api.usecases.createProduto.CreateProdutoUsecase;
import api.usecases.createProduto.CreateProdutoOutput;
import api.usecases.createProduto.CreateProdutoInput;
import errors.AplicationError;
import api.base.Controller;
import api.base.ApiResponse;

@RestController
public class CreateProdutoController extends Controller<CreateProdutoInput, CreateProdutoOutput> {
    @PostMapping("/api/produto")
    public ApiResponse run(@RequestBody CreateProdutoInput input) throws AplicationError {
        return super.run(input);
    }

    public CreateProdutoOutput exec(@RequestBody CreateProdutoInput input) throws AplicationError {
        CreateProdutoUsecase usecase = new CreateProdutoUsecase();
        return usecase.run(input);
    }
}
