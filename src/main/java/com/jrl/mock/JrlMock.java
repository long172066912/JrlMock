package com.jrl.mock;

import com.jrl.mock.core.JrlMockRuleBuilder;

/**
 * mock api，用来定义mock规则
 *
 * @author JerryLong
 */
public class JrlMock {

    private static Boolean isOpen = false;

    public static Boolean isOpen() {
        return isOpen;
    }

    /**
     * 开启mock规则
     */
    public static void open() {
        isOpen = true;
    }

    /**
     * 关闭mock规则
     */
    public static void close() {
        isOpen = false;
    }

    /**
     * 设置mock返回值
     *
     * @param obj 返回对象
     * @return {@link JrlMockRuleBuilder.WhenClass}
     */
    public static JrlMockRuleBuilder.WhenClass doReturn(Object obj) {
        return JrlMockRuleBuilder.doSomething().doReturn(obj);
    }

    /**
     * 设置mock异常
     *
     * @param throwable 异常
     * @return {@link JrlMockRuleBuilder.WhenClass}
     */
    public static JrlMockRuleBuilder.WhenClass doThrow(Throwable throwable) {
        return JrlMockRuleBuilder.doSomething().doThrow(throwable);
    }

    /**
     * 设置mock不执行
     *
     * @return {@link JrlMockRuleBuilder.WhenClass}
     */
    public static JrlMockRuleBuilder.WhenClass doNothing() {
        return JrlMockRuleBuilder.doSomething().doNothing();
    }
}
