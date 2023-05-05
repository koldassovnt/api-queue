package kz.nkoldassov.apiqueue.db.entity;

import lombok.*;

import java.sql.Timestamp;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ScoreboardEntity {
    private Long id;
    private String code;
    private Timestamp insertedAt;
}
