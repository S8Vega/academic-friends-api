package co.com.ufps.model.course;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Course {
    private String code;
    private String name;
    private int semester;
    private int credits;

    public static Course fromMap(Map<String, Object> map) {
        return Course.builder()
                .code(String.valueOf(Double.valueOf(map.get("code").toString()).intValue()))
                .name((String) map.get("name"))
                .semester(Double.valueOf(map.get("semester").toString()).intValue())
                .credits(Double.valueOf(map.get("credits").toString()).intValue())
                .build();
    }
}
