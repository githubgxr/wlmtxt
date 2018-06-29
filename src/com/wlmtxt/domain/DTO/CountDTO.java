package com.wlmtxt.domain.DTO;

import com.wlmtxt.domain.DO.wlmtxt_second_menu;

public class CountDTO {
private int works;
private int history;
private wlmtxt_second_menu second_menu;
public int getWorks() {
	return works;
}
public void setWorks(int works) {
	this.works = works;
}
public int getHistory() {
	return history;
}
public void setHistory(int history) {
	this.history = history;
}

public wlmtxt_second_menu getSecond_menu() {
	return second_menu;
}
public void setSecond_menu(wlmtxt_second_menu second_menu) {
	this.second_menu = second_menu;
}
@Override
public String toString() {
	return "CountDTO [works=" + works + ", history=" + history + ", second_menu=" + second_menu + "]";
}


}
