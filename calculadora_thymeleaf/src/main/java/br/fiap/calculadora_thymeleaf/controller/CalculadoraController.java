package br.fiap.calculadora_thymeleaf.controller;

import br.fiap.calculadora_thymeleaf.service.CalculadoraService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/calculadora")
public class CalculadoraController {
    private final CalculadoraService service;

    public CalculadoraController(CalculadoraService service) {
        this.service = service;
    }

    @GetMapping("/calcular")
    public String calcular(int a, int b, String operacao, Model model){
        model.addAttribute("a", a);
        model.addAttribute("b", b);
        model.addAttribute("operacao", operacao);
        double resultado = service.calcular(a, b, operacao);
        return "index";
    }
}
