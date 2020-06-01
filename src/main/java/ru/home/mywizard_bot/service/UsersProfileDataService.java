package ru.home.mywizard_bot.service;

import org.springframework.stereotype.Service;
import ru.home.mywizard_bot.model.UserProfileData;
import ru.home.mywizard_bot.repository.UsersProfileMongoRepository;

import java.util.List;

/**
 * Сохраняет, удаляет, ищет анкеты пользователя.
 *
 * @author Sergei Viacheslaev
 */
@Service
public class UsersProfileDataService {

    private UsersProfileMongoRepository profileMongoRepository;

    public UsersProfileDataService(UsersProfileMongoRepository profileMongoRepository) {
        this.profileMongoRepository = profileMongoRepository;
    }

    public List<UserProfileData> getAllProfiles() {
        return profileMongoRepository.findAll();
    }

    public void saveUserProfileData(UserProfileData userProfileData) {
        profileMongoRepository.save(userProfileData);
    }

    public void deleteUsersProfileData(String profileDataId) {
        profileMongoRepository.deleteById(profileDataId);
    }

    public UserProfileData getUserProfileData(long chatId) {
        return profileMongoRepository.findByChatId(chatId);
    }


}
