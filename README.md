# WebToursTest
Сценарий нагрузочного тестирования сервисе Web Tours на Gatling. 

Задание заключалось в написании скрипта покупки билета на сервисе Web Tours. Web Tours был развернут локально, после запуска StartServer.bat на сайт можно попасть по http://localhost:1080/WebTours/. 

На сервисе есть возможность купить билет в одном направлении и в направлении туда-и-обратно. В данном пректе этот момент был реализован составлением двух пользовательских сценариев usersOneWay и usersRoundtrip. 

Параметризация логинов, паролей, выбора посадочных мест, городов отправления и прибытия, даты отправления и прилета, а также количества пассажиров была осуществлена при помощи CSV-файлов (пользовательские логины и пароли были предварительно зарегистрированы на Web Tours).

Логика действий пользователя: 1. Переход на сайт; 2.Логин в системе; 3. Переход в раздел Flights; 4. Выбор города отправления и прибытия, даты вылета и прилета, количества пассажиров и типов мест (также здесь выбирается одно направление или туда-и-обратно); 5. Детали оплаты; 6. Логаут из системы (клик на раздел Sign Off).
