package ShallWe.Refactoring.domain.order.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class OrderRequest {
    @NotBlank
    private Long userId;
    @NotBlank
    private String title;
    @NotBlank
    private String description;
    @NotBlank
    private int goalPrice;
    @NotBlank
    private String category;
    private List<String> tags ;
    @NotBlank
    private LocalDateTime endTime;
    private int pay;
}
