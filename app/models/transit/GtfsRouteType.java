package models.transit;

import com.conveyal.gtfs.model.Entity;

public enum GtfsRouteType {
	TRAM,
	SUBWAY,
	RAIL, 
	BUS, 
	FERRY,
	CABLECAR,
	GONDOLA,
	FUNICULAR,
	TAXI,
	AIRPLANE,
	CAR;
	
	public int toGtfs() {
		switch(this)
		{
			case TRAM:
				return 0;
			case SUBWAY:
				return 1;
			case RAIL:
				return 2;
			case BUS:
				return 3;
			case FERRY:
				return 4;
			case CABLECAR:
				return 5;
			case GONDOLA:
				return 6;
			case FUNICULAR:
				return 7;
			default:
				// can't happen
				return Entity.INT_MISSING;
	
		}
	}
	
	public static GtfsRouteType fromGtfs (int gtfsType) {

		if (gtfsType >= 100 && gtfsType < 200){ // Railway Service
			return RAIL;
		} else if (gtfsType >= 200 && gtfsType < 300){ //Coach Service
			return BUS;
		} else if (gtfsType >= 300 && gtfsType < 500){ //Suburban Railway Service and Urban Railway service
			if (gtfsType >= 401 && gtfsType <= 402) {
				return SUBWAY;
			}
			return RAIL;
		} else if (gtfsType >= 500 && gtfsType < 700){ //Metro Service and Underground Service
			return SUBWAY;
		} else if (gtfsType >= 700 && gtfsType < 900){ //Bus Service and Trolleybus service
			return BUS;
		} else if (gtfsType >= 900 && gtfsType < 1000){ //Tram service
			return TRAM;
		} else if (gtfsType >= 1000 && gtfsType < 1100){ //Water Transport Service
			return FERRY;
		} else if (gtfsType >= 1100 && gtfsType < 1200){ //Air Service
			return AIRPLANE;
		} else if (gtfsType >= 1200 && gtfsType < 1300){ //Ferry Service
			return FERRY;
		} else if (gtfsType >= 1300 && gtfsType < 1400){ //Telecabin Service
			return GONDOLA;
		} else if (gtfsType >= 1400 && gtfsType < 1500){ //Funicalar Service
			return FUNICULAR;
		} else if (gtfsType >= 1500 && gtfsType < 1600){ //Taxi Service
			return TAXI;
		} else if (gtfsType >= 1600 && gtfsType < 1700){ //Self drive
			return CAR;
		}

		switch (gtfsType)
		{
		case 0:
			return TRAM;
		case 1:
			return SUBWAY;
		case 2:
			return RAIL;
		case 3:
			return BUS;
		case 4:
			return FERRY;
		case 5:
			return CABLECAR;
		case 6:
			return GONDOLA;
		case 7:
			return FUNICULAR;
		default:
			return null;
		}
	}
	
	public HvtRouteType toHvt () {
		switch (this) {
		case TRAM:
			return HvtRouteType.TRAM;
		case SUBWAY:
			return HvtRouteType.URBANRAIL_METRO;
		case RAIL:
			return HvtRouteType.RAIL;
		case BUS:
			// TODO overly specific
			return HvtRouteType.BUS_LOCAL;
		case FERRY:
			return HvtRouteType.WATER;
		case CABLECAR:
			return HvtRouteType.MISCELLANEOUS_CABLE_CAR;
		case GONDOLA:
			return HvtRouteType.MISCELLANEOUS;
		case FUNICULAR:
			return HvtRouteType.FUNICULAR;
		default:
			return null;
		}
	}
}