package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
//123
public class ReflectDemo02 {
	//��ȡ�����ʵ�����������ö���
	public static void demo01() throws InstantiationException, IllegalAccessException {
		Class<?> perClass = null;
		try {
			perClass = Class.forName("reflect.Person");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Person person = (Person)perClass.newInstance();
		person.setName("zs");
		person.setAge(22);
		System.out.println(person.getName()+", "+person.getAge());
	}
	
	//��������
	public static void demo02() throws InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
		Class<?> perClass = null;
		try {
			perClass = Class.forName("reflect.Person");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Person person = (Person)perClass.newInstance();
		Field idField = perClass.getDeclaredField("id");
		//���ʵ���private���ε�id����private��˽�е�
		//�޸����Եķ���Ȩ��
		idField.setAccessible(true);
		idField.set(person, 1);//�൱�ڵ�����person.setId(1);
		System.out.println(person.getId());
		System.out.println("============");
		Method method = perClass.getDeclaredMethod("privateMethod", null);
		method.setAccessible(true);
		method.invoke(person, null);
		System.out.println("============");
		Method method2 = perClass.getDeclaredMethod("privateMethod2", String.class);
		method2.setAccessible(true);
		method2.invoke(person, "lori");
	}
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
//		demo01();
		demo02();
	}
}
