# Лаб 9: JaCoCo хамралт ба бүтцийн тест

- Нэр: А.Адъяахүү
- Оюутны код: B232270125

## Орчин (`java -version` ба `mvn -version`-ийн бүтэн гаралт)

```text
openjdk version "17.0.21.0.3" 2026-10-24
OpenJDK Runtime Environment (build 17.0.21.0.3+1-1-26.04.1-Ubuntu)
OpenJDK 64-Bit Server VM (build 17.0.21.0.3+1-1-26.04.1-Ubuntu, mixed mode, sharing)
Apache Maven 3.9.12
Maven home: /usr/share/maven
Java version: 17.0.21.0.3, vendor: Ubuntu, runtime: /usr/lib/jvm/java-17-openjdk-amd64
Default locale: en, platform encoding: UTF-8
OS name: "linux", version: "6.18.54.1-microsoft-standard-wsl2", arch: "amd64", family: "unix"
```

## Хэсэг A: Happy path тестүүд ба эхний хэмжилт

Хэвийн урсгалын 5 тест бичсэний дараа Branch хамралт 53.7% (22/41), Line хамралт 68.0% (17/25) гарсан (`results/jacoco-A.csv`).

Шар ромбо бүхий мөрүүд нь `if`, `||`, `&&` нөхцөлийн зөвхөн нэг салаа хамрагдсаныг заана. Жишээ нь `letterGrade`-ийн `score >= 70`, `scholarship`-ийн `hasViolation`, `gpa >= 3.0` нөхцөлүүд зөвхөн үнэн эсвэл зөвхөн худал чиглэлд ажилласан.

Улаан (огт хүрээгүй) 8 мөр нь гурван `throw` бүхий алдааны зам, `letterGrade`-ийн D/F салаа, `gpa`-ийн `switch` доторх C/D тохиолдол, `scholarship`-ийн `return 0` юм. Happy-path тестүүд эдгээрийг дайрдаггүй.
