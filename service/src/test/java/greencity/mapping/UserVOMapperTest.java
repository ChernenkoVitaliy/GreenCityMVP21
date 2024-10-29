package greencity.mapping;

import greencity.ModelUtils;
import greencity.dto.user.UserVO;
import greencity.entity.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserVOMapperTest {
    @InjectMocks
    UserVOMapper mapper;

    @Test
    void convert() {
        UserVO expected = ModelUtils.getUserVOWithData();

        User userToBeConverted = User.builder()
                .id(expected.getId())
                .name(expected.getName())
                .email(expected.getEmail())
                .role(expected.getRole())
                .userCredo(expected.getUserCredo())
                .firstName(expected.getFirstName())
                .city(expected.getCity())
                .emailNotification(expected.getEmailNotification())
                .dateOfRegistration(expected.getDateOfRegistration())
                .profilePicturePath(expected.getProfilePicturePath())
                .refreshTokenKey(expected.getRefreshTokenKey())
                .userStatus(expected.getUserStatus())
                .rating(expected.getRating())
                .verifyEmail(expected.getVerifyEmail() != null ? VerifyEmail.builder()
                        .id(expected.getVerifyEmail().getId())
                        .user(User.builder()
                                .id(expected.getVerifyEmail().getUser().getId())
                                .name(expected.getVerifyEmail().getUser().getName())
                                .build())
                        .expiryDate(expected.getVerifyEmail().getExpiryDate())
                        .token(expected.getVerifyEmail().getToken())
                        .build() : null)
                .showShoppingList(expected.getShowShoppingList())
                .showEcoPlace(expected.getShowEcoPlace())
                .showLocation(expected.getShowLocation())
                .ownSecurity(expected.getOwnSecurity() != null ? OwnSecurity.builder()
                        .id(expected.getOwnSecurity().getId())
                        .password(expected.getOwnSecurity().getPassword())
                        .user(User.builder()
                                .id(expected.getOwnSecurity().getUser().getId())
                                .email(expected.getOwnSecurity().getUser().getEmail())
                                .build())
                        .build() : null)
                .lastActivityTime(expected.getLastActivityTime())
                .build();
        assertEquals(expected, mapper.convert(userToBeConverted));
    }
}