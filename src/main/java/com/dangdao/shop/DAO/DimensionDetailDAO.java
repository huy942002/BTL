package com.dangdao.shop.DAO;


import com.dangdao.shop.entities.DimensionDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface DimensionDetailDAO extends JpaRepository<DimensionDetail, Integer> {
    @Query("SELECT d FROM DimensionDetail d WHERE d.product.id=?1")
    List<DimensionDetail> findDimensionDetailByProductId(Integer id);

    @Query("SELECT MIN(d.price) FROM DimensionDetail d WHERE d.product.id=?1")
    public Double findByProductMINId(Integer id);

    @Query("SELECT MAX(d.price) FROM DimensionDetail d WHERE d.product.id=?1")
    public Double findByProductMAXId(Integer id);

    @Query("SELECT d FROM DimensionDetail d WHERE d.product.id =?1 AND  d.dimension.id = ?2")
    DimensionDetail findByProductAndDimension(Integer id1,Integer id2);
}
