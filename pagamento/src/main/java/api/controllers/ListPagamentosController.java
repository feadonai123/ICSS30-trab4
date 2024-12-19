package api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import api.usecases.listPagamentos.ListPagamentosUsecase;
import api.usecases.listPagamentos.ListPagamentosOutput;
import api.usecases.listPagamentos.ListPagamentosInput;
import errors.AplicationError;
import api.base.Controller;
import api.base.ApiResponse;

@RestController
public class ListPagamentosController extends Controller<ListPagamentosInput, ListPagamentosOutput> {
    @GetMapping("/api/pagamentos")
    public ApiResponse run() throws AplicationError {
        ListPagamentosInput input = new ListPagamentosInput();
        return super.run(input);
    }

    public ListPagamentosOutput exec(ListPagamentosInput input) throws AplicationError {
        ListPagamentosUsecase usecase = new ListPagamentosUsecase();
        return usecase.run(input);
    }
}
