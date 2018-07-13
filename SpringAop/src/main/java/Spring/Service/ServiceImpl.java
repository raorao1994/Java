package Spring.Service;


import java.util.List;
import java.util.Map;
import java.util.Set;

import Spring.IDao.IDao;
import Spring.IService.IService;

public class ServiceImpl implements  IService{

    private IDao dao;
    public IDao getDao() {
        return dao;
    }
    public void setDao(IDao dao) {
        this.dao = dao;
    }
    public void service(String name1) {
        System.out.println(dao.sayHello(name1));
        System.out.println("这是我的真实名字"+this.name);
        
        System.out.println("------------------lists-----------------------");
        for(int i=0;i<lists.size();i++)
        {
        	Object obj=lists.get(i);
            System.out.println(obj.getClass().getName());
        }
        System.out.println("--------------------sets---------------------");
        for(Object obj :sets)
        {
            System.out.println(obj.getClass().getName());
        }
        
        System.out.println("--------------------map---------------------");
      //遍历maps中的key
        for (Object key : maps.keySet()) {
            System.out.println("Key = " + key);
        }
        //遍历maps中的值
        for (Object value : maps.values()) {
            System.out.println("Value = " + value);
        }
    }
    
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<Object> getLists() {
		return lists;
	}
	public void setLists(List<Object> lists) {
		this.lists = lists;
	}

	public Set<Object> getSets() {
		return sets;
	}
	public void setSets(Set<Object> sets) {
		this.sets = sets;
	}

	public Map<Object,Object> getMaps() {
		return maps;
	}
	public void setMaps(Map<Object,Object> maps) {
		this.maps = maps;
	}

	private String name;
	
	private List<Object> lists;
	private Set<Object> sets;
	private Map<Object,Object> maps;
	
}
