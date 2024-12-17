package api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import api.usecases.listProdutos.ListProdutosUsecase;
import api.usecases.listProdutos.ListProdutosOutput;
import api.usecases.listProdutos.ListProdutosInput;
import errors.AplicationError;
import api.base.Controller;
import api.base.ApiResponse;

@RestController
public class ListProdutosController extends Controller<ListProdutosInput, ListProdutosOutput> {
    @GetMapping("/api/produtos")
    public ApiResponse run() throws AplicationError {
        ListProdutosInput input = new ListProdutosInput();
        return super.run(input);
    }

    public ListProdutosOutput exec(ListProdutosInput input) throws AplicationError {
        ListProdutosUsecase usecase = new ListProdutosUsecase();
        return usecase.run(input);
    }
}
