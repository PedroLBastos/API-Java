package com.pedro;

import com.pedro.exceptions.UnsupportedMathOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MathController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/sum/{n1}/{n2}")
    public Double sum(@PathVariable(value = "n1") String n1,
                      @PathVariable(value = "n2") String n2 )
    throws Exception{

    if (!isNumeric(n1) || !isNumeric(n2)) {
        throw new UnsupportedMathOperation("Please set a numeric value ");
    }
        return convertToDouble(n1) + convertToDouble(n2) ;
    }

    @GetMapping("/sub/{n1}/{n2}")
    public Double sub(@PathVariable(value = "n1") String n1,
                      @PathVariable(value = "n2") String n2 )
            throws Exception{

        if (!isNumeric(n1) || !isNumeric(n2)) {
            throw new UnsupportedMathOperation("Please set a numeric value ");
        }
        return convertToDouble(n1) - convertToDouble(n2) ;
    }

    @GetMapping("/mult/{n1}/{n2}")
    public Double mult(@PathVariable(value = "n1") String n1,
                      @PathVariable(value = "n2") String n2 )
            throws Exception{

        if (!isNumeric(n1) || !isNumeric(n2)) {
            throw new UnsupportedMathOperation("Please set a numeric value ");
        }
        return convertToDouble(n1) * convertToDouble(n2) ;
    }

    @GetMapping("/div/{n1}/{n2}")
    public Double div(@PathVariable(value = "n1") String n1,
                       @PathVariable(value = "n2") String n2 )
            throws Exception{

        if (!isNumeric(n1) || !isNumeric(n2)) {
            throw new UnsupportedMathOperation("Please set a numeric value ");
        }
        return convertToDouble(n1) / convertToDouble(n2) ;
    }

    @GetMapping("/med/{n1}/{n2}")
    public Double med(@PathVariable(value = "n1") String n1,
                       @PathVariable(value = "n2") String n2 )
            throws Exception{

        if (!isNumeric(n1) || !isNumeric(n2)) {
            throw new UnsupportedMathOperation("Please set a numeric value ");
        }
        return (convertToDouble(n1) + convertToDouble(n2)) /2 ;
    }

    @GetMapping("/raiz/{n1}/{n2}")
    public Double raiz(@PathVariable(value = "n1") String n1)
            throws Exception{

        if (!isNumeric(n1)) {
            throw new UnsupportedMathOperation("Please set a numeric value ");
        }
        return Math.sqrt(convertToDouble(n1));
    }

    private Double convertToDouble(String strNumber) {
        if (strNumber == null) return 0D;
        String number = strNumber.replaceAll(",", ".");
        if (isNumeric(number)) return Double.parseDouble(number);
        return 0D;
    }

    private boolean isNumeric(String strNumber) {
        if (strNumber == null) return false;
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");

    }
}
