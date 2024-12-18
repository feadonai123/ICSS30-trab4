package api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import api.usecases.getPagamento.GetPagamentoUsecase;
import api.usecases.getPagamento.GetPagamentoOutput;
import api.usecases.getPagamento.GetPagamentoInput;
import errors.AplicationError;
import api.base.Controller;
import api.base.ApiResponse;

@RestController
public class GetPagamentoController extends Controller<GetPagamentoInput, GetPagamentoOutput> {
    @GetMapping("/api/pagamento/{id}")
    public ApiResponse run(@PathVariable("id") String pagamentoId) throws AplicationError {
        GetPagamentoInput input = new GetPagamentoInput();
        input.setPagamentoId(pagamentoId);
        return super.run(input);
    }

    public GetPagamentoOutput exec(GetPagamentoInput input) throws AplicationError {
        GetPagamentoUsecase usecase = new GetPagamentoUsecase();
        return usecase.run(input);
    }
}
