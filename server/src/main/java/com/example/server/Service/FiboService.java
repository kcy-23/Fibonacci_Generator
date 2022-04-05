package com.example.server.Service;

import java.math.BigInteger;
import java.util.HashMap;

public interface FiboService {

    BigInteger generateFibo(BigInteger n, HashMap<BigInteger, BigInteger> cache);
}
