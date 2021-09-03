package com.xzj.gmall.gmallproduct.config;

import com.xzj.common.config.ExceptionCodeEnume;
import com.xzj.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 集中处理异常
 * @Author: xzj
 * @CreateDate: 2021/9/3 17:17
 */
@Slf4j
@RestControllerAdvice(basePackages = "com.xzj.gmall.gmallproduct.controller")
public class ExcetionAdviceController {
    //    @ExceptionHandler
//    public R handlerException(Exception e){
//        if (e instanceof MethodArgumentNotValidException){
//            BindingResult result = ((MethodArgumentNotValidException) e).getBindingResult();
//            Map<String, String> map = new HashMap<>();
//            for (FieldError resultFieldError : result.getFieldErrors()) {
//                map.put(resultFieldError.getField(),resultFieldError.toString());
//            }
//            return R.error(400,"数据检验检验问题").put("data",map);
//        }
//      log.error("数据校验出现问题:{},{}",e.getMessage(),e.getClass());
//      return R.error();
//    }
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R handlerException(MethodArgumentNotValidException e) {
        Map<String, String> map = new HashMap<>();
        for (FieldError resultFieldError : e.getBindingResult().getFieldErrors()) {
            map.put(resultFieldError.getField(), resultFieldError.toString());
        }
        log.error("数据校验出现问题:{},{}", e.getMessage(), e.getClass());

        return R.error(ExceptionCodeEnume.VAILD_EXCEPTION.getCode(), ExceptionCodeEnume.VAILD_EXCEPTION.getMsg()).put("data", map);

    }

    @ExceptionHandler(value = Throwable.class)
    public R handlerExceptionBig(Throwable throwable) {
        return R.error(ExceptionCodeEnume.UNKNOW_EXCEPTION.getCode(), ExceptionCodeEnume.UNKNOW_EXCEPTION.getMsg());
    }


}
