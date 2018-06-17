package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class AvatarFile {

	public static File getAvatar(String user_avatar) throws FileNotFoundException {
		String file = "c:\\wlmtxt\\avatar"+user_avatar;
		FileInputStream fis = new FileInputStream(file);
		return null;
	}
}
