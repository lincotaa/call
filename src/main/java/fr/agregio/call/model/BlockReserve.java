package fr.agregio.call.model;

import fr.agregio.call.model.dto.rte.MarketTomorrowDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "block_reserve")
public class BlockReserve extends Block {
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "reserve_id", nullable = false)
    private Reserve reserve;

    @Column(name = "bottom_price", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private Double bottomPrice;

    public void computeBottomPrice(MarketTomorrowDto marketTomorrow) {
        //TODO implement method to compute market price
        //Method:
        //1 - Get price corresponding to this step
        //2 - BottomPrice = min(this.productionGroup.getProductionCost(), spotPriceForStep)
        bottomPrice = 0.;
    }
}