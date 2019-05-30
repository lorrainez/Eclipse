package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectDemo01 {
	//通过反射获取类
	public static void demo01() {
		//Class.forName(全类名)
				try {
					Class<?> perClass = Class.forName("reflect.Person");
					System.out.println(perClass);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//类名.class
				Class<?> perClass2 = Person.class;
				System.out.println(perClass2);
				//对象.getClass()
				Person person = new Person();
				Class<?> perClass3 = person.getClass();
				System.out.println(perClass3);
	}
	
	//获取公共方法
	public static void demo02() {
		//class入口
		Class<?> perClass = null;
		try {
			perClass = Class.forName("reflect.Person");
			System.out.println(perClass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//获取所有公共的方法(1本类及父类中接口的所有方法2符合访问修饰符规律)
		Method[] methods = perClass.getMethods();
		for (Method method : methods) {
			System.out.println(method);
		}
		System.out.println("================");
		//获取当前类的所有方法
		Method[] declaredMethods = perClass.getDeclaredMethods();
		for (Method method : declaredMethods) {
			System.out.println(method);
		}
	}
	
	//获取所有的接口
	public static void demo03() {
		//class入口
		Class<?> perClass = null;
		try {
			perClass = Class.forName("reflect.Person");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Class<?>[] interfaces = perClass.getInterfaces();
		//遍历接口
		for (Class<?> inter : interfaces) {
			System.out.println(inter);
		}
	}
	
	//获取所有父类
	public static void demo04() {
		//class入口
		Class<?> perClass = null;
		try {
			perClass = Class.forName("reflect.Person");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Class<?> superclass = perClass.getSuperclass();
		System.out.println(superclass);
	}
	
	//获取所有构造方法
	public static void demo05() {
		//class入口
		Class<?> perClass = null;
		try {
			perClass = Class.forName("reflect.Person");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Constructor<?>[] constructors = perClass.getConstructors();
		for (Constructor<?> constructor : constructors) {
			System.out.println(constructor);
		}
	}
	
	//获取公共属性
	public static void demo06() {
		//class入口
		Class<?> perClass = null;
		try {
			perClass = Class.forName("reflect.Person");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Field[] fields = perClass.getFields();
		for (Field field : fields) {
			System.out.println(field);
		}
		System.out.println("=============");
		Field[] declaredFields = perClass.getDeclaredFields();
		for (Field field : declaredFields) {
			System.out.println(field);
		}
	}
	
	//获取当前反射所代表类(接口)的所有对象(实例)
	public static void demo07() throws InstantiationException, IllegalAccessException {
		//class入口
		Class<?> perClass = null;
		try {
			perClass = Class.forName("reflect.Person");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Object newInstance = perClass.newInstance();
		Person person = (Person)newInstance;//强制转换，如果成功转成Person，说明获得实例
		person.myInterfaceMethod();
	}
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
//		demo01();
//		demo02();
//		demo03();
//		demo04();
//		demo05();
//		demo06();
		demo07();
	}
}
