#### 1.JS的BOM对象
* **BOM**：Browser Object Model 浏览器对象模型
* **BOM组成**：
    - navigator：获取浏览器的信息 appName
    - screen：获取屏幕信息
    - location：请求url地址
        * href可以获取和设置浏览器地址
    - history：请求url历史记录
        * `back()`：返回上一个页面
        * `forward()`：前进到下一个页面
        * `go(数字)`：-1 ，1 前一个，下一个页面
    - window：窗口对象
        * 窗口对象，BOM操作都是在window中进行的
        * 属性：
    - opener：返回创建当前窗口的窗口对象
* **方法**：
    - `alert()`：警告框
    - `confirm()`：有返回值，可以进行确认
    - `prompt("显示的内容","输入框里的默认值")`：输入对话框
    - `open("网页地址","窗口名称","窗口属性")`：
    - `close( )`：关闭浏览器，兼容性比较差
* **定时器**
    - `setInterval("代码","毫秒数")`：每隔多久就执行一次代码，会有一个返回值id
    - `clearInterval(intervalId)`：interval函数返回的值
    - `setTimeout("代码","毫秒数")` 一段时间后执行一次代码 只执行一次，会有一个返回值id
    - `clearTimeout(timeoutId)`：timeout函数返回的值
    
