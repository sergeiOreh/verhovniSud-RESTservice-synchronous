package by.compit.verhovni.sud.util;

import by.compit.verhovni.sud.entity.ErrorMessage;
import by.compit.verhovni.sud.exception.NotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ws.client.WebServiceTransportException;
import org.springframework.ws.soap.client.SoapFaultClientException;

import javax.xml.datatype.DatatypeConfigurationException;
import java.net.ConnectException;

/**
 * Класс SOAPClientErrorHandler - обработчик ошибок, возникающих в SOAP-сервисе
 */
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class SOAPClientErrorHandler {

    private static final Logger logger = LogManager.getLogger();

    private static final int NOT_FOUND_CODE = 404;
    private static final int SOAP_FAULT_CODE = 500;
    private static final int WEB_SERVICE_TRANSPORT_EXCEPTION_CODE = 500;
    private static final int CONNECTION_REFUSED_CODE = 503;
    private static final int INVALID_DATE_PARAMETER_CODE = 400;

    @Value("${not.found.message}")
    private String NOT_FOUND_MESSAGE;
    @Value("${remote.soap.service.connection.exception.message}")
    private String CONNECTION_EXCEPTION_MESSAGE;
    @Value("${remote.soap.service.error.message}")
    private String SOAP_EXCEPTION_MESSAGE;
    @Value("${web.service.transport.exception.message}")
    private String WEB_SERVICE_TRANSPORT_EXCEPTION_MESSAGE;
    @Value("${invalid.date.parameter.message}")
    private String INVALID_DATE_PARAMETER_MESSAGE;

    /**
     * Возвращает сообщение об исключении, возникшем из-за того, что при вызове метода
     * объект не найден
     *
     * @return объекта типа {@link ErrorMessage}
     */
    @SuppressWarnings("Duplicates")
    @ResponseBody
    @ExceptionHandler(NotFoundException.class)
    public ErrorMessage handleNotFoundException() {
        ErrorMessage errorMessage = new ErrorMessage();

        errorMessage.setErrorcode(NOT_FOUND_CODE);
        errorMessage.setMessage(NOT_FOUND_MESSAGE);

        return errorMessage;
    }

    /**
     * Возвращает сообщение об исключении, возникшем из-за того, что при вызове метода
     * ответное сообщение SOAP-сервиса имеет ошибку
     *
     * @return объекта типа {@link ErrorMessage}
     */
    @ResponseBody
    @ExceptionHandler(SoapFaultClientException.class)
    public ErrorMessage handleSoapFaultClientException(SoapFaultClientException ex) {
        logger.error(ex.getFaultStringOrReason(), ex.getCause());

        ErrorMessage errorMessage = new ErrorMessage();

        errorMessage.setErrorcode(SOAP_FAULT_CODE);
        errorMessage.setMessage(SOAP_EXCEPTION_MESSAGE);

        return errorMessage;
    }

    /**
     * Возвращает сообщение об исключении, возникшем из-за того, что произошла ошибка
     * при попытке подключения к SOAP-сервису
     *
     * @return объекта типа {@link ErrorMessage}
     */
    @SuppressWarnings("Duplicates")
    @ResponseBody
    @ExceptionHandler(ConnectException.class)
    public ErrorMessage handleConnectException(ConnectException ex) {
        logger.error(ex.getMessage(), ex.getCause());

        ErrorMessage errorMessage = new ErrorMessage();

        errorMessage.setErrorcode(CONNECTION_REFUSED_CODE);
        errorMessage.setMessage(CONNECTION_EXCEPTION_MESSAGE);

        return errorMessage;
    }

    /**
     * Возвращает сообщение об исключении, возникшем из-за того, что при вызове метода возникла транспортная ошибка
     *
     * @return объекта типа {@link ErrorMessage}
     */
    @ResponseBody
    @ExceptionHandler(WebServiceTransportException.class)
    public ErrorMessage handleWebServiceTransportException(WebServiceTransportException ex) {
        logger.error(ex.getMessage(), ex);

        ErrorMessage errorMessage = new ErrorMessage();

        errorMessage.setErrorcode(WEB_SERVICE_TRANSPORT_EXCEPTION_CODE);
        errorMessage.setMessage(WEB_SERVICE_TRANSPORT_EXCEPTION_MESSAGE + " " + ex.getLocalizedMessage());

        return errorMessage;
    }

    /**
     * Возвращает сообщение об исключении, возникшем из-за того, что при вызове метода
     * введен параметр с неверным форматом даты
     *
     * @return объекта типа {@link ErrorMessage}
     */
    @ResponseBody
    @ExceptionHandler(DatatypeConfigurationException.class)
    public ErrorMessage handleDatatypeConfigurationException(DatatypeConfigurationException ex) {
        logger.error(ex.getMessage(), ex);

        ErrorMessage errorMessage = new ErrorMessage();

        errorMessage.setErrorcode(INVALID_DATE_PARAMETER_CODE);
        errorMessage.setMessage(INVALID_DATE_PARAMETER_MESSAGE);

        return errorMessage;
    }
}
