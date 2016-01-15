# ComunicationWithCustomPermission
两个应用直接通过广播通信，以及自定义权限，此工程包含两个APP

##创建广播接收器APP1
创建广播
```java
public class MyBroadCastReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("Josen-----------------",intent.getStringExtra("my_name"));
    }
}
```
在AndroidManifest文件中注册
```java
<!--权限声明-->
    <permission android:name="com.my.permission"></permission>
<application
<receiver android:name=".MyBroadCastReceiver"
            android:permission="my.permission">
            <intent-filter>
                <action android:name="com.my.broadcast"/>
            </intent-filter>
        </receiver>
</application>        
```
这样别的进程（APP2）只要声明了权限
`<uses-permission android:name="com.my.permission"></uses-permission>`
就可以对这个进程（APP1）发送广播
##创建广播发送器APP2
```java
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        btnSendBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setAction("com.my.broadcast");
                intent.putExtra("my_name","Josen");
                sendBroadcast(intent);
            }
        });
```
并且在AndroidManifest中加入权限
`<uses-permission android:name="com.my.permission"></uses-permission>`
这样APP1和APP2就可以通讯了

注：安装的时候要先安装广播接收器APP，否则没法使用
