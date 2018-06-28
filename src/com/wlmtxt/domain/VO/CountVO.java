package com.wlmtxt.domain.VO;

import java.util.List;

import com.wlmtxt.domain.DO.wlmtxt_play_history;
import com.wlmtxt.domain.DO.wlmtxt_user;
import com.wlmtxt.domain.DO.wlmtxt_works;
import com.wlmtxt.domain.DTO.CountDTO;

public class CountVO {
	// 开始时间
	private String start_time = "";
	// 结束时间
	private String stop_time = "";
	
	private int  wlmtxt_worksList;
	private int wlmtxt_play_historyList;
	private int wlmtxt_userList;
	private List<CountDTO> CountDTOList;
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getStop_time() {
		return stop_time;
	}
	public void setStop_time(String stop_time) {
		this.stop_time = stop_time;
	}
	public int getWlmtxt_worksList() {
		return wlmtxt_worksList;
	}
	public void setWlmtxt_worksList(int wlmtxt_worksList) {
		this.wlmtxt_worksList = wlmtxt_worksList;
	}
	public int getWlmtxt_play_historyList() {
		return wlmtxt_play_historyList;
	}
	public void setWlmtxt_play_historyList(int wlmtxt_play_historyList) {
		this.wlmtxt_play_historyList = wlmtxt_play_historyList;
	}
	public int getWlmtxt_userList() {
		return wlmtxt_userList;
	}
	public void setWlmtxt_userList(int wlmtxt_userList) {
		this.wlmtxt_userList = wlmtxt_userList;
	}
	
	public List<CountDTO> getCountDTOList() {
		return CountDTOList;
	}
	public void setCountDTOList(List<CountDTO> countDTOList) {
		CountDTOList = countDTOList;
	}
	@Override
	public String toString() {
		return "CountVO [start_time=" + start_time + ", stop_time=" + stop_time + ", wlmtxt_worksList="
				+ wlmtxt_worksList + ", wlmtxt_play_historyList=" + wlmtxt_play_historyList + ", wlmtxt_userList="
				+ wlmtxt_userList + ", CountDTOList=" + CountDTOList + "]";
	}

	
	
	
}
