package com.sunglowsys.service;

import com.sunglowsys.domain.RoomType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface RoomTypeService {

    RoomType saveRoomType(RoomType roomType);

    RoomType updateRoomType(RoomType roomType);

    Page<RoomType> findAll(Pageable pageable);

    Optional<RoomType> findById(Long id);


    void delete(Long id);
}
