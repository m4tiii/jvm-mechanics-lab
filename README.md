# JVM Mechanics Lab

A comprehensive engineering lab focused on deep core Java mechanics, modern language features, and JVM internals.

This project covers the full technical curriculum of the modern JDK: from advanced type system mechanics and functional programming paradigms, to low-level off-heap memory management, concurrency, runtime diagnostics, cryptography, and modular application design. Every topic is implemented as clean production-grade code and verified with unit test suites using JUnit 5 and AssertJ.

---

## 🗺️ Curriculum & Module Architecture

### 1. Modern Language Features (`/language`)
* **Generics:** Parameterized types, single and multiple bounds, wildcards (`? extends`, `? super`), the PECS principle, and byte-code type erasure mechanisms.
* **Lambda Expressions:** Functional interfaces, closures, method references, and eliminating mutable shared state.
* **Using Pattern Matching:** Pattern matching for `instanceof`, enhanced `switch` expressions and statements, records, and record pattern deconstruction.
* **Refactoring to Functional Style:** Migrating imperative loops and conditional blocks into declarative, side-effect-free stream processing pipelines.
* **Annotations:** Custom metadata declaration, retention policies (`RUNTIME`, `SOURCE`), meta-annotations, and compile-time/runtime processing.
* **Exceptions:** Robust exception hierarchy design, recovery strategies, `try-with-resources`, and suppressed exception management.

### 2. Mastering the JDK API (`/api`)
* **Collections & Streams:** Deep collection internals, custom collector implementations (`Collector`), parallel stream performance, and stream pipeline optimization.
* **Managing Out-of-Memory Data (I/O & FFM API):**
  * Classic Java I/O vs Java NIO.2 (Channels, ByteBuffers, asynchronous file channels).
  * **Foreign Function and Memory (FFM) API:** Safe off-heap memory access (Arenas, MemorySegments) and downcall method handles invoking native C/C++ libraries without JNI.
* **Managing Dates & Regular Expressions:** Modern date-time arithmetic using `java.time` (Zones, Durations, Period), custom temporal adjusters, and regex engine mechanics (`java.util.regex`).
* **Reflection & Method Handles:** Dynamic class inspection, runtime reflection boundaries, and high-performance method invocations using `MethodHandles` and `VarHandle`.
* **Virtual Threads (Project Loom):** High-throughput lightweight concurrency, carrier thread scheduling (M:N model), non-blocking socket operations, pinning diagnostics, and comparisons with platform thread pools.

### 3. Application Architecture & Packaging (`/architecture`)
* **Java Platform Module System (JPMS):** Modular application design using `module-info.java`, strict encapsulation, service providers (`provides`/`uses`), and module boundaries.
* **JLink & Custom Runtime Images:** Building lightweight, zero-dependency customized Java runtime images stripped of unused platform modules.

### 4. JVM Internals & Tooling (`/internals`)
* **Core JDK Tools:** Compilation and analysis toolchain (`javac`, `javap`, `jdeps`, `javadoc`).
* **JFR, Monitoring & Troubleshooting:** Application profiling with **JDK Flight Recorder (JFR)**, performance analysis via JDK Mission Control (JMC), and command-line diagnostics (`jcmd`, `jstack`, `jmap`).
* **Security & Garbage Collection:** GC latency and throughput characteristics (comparing G1 GC and ZGC) and JVM-level memory footprint optimizations.
* **Advanced JDK Tools:** Native application packaging via `jpackage`, startup time reduction using Application Class-Data Sharing (AppCDS), and lightweight prototyping with `jwebserver`.

### 5. Security & Cryptography (`/security`)
* **Java Encryption/Decryption (JCA):** Java Cryptography Architecture fundamentals, symmetric encryption (AES-GCM), asymmetric key pairs (RSA), and secure key derivation.
* **Digital Signatures & Certificates:** Message digests, signature generation/verification, and parsing X.509 certificates.
* **Security Monitoring:** Auditing and profiling security events inside the JVM using JFR security event streams and `keytool` keystore management.
* **Safeguarding Applications:** Hardening JVM execution environments, secure communication with TLS/SSL, and mitigating common vulnerabilities.

### 6. Foundations & Quality Engineering (`/foundations`)
* **Certification Alignment:** Core competency checkpoints matching Oracle Certified Professional (OCP) Java SE requirements.
* **Advanced Debugging:** Thread dump analysis, conditional breakpoints, memory leak identification, and step-through debugging techniques.

---

## 🛠️ Tech Stack
* **Language:** Java 25 (Eclipse Temurin OpenJDK)
* **Build System:** Apache Maven
* **Testing & Assertions:** JUnit 5 (Jupiter), AssertJ

---

## 🚀 Running the Lab

All implementations are continuously validated through the test engine. To compile the code and execute all automated test suites:

```bash
mvn clean test
```
