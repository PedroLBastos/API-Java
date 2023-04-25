package com.pedro.controller;

import com.pedro.converts.NumberConverts;
import com.pedro.exceptions.UnsupportedMathOperation;
import com.pedro.math.SimpleMath;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MathController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private SimpleMath math = new SimpleMath();

    @GetMapping("/sum/{n1}/{n2}")
    public Double sum(@PathVariable(value = "n1") String n1,
                      @PathVariable(value = "n2") String n2 )
    throws Exception{

    if (!NumberConverts.isNumeric(n1) || !NumberConverts.isNumeric(n2)) {
        throw new UnsupportedMathOperation("Please set a numeric value ");
    }
        return math.sum(NumberConverts.convertToDouble(n1), NumberConverts.convertToDouble(n2));
    }

    @GetMapping("/sub/{n1}/{n2}")
    public Double sub(@PathVariable(value = "n1") String n1,
                      @PathVariable(value = "n2") String n2 )
            throws Exception{

        if (!NumberConverts.isNumeric(n1) || !NumberConverts.isNumeric(n2)) {
            throw new UnsupportedMathOperation("Please set a numeric value ");
        }
        return math.subtraction(NumberConverts.convertToDouble(n1), NumberConverts.convertToDouble(n2));
    }

    @GetMapping("/mult/{n1}/{n2}")
    public Double mult(@PathVariable(value = "n1") String n1,
                      @PathVariable(value = "n2") String n2 )
            throws Exception{

        if (!NumberConverts.isNumeric(n1) || !NumberConverts.isNumeric(n2)) {
            throw new UnsupportedMathOperation("Please set a numeric value ");
        }
        return math.multiplication(NumberConverts.convertToDouble(n1), NumberConverts.convertToDouble(n2));
    }

    @GetMapping("/div/{n1}/{n2}")
    public Double div(@PathVariable(value = "n1") String n1,
                       @PathVariable(value = "n2") String n2 )
            throws Exception{

        if (!NumberConverts.isNumeric(n1) || !NumberConverts.isNumeric(n2)) {
            throw new UnsupportedMathOperation("Please set a numeric value ");
        }
        return math.division(NumberConverts.convertToDouble(n1), NumberConverts.convertToDouble(n2));
    }

    @GetMapping("/med/{n1}/{n2}")
    public Double med(@PathVariable(value = "n1") String n1,
                       @PathVariable(value = "n2") String n2 )
            throws Exception{

        if (!NumberConverts.isNumeric(n1) || !NumberConverts.isNumeric(n2)) {
            throw new UnsupportedMathOperation("Please set a numeric value ");
        }
        return math.mean(NumberConverts.convertToDouble(n1), NumberConverts.convertToDouble(n2));
    }

    @GetMapping("/raiz/{n1}/{n2}")
    public Double raiz(@PathVariable(value = "n1") String n1)
            throws Exception{

        if (!NumberConverts.isNumeric(n1)) {
            throw new UnsupportedMathOperation("Please set a numeric value ");
        }
        return math.squareRoot(NumberConverts.convertToDouble(n1));
    }

}
