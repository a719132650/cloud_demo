package org.example.gateway.handler;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GatewayExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public void handleBizException(Exception e) {
        System.out.println("===== this is Exception: "+e);
    }

    @ExceptionHandler(value = ArithmeticException.class)
    public void handleBizException(ArithmeticException e) {
        System.out.println("===== this is ArithmeticException: "+e);
    }

}
