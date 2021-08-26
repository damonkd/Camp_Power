package com.perscholas.camppower.dao;

import com.perscholas.camppower.models.Booking;
import com.perscholas.camppower.models.Rentals;
import com.perscholas.camppower.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long>{
}
