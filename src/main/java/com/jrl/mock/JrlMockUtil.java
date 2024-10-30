package com.jrl.mock;

import com.jrl.mock.core.JrlMockRuleFactory;
import com.jrl.mock.model.JrlMockResponse;

import java.util.function.Supplier;

/**
 * mock功能帮助类，用于mock对象，并拿到mock结果
 *
 * @author JerryLong
 */
public class JrlMockUtil {
    /**
     * mock对象与方法
     *
     * @param clazz      对象
     * @param methodName 方法名
     * @param <T>        返回对象类型
     * @return {@link JrlMockResponse}
     */
    public static <T> JrlMockResponse<T> mock(Class<?> clazz, String methodName) {
        return getMockResponse(JrlMockRuleFactory.getMockRule(clazz, methodName));
    }

    /**
     * mock对象与方法
     *
     * @param clazz      对象
     * @param methodName 方法名
     * @param callable   待mock方法
     * @param <T>        返回对象类型
     * @return {@link JrlMockResponse}
     */
    public static <T> T mock(Class<?> clazz, String methodName, Supplier<T> callable) {
        final JrlMockResponse<T> mockResponse = getMockResponse(JrlMockRuleFactory.getMockRule(clazz, methodName));
        if (mockResponse.isMock()) {
            return mockResponse.getResult();
        }
        return callable.get();
    }

    private static <T> JrlMockResponse<T> getMockResponse(JrlMockRule mockRule) {
        if (null == mockRule) {
            return JrlMockResponse.noMock();
        }
        mockRule.sleep();
        if (null != mockRule.getDoNothing() && mockRule.getDoNothing()) {
            return JrlMockResponse.mock(null);
        }
        if (null != mockRule.getDoThrow()) {
            return JrlMockResponse.mock(mockRule.getDoThrow());
        }
        return (JrlMockResponse<T>) JrlMockResponse.mock(mockRule.getDoReturn());
    }
}
