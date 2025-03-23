package com.tfg.vehiculosapi.service;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class VehiculoService {

	// Creo e inicializo el mapa que contiene el nombre de la marca y los modelos de los coches
	private final Map<String, List<String>> coches = new HashMap<>();
	// Creo e inicializo el mapa que contiene el nombre de la marca y los modelos de las motos
	private final Map<String, List<String>> motos = new HashMap<>();

	public VehiculoService() {
		// Declaro todas las marcas de coches junto con sus modelos
		coches.put("Toyota",
				List.of("Corolla", "Camry", "Yaris", "Hilux", "Rav4", "Land Cruiser", "Prius", "Supra", "Avensis",
						"Auris", "Land Cruiser Prado", "FJ Cruiser", "C-HR", "Venza", "Tacoma", "Sequoia", "Sienna",
						"Highlander", "Tundra", "Verso", "Mark X", "Chaser", "Cressida", "Corona", "Crown"));

		coches.put("Ford",
				List.of("Focus", "Fiesta", "Mustang", "EcoSport", "Explorer", "Mondeo", "Kuga", "Ranger", "Edge",
						"F-150", "C-Max", "Fusion", "Transit", "Tourneo", "Ka", "S-Max", "Galaxy", "Puma", "Cortina",
						"Escort", "Granada", "Taurus", "Zephyr", "Mustang Mach-E", "F-250", "F-350", "Fairlane",
						"Thunderbird"));

		coches.put("Volkswagen",
				List.of("Golf", "Passat", "Polo", "Tiguan", "Touareg", "Jetta", "Arteon", "ID.3", "ID.4", "Beetle",
						"Scirocco", "Sharan", "Up!", "Eos", "Amarok", "Transporter", "Caravelle", "Lupo", "Corrado",
						"Phaeton", "Golf Plus", "Golf Variant", "Lupo", "CC", "ID. Buzz"));

		coches.put("BMW",
				List.of("Serie 1", "Serie 3", "Serie 5", "Serie 7", "X1", "X3", "X5", "X6", "i3", "i8", "Z3", "Z4",
						"Z8", "M2", "M3", "M4", "M5", "M6", "X4", "X7", "M8", "iX", "i4", "X2", "X6 M", "X5 M", "E30",
						"E46", "E92", "E60", "E90", "F30", "F10", "G20", "F80", "M1", "M3 G80", "F12", "M6 G15"));

		coches.put("Audi", List.of("A1", "A3", "A4", "A5", "A6", "A7", "Q2", "Q3", "Q5", "Q7", "e-tron", "A8", "Q8",
				"RS4", "RS5", "RS7", "RS Q3", "RS Q8", "S3", "S4", "S5", "S6", "S7", "S8", "TT", "R8"));

		coches.put("Mercedes-Benz",
				List.of("Clase A", "Clase C", "Clase E", "Clase S", "GLA", "GLC", "GLE", "GLS", "EQC", "Clase G",
						"Clase CLA", "GLK", "Viano", "V-Class", "B-Class", "EQB", "EQE", "EQS", "M-Class", "CLS", "SL",
						"AMG GT", "G-Class", "SLK", "SLS AMG", "Maybach"));

		coches.put("Nissan",
				List.of("Micra", "Note", "Juke", "Qashqai", "X-Trail", "Navara", "370Z", "GT-R", "Leaf", "Altima",
						"Maxima", "Murano", "Pathfinder", "Skyline", "350Z", "370Z Roadster", "Frontier", "GT-R Nismo",
						"Rogue", "Juke Nismo", "Teana", "Cube", "Fairlady Z", "NV200"));

		coches.put("Hyundai", List.of("i10", "i20", "i30", "Tucson", "Santa Fe", "Kona", "Elantra", "Ioniq", "Bayon",
				"Palisade", "Creta", "Kona Electric", "Sonata", "Tucson N", "Veloster", "i40", "Genesis", "Azera"));

		coches.put("Kia", List.of("Picanto", "Rio", "Ceed", "Sportage", "Sorento", "Stinger", "EV6", "Niro", "Soul",
				"Optima", "Cadenza", "Seltos", "Tucson", "Carens", "Forte", "K900"));

		coches.put("Peugeot",
				List.of("208", "308", "508", "2008", "3008", "5008", "Rifter", "Partner", "Expert", "Boxer", "208 GTi",
						"308 GTi", "RCZ", "3008 Hybrid", "5008 Hybrid", "607", "406", "407", "605", "Talbot Horizon"));

		coches.put("Renault",
				List.of("Clio", "Megane", "Talisman", "Captur", "Kadjar", "Scénic", "ZOE", "Kangoo", "Laguna",
						"Avantime", "Espace", "Twingo", "Trafic", "Twizy", "Alpine A110", "Renault 5", "R4", "Fuego",
						"Safrane", "Spider", "Lodgy", "Dokker"));

		coches.put("Chevrolet",
				List.of("Spark", "Aveo", "Cruze", "Malibu", "Equinox", "Trailblazer", "Tahoe", "Camaro", "Impala",
						"Suburban", "Silverado", "Chevy Volt", "Chevy Tracker", "Sonic", "Corvette", "Blazer",
						"Chevy Traverse", "Cavalier", "Chevy HHR"));

		coches.put("Mazda", List.of("Mazda2", "Mazda3", "Mazda6", "CX-3", "CX-5", "CX-9", "MX-5", "Mazda MX-6",
				"Mazda RX-7", "Mazda RX-8", "Mazda CX-30", "Mazda2 Hybrid", "Mazda5"));

		coches.put("Seat", List.of("Ibiza", "Leon", "Ateca", "Arona", "Tarraco", "Toledo", "Alhambra", "Mii", "Exeo",
				"Fura", "Ronda", "Córdoba", "Marbella", "Altea", "Leon Cupra", "Seat 600"));

		coches.put("Skoda", List.of("Fabia", "Octavia", "Superb", "Kamiq", "Karoq", "Kodiaq", "Scala", "Citigo", "Yeti",
				"Roomster", "Karoq", "Rapid", "Favorit", "Felicia", "Superb Combi"));

		coches.put("Citroën",
				List.of("C1", "C2", "C3", "C4", "C5", "C6", "C8", "Berlingo", "Picasso", "DS3", "DS4", "DS5",
						"C3 Aircross", "C4 Cactus", "C4 Aircross", "C5 Aircross", "ZX", "Saxo", "Xantia", "XM", "CX",
						"Traction Avant", "DS", "2CV", "Visa", "BX", "Méhari"));

		coches.put("Tesla", List.of("Model S", "Model 3", "Model X", "Model Y", "Roadster", "Cybertruck", "Semi",
				"Model 3 Performance", "Model Y Long Range", "Model S Plaid", "Roadster 2.0"));

		coches.put("Rolls-Royce",
				List.of("Phantom", "Cullinan", "Ghost", "Wraith", "Dawn", "Silver Shadow", "Silver Spirit", "Corniche",
						"Silver Cloud", "Silver Wraith", "Park Ward", "Mulliner", "Sweptail", "Drophead Coupé"));

		coches.put("Cadillac",
				List.of("Escalade", "CT6", "XT5", "CTS", "SRX", "ATS", "XTS", "STS", "Seville", "DeVille", "Fleetwood",
						"Brougham", "Eldorado", "CTS-V", "V-Series", "LTS", "Cadillac LYRIQ", "Cimarron"));

		coches.put("Mustang", List.of("Mustang GT", "Mustang Mach-E", "Mustang Shelby GT500", "Mustang Shelby GT350",
				"Mustang Bullitt", "Mustang EcoBoost", "Mustang Mach 1", "Mustang Convertible", "Mustang Cobra"));

		coches.put("Ferrari", List.of("488 GTB", "F8 Tributo", "LaFerrari", "Portofino", "GTC4Lusso", "Roma",
				"California", "812 Superfast", "Ferrari 458 Italia", "Ferrari 430 Scuderia", "Ferrari 360 Modena",
				"Ferrari F12 Berlinetta", "Ferrari Enzo", "Ferrari 250 GTO", "Ferrari F355", "Ferrari 550 Maranello"));

		coches.put("Lamborghini",
				List.of("Aventador", "Huracán", "Gallardo", "Urus", "Countach", "Diablo", "Murciélago",
						"Lamborghini Centenario", "Lamborghini Sián", "Lamborghini Reventón", "Lamborghini Miura",
						"Lamborghini Espada", "Lamborghini Jarama", "Lamborghini 350 GT"));

		coches.put("BYD", List.of("Tang EV", "Song EV", "Qin EV", "Yuan EV", "e6", "T3", "F3DM", "S6", "E6 Plus",
				"BYD Han EV", "BYD Atto 3", "BYD Dolphin", "BYD Seagull"));

		coches.put("NIO", List.of("ES8", "ES6", "EC6", "ET7", "ET5", "ES7", "NIO ET7", "NIO EC6"));

		coches.put("XPeng", List.of("P7", "G3", "P5", "G9", "XPeng X2", "XPeng P7 Wing"));

		coches.put("Li Auto", List.of("Li ONE", "Li L9", "Li L8"));

		coches.put("Geely",
				List.of("Geometry A", "Geometry C", "Geometry EX3", "Geely Emgrand EV", "Geely Lynk & Co 01 EV"));

		coches.put("BYTON", List.of("M-Byte", "K-Byte"));

		coches.put("Great Wall Motors",
				List.of("ORA Good Cat", "ORA Black Cat", "ORA Funky Cat", "HAVAL H9 EV", "HAVAL H6 EV"));

		coches.put("Wuling", List.of("Wuling Hongguang Mini EV", "Wuling Baojun E100", "Wuling E200"));

		coches.put("SAIC Motor", List.of("MG ZS EV", "MG Marvel R", "MG4 Electric", "Roewe Ei5", "Roewe RX5 EV"));

		coches.put("Tianjin FAW Xiali", List.of("Xiali EV", "Xiali V2 EV"));

		
		// Declaro todas las marcas de motos junto con sus modelos
		motos.put("Zontes", List.of("G1-125", "G1-125 X", "U1-125", "GK125", "R310", "T310", "X310", "GK350", "Z2-350",
				"Z3-350", "Z4-350", "V310", "M310", "E125", "C125", "E350", "Mantis 125", "Scrambler 125"));
		motos.put("CFMOTO", List.of("125NK", "300NK", "300SR", "650NK", "650MT", "650GT", "700CL-X Heritage",
				"700CL-X Sport", "700CL-X Adventure", "800MT", "Papio 125", "300GT-E", "300CL-X"));
		motos.put("QJ Motor", List.of("SRK 125", "SRV 125", "SRK 250", "SRV 250", "SRK 350", "SRV 350", "SRT 500",
				"SRK 500", "SRV 500", "SRT 700", "SRK 700", "SRV 700", "SRK 1000", "SRV 1000", "SRT 1000"));
		motos.put("Voge", List.of("125R", "125AC", "300R", "300AC", "300DS", "500R", "500AC", "500DS", "500DSX",
				"650DS", "650DSX", "900DS", "900DSX", "SR4 Max", "SR1 125"));
		motos.put("Benelli", List.of("BN 125", "Leoncino 125", "302S", "Leoncino 500", "TRK 502", "502C", "752S",
				"Leoncino 800", "TRK 702", "TRK 800", "Imperiale 400"));
		motos.put("Yamaha",
				List.of("MT-125", "YZF-R125", "XSR125", "MT-03", "YZF-R3", "XSR300", "MT-07", "YZF-R7", "XSR700",
						"MT-09", "YZF-R9", "XSR900", "Tracer 7", "Tracer 9", "Tenere 700", "Tenere 900", "Niken",
						"Niken GT"));
		motos.put("Honda",
				List.of("CB125R", "CBR125R", "CB125F", "CB300R", "CBR300R", "CB500F", "CBR500R", "CB500X", "CB650R",
						"CBR650R", "NC750S", "NC750X", "CB750 Hornet", "CBR750R", "CB1000R", "CBR1000RR-R Fireblade",
						"Africa Twin", "Gold Wing"));
		motos.put("Kawasaki",
				List.of("Z125", "Ninja 125", "Z250", "Ninja 250", "Z400", "Ninja 400", "Z650", "Ninja 650", "Z900",
						"Ninja ZX-6R", "Z1000", "Ninja ZX-10R", "Versys-X 300", "Versys 650", "Versys 1000", "Vulcan S",
						"Vulcan 900", "Vulcan 1700"));
		motos.put("Ducati",
				List.of("Monster", "Scrambler Icon", "Scrambler Nightshift", "Scrambler Desert Sled", "Panigale V2",
						"Panigale V4", "Panigale V4 S", "Panigale V4 R", "SuperSport 950", "Streetfighter V2",
						"Streetfighter V4", "Streetfighter V4 S", "Multistrada V2", "Multistrada V4",
						"Multistrada V4 S", "Diavel 1260", "XDiavel"));
		motos.put("KTM",
				List.of("125 Duke", "RC 125", "200 Duke", "390 Duke", "RC 390", "690 Duke", "790 Duke", "890 Duke R",
						"1290 Super Duke R", "1290 Super Duke GT", "390 Adventure", "790 Adventure", "890 Adventure",
						"1290 Super Adventure S", "1290 Super Adventure R", "450 Rally", "Freeride E-XC"));
		motos.put("Suzuki", List.of("GSX-8S", "V-Strom 800DE", "V-Strom 1050", "V-Strom 1050DE", "Avenis 125",
				"Burgman Street 125EX"));
		motos.put("BMW", List.of("F900R", "F850GS", "F750GS"));
		motos.put("Harley-Davidson",
				List.of("Road Glide Limited", "Road King Special", "Low Rider ST", "Fat Bob 114", "Low Rider S",
						"Sport Glide", "Street Bob 114", "Softail Standard", "Softail Heritage Classic 114",
						"Fat Boy 114", "Ultra Limited"));
		motos.put("Triumph", List.of("Daytona 955i", "Legend TT", "Street Triple", "Speed Triple", "Sprint",
				"Tiger 800", "Tiger 1050", "Tiger Explorer"));
		motos.put("Aprilia",
				List.of("RS 660", "Tuono 660", "RSV4", "Tuono V4", "Tuareg 660", "Shiver 900", "Dorsoduro 900"));
		motos.put("Zongshen",
				List.of("RX1", "RX3", "RX4", "RC3", "RZ3", "ZS 50 GY", "ZS 110-26", "ZS 125-2", "ZS 125-4",
						"ZS 125 GY-Un", "ZS 125 ST ATV", "ZS 125 T-7", "ZS 125 T-8", "ZS 150 GY", "ZS 200 GY",
						"ZS 250 GY-3", "ZS 125 T-30", "ZS 200 GS", "ZS 250 GS", "ZS 250-5", "Zx 200", "Z One S", "Z II",
						"ZS125-67"));
		motos.put("Lexmoto", List.of("LXR 125", "LXS 125", "Isca 125", "ZSB 125", "Michigan 125", "Vendetta 250"));
		motos.put("Lifan", List.of("KPR 200", "KPT 200", "KP 150", "LF150-10S", "LF125-14F", "LF250GY-2"));
		motos.put("SYM",
				List.of("Jet 14 125", "Symphony ST 125", "Cruisym 125", "Fiddle III 125", "NH-T 125", "Maxsym TL 500"));
		motos.put("Loncin", List.of("GP 150", "CR 9", "LX 650", "DS8", "Voge 500R", "Voge 500DS"));

	}

	// Método para obtener todas las marcas de los coches
	public Set<String> getMarcasCoches() {
		return coches.keySet();
	}

	// Método para obtener todas las marcas de las motos
	public Set<String> getMarcasMotos() {
		return motos.keySet();
	}

	// Método para obtener todos los modelos de un coche pasandole la marca
	public List<String> getModelosCochePorMarca(String marca) {
		return coches.getOrDefault(marca, List.of());
	}

	// Método para obtener todos los modelos de una moto pasandole la marca
	public List<String> getModelosMotoPorMarca(String marca) {
		return motos.getOrDefault(marca, List.of());
	}
}