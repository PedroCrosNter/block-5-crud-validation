package app.block5crudvalidation.student.infrastructure.repository.jpa.entity;

import app.block5crudvalidation.person.infrastructure.repository.jpa.entity.PersonJpa;
import app.block5crudvalidation.shared.enums.Branch;
import app.block5crudvalidation.teacher.infrastructure.repository.jpa.entity.TeacherJpa;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "student")
@Getter
@Setter
public class StudentJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_student")
    private Long idStudent;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_person", nullable = false)
    private PersonJpa personJpa;

    @Column(name = "num_hours_week", nullable = false)
    private Integer numHoursWeek;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_teacher", nullable = false)
    private TeacherJpa teacherJpa;

    @Column(name = "branch", nullable = false)
    @Enumerated(EnumType.STRING)
    private Branch branch;
}