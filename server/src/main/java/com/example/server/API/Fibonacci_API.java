package com.example.server.API;

import com.example.server.Service.FiboService;
import com.example.server.Service.FiboServiceImpl;
import com.fasterxml.jackson.databind.node.BigIntegerNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigInteger;
import java.util.HashMap;

@RestController
@CrossOrigin("http://localhost:3000/")
@RequestMapping("/api/fibo")
public class Fibonacci_API {

    @Autowired
    private FiboService fs;

    @GetMapping("/{number}")
    private ResponseEntity getFibonacciNumber(@PathVariable String number) throws Exception {
        try {
            BigInteger n = new BigInteger(number);

            if (n.signum() != 1) {
                String negativeMsg = "Only non-zero and positive input are allowed";
                throw new ResponseStatusException(HttpStatus.FORBIDDEN, negativeMsg);
            }

            if (n.compareTo(BigInteger.valueOf(1476)) == 1) {
                String outOfRangeMsg = "Input cannot exceed 1476";
                throw new ResponseStatusException(HttpStatus.FORBIDDEN, outOfRangeMsg);
            }

            HashMap<BigInteger, BigInteger> cache = new HashMap<>();
            BigInteger result = fs.generateFibo(n, cache);

            return ResponseEntity.status(HttpStatus.OK)
                    .body(result);
        } catch (NumberFormatException e) {
            String nonNumericMsg = "Only numerics input are allowed";
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, nonNumericMsg, e);
        }
    }
}
