package myobj.phone;

import java.util.Comparator;
import java.util.HashMap;

import quiz.D07_PhoneBook.Info;

public class PhoneB implements Comparable<PhoneB>{
	
	String groupName;
	String name;
	String tel;
	
	static HashMap<String, HashMap<String, Info>> phoneB;
	
	public PhoneB(String groupName, String name, String tel) {
		this.groupName = groupName;
		this.name = name;
		this.tel = tel;
	}
	
	public String getGroup() {
		return groupName;
	}
	
	public String getName() {
		return name;
	}
	
	public String getTel() {
		return tel;
	}
	
	public void addGroup(String group) {
		
	}

	@Override
	public int compareTo(PhoneB o) {
		return this.tel.compareTo(o.tel);
	}
	
	@Override
	public String toString() {
		return String.format("¿Ã∏ß: [%s], tel: [%s] ", name, tel);
	}
}

class ascending implements Comparator<PhoneB> {

	@Override
	public int compare(PhoneB o1, PhoneB o2) {
		if (o1.getName().equals(o2.getName())) {
			return o1.getTel().compareTo(o2.tel);
		}else {
			return o2.tel.compareTo(o1.getTel());
		}
	}
	
}

