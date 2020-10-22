package by.compit.verhovni.sud.util;

import by.compit.verhovni.sud.entity.ErrorMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

/**
 * Класс ClientErrorHandler - обработчик ошибок, возникающих по вине пользователя.
 */
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ClientErrorHandler {

    private static final int INVALID_REQUEST_PARAMETER_CODE = 400;
    @Value("${missing.request.parameter.message}")
    private String INVALID_REQUEST_PARAMETER_MESSAGE;

    /**
     * Возвращает сообщение об исключении, возникшем из-за того, что при вызове метода пропущен параметр
     *
     * @return объекта типа {@link ErrorMessage}
     */
    @ResponseBody
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ErrorMessage handleMissingServletRequestParameterException() {
        ErrorMessage errorMessage = new ErrorMessage();

        errorMessage.setErrorcode(INVALID_REQUEST_PARAMETER_CODE);
        errorMessage.setMessage(INVALID_REQUEST_PARAMETER_MESSAGE);

        return errorMessage;
    }

    /**
     * Возвращает сообщение об исключении, возникшем из-за того, что при вызове метода указан неверный тип параметра
     *
     * @return объекта типа {@link ErrorMessage}
     */
    @ResponseBody
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ErrorMessage handleMethodArgumentTypeMismatchException() {
        ErrorMessage errorMessage = new ErrorMessage();

        errorMessage.setErrorcode(INVALID_REQUEST_PARAMETER_CODE);
        errorMessage.setMessage(INVALID_REQUEST_PARAMETER_MESSAGE);

        return errorMessage;
    }

}
