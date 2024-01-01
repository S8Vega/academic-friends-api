package co.com.ufps.model.consultancy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CountConsultanciesBetweenDateRanges {
    private int day;
    private int week;
    private int month;
    private int semester;
}
