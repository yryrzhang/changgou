package om.changgou.goods.handler;

import com.changgou.entity.Result;
import com.changgou.entity.StatusCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author : Gordon Zhang
 * @Date: 4/27/2020 2:16 PM
 * @Version 1.0
 */
@ControllerAdvice
public class BaseExceptionHandler {
    @ExceptionHandler
    @ResponseBody
    public Result error(Exception e) {
        e.printStackTrace();
        return new Result(false, StatusCode.ERROR, e.getMessage());
    }
}
