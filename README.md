# l-mock
简单的mock工具

## 开始使用
##### 1、通过JrlMockUtil支持方法mock
```java
static class MockTestModel {
    private final String name;
    private final int age;

    public MockTestModel(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        //调用 JrlMockUtil mock方法，如果有配置，则返回配置，否则返回默认值
        return JrlMockUtil.mock(MockTestModel.class, "getName", () -> name);
    }

    public int getAge() {
        //调用 JrlMockUtil mock方法，如果有配置，则返回配置，否则返回默认值
        return JrlMockUtil.mock(MockTestModel.class, "getAge", () -> age);
    }
}
```
##### 2、通过JrlMockUtil进行方法mock
```java
//开启mock
JrlMock.open();
// 配置返回值
JrlMock.doReturn("bbb").when(MockTestModel.class).func("getName");
```
##### 3、调用方法
```java
final MockTestModel model = new MockTestModel("aaa", 1);
Assertions.assertEquals("bbb", model.getName());
```