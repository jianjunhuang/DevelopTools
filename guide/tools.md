# DevelopTools
some base framework and some useful tools
### 用法
直接下载引入，因为有时候会用到一些分析软件页面跳转的 SDK 所以直接系在引入可以方便修改
## framework
### BaseApplication
初始化了 BaseToast 和 StoreInfo
### BaseActivity
1. 添加 initView 、initListener

2. 设置是否沉浸式（默认开启）
 ```
 //关闭
 setSteepStatuBar(false);
 ```

3. findview
 ```
 Button button = findView(R.id.button);
 ```

4. 显示 Toast
 ```
 //短时 Toast
 showShort("toast");
 showShort(R.string.toast);
 //长时 Toast
 showLong("toast");
 showLong(R.string.toast);
 ```

5. 跳转方法
 ```
 //不带数据跳转
 startActivity(IntentActivity.class);
 //带数据跳转
 startActivity(IntentActivity.class,bundle);
 ```

6. 判空
 ```
 isEmptyOrNull(str);
 ```

### BaseFragment
1. 添加 initView 、 initListener
1. findView
2. 显示 Toast
3. 跳转方法
3. 判空

### BaseToast
需要在 Application 中初始化（默认在 BaseApplication 中已经初始化了）
 ```
 //短时 Toast
 BaseToast.showShort("toast");
 BaseToast.showShort(R.string.toast);
 //长时 Toast
 BaseToast.showLong("toast");
 BaseToast.showLong(R.string.toast);
 ```

## utils

### MD5Util
  ```
  MD5Util.getMD5String(str);
  ```

### NetworkStatus
  ```
  NetWorkStatus netWorkStatus = new NetWorkStatus(context);
  //是否联网
  boolean isNetWork = netWorkStatus.isNetAvilable();

  //判断是否连接了 wifi
  boolean isWifi = netWorkStatus.isWifiConnected();

  /**
   *
   *获取连接的网络
   * TYPE_WIFI 用 wifi
   * TYPE_MOBILE 用流量
   * TYPE_NOCONNECTED 没联网
   */
  int type = netWorkStatus.getNetWorkStatus();

  ```

### StoreInfo
 同样，需要在 Application 中初始化（默认在 BaseApplication 中已经初始化了）
 ```
 StoreInfo.instance().store(key,value);

 StoreInfo.instance().getInfo(key,defaultBack);
 //清除所有存储的信息
 StoreInfo.instance().clearAll();
 //清除对应文件的信息
 StoreInfo.instance().clear(key);
 ```

## adapter
```
CommonAdapter commonAdapter = new CommonAdapter<Bean>(context,list,R.layout.itemlayout){
     @Override public void convert(CommonViewHolder viewHolder, Bean bean, int position) {
                  viewHolder.getView(R.id.xx);
                  viewHolder.setText(R.id.textview, bean.getStr());
                  viewHolder.setImgeResoure(R.id.img, bean.getImg());
                  .
                  .
                  .
                  .
                  .
                  .

                }
};
```