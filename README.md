<h1 align="center">Slate Engine</h1>

<p align="center">
  <img src="icon.png" width="128">
</p>

![License](https://img.shields.io/badge/License-PolyForm%20Noncommercial%201.0.0-blue)
![Java](https://img.shields.io/badge/Java-21-007396?style=flat&logo=openjdk&logoColor=white)
![Status](https://img.shields.io/badge/status-pre--alpha-darkred)
[![Latest Release](https://img.shields.io/github/v/release/breadcat-dev/slate-engine?style=flat&logo=github&color=blue)](https://github.com/breadcat-dev/slate-engine)
[![Downloads](https://img.shields.io/github/downloads/breadcat-dev/slate-engine/total?style=flat&logo=github&color=brightgreen)](https://github.com/breadcat-dev/slate-engine)
[![Stars](https://img.shields.io/github/stars/breadcat-dev/slate-engine?style=flat&logo=github&color=yellow)](https://github.com/breadcat-dev/slate-engine)

---

## Installation

### Requirements

- Java JDK 21+
- Gradle 9.3.0+ (included)
- Git

Currently, Slate Engine is not on Maven Central.
To use it, clone the repository and publish it to your local Maven repository.

### Linux / MacOS

```sh
git clone https://github.com/breadcat-dev/slate-engine.git
cd slate-engine
./gradlew publishToMavenLocal
```

### Windows

```sh
git clone https://github.com/breadcat-dev/slate-engine.git
cd slate-engine
./gradlew.bat publishToMavenLocal
```

Once installed, add the dependency:

### Groovy
```gradle
implementation "cat.breadcat.slate:engine:<version>"
```

### Kotlin
```gradle
implementation("cat.breadcat.slate:engine:<version>")
```

---

## Roadmap

- Transform
- Renderable

## Dependencies

- Slate Engine - Math - [Github](https://github.com/breadcat-dev/slate-math)

## License

PolyForm Noncommercial License 1.0.0
