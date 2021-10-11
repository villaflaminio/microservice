package com.flaminiovilla.bookshare.service;

import com.flaminiovilla.bookshare.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProfileService {

    @Autowired
    ProfileRepository profileRepository;
//
//    public Profile saveProfile(RegisterDTO registerDTO) {
//        return profileRepository.save(Profile.builder()
//                .user(registerDTO.user)
//                .firstName(registerDTO.firstName)
//                .lastName(registerDTO.lastName)
//                .birthday(registerDTO.birthday)
//                .phoneNumber(registerDTO.phoneNumber)
//                .activated(true)
//                .build());
//
//    }
//
//    public Profile saveProfilePut(Long id, Profile profile)  {
//        Optional<Profile> getById = profileRepository.findById(id);
//
//        if (getById.isPresent()) {
//            if (Objects.requireNonNull(Objects.requireNonNull(getById.get().getUser().equals(profile.getUser())))){
//                return profileRepository.save(profile);
//            }
//        }
//        throw new UserException(USER_ALREADY_EXISTS);
//    }
//

}
