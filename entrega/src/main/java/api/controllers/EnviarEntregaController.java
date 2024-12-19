package api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import api.usecases.enviarEntrega.EnviarEntregaUsecase;
import api.usecases.enviarEntrega.EnviarEntregaOutput;
import api.usecases.enviarEntrega.EnviarEntregaInput;
import errors.AplicationError;
import api.base.Controller;
import api.base.ApiResponse;

@RestController
public class EnviarEntregaController extends Controller<EnviarEntregaInput, EnviarEntregaOutput> {
    @PostMapping("/api/entrega/enviar")
    public ApiResponse run(@RequestBody EnviarEntregaInput input) throws AplicationError {
        return super.run(input);
    }

    public EnviarEntregaOutput exec(EnviarEntregaInput input) throws AplicationError {
        EnviarEntregaUsecase usecase = new EnviarEntregaUsecase();
        return usecase.run(input);
    }
}
