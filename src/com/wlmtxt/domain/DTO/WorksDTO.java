package com.wlmtxt.domain.DTO;

import java.util.List;

import com.wlmtxt.domain.DO.wlmtxt_first_menu;
import com.wlmtxt.domain.DO.wlmtxt_second_menu;
import com.wlmtxt.domain.DO.wlmtxt_user;
import com.wlmtxt.domain.DO.wlmtxt_works;

public class WorksDTO {

	private wlmtxt_works works;

	private wlmtxt_second_menu secondMenu;

	private wlmtxt_first_menu firstMenu;
	// 关键词列表
	private List<KeyWordDTO> keyWordDTOList;
	// 作者
	private wlmtxt_user user;
	// 播放数
	private int playNum;
	// 点赞数
	private int likeNum;
	// 收藏数
	private int collectNum;
	// 评论数
	private int discussNum;
	// 热度
	private int hot;

	@Override
	public String toString() {
		return "WorksDTO [works=" + works + ", secondMenu=" + secondMenu + ", firstMenu=" + firstMenu
				+ ", keyWordDTOList=" + keyWordDTOList + ", user=" + user + ", playNum=" + playNum + ", likeNum="
				+ likeNum + ", collectNum=" + collectNum + ", discussNum=" + discussNum + ", hot=" + hot + "]";
	}

	public int getPlayNum() {
		return playNum;
	}

	public void setPlayNum(int playNum) {
		this.playNum = playNum;
	}

	public int getLikeNum() {
		return likeNum;
	}

	public void setLikeNum(int likeNum) {
		this.likeNum = likeNum;
	}

	public int getCollectNum() {
		return collectNum;
	}

	public void setCollectNum(int collectNum) {
		this.collectNum = collectNum;
	}

	public int getDiscussNum() {
		return discussNum;
	}

	public void setDiscussNum(int discussNum) {
		this.discussNum = discussNum;
	}

	public int getHot() {
		return hot;
	}

	public void setHot(int hot) {
		this.hot = hot;
	}

	public wlmtxt_user getUser() {
		return user;
	}

	public void setUser(wlmtxt_user user) {
		this.user = user;
	}

	public wlmtxt_works getWorks() {
		return works;
	}

	public void setWorks(wlmtxt_works works) {
		this.works = works;
	}

	public wlmtxt_second_menu getSecondMenu() {
		return secondMenu;
	}

	public void setSecondMenu(wlmtxt_second_menu secondMenu) {
		this.secondMenu = secondMenu;
	}

	public wlmtxt_first_menu getFirstMenu() {
		return firstMenu;
	}

	public void setFirstMenu(wlmtxt_first_menu firstMenu) {
		this.firstMenu = firstMenu;
	}

	public List<KeyWordDTO> getKeyWordDTOList() {
		return keyWordDTOList;
	}

	public void setKeyWordDTOList(List<KeyWordDTO> keyWordDTOList) {
		this.keyWordDTOList = keyWordDTOList;
	}

}
