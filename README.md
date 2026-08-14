# University Management System

![Java](https://img.shields.io/badge/Java-ED8B00?logo=openjdk&logoColor=white)
![OOP](https://img.shields.io/badge/Paradigm-OOP-blue)
![Design Patterns](https://img.shields.io/badge/Design%20Patterns-Singleton%20%7C%20Strategy%20%7C%20Template%20Method-8A2BE2)
![Build](https://img.shields.io/badge/build-javac-success)
![License](https://img.shields.io/badge/License-MIT-green)

A console-based university management system built in pure Java (no frameworks) as an
Object-Oriented Programming final project. It models the real roles and workflows of a
university — students, teachers, admins and managers — behind a role-aware, trilingual
(English / Русский / Қазақша) terminal interface backed by a persistent database.

The project is a deliberate exercise in OOP done properly: a real inheritance hierarchy,
programming to interfaces, three classic design patterns, custom comparators and
exceptions, and object serialization for persistence — ~2,900 lines across 58 classes.

## Why it's interesting

- **Design patterns applied on purpose, not by accident** — Singleton for the datastore and
  session, Template Method for the page-navigation lifecycle, Strategy via pluggable
  `Comparator`s for ranking users and courses.
- **A genuine type hierarchy** — an abstract `User` specialises into `Admin`, `Manager`,
  `Teacher` and `Student`, and `Student` further into `Bachelor`, `Master` and `PhD`, each
  overriding behaviour rather than branching on a type flag.
- **Role-based access** — the same login screen routes each user to a different capability
  set purely through polymorphism (`user instanceof Teacher → TeacherPage`, etc.).
- **Localised at the domain level** — every screen renders in EN / RU / KZ from a single
  `Language` enum.

## Architecture

```
                         ┌──────────────┐
                         │   Main       │  entry point → AuthPage.start()
                         └──────┬───────┘
                                │
              ┌─────────────────▼──────────────────┐
              │  Page  (abstract, Template Method)  │  display() / navigate() / start()
              └───────┬───────────────────┬─────────┘
        AuthPage · HomePage · AdminPage · TeacherPage · StudentPage · ManagerPage · ...
                                │  polymorphic routing by role
              ┌─────────────────▼──────────────────┐
              │  Domain model                       │
              │  User (abstract)                    │
              │   ├── Admin  ├── Manager             │
              │   ├── Teacher (Employee)             │
              │   └── Student → Bachelor/Master/PhD  │
              │  Course · Lesson · Research · News   │
              └─────────────────┬───────────────────┘
                                │
              ┌─────────────────▼───────────────────┐
              │  DB (Singleton, Serializable)        │  users / courses / logs
              │  UserSession (Singleton)             │  auto-persists to ./data
              └──────────────────────────────────────┘
```

## Object-oriented design highlights

| Concept | Where |
|---|---|
| **Abstraction** | `abstract class User`, `abstract class Employee`, `abstract class Page` |
| **Inheritance** | `Student → Bachelor / Master / PhD`; `Teacher extends Employee extends User` |
| **Polymorphism** | role-based page routing in `AuthPage.login()`; overridden `display()` / `navigate()` |
| **Interfaces** | `Researcher`, `CanApplyForInternship`, `Comparator<T>` implementations |
| **Singleton** | `DB.getInstance()`, `UserSession.getInstance()` |
| **Template Method** | `Page` defines the `start()` lifecycle; subclasses fill `display()` / `navigate()` |
| **Strategy** | `StudentGPAComparator`, `CourseCreditComparator`, `UserIdComparator`, `UserNamesComparator` |
| **Encapsulation** | private fields + accessors throughout; password stored only as a SHA-256 hash |
| **Custom exceptions** | `NullMapException` |
| **Enums as domain types** | `Mark`, `School`, `Speciality`, `Semester`, `Language`, `Status`, … (11 total) |
| **Persistence** | Java object serialization (`DB implements Serializable`), auto-save on every mutation |

## Project structure

```
src/
├── NewNav/        Console UI — abstract Page + one page per role (1,300 LOC)
├── Users/         User hierarchy: Admin, Manager, Teacher, Student → Bachelor/Master/PhD
├── Courses/       Course and Lesson models
├── Database/      DB singleton, LogInfo, serialization
├── Enums/         11 domain enums (Mark, School, Speciality, Semester, …)
├── Comparators/   Pluggable ranking strategies (Comparator<User>, Comparator<Course>)
├── Research/      Researcher / CanApplyForInternship interfaces + implementations
├── Notifications/ Message and News
└── exceptions/    NullMapException
```

## Quick start

Requires a JDK (17+ recommended; the code uses no version-specific APIs).

```bash
git clone https://github.com/altairzhambyl/oopfinal.git && cd oopfinal
javac -d bin $(find src -name '*.java')
java -cp bin NewNav.Main
```

On first run the app starts with an empty database and creates a `data` file next to the
working directory to persist users, courses and logs between sessions.

> **Note on security:** this is a learning project. Passwords are hashed with unsalted
> SHA-256 and persisted via Java serialization — fine for a coursework demo, not for
> production. A production version would use a salted adaptive hash (bcrypt/Argon2) and a
> real database. The repository intentionally ships **no** real user data.

## Team

A two-person university project. Both authors' commits are preserved in the git history —
see the contributor graph for the exact split.

- **Altair Zhambyl** ([@altairzhambyl](https://github.com/altairzhambyl)) — authentication &
  login flow, user session, and parts of the user model and page-navigation layer.
- **Zhanibek Sultanbek** ([@ZSultanbek](https://github.com/ZSultanbek)) — majority contributor:
  database & persistence layer, course, research and notification modules, comparators, and
  much of the page UI.

## License

[MIT](LICENSE) © 2024 Altair Zhambyl and the oopfinal contributors
