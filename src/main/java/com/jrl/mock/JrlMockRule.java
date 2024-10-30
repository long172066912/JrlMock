package com.jrl.mock;

import java.util.concurrent.TimeUnit;

/**
 * mock api，用来定义mock规则
 *
 * @author JerryLong
 */
public interface JrlMockRule {

    /**
     * 开启mock规则
     */
    void open();

    /**
     * 关闭mock规则
     */
    void close();

    /**
     * 设置mock返回值
     *
     * @param obj 返回对象
     * @return ZeusMockRule
     */
    JrlMockRule doReturn(Object obj);

    /**
     * 设置mock异常
     *
     * @param throwable 异常
     * @return ZeusMockRule
     */
    JrlMockRule doThrow(Throwable throwable);

    /**
     * 设置mock不执行
     *
     * @return ZeusMockRule
     */
    JrlMockRule doNothing();

    /**
     * 设置mock执行class类型
     *
     * @param clazz 类
     * @return ZeusMockRule
     */
    JrlMockRule when(Class<?> clazz);

    /**
     * 设置mock执行方法
     *
     * @param methods 方法
     * @return ZeusMockRule
     */
    JrlMockRule when(String... methods);

    /**
     * 设置mock执行时间
     *
     * @param min 最小值
     * @param max 最大值
     * @param timeUnit 时间单位
     * @return ZeusMockRule
     */
    JrlMockRule time(int min, int max, TimeUnit timeUnit);

    /**
     * 获取mock返回值
     *
     * @return Object
     */
    Object getDoReturn();

    /**
     * 获取mock异常
     *
     * @return Throwable
     */
    Throwable getDoThrow();

    /**
     * 获取mock不执行
     *
     * @return Boolean
     */
    Boolean getDoNothing();

    /**
     * 睡眠
     */
    void sleep();
}
