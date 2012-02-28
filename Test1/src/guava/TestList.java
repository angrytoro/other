package guava;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.MapMaker;
import com.google.common.collect.Maps;

public class TestList {

	public static void main(String args[]){
		List<String> list = Lists.newArrayList("1","2");
		Map<Integer,Integer> map = Maps.newConcurrentMap();
		Map hashMap = new HashMap();
		@SuppressWarnings({ "unchecked", "deprecation" })
		ConcurrentMap<String,Integer> cache = new MapMaker().expiration(0, TimeUnit.DAYS).makeComputingMap(new Function(){

			public Object apply(Object input) {
				// TODO Auto-generated method stub
				return null;
			}
			
		});
		Iterator<String> iterator = list.iterator();
		System.out.println(list.get(0));
	}
}
