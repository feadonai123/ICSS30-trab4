package api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;

import api.usecases.getProduto.GetProdutoUsecase;
import api.usecases.getProduto.GetProdutoOutput;
import api.usecases.getProduto.GetProdutoInput;
import errors.AplicationError;
import api.base.Controller;
import api.base.ApiResponse;

@CrossOrigin(origins = "*")
@RestController
public class GetProdutoController extends Controller<GetProdutoInput, GetProdutoOutput> {
    @GetMapping("/api/produto/{id}")
    public ApiResponse run(@PathVariable("id") String produtoId) throws AplicationError {
        GetProdutoInput input = new GetProdutoInput();
        input.setProdutoId(produtoId);
        return super.run(input);
    }

    public GetProdutoOutput exec(GetProdutoInput input) throws AplicationError {
        GetProdutoUsecase usecase = new GetProdutoUsecase();
        return usecase.run(input);
    }
}
