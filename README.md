<div align="center" style="display: flex; align-items: center; justify-content: center;">
  <img src="https://www.enoca.com/wp-content/uploads/2019/02/enoca.png" style="align-items: center;" alt="Icon" width="100" height="50">
</div>
  <h2 align="center">Company Project</h2>

  <p align="center" >
Şirket ve Çalışanlar için Temel CRUD İşlemleri
    <br/>
    <br/>
    <a href="https://keremturak.github.io/taskquestion6-documentation"><strong>Explore the docs »</strong></a>

## İçerik

**[1. Proje Hakkında](#about-this-project)**

  * [1.1. Projenin Amacı](#Proje-Hakkında)
  * [1.2. Kullanılan Teknolojiler](#tech-stack)

**[2. Başlamak İçin](#getting-started)**

  * [2.1. Yapılması Gerekenler](#condition-in-the-project)

      * [2.1.1. Bağımlılıklar](#dependencies)
      * [2.1.2. Gereklilikler](#requirements)

**[3. Örnekler](#usage/examples)**

**[4. Nasıl Çalışır?](#how-to-run)**

**[5. Proje Akışı](#screenshots)**

  * [5.1. Ekran Görüntüleri](#screenshots)

**[6. Contributing](#contributing)**

**[7. Authors](#authors)**

**[8. Documentation](#documentation)**

 


## Proje Hakkında 
Bu proje, bir Java Spring uygulamasıdır ve lokal bir veritabanında (MongoDB) şirketler ve çalışanların tablolarını içerir. Bu iki tablo arasında bir ilişki bulunmaktadır. Bu ilişki id üzerinden ilişkisel olmayan veritabanında yapılmıştır. Proje ekleme, silme, güncelleme ve listeleme işlemlerini gerçekleştirmektedir. Her işlem sonrasında yapılan işlem detayı return edilmektedir.

## Tech Stack 


**Server:**<img src="https://cdn.iconscout.com/icon/free/png-512/free-java-59-1174952.png?f=avif&w=256" alt="HTML5" width="25" height="20"> Java,<img src="https://camo.githubusercontent.com/96e43701d83561899724a89d71187445b7b8f4fe84518a3ea5bec8f85bd207bf/68747470733a2f2f63646e2e737667706f726e2e636f6d2f6c6f676f732f737761676765722e737667" alt="HTML5" width="25" height="20"> Swagger<img src="https://cdn.iconscout.com/icon/free/png-512/free-spring-16-283031.png?f=avif&w=256" alt="HTML5" width="25" height="20">SpringBoot, <img src="https://cdn.iconscout.com/icon/free/png-512/free-gradle-2-1174969.png?f=avif&w=256" alt="HTML5" width="25" height="20">Gradle


**Cloud:**<img src="https://cdn.iconscout.com/icon/free/png-512/free-docker-226091.png?f=avif&w=256" alt="HTML5" width="25" height="20">Docker

**DataBases:**<img src="https://cdn.iconscout.com/icon/free/png-512/free-mongodb-3521676-2945120.png?f=avif&w=256" alt="HTML5" width="25" height="20">MongoDB



## Getting Started
✔  Java 8 SE veya daha yeni sürümler gerekli.
✔ Öncelkle projeyi localinize klonlayınız.

✔ Projeyi kullanmadan önce resources/application.yaml dosyasında ki yapılandırmaları kendinize göre düzenleyin.

✔ Database olarak MongoDB kullanılmıştır. kullanıcı adı ve şifrenizi belirleyiniz ve "project" isimli bir database bulunduğuna emin olunuz.

✔ Projeyi ardından başlatabilirsiniz. Port olarak "9090" portunda ayağa kalkacaktır. 

✔ http://localhost:9090/swagger-ui/index.html# adresinde End pointleri görebileceksiniz.

✔Öncelikle Şirket eklenmeli. Şirket verisi yoksa çalışan ekleyemezsiniz.

> :warning: **Warning:** şirket sildiğiniz zaman o şirkete bağlı bütün çalışanlar silinir..


### Dependencies
![Dependencies](https://github.com/keremturak/HR-Management-Documentation/blob/main/docs/img/Gradle_logo.png?raw=true)

|      | Tech     | Url |
|----| -------- | ------- |
|1| springDataMongodb  | "org.springframework.boot:spring-boot-starter-data-mongodb:${versions.springBoot}"    |
|2| Spring Boot Web | implementation 'org.springframework.boot:spring-boot-starter-web'     |
|3| Lombok    |compileOnly 'org.projectlombok:lombok'-----annotationProcessor 'org.projectlombok:lombok'    |
|4| Swagger Ui | implementation 'org.springdoc:springdoc-openapi-starter-webmvc-ui:2.1.0'     |
|5| Mapstruct    | implementation 'org.mapstruct:mapstruct:1.5.5.Final'   |
|6| Validator | 	implementation  'org.hibernate.validator:hibernate-validator:8.0.0.Final'    |





### Requirements
- 👉  <a href="https://keremturak.github.io/taskquestion6-documentation"><strong>Explore the docs »</strong></a>

## Usage/Examples

Örnek bir save metodu ;

```java
    public CompanySaveResponseDto save(CompanySaveRequestDto dto) {
        if (dto == null) {
            throw new MyCompanyException(EErrorType.DTO_IS_NULL);
        }
        Company company = IMapper.INSTANCE.companyFromCompanySaveRequestDto(dto);
        return IMapper.INSTANCE.companySaveResponseDtofromCompany(companyRepository.save(company));
    }
```

örnek bir @GetMapping kullanımı

```java
    @PostMapping (SAVE_COMPANY)
    public ResponseEntity<CompanySaveResponseDto> save(@RequestBody @Valid CompanySaveRequestDto dto) {
        return ResponseEntity.ok(companyService.save(dto));
    }
    }
```

## Documentation

- 👉  <a href="https://keremturak.github.io/taskquestion6-documentation"><strong>Explore the docs »</strong></a>

