package UserManagement;

import DataLayer.UserType;

/*
 * Used to create User determined by user type extrapolated from database
 * Users can be "Admin","SuperUser","User"
 */
public class UserFactory {

	/*
	 * Returns Admin,SuperUser or User based on UserType
	 */
	public static User createUser(UserType userType) {

		switch (userType) {

		case Admin:
			return new Admin();
		case SuperUser:
			return new SuperUser();
		case User:
			return new User();
		}

		return null;
	}
}
