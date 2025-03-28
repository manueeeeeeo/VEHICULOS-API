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