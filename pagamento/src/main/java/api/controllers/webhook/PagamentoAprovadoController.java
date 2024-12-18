package api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import api.usecases.pagamentoAprovado.PagamentoAprovadoUsecase;
import api.usecases.pagamentoAprovado.PagamentoAprovadoOutput;
import api.usecases.pagamentoAprovado.PagamentoAprovadoInput;
import errors.AplicationError;
import api.base.Controller;
import api.base.ApiResponse;

@RestController
public class PagamentoAprovadoController extends Controller<PagamentoAprovadoInput, PagamentoAprovadoOutput> {
    @PostMapping("/api/webhook/pagamento/aprovado")
    public ApiResponse run(@RequestBody PagamentoAprovadoInput input) throws AplicationError {
        return super.run(input);
    }

    public PagamentoAprovadoOutput exec(PagamentoAprovadoInput input) throws AplicationError {
        PagamentoAprovadoUsecase usecase = new PagamentoAprovadoUsecase();
        return usecase.run(input);
    }
}
