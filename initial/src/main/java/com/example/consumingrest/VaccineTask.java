package com.example.consumingrest;

import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.TimerTask;

import com.google.gson.Gson;

public class VaccineTask extends TimerTask {
	private static final String ROOT_URL = "https://cdn-api.co-vin.in/api";
	private boolean soundPlayed = false;

	public void run() {
		System.out.println(
				"Starting at : " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
		String date1Str = "13-05-2021";
		String date2Str = "19-05-2021";
		try {
			checkForAvailableSlots(date1Str, date2Str);
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
		System.out
				.println("Done at : " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
	}

	private void checkForAvailableSlots(String date1Str, String date2Str) throws Exception {
		String statesStr = getContent(ROOT_URL + "/v2/admin/location/states");
		Gson g = new Gson();
		States states = g.fromJson(statesStr, States.class);
		for (State s : states.getStates()) {
			if ("Odisha".equals(s.getState_name())) { // Odisha Maharashtra
				String districtsStr = getContent(
						ROOT_URL + "/v2/admin/location/districts/" + String.valueOf(s.getState_id()));
				Districts districts = g.fromJson(districtsStr, Districts.class);
				// printAvailableSlots(date1Str, g, districts, "Ganjam"); // Ganjam Pune
				printAvailableSlots(date1Str, g, districts, "Khurda");

				// printAvailableSlots(date2Str, g, districts, "Ganjam"); // Ganjam Pune
				printAvailableSlots(date2Str, g, districts, "Khurda");

			}
		}
	}

	private void printAvailableSlots(String dateStr, Gson g, Districts districts, String districtName)
			throws Exception {
		for (District district : districts.getDistricts()) {
			if (districtName.equals(district.getDistrict_name())) {
				String cetersStr = getContent(
						ROOT_URL + "/v2/appointment/sessions/public/calendarByDistrict?district_id="
								+ String.valueOf(district.getDistrict_id()) + "&date=" + dateStr);
				Centers centers = g.fromJson(cetersStr, Centers.class);
				for (Center center : centers.getCenters()) {
					List<Session> sessions = center.getSessions();
					for (Session session : sessions) {
						if (session.getAvailable_capacity() > 1 && session.getMin_age_limit() == 18) {
							System.out.println(center.toStringCustom() + ", " + session);
							// if (!soundPlayed) {
							// soundPlayed = true;
							Toolkit.getDefaultToolkit().beep();
							// }
						}
					}
				}
			}
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
