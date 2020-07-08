package com.bsa.springdata.user;

import com.bsa.springdata.office.OfficeRepository;
import com.bsa.springdata.team.TeamRepository;
import com.bsa.springdata.user.dto.CreateUserDto;
import com.bsa.springdata.user.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OfficeRepository officeRepository;

    @Autowired
    private TeamRepository teamRepository;

    public Optional<UUID> safeCreateUser(CreateUserDto userDto) {
        var office = officeRepository.findById(userDto.getOfficeId());
        var team = teamRepository.findById((userDto.getTeamId()));

        return office.flatMap(o -> team.map(t -> {
            var user = User.fromDto(userDto, o, t);
            var result = userRepository.save(user);
            return result.getId();
        }));
    }

    public Optional<UUID> createUser(CreateUserDto userDto) {
        try {
            var office = officeRepository.getOne(userDto.getOfficeId());
            var team = teamRepository.getOne(userDto.getTeamId());

            var user = User.fromDto(userDto, office, team);
            var result = userRepository.save(user);
            return Optional.of(result.getId());
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public Optional<UserDto> getUserById(UUID id) {
        return userRepository.findById(id).map(UserDto::fromEntity);
    }

    public List<UserDto> getUsers() {
        return userRepository
                .findAll()
                .stream()
                .map(UserDto::fromEntity)
                .collect(Collectors.toList());
    }

    public List<UserDto> findByLastName(String lastName, int page, int size) {
        // TODO: Use a single query. Use class Sort to sort users by last name. Try to avoid @Query annotation here
        return null;
    }

    public List<UserDto> findByCity(String city) {
        // TODO: Use a single query. Sort users by last name
        return null;
    }

    public List<UserDto> findByExperience(int experience) {
        // TODO: Use a single query. Sort users by experience by descending. Try to avoid @Query annotation here
        return null;
    }

    public List<UserDto> findByRoomAndCity(String city, String room) {
        // TODO: Use a single query. Use class Sort to sort users by last name.
        return null;
    }

    public int deleteByExperience(int experience) {
        // TODO: Use a single query. Return a number of deleted rows
        return 0;
    }
}
