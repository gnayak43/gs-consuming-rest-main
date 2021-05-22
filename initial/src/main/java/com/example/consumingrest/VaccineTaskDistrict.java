package com.example.consumingrest;

import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import com.google.gson.Gson;

public class VaccineTaskDistrict extends TimerTask {
	private static final String ROOT_URL = "https://cdn-api.co-vin.in/api";

	private String date1;
	private String date2;
	private int district_id;
	private int age;
	private String[] recipients;
	private List<Long> pincodes;
	private List<String> chatIds;
	private boolean isDose1;
	private boolean isDose2;

	public VaccineTaskDistrict(String[] recipients, List<String> chatIds, String date1, String date2, int district_id,
			int age, List<Long> pincodes, boolean isDose1, boolean isDose2) {
		super();
		this.recipients = recipients;
		this.chatIds = chatIds;
		this.date1 = date1;
		this.date2 = date2;
		this.district_id = district_id;
		this.age = age;
		this.pincodes = pincodes;
		this.isDose1 = isDose1;
		this.isDose2 = isDose2;
	}

	public void run() {
		System.out.println(
				"Starting at : " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
		try {
			printAvailableSlots(date1);
			printAvailableSlots(date2);
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
		System.out
				.println("Done at : " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
	}

	private void printAvailableSlots(String dateStr) throws Exception {
		List<String> availableCenterDetails = new ArrayList<>();
		String cetersStr = getContent(ROOT_URL + "/v2/appointment/sessions/public/calendarByDistrict?district_id="
				+ String.valueOf(district_id) + "&date=" + dateStr);
		Centers centers = new Gson().fromJson(cetersStr, Centers.class);
		for (Center center : centers.getCenters()) {
			List<Session> sessions = center.getSessions();
			for (Session session : sessions) {
				if (session.getAvailable_capacity() > 0 && session.getMin_age_limit() == age
						&& (pincodes == null || pincodes.contains(center.getPincode()))) {
					if ((isDose1 && session.getAvailable_capacity_dose1() > 0)
							|| (isDose2 && session.getAvailable_capacity_dose2() > 0)) {
						String details = center.toStringCustom() + ", " + session.toStringCustom();
						System.out.println(details);
						availableCenterDetails.add(details);
						Toolkit.getDefaultToolkit().beep();
					}
				}
			}
		}
		if (!availableCenterDetails.isEmpty()) {
			String content = String.join("\n\n", availableCenterDetails);
			if (recipients != null && recipients.length > 0) {
				new SendEmailTLS().sendFromGMail(recipients, "Vaccine Slot Available Alert", content);
			}
			new TelegramNotifier().send(chatIds, content);
		}
	}

	private String getContent(String u) throws Exception {
		String content = null;
		URL url = new URL(u);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestProperty("User-Agent",
				"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.95 Safari/537.36");
		conn.connect();
		// open the stream and put it into BufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

		String inputLine;
		while ((inputLine = br.readLine()) != null) {
			// System.out.println(inputLine);
			content = inputLine;
		}
		br.close();
		return content;
	}

}
