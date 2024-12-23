package api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;

import api.usecases.getPedido.GetPedidoUsecase;
import api.usecases.getPedido.GetPedidoOutput;
import api.usecases.getPedido.GetPedidoInput;
import errors.AplicationError;
import api.base.Controller;
import api.base.ApiResponse;

@CrossOrigin(origins = "*")
@RestController
public class GetPedidoController extends Controller<GetPedidoInput, GetPedidoOutput> {
    @GetMapping("/api/pedido/{id}")
    public ApiResponse run(@PathVariable("id") String pedidoId) throws AplicationError {
        GetPedidoInput input = new GetPedidoInput();
        input.setPedidoId(pedidoId);
        return super.run(input);
    }

    public GetPedidoOutput exec(GetPedidoInput input) throws AplicationError {
        GetPedidoUsecase usecase = new GetPedidoUsecase();
        return usecase.run(input);
    }
}
