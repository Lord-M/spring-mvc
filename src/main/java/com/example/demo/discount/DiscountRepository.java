package com.example.demo.discount;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface DiscountRepository extends CrudRepository<Discount, Long> {
    // Hibernate: select discount0_.id as id1_2_, discount0_."timestamp" as timestam2_2_, discount0_.description as descript3_2_, discount0_.due_to as due_to4_2_, discount0_.product_id as product_7_2_, discount0_.start_from as start_fr5_2_, discount0_.value_decimal as value_de6_2_ from discounts discount0_ left outer join products product1_ on discount0_.product_id=product1_.id where product1_.id=? and discount0_.start_from<=? and discount0_.due_to>=? order by discount0_.value_decimal desc limit ?
    @Query("select d from Discount d" +
            " where d.product.id = :productId" +
            " and d.startFrom <= current_timestamp" +
            " and d.dueTo >= current_timestamp" +
            " order by d.valueDecimal desc")
//    List<Discount> findActualDiscountsDescOrder(Long productId);
    List<Discount> findActualDiscountsDescOrder(@Param("productId") Long productId);
//    Discount findFirstByProduct_IdAndStartFromLessThanEqualAndDueToGreaterThanEqualOrderByValueDecimalDesc(Long productId, Date currentDate, Date currentDate2);
//    List<Discount> findByProduct_idAnd
}
