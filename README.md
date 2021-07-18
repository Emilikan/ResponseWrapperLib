# ResponseWrapperLib
Проект, демонстрирующий возможность оборачивать ответы контроллеров с помощью ControllerAdvice

ResponseWrapperLib - стартер

ResponseWrapperDemo - демонстрация работы стартера

--------------
Проект подготовлен для статьи на [Хабре](https://habr.com/ru/post/567056/)

--------------
Ветка **master** - вариант, описанный в [статье](https://habr.com/ru/post/567056/)

Ветка **many-services-inject-through-list** - обновленный вариант с generics, передачей информации о запросе, возможностью использовать несколько реализаций сервисов для разных классов-оберток. Описан в [статье на хабре часть 2](https://habr.com/ru/post/568344/)

Ветка **many-services-inject-through-map-with-bpp** - реализация использования нескольких сервисов для разных оберток через самостоятельный инжект через аннотацию @InjectWrapperServiceMap (реализовано через BeanPostProcessor). Описана в [статье на хабре часть 2](https://habr.com/ru/post/568344/)
