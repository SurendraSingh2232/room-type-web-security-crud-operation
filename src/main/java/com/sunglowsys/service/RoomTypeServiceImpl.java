package com.sunglowsys.service;

import com.sunglowsys.domain.RoomType;
import com.sunglowsys.repository.RoomTypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class RoomTypeServiceImpl implements RoomTypeService{

    private final Logger logger = LoggerFactory.getLogger(RoomTypeServiceImpl.class);

    private final RoomTypeRepository roomTypeRepository;

    public RoomTypeServiceImpl(RoomTypeRepository roomTypeRepository) {
        this.roomTypeRepository = roomTypeRepository;
    }

    @Override
    public RoomType saveRoomType(RoomType roomType) {
        logger.debug("request to create roomTypes: {} ",roomType);
        return roomTypeRepository.save(roomType);
    }

    @Override
    public RoomType updateRoomType(RoomType roomType) {
        logger.debug("request to update roomTypes: {} ",roomType);
        return roomTypeRepository.save(roomType);
    }

    @Override
    public Page<RoomType> findAll(Pageable pageable) {
        logger.debug("request to getAll roomTypes: {}",pageable.toString());
        return roomTypeRepository.findAll(pageable);
    }

    @Override
    public Optional<RoomType> findById(Long id) {
        logger.debug("request to update roomTypes: {} ",id);
        return roomTypeRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        logger.debug("request to create roomTypes: {} ",id);
        roomTypeRepository.deleteById(id);

    }
}
