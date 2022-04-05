import axios from "axios";

const API_BASE_URL = "http://localhost:8080/api/fibo";

const getFibonacciNumber = (number) => {
  return axios.get(API_BASE_URL + "/" + number);
};

const FibonacciService = {
  getFibonacciNumber,
};

export default FibonacciService;
