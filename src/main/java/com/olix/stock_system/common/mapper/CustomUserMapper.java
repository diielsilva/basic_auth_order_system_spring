package com.olix.stock_system.common.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.olix.stock_system.api.representation.input.SaveUser;
import com.olix.stock_system.api.representation.output.ShowUser;
import com.olix.stock_system.domain.model.CustomUser;

@Component
public class CustomUserMapper {

	public ShowUser fromCustomUserToShowUser(CustomUser customUser) {
		return new ShowUser(customUser.getId(), customUser.getName(), customUser.getUsername(),
				customUser.getRawAuthorities());
	}

	public CustomUser fromSaveUserToCustomUser(SaveUser saveUser) {
		return new CustomUser(null, saveUser.getName(), saveUser.getUsername(), saveUser.getPassword(),
				saveUser.getAuthorities());
	}

	public List<ShowUser> fromCustomUserListToShowUserList(List<CustomUser> customUsers) {
		List<ShowUser> showUserList = new ArrayList<ShowUser>();
		for (CustomUser customUser : customUsers) {
			ShowUser showUser = fromCustomUserToShowUser(customUser);
			showUserList.add(showUser);
		}
		return showUserList;
	}
}
