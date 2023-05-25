package com.example.demo.b8;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ISanPhamRepository extends JpaRepository<SanPham, Integer> {

    List<SanPham> findByTenSanPhamContains(String ten);
}
