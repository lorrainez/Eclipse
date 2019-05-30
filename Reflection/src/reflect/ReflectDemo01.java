package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectDemo01 {
	//ͨ�������ȡ��
	public static void demo01() {
		//Class.forName(ȫ����)
				try {
					Class<?> perClass = Class.forName("reflect.Person");
					System.out.println(perClass);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//����.class
				Class<?> perClass2 = Person.class;
				System.out.println(perClass2);
				//����.getClass()
				Person person = new Person();
				Class<?> perClass3 = person.getClass();
				System.out.println(perClass3);
	}
	
	//��ȡ��������
	public static void demo02() {
		//class���
		Class<?> perClass = null;
		try {
			perClass = Class.forName("reflect.Person");
			System.out.println(perClass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//��ȡ���й����ķ���(1���༰�����нӿڵ����з���2���Ϸ������η�����)
		Method[] methods = perClass.getMethods();
		for (Method method : methods) {
			System.out.println(method);
		}
		System.out.println("================");
		//��ȡ��ǰ������з���
		Method[] declaredMethods = perClass.getDeclaredMethods();
		for (Method method : declaredMethods) {
			System.out.println(method);
		}
	}
	
	//��ȡ���еĽӿ�
	public static void demo03() {
		//class���
		Class<?> perClass = null;
		try {
			perClass = Class.forName("reflect.Person");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Class<?>[] interfaces = perClass.getInterfaces();
		//�����ӿ�
		for (Class<?> inter : interfaces) {
			System.out.println(inter);
		}
	}
	
	//��ȡ���и���
	public static void demo04() {
		//class���
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
	
	//��ȡ���й��췽��
	public static void demo05() {
		//class���
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
	
	//��ȡ��������
	public static void demo06() {
		//class���
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
	
	//��ȡ��ǰ������������(�ӿ�)�����ж���(ʵ��)
	public static void demo07() throws InstantiationException, IllegalAccessException {
		//class���
		Class<?> perClass = null;
		try {
			perClass = Class.forName("reflect.Person");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Object newInstance = perClass.newInstance();
		Person person = (Person)newInstance;//ǿ��ת��������ɹ�ת��Person��˵�����ʵ��
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
