package ru.alex.coffeapp.model.coffee;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.BatchSize;
import org.hibernate.proxy.HibernateProxy;
import ru.alex.coffeapp.model.entity.BaseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "recipe")
public class Recipe implements BaseEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "c_name")
    @Size(max = 255)
    private String name;

    @Column(name = "quantity_buyers")
    @Schema(description = "Количество покупателей")
    private Integer quantityBuyers;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coffee_id", referencedColumnName = "id")
    private Coffee coffee;

    @BatchSize(size = 25)
    @ManyToMany(mappedBy = "recipes", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Ingredient> ingredients = new ArrayList<>();

    @Column(name = "cost", nullable = false)
    private Double cost;

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Recipe recipe = (Recipe) o;
        return getId() != null && Objects.equals(getId(), recipe.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
