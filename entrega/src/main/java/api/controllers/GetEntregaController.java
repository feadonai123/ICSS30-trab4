package api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import api.usecases.getEntrega.GetEntregaUsecase;
import api.usecases.getEntrega.GetEntregaOutput;
import api.usecases.getEntrega.GetEntregaInput;
import errors.AplicationError;
import api.base.Controller;
import api.base.ApiResponse;

@RestController
public class GetEntregaController extends Controller<GetEntregaInput, GetEntregaOutput> {
    @GetMapping("/api/entrega/{id}")
    public ApiResponse run(@PathVariable("id") String entregaId) throws AplicationError {
        GetEntregaInput input = new GetEntregaInput();
        input.setEntregaId(entregaId);
        return super.run(input);
    }

    public GetEntregaOutput exec(GetEntregaInput input) throws AplicationError {
        GetEntregaUsecase usecase = new GetEntregaUsecase();
        return usecase.run(input);
    }
}
