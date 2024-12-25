package EdTech.Course.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    private Long userId;
    private Long courseId;
    private String date;
    private Long amount;
}
