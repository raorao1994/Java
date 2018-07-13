package Spring.Service;

import Spring.IService.IFunc;

public class Func implements IFunc {

	public int Add(int x, int y) {
		// TODO 自动生成的方法存根
		System.out.println("执行加法");
		return x+y;
	}

	public int sub(int x, int y) {
		// TODO 自动生成的方法存根
		System.out.println("执行减法");
		return x-y;
	}

}
