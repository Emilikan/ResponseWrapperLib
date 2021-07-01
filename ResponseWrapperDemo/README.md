# ResponseWrapperDemo
Проект, демонстрирующий использование стартера response-wrapper-starter

## Запуск
Запуск как обычный spring boot проект

## Точки входа
``GET /test`` - обертка 1-ого объекта

``GET /test/collection`` - обертка коллекции объектов

``GET /test/unwrapped`` - пример использование аннотации `@DisableResponseWrapper`

## Для разработчиков
Стартер подключается из папки `libs`

Для того чтобы IntelliJ IDEA подгрузила себе все зависимости — выполните следующие команды в указанном порядке
```yaml
gradle :clean
gradle build
```