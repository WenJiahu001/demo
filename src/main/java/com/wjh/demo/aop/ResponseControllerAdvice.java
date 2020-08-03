package com.wjh.demo.aop;

/**
 * 统一返回值 在renturn之前 重新组装数据返回
 * author wjh
 */
//@RestControllerAdvice(basePackages = "com")
//public class ResponseControllerAdvice implements ResponseBodyAdvice<Object> {
//    @Override
//    public boolean supports(MethodParameter methodParameter, Class aClass) {
//        // 如果接口返回的类型本身就是ResultVO那就没有必要进行额外的操作，返回false
//        return !methodParameter.getGenericParameterType().equals(ResultVO.class);
//    }
//
//    @SneakyThrows
//    @Override
//    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
//        if (o instanceof String)
//            return new ObjectMapper().writeValueAsString(new ResultVO((String) o));
//        else
//            return new ResultVO(o);
//    }
//}
