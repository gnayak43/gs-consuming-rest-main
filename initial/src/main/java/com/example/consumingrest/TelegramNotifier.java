package com.example.consumingrest;

import java.util.List;

import javax.ws.rs.core.UriBuilder;

import org.springframework.web.client.RestTemplate;

public class TelegramNotifier {
	public static final String CHAT_ID = "<put your own chat session id>";
	private static final String TOKEN = "<put your bot token>";

	public void send(List<String> chatIds, String message) {
		for(String chatId : chatIds) {
			UriBuilder builder = UriBuilder.fromUri("https://api.telegram.org").path("/{token}/sendMessage")
					.queryParam("chat_id", chatId).queryParam("text", message);

			String response = new RestTemplate().getForObject(builder.build("bot" + TOKEN), String.class);

			System.out.println(response);
		}
	}

	public static void main(String[] args) {
		UriBuilder builder = UriBuilder.fromUri("https://api.telegram.org").path("/{token}/sendMessage")
				.queryParam("chat_id", "-558317180").queryParam("text", "Hello from Bot");

		String response = new RestTemplate().getForObject(builder.build("bot" + TOKEN), String.class);

		System.out.println(response);
	}
}
