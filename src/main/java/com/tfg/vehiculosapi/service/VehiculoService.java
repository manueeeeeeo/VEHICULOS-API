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
				List.of("Corolla", "Camry", "Celica", "Supra", "Land Cruiser", "Hilux", "Prius", "Yaris", "RAV4", "Avalon",
				        "4Runner", "Sequoia", "Sienna", "Tacoma", "Tundra", "Aygo", "Avensis", "Verso", "C-HR", "bZ4X",
				        "Coaster", "AE86", "Urban Cruiser", "Auris", "Hiace", "Echo", "FJ Cruiser", "Matrix", "Paseo",
				        "Previa", "Starlet", "Tercel", "Venza", "Scion", "MR2", "Cressida", "Crown", "Mark II", "Corona",
				        "Voxy", "Esquire", "ProAce", "IQ", "Rush", "Granvia", "LiteAce", "TownAce", "Raize", "Sprinter",
				        "Verossa", "Windom", "Harrier", "Reiz", "Fortuner", "Avanza", "Cavalier", "Soluna", "Blade",
				        "Spade", "Vitz", "Belta", "Echo Verso", "Noah", "Ractis", "Raum", "Sienta", "Wish", "Etios",
				        "Probox", "Passo", "Pixis", "Tacoma X-Runner", "Solara", "Scion xA", "Scion xB", "Scion tC",
				        "Scion FR-S", "Scion iQ", "Scion iM"));

		coches.put("Ford",
				List.of("Model T", "Model A", "Anglia", "Prefect", "Consul", "Zephyr", "Cortina", "Capri", "Escort", "Fiesta",
				        "Granada", "Sierra", "Scorpio", "Mondeo", "Focus", "Ka", "Puma", "Fusion", "B-Max", "C-Max",
				        "S-Max", "Galaxy", "Kuga", "EcoSport", "Edge", "Mustang", "Thunderbird", "Falcon", "Torino",
				        "Fairlane", "LTD", "Crown Victoria", "Taurus", "Probe", "Tempo", "Contour", "Five Hundred",
				        "Freestyle", "Flex", "Fusion (USA)", "Maverick", "Bronco", "Explorer", "Expedition", "Excursion",
				        "Ranger", "F-150", "F-250", "F-350", "F-450", "F-550", "Courier", "Transit", "Transit Connect",
				        "Transit Custom", "Tourneo Connect", "Tourneo Custom", "E-Series", "Aerostar", "Windstar",
				        "Freestar", "Courier (Europe)", "P100", "Puma (2020)", "Territory", "Everest", "Endeavour",
				        "Ikon", "Aspire", "Laser", "Telstar", "Meteor", "Spectron", "Fred", "Ixion", "Ixion (Asia)",
				        "Lynx", "Verona", "Escape", "Freestyle (India)", "EcoSport (India)", "Endura", "Corsair",
				        "Del Rey", "Corcel", "Verona", "Royale", "Landau", "Galaxy (Brasil)", "Deluxe", "Custom",
				        "Mainline", "Fairmont", "Meteor", "Parklane", "Skyliner", "Sunliner", "Starliner", "Sunliner",
				        "Victoria", "Crestline", "Crown Victoria", "Customline", "Deluxe", "Elite", "Gran Torino",
				        "LTD II", "Ranchero", "Ranch Wagon", "Country Squire", "Country Sedan", "Club Wagon",
				        "Club Coupe", "Business Coupe", "Custom 500", "Custom 300", "Custom Deluxe", "Deluxe",
				        "Super Deluxe", "Standard", "V8", "Model 48", "Model 68", "Model 78", "Model 81A", "Model 91A"));

		coches.put("Volkswagen",
				List.of("Beetle", "Golf", "Passat", "Polo", "Tiguan", "Touareg", "Jetta", "Arteon", "ID.3", "ID.4",
				        "ID.5", "ID. Buzz", "Scirocco", "Sharan", "Up!", "Eos", "Amarok", "Transporter", "Caravelle",
				        "Lupo", "Corrado", "Phaeton", "Golf Plus", "Golf Variant", "CC", "T-Cross", "T-Roc", "Taigo",
				        "Fox", "Bora", "Vento", "Santana", "Caddy", "California", "Multivan", "Crafter", "LT", "Karmann Ghia",
				        "Type 3", "Type 4", "Thing", "Routan", "Atlas", "Atlas Cross Sport", "Saveiro", "Gol", "Voyage",
				        "Parati", "Pointer", "Derby", "Kübelwagen", "Karmann Ghia TC", "Brasilia", "SP2", "Variant",
				        "1500", "1600", "181", "Fridolin", "Iltis", "XL1", "e-Golf", "e-Up!", "ID.6", "ID.7"));

		coches.put("BMW",
				List.of("1 Series", "2 Series", "3 Series", "4 Series", "5 Series", "6 Series", "7 Series", "8 Series", 
						"X1", "X2", "X3", "X4", "X5", "X6", "X7", "Z4", "M2", "M3", "M4", "M5", 
						"M6", "M8", "X5 M", "X6 M", "X3 M", "X4 M", "Z3", "Z8", "1 Series M", 
						"2 Series Gran Coupé", "3 Series Gran Turismo", "4 Series Gran Coupé", "5 Series Gran Turismo", 
						"6 Series Gran Coupé", "X3 xDrive", "X4 xDrive", "i3", "i4", "i8", "iX", "iX3", 
						"i4 M50", "2 Series Active Tourer", "2 Series Gran Tourer", "3 Series Touring", 
						"4 Series Convertible", "4 Series Gran Coupé", "5 Series Touring", "7 Series L", "8 Series Gran Coupé", 
						"M8 Gran Coupé", "X1 xDrive", "X2 xDrive", "X7 xDrive", "BMW iX M60", "X5 xDrive", 
						"X6 xDrive", "X3 M40i", "X4 M40i", "X6 M50i", "X7 M50i", "BMW 4 Series Coupé", 
						"3 Series Coupé", "3 Series Sedan", "M5 Competition", "M4 Competition", "M2 Competition", 
						"M850i", "Z4 M40i"));

		coches.put("Audi", List.of("A1", "A3", "A4", "A5", "A6", "A7", "A8", "Q2", "Q3", "Q4", "Q5", "Q7", "Q8", "R8", "TT", "S1", "S3", "S4", 
		        "S5", "S6", "S7", "S8", "RS3", "RS4", "RS5", "RS6", "RS7", "RS Q3", "RS Q5", "Q5 TFSI e", "Q7 TFSI e", "Q8 TFSI e", 
		        "E-Tron", "E-Tron GT", "A1 Citycarver", "A3 Sportback", "A3 Cabriolet", "A4 Allroad", "A5 Cabriolet", "A6 Allroad", 
		        "A7 Sportback", "A8 L", "Q3 Sportback", "Q5 Sportback", "Q8 Sportback", "A8 TFSI e", "Q3 TFSI e", "A4 Avant", "S1 Sportback", 
		        "A6 Avant", "A7 Avant", "A4 Limousine", "Q7 e-tron", "Q5 e-tron", "Q8 e-tron", "A4 TFSI e", "A6 TFSI e", "RS Q5", "RS Q8", 
		        "S Q7", "S Q8", "S3 Sportback", "RS3 Sportback", "Q2 TFSI e", "SQ5", "RS Q7"));

		coches.put("Mercedes-Benz",
				List.of("A-Class", "B-Class", "C-Class", "E-Class", 
						"S-Class", "G-Class", "CLA", "CLS", 
						"GLA", "GLB", "GLC", "GLE", "GLS", 
						"SLC", "SL", "AMG GT", "EQC", "EQS", 
						"EQB", "EQE", "C-Class Coupe", "C-Class Cabriolet", 
						"E-Class Coupe", "E-Class Cabriolet", "S-Class Coupe", 
						"S-Class Cabriolet", "A-Class Sedan", "C-Class Sedan", 
						"S-Class Sedan", "G-Class Cabriolet", "B-Class Electric Drive", 
						"A-Class Electric", "ME-Class Electric", "GLE Coupe", 
						"GLC Coupe", "G-Class G 63 AMG", "GLB 35 AMG", 
						"GLC 63 AMG", "GLE 63 AMG", "GLS 63 AMG", "SLS AMG", 
						"AMG GT 4-Door", "V-Class", "EQS 580 4MATIC", 
						"EQA", "EQV", "A-Class Hatchback", "B-Class Hatchback", 
						"C-Class Estate", "E-Class Estate", "S-Class Maybach", 
						"A-Class Limousine", "C-Class Limousine", "G-Class 4x4²", 
						"X-Class", "Maybach S-Class", "EQB 350 4MATIC", 
						"S-Class Sedan", "EQS 450+"));

		coches.put("Nissan",
				List.of("350Z", "370Z", "Altima", "Armada", "Ariya", "Cube", "Frontier", "GT-R", "Juke", "Leaf", "Maxima", "Micra", "Murano", 
				        "Navara", "NP300", "Pathfinder", "Patrol", "Pathfinder", "Qashqai", "Rogue", "Sentra", "Silvia", "Skyline", "Tiida", 
				        "Versa", "X-Trail", "Z"));

		coches.put("Hyundai", List.of("i10", "i20", "i30", "i40", "iX20", "iX35", "Tucson", "Kona", "Santa Fe", "Elantra", "Sonata", 
		        "Veloster", "Palisade", "Accent", "Getz", "H-1", "Starex", "Nexo", "Ioniq", "Ioniq 5", "Ioniq 6", 
		        "Grandeur", "Azera", "Trajet", "Entourage", "Matrix", "Eon", "Veracruz", "KONA Electric", 
		        "Santa Fe Plug-In Hybrid", "Ioniq Plug-In Hybrid", "Nexo Fuel Cell", "Elantra GT", 
		        "Coupe", "Genesis", "Genesis Coupe", "Equus", "Tiburon", "Accent Electric", "Tuscani", "Creta", 
		        "Bayon", "i30 N", "Veloster N", "i40 Tourer", "i30 Fastback", "i30 Wagon", "Sonata Hybrid", "Elantra Hybrid"));

		coches.put("Kia", 
				List.of("Brisa", "Pride", "Sephia", "Sportage", "Carnival", "Rio", "Sorento", "Optima", "Picanto", "Cerato", 
				        "Carens", "Cadenza", "Soul", "Venga", "Stinger", "Stonic", "Telluride", "Seltos", "K5", "K8", "K9", 
				        "EV3", "EV6", "EV9", "Mohave", "Bongo", "K2700", "Granbird", "Avella", "Clarus", "Concord", "Shuma", "Joice", 
				        "Opirus", "Amanti", "Borrego", "Rondo", "Quoris", "K900", "Ceed", "ProCeed", "XCeed", "Niro", "Sonet", 
				        "Soluto", "Morning", "Ray", "Koup", "Forte", "K2500", "Pregio", "Besta", "Retona", "Elan", "Enterprise", 
				        "Capital", "Lotze", "Combi", "Potentia", "K360", "Towner", "Visto", "Spectra", "Mentor", "Sephia II", 
				        "Credos", "K7", "K3", "K2", "K1", "K4", "KX3", "KX5", "KX7", "Pegas", "Pegas II"));

		coches.put("Peugeot",
			    List.of(
			        "208", "308", "508", "2008", "3008", "5008", "Rifter", "Partner", "Expert", "Boxer", 
			        "208 GTi", "308 GTi", "RCZ", "3008 Hybrid", "5008 Hybrid", "607", "406", "407", 
			        "605", "Talbot Horizon", "Type 2", "Type 3", "Type 6", "Bébé", "Quadrilette", 
			        "173", "201", "301", "401", "402", "202", "203", "403", "404", "504", "505", 
			        "604", "104", "205", "206", "207", "306", "307", "405", "905", "e-208", "e-2008", 
			        "e-Expert", "e-Boxer", "L500 R Hybrid", "Oxia", "Proxima", "SR1", "Onyx", "Fractal", 
			        "205 GTi", "205 Turbo 16", "806", "605"
			    )
			);

		coches.put("Renault",
				List.of("4", "5", "6", "9", "11", "12", "14", "15", "16", "17", "18", "19", "20", "21", "25", "30", "Clio", 
				        "Mégane", "Scénic", "Laguna", "Twingo", "Espace", "Kangoo", "Modus", "Koleos", "Captur", "Kadjar", 
				        "Arkana", "Austral", "Rafale", "Kwid", "Alaskan", "Duster", "Sandero", "Logan", "Symbol", "Fluence", 
				        "Latitude", "Wind", "Zoe", "Twizy", "Avantime", "Vel Satis", "Trafic", "Master", "Express", "Pulse", 
				        "Scala", "Kiger", "Triber", "Oroch", "Lodgy", "Dokker", "Nepta", "Nervasport", "Monaquatre", "Celtaquatre", 
				        "Juvaquatre", "Dauphine", "Caravelle", "Fregate", "Estafette", "Primaquatre", "Vivaquatre", "Monastella", 
				        "Reinastella", "Vivasport", "Vivastella", "Nervastella", "Suprastella", "Colorale", "Goélette", "Frégate", 
				        "R8", "R10", "R16", "R17", "R20", "R30", "Rodeo", "Fuego", "Alliance", "Encore", "Medallion", "Premier", 
				        "Safrane", "Spider", "Clio V6", "Kangoo Be Bop", "Samsung SM3", "Samsung SM5", "Samsung SM7", "Samsung QM3", 
				        "Samsung QM5", "Samsung QM6", "Samsung XM3", "Samsung Twizy", "Samsung Zoe", "Samsung Captur", "Samsung Arkana", 
				        "Samsung Koleos", "Samsung Talisman", "Samsung Latitude", "Samsung Fluence", "Samsung Scala", "Samsung Pulse", 
				        "Samsung Kiger", "Samsung Triber", "Samsung Kwid", "Samsung Alaskan", "Samsung Duster", "Samsung Sandero", 
				        "Samsung Logan", "Samsung Symbol", "Samsung Wind", "Samsung Avantime", "Samsung Vel Satis", "Samsung Trafic", 
				        "Samsung Master", "Samsung Express", "Samsung Oroch", "Samsung Lodgy", "Samsung Dokker", "Samsung Nepta", 
				        "Samsung Nervasport", "Samsung Monaquatre", "Samsung Celtaquatre", "Samsung Juvaquatre", "Samsung Dauphine", 
				        "Samsung Caravelle", "Samsung Fregate", "Samsung Estafette", "Samsung Primaquatre", "Samsung Vivaquatre", 
				        "Samsung Monastella", "Samsung Reinastella", "Samsung Vivasport", "Samsung Vivastella", "Samsung Nervastella", 
				        "Samsung Suprastella", "Samsung Colorale", "Samsung Goélette", "Samsung Frégate", "Samsung R8", "Samsung R10", 
				        "Samsung R16", "Samsung R17", "Samsung R20", "Samsung R30", "Samsung Rodeo", "Samsung Fuego", "Samsung Alliance", 
				        "Samsung Encore", "Samsung Medallion", "Samsung Premier", "Samsung Safrane", "Samsung Spider", "Samsung Clio V6", 
				        "Samsung Kangoo Be Bop"));

		coches.put("Chevrolet",
				List.of("490", "Suburban", "Fleetmaster", "Stylemaster", "Advance Design", "Fleetline", "Bel Air", "Corvette", "Impala", 
				        "Brookwood", "Biscayne", "El Camino", "Corvair", "400", "Chevy II / Nova", "Chevelle", "Malibu", "Caprice", "Camaro", 
				        "Vega", "Monte Carlo", "LUV", "Silverado", "Chevette", "Van", "Citation", "Celebrity", "Cavalier", "S-10", "Blazer", 
				        "Astro", "Corsica", "Beretta", "Lumina APV", "Lumina", "Geo Prizm", "Tracker", "Corsa", "Vectra", "Astra", "Tahoe", 
				        "Express", "Venture", "Spark", "Sail", "Zafira", "TrailBlazer", "Avalanche", "Sonic", "Optra", "SSR", "Equinox", "Cobalt", 
				        "Colorado", "HHR", "Uplander", "Captiva", "Aveo", "Agile", "Cruze", "Volt", "Onix", "Bolt", "Trax", "Traverse", "Orlando", 
				        "Spin", "Prisma", "Niva"));

		coches.put("Mazda",
			    List.of(
			        "2", "3", "6", "5", "MX-5", "CX-3", "CX-30", "CX-5", 
			        "CX-7", "CX-9", "CX-60", "CX-70", "CX-80", "CX-90", "BT-50", "MX-30", 
			        "RX-7", "RX-8", "121", "323", "626", "929", "Serie B Pickup", "Millenia", 
			        "Allegro", "Cosmo", 
			        "1000", "1300", "1500", "1600", "1800", "2000", "2100", "2200", 
			        "3100", "3300", "3400", "3500", "3600", "3700", "3800", "3900", 
			        "4000", "4100", "4200", "4300", "4400", "4500", "4600", "4700", 
			        "4800", "4900", "5000", "5100", "5200", "5300", "5400", "5500", 
			        "5600", "5700", "5800", "5900", "6000", "6100", "6200", "6300", 
			        "6400", "6500", "6600", "6700", "6800", "6900", "7000", "7100", 
			        "7200", "7300", "7400", "7500", "7600", "7700", "7800", "7900", 
			        "8000", "8100", "8200", "8300", "8400", "8500", "8600", "8700", 
			        "8800", "8900", "9000", "9100", "9200", "9300", "9400", "9500", 
			        "9600", "9700", "9800", "9900", "10000", 
			        "B-Series", "E-Series", "F-Series", "G-Series", "H-Series", "L-Series", 
			        "MPV", "Navajo", "Protege", "Protege5", "Tribute", "Verisa", "Xedos 6", 
			        "Xedos 9", "Carol", "Demio", "Flair", "Scrum", "Proceed", "Proceed Levante", 
			        "RX-2", "RX-3", "RX-4", "RX-5", "RX-6", "RX-9", "Rotary Pickup", 
			        "MX-3", "MX-6", "MX-8", "Premacy", "Sentia", "Titan", "Roadpacer", 
			        "Revue", "Rustler", "Savanna", "Spiano", "Unser", "Vantrend", "Voltz"
			    )
			);

		coches.put("Seat", List.of("600", "850", "124", "1430", "127", "128", "131", "132", "133", 
				"1430", "1500", "1600", "1800", "2000", "850 Sport Coupé", "124 Sport Coupé", 
				"127 Sport", "128 Sport", "131 Mirafiori", "132 E", "133 Fura", "1430 Especial", 
				"1500 Especial", "1600 Coupé", "1800 Sport", "2000 Sport", "León", "Ibiza", 
				"Toledo", "Córdoba", "Alhambra", "Ateca", "Arona", "Tarraco", "Mii", "Exeo", 
				"León ST", "León X-PERIENCE", "Ateca Xperience", "Arona Xperience", "Tarraco FR", 
				"Ibiza FR", "León CUPRA", "Ibiza CUPRA", "León e-HYBRID", "Ibiza e-HYBRID", 
				"Tarraco e-HYBRID", "MÓ 50", "MÓ 125", "MÓ 125 Performance"));

		coches.put("Skoda", List.of("Citigo", "Fabia", "Octavia", "Superb", "Rapid", "Kodiaq", 
				"Karoq", "Yeti", "Scala", "Kamiq", "Roomster", "Felicia", "120", 
				"130", "1000 MB", "110", "120 L", "110 R", "Favorit", "Forman", 
				"130 RS", "Monte Carlo", "Superb Combi", "Octavia Combi", "Citigo-e iV", 
				"Enyaq iV", "Superb iV", "Octavia iV", "Fabia Combi", "Octavia Scout", 
				"Superb Scout", "Kodiaq RS", "Rapid Spaceback", "Karoq Scout", "Citigo-e", 
				"Superb Laurin & Klement", "Vision iV", "Kodiaq L&K", "Octavia RS", 
				"Scala Monte Carlo", "Karoq Sportline", "Yeti Outdoor", "Roomster Scout", 
				"Superb Plug-in Hybrid", "Enyaq Coupe iV"));

		coches.put("Citroën",
				List.of("2CV", "Ami", "BX", "C1", "C2", "C3", "C4", 
						"C5", "C6", "C8", "DS", "DS3", "DS4", "DS5", 
						"DS7 Crossback", "E-Mehari", "Jumpy", "Jumper", "Berlingo", 
						"Xsara", "Xsara Picasso", "Nemo", "C3 Picasso", 
						"Grand C4 Picasso", "C4 Cactus", "C4 SpaceTourer", 
						"C5 Aircross", "C6 Aircross", "Aircross", "Picasso", 
						"C-Zero", "C3 Aircross", "C4 Aircross", "Grand C4 SpaceTourer", 
						"Spacetourer", "ë-C4", "ë-Jumpy", "ë-Berlingo", 
						"ë-Dispatch", "DS7", "DS9", "E-C4", "C4 X", 
						"C3 X", "C1 Airflow", "C3 Airflow", "CXperience", 
						"Traction Avant", "LNA", "Xantia", "Visa", "BX 4TC"));

		coches.put("Tesla", List.of("Model S", "Model 3", "Model X", "Model Y", "Roadster", "Cybertruck", 
				"Semi", "Model S Plaid", "Model 3 Performance", "Model Y Performance", "Model X Plaid", 
				"Model S Long Range", "Model 3 Long Range", "Model X Long Range", "Model Y Long Range", 
				"Roadster 2.0", "Model S P85", "Model S P90D", "Model S P100D", "Model 3 Standard Range", 
				"Model 3 Standard Range Plus", "Model X 75D", "Model X 90D", "Model X 100D", "Model S 85D", 
				"Model S 70D", "Model 3 Dual Motor", "Model 3 AWD", "Model X Dual Motor", "Model X AWD", 
				"Model Y Dual Motor", "Model Y AWD", "Model 3 RWD", "Model S Signature Series", 
				"Roadster Sport", "Roadster Founders Series", "Model X Signature Edition", 
				"Model Y Standard Range", "Cybertruck Tri Motor", "Cybertruck Dual Motor", 
				"Cybertruck Single Motor", "Model S Dual Motor", "Model S Performance", 
				"Model 3 Performance Dual Motor", "Model X Plaid+"));

		coches.put("Rolls-Royce",
				List.of("Phantom", "Ghost", "Wraith", "Dawn", "Cullinan", 
						"Silver Spirit", "Silver Shadow", "Silver Spur", "Corniche", 
						"Silver Cloud", "Silver Wraith", "Park Ward", "Phantom II", 
						"Phantom III", "20/25", "40/50", "Silver Seraph", 
						"Boat Tail", "Spectre", "Silver Dawn", "10 HP", 
						"Silver Ghost", "Phantom IV", "Silver Arrow", "Dawn Drophead", 
						"Series I", "Series II", "Series III", "Silver Eagle", 
						"Cloud II", "Cloud III"));
		
		coches.put("Abarth",
			    List.of(
			        "595", "595 Competizione", "595 Turismo", "695 Biposto", "695 Competizione", 
			        "695 Rivale", "124 Spider", "500", "500C", "500X", "Punto Evo Abarth", 
			        "Grande Punto Abarth", "500 Abarth", "500L", "500X Abarth", 
			        "1000", "1300", "1600", "2000", "2400", "750", "850", "850 TC", 
			        "1000 GT", "1300 GT", "205", "207", "208", "209", "210", "211", 
			        "212", "213", "214", "215", "216", "217", "218", "219", "220", 
			        "221", "222", "223", "224", "225", "226", "227", "228", "229", 
			        "230", "231", "232", "233", "234", "235", "236", "237", "238", 
			        "239", "240", "241", "242", "243", "244", "245", "246", "247", 
			        "248", "249", "250", "251", "252", "253", "254", "255", "256", 
			        "257", "258", "259", "260", 
			        "A112", "A112 Abarth", "Autotela 1100", "Simca 1300", "Fiat 124 Abarth", 
			        "Fiat 131 Abarth", "Fiat Ritmo Abarth", "Fiat Uno Abarth", "Fiat Panda Abarth", 
			        "Abarth 600", "Abarth 1000 SP", "Abarth 205A", "Abarth 207A", "Abarth OT 1600", 
			        "Abarth OT 2000", "Abarth 1000 Berlina", "Abarth 1300", "Abarth 2000", 
			        "Abarth 2400", "Abarth 3000", "Abarth 3500", "Abarth 4000", "Abarth 5000"
			    )
			);
		
		coches.put("Alfa Romeo",
			    List.of(
			        "Giulia", "Giulietta", "Stelvio", "Tonale", "33 Stradale", "8C Competizione", 
			        "4C", "MiTo", "Brera", "Spider", "GT", "159", "156", "147", "145", "146", 
			        "75", "90", "Alfetta", "GTV", "Montreal", "Sud", "33", "164", "166", 
			        "2000", "2600", "1900", "6C", "8C", "RL", "RM", "P2", "P3", "Tipo B", 
			        "Tipo C", "Tipo 158", "Tipo 159", "Tipo 33", "Tipo 33/2", "Tipo 33/3", 
			        "Tipo 33TT12", "Tipo 33SC", "SZ", "RZ", "Junior Zagato", "GTA", "GTV6", 
			        "Alfasud Sprint", "Arna", "Duetto", "2000 Spider Veloce", "2600 Spider", 
			        "4C Spider", "8C Spider", "Disco Volante", "Carabo", "Navajo", "Caimano", 
			        "Iguana", "Proteo", "Scighera", "Nuvola", "Visconti", "Kamal", "Bertone", 
			        "Giulietta Sprint", "Giulietta Spider", "Giulia Sprint GT", "Giulia Super", 
			        "Giulia TZ", "Giulia GTA", "Giulia Sprint Speciale", "Fiat 132 Alfa Romeo", 
			        "Fiat Ritmo Abarth", "Fiat Uno Abarth", "Fiat Panda Abarth"
			    )
			);
		
		coches.put("Aston Martin",
			    List.of(
			        "DB5", "DB6", "DB7", "DB9", "DB11", "DB12", "DBS", "DBS Superleggera", 
			        "V8 Vantage", "V12 Vantage", "Vantage", "Vanquish", "Virage", "Lagonda", 
			        "Rapide", "Cygnet", "One-77", "Valkyrie", "Valhalla", "Victor", "Vulcan", 
			        "DB2", "DB3", "DB4", "DBR1", "DBR2", "DBR3", "DBR4", "DBR5", "DBR9", 
			        "DBS V12", "DB10", "DBX", "DBX707", "AMR One", "AMR21", "AMR22", 
			        "Atom", "Bulldog", "CC100", "DP214", "DP215", "DP100", "DP212", 
			        "Lagonda Taraf", "Lagonda Vision Concept", "Lagonda All-Terrain", 
			        "Nieuport", "RHAM/1", "RHAM/2", "RHAM/3", "Ulster", "V8 Zagato", 
			        "V8 Vantage Zagato", "V8 Volante", "V8 Coupe", "V8 Saloon", "V8 Shooting Brake", 
			        "V12 Speedster", "V12 Zagato", "V12 Vanquish Zagato", "Vantage GT8", 
			        "Vantage GT12", "Vantage GT4", "Vantage N430", "Vantage S", "Vantage AMR", 
			        "Vanquish Zagato", "Vanquish Volante", "Vanquish Shooting Brake", 
			        "Virage Volante", "Virage Coupe", "Zagato Centenary", "Zagato Heritage", 
			        "Zagato Tribute", "Zagato Future", "Zagato Vision"
			    )
			);
		
		coches.put("Bentley",
			    List.of(
			        "Blower 4½ Litre", "Continental GT", "Continental GT Speed", "Continental GT V8", 
			        "Flying Spur", "Flying Spur V8", "Mulsanne", "Mulsanne Speed", 
			        "Bentayga", "Bentayga Speed", "Bentayga Hybrid", "Arnage", "Brooklands", 
			        "Mark VI", "Turbo R", "Azure", "Continental Flying Spur", "Continental GT W12", 
			        "3 Litre", "4 Litre", "6 Litre", "8 Litre", "S1", "S2", "S3", 
			        "T-Series", "R-Type", "R-Type Continental", "Continental S", "Continental T", 
			        "Continental SC", "Continental GTC", "Continental Supersports", "Continental GT Convertible", 
			        "Continental GTC Speed", "Continental GTC V8", "Continental GT V8 S", 
			        "Continental GT Mulliner", "Continental GT Mulliner Convertible", "Continental GT Z", 
			        "Bentayga EWB", "Bentayga Azure", "Bentayga S", "Bentayga Odyssean", 
			        "Bentayga First Edition", "Bentayga Hybrid Extended Range", "Bentayga PHEV", 
			        "Azure Coupe", "Azure Convertible", "Azure Saloon", "Azure LWB", 
			        "Azure R", "Azure T", "Azure Turbo", "Azure Turbo R", 
			        "Azure Turbo RL", "Azure Turbo RS", "Azure Turbo RT", 
			        "Azure Turbo RW", "Azure Turbo RX", "Azure Turbo RZ", 
			        "Azure Turbo RY", "Azure Turbo RZ", "Azure Turbo RA", 
			        "Azure Turbo RB", "Azure Turbo RC", "Azure Turbo RD", 
			        "Azure Turbo RE", "Azure Turbo RF", "Azure Turbo RG", 
			        "Azure Turbo RH", "Azure Turbo RI", "Azure Turbo RJ", 
			        "Azure Turbo RK", "Azure Turbo RL", "Azure Turbo RM", 
			        "Azure Turbo RN", "Azure Turbo RO", "Azure Turbo RP", 
			        "Azure Turbo RQ", "Azure Turbo RR", "Azure Turbo RS", 
			        "Azure Turbo RT", "Azure Turbo RU", "Azure Turbo RV", 
			        "Azure Turbo RW", "Azure Turbo RX", "Azure Turbo RY", 
			        "Azure Turbo RZ"
			    )
			);
		
		coches.put("Dacia",
			    List.of(
			        "Logan", "Sandero", "Lodgy", "Dokker", "Spring", "Dokker Van", "Lodgy Stepway", 
			        "Sandero Stepway", "Logan MCV", "Logan Stepway", "Spring Electric", "Jogger", 
			        "1300", "1310", "1410", "2000", "Nova", "Pick-Up", "Solenza", "Berlina", 
			        "Break", "Van", "Duster", "Duster Oroch", "Duster Commercial", "Duster Stepway", 
			        "Lodgy Combi", "Bigster", "Manifesto", "EZ-Pro", "EZ-Ultimo", "EZ-GO", 
			        "EZ-Van"
			    )
			);
		
		coches.put("DS",
			    List.of(
			        "3", "3 Crossback", "3 E-Tense", "4", "4 Crossback", "4 E-Tense", 
			        "5", "5 LS", "5 E-Tense", "7", "7 Crossback", "7 E-Tense", 
			        "E-Tense Performance", "E-Tense FE21", "X E-Tense", 
			        "21", "23", "19", "20", "21 Pallas", 
			        "23 Injection", "Divine", "Aero Sport Lounge", 
			        "Numéro 9", "Wild Rubis", "X-Motion", "E-Tense Concept", 
			        "E-Tense Vision", "4S", "6WR", "7FR", 
			        "3 Café Racer", "3 Inès de la Fressange", "3 Dark Side", 
			        "3 Rivoli", "3 Opera", "3 Performance Line", 
			        "4 Urbain", "4 Chic", "4 Rivoli", "4 Performance", 
			        "5 Hybrid4", "5 Lounge", "5 Prestige", "5 So Chic", 
			        "7 CROSSBACK La Premiere", "7 CROSSBACK Grand Chic", 
			        "7 CROSSBACK Rivoli", "7 CROSSBACK Opera", "7 CROSSBACK E-Tense 4x4", 
			        "7 CROSSBACK Monte Carlo", "7 CROSSBACK Bastille", 
			        "7 CROSSBACK Performance Line", "7 CROSSBACK Louvre", 
			        "9", "DS 9 E-Tense", "9 Opera", "9 Rivoli", 
			        "9 Grand Chic", "9 La Premiere", "9 Performance Line", 
			        "X E-Tense Concept", "Aero Sport Lounge Concept", 
			        "Numéro 10", "Numéro 11", "Numéro 12", "Numéro 13", 
			        "Numéro 14", "Numéro 15", "Numéro 16", "Numéro 17", 
			        "Numéro 18", "Numéro 19", "Numéro 20"
			    )
			);
		
		coches.put("Fiat",
			    List.of(
			        "500", "500L", "500X", "Panda", "Punto", "Tipo", "Bravo", "Cinquecento", 
			        "Multipla", "Qubo", "Freemont", "Panda 4x4", "Punto Abarth", "Punto Evo", 
			        "Sedici", "Stilo", "Linea", "Barchetta", "500E", "Doblò", "Punto Classic", 
			        "Spider 124", "Croma", "Palio", "Panda Cross", "500L Living", "500L Trekking", 
			        "124 Spider", "126", "127", "128", "131", "132", "Argenta", "Regata", 
			        "Tempra", "Marea", "Seicento", "Uno", "Duna", "Ritmo", "Strada", "Fiorino", 
			        "Scudo", "Talento", "Ducato", "Fullback", "Idea", "Grande Punto", "Nuova 500", 
			        "Topolino", "Campagnola", "X1/9", "Coupe", "Croma II", "Ulysse", "Brava", 
			        "Coupé", "Doblo Cargo", "Fiorino Qubo", "Fiorino Van", "500 Giardiniera", 
			        "500 Spiaggina", "500 Vintage", "600", "850", "1100", "1200", "1500", "1800", 
			        "2100", "2300", "2400", "Abarth 1000", "Abarth 695", "Abarth 595", "Abarth 500", 
			        "Abarth 595 Competizione", "Abarth 695 Biposto", "Abarth 595 Turismo", "Abarth 595 Esseesse"
			    )
			);
		
		coches.put("Honda",
			    List.of(
			        "Civic", "Accord", "CR-V", "HR-V", "Pilot", "Fit", "Insight", "Clarity", 
			        "CR-Z", "Ridgeline", "Element", "Element EV", "Jazz", "Prelude", "Legend", 
			        "Odyssey", "Passport", "Urban", "Brio", "City", "Crosstour", "S660", 
			        "Z360", "N-Box", "N-WGN", "Acty", "Mobilio", "Stepwgn", "CR-V Hybrid", 
			        "Clarity Fuel Cell", "Civic Type R", "NSX", "Integra", "S2000", "Beat", 
			        "Today", "Life", "Capa", "Domani", "Orthia", "Avancier", "Vezel", "Shuttle", 
			        "Freed", "Airwave", "Crossroad", "Logo", "Stream", "FR-V", "Edix", "Elysion", 
			        "That's", "Z", "T360", "Vamos", "Street", "Partner", "Horizon", "Quintet", 
			        "Concerto", "Ascot", "Inspire", "Sabre", "Torneo", "Rafaga", "Civic Ferio", 
			        "Civic Shuttle", "Civic GX", "Civic Si", "Civic Hybrid", "Accord Hybrid", 
			        "Accord Crosstour", "Accord Tourer", "Accord Aerodeck", "CR-X", "CR-X Del Sol", 
			        "CR-V Plug-in Hybrid", "e:NS1", "e:HEV", "e:Ny1", "e:Prototype"
			    )
			);
		
		coches.put("Infiniti",
			    List.of(
			        "Q50", "Q60", "Q70", "QX50", "QX60", "QX70", "QX80", "JX35", "FX35", 
			        "FX50", "M35h", "M56", "G35", "G37", "EX35", "EX37", "J30", "Q30", 
			        "QX55", "QX30", "QX56", "QX56L", "I30", "I35", "Q45", "QX4", "QX70S", 
			        "QX60 Hybrid", "QX80 Armada", "Q50 Hybrid", "Q70 Hybrid", "Q50 Red Sport", 
			        "Q60 Red Sport", "QX50 Autograph", "QX60 Autograph", "QX80 Monograph", 
			        "Q Inspiration", "QX Inspiration", "Emerg-E", "Essence", "Q80 Inspiration", 
			        "Prototype 9", "Prototype 10", "QX Sport Inspiration"
			    )
			);
		
		coches.put("Isuzu",
			    List.of(
			        "Bellel", "Bellett", "Florian", "117 Coupé", "Gemini", "Piazza", "Aska", "Impulse", 
			        "Trooper", "Rodeo", "Axiom", "MU", "MU-X", "VehiCROSS", "D-Max", "Fargo", 
			        "Como", "Forward", "Elf", "Giga", "Bighorn", "Wizard", "Amigo", "Hombre", 
			        "Journey", "Oasis", "Reach", "TFR", "TFX", "TFS", "TGT", "TWM", "TWS", 
			        "Type-61", "Type-90", "Type-91", "Type-95", "Type-100", "Type-117", "Type-130", 
			        "Type-150", "Type-180", "Type-200", "Type-240", "Type-280", "Type-300", 
			        "Type-350", "Type-400", "Type-450", "Type-500", "Type-600", "Type-700", 
			        "Type-800", "Type-900", "Type-1000", "Type-1200", "Type-1500", "Type-1800", 
			        "Type-2000", "Type-2500", "Type-3000", "Type-3500", "Type-4000", "Type-4500", 
			        "Type-5000", "Type-6000", "Type-7000", "Type-8000", "Type-9000", "Type-10000"
			    )
			);
		
		coches.put("Jaguar",
			    List.of(
			        "XE", "XF", "XJ", "F-Type", "F-Pace", "E-Pace", "I-Pace", "X-Type", "S-Type", 
			        "XK", "F-Type SVR", "XE SV Project 8", "I-Pace EV", "XJ220", "C-X75", 
			        "SS 100", "SS 90", "Mark I", "Mark II", "Mark V", "Mark VII", "Mark VIII", 
			        "Mark IX", "Mark X", "XJ6", "XJ12", "XJR", "XJS", "XJR-S", "XJ-C", "XJ40", 
			        "XJ8", "XK-E", "XK120", "XK140", "XK150", "D-Type", "C-Type", "E-Type", 
			        "F-Type Convertible", "F-Type Coupe", "XJ6 Series I", "XJ6 Series II", 
			        "XJ6 Series III", "XJ12 Series I", "XJ12 Series II", "XJ12 Series III", 
			        "XJR Portfolio", "XJR Sport", "XJR Autobiography", "Future-Type", "J-Pace", 
			        "J-Type", "Jaguar Vision Gran Turismo", "Jaguar CX-75 Concept", "Jaguar F-Zero"
			    )
			);
		
		coches.put("Jeep",
			    List.of(
			        "Wrangler", "Cherokee", "Grand Cherokee", "Renegade", "Compass", "Gladiator", 
			        "Commander", "Patriot", "Liberty", "Wagoneer", "Grand Wagoneer", "Jeepster", 
			        "FC-150", "FC-170", "CJ-5", "CJ-7", "CJ-8 Scrambler", "CJ-2A", "CJ-3A", 
			        "CJ-3B", "CJ-6", "CJ-10", "CJ-V35", "CJ-Y", "DJ-3A", "DJ-5", "DJ-6", 
			        "DJ-7", "DJ-8", "DJ-9", "DJ-10", "DJ-11", "DJ-12", "DJ-13", "DJ-14", 
			        "DJ-15", "DJ-16", "DJ-17", "DJ-18", "DJ-19", "DJ-20", "DJ-21", "DJ-22", 
			        "DJ-23", "DJ-24", "DJ-25", "DJ-26", "DJ-27", "DJ-28", "DJ-29", "DJ-30", 
			        "DJ-31", "DJ-32", "DJ-33", "DJ-34", "DJ-35", "DJ-36", "DJ-37", "DJ-38", 
			        "DJ-39", "DJ-40", "DJ-41", "DJ-42", "DJ-43", "DJ-44", "DJ-45", "DJ-46", 
			        "DJ-47", "DJ-48", "DJ-49", "DJ-50", "DJ-51", "DJ-52", "DJ-53", "DJ-54", 
			        "DJ-55", "DJ-56", "DJ-57", "DJ-58", "DJ-59", "DJ-60", "DJ-61", "DJ-62", 
			        "DJ-63", "DJ-64", "DJ-65", "DJ-66", "DJ-67", "DJ-68", "DJ-69", "DJ-70", 
			        "DJ-71", "DJ-72", "DJ-73", "DJ-74", "DJ-75", "DJ-76", "DJ-77", "DJ-78", 
			        "DJ-79", "DJ-80", "DJ-81", "DJ-82", "DJ-83", "DJ-84", "DJ-85", "DJ-86", 
			        "DJ-87", "DJ-88", "DJ-89", "DJ-90", "DJ-91", "DJ-92", "DJ-93", "DJ-94", 
			        "DJ-95", "DJ-96", "DJ-97", "DJ-98", "DJ-99", "DJ-100", "DJ-101", "DJ-102", 
			        "DJ-103", "DJ-104", "DJ-105", "DJ-106", "DJ-107", "DJ-108", "DJ-109", 
			        "DJ-110", "DJ-111", "DJ-112", "DJ-113", "DJ-114", "DJ-115", "DJ-116", 
			        "DJ-117", "DJ-118", "DJ-119", "DJ-120", "DJ-121", "DJ-122", "DJ-123", 
			        "DJ-124", "DJ-125", "DJ-126", "DJ-127", "DJ-128", "DJ-129", "DJ-130", 
			        "DJ-131", "DJ-132", "DJ-133", "DJ-134", "DJ-135", "DJ-136", "DJ-137", 
			        "DJ-138", "DJ-139", "DJ-140", "DJ-141", "DJ-142", "DJ-143", "DJ-144", 
			        "DJ-145", "DJ-146", "DJ-147", "DJ-148", "DJ-149", "DJ-150", "DJ-151", 
			        "DJ-152", "DJ-153", "DJ-154", "DJ-155", "DJ-156", "DJ-157", "DJ-158", 
			        "DJ-159", "DJ-160", "DJ-161", "DJ-162", "DJ-163", "DJ-164", "DJ-165", 
			        "DJ-166", "DJ-167", "DJ-168", "DJ-169", "DJ-170", "DJ-171", "DJ-172", 
			        "DJ-173", "DJ-174", "DJ-175", "DJ-176", "DJ-177", "DJ-178", "DJ-179", 
			        "DJ-180", "DJ-181", "DJ-182", "DJ-183", "DJ-184", "DJ-185", "DJ-186", 
			        "DJ-187", "DJ-188", "DJ-189", "DJ-190", "DJ-191", "DJ-192", "DJ-193", 
			        "DJ-194", "DJ-195", "DJ-196", "DJ-197", "DJ-198", "DJ-199", "DJ-200"
			    )
			);
		
		coches.put("Lada",
			    List.of(
			        "Niva", "Granta", "Vesta", "XRay", "2101", "2103", "2106", "2107", "Samara", 
			        "Priora", "Largus", "Kalina", "4x4", "Niva Travel", "Vesta Cross", "XRay Cross", 
			        "Granta Cross", "Vesta SW", "Niva Legend", 
			        "2102", "2104", "2105", "2108", "2109", "2110", "2111", "2112", "2113", 
			        "2114", "2115", "2116", "2117", "2118", "2119", "2120", "2121", "2123", 
			        "2129", "2131", "2170", "2190", "2192", "2194", "2329", "2335", "2351", 
			        "Revolution", "Oka", "Riva", "Nova", "Signa", "Bogdan", "Caspian", 
			        "Kuban", "Volga Siber", "Aurus Senat", "Aurus Komendant", "Aurus Arsenal", 
			        "Aurus Limo", "Aurus Cortez", "Aurus Vagon", "Aurus Vision", 
			        "Urban", "City", "Family", "Adventure", 
			        "Cargo", "Commercial", "Future SUV", "Smart EV", 
			        "Concept 1", "Concept 2", "Concept 3", "Vision", 
			        "X", "Y", "Z", "Urban Cruiser"
			    )
			);
		
		coches.put("Lancia",
			    List.of(
			        "Lambda", "Augusta", "Ardea", "Aurelia", "Appia", "Flaminia", "Flavia", 
			        "Fulvia", "Beta", "Gamma", "Delta", "Prisma", "Thema", "Dedra", 
			        "Kappa", "Lybra", "Thesis", "Y", "Ypsilon", "Zeta", "Phedra", 
			        "Musa", "Voyager", "Delta Integrale", "Stratos", "Montecarlo", "Rally 037", 
			        "Aprilia", "Astura", "Belna", "D24", "D50", "D51", "D52", "D53", 
			        "D54", "D55", "D56", "D57", "D58", "D59", "D60", "D61", "D62", 
			        "D63", "D64", "D65", "D66", "D67", "D68", "D69", "D70", "D71", 
			        "D72", "D73", "D74", "D75", "D76", "D77", "D78", "D79", "D80", 
			        "D81", "D82", "D83", "D84", "D85", "D86", "D87", "D88", "D89", 
			        "D90", "D91", "D92", "D93", "D94", "D95", "D96", "D97", "D98", 
			        "D99", "D100", "D101", "D102", "D103", "D104", "D105", "D106", 
			        "D107", "D108", "D109", "D110", "D111", "D112", "D113", "D114", 
			        "D115", "D116", "D117", "D118", "D119", "D120", "D121", "D122", 
			        "D123", "D124", "D125", "D126", "D127", "D128", "D129", "D130", 
			        "D131", "D132", "D133", "D134", "D135", "D136", "D137", "D138", 
			        "D139", "D140", "D141", "D142", "D143", "D144", "D145", "D146", 
			        "D147", "D148", "D149", "D150", "D151", "D152", "D153", "D154", 
			        "D155", "D156", "D157", "D158", "D159", "D160", "D161", "D162", 
			        "D163", "D164", "D165", "D166", "D167", "D168", "D169", "D170", 
			        "D171", "D172", "D173", "D174", "D175", "D176", "D177", "D178", 
			        "D179", "D180", "D181", "D182", "D183", "D184", "D185", "D186", 
			        "D187", "D188", "D189", "D190", "D191", "D192", "D193", "D194", 
			        "D195", "D196", "D197", "D198", "D199", "D200"
			    )
			);
		
		coches.put("Land Rover",
			    List.of(
			        "Defender", "Defender 90", "Defender 110", "Defender 130", 
			        "Discovery", "Discovery Sport", "Freelander", "Freelander 2", 
			        "Range Rover", "Range Rover Sport", "Range Rover Evoque", 
			        "Range Rover Velar", "Series I", "Series II", "Series III", 
			        "DC100", "DC100 Sport", "LRX", "Lunar", "Nimbus", "Sayer", 
			        "Road Rover", "Range Rover Classic", "Range Rover PHEV", 
			        "Range Rover LWB", "Range Rover SV Autobiography", 
			        "Range Rover SVR", "Range Rover SVAutobiography Dynamic", 
			        "Discovery Commercial", "Discovery 3", "Discovery 4", 
			        "Discovery 5", "Discovery 6", "Freelander 1", "Land Rover 1", 
			        "2", "3", "4", "5", 
			        "6", "7", "8", "9", 
			        "10", "11", "12", "13", 
			        "14", "15", "16", "17", 
			        "18", "19", "20", "21", 
			        "22", "23", "24", "25"
			    )
			);
		
		coches.put("Lexus",
			    List.of(
			        "IS", "ES", "GS", "LS", "RX", "NX", "UX", "GX", "LX", "RC", "LC", "LC Convertible", 
			        "RX L", "NX F Sport", "RX F Sport", "ES F Sport", "IS F", "LS F", "CT", "RC F", 
			        "RX Hybrid", "NX Hybrid", "ES Hybrid", "UX Hybrid", "LX 600", "GX 460", "LC 500h", 
			        "SC", "SC 300", "SC 400", "SC 430", "HS 250h", "LFA", "LF-A", "LF-1 Limitless", 
			        "LF-30 Electrified", "LF-Z Electrified", "LF-C", "LF-C2", "LF-CC", "LF-LC", 
			        "LF-NX", "LF-SA", "LF-FC", "LF-X", "LF-Xh", "LF-Ch", "LF-Gh", "LF-Ah", 
			        "LM", "LM 350", "LM 500h", "RZ", "RZ 450e", "Electrified SUV", "Electrified Sedan", 
			        "Electrified Coupe", "Electrified Roadster", "Electrified Van", "Electrified Truck", 
			        "Electrified Concept", "Electrified Vision", "Electrified Future", "Electrified Urban", 
			        "Electrified City", "Electrified Adventure", "Electrified Cargo", "Electrified Commercial"
			    )
			);
		
		coches.put("Maserati",
			    List.of(
			        "A6 1500", "A6G 2000", "3500 GT", "Mistral", "Ghibli", "Indy", "Quattroporte", 
			        "Biturbo", "Shamal", "Spyder", "GranTurismo", "GranCabrio", "Quattroporte Ghibli", 
			        "Ghibli (2013)", "Levante", "Alfieri", "GranTurismo (2017)", "Quattroporte (2013)", 
			        "Ghibli Hybrid", "MC20", "Levante Trofeo", "Alfieri EV", "Grecale", 
			        "Tipo 26", "Tipo 4CM", "Tipo 6CM", "Tipo 8CM", "A6GCS", "A6G/54", 
			        "Sebring", "Mexico", "Khamsin", "Bora", "Merak", "Kyalami", "Karif", 
			        "Coupe", "Gransport", "Grancabrio", "Coupé Cambiocorsa", "4200 GT", 
			        "4200 Spyder", "4200 Cambiocorsa", "4200 GTA", "4200 GT Spyder", 
			        "4200 GTC", "4200 MC Victory", "4200 MC Sportline", "4200 MC Stradale", 
			        "4200 MC Corsa", "4200 MC Competizione", "4200 MC Corse", "4200 MC Race", 
			        "4200 MC Racer", "4200 MC Racing", "4200 MC Rally", "4200 MC Rallye", 
			        "4200 MC Rallyesport", "4200 MC Rallyespeed", "4200 MC Rallyestrada", 
			        "4200 MC Rallyestradale", "4200 MC Rallyestrade", "4200 MC Rallyestreet"
			    )
			);
		
		coches.put("Mini",
			    List.of(
			        "Classic", "Cooper", "Cooper S", "One", "Clubman", 
			        "Convertible", "Roadster", "Coupe", "Countryman", 
			        "Paceman", "Electric", "Aceman", "John Cooper Works", 
			        "Van", "Pick-Up", "Moke", "Traveller", "Mayfair", 
			        "City", "Checkmate", "Rider", "Wolseley Hornet", 
			        "Riley Elf", "1000", "1275GT", "Mark I", "Mark II", 
			        "Mark III", "Mark IV", "Mark V", "Mark VI", "Mark VII", 
			        "E", "Rocketman", "Crossover", "Clubvan", "Vision Next", 
			        "Strip", "Cooper SE", "JCW GP", "JCW Challenge", 
			        "JCW Rally", "JCW Buggy", "JCW Streetcar", "JCW Trackstar"
			    )
			);
		
		coches.put("Mitsubishi",
			    List.of(
			        "Lancer", "Lancer Evolution", "Eclipse", "Eclipse Cross", "Outlander", 
			        "Outlander PHEV", "ASX", "Pajero", "Pajero Sport", "Montero", "Montero Sport", 
			        "Colt", "Space Star", "Mirage", "Galant", "Grandis", "Carisma", "3000GT", 
			        "Endeavor", "RVR", "i-MiEV", "Xpander", "Delica", 
			        "Lancer EX", "Lancer Wagon", "Lancer Cedia", "Lancer Celeste", 
			        "Lancer Fiore", "Lancer GSR", "Lancer VR-4", "Lancer GLXi", 
			        "Eclipse Spyder", "Eclipse GSX", "Eclipse GT", "Eclipse SE", 
			        "Outlander Sport", "Outlander XL", "Outlander Hybrid", 
			        "Pajero Mini", "Pajero iO", "Pajero Pinin", "Pajero Evolution", 
			        "Pajero Junior", "Pajero Long", "Pajero Dakar", "Pajero TR4", 
			        "Montero Raider", "Montero Limited", "Montero XLS", 
			        "Colt Galant", "Colt Vista", "Colt Lancer", "Colt Mirage", 
			        "Colt Tredia", "Colt CZC", "Colt CZT", "Colt CZ2", 
			        "Space Gear", "Space Wagon", "Space Runner", "Space Jet", 
			        "Mirage Dingo", "Mirage G4", "Mirage Cyborg", "Mirage Asti", 
			        "Galant VR-4", "Galant Sigma", "Galant Fortis", "Galant AMG", 
			        "Grandis Aero", "Grandis GT", "Grandis Sport", 
			        "Carisma GDI", "Carisma GT", "Carisma Aero", 
			        "3000GT VR-4", "3000GT SL", "3000GT Spyder", 
			        "Endeavor LS", "Endeavor XLS", "Endeavor SE", 
			        "RVR Turbo", "RVR GDI", "RVR Aero", "RVR Cross", 
			        "i-MiEV Evolution", "i-MiEV Sport", "i-MiEV City", 
			        "Xpander Cross", "Xpander Sport", "Xpander Urban", 
			        "Delica D:5", "Delica Space Gear", "Delica Star Wagon", 
			        "Delica Cargo", "Delica Van", "Delica Minicab", 
			        "Minica", "Minica Skipper", "Minica Toppo", "Minica Truck", 
			        "Fuso", "Canter", "Triton", "Strada", "Chariot", "Sigma", 
			        "FTO", "Diamante", "Debonair", "Emeraude", "Libero", 
			        "Jeep J10", "Jeep J20", "Jeep J30", "Jeep J40", 
			        "Concept XR-PHEV", "Concept GC-PHEV", "Concept e-Evolution", 
			        "Concept Mi-Tech", "Concept Engelberg Tourer"
			    )
			);
		
		coches.put("Morgan",
			    List.of(
			        "4/4", "Plus 4", "Plus 6", "Plus 8", "Roadster", "3-Wheeler", "Super 3", 
			        "Aero 8", "Aero SuperSports", "Aero Coupé", "Eva GT", 
			        "Runabout", "F2", "F4", "F-Super", "Plus E", "EV3", 
			        "LifeCar", "500", "Cycle Car", "Tina", "Threewheeler", 
			        "Classic", "Supersports", "Cresta", "Plus Four CX-T", 
			        "ARV6", "Rocket 3", "SP1", "Project 25", 
			        "1909 Runabout", "1910 Grand Prix", "1911 Aero", "1913 Tandem", 
			        "1920 Sports", "1925 Super Sports", "1930 F-Type", "1932 De Luxe", 
			        "1935 F2", "1937 F4", "1938 F-Super", "1948 4/4", 
			        "1950 Plus 4", "1952 Plus 4 Drophead", "1954 Plus 4 Competition", 
			        "1955 Plus 4 Supersports", "1959 Plus 4 Rally", "1960 Plus 4 Estate", 
			        "1962 Plus 4 Series V", "1963 Plus 4 Series VI", 
			        "1965 Plus 4 Series VII", "1968 Plus 4 Series VIII", 
			        "1970 Plus 8", "1972 Plus 8 GTR", "1975 Plus 8 Competition", 
			        "1980 Plus 8 Turbo", "1985 Plus 8 Limited Edition", 
			        "1990 Plus 8 Anniversary", "1995 Plus 8 Sport", 
			        "2000 Aero 8 Prototype", "2005 AeroMax", "2008 Aero Supersports", 
			        "2010 Aero Coupé", "2012 Eva GT Concept", "2015 EV3 Concept", 
			        "2018 Plus Six", "2020 Super 3 Concept", "2022 Project 25", 
			        "Classic 3 Wheeler", "Threewheeler V-Twin", 
			        "Threewheeler Electric", "Future EV", 
			        "Urban Cruiser", "Adventure EV", 
			        "Cargo EV", "Commercial EV"
			    )
			);
		
		coches.put("Opel",
				List.of("4 PS", "Kadett", "Olympia", "Kapitan", "Rekord", "Commodore", "Manta", "GT", 
						"Ascona", "Monza", "Senator", "Corsa", "Astra", "Vectra", "Omega", 
						"Tigra", "Agila", "Meriva", "Zafira", "Insignia", "Karl", 
						"Adam", "Ampera", "Ampera-e", "Crossland", "Crossland X", 
						"Grandland", "Grandland X", "Mokka", "Mokka X", "Combo", 
						"Combo Life", "Combo-e Life", "Vivaro", "Vivaro-e", 
						"Movano", "Movano-e", "Rocks-e", "Frontera", "Calibra"));
		
		coches.put("Porsche",
				List.of("356", "550 Spyder", "904 Carrera GTS", "911", "912", "914", "924", "928", 
						"944", "959", "968", "Boxster", "Cayman", "Carrera GT", "Cayenne", 
						"Panamera", "Macan", "918 Spyder", "Taycan", "718 Boxster", 
						"718 Cayman", "911 GT3", "911 Turbo", "911 Carrera", "911 Targa", 
						"Taycan Cross Turismo", "Taycan Sport Turismo", "Mission E", "Macan EV", 
						"Cayenne Coupe", "Panamera Sport Turismo"));
		
		coches.put("Skoda",
			    List.of(
			        "Fabia", "Scala", "Octavia", "Superb", "Kamiq", "Karoq", "Kodiaq", 
			        "Enyaq", "Enyaq Coupé", "Citigo", "Roomster", "Rapid", "Yeti", 
			        "Felicia", "Favorit", "120", "105", "Estelle", "Forman", "S100", "S110", 
			        "Popular", "1101", "1102", "130", "135", "136", "Garde", "742", "781", 
			        "1000 MB", "110 R", "180", "200", "205", "210", "220", "230", "240", 
			        "250", "260", "270", "280", "290", "300", "310", "320", "330", "340", 
			        "350", "360", "370", "380", "390", "400", "410", "420", "430", "440", 
			        "450", "460", "470", "480", "490", "500", "510", "520", "530", "540", 
			        "550", "560", "570", "580", "590", "600", "610", "620", "630", "640", 
			        "650", "660", "670", "680", "690", "700", "710", "720", "730", "740", 
			        "750", "760", "770", "780", "790", "800", "810", "820", "830", "840", 
			        "850", "860", "870", "880", "890", "900", "910", "920", "930", "940", 
			        "950", "960", "970", "980", "990", "1000", "1010", "1020", "1030", "1040", 
			        "1050", "1060", "1070", "1080", "1090", "1100", "1110", "1120", "1130", "1140", 
			        "1150", "1160", "1170", "1180", "1190", "1200", "1210", "1220", "1230", "1240", 
			        "1250", "1260", "1270", "1280", "1290", "1300", "1310", "1320", "1330", "1340", 
			        "1350", "1360", "1370", "1380", "1390", "1400", "1410", "1420", "1430", "1440", 
			        "1450", "1460", "1470", "1480", "1490", "1500"
			    )
			);
		
		coches.put("Smart",
			    List.of(
			        "City-Coupe", "Fortwo", "Forfour", "Roadster", "Crossblade", 
			        "Fortwo Electric Drive", "Forfour Electric Drive", "EQ Fortwo", 
			        "EQ Forfour", "Hashtag 1", "Hashtag 3", 
			        "Pulse", "Brabus", "Ultimate", "Cabrio", "Roadster-Coupe", 
			        "Fortwo Coupé", "Fortwo Cabrio", "Forfour Coupé", "Forfour Cabrio", 
			        "Fortwo ED", "Forfour ED", "Smart #1", "Smart #2", "Smart #3", 
			        "Concept One", "Concept Two", "Concept Three", "Concept Four", 
			        "Concept Five", "Concept Six", "Concept Seven", "Concept Eight", 
			        "Concept Nine", "Concept Ten"
			    )
			);
		
		coches.put("SsangYong",
			    List.of(
			        "Tivoli", "Tivoli Grand", "Korando", "Korando e-Motion", "Rexton", "Rexton Sports", 
			        "Rexton Sports Khan", "Musso", "Actyon", "Actyon Sports", "Kyron", "Rodius", 
			        "Stavic", "XLV", "Chairman", "Istana", 
			        "Korando Family", "Korando Turismo", "Korando C", "Korando KJ", "Korando TJ", 
			        "Musso Sports", "Musso Grande", "Musso SUV", "Musso Pickup", "Musso Tourer", 
			        "Rodius S", "Rodius X", "Rodius Luxury", "Rodius Van", "Rodius RV", 
			        "Stavic Premium", "Stavic Deluxe", "Stavic Executive", "Stavic Royal", 
			        "Action X", "Action X Sports", "Action X Utility", "Action X Adventure", 
			        "Kyron S", "Kyron T", "Kyron H", "Kyron M", "Kyron L", 
			        "Chairman W", "Chairman H", "Chairman Junior", "Chairman Limousine", 
			        "Istana Cargo", "Istana Van", "Istana Minibus", "Istana Commercial", 
			        "SsangYong Concept 1", "SsangYong Concept 2", "SsangYong Concept 3", 
			        "SsangYong Vision 1", "SsangYong Vision 2", "SsangYong Vision 3", 
			        "SsangYong Urban Cruiser", "SsangYong Smart EV", "SsangYong Future SUV", 
			        "SsangYong City Commuter", "SsangYong Cargo EV", "SsangYong Commercial EV"
			    )
			);
		
		coches.put("Subaru",
			    List.of(
			        "Impreza", "WRX", "WRX STI", "Legacy", "Outback", "Forester", "Crosstrek", 
			        "XV", "BRZ", "Ascent", "Levorg", "Solterra", "Baja", "Justy", "Rex", 
			        "Tribeca", "Alcyone SVX", "Sambar", "Pleo", "Lucra", 
			        "1000", "360", "FF-1", "Leone", "XT", "Loyale", "Domingo", 
			        "Stella", "Exiga", "G4", "Traviq", "Dias", "Dias Wagon", 
			        "Pleo Plus", "Pleo Van", "Dex", "Graveler", "Vivio", "R2", 
			        "R1", "R1e", "Bighorn", "Hybrid Tourer", "Levorg STI Sport", 
			        "Impreza XV", "Impreza WRX", "Impreza WRX STI", "Legacy Lancaster", 
			        "Legacy Touring Wagon", "Legacy RS", "Legacy GT", "Legacy B4", 
			        "Forester XT", "Forester Hybrid", "Outback Sport", "Outback Wilderness", 
			        "Ascent Limited", "Ascent Touring", "Solterra EV", "Subaru G4e"
			    )
			);
		
		coches.put("Suzuki",
			    List.of(
			        "Swift", "Ignis", "Vitara", "S-Cross", "Jimny", "Baleno", "Across", 
			        "Swace", "Alto", "Celerio", "Splash", "SX4", "SX4 S-Cross", "Liana", 
			        "Grand Vitara", "Kizashi", "Wagon R", "XL7", "Ertiga", "Carry", 
			        "Every", "Cultus", "Esteem", "Samurai", "Sidekick", "Equator", 
			        "Forenza", "Reno", "Verona", "Aerio", "Kei", "Palette", "Solio", 
			        "Spacia", "Hustler", "Escudo", "Super Carry", "Mehran", "Alto K10", 
			        "Alto Lapin", "Alto Van", "MR Wagon", "Karimun", "APV", "Arena", 
			        "Concept X", "Concept Y", "Concept Z", "iM-4", "e-Survivor", 
			        "eVX", "Across PHEV", "Jimny Sierra", "Jimny 5-Door", "Swift Sport", 
			        "Vitara Brezza", "S-Presso", "Ciaz", "Dzire", "Maruti 800", "Omni"
			    )
			);
		
		coches.put("Tata",
				List.of("Telcoline", "Sierra", "Estate", "Sumo", "Indica", "Indigo", "Safari", 
						"Nano", "Zest", "Bolt", "Tiago", "Tigor", "Altroz", "Punch", 
						"Nexon", "Nexon EV", "Harrier", "Safari (2021)", "Hexa", 
						"Aria", "Venture", "Winger", "Movus", "Ace", "Ace EV", 
						"Intra", "Yodha", "Magic", "Xenon"));
		
		coches.put("Volvo",
			    List.of(
			        "ÖV4", "PV36", "PV444", "PV544", "P1900", "Amazon", "140", "164", "240", 
			        "260", "340", "360", "440", "460", "480", "740", "760", "780", 
			        "850", "940", "960", "C30", "C70", "S40", "S60", "S70", "S80", 
			        "S90", "V40", "V50", "V60", "V70", "V90", "XC40", "XC60", "XC70", 
			        "XC90", "EX30", "EX90", "EM90", "V60 Cross Country", "V90 Cross Country", 
			        "Duett", "Pelle", "Nova", "B18", "B20", "B230", "B6304", "B5254", 
			        "B5244", "B5204", "B4204", "FH12", "FL6", "FE", "FM", "VM", "VN", 
			        "Concept Estate", "Concept Coupe", "Concept XC", "Recharge", "Polestar 1", 
			        "Polestar 2", "Polestar 3", "Polestar 4", "Polestar 5", "Polestar 6"
			    )
			);

		coches.put("Cadillac",
				List.of("ATS", "CTS", "XTS", "STS", "DeVille", "Escalade", 
						"ELR", "CT6", "CT4", "CT5", "Seville", "Eldorado", 
						"Fleetwood", "Brougham", "SRX", "XT5", "XT4", "XT6", 
						"Lyriq", "V-Series", "Escalade ESV", "Escalade EXT", "V-16", 
						"Allante", "Cimarron", " Viera", "XLR", "Catera", "CTS-V", 
						"Escalade Hybrid", "CT6 Plug-in Hybrid", "ATS-V", "V8", "Series 62", 
						"Series 75", "LaSalle", "V-Series Blackwing", "Escalade IQ"));

		coches.put("Mustang",
			    List.of(
			        "Mustang", "Mach 1", "Shelby GT350", "Shelby GT500", "Bullitt", 
			        "Cobra", "GT", "EcoBoost", "GT350", "Fastback", 
			        "Convertible", "Mach-E", "II", "Boss 302", "Boss 429", 
			        "GT500KR", "GT500", "Shelby GT500KR", "Special Edition", 
			        "Roush", "California Special", 
			        "Eleanor", "SVO", "King Cobra", "Saleen", "SVT Cobra", 
			        "Terlingua", "Dark Horse", "Mach-E GT", "Mach-E California Route 1", 
			        "Mach-E Premium", "Mach-E Select", "Mach-E Extended Range", 
			        "Mach-E Performance Edition", "Mach-E Ice White Edition", 
			        "Mach-E GT Performance Edition", "Mach-E Stealth Edition", 
			        "Mach-E Carbonized Gray", "Mach-E Grabber Blue", "Mach-E Cyber Orange", 
			        "Mach-E Rapid Red", "Mach-E Star White", "Mach-E Shadow Black", 
			        "Mach-E Oxford White", "Mach-E Atlas Blue", "Mach-E Iconic Silver", 
			        "Mach-E Velocity Blue", "Mach-E Iced Coffee", "Mach-E Eruption Green"
			    )
			);

		coches.put("Ferrari", List.of("125 S", "166 Inter", "212 Inter", "250 GTO", "330 P4", "365 GTB/4", "512 TR", 
				"F40", "F50", "Enzo", "LaFerrari", "Portofino", "Roma", "488 GTB", 
				"458 Italia", "599 GTB Fiorano", "812 Superfast", "GTC4Lusso", "Monza SP1", 
				"Monza SP2", "SF90 Stradale", "F12berlinetta", "F136 E", "550 Maranello", 
				"360 Modena", "430 Scuderia", "360 Challenge Stradale", "Testarossa", "Dino 246", 
				"288 GTO", "California", "California T", "250 Testa Rossa", "275 GTB", 
				"400i", "365 GT4 2+2", "308 GTB", "308 GTS", "348 TB", "348 TS", 
				"512 TR", "308 GT4", "308 GTSi", "512 M", "F430", "F1", "FXX", 
				"LaFerrari Aperta"));

		coches.put("Lamborghini",
				List.of("350 GT", "400 GT", "Miura", "Espada", "Jarama", "Urraco", "Countach", 
						"Silhouette", "Jalpa", "Diablo", "Murciélago", "Gallardo", 
						"Reventón", "Aventador", "Huracán", "Centenario", "Sian", 
						"Terzo Millennio", "Estoque", "LM002", "5000 GT", "350 GTV", 
						"400 GT 2+2", "Miura SV", "Miura P400", "Miura P400S", 
						"Murciélago LP640", "Murciélago LP670-4 SV", "Gallardo Spyder", 
						"Gallardo Superleggera", "Gallardo LP570-4", "Aventador S", "Aventador SVJ", 
						"Huracán Spyder", "Huracán Performante", "Huracán STO", "Urus"));

		coches.put("BYD",
			    List.of(
			        "Tang EV", "Song EV", "Qin EV", "Yuan EV", "e6", "T3", "F3DM", "S6", 
			        "E6 Plus", "Han EV", "Atto 3", "Dolphin", "Seagull", 
			        "F3", "L3", "G3", "F0", "M6", "e5", "e2", "e1", "S1", 
			        "S2", "S3", "S5", "S8", "M3", "M5", "M7", "L6", "L8", 
			        "T5", "T6", "T7", "T9", "T10", "T11", "T12", "T13", "T14", 
			        "T15", "T16", "T17", "T18", "T19", "T20", "T21", "T22", 
			        "Tang DM", "Song DM", "Qin DM", "Yuan DM", "Song Pro", 
			        "Song Max", "Qin Plus", "Yuan Plus", "Tang Pro", "Tang Max", 
			        "Han DM", "Han PHEV", "Ocean X", "Ocean R", "Ocean S", 
			        "Ocean E", "Ocean F", "Ocean G", "Ocean H", "Ocean K", 
			        "Ocean L", "Ocean M", "Ocean N", "Ocean O", "Ocean P", 
			        "Ocean Q", "Ocean R", "Ocean S", "Ocean T", "Ocean U", 
			        "Ocean V", "Ocean W", "Ocean X", "Ocean Y", "Ocean Z"
			    )
			);

		coches.put("NIO",
			    List.of(
			        "ES8", "ES6", "EC6", "ET7", "ET5", "ES7", "ET7 Electric", 
			        "EC6 Electric", "ES8 Electric", "ES6 Electric", "ET5 Electric", "ET7 AWD", 
			        "ET5 AWD", "Power Swap Station", "EVE Concept", "NioPilot", 
			        "EP9", "ET9", "ES9", "EC7", "EC5", "ET3", "ET6", "ET8", 
			        "EVE", "Concept EV", "Urban Cruiser", "Smart EV", 
			        "City Commuter", "NIO Cargo EV", "Commercial EV", 
			        "Autonomous Driving", "Smart Cockpit", "Battery Swap", 
			        "Power Home", "Power Mobile", "Power Charger", 
			        "Vision 1", "Vision 2", "Vision 3", "Vision 4", 
			        "Vision 5", "Vision 6", "Vision 7", "Vision 8", 
			        "Vision 9", "Vision 10", "Future SUV", "Future Sedan", 
			        "Urban Air Mobility", "Flying Car", "Robotaxi"
			    )
			);

		coches.put("XPeng",
			    List.of(
			        "G3", "P7", "P5", "G3i", "Xmart OS", 
			        "P7 Electric", "G3 Electric", "P5 Electric", 
			        "G3i Electric", "P7 Wing", "City", 
			        "G9", "X2", "X3", "X4", "X5", 
			        "X6", "X7", "X8", "X9", "X10", 
			        "H1", "H2", "H3", "H4", "H5", 
			        "H6", "H7", "H8", "H9", "H10", 
			        "M1", "M2", "M3", "M4", "M5", 
			        "M6", "M7", "M8", "M9", "M10", 
			        "Robotaxi", "Flying Car", "AeroHT", 
			        "Smart Cockpit", "Autonomous Driving", 
			        "Urban Air Mobility", "Concept 1", "Concept 2", 
			        "Concept 3", "Concept 4", "Concept 5", 
			        "Concept 6", "Concept 7", "Concept 8", 
			        "Concept 9", "Concept 10"
			    )
			);

		coches.put("Li Auto",
			    List.of(
			        "ONE", "L7", "L9", "X", "L9 Electric", 
			        "ONE Electric", "L7 Electric", 
			        "L8", "L6", "M1", "M2", "M3", 
			        "M4", "M5", "M6", "M7", "M8", 
			        "M9", "M10", "S1", "S2", "S3", 
			        "S4", "S5", "S6", "S7", "S8", 
			        "S9", "S10", "Air", "Space", 
			        "Concept 1", "Concept 2", "Concept 3", 
			        "Concept 4", "Concept 5", "Concept 6", 
			        "Concept 7", "Concept 8", "Concept 9", 
			        "Concept 10", "Future SUV", "Future Sedan", 
			        "Autonomous Driving", "Smart Cockpit", "EV Platform"
			    )
			);

		coches.put("Geely",
			    List.of(
			        "Emgrand", "Boyue", "Atlas", "EC7", "GC9", "Geometro", "Xingyue", "Emgrand EV", 
			        "Geometry A", "Geometry C", "Geometry E", "Icon", "Geometry G6", "GE11", "Yuan Pro", 
			        "Hao Yue", "Emgrand GSe", "G5", "GX7", "Geometry A Pro", "Panda Mini EV", 
			        "Vision", "CK", "LC", "FC", "SC5", "SC6", "SC7", "SL", "SR", "SX", 
			        "MK", "MK Cross", "MK RV", "MK Sedan", "MK Hatchback", "MK Coupe", 
			        "GC2", "GC5", "GC6", "GC7", "GC8", "GC9", "GC10", "GC11", "GC12", 
			        "GL", "GL3", "GL5", "GL7", "GL9", "GL10", "GL11", "GL12", 
			        "Preface", "Monjaro", "Okavango", "Coolray", "Azkarra", "Tugella", 
			        "Zeekr 001", "Zeekr 009", "Zeekr X", "Zeekr 003", "Zeekr 007", 
			        "Maple X3", "Maple X5", "Maple X7", "Maple E200", "Maple E3", 
			        "Geometry EX3", "Geometry EX5", "Geometry EX6", "Geometry EX7", 
			        "Geometry EX8", "Geometry EX9", "Geometry EX10", 
			        "Geometry Smart EV", "Geometry Urban Cruiser", "Geometry Concept EV", 
			        "Geometry Vision", "Geometry Future SUV", "Geometry City Commuter", 
			        "Geometry Cargo EV", "Geometry Commercial EV"
			    )
			);

		coches.put("BYTON",
			    List.of(
			        "M-Byte", "K-Byte", "C-Byte", "E-Byte", "S-Byte", "SUV", 
			        "Concept", "M-Byte Electric", "K-Byte Electric", 
			        "Concept SUV", "Concept Sedan", "Concept Coupe", 
			        "X1", "X2", "X3", "X4", "X5", 
			        "X6", "X7", "X8", "X9", "X10", 
			        "L1", "L2", "L3", "L4", "L5", 
			        "L6", "L7", "L8", "L9", "L10", 
			        "Smart Cockpit", "Autonomous Driving", 
			        "EV Platform", "Future Mobility", 
			        "Urban Commuter", "City Cruiser", 
			        "Vision 1", "Vision 2", "Vision 3", 
			        "Vision 4", "Vision 5", "Vision 6", 
			        "Vision 7", "Vision 8", "Vision 9", 
			        "Vision 10"
			    )
			);

		coches.put("Great Wall Motors",
			    List.of(
			        "ORA Good Cat", "ORA Black Cat", "ORA Funky Cat", "HAVAL H9 EV", "HAVAL H6 EV", 
			        "HAVAL H2", "HAVAL H5", "HAVAL H7", "HAVAL H8", "HAVAL H9", 
			        "HAVAL Jolion", "HAVAL F7", "HAVAL F7x", "HAVAL M6", "HAVAL Dargo", 
			        "WEY VV5", "WEY VV6", "WEY VV7", "WEY Tank 300", "WEY Tank 500", 
			        "WEY Coffee 01", "WEY Coffee 02", "WEY Coffee 03", "WEY P8", 
			        "GWM Cannon", "GWM Poer", "GWM Wingle 5", "GWM Wingle 6", "GWM Wingle 7", 
			        "GWM Steed", "GWM Deer", "GWM Pao", "GWM TANK 400", "GWM TANK 700", 
			        "ORA R1", "ORA iQ", "ORA ES1", "ORA Lightning Cat", "ORA Punk Cat", 
			        "ORA Cherry Cat", "ORA Ice Cat", "ORA Bubble Cat", "ORA Speed Cat", 
			        "ORA Retro Cat", "ORA Space Cat", "ORA Dream Cat", "ORA Vision Cat", 
			        "ORA Concept Cat", "ORA Smart EV", "ORA Urban Cruiser", 
			        "GWM Pickup", "GWM Minibus", "GWM Cargo EV", "GWM Commercial EV", 
			        "GWM Smart Van", "GWM City Commuter", "GWM Urban EV", "GWM Future SUV"
			    )
			);

		coches.put("Wuling",
			    List.of(
			        "Hongguang Mini EV", "Baojun E100", "E200", 
			        "Hongguang S3", "Hongguang S1", "Hongguang Plus", 
			        "Hongguang V8", "Hongguang LZW6376", "Rongguang", 
			        "Zhiguang", "Sunshine", "Victory", "Star", 
			        "Baojun 530", "Baojun 310", "Baojun 730", 
			        "Baojun RS-5", "Baojun RC-6", "Baojun RM-5", 
			        "Baojun RV-8", "Baojun E300", "Baojun KiWi EV", 
			        "Nano EV", "Zhengji", "Victory EV", 
			        "Air EV", "Almaz", "Confero", 
			        "Formo", "Cortez", "Alia", 
			        "Futura", "Sunshine EV", "Star EV", 
			        "Concept EV", "Urban Cruiser", 
			        "Smart Van", "Cargo EV", "MPV", 
			        "Pickup", "Minibus", "Commercial EV"
			    )
			);

		coches.put("SAIC Motor",
			    List.of(
			        "MG ZS EV", "MG Marvel R", "MG4 Electric", "Roewe Ei5", "Roewe RX5 EV", 
			        "MG HS", "MG RX8", "MG GT", "MG6", "MG3", "MG5", "MG7", 
			        "Roewe i6", "Roewe 350", "Roewe 550", "Roewe 750", "Roewe 950", 
			        "Roewe eRX5", "Roewe iMAX8", "Roewe RX8", "Roewe RX3", "Roewe RX9", 
			        "Maxus EUNIQ 5", "Maxus EUNIQ 6", "Maxus EUNIQ 7", "Maxus MIFA 9", 
			        "Maxus G10", "Maxus G20", "Maxus G50", "Maxus T60", "Maxus T70", 
			        "Maxus V80", "Maxus V90", "Maxus EV30", "Maxus EV80", "Maxus EV90", 
			        "MG Cyberster", "MG CyberMorph", "MG RX5", "MG ASHS", 
			        "Roewe Vision-i", "Roewe Concept-i", "Roewe MARVEL X", 
			        "Roewe MARVEL X Pro", "Roewe MARVEL 8", "Roewe MARVEL 9", 
			        "Maxus Concept M", "Maxus Concept V", "Maxus Concept T", 
			        "SAIC IMAX", "SAIC IMAX EV", "SAIC LCV", "SAIC MPV", 
			        "SAIC Commercial EV", "SAIC Smart EV", "SAIC Urban Cruiser"
			    )
			);

		coches.put("Tianjin FAW Xiali", List.of("1010", "1041", "1061", 
				"1081", "1091", "T173", 
				"Xiali 2000", "3000", "A11", 
				"Xiali A21", "A22", "Xiali E30", 
				"E50", "Tianjin FAW Xiali E60", "E80", "E90", 
				"V5", "V6", "V7", "V8", 
				"S11", "S12", "M7", "M8", 
				"Jetta", "T71", "T81", "T91", 
				"XEV", "T6", "T8", "E70", 
				"X6"));

		
		// Declaro todas las marcas de motos junto con sus modelos
		motos.put("Zontes",
			    List.of(
			        "G1-125", "G1-125 X", "U1-125", "GK125", "R310", "T310", "X310", "GK350", "Z2-350",
			        "Z3-350", "Z4-350", "V310", "M310", "E125", "C125", "E350", "Mantis 125", "Scrambler 125",
			        "G1-150", "G1-150 X", "U1-150", "GK150", "R350", "T350", "X350", "Z1-350", 
			        "Z5-350", "Z6-350", "V350", "M350", "E150", "C150", "E500", 
			        "Mantis 150", "Scrambler 150", "Adventure 310", "Adventure 350", 
			        "Cafe Racer 310", "Cafe Racer 350", "Street 310", "Street 350", 
			        "Urban Cruiser 310", "Urban Cruiser 350", "City Commuter 125", 
			        "City Commuter 150", "Cargo EV 125", "Cargo EV 150", 
			        "Commercial EV 310", "Commercial EV 350", "Smart EV 125", 
			        "Smart EV 150", "Smart EV 310", "Smart EV 350", 
			        "Zontes Concept 1", "Zontes Concept 2", "Zontes Vision", 
			        "Zontes Future EV", "Zontes Urban EV", "Zontes Adventure EV"
			    )
			);
		
		motos.put("CFMOTO",
			    List.of(
			        "125NK", "300NK", "300SR", "650NK", "650MT", "650GT", "700CL-X Heritage", 
			        "700CL-X Sport", "700CL-X Adventure", "800MT", "Papio 125", "300GT-E", "300CL-X", 
			        "150NK", "150SR", "250NK", "250SR", "250TR", "450NK", "450MT", "450GT", 
			        "500NK", "500MT", "500GT", "650CL-X", "650 Adventure", "650 Sport", 
			        "800MT Touring", "800MT Adventure", "800GT", "800NK", "800X", 
			        "CFORCE 400", "CFORCE 450", "CFORCE 500", "CFORCE 600", "CFORCE 800", 
			        "ZFORCE 800", "ZFORCE 1000", "UFORCE 800", "UFORCE 1000", 
			        "Concept 1", "Concept 2", "Vision", 
			        "Urban Cruiser", "CFMOTO City Commuter", "Adventure", 
			        "Cargo EV", "Commercial EV", "Smart EV", 
			        "Future EV", "Hybrid", "Electric Cruiser"
			    )
			);
		
		motos.put("QJ Motor",
			    List.of(
			        "SRK 125", "SRV 125", "SRK 250", "SRV 250", "SRK 350", "SRV 350", "SRT 500",
			        "SRK 500", "SRV 500", "SRT 700", "SRK 700", "SRV 700", "SRK 1000", "SRV 1000", "SRT 1000", 
			        "SRK 150", "SRV 150", "SRK 400", "SRV 400", "SRT 400", 
			        "SRK 600", "SRV 600", "SRT 600", "SRK 800", "SRV 800", "SRT 800", 
			        "SRK Adventure", "SRV Adventure", "SRT Adventure", 
			        "SRK Scrambler", "SRV Scrambler", "SRT Scrambler", 
			        "SRK Cafe Racer", "SRV Cafe Racer", "SRT Cafe Racer", 
			        "SRK Street", "SRV Street", "SRT Street", 
			        "SRK Urban Cruiser", "SRV Urban Cruiser", "SRT Urban Cruiser", 
			        "SRK City Commuter", "SRV City Commuter", "SRT City Commuter", 
			        "SRK Cargo EV", "SRV Cargo EV", "SRT Cargo EV", 
			        "SRK Commercial EV", "SRV Commercial EV", "SRT Commercial EV", 
			        "SRK Smart EV", "SRV Smart EV", "SRT Smart EV", 
			        "SRK Hybrid", "SRV Hybrid", "SRT Hybrid", 
			        "QJ Concept 1", "QJ Concept 2", "QJ Vision", 
			        "QJ Future EV", "QJ Urban EV", "QJ Adventure EV"
			    )
			);
		
		motos.put("Voge",
			    List.of(
			        "300R", "300AC", "300ACX", "300DS", "300GY", 
			        "350AC", "500R", "500DS", "500AC", "500ACX", 
			        "525R", "525DSX", "650DS", "650DSX", 
			        "900DS", "900DSX", "SR1 ADV", "SR4 Max", 
			        "CU 525", "CU 300", "CU 125", 
			        "150R", "150AC", "200R", "200AC", "250R", "250AC", 
			        "250DS", "250GY", "300NK", "300RR", "300ADV", 
			        "350DS", "350GY", "400R", "400AC", "400DS", 
			        "450R", "450DS", "450AC", "450GY", 
			        "700DS", "700DSX", "700ADV", "700R", "700AC", 
			        "800DS", "800DSX", "800ADV", "800R", "800AC", 
			        "Concept 1", "Concept 2", "Vision", 
			        "Urban Cruiser", "City Commuter", 
			        "Adventure", "Cargo EV", "Commercial EV", 
			        "Smart EV", "Future EV", "Hybrid"
			    )
			);
		
		motos.put("Benelli",
				List.of("TNT 125", "TNT 135", "TNT 150", "TNT 300", "TNT 302S", "TNT 600", 
						"TNT 899", "TNT 1130", "302R", "502C", "752S", "Leoncino 125", 
						"Leoncino 250", "Leoncino 500", "Leoncino 500 Trail", "Leoncino 800", 
						"Leoncino 800 Trail", "TRK 251", "TRK 502", "TRK 502 X", "TRK 702", 
						"TRK 702 X", "TRK 800", "Imperiale 400", "Velvet 125", "Velvet 250", 
						"Macis 125", "Caffè Nero 250", "Pepe 50", "Adiva", "BN 125", "BN 251", 
						"BN 302", "BN 600", "Quattro 500", "Sport 250", "Cento", "900 Sei", 
						"504 Sport", "654", "Minibike", "Velox"));
		
		motos.put("Yamaha",
				List.of("YA-1", "YD-1", "YA-2", "YDS-1", "YDS-2", "YDS-3", "YS-1", "RD56", "RD48", "DT-1", "RT-1",
						"XS-1", "RD350", "RD400", "XT500", "XS750", "SR500", "SR250", "XT250", "XT600", "FZR1000",
						"FZR600", "YZF750", "YZF600R", "YZF-R1", "YZF-R6", "YZF-R7", "YZF-R3", "YZF-R125", "FZ6",
						"FZ1", "FZ8", "MT-01", "MT-03", "MT-07", "MT-09", "MT-10", "MT-125", "XSR700", "XSR900", 
						"XSR125", "XSR300", "Tracer 700", "Tracer 900", "Tracer 7", "Tracer 9", "Tenere 700", 
						"Tenere 900", "Niken", "Niken GT", "WR250R", "WR450F", "XT660R", "XT660Z Tenere", "SR400", 
						"VMAX", "Bolt", "DragStar", "Virago", "Venture", "Road Star", "Midnight Star", "Super Tenere", 
						"Radian", "TW200", "TT-R125", "TT-R230", "YBR125", "XJ6", "FZ-07", "FZ-09", "FZ-10"));

		motos.put("Honda",
				List.of("CB500F", "CB500X", "CB650R", "CBR1000RR", "CBR600RR", "CBR500R", "CRF250L", "CRF450L", 
				        "CRF110F", "CRF150R", "CRF250R", "CRF450R", "CRF450X", "Grom", "Africa Twin", "Rebel 500", 
				        "Rebel 1100", "VFR800", "VFR1200F", "Shadow Phantom", "Shadow Aero", "Shadow Spirit", "CT125", 
				        "CBR1000RR-R", "CBR250R", "CBR300R", "VTR1000", "NC750X", "NC750S", "CB1100", "CB125F", 
				        "CB300R", "CB150R", "X-ADV", "Gold Wing", "Gold Wing Tour", "Monkey", "Super Cub C125", "CRF150L", 
				        "CRF250X", "XR650L", "XR250", "XR400R", "XR500", "CB750", "CB650F", "NSS300 Forza", "Dax", 
				        "CBR250RR", "CB300F", "VFR1200X", "VTR250", "CBR650F", "CB150F", "X-ADV 750", "CRF1000L", 
				        "CB500R", "CB1000R", "VFR800X", "CRF1100L", "CBR600F4i", "CBR900RR", "TLR200", "TRX450R", 
				        "TLR250", "CBR900RR FireBlade"));
		
		motos.put("Kawasaki",
				List.of("Ninja 400", "Ninja 650", "Ninja 1000SX", "Ninja ZX-6R", "Ninja ZX-10R", "Ninja ZX-14R", 
				        "Versys 300", "Versys 650", "Versys 1000", "Z125 Pro", "Z400", "Z650", "Z900", "Z1000", 
				        "Z1000 R", "Z900RS", "Z650RS", "W800", "Vulcan S", "Vulcan 900", "Vulcan 1700", "Vulcan 2000", 
				        "KLR650", "KX65", "KX85", "KX100", "KX250", "KX450", "KLX110", "KLX140", "KLX230", 
				        "KLX300R", "KLX450R", "Concours 14", "Mule Pro-FX", "Mule Pro-FXT", "Mule 4010 Trans4x4", 
				        "Mule 600", "Mule 610", "Mule 4000", "Mule 4010", "Mule 3010", "Mule SX", "Mule 700", 
				        "Mule Pro-DX", "Mule Pro-DXT", "Mule Pro-MX", "Mule Pro-MX EPS", "Ninja H2", "Ninja H2R", 
				        "ZXR", "Z2", "Z3", "KLR250", "Z2R", "ZX-12R", "ZX-10RR", "ZX-9R", "Z900RS Cafe"));

		motos.put("Ducati",
				List.of("Cucciolo", "98", "125 Sport", "200 Elite", "250 Monza", "250 Scrambler", "350 Scrambler",
						"450 Scrambler", "860 GT", "900 SS", "500 Pantah", "600 Pantah", "750 F1", "851", "888", 
						"Monster 600", "Monster 750", "Monster 900", "Supermono", "916", "748", "996", "998", "999", 
						"ST2", "ST3", "ST4", "Multistrada 1000DS", "Multistrada 620", "Hypermotard 796", 
						"Hypermotard 1100", "Hypermotard 950", "Hypermotard 939", "Monster 696", "Monster 796", 
						"Monster 821", "Monster 1200", "Monster 937", "Monster", "Diavel", "XDiavel", "Diavel 1260",
						"Streetfighter 848", "Streetfighter V2", "Streetfighter V4", "Streetfighter V4 S", 
						"Scrambler Icon", "Scrambler Nightshift", "Scrambler Desert Sled", "Scrambler Cafe Racer", 
						"Scrambler 1100", "Scrambler 1100 Sport", "Scrambler 1100 Pro", "Scrambler 800", 
						"Panigale 899", "Panigale 959", "Panigale V2", "Panigale V4", "Panigale V4 S", "Panigale V4 R", 
						"SuperSport", "SuperSport 950", "Multistrada V2", "Multistrada V4", "Multistrada V4 S", 
						"Multistrada 1260", "Multistrada 1200", "Multistrada Enduro", "Desmosedici RR", 
						"Streetfighter 1098", "1098", "1198", "848", "Hypermotard SP", "DesertX"));
		
		motos.put("KTM",
				List.of("125 Duke", "200 Duke", "250 Duke", "390 Duke", "690 Duke", "790 Duke", "890 Duke", "990 Duke", "1290 Super Duke",
				        "RC 125", "RC 200", "RC 250", "RC 390", "RC 8C",
				        "690 SMC R", "450 SMR", "450 SX-F", "250 SX", "250 SX-F", "125 SX", "150 SX", "300 SX",
				        "250 EXC", "300 EXC", "350 EXC-F", "450 EXC-F", "500 EXC-F",
				        "690 Enduro R", "790 Adventure", "890 Adventure", "1290 Super Adventure S", "1290 Super Adventure R",
				        "Freeride E-XC", "Freeride 250 F", "Freeride 350",
				        "Adventure 390", "Adventure 250", "Adventure 200",
				        "125 EXC", "150 EXC", "250 EXC TPI", "300 EXC TPI", "450 EXC", "500 EXC", 
				        "SMR 125", "SMR 250", "SMR 450", "SMR 690", "SX-E 5", "E-Speed",
				        "Mini Adventure", "65 SX", "85 SX", "105 SX", "50 SX", "50 Mini", 
				        "Enduro 350", "Enduro 450", "Enduro 500", "105 XC", "450 XC-F", "350 XC-F",
				        "450 Rally", "690 Rally", "950 Rally", "450 EXC Rally", "1290 Super Rally"));
		
		motos.put("Suzuki", 
				List.of("GSX-R1000", "GSX-R750", "GSX-R600", "GSX-S1000", "GSX-S750", "GSX250R", "Hayabusa", "Katana",
				        "SV650", "SV650X", "V-Strom 1050", "V-Strom 650", "V-Strom 250", "DR650", "DR-Z400", "DR-Z125",
				        "DR200", "RM-Z450", "RM-Z250", "RM85", "GSX1400", "GSX1250FA", "GSX650F", "GS500", "GSX250F",
				        "Inazuma 250", "Bandit 1250", "Bandit 650", "Intruder 1800", "Intruder 1500", "Intruder 800",
				        "Intruder 250", "Boulevard M109R", "Boulevard C50", "Boulevard S40", "Boulevard M50",
				        "Marauder 250", "Marauder 800", "GN125", "GN250", "GZ150", "GZ250", "TU250X", "DR-BIG",
				        "TS185", "TS250", "TS125", "TS90", "TS50", "GS450", "GS550", "GS750", "GS1000", "GS1100",
				        "GS1150", "GS1200SS", "Burgman 200", "Burgman 400", "Burgman 650", "Burgman 125",
				        "Access 125", "Avenis 125", "Lets", "Gixxer 250", "Gixxer 150", "Gixxer SF 250", "Gixxer SF 150",
				        "Shogun", "Raider R150", "Smash 115", "Address 110", "Step 125", "AX100", "Fronte", "RE5",
				        "X6 Hustler", "GT185", "GT250", "GT380", "GT500", "GT550", "GT750", "GSX1100S Katana",
				        "GSX1100G", "GSX1100F", "GSF600", "GSF1200", "GR650", "RE5", "DR-Z70", "DR-Z110", "DR-Z400SM",
				        "DR650SE", "VanVan 200", "VanVan 125", "GSX250R ABS", "GSX-S125", "RMX450Z", "GSX1300R Hayabusa"));
		
		motos.put("BMW", 
				List.of("S1000RR", "S1000R", "S1000XR", "R1250GS", "R1250RT", "R1250R", "R1250RS", "R nineT", "R nineT Pure",
				        "R nineT Scrambler", "R nineT Urban G/S", "G310R", "G310GS", "F750GS", "F850GS", "F850GS Adventure",
				        "F900R", "F900XR", "K1600GT", "K1600GTL", "K1600B", "K1600 Grand America", "R18", "R18 Classic",
				        "R18 B", "R18 Transcontinental", "C400X", "C400GT", "C650 Sport", "C650GT", "C Evolution",
				        "R1200GS", "R1200RT", "R1200R", "R1200RS", "F800GS", "F800R", "F800GT", "F700GS", "F650GS",
				        "K1300R", "K1300S", "K1200R", "K1200S", "K1200LT", "K1200GT", "R1100GS", "R1150GS", "R1100RT",
				        "R1150RT", "R1100R", "R1150R", "R1100S", "R1150RS", "HP2 Enduro", "HP2 Sport", "HP4",
				        "R80GS", "R90S", "R100RS", "R100RT", "R80RT", "R80ST", "R65", "R45", "K75", "K100", "K1100RS",
				        "K1100LT", "K1", "R80G/S", "R1200C", "G450X", "F650", "F650CS", "F650ST", "F650 Funduro",
				        "F650 Dakar", "G650GS", "G650 Xchallenge", "G650 Xmoto", "G650 Xcountry", "G310R", "G310GS",
				        "CE 04", "F900R", "F900XR", "S1000XR", "R nineT Racer", "R nineT Scrambler", "R nineT Urban G/S",
				        "R nineT Pure", "R nineT", "R18 B", "R18 Transcontinental", "R18 Classic", "R18", "C Evolution"));
		
		motos.put("Harley-Davidson",
				List.of("Sportster S", "Iron 883", "Iron 1200", "Forty-Eight", "Nightster", "Roadster", 
				        "Softail Standard", "Street Bob", "Low Rider", "Low Rider S", "Fat Bob", "Fat Boy", 
				        "Heritage Classic", "Deluxe", "Breakout", "Road King", "Road King Special", "Street Glide", 
				        "Street Glide Special", "Road Glide", "Road Glide Special", "Road Glide Limited", "Electra Glide", 
				        "Ultra Limited", "CVO Street Glide", "CVO Road Glide", "CVO Limited", "CVO Tri Glide", 
				        "Tri Glide Ultra", "Freewheeler", "LiveWire", "Pan America", "Pan America Special", 
				        "FXDR 114", "V-Rod", "Night Rod", "Street Rod", "Street 500", "Street 750", 
				        "Dyna Super Glide", "Dyna Street Bob", "Dyna Fat Bob", "Dyna Wide Glide", 
				        "Dyna Low Rider", "Dyna Switchback", "Super Glide", "Shovelhead", "Panhead", 
				        "Knucklehead", "Evolution", "Twin Cam", "Revolution Max", "Electra Glide Standard", 
				        "Road Glide Ultra", "Road Glide Custom", "Ultra Classic", "Heritage Springer", 
				        "Softail Slim", "Cross Bones", "Rocker", "Rocker C", "Street Glide ST", "Road Glide ST", 
				        "Sport Glide", "Night Train", "Wide Glide", "Street Bob 114", "Fat Boy 114", 
				        "Low Rider ST", "Breakout 114", "Iron 883N", "Iron 1200N", "Forty-Eight Special"));
		
		motos.put("Aprilia",
				List.of("Colibrì", "Scarabeo", "RS 50", "RS 125", "RS 250", "RS 660", "RSV Mille", "RSV Mille R", 
						"RSV4", "RSV4 Factory", "RSV4 RF", "RSV4 RR", "Tuono 50", "Tuono 125", "Tuono 660", 
						"Tuono V4", "Tuono V4 R", "Tuono V4 Factory", "Tuareg 600", "Tuareg 660", "Pegaso 600", 
						"Pegaso 650", "Pegaso 125", "Pegaso 300", "Pegaso 650 Trail", "Caponord 1200", 
						"Caponord 1200 Rally", "ETV 1000 Caponord", "Mana 850", "Shiver 750", "Shiver 900", 
						"Dorsoduro 750", "Dorsoduro 900", "Dorsoduro 1200", "SXV 450", "SXV 550", "RXV 450", 
						"RXV 550", "RS 660 Trofeo", "RSV4 X", "Moto 6.5", "Leonardo", "RS 125 GP Replica", 
						"SR Max 300", "SRV 850", "Atlantic 500", "Sportcity 250", "Red Rose 50", "Classic 50", 
						"RSV4 XTrenta"));
		
		motos.put("Zongshen",
				List.of("ZS 50 GY", "ZS 110-26", "ZS 125-2", "ZS 125-4", "ZS 125 GY-Un", "ZS 125 ST ATV", 
						"ZS 125 T-7", "ZS 125 T-8", "ZS 125 T-30", "ZS 150 GY", "ZS 200 GY", "ZS 200 GS", 
						"ZS 250 GY-3", "ZS 250 GS", "ZS 250-5", "ZS125-67", "RX1", "RX3", "RX4", "RC3", "RZ3", 
						"Zx 200", "Z One S", "Z II", "ZS 250-5C", "ZS 250-6", "ZS 250-8", "ZS 300-3", "ZS 400 GS", 
						"ZS 500 GS", "ZS 650 GY", "ZS 250GY-7A", "ZS 250GY-9", "ZS 250 ST", "ZS 250-8B", 
						"ZS 150-58", "ZS 150-7", "ZS 150-9", "ZS 150-10", "ZS 125-8", "ZS 125-10A", 
						"ZS 125-50", "ZS 250-10", "ZS 250 R", "ZS 250 RZ3S", "ZS 500-6"));
		
		motos.put("Lexmoto",
				List.of("LXR 125", "LXR SE 125", "LXS 125", "LXR 380", "Isca 125", "ZSB 125", "Michigan 125", 
						"Vendetta 250", "Tempest 125", "Tempest GT 125", "Isca 125", "ZSB 125", "Aspire 125", 
						"Venom 125", "Echo 50", "Echo 125", "Assault 125", "Urban 125", "ZSF 125", "ZSF 250", 
						"Valiant 125", "Viper 125", "Nano 50", "Nano 125", "Hawk 125", "Ranger 125", 
						"Pegasus 300", "Enigma 125", "Milano 125", "Diablo 125", "Vendetta 250", "LXR 380", 
						"Impulse 125", "FMX 125", "Kiden 125", "Hunter 50", "Hunter 125", "Riviera 125", 
						"Chieftain 125", "Vienna 50", "Vienna 125", "Cypher (Eléctrica)", "E-Lex (Eléctrica)"));
		
		motos.put("Lifan",
				List.of("KPR 200", "KPT 200", "KP 150", "KP Mini", "LF150-10S", "LF125-14F", "LF250GY-2", "LF200GY-5", 
						"LF150-5U", "LF125-8", "LF200-10P", "LF150-10B", "LF125-14", "LF250-19", "LF150-10R", 
						"LF150-5P", "LF200GY-6B", "LF200-3", "LF200-4", "LF200GY-2", "LF200GY-7", "LF250GY-3", 
						"LF200-10R", "LF150-10M", "LF150-10L", "LF150-5", "LF100-7F", "LF125-14G", "LF125-14P", 
						"LF150-10N", "LF250-3", "LF250-19", "LF250-B", "LF250GY-7", "LF200GY-4", "LF150GY-5", 
						"LF125-10", "LF200-3A", "LF250-B", "LF200-4A", "LF250-5", "LF200GY-5A", "LF250-19A"));
		
		motos.put("SYM",
				List.of("Jet 14 125", "Jet 14 200", "Symphony ST 125", "Symphony SR 125", "Symphony SR 150", 
						"Symphony 50", "Symphony 125", "Symphony 200", "Cruisym 125", "Cruisym 150", "Cruisym 300", 
						"Cruisym Alpha 300", "Cruisym 250", "Cruisym 400", "Fiddle II 50", "Fiddle II 125", 
						"Fiddle III 50", "Fiddle III 125", "Fiddle 200", "Fiddle 4 125", "Fiddle 4 150", 
						"NH-T 125", "NH-X 125", "NH-T 200", "NH-X 200", "Maxsym 400", "Maxsym 500", "Maxsym TL 500", 
						"Maxsym 600i", "Joyride 125", "Joyride 200", "Joyride S 200", "Joyride S 125", 
						"Joymax Z 125", "Joymax Z 300", "Orbit 50", "Orbit 125", "Orbit III 125", "Wolf 125", 
						"Wolf 150", "Magic 110", "Crox 50", "Crox 125", "X-Pro 125", "Husky 125", "Attila 125", 
						"Citycom 300i", "Citycom S 300i", "Allo 50", "Duke 125", "Duke 150", "SR 150", "SR 200"));
		
		motos.put("Loncin",
				List.of("GP 150", "GP 200", "CR 9", "LX 650", "DS8", "Voge 500R", "Voge 500DS", "Voge 300RR", 
						"Voge 300AC", "Voge 300DS", "Voge 300R", "Voge 350AC", "Voge 500AC", "Voge 650DS", 
						"Voge 650DSX", "Voge 500ACX", "LX250-8", "LX250-16", "LX300", "LX300GY", "LX400", 
						"LX500", "LX650", "CR10", "CR7", "CR6", "CR5", "CR1", "DS7", "DS6", "LX200", "LX150", 
						"Revo 150", "Revo 250", "Voge 125R", "Voge 125AC", "Voge 300RR Special Edition", 
						"Voge 500DSX", "Voge 650DS Adventure", "Voge 300 Rally", "Voge 500DS Pro"));
		
		motos.put("Zero",
				List.of("DSR/X 17.3 Black Forest 2025", "DSR/X 17.3 2025", "SR/S 17.3 2025", "SR/F 17.3 2025", 
						"DSR 15.6 2025", "SR 15.6 2025", "FX 7.2 2025", "DS 14.4 2025", "S 14.4 2025", 
						"FXE 7.2 2025", "XE 4.3 2025", "XB 2.4 2025", "Zero S", "Zero DS", "Zero SR", 
						"Zero DSR", "Zero FX", "Zero FXS", "Zero SR/F", "Zero SR/S", "Zero DSR Black Forest", 
						"Zero DSR/X", "Zero XU", "Zero X", "Zero MX", "Zero FXE", "Zero S ZF14.4", "Zero SR ZF14.4", 
						"Zero DS ZF14.4", "Zero FX ZF7.2", "Zero FXS ZF7.2", "Zero SR/F Premium", "Zero SR/S Premium", 
						"Zero SR/F Standard", "Zero SR/S Standard", "Zero DSR ZF14.4", "Zero DSR ZF15.6", 
						"Zero DSR/X ZF17.3", "Zero SR/F ZF15.6", "Zero SR/S ZF15.6", "Zero S ZF7.2", "Zero FXE ZF7.2"));
		
		motos.put("Vespa", List.of("GTS 125 FL24 E5+", "GTS 125 Super FL24 E5+", "GTS 125 Supersport FL24 E5+", "GTS 310 FL24 E5+", 
				"GTS 310 Super FL24 E5+", "GTS 310 Supersport FL24 E5+", "Sprint S 50 FL 24", "Sprint S 125 FL 24", "Primavera 50 FL 24", 
				"Primavera S 50 FL 24", "Primavera 50 4T RED FL 24", "Primavera 50 TECH FL 24", "Primavera 125 FL 24", 
				"Primavera 125 S FL 24", "Primavera 125 RED FL 24", "Primavera 125 Batik FL 24", "Primavera 125 Tech FL 24", 
				"Primavera Elettrica (L1)", "Sprint S Elettrica (L1)", "Primavera Elettrica RED (L1)", 
				"Primavera Tech Elettrica FL 24 (L3)", "Primavera Tech RED Elettrica FL 24 (L3)", "GTV 300"));
		
		motos.put("Triumph", List.of( "Bonneville Bobber 2025", "Bonneville Bobber Icon Edition 2025", "Bonneville Bobber TFC 2025", 
				"Bonneville Speedmaster 2025", "Bonneville Speedmaster Icon Edition 2025", "Bonneville T100 2025", 
				"Bonneville T100 Blue Stealth 2024", "Bonneville T100 Chrome 2023", "Bonneville T100 Icon Edition 2025", 
				"Bonneville T120 2025", "Bonneville T120 Black 2021-2024", "Bonneville T120 Icon Edition 2025", 
				"Rocket 3 GT Evel Knievel 2025", "Rocket 3 R Evel Knievel 2025", "Scrambler 1200 X Icon Edition 2025", 
				"Scrambler 1200 XE 2024", "Scrambler 1200 XE Icon Edition 2025", "Scrambler 400 X 2024", 
				"Scrambler 900 2025", "Scrambler 900 Icon Edition 2025", "Speed 400 2024", "Speed Triple 1200 RR 2022-2024", 
				"Speed Triple 1200 RR Breitling 2024", "Speed Triple 1200 RS 2021-2024", "Speed Triple 1200 RS 2025", 
				"Speed Twin 1200 2025", "Speed Twin 1200 RS 2025", "Speed Twin 900 2023-2024", "Speed Twin 900 2025", 
				"Street Triple 765 R/A2 2025", "Street Triple 765 RS 2025", "Tiger 1200 Rally Pro 2024", 
				"Tiger 850 Sport 2025", "Tiger 900 GT 2024", "Tiger 900 GT Pro 2024", "Tiger 900 Rally Pro 2024", 
				"Tiger Sport 660 2025", "Tiger Sport 800 2025", "Trident 660 2021-2024", "Trident 660 2025", 
				"Daytona 660 2024", "Daytona 675", "Daytona 675 2013", "Daytona 675 ABS 2013", "Daytona 675 R", 
				"Daytona 675 R 2013", "Daytona 675 SE", "Daytona 765 Moto2 Limited Edition", 
				"Speed Triple 1200 RR Bond Edition 2023", "Street Triple 765 R 2023-2024", "Street Triple Moto2 2023" ));
		
		motos.put("Rieju", List.of( "MRT 50 SM Trophy 2025", "Nuuk Urban 6 2022", "Tango 125/Scrambler 2022-2024", 
				"Blast Urban 50 2018", "Bye Bike 2018-2020", "Century 125 2018-2021", "City Line 125", "City Line 300", 
				"E-City 125 2022", "Marathon 125 Pro 2022", "MR 300 Pro 2024", "MR Racing 300 2024", "MRT 50 2025", 
				"MRT 50 Pro 2025", "Marathon Pro 250 2010", "Marathon Pro 450 2010", "MR 250 Racing/Pro 2022", 
				"MR 250 Racing/Pro 2023", "MR 300 Racing/Pro 2021", "MR 300 Racing/Pro 2022", "MR 300 Racing/Pro 2023", 
				"MR Ranger 200 2023", "MR Ranger 300 2023", "MRT 125 AC 2016-2017", "MRT 50 2010-2017", 
				"MRT 50 2022", "MRT 50 Pro 2010-2017", "MRT 50 Pro 2022", "MRT 50/Pro/Replica 2018-2021", 
				"Aventura 500", "Aventura 125", "RS3 NKD 50", "RS3 50", "Strada 125", "Marathon 50", "Marathon 74", 
				"Sprint", "P3A", "TT", "Automatic KS", "Drac", "RR 50", "RS1", "RS2" ));
		
		motos.put("Piaggio",
				List.of("Vespa 50", "Vespa 125", "Vespa 150", "Vespa 200", "Vespa 300", 
						"Vespa Sprint 50", "Vespa Sprint 125", "Vespa Sprint 150", "Vespa GTS 125", 
						"Vespa GTS 300", "Vespa GTS 300 HPE", "Vespa Elettrica", "Liberty 50", 
						"Liberty 125", "Liberty 150", "Liberty 200", "Beverly 125", 
						"Beverly 300", "Beverly 350", "Piaggio MP3 250", 
						"MP3 300", "MP3 500", "Zip 50", "Zip 100", 
						"Fly 50", "Fly 125", "Fly 150", "Medley 125", 
						"Medley 150", "Medley 300", "X10 125", "X10 350", 
						"X10 500", "BV350", "BV500", "Typhoon 50", 
						"Typhoon 125", "Typhoon 150", "Liberty S 50", "Liberty S 125", 
						"Zip S 50", "Zip S 100", "TPH 50", "TPH 125", 
						"Beverly SportTouring 300", "Beverly 400", "MP3 Yourban 300", 
						"MP3 Yourban 500", "Biker 125", "Fly 150 CC", "Ape 50"));
		
		motos.put("Peugeot",
				List.of("Django 50", "Django 125", "Django 150", "Tweet 50", 
						"Tweet 100", "Tweet 125", "Citystar 50", "Citystar 125", 
						"Citystar 200", "Speedfight 50", "Speedfight 100", "Speedfight 125", 
						"Ludix 50", "Ludix 100", "Ludix 125", "Vivacity 50", 
						"Vivacity 100", "Vivacity 125", "Satelis 125", "Satelis 300", 
						"Metropolis 400", "Metropolis 500", "Kisbee 50", "Kisbee 100", 
						"Kisbee 125", "Tweet 50 4T", "Traveller 50", "Traveller 100", 
						"Traveller 125", "Pulsion 125", "Pulsion 300", "Belville 125", 
						"Belville 200", "XR7", "XR8", "RCX 50", "RCX 100", 
						"RCX 125"));
		
		motos.put("Montesa",
				List.of("Cota 4RT", "Cota 301RR", "Cota 300RR", "Cota 260", "Cota 125", 
						"Cota 4RT 260", "Cota 300", "Cota 200", "Cota 349", "Cota 348", 
						"Cota 247", "Cota 247RR", "Cota 247 Mk1", "Cota 247 Mk2", "Cota 247 Mk3", 
						"Cota 315R", "Cota 315", "Cota 350", "Cota 350RR", "Cota 280", 
						"Cota 280RR", "Cota 175", "Cota 125RR", "4RT 260", "4RT 300", 
						"Cota 4RT 125", "315R", "350", "280", 
						"Cota 300RR 4RT", "Cota 301RR 4RT", "4RT Racing", "Cota 360", 
						"Cota 247", "Cota 248", "360", "123", 
						"350 V1", "350 V2"));
		
		motos.put("MITT",
				List.of("125 GPR", "125 RR", "125 GP", "125 X", "125 Scrambler", 
						"125 Cafe Racer", "125 Cruiser", "150 GPR", "150 RR", 
						"150 X", "150 GP", "300 GPR", "300 RR", "300 X", 
						"300 GP", "500 GPR", "500 RR", "500 X", "500 GP", 
						"650 X", "650 GP", "650 RR", "650 Scrambler", 
						"650 Cruiser", "500 Cafe Racer", "125 Enduro", "250 Enduro", 
						"500 Enduro", "125 Street Fighter", "150 Street Fighter", 
						"300 Street Fighter", "500 Street Fighter"));
		
		motos.put("Mondial",
				List.of("50", "125", "200", "HPS 125", "HPS 300", 
						"HPS 500", "SMX 125", "SMX 250", "SMX 500", 
						"Sport 50", "Sport 125", "Cafe Racer 125", "Café Racer 250", 
						"Pagani 125", "Pagani 200", "Pagani 300", "Torpedo 125", 
						"Torpedo 150", "V2 125", "V2 250", "V2 300", 
						"V2 500", "CR 125", "CR 250", "CR 500", 
						"125 Sport", "250 Sport", "500 Sport", "V2 Sport", 
						"50 E5", "125 E5", "250 E5", "300 E5"));
		
		motos.put("Malaguti",
				List.of("Madison 125", "Madison 150", "Madison 250", "F12 50", "F12 100", 
						"F15 125", "F15 150", "F15 250", "XTM 125", "XTM 200", 
						"XTM 250", "XSM 125", "XSM 200", "XSM 250", "Fighter 50", 
						"Fighter 100", "Fighter 125", "Fighter 150", "Fighter 250", 
						"Zebra 50", "Zebra 125", "Zebra 150", "Zebra 200", "Crosser 50", 
						"Raptor 125", "Raptor 250", "Raptor 500", "Raptor X", "Krypton 50", 
						"Krypton 125", "Krypton 150", "Krypton 200", "Krypton 250", 
						"Madison 400", "Phantom 50", "Phantom 125", "Phantom 150", 
						"Phantom 250", "Malaguti 125", "Malaguti 150", "Malaguti 200", 
						"Malaguti 250", "Reptile 125", "Reptile 150", "Reptile 250", 
						"Reptile 500", "Spyder 125", "Spyder 150", "Spyder 200"));
		
		motos.put("Macbor",
				List.of("50", "125", "250", "500", "X-Ride 125", 
						"X-Ride 250", "X-Ride 500", "Scrambler 125", "Scrambler 250", 
						"Scrambler 500", "Cafe Racer 125", "Cafe Racer 250", 
						"Cafe Racer 500", "Roadster 125", "Roadster 250", "Roadster 500", 
						"Enduro 125", "Enduro 250", "Enduro 500", "Adventure 125", 
						"Adventure 250", "Adventure 500", "Trail 125", "Trail 250", 
						"Trail 500", "Custom 125", "Custom 250", "Custom 500", 
						"Urban 125", "Urban 250", "Urban 500", "X-Trail 250", 
						"X-Trail 500", "Supermoto 125", "Macbor Supermoto 250", "Macbor Supermoto 500"));
		
		motos.put("MH",
				List.of("50", "125", "250", "125 Enduro", "125 Sport", "125 Cafe Racer", 
						"125 Scrambler", "250 Enduro", "250 Sport", "250 Scrambler", 
						"400", "650", "125 R", "250 R", "125 X", "250 X", 
						"250 C", "125 C", "500", "150", "300", "650 Cafe Racer", 
						"250 Cafe Racer", "125 Cruiser", "250 Cruiser", "Supermotard 125", 
						"Supermotard 250", "Scrambler 125", "Scrambler 250", "Enduro 125", 
						"Enduro 250", "Enduro 500"));
		
		motos.put("Mash",
				List.of("Seventy 50", "Seventy 125", "Seventy 250", "Dirt 50", 
						"Dirt 125", "Dirt 250", "Five Hundred", "Scrambler 50", 
						"Scrambler 125", "Scrambler 250", "Roadstar 125", "Roadstar 250", 
						"Cafe Racer 125", "Cafe Racer 250", "X-Ride 125", "X-Ride 250", 
						"Black Seven 125", "Black Seven 250", "Brat 125", "Brat 250", 
						"Heritage 125", "Heritage 250", "TT40 125", "TT40 250", 
						"Spirit 125", "Spirit 250", "Seventy 125 Limited Edition", 
						"Seventy 250 Limited Edition", "400", "650", "125 Enduro", 
						"250 Enduro", "400 Scrambler", "650 Scrambler"));
		
		motos.put("Lambretta",
			    List.of(
			        "M", "A", "B", "C", "D", "LD", "E", "F", "J", "J50", "Li 125", "Li 150", "Li 175", 
			        "Li Special", "TV 175", "TV 200", "GP 125", "GP 150", "GP 200", "SX 150", "SX 200", 
			        "V50", "V125", "V200", "G325", "G350", "LN 125", "LN 150", "LN 151", "Pato", 
			        "Centomila", "Serveta Li 150", "Serveta Jet 200", "Grand Prix", "Super Star", 
			        "Special 125", "Special 150", "Special 200", "V-Special 50", "V-Special 125", 
			        "V-Special 200", "X300", "G-Special 300", 
			        "DL", "DL 125", "DL 150", "DL 200", "DLE", "DLE 125", "DLE 150", "DLE 200", 
			        "S1", "S2", "S3", "S4", "S5", "S6", "S7", "S8", "S9", "S10", 
			        "Concept 1", "Concept 2", "Vision", 
			        "Urban EV", "City Commuter", "Adventure", 
			        "Cargo EV", "Commercial EV", "Smart EV", 
			        "Future EV", "Hybrid", "Electric Cruiser"
			    )
			);
		
		motos.put("Keeway",
				List.of("RKF 125", "RKR 125", "K-Light 125", "K-Light 200", "Superlight 125", 
						"Superlight 200", "Superlight 250", "Superlight Limited Edition", 
						"TX 125", "TX 200", "TX 125 S", "TX 200 S", "TX 250", 
						"RKS 125", "RKS 150", "RKS 200", "RKV 125", "RKV 200", 
						"RKV Sport 125", "RKV Sport 200", "Blackster 250", "Cruiser 250", 
						"Patagonian Eagle 250", "Patagonian 150", "Patagonian 200", "Patagonian 250", 
						"Outlook 125", "Outlook 150", "Logik 125", "Logik 150", "Cityblade 125", 
						"Cityblade 150", "Matrix 125", "F-Act 50", "F-Act Evo 50", "Pixel 50", 
						"Zahara 125", "Zahara 150", "Vieste 125", "Vieste 300", "Blueshark R", 
						"Blueshark Lite", "Blueshark GT", "Sixties 300i", "Silverblade 250", 
						"Silverblade 300", "RY6 50", "RY8 50", "Leone 125", "X-Ray 125", 
						"X-Ray 150", "X-BLADE 125", "X-BLADE 150", "Keeway Versilia 125", 
						"Keeway Versilia 150", "Keeway SR 125", "Keeway SR 250"));
		
		motos.put("Kymco",
				List.of("Agility 50", "Agility 125", "Agility City 125", "Agility City 150", "Agility City 200", 
						"Agility Plus 125", "Super Dink 125", "Super Dink 300", "Super Dink 350", "Grand Dink 125", 
						"Grand Dink 300", "People 125", "People S 125", "People GT 300", "People One 125", 
						"Downtown 125", "Downtown 300", "Downtown 350", "AK 550", "Xciting 250", 
						"Xciting 300", "Xciting 400", "Xciting S 400", "Like 50", "Like 125", 
						"Like 150", "Like 200", "Like 300", "Miler 125", "Vitality 50", 
						"Dink 50", "Dink 125", "Dink 200", "Dink Street 125", "Dink Street 300", 
						"Venox 250", "Pulsar 125", "Pulsar 150", "Pulsar 200", "Movie 125", 
						"Bet&Win 150", "Bet&Win 250", "K-XCT 125", "K-XCT 300", "X-Town 125", 
						"X-Town 300", "X-Town 400", "UXV 450", "MXU 300", "MXU 700", 
						"Mongoose 90", "Mongoose 270", "Mongoose 700", "Maxxer 300", "Maxxer 450", 
						"K-Pipe 125", "K-Pipe 50", "Filly 50", "Sento 50", "Sento 100", 
						"Super 8 50", "Super 8 125", "Super 9 50", "Downtown 125i", "Downtown 350i"));
		
		motos.put("Indian",
				List.of("Chief", "Chief Dark Horse", "Chief Bobber", "Chief Bobber Dark Horse", "Chieftain", 
						"Chieftain Dark Horse", "Chieftain Limited", "Chieftain Elite", "FTR 1200", "FTR 1200 S", 
						"FTR 1200 Rally", "FTR", "FTR R Carbon", "Roadmaster", "Roadmaster Dark Horse", 
						"Roadmaster Limited", "Roadmaster Elite", "Scout", "Scout Sixty", "Scout Bobber", 
						"Scout Bobber Sixty", "Scout Bobber Twenty", "Springfield", "Springfield Dark Horse", 
						"Super Chief", "Super Chief Limited", "Super Chief Dark Horse", "Challenger", 
						"Challenger Dark Horse", "Challenger Limited", "Challenger Elite", "Vintage", 
						"Vintage Dark Horse", "Spirit of Munro", "Powerplus", "Four", "Big Chief", 
						"Big Chief Special", "Warrior", "Arrow", "Junior Scout", "Daytona", "Ace", 
						"Silver Arrow", "Model O", "Model K", "Model C", "Model F", "Model O", "Roadster", 
						"Indian Four", "Standard", "Prince"));
		
		motos.put("Husqvarna",
				List.of("Svartpilen 125", "Svartpilen 250", "Svartpilen 401", "Svartpilen 701", 
						"Vitpilen 125", "Vitpilen 250", "Vitpilen 401", "Vitpilen 701", 
						"Norden 901", "Norden 901 Expedition", "TE 150", "TE 250", "TE 300", 
						"TE 310", "TE 350", "TE 450", "TE 510", "TE 610", "TE 630", 
						"FE 250", "FE 350", "FE 450", "FE 501", "FE 701", 
						"TC 50", "TC 65", "TC 85", "TC 125", "TC 250", "TC 450", 
						"TX 125", "TX 300", "TXC 250", "TXC 310", "TXC 450", 
						"FC 250", "FC 350", "FC 450", "FS 450", "SM 125", "SM 450", 
						"SM 610", "SM 630", "701 Enduro", "701 Supermoto", "TR 650 Strada", 
						"TR 650 Terra", "WR 125", "WR 250", "WR 300", "WR 360", 
						"WR 430", "WR 500", "WR 125X", "WR 250X", "WR 300X", 
						"CR 125", "CR 250", "CR 360", "CR 500"));
		
		motos.put("Gas Gas",
				List.of("TXT 80", "TXT 125", "TXT 250", "TXT 280", "TXT 300", 
						"TXT Racing 125", "TXT Racing 250", "TXT Racing 280", "TXT Racing 300", 
						"TXT GP 125", "TXT GP 250", "TXT GP 280", "TXT GP 300", 
						"EC 125", "EC 200", "EC 250", "EC 300", "EC 350", 
						"EC 450", "EC Ranger 200", "EC Ranger 300", 
						"EC 250F", "EC 350F", "EC 300F", "EC 450F", 
						"MC 125", "MC 250", "MC 450F", "MC 65", "MC 85", 
						"MC 250F", "MC 350F", "MC-E 5", "MC-E 12", "MC-E 16", 
						"SM 125", "SM 250", "SM 450", 
						"XC 125", "XC 200", "XC 250", "XC 300", "XC 450", 
						"XC 250F", "XC 350F", "XC 300F", "XC 450F", 
						"TXE", "Contact 250", "Contact 280", "Contact 300"));
		
		motos.put("Hanway",
				List.of("Raw 50", "Raw 125", "Raw Café 125", "Raw Café Racer 50", "Raw Café Racer 125", 
						"Raw SR 125", "Muscle 125", "Scrambler 125", "Scrambler 50", "Tourer 125", 
						"Street 50", "Street 125", "Black Café 125", "Black Café 50", "SC 125", 
						"SC 50", "Raw SR Chrome 125", "Raw SR Chrome 50", "Venture 125", "Venture 50", 
						"G15 Adventure 125", "G15 Scrambler 125", "G15 Urban 125", "G15 Adventure 50", 
						"Scrambler 125 Furious", "Café Racer 125 Limited", "Raw Sport 125", 
						"Raw Sport 50", "Flash 125", "Flash 50", "Furious 125", "Furious 50", 
						"Vintage 125", "Vintage 50"));
		
		motos.put("Fantic",
				List.of("Caballero 50", "Caballero 125", "Caballero 200", "Caballero 250", "Caballero 500", 
						"Caballero 500 Scrambler", "Caballero 500 Rally", "Caballero 500 Flat Track", 
						"Caballero 500 Deluxe", "Caballero 500 Explorer", "Caballero 125 Scrambler", 
						"Caballero 125 Rally", "Caballero 125 Flat Track", "Issimo 50", "Issimo 125", 
						"TX 150", "TX 200", "TX 250", "TX 300", "XE 125", "XE 250", "XE 300", "XX 125", 
						"XX 250", "XX 300", "Motard 50", "Motard 125", "E-Motard", "Performance 125", 
						"Performance 250", "Performance 300", "Supermotard 50", "Supermotard 125", 
						"Motorcross 50", "Motorcross 125", "Casa 50", "Casa 125", "TR 50", "TR 125", 
						"TR 250", "TR 300", "K-Racer 125", "K-Racer 250", "K-Racer 500", "Caballero Rally 125", 
						"Caballero Rally 500", "Enduro 50", "Enduro 125", "Enduro 250", "Enduro 300"));
		
		motos.put("Derbi",
				List.of("Senda 50", "Senda Xtreme 50", "Senda DRD Racing 50", "Senda DRD Pro 50", 
						"Senda Baja 50", "Senda SM 50", "Senda R 50", "Senda X-Treme SM", "Senda X-Treme R", 
						"Senda DRD X-Treme", "Senda DRD Limited", "Senda DRD Evo", "Senda DRD Pro SM", 
						"Senda DRD Pro R", "Senda DRD Racing SM", "Senda DRD Racing R", "Senda DRD Pro Limited", 
						"Terra 125", "Terra Adventure 125", "Mulhacén 125", "Mulhacén Café 125", 
						"Mulhacén Café 659", "GPR 50", "GPR 125", "GPR 50 Racing", "GPR 125 Racing", 
						"GPR 50 Nude", "GPR 125 Nude", "Cross City 125", "Boulevard 125", "Variante 48", 
						"Antorcha", "Rabasa", "Diablo", "Paddock 50", "Vamos 125", "Vamos 200", 
						"Atlantis 50", "Atlantis 100", "Atlantis 125", "Atlantis Bullet", 
						"Scooter 50", "GP1 50", "GP1 125", "GP1 250", "Sonar 50", "Sonar 125", 
						"Predator 50", "Predator 100", "Variant", "Revolution 50", "Revolution 125"));
		
		motos.put("Brixton",
			    List.of(
			        "Crossfire 125", "Crossfire 125 XS", "Crossfire 250", "Crossfire 500", "Crossfire 500 X", 
			        "Crossfire 500 XC", "Cromwell 125", "Cromwell 250", "Cromwell 500", 
			        "Felsberg 125", "Felsberg 250", "Felsberg 500", "Rayburn 125", 
			        "Sunray 125", "BX 125", "BX 125 R", "BX 125 X", "Glanville 250 X", 
			        "BX 150", "BX 150 R", "BX 150 X", "BX 250", "BX 250 R", "BX 250 X", 
			        "BX 500", "BX 500 R", "BX 500 X", "BX Adventure", "BX Scrambler", 
			        "BX Cafe Racer", "BX Street", "BX Urban Cruiser", "BX City Commuter", 
			        "BX Cargo", "BX Commercial", "BX Electric", "BX Hybrid", 
			        "BX Concept 1", "BX Concept 2", "BX Vision", "BX Future EV", 
			        "BX Smart EV", "BX Urban EV", "BX Adventure EV", "BX Cargo EV"
			    )
			);
		
		motos.put("Daelim",
				List.of("Daystar 125", "Daystar 250", "Daystar VL 125", "Roadwin 125", "Roadwin R 125", 
						"Roadwin 250", "Roadwin 250R", "S1 125", "S2 125", "S3 125", "S3 250", 
						"VJF 125", "VJF 250", "VJ 125", "B-Bone 125", "Besbi 125", "Citi Ace 110", 
						"Dart 125", "Deluxe 125", "Freewing 250", "History 125", "NS 125", "NS 250", 
						"Steezer 125", "Steezer 250", "VC 125", "VS 125", "XQ 125", "XQ 250", 
						"Aquila 125", "Aquila 250", "Aquila GV 125", "Aquila GV 250", "V-Lux 125", 
						"V-Lux 250", "V-Gran 125", "V-Gran 250", "Defcon 125", "Defcon 250", "Lynx 125"));
		
		motos.put("Bimota",
				List.of("HB1", "HB2", "HB3", "KB1", "KB2", "KB3", "KB4", "KB4 RC",
						"SB2", "SB3", "SB4", "SB5", "SB6", "SB6R", "SB7", "SB8K", "SB8R", 
						"SB8RS", "SB8K Santamonica", "DB1", "DB2", "DB3 Mantra", "DB4", "DB5", 
						"DB5R", "DB6 Delirio", "DB7", "DB8", "DB9 Brivido", "DBX", "BB1 Supermono", 
						"BB2", "BB3", "Tesi 1D", "Tesi 2D", "Tesi 3D", "Tesi H2", "YB3", "YB4", 
						"YB4EI", "YB5", "YB6", "YB7", "YB8", "YB9", "YB10", "YB11", "YB12", 
						"YB8 Furano", "YB8 Evoluzione", "YB11 Superleggera", "V-Due", "TESI H2 Carbon", 
						"TESI H2 Traditional", "TESI H2 Carbono", "KB4 RC", "KB4", "TESI H2 Naked"));
		
		motos.put("Benelli",
				List.of("Imperiale 400", "Leoncino 250", "Leoncino 500", "Leoncino 800", "Leoncino 800 Trail", 
						"TRK 251", "TRK 502", "TRK 502 X", "TRK 702", "TRK 702 X", "TRK 800", 
						"302R", "TNT 125", "TNT 135", "TNT 150", "TNT 300", "TNT 600", "TNT 899", 
						"TNT 1130", "Tornado Naked Tre 899", "Tornado Naked Tre 1130", "Tornado 302", 
						"Tornado 650", "Tornado 900", "Tornado Tre 900", "Tornado Tre 1130", "Quattro 500", 
						"Sei 750", "Sei 900", "BN 125", "BN 251", "BN 302", "BN 600", "BN 600i", 
						"BN 302 S", "BN 502", "Velvet 125", "Velvet 150", "Caffenero 150", "Caffenero 250", 
						"Pepe 50", "Pepe 125", "Macis 125", "Macis 150", "Zenzero 350", "Citybike 125", 
						"Citybike 250", "Mini Bike 50", "Motorella 50", "MotoBi 125", "Sprite 200", 
						"Sprite 250", "Sprite 350", "Sport 250", "Sport 500", "Sport Special", 
						"250 2C", "500 LS", "504 Sport", "654 Sport", "654 Tourer", "654 Racing", 
						"750 Sei", "900 Sei", "Trek 1130", "Trek Amazonas 1130", "BX 250", "BX 500", 
						"502 C", "502 Cruiser"));
		
		motos.put("Can-Am",
				List.of("Ryker", "Ryker Rally Edition", "Spyder F3", "Spyder F3-S", "Spyder F3-T", "Spyder F3 Limited",
						"Spyder RT", "Spyder RT Limited", "Spyder RS", "Spyder RS-S", "Spyder ST", "Spyder ST-S",
						"Spyder ST Limited", "Spyder GS", "Outlander 450", "Outlander 570", "Outlander 650", 
						"Outlander 850", "Outlander 1000", "Outlander X mr", "Outlander X xc", "Outlander MAX", 
						"Renegade 570", "Renegade 850", "Renegade 1000", "Commander 700", "Commander 1000", 
						"Defender HD5", "Defender HD8", "Defender HD10", "Maverick 1000R", "Maverick X3", 
						"Maverick X3 Max", "Maverick Trail", "Maverick Sport", "DS 450", "DS 250", "DS 90", 
						"DS 70", "Rally 175", "Rally 200", "MX2", "MX3", "ASE 250", "ASE 500", "ASE 800"));
		
		motos.put("Hyosung",
				List.of("GT125", "GT125R", "GT250", "GT250R", "GT650", "GT650R", "GV125C", "GV125S", 
						"GV250", "GV300S", "GV650", "GV700C", "ST7", "RT125D", "RT125 Karion", 
						"RT125 SM", "Aquila 125", "Aquila 250", "Aquila 650", "Exiv 250", "Exiv 650", 
						"Comet 125", "Comet 250", "Comet 650", "MS3-125", "MS3-250", "RX125", "RX250", 
						"RX450", "RX650", "Mirage 250", "Mirage 650", "GV650 Pro", "Aquila GV250FI", 
						"GD250N", "GD250R", "GT300R", "GV300DR", "GV650 Classic", "GT250 Naked", 
						"GT650 Naked", "RX450SM", "RX450R"));
		
		motos.put("Moto Guzzi",
				List.of("V7", "V7 III", "V7 Special", "V7 Stone", "V7 Rough", "V7 Racer", "V7 Classic",
						"V7 II", "V7 II Stone", "V7 II Special", "V7 II Racer", "V7 III Stone", 
						"V7 III Special", "V7 III Racer", "V7 III Rough", "V7 III Milano", "V7 Centenario", 
						"V9 Bobber", "V9 Roamer", "V85 TT", "V85 TT Travel", "V85 TT Centenario", 
						"V100 Mandello", "V100 Mandello S", "California 1400", "California Touring", 
						"California Custom", "California Vintage", "California III", "California II", 
						"California 1100", "California Stone", "California Special", "California EV", 
						"Griso 1100", "Griso 1200", "Norge 1200", "Norge GT 8V", "Breva 750", 
						"Breva 850", "Breva 1100", "Breva 1200", "Bellagio", "Stelvio 1200", "Stelvio NTX", 
						"Le Mans", "Le Mans II", "Le Mans III", "Le Mans 850", "Le Mans 1000", 
						"Daytona 1000", "Daytona RS", "Sport 1100", "Sport 1200", "850 T3", "850 Le Mans", 
						"850 California", "V50", "V65", "V75", "850 GT", "Galletto", "Falcone", "Airone", 
						"Zigolo", "Dingo", "Stornello", "Lodola", "Cardellino", "Nuovo Falcone", 
						"Audace", "Eldorado", "MGX-21", "MGS-01", "Quota 1000", "Quota 1100", "Quota 650", 
						"Quota 750", "TS", "V11 Le Mans", "V11 Sport", "V11 Rosso Mandello"));
		
		motos.put("MV Agusta",
				List.of("Brutale 675", "Brutale 800", "Brutale 800 RR", "Brutale 1000 RR", 
						"Brutale 1000 Nürburgring", "Brutale Dragster 800", "Brutale Dragster 800 RR", 
						"Brutale Dragster 800 RC", "Brutale Dragster 800 Rosso", "F3 675", "F3 800", 
						"F3 800 RC", "F4", "F4 RR", "F4 RC", "Superveloce 800", "Superveloce 800 S", 
						"Superveloce 800 Serie Oro", "Superveloce 800 Ago", "Superveloce 1000", 
						"Rush 1000", "Turismo Veloce 800", "Turismo Veloce 800 Lusso", 
						"Turismo Veloce 800 Lusso SCS", "Turismo Veloce 800 RC", "Turismo Veloce 800 Rosso", 
						"Turismo Veloce 800 SCS", "Turismo Veloce 800 Rosso SCS", "Rapido Sport", 
						"Rapido Lusso", "125 TR", "175 CSS", "350 B", "350 Sport", "350 Ipotesi", 
						"750S", "750 Sport", "750 America", "750 S America", "750 Super America", 
						"MV Agusta 500 Three", "Magni 861", "Magni 1200", "Rivale 800", "Rivale 800 RR", 
						"RVS#1", "Stradale 800", "Cagiva Elefant 900 IE", "Cagiva Grand Canyon 900", 
						"Dragster RC Shining Gold", "Brutale 1000 Serie Oro"));
		
		motos.put("Moto Morini",
				List.of("Corsaro 1200", "Corsaro 1200 Veloce", "Corsaro ZZ", "Corsaro ZT", 
						"Seiemmezzo STR", "Seiemmezzo SCR", "Milano", "Super Scrambler", 
						"X-Cape", "X-Cape 649", "X-Cape 650", "Granpasso 1200", "Scrambler 1200", 
						"Rebello 1200 Giubileo", "3 1/2", "3 1/2 Sport", "500 Camel", 
						"500 Excalibur", "500 Sei-V", "KJ 125", "KJ 200", "Corsarino", 
						"Excalibur 350", "Excalibur 501", "New York 350", "New York 501", 
						"125 H", "250 T", "350 K2", "350 Sport", "350 Turismo", "500 Turbo", 
						"501 Camel", "501 Excalibur", "Granpasso R", "Corsaro Avio", 
						"X-Cape Adventure", "X-Cape Rally"));
		
		motos.put("Royal Enfield",
				List.of("Bullet 350", "Bullet 500", "Classic 350", "Classic 500", "Interceptor 650", 
						"Continental GT 650", "Meteor 350", "Super Meteor 650", "Himalayan", 
						"Scram 411", "Thunderbird 350", "Thunderbird 500", "Thunderbird X 350", 
						"Thunderbird X 500", "Electra 350", "Electra 500", "Model G", "Model J", 
						"Flying Flea", "Constellation", "Interceptor 750", "Meteor Minor", 
						"Cyclone", "Lightning 535", "Explorer", "Machismo", "Silver Plus", 
						"Mini Bullet", "Citybike", "Sherpa", "Crusader", "Crusader Sports", 
						"Clipper", "Super Meteor 700", "Meteor 700", "Interceptor Mark 1", 
						"Interceptor Mark 2", "Classic 500 Pegasus", "Bullet Trials Works Replica 500", 
						"Bullet Trials Works Replica 350", "Himalayan BS6"));
		
		motos.put("Qooder",
			    List.of(
			        "QV3", "QV4", "Oxygen", 
			        "e-Qooder", "XQooder", "Nuvion", 
			        "Urban", "City", "Adventure", 
			        "Hybrid", "Pro", "Sport", 
			        "Touring", "Cargo", "Utility", 
			        "Concept 1", "Concept 2", "Vision", 
			        "Future", "Smart", "Electric", 
			        "Urban EV", "City EV", "Adventure EV", 
			        "Cargo EV", "Utility EV"
			    )
			);
		
		motos.put("SYM",
				List.of("Jet 4", "Jet 4R", "Jet 14", "Jet 14 125", "Jet 14 150", "Jet 14 200", 
						"Symphony", "Symphony S", "Symphony SR", "Symphony ST", "Symphony Cargo", 
						"Cruisym 125", "Cruisym 150", "Cruisym 300", "Cruisym Alpha", "Maxsym 400", 
						"Maxsym 500", "Maxsym TL 500", "Fiddle II", "Fiddle III", "Fiddle 125", 
						"Fiddle 150", "Orbit II", "Orbit III", "Orbit 125", "Orbit 150", "NH-T 125", 
						"NH-T 200", "NH-X 125", "NH-X 200", "Wolf 125", "Husky 125", "Magic 125", 
						"Crox 125", "Crox 150", "Tonik 50", "Tonik 125", "Attila 125", "Duke 125", 
						"VS 150", "Citycom 300i", "Citycom S 300i", "Joymax Z 300", "Joymax Z+", 
						"Joymax 125", "Joymax 250", "Joymax 300", "Joyride 125", "Joyride 200", 
						"Shark 125", "Shark 150", "Mask 125", "FNX 125", "Classic 125", "Bonus 110", 
						"Star 125", "Allo 50", "Allo 100", "Mio 50", "Mio 100", "Mio 115", 
						"Symba 100", "Orbit 50", "Jet 50", "Jet 100", "Jet SportX", "Jet SportX EVO", 
						"Maxsym 600i", "QuadRaider 600", "QuadRaider 700"));
		
		motos.put("UM Motorcycles",
				List.of("Renegade Commando", "Renegade Commando Classic", "Renegade Sport S", "Renegade Mojave", 
						"Renegade Duty", "Renegade Duty Ace", "Renegade Vegas", "Renegade Freedom", 
						"Renegade Commando Black Cat", "Renegade Thor", "Renegade Commando Classic 300", 
						"Renegade Sport S 300", "Hypersport", "Nitrox", "Dirt Bike 150", "Dirt Bike 200", 
						"Dirt Bike 250", "DSR 200", "DSR Adventure TT", "Xtreet 125", "Xtreet 150", 
						"Xtreet R", "Xtreet RS", "Max 125", "Max 150", "Nitrox 125", "Nitrox 150", 
						"Hypersport 125", "Hypersport 200", "Hypersport 250", "Xplorer 150", "Xplorer 250", 
						"Xplorer 300", "Xplorer 400", "Renegade Commando 125", "Renegade Sport S 125", 
						"Renegade Classic 125", "Renegade Vegas 125"));
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
