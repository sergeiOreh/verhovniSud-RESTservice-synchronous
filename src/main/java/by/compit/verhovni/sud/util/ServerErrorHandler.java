package by.compit.verhovni.sud.util;

import by.compit.verhovni.sud.entity.ErrorMessage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Класс ServerErrorHandler - обработчик ошибок, возникающих в данном сервисе.
 */
@ControllerAdvice
public class ServerErrorHandler {

    private static final Logger logger = LogManager.getLogger();

    private static final int SERVER_ERROR_CODE = 500;
    @Value("${server.error.message}")
    private String SERVER_ERROR_MESSAGE;

    /**
     * @return объекта типа {@link ErrorMessage}
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ErrorMessage handleConnectException(Exception ex) {
        logger.error(ex);

        ErrorMessage errorMessage = new ErrorMessage();

        errorMessage.setErrorcode(SERVER_ERROR_CODE);
        errorMessage.setMessage(SERVER_ERROR_MESSAGE);

        return errorMessage;
    }
}
