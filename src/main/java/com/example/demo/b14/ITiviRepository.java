package com.example.demo.b14;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ITiviRepository extends JpaRepository<Tivi, Integer> {

    @Query("SELECT t FROM Tivi t ORDER BY t.doPhanGiai DESC")
    Page<Tivi> timTatPhanTrangVaSapXep(Pageable pageable);

    @Query("SELECT t FROM Tivi t WHERE t.tenTivi LIKE :name ORDER BY t.doPhanGiai DESC")
    Page<Tivi> timTheoTenPhanTrangVaSapXep(String name, Pageable pageable);

    @Query("SELECT t FROM Tivi t WHERE t.doPhanGiai = :dpg ORDER BY t.doPhanGiai DESC")
    Page<Tivi> timTheoDoPhanGiaiPhanTrangVaSapXep(Integer dpg, Pageable pageable);

    @Query("""
        SELECT new com.example.demo.b14.TiviResolution(t.doPhanGiai, COUNT(t.doPhanGiai)) FROM Tivi t
        	GROUP BY t.doPhanGiai
    """)
    List<TiviResolution> thongKeDoPhanGiaiCuaTivi();
}
