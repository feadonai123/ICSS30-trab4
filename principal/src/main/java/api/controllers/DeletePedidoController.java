package api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import api.usecases.deletePedido.DeletePedidoUsecase;
import api.usecases.deletePedido.DeletePedidoOutput;
import api.usecases.deletePedido.DeletePedidoInput;
import errors.AplicationError;
import api.base.Controller;
import api.base.ApiResponse;

@RestController
public class DeletePedidoController extends Controller<DeletePedidoInput, DeletePedidoOutput> {
    @DeleteMapping("/api/pedido/{id}")
    public ApiResponse run(@PathVariable("id") String pedidoId) throws AplicationError {
        DeletePedidoInput input = new DeletePedidoInput();
        input.setPedidoId(pedidoId);
        return super.run(input);
    }

    public DeletePedidoOutput exec(DeletePedidoInput input) throws AplicationError {
        DeletePedidoUsecase usecase = new DeletePedidoUsecase();
        return usecase.run(input);
    }
}
