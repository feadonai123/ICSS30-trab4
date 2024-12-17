package api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import api.usecases.createPedido.CreatePedidoUsecase;
import api.usecases.createPedido.CreatePedidoOutput;
import api.usecases.createPedido.CreatePedidoInput;
import errors.AplicationError;
import api.base.Controller;
import api.base.ApiResponse;

@RestController
public class CreatePedidoController extends Controller<CreatePedidoInput, CreatePedidoOutput> {
    @PostMapping("/api/pedido")
    public ApiResponse run(@RequestBody CreatePedidoInput input) throws AplicationError {
        return super.run(input);
    }

    public CreatePedidoOutput exec(@RequestBody CreatePedidoInput input) throws AplicationError {
        CreatePedidoUsecase usecase = new CreatePedidoUsecase();
        return usecase.run(input);
    }
}
