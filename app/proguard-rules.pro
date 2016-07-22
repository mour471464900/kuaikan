# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in C:\android\android develtools\android-sdk-windows/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}
-injars      libs   #配置当前需要导入的Jar文件路径
-outjars     bin/classes-processed.jar //jar文件的输出文件名称

-dontpreverify #不进行预先校验
-allowaccessmodification
-optimizations !code/simplification/arithmetic
-keepattributes *Annotation* #保证使用注解注释的方法不被混淆
#保证某一个具体的类不被混淆
#-keep public class 包名.类名
#-keep 表示某些文件不被混淆
-keep public class * extends android.app.Activity #保证所有的Activity的子类不被混淆
-keep public class * extends android.app.Application#保证application 不被混淆
-keep public class * extends android.app.Service  #保证 service 不被混淆
-keep public class * extends android.content.BroadcastReceiver  #保证BroadcastRecevier
-keep public class * extends android.content.ContentProvider    #保证contentProvider 不被混淆
-keep public class * implements java.io.Serializable    #保证所有实现序列化的类不被混淆
#保证View的子类的构造方法和所有set方法不被混淆
-keep public class * extends android.view.View {
    public <init>(android.content.Context);
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
    public void set*(...);
}

-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet);
}

-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet, int);
}

-keepclassmembers class * implements android.os.Parcelable {
    static android.os.Parcelable$Creator CREATOR;
}

-keepclassmembers class **.R$* {
    public static <fields>;
}

-keepclasseswithmembernames class * {
    native <methods>;
}

-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}
