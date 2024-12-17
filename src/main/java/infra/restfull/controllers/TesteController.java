package infra.restfull.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import usecases.teste.TesteUsecase;
import usecases.teste.TesteOutput;
import usecases.teste.TesteInput;
import errors.AplicationError;
import base.Controller;
import base.ApiResponse;

@RestController
public class TesteController extends Controller<TesteInput, TesteOutput> {
    @PostMapping("/api/teste")
    public ApiResponse run(@RequestBody TesteInput input) throws AplicationError {
        return super.run(input);
    }

    public TesteOutput exec(@RequestBody TesteInput input) throws AplicationError {
        TesteUsecase usecase = new TesteUsecase();
        return usecase.run(input);
    }
}
