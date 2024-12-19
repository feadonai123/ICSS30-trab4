package api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import api.usecases.listEntregas.ListEntregasUsecase;
import api.usecases.listEntregas.ListEntregasOutput;
import api.usecases.listEntregas.ListEntregasInput;
import errors.AplicationError;
import api.base.Controller;
import api.base.ApiResponse;

@RestController
public class ListEntregasController extends Controller<ListEntregasInput, ListEntregasOutput> {
    @GetMapping("/api/entregas")
    public ApiResponse run() throws AplicationError {
        ListEntregasInput input = new ListEntregasInput();
        return super.run(input);
    }

    public ListEntregasOutput exec(ListEntregasInput input) throws AplicationError {
        ListEntregasUsecase usecase = new ListEntregasUsecase();
        return usecase.run(input);
    }
}
