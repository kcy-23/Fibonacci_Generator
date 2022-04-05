package com.example.server.Service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.HashMap;

@Service
public class FiboServiceImpl implements FiboService{

    @Override
    public BigInteger generateFibo(BigInteger n, HashMap<BigInteger, BigInteger> cache) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        BigInteger result;
        if (n.equals(BigInteger.valueOf(1))) {
            result = BigInteger.valueOf(1);
        } else if (n.equals(BigInteger.valueOf(2))) {
            result = BigInteger.valueOf(1);
        } else {
            result = generateFibo(n.subtract(BigInteger.valueOf(1)), cache).add(generateFibo(n.subtract(BigInteger.valueOf(2)), cache));
        }

        cache.put(n, result);
        return result;
    }
}
