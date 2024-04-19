package finance.dev.domain.product;

import finance.dev.common.annotation.TypeInfo;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.*;

@TypeInfo(name = "CompanyProductEntity", description = "회사 제품 엔티티 클래스")
@Entity
@Table(name = "company_product")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CompanyProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_idx")
    private int productIdx;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "product_content", nullable = false, length = 2000)
    private String productContent;

    @Column(name = "product_img", nullable = false)
    private String productImg;

    @Column(name = "product_reg_name", nullable = false)
    private String productRegName;

    @Column(name = "product_date", nullable = false)
    private LocalDateTime productDate;

    @Builder
    public CompanyProductEntity(
            String productName,
            String productContent,
            String productImg,
            String productRegName,
            LocalDateTime productDate) {
        this.productName = productName;
        this.productContent = productContent;
        this.productImg = productImg;
        this.productRegName = productRegName;
        this.productDate = productDate;
    }
}
