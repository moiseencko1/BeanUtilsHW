import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Acer on 01.12.2016.
 */
public class BeanUtils {
    /**
     * Scans object "from" for all getters. If object "to"
     * contains correspondent setter, it will invoke it
     * to set property value for "to" which equals to the property
     * of "from".
     * <p/>
     * The type in setter should be compatible to the value returned
     * by getter (if not, no invocation performed).
     * Compatible means that parameter type in setter should
     * be the same or be superclass of the return type of the getter.
     * <p/>
     * The method takes care only about public methods.
     *
     * @param to   Object which properties will be set.
     * @param from Object which properties will be used to get values.
     */
    public static void assign(Object to, Object from) {
        Method[] methods = to.getClass().getMethods();
        Map<String, Method> setMethodMap = new HashMap<>();
        for (Method method : methods) {
            if (method.getName().startsWith("set"))
                setMethodMap.put(method.getName().substring(3), method);
        }
        methods = from.getClass().getMethods();
        for (Method method : methods) {
            String name = method.getName();
            if (name.startsWith("get")) {
                Method method1 = setMethodMap.get(name.substring(3));
                if (method1 != null)
                    try {
                        method1.invoke(to, method.invoke(from, new Object[0]));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
            }
        }
    }
}