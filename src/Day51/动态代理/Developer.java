package Day51.动态代理;

import java.lang.reflect.Proxy;
import java.util.HashMap;

public interface Developer {
    void code();

    void debug();
}
class JavaDeveloper implements Developer{
    private String name;

    public JavaDeveloper(String name) {
        this.name = name;
    }

    @Override
    public void code() {
        System.out.println(this.name+" is coding java");
    }

    @Override
    public void debug() {
        System.out.println(this.name+" is debugging java");
    }
}
class JavaDynamicProxy{

    private static ThreadLocal threadLocal = new ThreadLocal();

    public static void main(String[] args) {
        JavaDeveloper zhongger = new JavaDeveloper("Zhongger");
        Developer zhonggerProxy = (Developer)Proxy.newProxyInstance(zhongger.getClass().getClassLoader(), zhongger.getClass().getInterfaces(),
                (proxy, method, args1) -> {
                    if (method.getName().equals("code")) {
                        System.out.println("Zhongger is good at coding");
                        return method.invoke(zhongger, args1);
                    }
                    if (method.getName().equals("debug")) {
                        System.out.println("Zhongger is good at debug");
                        return method.invoke(zhongger, args1);
                    }
                    return null;
                });
        zhonggerProxy.code();
        zhonggerProxy.debug();
        threadLocal.set(1);
        Object o = threadLocal.get();
        System.out.println(o);
        HashMap<String, String> map = new HashMap<>();
        map.put("2","hh");
    }
}