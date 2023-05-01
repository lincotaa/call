package fr.agregio.call.model;

import fr.agregio.call.service.dto.rte.MarketTomorrowDto;
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
@Table(name = "block_reserve", indexes = {
        @Index(name = "idx_day", columnList = "day"),
        @Index(name = "idx_step", columnList = "step"),
        @Index(name = "idx_call", columnList = "call")
        })
public class BlockReserve extends Block {
    @Column(name = "bottom_price", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private Double bottomPrice;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "call_id", nullable = false)
    private Call call;

    public void computeBottomPrice(MarketTomorrowDto marketTomorrow) {
        //TODO implement method to compute market price
        //Method:
        //1 - Get price corresponding to this step
        //2 - BottomPrice = min(this.productionGroup.getProductionCost(), spotPriceForStep)
        bottomPrice = 0.;
    }
}