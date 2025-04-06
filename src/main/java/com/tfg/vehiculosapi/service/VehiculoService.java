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
				List.of("208", "308", "508", "2008", "3008", "5008", "Rifter", "Partner", "Expert", "Boxer", "208 GTi",
						"308 GTi", "RCZ", "3008 Hybrid", "5008 Hybrid", "607", "406", "407", "605", "Talbot Horizon"));

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

		coches.put("Mazda", List.of("2", "3", "6", "5", "MX-5", "CX-3", "CX-30", "CX-5", 
				"CX-7", "CX-9", "CX-60", "CX-70", "CX-80", "CX-90", "BT-50", "MX-30", 
				"RX-7", "RX-8", "121", "323", "626", "929", "Serie B Pickup", "Millenia", 
				"Allegro", "Cosmo"));

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

		coches.put("Cadillac",
				List.of("ATS", "CTS", "XTS", "STS", "DeVille", "Escalade", 
						"ELR", "CT6", "CT4", "CT5", "Seville", "Eldorado", 
						"Fleetwood", "Brougham", "SRX", "XT5", "XT4", "XT6", 
						"Lyriq", "V-Series", "Escalade ESV", "Escalade EXT", "V-16", 
						"Allante", "Cimarron", " Viera", "XLR", "Catera", "CTS-V", 
						"Escalade Hybrid", "CT6 Plug-in Hybrid", "ATS-V", "V8", "Series 62", 
						"Series 75", "LaSalle", "V-Series Blackwing", "Escalade IQ"));

		coches.put("Mustang", List.of("Ford Mustang", "Mach 1", "Shelby GT350", "Shelby GT500", "Bullitt", 
				"Cobra", "GT", "EcoBoost", "GT350", "Fastback", 
				"Convertible", "Mach-E", "II", "Boss 302", "Boss 429", 
				"GT500KR", "GT500", "Shelby GT500KR", "Special Edition", 
				"Roush", "California Special"));

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

		coches.put("BYD", List.of("Tang EV", "Song EV", "Qin EV", "Yuan EV", "e6", "T3", "F3DM", "S6", "E6 Plus",
				"Han EV", "Atto 3", "Dolphin", "Seagull"));

		coches.put("NIO", List.of("ES8", "ES6", "EC6", "ET7", "ET5", "ES7", "ET7 Electric", 
				"EC6 Electric", "ES8 Electric", "ES6 Electric", "ET5 Electric", "ET7 AWD", 
				"ET5 AWD", "Power Swap Station", "EVE Concept", "NioPilot"));

		coches.put("XPeng", List.of("XPeng G3", "XPeng P7", "XPeng P5", "XPeng G3i", "XPeng Xmart OS", "XPeng P7 Electric", "XPeng G3 Electric", 
				"XPeng P5 Electric", "XPeng G3i Electric", "XPeng P7 Wing", "XPeng Xpeng City"));

		coches.put("Li Auto", List.of("Li Auto Li ONE", "Li Auto Li L7", "Li Auto Li L9", "Li Auto Li X", "Li Auto L9 Electric", 
				"Li Auto Li ONE Electric", "Li Auto Li L7 Electric"));

		coches.put("Geely",
				List.of("Emgrand", "Boyue", "Atlas", "EC7", "GC9", "Geometro", "Xingyue", "Emgrand EV", 
						"Geometry A", "Geometry C", "Geometry E", "Icon", "Geometry G6", "GE11", "Yuan Pro", 
						"Hao Yue", "Emgrand GSe", "G5", "GX7", "Geometry A Pro", "Panda Mini EV"));

		coches.put("BYTON", List.of("M-Byte", "K-Byte", "C-Byte", "E-Byte", "S-Byte", "SUV", 
				"Concept", "M-Byte Electric", "K-Byte Electric"));

		coches.put("Great Wall Motors",
				List.of("ORA Good Cat", "ORA Black Cat", "ORA Funky Cat", "HAVAL H9 EV", "HAVAL H6 EV"));

		coches.put("Wuling", List.of("Wuling Hongguang Mini EV", "Wuling Baojun E100", "Wuling E200"));

		coches.put("SAIC Motor", List.of("MG ZS EV", "MG Marvel R", "MG4 Electric", "Roewe Ei5", "Roewe RX5 EV"));

		coches.put("Tianjin FAW Xiali", List.of("Tianjin FAW Xiali 1010", "Tianjin FAW Xiali 1041", "Tianjin FAW Xiali 1061", 
				"Tianjin FAW Xiali 1081", "Tianjin FAW Xiali 1091", "Tianjin FAW Xiali T173", 
				"Tianjin FAW Xiali Xiali 2000", "Tianjin FAW Xiali Xiali 3000", "Tianjin FAW Xiali Xiali A11", 
				"Tianjin FAW Xiali Xiali A21", "Tianjin FAW Xiali Xiali A22", "Tianjin FAW Xiali Xiali E30", 
				"Tianjin FAW Xiali E50", "Tianjin FAW Xiali E60", "Tianjin FAW Xiali E80", "Tianjin FAW Xiali E90", 
				"Tianjin FAW Xiali V5", "Tianjin FAW Xiali V6", "Tianjin FAW Xiali V7", "Tianjin FAW Xiali V8", 
				"Tianjin FAW Xiali S11", "Tianjin FAW Xiali S12", "Tianjin FAW Xiali M7", "Tianjin FAW Xiali M8", 
				"Tianjin FAW Xiali Jetta", "Tianjin FAW Xiali T71", "Tianjin FAW Xiali T81", "Tianjin FAW Xiali T91", 
				"Tianjin FAW Xiali XEV", "Tianjin FAW Xiali T6", "Tianjin FAW Xiali T8", "Tianjin FAW Xiali E70", 
				"Tianjin FAW Xiali X6"));

		
		// Declaro todas las marcas de motos junto con sus modelos
		motos.put("Zontes", List.of("G1-125", "G1-125 X", "U1-125", "GK125", "R310", "T310", "X310", "GK350", "Z2-350",
				"Z3-350", "Z4-350", "V310", "M310", "E125", "C125", "E350", "Mantis 125", "Scrambler 125"));
		
		motos.put("CFMOTO", List.of("125NK", "300NK", "300SR", "650NK", "650MT", "650GT", "700CL-X Heritage",
				"700CL-X Sport", "700CL-X Adventure", "800MT", "Papio 125", "300GT-E", "300CL-X"));
		
		motos.put("QJ Motor", List.of("SRK 125", "SRV 125", "SRK 250", "SRV 250", "SRK 350", "SRV 350", "SRT 500",
				"SRK 500", "SRV 500", "SRT 700", "SRK 700", "SRV 700", "SRK 1000", "SRV 1000", "SRT 1000"));
		
		motos.put("Voge",
				List.of("300R", "300AC", "300ACX", "300DS", "300GY", 
						"350AC", "500R", "500DS", "500AC", "500ACX", 
						"525R", "525DSX", "650DS", "650DSX", 
						"900DS", "900DSX", "SR1 ADV", "SR4 Max", 
						"CU 525", "CU 300", "CU 125"));
		
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
						"Liberty 125", "Liberty 150", "Liberty 200", "Piaggio Beverly 125", 
						"Piaggio Beverly 300", "Piaggio Beverly 350", "Piaggio MP3 250", 
						"Piaggio MP3 300", "Piaggio MP3 500", "Piaggio Zip 50", "Piaggio Zip 100", 
						"Piaggio Fly 50", "Piaggio Fly 125", "Piaggio Fly 150", "Piaggio Medley 125", 
						"Piaggio Medley 150", "Piaggio Medley 300", "Piaggio X10 125", "Piaggio X10 350", 
						"Piaggio X10 500", "Piaggio BV350", "Piaggio BV500", "Piaggio Typhoon 50", 
						"Piaggio Typhoon 125", "Piaggio Typhoon 150", "Piaggio Liberty S 50", "Piaggio Liberty S 125", 
						"Piaggio Zip S 50", "Piaggio Zip S 100", "Piaggio TPH 50", "Piaggio TPH 125", 
						"Piaggio Beverly SportTouring 300", "Piaggio Beverly 400", "Piaggio MP3 Yourban 300", 
						"Piaggio MP3 Yourban 500", "Piaggio Biker 125", "Piaggio Fly 150 CC", "Piaggio Ape 50"));
		
		motos.put("Peugeot",
				List.of("Peugeot Django 50", "Peugeot Django 125", "Peugeot Django 150", "Peugeot Tweet 50", 
						"Peugeot Tweet 100", "Peugeot Tweet 125", "Peugeot Citystar 50", "Peugeot Citystar 125", 
						"Peugeot Citystar 200", "Peugeot Speedfight 50", "Peugeot Speedfight 100", "Peugeot Speedfight 125", 
						"Peugeot Ludix 50", "Peugeot Ludix 100", "Peugeot Ludix 125", "Peugeot Vivacity 50", 
						"Peugeot Vivacity 100", "Peugeot Vivacity 125", "Peugeot Satelis 125", "Peugeot Satelis 300", 
						"Peugeot Metropolis 400", "Peugeot Metropolis 500", "Peugeot Kisbee 50", "Peugeot Kisbee 100", 
						"Peugeot Kisbee 125", "Peugeot Tweet 50 4T", "Peugeot Traveller 50", "Peugeot Traveller 100", 
						"Peugeot Traveller 125", "Peugeot Pulsion 125", "Peugeot Pulsion 300", "Peugeot Belville 125", 
						"Peugeot Belville 200", "Peugeot XR7", "Peugeot XR8", "Peugeot RCX 50", "Peugeot RCX 100", 
						"Peugeot RCX 125"));
		
		motos.put("Montesa",
				List.of("Cota 4RT", "Cota 301RR", "Cota 300RR", "Cota 260", "Cota 125", 
						"Cota 4RT 260", "Cota 300", "Cota 200", "Cota 349", "Cota 348", 
						"Cota 247", "Cota 247RR", "Cota 247 Mk1", "Cota 247 Mk2", "Cota 247 Mk3", 
						"Cota 315R", "Cota 315", "Cota 350", "Cota 350RR", "Cota 280", 
						"Cota 280RR", "Cota 175", "Cota 125RR", "Montesa 4RT 260", "Montesa 4RT 300", 
						"Cota 4RT 125", "Montesa 315R", "Montesa 350", "Montesa 280", 
						"Cota 300RR 4RT", "Cota 301RR 4RT", "Montesa 4RT Racing", "Montesa Cota 360", 
						"Montesa Cota 247", "Montesa Cota 248", "Montesa 360", "Montesa 123", 
						"Montesa 350 V1", "Montesa 350 V2"));
		
		motos.put("MITT",
				List.of("MITT 125 GPR", "MITT 125 RR", "MITT 125 GP", "MITT 125 X", "MITT 125 Scrambler", 
						"MITT 125 Cafe Racer", "MITT 125 Cruiser", "MITT 150 GPR", "MITT 150 RR", 
						"MITT 150 X", "MITT 150 GP", "MITT 300 GPR", "MITT 300 RR", "MITT 300 X", 
						"MITT 300 GP", "MITT 500 GPR", "MITT 500 RR", "MITT 500 X", "MITT 500 GP", 
						"MITT 650 X", "MITT 650 GP", "MITT 650 RR", "MITT 650 Scrambler", 
						"MITT 650 Cruiser", "MITT 500 Cafe Racer", "MITT 125 Enduro", "MITT 250 Enduro", 
						"MITT 500 Enduro", "MITT 125 Street Fighter", "MITT 150 Street Fighter", 
						"MITT 300 Street Fighter", "MITT 500 Street Fighter"));
		
		motos.put("Mondial",
				List.of("Mondial 50", "Mondial 125", "Mondial 200", "Mondial HPS 125", "Mondial HPS 300", 
						"Mondial HPS 500", "Mondial SMX 125", "Mondial SMX 250", "Mondial SMX 500", 
						"Mondial Sport 50", "Mondial Sport 125", "Mondial Cafe Racer 125", "Mondial Café Racer 250", 
						"Mondial Pagani 125", "Mondial Pagani 200", "Mondial Pagani 300", "Mondial Torpedo 125", 
						"Mondial Torpedo 150", "Mondial V2 125", "Mondial V2 250", "Mondial V2 300", 
						"Mondial V2 500", "Mondial CR 125", "Mondial CR 250", "Mondial CR 500", 
						"Mondial 125 Sport", "Mondial 250 Sport", "Mondial 500 Sport", "Mondial V2 Sport", 
						"Mondial 50 E5", "Mondial 125 E5", "Mondial 250 E5", "Mondial 300 E5"));
		
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
				List.of("Macbor 50", "Macbor 125", "Macbor 250", "Macbor 500", "Macbor X-Ride 125", 
						"Macbor X-Ride 250", "Macbor X-Ride 500", "Macbor Scrambler 125", "Macbor Scrambler 250", 
						"Macbor Scrambler 500", "Macbor Cafe Racer 125", "Macbor Cafe Racer 250", 
						"Macbor Cafe Racer 500", "Macbor Roadster 125", "Macbor Roadster 250", "Macbor Roadster 500", 
						"Macbor Enduro 125", "Macbor Enduro 250", "Macbor Enduro 500", "Macbor Adventure 125", 
						"Macbor Adventure 250", "Macbor Adventure 500", "Macbor Trail 125", "Macbor Trail 250", 
						"Macbor Trail 500", "Macbor Custom 125", "Macbor Custom 250", "Macbor Custom 500", 
						"Macbor Urban 125", "Macbor Urban 250", "Macbor Urban 500", "Macbor X-Trail 250", 
						"Macbor X-Trail 500", "Macbor Supermoto 125", "Macbor Supermoto 250", "Macbor Supermoto 500"));
		
		motos.put("MH",
				List.of("MH 50", "MH 125", "MH 250", "MH 125 Enduro", "MH 125 Sport", "MH 125 Cafe Racer", 
						"MH 125 Scrambler", "MH 250 Enduro", "MH 250 Sport", "MH 250 Scrambler", 
						"MH 400", "MH 650", "MH 125 R", "MH 250 R", "MH 125 X", "MH 250 X", 
						"MH 250 C", "MH 125 C", "MH 500", "MH 150", "MH 300", "MH 650 Cafe Racer", 
						"MH 250 Cafe Racer", "MH 125 Cruiser", "MH 250 Cruiser", "MH Supermotard 125", 
						"MH Supermotard 250", "MH Scrambler 125", "MH Scrambler 250", "MH Enduro 125", 
						"MH Enduro 250", "MH Enduro 500"));
		
		motos.put("Mash",
				List.of("Mash Seventy 50", "Mash Seventy 125", "Mash Seventy 250", "Mash Dirt 50", 
						"Mash Dirt 125", "Mash Dirt 250", "Mash Five Hundred", "Mash Scrambler 50", 
						"Mash Scrambler 125", "Mash Scrambler 250", "Mash Roadstar 125", "Mash Roadstar 250", 
						"Mash Cafe Racer 125", "Mash Cafe Racer 250", "Mash X-Ride 125", "Mash X-Ride 250", 
						"Mash Black Seven 125", "Mash Black Seven 250", "Mash Brat 125", "Mash Brat 250", 
						"Mash Heritage 125", "Mash Heritage 250", "Mash TT40 125", "Mash TT40 250", 
						"Mash Spirit 125", "Mash Spirit 250", "Mash Seventy 125 Limited Edition", 
						"Mash Seventy 250 Limited Edition", "Mash 400", "Mash 650", "Mash 125 Enduro", 
						"Mash 250 Enduro", "Mash 400 Scrambler", "Mash 650 Scrambler"));
		
		motos.put("Lambretta",
				List.of("M", "A", "B", "C", "D", "LD", "E", "F", "J", "J50", "Li 125", "Li 150", "Li 175", 
						"Li Special", "TV 175", "TV 200", "GP 125", "GP 150", "GP 200", "SX 150", "SX 200", 
						"V50", "V125", "V200", "G325", "G350", "LN 125", "LN 150", "LN 151", "Pato", 
						"Centomila", "Serveta Li 150", "Serveta Jet 200", "Grand Prix", "Super Star", 
						"Special 125", "Special 150", "Special 200", "V-Special 50", "V-Special 125", 
						"V-Special 200", "X300", "G-Special 300"));
		
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
				List.of("Crossfire 125", "Crossfire 125 XS", "Crossfire 250", "Crossfire 500", "Crossfire 500 X", 
						"Crossfire 500 XC", "Cromwell 125", "Cromwell 250", "Cromwell 500", 
						"Felsberg 125", "Felsberg 250", "Felsberg 500", "Rayburn 125", 
						"Sunray 125", "BX 125", "BX 125 R", "BX 125 X", "Glanville 250 X"));
		
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
				List.of("Qooder", "Qooder QV3", "Qooder QV4", "Qooder Qooder", "Qooder Oxygen", 
						"Qooder e-Qooder", "Qooder XQooder", "Qooder Nuvion"));
		
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
