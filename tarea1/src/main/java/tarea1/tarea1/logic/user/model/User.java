package tarea1.tarea1.logic.user.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tarea1.tarea1.logic.role.model.Role;


@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(
        name = "users",
        indexes = {
                @Index(name = "idx_users_role_id", columnList = "role_id")
        }
)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true, length = 120)
    private String email;

    @Column(nullable = false, length = 200)
    @NotBlank
    @Pattern(
            regexp = "^\\$2[aby]\\$\\d{2}\\$[./A-Za-z0-9]{53}$",
            message = "Hash bcrypt inválido"
    )
    private String password;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;


}
