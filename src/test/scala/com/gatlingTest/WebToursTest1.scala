package com.gatlingTest

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._
import io.gatling.core.feeder._
import io.gatling.http.request.builder.HttpRequestBuilder

class WebToursTest1 extends Simulation {

	val httpProtocol = http
		.baseUrl("http://localhost:1080/")
		.inferHtmlResources(BlackList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.woff2""", """.*\.(t|o)tf""", """.*\.png""", """.*detectportal\.firefox\.com.*"""), WhiteList())
		.userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.0.0 Safari/537.36")

	/* val headers_0 = Map(

		"A-IM" -> "x-bm,gzip",
		"Accept-Encoding" -> "gzip, deflate, br",
		"If-None-Match" -> "SMChYyMDIzMDQwNy0wODIyNDYuMzU5MDAwEggIABADGG8gAA==#P0of0+m0bvI=",
		"Sec-Fetch-Dest" -> "empty",
		"Sec-Fetch-Mode" -> "no-cors",
		"Sec-Fetch-Site" -> "none")

	val headers_1 = Map(
		"Accept-Encoding" -> "gzip, deflate, br",
		"Accept-Language" -> "ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7",
		"Origin" -> "https://www.google.com",
		"Sec-Fetch-Dest" -> "empty",
		"Sec-Fetch-Mode" -> "no-cors",
		"Sec-Fetch-Site" -> "none")

	val headers_2 = Map(
		"Accept-Encoding" -> "gzip, deflate, br",
		"Accept-Language" -> "ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7",
		"Sec-Fetch-Dest" -> "empty",
		"Sec-Fetch-Mode" -> "no-cors",
		"Sec-Fetch-Site" -> "none")

	val headers_3 = Map(
		"Accept-Encoding" -> "gzip, deflate, br",
		"Accept-Language" -> "ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7",
		"Content-Type" -> "application/json",
		"Sec-Fetch-Dest" -> "empty",
		"Sec-Fetch-Mode" -> "no-cors",
		"Sec-Fetch-Site" -> "none",
		"X-Goog-Update-AppId" -> "fdcgdnkidjaadafnichfpabhfomcebme,ghbmnnjooekpmoecnnnilnnbdlolhkhi,gighmmpiobklfepjocnamgkkbiglidom,mlomiejdfkolichcflejclcbmpeaniij,nmmhkkegccagdldgiimedpiccmgmieda",
		"X-Goog-Update-Interactivity" -> "bg",
		"X-Goog-Update-Updater" -> "chromecrx-111.0.5563.147")

	val headers_4 = Map(
		"Accept-Encoding" -> "gzip, deflate, br",
		"Accept-Language" -> "ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7",
		"Sec-Fetch-Dest" -> "empty",
		"Sec-Fetch-Mode" -> "no-cors",
		"Sec-Fetch-Site" -> "none",
		"X-Goog-Update-AppId" -> "mjmpfdkmpojoeemjmfiddlhkkndcdpno",
		"X-Goog-Update-Interactivity" -> "bg",
		"X-Goog-Update-Updater" -> "chromecrx-111.0.5563.147")

	val headers_5 = Map(
		"Accept-Encoding" -> "gzip, deflate, br",
		"Accept-Language" -> "ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7",
		"Sec-Fetch-Dest" -> "empty",
		"Sec-Fetch-Mode" -> "no-cors",
		"Sec-Fetch-Site" -> "none",
		"X-Developer-Key" -> "77185425430.apps.googleusercontent.com",
		"authorization" -> "Bearer ya29.a0Ael9sCNnrHSLSAjCTAN66QTvrZ53BUCsHuRWjMLnk1ZaYVteLEHTpnWwOzEn3rG4XylRiYka2HRyVcojiVHhhW4grwsv1u2rdj3qRwGevF_zUHKew83-MkpsEq6XbxhgkbhpIA_Q6hhNhygOlrpEUHSq-eaNQshYwi8GZOFxhX2m4N9DAGD39ZooDAdm4V6ZHPM6YcNwBYjqoFEBty4tmS7Lts5tjLh3MTBtKFECKUc4w83hbuEnFtpIHJSSyt7Qd4KXET4p-AaCgYKAU8SARASFQF4udJhmckQJIH8NbahPefq6eKGtA0273")

	val headers_6 = Map(
		"Accept-Encoding" -> "gzip, deflate, br",
		"Accept-Language" -> "ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7",
		"Cache-Control" -> "no-cache",
		"Content-Encoding" -> "gzip",
		"Content-Type" -> "application/octet-stream",
		"Pragma" -> "no-cache",
		"Sec-Fetch-Dest" -> "empty",
		"Sec-Fetch-Mode" -> "no-cors",
		"Sec-Fetch-Site" -> "none",
		"User-Agent" -> "Chrome WIN 111.0.5563.147 (2b5ec366bb5b68dacca9719d5d83cb7e61fb6431-refs/branch-heads/5563@{#1238}) channel(stable)",
		"X-Client-Data" -> "CIS2yQEIpLbJAQjBtskBCKmdygEIu/XKAQiWocsBCOGXzQEI5JfNAQjom80BCMyczQEI7J7NAQi/n80BCPmfzQEIhaDNAQi7oc0BCL6izQEIqYStAg==",
		"authorization" -> "Bearer ya29.a0Ael9sCNnrHSLSAjCTAN66QTvrZ53BUCsHuRWjMLnk1ZaYVteLEHTpnWwOzEn3rG4XylRiYka2HRyVcojiVHhhW4grwsv1u2rdj3qRwGevF_zUHKew83-MkpsEq6XbxhgkbhpIA_Q6hhNhygOlrpEUHSq-eaNQshYwi8GZOFxhX2m4N9DAGD39ZooDAdm4V6ZHPM6YcNwBYjqoFEBty4tmS7Lts5tjLh3MTBtKFECKUc4w83hbuEnFtpIHJSSyt7Qd4KXET4p-AaCgYKAU8SARASFQF4udJhmckQJIH8NbahPefq6eKGtA0273")


	val headers_12 = Map(
		"Accept-Encoding" -> "gzip, deflate, br",
		"Accept-Language" -> "ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7",
		"Content-Type" -> "application/x-protobuf",
		"Sec-Fetch-Dest" -> "empty",
		"Sec-Fetch-Mode" -> "no-cors",
		"Sec-Fetch-Site" -> "none",
		"X-Client-Data" -> "CIS2yQEIpLbJAQjBtskBCKmdygEIu/XKAQiWocsBCOGXzQEI5JfNAQjom80BCMyczQEI7J7NAQi/n80BCPmfzQEIhaDNAQi7oc0BCL6izQEIqYStAg==")


	val headers_16 = Map(
		"Accept-Encoding" -> "gzip, deflate, br",
		"Accept-Language" -> "ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7",
		"Content-Type" -> "application/x-protobuf",
		"Sec-Fetch-Dest" -> "empty",
		"Sec-Fetch-Mode" -> "no-cors",
		"Sec-Fetch-Site" -> "none",
		"authorization" -> "Bearer ya29.a0Ael9sCPLq4a9UkmtCRnwVwliaLT5S9R_xw2jh7XdrXzxIdA45bBBjLlqSPwsaRgQ9-rp8qbFVUL8QYywwolcCxaG-YE5g0JB3CdxgL14w4k7U3L8Kv3zDQltKOaWro3tP77FyURTg3XKkeNnjagfeNmCLpqK32-OevP_oPKl9PN33WYQh_aJQZXqitRgcZXS3KVxskp8AwJPU69TRoQa6Did-ODyDhCGwQfB3_5S_YbQw79xnWKH0pEPTk7My_seaM79aCgYKAZgSARASFQF4udJhZTEk9X7zGKONEk3DHf6VCA0267")

	val headers_22 = Map(
		"Accept-Encoding" -> "gzip, deflate, br",
		"Content-Type" -> "application/json",
		"Sec-Fetch-Dest" -> "empty",
		"Sec-Fetch-Mode" -> "no-cors",
		"Sec-Fetch-Site" -> "none",
		"X-Goog-Update-AppId" -> "ihnlcenocehgdaegdmhbidjhnhdchfmm,oimompecagnajdejgnnjijobebaeigek,neifaoindggfcjicffkgpmnlppeffabd,obedbbhbpmojnkanicioggnmelmoomoc,lmelglejhemejginpboagddgdfbepgmp,giekcmmlnklenlaomppkphknjmnnpneh,laoigpblnllgcgjnjnllmfolckpjlhki,khaoiebndkojlmppeemjhbpbandiljpe,gcmjkmgdlgnkkcocmoeiminaijmmjnii,hfnkpimlhhgieaddgfemjhofmfblmnib,llkgjffcdpffmhiakmfcdcblohccpfmo,hnimpnehoodheedghdeeijklkeaacbdc,ehgidpndbllacpjalkiimkbadgjfnnmc,jflookgnkcckhobaglndicnbbgbonegd,ggkkehgbnfjpeggfpleeakpidbkibbmn,efniojlnjndmcbiieegkicadnoecjjef,jamhcnnkihinmdlkakkaopbjbbcngflc,dhlpobdgcjafebgbbhjdnapejmpkgiie,ojhpjlocmbogdgmfpkhlaaeamibhnphh,imefjhfbkmcmebodilednhmaccmincoa,eeigpngbgcognadeebkilcpcaedhellh,gonpemdgkjcecdgbnaabipppbmgfggbe",
		"X-Goog-Update-Interactivity" -> "bg",
		"X-Goog-Update-Updater" -> "chrome-111.0.5563.147")

	val headers_23 = Map(
		"Accept-Encoding" -> "gzip",
		"DisableExperiments" -> "false",
		"If-None-Match" -> "Mhz6BHuGm7UTbJXWUhRiJ2BL/wGaysWNLoi23GivOdg=",
		"User-Agent" -> "Microsoft Office  2014")

	val headers_25 = Map(
		"Accept-Encoding" -> "gzip",
		"DisableExperiments" -> "false",
		"If-None-Match" -> "8FYhSJmT5PoxPmxuajaMO5lqaQMSl1QSLokK1ugCHZg=",
		"User-Agent" -> "Microsoft Office  2014")

	val headers_26 = Map(
		"Accept-Encoding" -> "gzip",
		"DisableExperiments" -> "false",
		"If-None-Match" -> "P+mLa6N5SZp6WJ/Nl8+aK2Q5XZn86WE2LokK1rpsUW4=",
		"User-Agent" -> "Microsoft Office  2014")

	val headers_27 = Map(
		"Accept-Encoding" -> "gzip",
		"DisableExperiments" -> "false",
		"If-None-Match" -> "aeHkfOmsj3gCQ9MM/mWo0LarrGFKD4RCLokK1u5+Zvw=",
		"User-Agent" -> "Microsoft Office  2014")

	val headers_28 = Map(
		"Content-Type" -> "application/json; charset=utf-8",
		"DmsActivityId" -> "{08D76C52-95BA-428F-9BA3-D5CA89255B04}",
		"User-Agent" -> "cpprestsdk/2.8.0")*/


	val openPage = exec(http("request_8")
		.get("/cgi-bin/welcome.pl?signOff=true")
		//.headers(headers_8)
		.resources(http("request_9")
			.get("/cgi-bin/nav.pl?in=home")))
		/*.headers(headers_8)))
  .pause(6)
  .exec(http("request_10")
    .post(uri07 + "/?client=Google+Chrome&client_id=FMgZR4Z58fsU%2BXsUWA2cmg%3D%3D")
    .headers(headers_6)
    .body(RawFileBody("com/gatlingTest/webtourstest1/0010_request.bin"))
    .resources(http("request_11")
    .post(uri07 + "/?client=Google+Chrome&client_id=FMgZR4Z58fsU%2BXsUWA2cmg%3D%3D")
    .headers(headers_6)
    .body(RawFileBody("com/gatlingTest/webtourstest1/0011_request.bin")),
          http("request_12")
    .post(uri09 + "?key=AIzaSyBOti4mM-6x9WDnZIjIeyEU21OpBXqWBgw")
    .headers(headers_12)
    .body(RawFileBody("com/gatlingTest/webtourstest1/0012_request.dat"))))*/
		.pause(4)

	val login = exec(http("login")
		.post("/cgi-bin/login.pl")
		//.headers(headers_13)
		.formParam("userSession", "136172.664398542HAAtDiVptcftcAczpciiff")
		.formParam("username", "#{username}")
		.formParam("password", "#{password}")
		.formParam("login.x", "49")
		.formParam("login.y", "12")
		.formParam("JSFormSubmit", "off")
		.resources(http("request_14")
			/*.post(uri12)
      .headers(headers_2)
      .formParam("client_id", "77185425430.apps.googleusercontent.com")
      .formParam("client_secret", "OTJgUOQcT7lO7GsGZq2G4IlT")
      .formParam("grant_type", "refresh_token")
      .formParam("refresh_token", "1//0crq_aoSlpYWBCgYIARAAGAwSNwF-L9Ira5C1vrBhcZKbLS0_hq9yh-9MXpRX8HxOgDjK7EPVZ17t6wpicjZKL-7ID_0OXtpr-vo")
      .formParam("scope", "https://www.googleapis.com/auth/identity.passwords.leak.check"),
            http("request_15")*/
			.get("/cgi-bin/nav.pl?page=menu&in=home"),
			/*.headers(headers_15),
            http("request_16")
      .post(uri02)
      .headers(headers_16)
      .body(RawFileBody("com/gatlingTest/webtourstest1/0016_request.dat")),*/
			http("request_17")
				.get("/cgi-bin/login.pl?intro=true")))
		//.headers(headers_15)))
		.pause(1)

		/*.exec(http("request_18")
      .post(uri07 + "/?client=Google+Chrome&client_id=FMgZR4Z58fsU%2BXsUWA2cmg%3D%3D")
      .headers(headers_6)
      .body(RawFileBody("com/gatlingTest/webtourstest1/0018_request.bin")))
    .pause(6)*/

		.exec(http("request_19")
			.get("/cgi-bin/nav.pl?page=menu&in=flights")
			//.headers(headers_15)
			.resources(http("request_20")
				.get("/cgi-bin/welcome.pl?page=search"),
				//.headers(headers_15),
				http("request_21")
					.get("/cgi-bin/reservations.pl?page=welcome")))
		//.headers(headers_15)))
		.pause(2)

	val buyFlightOneWay = exec(http("choose_flight1")
		.post("/cgi-bin/reservations.pl")
		//.headers(headers_13)
		.formParam("advanceDiscount", "0")
		.formParam("depart", "#{depart}")
		.formParam("departDate", "#{departDate}")
		.formParam("arrive", "#{arrive}")
		.formParam("numPassengers", "#{numPassengers}")
		.formParam("seatPref", "#{seatPref}")
		.formParam("seatType", "#{seatType}")
		.formParam("findFlights.x", "78")
		.formParam("findFlights.y", "16")
		.formParam(".cgifields", "roundtrip")
		.formParam(".cgifields", "seatType")
		.formParam(".cgifields", "seatPref"))
		.pause(3)

		.exec(http("request_30")
			.post("/cgi-bin/reservations.pl")
			//.headers(headers_13)
			.formParam("outboundFlight", "582;1427;#{departDate}")
			.formParam("numPassengers", "#{numPassengers}")
			.formParam("advanceDiscount", "0")
			.formParam("seatType", "#{seatType}")
			.formParam("seatPref", "#{seatPref}")
			.formParam("reserveFlights.x", "76")
			.formParam("reserveFlights.y", "8"))
		.pause(2)

		.exec(http("buy_ticket1")
			.post("/cgi-bin/reservations.pl")
			//.headers(headers_13)
			.formParam("firstName", "#{username}")
			.formParam("lastName", "#{password}")
			.formParam("address1", "kkkkk")
			.formParam("address2", "wwwww")
			.formParam("pass1", "#{username} #{password}")
			.formParam("creditCard", "12345678")
			.formParam("expDate", "222")
			.formParam("oldCCOption", "")
			.formParam("numPassengers", "#{numPassengers}")
			.formParam("seatType", "#{seatType}")
			.formParam("seatPref", "#{seatPref}")
			.formParam("outboundFlight", "582;1427;#{departDate}")
			.formParam("advanceDiscount", "0")
			.formParam("returnFlight", "")
			.formParam("JSFormSubmit", "off")
			.formParam("buyFlights.x", "55")
			.formParam("buyFlights.y", "7")
			.formParam(".cgifields", "saveCC"))
		.pause(1)



	val buyFlightRoundtrip = exec(http("choose_flight2")
		.post("/cgi-bin/reservations.pl")
		//.headers(headers_18)
		.formParam("advanceDiscount", "0")
		.formParam("depart", "#{depart}")
		.formParam("departDate", "#{departDate}")
		.formParam("arrive", "#{arrive}")
		.formParam("returnDate", "#{returnDate}")
		.formParam("numPassengers", "#{numPassengers}")
		.formParam("roundtrip", "on")
		.formParam("seatPref", "#{seatPref}")
		.formParam("seatType", "#{seatType}")
		.formParam("findFlights.x", "68")
		.formParam("findFlights.y", "8")
		.formParam(".cgifields", "roundtrip")
		.formParam(".cgifields", "seatType")
		.formParam(".cgifields", "seatPref"))
		//.resources(http("request_28")
			//.post(uri05 + "?cup2key=12:CXKFXW0TD8ehu1MeJTzANlJqwUTLyARhHehIuiaF6dw&cup2hreq=d6c3f09ff62db36cdb95e70c35a821827b70ac4cf9dffad32f2ff0c6a1d2f49d")
			//.headers(headers_28)
			//.body(RawFileBody("com/gatlingTest/tuda/0028_request.json"))))
		.pause(4)
		.exec(http("request_29")
			.post("/cgi-bin/reservations.pl")
			//.headers(headers_18)
			.formParam("outboundFlight", "282;1362;#{departDate}")
			.formParam("returnFlight", "823;1179;#{returnDate}")
			.formParam("numPassengers", "#{numPassengers}")
			.formParam("advanceDiscount", "0")
			.formParam("seatType", "#{seatType}")
			.formParam("seatPref", "#{seatPref}")
			.formParam("reserveFlights.x", "17")
			.formParam("reserveFlights.y", "13"))
		.pause(2)
		.exec(http("buy_ticket2")
			.post("/cgi-bin/reservations.pl")
			//.headers(headers_18)
			.formParam("firstName", "#{username}")
			.formParam("lastName", "#{password}")
			.formParam("address1", "tttt")
			.formParam("address2", "kkkkk")
			.formParam("pass1", "#{username} #{password}")
			.formParam("creditCard", "12345678")
			.formParam("expDate", "111")
			.formParam("oldCCOption", "")
			.formParam("numPassengers", "#{numPassengers}")
			.formParam("seatType", "#{seatType}")
			.formParam("seatPref", "#{seatPref}")
			.formParam("outboundFlight", "282;1362;#{departDate}")
			.formParam("advanceDiscount", "0")
			.formParam("returnFlight", "823;1179;#{returnDate}")
			.formParam("JSFormSubmit", "off")
			.formParam("buyFlights.x", "49")
			.formParam("buyFlights.y", "3")
			.formParam(".cgifields", "saveCC"))
		.pause(1)

	val logout = exec(http("logout")
		.get("/cgi-bin/welcome.pl?signOff=1")
		//.headers(headers_15)
		.resources(http("request_33")
			.get("/cgi-bin/nav.pl?in=home")))
	//.headers(headers_15)))

	val scn = scenario("WebToursTest1").exec(openPage,login,buyFlightOneWay,buyFlightRoundtrip,logout)


	val feeder = csv("data/users.csv").circular
	val feeder1 = csv("data/users1.csv").circular
	val feederDate1 = csv("data/depDate.csv").random
	val feederDate2 = csv("data/returnDate.csv").random
	val feederCity = csv("data/City.csv").random
	val feederSeat = csv("data/seat.csv").random
	val feederPassengers = csv("data/passengers.csv").random



	val usersOneWay = scenario("UsersOneWay").exec(openPage,login,buyFlightOneWay,logout)
		.feed(feeder)
		.exec{ session =>
			println("Username: "+session("username").as[String])
			println("Password: "+session("password").as[String])
			session
		}
		.feed(feederDate1)
		.exec{ session =>
			println("DepartDate: " + session("departDate").as[String])
			session
		}
		.feed(feederCity)
		.exec { session =>
			println("Depart: " + session("depart").as[String])
			println("Arrive: " + session("arrive").as[String])
			session
		}
		.feed(feederSeat)
		.exec { session =>
			println("SeatPref: " + session("seatPref").as[String])
			println("SeatType: " + session("seatType").as[String])
			session
		}
		.feed(feederPassengers)
		.exec { session =>
			println("NumPassengers: " + session("numPassengers").as[String])
			session
		}


	val usersRoundtrip = scenario("UsersRoundtrip").exec(openPage,login,buyFlightRoundtrip,logout)
		.feed(feeder1)
		.exec { session =>
			println("Username: " + session("username").as[String])
			println("Password: " + session("password").as[String])
			session
		}
		.feed(feederDate1)
		.exec { session =>
			println("DepartDate: " + session("departDate").as[String])
			session
		}
		.feed(feederDate2)
		.exec { session =>
			println("ReturnDate: " + session("returnDate").as[String])
			session
		}
		.feed(feederCity)
		.exec { session =>
			println("Depart: " + session("depart").as[String])
			println("Arrive: " + session("arrive").as[String])
			session
		}
		.feed(feederSeat)
		.exec { session =>
			println("SeatPref: " + session("seatPref").as[String])
			println("SeatType: " + session("seatType").as[String])
			session
		}
		.feed(feederPassengers)
		.exec { session =>
			println("NumPassengers: " + session("numPassengers").as[String])
			session
		}

	setUp(
		usersOneWay.inject(rampUsers(5).during(10)),
		usersRoundtrip.inject(rampUsers(2).during(5)) //на сайте есть выбор билета (только туда или туда и обратно). Здесь я реализую разбивку юзеров на тех, что летят только туда и тех, кто летит туда и обратно
	).protocols(httpProtocol)


}