package com.example.consumingrest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;

public class Main {


	public static void main(String[] args) throws Exception {
		String[] recipients = null;// { "recipient@gmail.com" };
		List<String> chatIds = Arrays.asList("<put chat id>");
		String date1 = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		String date2 = LocalDateTime.now().plusDays(7).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		long timer = 60000 * 1;
		new Timer().schedule(new VaccineTaskDistrict(recipients, Arrays.asList(TelegramNotifier.CHAT_ID), date1, date2,
				446, 18, null, true, true), 0, timer); // Khurdha
		List<Long> pincodes = new ArrayList<>();
		pincodes.add((long) 753015);
		pincodes.add((long) 753011);
		pincodes.add((long) 753012);
		pincodes.add((long) 753013);
		pincodes.add((long) 753014);
		pincodes.add((long) 753016);
		pincodes.add((long) 753017);
		pincodes.add((long) 753018);
		new Timer().schedule(new VaccineTaskDistrict(recipients, chatIds, date1, date2, 457, 18, pincodes, true, true),
				0, timer); // Cuttack
	}
}
