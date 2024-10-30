package com.jrl.mock.model;

import java.io.Serializable;

/**
 * mock返回对象
 *
 * @author JerryLong
 */
public class JrlMockResponse<T> implements Serializable {
    private final Boolean isMock;
    private final T result;
    private final Throwable throwable;

    public JrlMockResponse(Boolean isMock, T result, Throwable throwable) {
        this.isMock = isMock;
        this.result = result;
        this.throwable = throwable;
    }

    public Boolean isMock() {
        return isMock;
    }

    public T getResult() {
        if (null != throwable) {
            throw new RuntimeException(throwable);
        }
        return result;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public static <T> JrlMockResponse<T> noMock() {
        return new JrlMockResponse<>(false, null, null);
    }

    public static <T> JrlMockResponse<T> mock(T result) {
        return new JrlMockResponse<>(true, result, null);
    }

    public static <T> JrlMockResponse<T> mock(Throwable throwable) {
        return new JrlMockResponse<>(true, null, throwable);
    }
}
