
package com.portfolio.EduSilva.repository;

import com.portfolio.EduSilva.model.authapp.UserDevice;
import com.portfolio.EduSilva.model.authapp.token.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDeviceRepository extends JpaRepository<UserDevice, Long> {

    @Override
    Optional<UserDevice> findById(Long id);

    Optional<UserDevice> findByRefreshToken(RefreshToken refreshToken);

    Optional<UserDevice> findByUserIdAndDeviceId(Long userId, String userDeviceId);
}
