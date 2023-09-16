### Домашнее задание к занятию «8.7. Method security. OAuth2»

# Задача «Безопасные методы»

[Ссылка на задание](https://github.com/netology-code/jd-homeworks/blob/master/spring_method_security/task1/README.md)

### Пользователи системы (у всех пароль password)
* user1 роль READ
* user2 роль WRITE
* admin роль DELETE

### Ссылки для получения данных:
* Доступна только user1 с ролью READ  
http://localhost:8080/security/read
* Доступна только user2 с ролью WRITE  
http://localhost:8080/security/write
* Доступна user2 с ролью WRITE и admin с ролью DELETE   
http://localhost:8080/security/delete
* Доступна при query параметре username == логину пользователя  
http://localhost:8080/security/user?username=admin  

