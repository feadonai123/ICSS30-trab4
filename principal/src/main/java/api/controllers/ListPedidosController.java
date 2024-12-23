package api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import api.usecases.listPedidos.ListPedidosUsecase;
import api.usecases.listPedidos.ListPedidosOutput;
import api.usecases.listPedidos.ListPedidosInput;
import errors.AplicationError;
import api.base.Controller;
import api.base.ApiResponse;

@CrossOrigin(origins = "*")
@RestController
public class ListPedidosController extends Controller<ListPedidosInput, ListPedidosOutput> {
    @GetMapping("/api/pedidos")
    public ApiResponse run() throws AplicationError {
        ListPedidosInput input = new ListPedidosInput();
        return super.run(input);
    }

    public ListPedidosOutput exec(ListPedidosInput input) throws AplicationError {
        ListPedidosUsecase usecase = new ListPedidosUsecase();
        return usecase.run(input);
    }
}
