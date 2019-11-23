package ideation.platform.api.attachments;

import ideation.platform.api.ideation.Idea;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "attachments")
public class Attachment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Range(max = 4294967295L)
    @Column(nullable = false, updatable = false, unique = true)
    private Long id;

    @Column(name = "uuid", updatable = false, nullable = false, unique = true, columnDefinition = "BINARY(16)")
    private UUID uuid;

    @OneToOne
    private Idea idea;

    @NotNull
    @Enumerated(EnumType.ORDINAL)
    private AttachmentType type;

    private LocalDateTime stampCreated;

    private String belongsToType;
    private UUID   belongsToUUID;

}
