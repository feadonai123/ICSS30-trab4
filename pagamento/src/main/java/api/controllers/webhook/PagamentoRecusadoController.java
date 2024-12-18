package api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import api.usecases.pagamentoRecusado.PagamentoRecusadoUsecase;
import api.usecases.pagamentoRecusado.PagamentoRecusadoOutput;
import api.usecases.pagamentoRecusado.PagamentoRecusadoInput;
import errors.AplicationError;
import api.base.Controller;
import api.base.ApiResponse;

@RestController
public class PagamentoRecusadoController extends Controller<PagamentoRecusadoInput, PagamentoRecusadoOutput> {
    @PostMapping("/api/webhook/pagamento/recusado")
    public ApiResponse run(@RequestBody PagamentoRecusadoInput input) throws AplicationError {
        return super.run(input);
    }

    public PagamentoRecusadoOutput exec(PagamentoRecusadoInput input) throws AplicationError {
        PagamentoRecusadoUsecase usecase = new PagamentoRecusadoUsecase();
        return usecase.run(input);
    }
}
