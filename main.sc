// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// ****************************************Main Script**************************************
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
  
SCRIPT_NAME Main

VAR_FLOAT one_sixteenth one_thirtysecond one_sixtyfourth

one_sixteenth = 0.0625 

one_thirtysecond = one_sixteenth / 2.0

one_sixtyfourth =  one_thirtysecond / 2.0

VAR_INT mission_trigger_wait_time

mission_trigger_wait_time = 250

// ***************************************Frankie 3 Warp Stuff******************************
// ******************************************DO NOT REMOVE!*********************************
VAR_INT flag_taken_money_off_fm3

flag_taken_money_off_fm3 = 0

// ********************************************Help Message*********************************
// ********************************************DO NOT REMOVE********************************

VAR_INT flag_player_had_gun_message

flag_player_had_gun_message = 0

// *********************************8Ball/Luigi Girls Warp Stuff****************************
// ***************************************DO NOT REMOVE*************************************
VAR_INT flag_reached_hideout

flag_reached_hideout = 0

VAR_INT flag_had_luigi_help_message

flag_had_luigi_help_message = 0

// *************************************LOCATE BLOB VARIABLE STUFF**************************
// ********************************************DO NOT REMOVE********************************

VAR_INT blob_flag

blob_flag = 0

// zero = false no blob displayed
// one = true blob is displayed
// before the loop set this flag to the way you want it displayed or nothing will happen

// *********************************TOTAL NUMBER OF MISSIONS********************************
// *****************************************************************************************

SET_TOTAL_NUMBER_OF_MISSIONS 73
SET_PROGRESS_TOTAL 0

// ********************************Player name for Cut-scene stuff**************************

VAR_INT script_controlled_player

VAR_INT controlmode //Control Config variable

// ********************************CREATE INDUSTRIAL OBJECTS********************************

VAR_INT backdoor playersdoor  //luigi_club_door
VAR_INT dogfood_factory_gate, doggy_door
VAR_INT misty_door1, misty_door2
VAR_INT explosive_drum1, explosive_drum2
VAR_INT laundrete_door1, laundrete_door2
VAR_INT fish_factory_gate 
VAR_INT Bank_job_door bankdoor1 bankdoor2
VAR_INT fuzz_door1, fuzz_door2
VAR_INT	joeys_garage_door2, joeys_garage_door3
VAR_INT target1 target2 target3
VAR_INT subway_gate_industrial tunnel_gate_industrial
VAR_INT bridge_is_damaged 
VAR_INT subway_gate_suburban1, subway_gate_suburban2, tunnel_gate_suburban

VAR_FLOAT joeydoor2_X joeydoor2_Y joeydoor2_Z joeydoor3_X joeydoor3_Y joeydoor3_Z 

CREATE_OBJECT_NO_OFFSET playersdoor 890.883 -307.74 8.75 playersdoor
DONT_REMOVE_OBJECT playersdoor

CREATE_OBJECT_NO_OFFSET faketarget 1078.7 -384.8 15.4 target1
DONT_REMOVE_OBJECT target1

CREATE_OBJECT_NO_OFFSET faketarget 1080.5 -384.8 15.4 target2
DONT_REMOVE_OBJECT target2

CREATE_OBJECT_NO_OFFSET faketarget 1082.3 -384.8 15.4 target3
DONT_REMOVE_OBJECT target3

CREATE_OBJECT_NO_OFFSET Mistydoor 945.68 -272.31 4.854 misty_door1
DONT_REMOVE_OBJECT misty_door1
CREATE_OBJECT_NO_OFFSET Mistydoor 942.746 -273.712 4.854 misty_door2
DONT_REMOVE_OBJECT misty_door2
SET_OBJECT_HEADING misty_door2 180.0

CREATE_OBJECT_NO_OFFSET laundrtdoor1 845.773 -662.80 15.07 laundrete_door1
DONT_REMOVE_OBJECT laundrete_door1
CREATE_OBJECT_NO_OFFSET laundrtdoor1 845.773 -664.824 15.07 laundrete_door2
DONT_REMOVE_OBJECT laundrete_door2
SET_OBJECT_HEADING laundrete_door2 180.0

CREATE_OBJECT_NO_OFFSET joey_door1 1192.23 -867.252 14.124 joeys_garage_door2 //The moving one
DONT_REMOVE_OBJECT joeys_garage_door2
SET_OBJECT_HEADING joeys_garage_door2 45.0

CREATE_OBJECT_NO_OFFSET joey_door2 1190.12 -869.339 14.19 joeys_garage_door3
DONT_REMOVE_OBJECT joeys_garage_door3
SET_OBJECT_HEADING joeys_garage_door3 45.0

CREATE_OBJECT_NO_OFFSET electricgate 1250.4 -812.0 13.97 dogfood_factory_gate
DONT_REMOVE_OBJECT dogfood_factory_gate
SET_OBJECT_HEADING dogfood_factory_gate 225.0

CREATE_OBJECT_NO_OFFSET dogfoodoor01 1205.298 -802.908  15.0 doggy_door
DONT_REMOVE_OBJECT doggy_door 
SET_OBJECT_HEADING doggy_door 45.0

CREATE_OBJECT_NO_OFFSET electricgate 1016.0 -1107.955 12.294 fish_factory_gate
DONT_REMOVE_OBJECT fish_factory_gate
SET_OBJECT_HEADING fish_factory_gate 90.0

CREATE_OBJECT_NO_OFFSET bankjobdoor 1087.523 -233.801 11.012 Bank_job_door
DONT_REMOVE_OBJECT Bank_job_door

CREATE_OBJECT_NO_OFFSET chnabankdoor 1035.6 -700.793 15.334 bankdoor1	//chnabankdoor 1035.479 -700.743 15.334
DONT_REMOVE_OBJECT bankdoor1

CREATE_OBJECT_NO_OFFSET chnabankdoor 1035.6 -699.408 15.334 bankdoor2	//chnabankdoor
DONT_REMOVE_OBJECT bankdoor2
SET_OBJECT_HEADING bankdoor2 180.0

CREATE_OBJECT_NO_OFFSET backdoor 891.056 -416.4373 14.955 backdoor
DONT_REMOVE_OBJECT backdoor		 

CREATE_OBJECT_NO_OFFSET fuzballdoor 1001.673 -887.855 15.775 fuzz_door1
SET_OBJECT_HEADING fuzz_door1 180.0
DONT_REMOVE_OBJECT fuzz_door1

CREATE_OBJECT_NO_OFFSET fuzballdoor 998.33 -887.94 15.775 fuzz_door2
SET_OBJECT_HEADING fuzz_door2 0.0
DONT_REMOVE_OBJECT fuzz_door2 

CREATE_OBJECT_NO_OFFSET subwaygate 988.963 -471.778 5.2 subway_gate_industrial
DONT_REMOVE_OBJECT subway_gate_industrial
SET_OBJECT_HEADING subway_gate_industrial 90.0   

CREATE_OBJECT_NO_OFFSET tunnelentrance 730.331 172.467 -21.075 tunnel_gate_industrial
DONT_REMOVE_OBJECT tunnel_gate_industrial

// ********************************CREATE COMMERCIAL OBJECTS********************************

VAR_INT plysav_lftdr_lft, plysav_lftdr_rght
VAR_INT police_door_one, police_door_two
VAR_INT colombian_gate, helix_barrier
VAR_INT phils_compnd_gate flag_player_on_phil_mission
VAR_INT inside_fence outside_fence
																  
CREATE_OBJECT_NO_OFFSET helix_barrier -73.137 -630.333 25.932 helix_barrier
DONT_REMOVE_OBJECT helix_barrier

CREATE_OBJECT_NO_OFFSET plysav_lftdr_lft 103.85 -482.8 16.25 plysav_lftdr_lft
DONT_REMOVE_OBJECT plysav_lftdr_lft

CREATE_OBJECT_NO_OFFSET plysav_lftdr_rght 102.192 -482.8 16.25 plysav_lftdr_rght
DONT_REMOVE_OBJECT plysav_lftdr_rght
SET_OBJECT_HEADING plysav_lftdr_rght 180.0

CREATE_OBJECT_NO_OFFSET electricgate 366.158 -1128.522 21.941 police_door_one
DONT_REMOVE_OBJECT police_door_one
SET_OBJECT_HEADING police_door_one 180.0

CREATE_OBJECT_NO_OFFSET electricgate 326.3 -1128.522 21.941 police_door_two
DONT_REMOVE_OBJECT police_door_two
SET_OBJECT_HEADING police_door_two 180.0
										
CREATE_OBJECT_NO_OFFSET electricgate 91.589 -318.592 15.296 colombian_gate
DONT_REMOVE_OBJECT colombian_gate
SET_OBJECT_HEADING colombian_gate 270.0

CREATE_OBJECT_NO_OFFSET electricgate 147.249 207.323 10.599 phils_compnd_gate
DONT_REMOVE_OBJECT phils_compnd_gate
SET_OBJECT_HEADING phils_compnd_gate 270.0

CREATE_OBJECT_NO_OFFSET fixed_inside 362.827 -341.883 17.186 inside_fence
DONT_REMOVE_OBJECT inside_fence

CREATE_OBJECT_NO_OFFSET fixed_outside 360.852 -391.405 22.622 outside_fence
DONT_REMOVE_OBJECT outside_fence

// ********************************CREATE SUBURBAN OBJECTS*********************************

VAR_INT newtowerdoor1 Columbian_gate2
VAR_INT airportdoor1 airportdoor2

CREATE_OBJECT_NO_OFFSET	newtowerdoor1 -664.313 2.883 19.51 newtowerdoor1
DONT_REMOVE_OBJECT newtowerdoor1
SET_OBJECT_HEADING newtowerdoor1 180.0

CREATE_OBJECT_NO_OFFSET Columbiangate -363.05 250.455 61.355 Columbian_gate2
DONT_REMOVE_OBJECT Columbian_gate2
SET_OBJECT_HEADING Columbian_gate2 180.0

CREATE_OBJECT_NO_OFFSET airportdoor1 -770.414 -599.292 11.847 airportdoor1
DONT_REMOVE_OBJECT airportdoor1

CREATE_OBJECT_NO_OFFSET airportdoor2 -770.414 -601.369 11.846 airportdoor2
DONT_REMOVE_OBJECT airportdoor2

// ******************************************Police Levels**********************************

SET_MAX_WANTED_LEVEL 4

// **************************************Industrial Garages*********************************

VAR_INT save_cars1, bombshop1, sprayshop1, collect_all_cars1, special_garage1, hours minutes
VAR_INT frankie_garage, Garage_bank, garage_lm2

SET_GARAGE 891.3 -311.1 7.7 898.4 -315.5 12.7 GARAGE_HIDEOUT_INDUSTRIAL save_cars1 //Saves current car to memory  

SET_GARAGE 1496.8 -686.2 11.0 1523.3 -666.8 17.0 GARAGE_COLLECTCARS_1 collect_all_cars1 //Inport/Export garage industrial
NO_SPECIAL_CAMERA_FOR_THIS_GARAGE collect_all_cars1

SET_GARAGE 1284.6 -100.5 13.6 1278.0 -111.0 18.6 GARAGE_BOMBSHOP2 bombshop1 //bomb shop - once armed waits for ped to enter car before detonation

SET_GARAGE 921.0 -367.5 9.8 928.7 -355.1 14.8 GARAGE_RESPRAY sprayshop1 //spray/repair shop    

SET_GARAGE 1428.8 -187.0 49.7 1442.5 -179.9 54.7 GARAGE_MISSION_KEEPCAR_REMAINCLOSED frankie_garage //Toni 3 and Frankie 1   
SET_ROTATING_GARAGE_DOOR frankie_garage

SET_GARAGE 1440.7 -805.6 10.9 1449.8 -782.1 15.9 GARAGE_MISSION Garage_bank //Joey 3 

SET_GARAGE 1074.0 -578.0 13.0 1085.0 -568.0 17.0 GARAGE_MISSION garage_lm2 //Luigi 2

// **************************************Commercial Garages*********************************

VAR_INT save_cars2, bombshop2, sprayshop2, garage_yd3, garage1_love1, garage2_love1, garage3_love1, garage4_love1, garage5_love1
VAR_INT garage_km2, rays_prize_garage, witsec_garage, loves_garage
VAR_FLOAT garage_min_x_yd3,	garage_min_y_yd3, garage_max_x_yd3, garage_max_y_yd3
garage_min_x_yd3 = 257.0   
garage_min_y_yd3 = -803.0
garage_max_x_yd3 = 263.0
garage_max_y_yd3 = -795.5

SET_GARAGE 115.1 -475.3 15.0 106.9 -487.1 19.0 GARAGE_HIDEOUT_COMMERCIAL save_cars2 //Saves current cars to memory

SET_GARAGE 386.0 -573.0 25.2 376.6 -580.1 30.2 GARAGE_BOMBSHOP1 bombshop2 // bomb shop - once armed waits 5 seconds then detonates

SET_GARAGE 386.0 -490.0 25.2 376.6 -497.0 30.2 GARAGE_RESPRAY sprayshop2 // Spray shop 

SET_GARAGE 245.4 -992.2 20.0 234.4 -1000.5 24.0 GARAGE_FOR_SCRIPT_TO_OPEN_AND_CLOSE rays_prize_garage //RAY 6 - MARKED MAN (BY SPRAYSHOP)
SET_ROTATING_GARAGE_DOOR rays_prize_garage
  
SET_GARAGE 375.0 -441.5 20.0837 386.0 -434.0 25.0837 GARAGE_FORCARTOCOMEOUTOF witsec_garage //RAY 1 - SILENCE THE SNEAK (BEHIND CARPARK)

SET_GARAGE 377.3 -511.4 25.1132 383.7 -502.0 30.0 GARAGE_MISSION garage_km2 //Kenji 2 

SET_GARAGE 63.8 -307.9 15.2 70.0 -316.7 19.2 GARAGE_FOR_SCRIPT_TO_OPEN_AND_CLOSE garage1_love1 //Love 1
SET_GARAGE 53.0 -308.0 15.2 60.0 -316.7 19.2 GARAGE_FOR_SCRIPT_TO_OPEN_AND_CLOSE garage2_love1 //Love 1
SET_GARAGE 24.9 -344.0 15.2 30.6 -337.1 19.2 GARAGE_FOR_SCRIPT_TO_OPEN_AND_CLOSE garage3_love1 //Love 1
SET_GARAGE 24.5 -355.0 15.2 30.6 -346.0 19.2 GARAGE_FOR_SCRIPT_TO_OPEN_AND_CLOSE garage4_love1 //Love 1
SET_GARAGE 52.5 -388.0 15.2 42.0 -374.1 19.2 GARAGE_FOR_SCRIPT_TO_OPEN_AND_CLOSE garage5_love1 //Love 1
 
SET_GARAGE garage_min_x_yd3 garage_min_y_yd3 26.8 garage_max_x_yd3 garage_max_y_yd3 31.8 GARAGE_MISSION garage_yd3 //Yardie 3


// ****************************************Suburban Garages*********************************

VAR_INT save_cars3, bombshop3, garage_hm3, garage_hm4, escort_garage, collect_all_cars2, sprayshop3 

SET_GARAGE -662.5 -47.4 17.0 -670.7 -30.0 22.0 GARAGE_HIDEOUT_SUBURBAN save_cars3 //Saves current car to memory
SET_ROTATING_GARAGE_DOOR save_cars3
NO_SPECIAL_CAMERA_FOR_THIS_GARAGE save_cars3

SET_GARAGE -1139.0 37.8 55.0 -1148.5 32.1 65.0 GARAGE_RESPRAY sprayshop3 // Spray shop

SET_GARAGE -1078.9 58.0 56.0 -1086.0 49.0 65.0 GARAGE_BOMBSHOP3 bombshop3 // bomb shop - detonator

SET_GARAGE -1117.5 150.9 55.0 -1097.7 121.2 65.0 GARAGE_COLLECTCARS_2 collect_all_cars2 //Inport/Export garage industrial
NO_SPECIAL_CAMERA_FOR_THIS_GARAGE collect_all_cars2

SET_GARAGE 1346.9 -315.5 49.0 1352.5 -310.7 53.0 GARAGE_MISSION_KEEPCAR garage_hm3 //Hoods 3

SET_GARAGE -824.7 -165.5 32.8 -843.5 -171.7 37.0 GARAGE_KEEPS_OPENING_FOR_SPECIFIC_CAR garage_hm4 //Hoods 4

SET_GARAGE -1049.17 -77.47 37.8 -1037.21 -69.17 42.8 GARAGE_FOR_SCRIPT_TO_OPEN_AND_CLOSE escort_garage //LOVE 5 - ESCORT SERVICE (WAREHOUSE)
SET_ROTATING_GARAGE_DOOR escort_garage

// ************************************Industrial Crane Positions***************************

ACTIVATE_MILITARY_CRANE 1570.3 -675.4 1565.7 -686.5 1576.8 -706.6 1639.9 -696.7 26.0 0.0 //Docks crane for the Police cars onto boat height for area 10.8

ACTIVATE_CRUSHER_CRANE 1119.8 51.8 1135.8 56.1 1149.8 46.3 1143.0 59.9 5.0 180.0 //Crusher crane 1135.8 56.1 -1.0 1149.8 46.3 7.0
					   			   
// ****************************************Restart Zones************************************

// **************************************GLOBAL ZONES*****************************************

 	SETUP_ZONE_PED_INFO CITYZON DAY   (12) 0 0 0 0 0 0 0 20   
    SETUP_ZONE_PED_INFO CITYZON NIGHT ( 8) 0 0 0 0 0 0 0 10 
    SETUP_ZONE_CAR_INFO CITYZON DAY   (10) 0 0 0 0 0 0 0 20 240 240 240 240 0 0
    SETUP_ZONE_CAR_INFO CITYZON NIGHT ( 8) 0 0 0 0 0 0 0 10 240 240 240 240 0 0
	SET_ZONE_GROUP CITYZON DAY DEFAULT_PEDGRP
	SET_ZONE_GROUP CITYZON NIGHT DEFAULT_PEDGRP

    SETUP_ZONE_PED_INFO IND_ZON DAY   (12) 0 0 0 0 0 0 0 20    
    SETUP_ZONE_PED_INFO IND_ZON NIGHT ( 8) 0 0 0 0 0 0 0 10
    SETUP_ZONE_CAR_INFO IND_ZON DAY   (10) 0 0 0 0 0 0 0 20 500 0 0 450 0 0
    SETUP_ZONE_CAR_INFO IND_ZON NIGHT ( 8) 0 0 0 0 0 0 0 10 500 0 0 450 0 0
	SET_ZONE_GROUP IND_ZON DAY INDUSTRIAL_PEDGRP
	SET_ZONE_GROUP IND_ZON NIGHT INDUSTRIAL_NIGHT_PEDGRP

    SETUP_ZONE_PED_INFO COM_ZON DAY   (12) 0 0 0 0 0 0 0 20  
    SETUP_ZONE_PED_INFO COM_ZON NIGHT ( 8) 0 0 0 0 0 0 0 10
    SETUP_ZONE_CAR_INFO COM_ZON DAY   (10) 0 0 0 0 0 0 0 20 0 300 450 150 0 0
    SETUP_ZONE_CAR_INFO COM_ZON NIGHT ( 8) 0 0 0 0 0 0 0 10 0 300 450 150 0	0
	SET_ZONE_GROUP COM_ZON DAY DEFAULT_PEDGRP
	SET_ZONE_GROUP COM_ZON NIGHT DEFAULT_PEDGRP

    SETUP_ZONE_PED_INFO SUB_ZON DAY   (12) 0 0 0 0 0 0 0 20 
    SETUP_ZONE_PED_INFO SUB_ZON NIGHT ( 8) 0 0 0 0 0 0 0 10
    SETUP_ZONE_CAR_INFO SUB_ZON DAY   (10) 0 0 0 0 0 0 0 20 0 500 450 0 0 0   
    SETUP_ZONE_CAR_INFO SUB_ZON NIGHT ( 8) 0 0 0 0 0 0 0 10 0 500 450 0 0 0
	SET_ZONE_GROUP SUB_ZON DAY DEFAULT_PEDGRP
	SET_ZONE_GROUP SUB_ZON NIGHT DEFAULT_PEDGRP

// Gang1 in industrial = MAFIA
// Gang2 in industrial = TRIADS
// Gang3 in industrial = DIABLOS
// Gang4 in commercial = YAKUZA
// Gang5 in commercial = YARDDIES
// Gang6 in commercial = COLUMBIANS
// Gang7 in commercial = HOODS
// PedDensity Gang1 Gang2 Gang3 Gang4 Gang5 Gang6 Gang7 Police
// CarDensity Gang1 Gang2 Gang3 Gang4 Gang5 Gang6 Gang7 Police PoorFamily RichFamily Executive Worker Special Big

//GANG ZONES 

    SETUP_ZONE_PED_INFO LITTLEI DAY	  (17) 300 0 0 (0 0 0 0) 20	//St Marks
    SETUP_ZONE_PED_INFO	LITTLEI	NIGHT (11) 400 0 0 (0 0 0 0) 10
    SETUP_ZONE_CAR_INFO LITTLEI DAY	  (10) 100 0 0 (0 0 0 0) 20 400 0 0 350 20 0
    SETUP_ZONE_CAR_INFO LITTLEI NIGHT ( 8) 150 0 0 (0 0 0 0) 10 550 0 0 150 0  0
	SET_ZONE_GROUP LITTLEI DAY LITTLEITALY_PEDGRP
	SET_ZONE_GROUP LITTLEI NIGHT LITTLEITALY_NIGHT_PEDGRP

    SETUP_ZONE_PED_INFO CHINA DAY   (20) 0 300 0 (0 0 0 0) 20 //China town 
    SETUP_ZONE_PED_INFO CHINA NIGHT (12) 0 400 0 (0 0 0 0) 10 
    SETUP_ZONE_CAR_INFO CHINA DAY   (10) 0 100 0 (0 0 0 0) 10 400 0 0 350 0 0
    SETUP_ZONE_CAR_INFO CHINA NIGHT ( 8) 0 150 0 (0 0 0 0) 20 550 0 0 200 0	0
	SET_ZONE_GROUP CHINA DAY CHINATOWN_PEDGRP
	SET_ZONE_GROUP CHINA NIGHT CHINATOWN_NIGHT_PEDGRP

    SETUP_ZONE_PED_INFO	TOWERS DAY   (15) 0 0 300 (0 0 0 0) 0 //Hepburn heoghts
    SETUP_ZONE_PED_INFO TOWERS NIGHT (10) 0 0 400 (0 0 0 0) 0
    SETUP_ZONE_CAR_INFO TOWERS DAY   ( 8) 0 0 100 (0 0 0 0) 20 400 0 0 350 0 0
    SETUP_ZONE_CAR_INFO TOWERS NIGHT ( 6) 0 0 150 (0 0 0 0) 10 550 0 0 200 0 0
	SET_ZONE_GROUP TOWERS DAY PROJECTS_PEDGRP
	SET_ZONE_GROUP TOWERS NIGHT PROJECTS_NIGHT_PEDGRP

    SETUP_ZONE_PED_INFO REDLIGH DAY   ( 6) 0 0 0 (0 0 0 0) 20 //Redlight district 
    SETUP_ZONE_PED_INFO REDLIGH NIGHT (13) 0 0 0 (0 0 0 0) 10
    SETUP_ZONE_CAR_INFO REDLIGH DAY   ( 5) 0 0 0 (0 0 0 0) 10 550 0 0 350 0	0
    SETUP_ZONE_CAR_INFO REDLIGH NIGHT ( 7) 0 0 0 (0 0 0 0) 20 600 0 0 200 0	0
	SET_ZONE_GROUP REDLIGH DAY REDLIGHT_PEDGRP
	SET_ZONE_GROUP REDLIGH NIGHT REDLIGHT_NIGHT_PEDGRP


//NAVIGATION ZONES 
	
    SETUP_ZONE_PED_INFO PORT_I DAY   (10) 0 0 0 (0 0 0 0) 0 //Trenton
    SETUP_ZONE_PED_INFO PORT_I NIGHT ( 7) 0 0 0 (0 0 0 0) 0
    SETUP_ZONE_CAR_INFO PORT_I DAY   ( 8) 0 0 0 (0 0 0 0) 20 300 0 0 400 20 0
    SETUP_ZONE_CAR_INFO PORT_I NIGHT ( 6) 0 0 0 (0 0 0 0) 10 500 0 0 400 0	0
	SET_ZONE_GROUP PORT_I DAY INDUSTRIAL_PEDGRP
	SET_ZONE_GROUP PORT_I NIGHT INDUSTRIAL_NIGHT_PEDGRP

    SETUP_ZONE_PED_INFO PORT_E DAY   (10) 0 0 0 (0 0 0 0) 0 //Portland Harbour
    SETUP_ZONE_PED_INFO PORT_E NIGHT ( 8) 0 0 0 (0 0 0 0) 0
    SETUP_ZONE_CAR_INFO PORT_E DAY   ( 8) 0 0 0 (0 0 0 0) 20 300 0 0 400 20 0
    SETUP_ZONE_CAR_INFO PORT_E NIGHT ( 6) 0 0 0 (0 0 0 0) 10 500 0 0 400 0	0
	SET_ZONE_GROUP PORT_E DAY DOCKS_PEDGRP
	SET_ZONE_GROUP PORT_E NIGHT DOCKS_NIGHT_PEDGRP

    SETUP_ZONE_PED_INFO PORT_S DAY   (10) 0 0 0 (0 0 0 0) 0 //Atlantic Quays
    SETUP_ZONE_PED_INFO PORT_S NIGHT ( 8) 0 0 0 (0 0 0 0) 0 				 
    SETUP_ZONE_CAR_INFO PORT_S DAY   ( 8) 0 0 0 (0 0 0 0) 20 300 0 0 500 20 0
    SETUP_ZONE_CAR_INFO PORT_S NIGHT ( 6) 0 0 0 (0 0 0 0) 10 500 0 0 400 0	0
	SET_ZONE_GROUP PORT_S DAY INDUSTRIAL_PEDGRP
	SET_ZONE_GROUP PORT_S NIGHT INDUSTRIAL_NIGHT_PEDGRP

    SETUP_ZONE_PED_INFO PORT_W DAY   (10) 0 10 0 (0 0 0 0) 0 //Callahan Point
    SETUP_ZONE_PED_INFO PORT_W NIGHT ( 5) 0 10 0 (0 0 0 0) 0 
    SETUP_ZONE_CAR_INFO PORT_W DAY   ( 8) 0 0 0 (0 0 0 0) 20 300 0 0 400 0 0
    SETUP_ZONE_CAR_INFO PORT_W NIGHT ( 6) 0 0 0 (0 0 0 0) 10 500 0 0 400 0 0
	SET_ZONE_GROUP PORT_W DAY INDUSTRIAL_PEDGRP
	SET_ZONE_GROUP PORT_W NIGHT INDUSTRIAL_NIGHT_PEDGRP

    SETUP_ZONE_PED_INFO	HARWOOD	DAY   (10) 0 0 0 (0 0 0 0) 0 //Harwood
    SETUP_ZONE_PED_INFO HARWOOD NIGHT ( 8) 0 0 0 (0 0 0 0) 0
    SETUP_ZONE_CAR_INFO HARWOOD DAY   ( 8) 0 0 0 (0 0 0 0) 20 400 0 0 300 0	0
    SETUP_ZONE_CAR_INFO HARWOOD NIGHT ( 6) 0 0 0 (0 0 0 0) 10 600 0 0 200 0	0
	SET_ZONE_GROUP HARWOOD DAY INDUSTRIAL_PEDGRP
	SET_ZONE_GROUP HARWOOD NIGHT INDUSTRIAL_NIGHT_PEDGRP

    SETUP_ZONE_PED_INFO	EASTBAY	DAY   (10) 0 0 0 (0 0 0 0) 0 //Portland Beach
    SETUP_ZONE_PED_INFO EASTBAY NIGHT ( 5) 0 0 0 (0 0 0 0) 0 
    SETUP_ZONE_CAR_INFO EASTBAY DAY   ( 5) 0 0 0 (0 0 0 0) 20 500 0 0 480 0 0
    SETUP_ZONE_CAR_INFO EASTBAY NIGHT ( 4) 0 0 0 (0 0 0 0) 10 500 0 0 490 0 0
	SET_ZONE_GROUP EASTBAY DAY INDUSTRIAL_PEDGRP
	SET_ZONE_GROUP EASTBAY NIGHT INDUSTRIAL_NIGHT_PEDGRP

    SETUP_ZONE_PED_INFO	S_VIEW DAY   (10) 0 0 0 (0 0 0 0) 30 //Portland View
    SETUP_ZONE_PED_INFO S_VIEW NIGHT ( 8) 0 0 0 (0 0 0 0) 20
    SETUP_ZONE_CAR_INFO S_VIEW DAY   (10) 0 0 0 (0 0 0 0) 30 400 0 0 300 100 0
    SETUP_ZONE_CAR_INFO S_VIEW NIGHT ( 8) 0 0 0 (0 0 0 0) 20 500 0 0 200 100 0
	SET_ZONE_GROUP S_VIEW DAY INDUSTRIAL_PEDGRP
	SET_ZONE_GROUP S_VIEW NIGHT INDUSTRIAL_NIGHT_PEDGRP


//OTHER ZONES 

	SETUP_ZONE_PED_INFO	COPS_1 DAY   (10) 0 0 0 (0 0 0 0) 60 //Police station in Portland View
    SETUP_ZONE_PED_INFO COPS_1 NIGHT ( 8) 0 0 0 (0 0 0 0) 60
    SETUP_ZONE_CAR_INFO COPS_1 DAY   (10) 0 0 0 (0 0 0 0) 90 400 0 0 400 0 0
    SETUP_ZONE_CAR_INFO COPS_1 NIGHT ( 8) 0 0 0 (0 0 0 0) 90 400 0 0 400 0	0
	SET_ZONE_GROUP COPS_1 DAY INDUSTRIAL_PEDGRP
	SET_ZONE_GROUP COPS_1 NIGHT INDUSTRIAL_NIGHT_PEDGRP

    SETUP_ZONE_PED_INFO	HOSPI_1	DAY   (10) 0 0 0 (0 0 0 0) 60 //Hospital in Portland View
    SETUP_ZONE_PED_INFO HOSPI_1 NIGHT ( 8) 0 0 0 (0 0 0 0) 60
    SETUP_ZONE_CAR_INFO HOSPI_1 DAY   (10) 0 0 0 (0 0 0 0) 90 400 0 0 400 0 0
    SETUP_ZONE_CAR_INFO HOSPI_1 NIGHT ( 8) 0 0 0 (0 0 0 0) 90 400 0 0 400 0 0
	SET_ZONE_GROUP HOSPI_1 DAY HOSPITAL_PEDGRP
	SET_ZONE_GROUP HOSPI_1 NIGHT HOSPITAL_NIGHT_PEDGRP

    SETUP_ZONE_PED_INFO ROADBR1 DAY   (30) 0 0 0 (0 0 0 0) 0 //com/ind bridge east side 
    SETUP_ZONE_PED_INFO ROADBR1 NIGHT (20) 0 0 0 (0 0 0 0) 0
    SETUP_ZONE_CAR_INFO ROADBR1 DAY   (12) 0 0 0 (0 0 0 0) 20 400 0 0 400 0 100
    SETUP_ZONE_CAR_INFO ROADBR1 NIGHT (10) 0 0 0 (0 0 0 0) 10 400 0 0 400 0	100
	SET_ZONE_GROUP ROADBR1 DAY INDUSTRIAL_PEDGRP
	SET_ZONE_GROUP ROADBR1 NIGHT INDUSTRIAL_NIGHT_PEDGRP

   	SETUP_ZONE_PED_INFO FISHFAC DAY   ( 2) 0 1000 0 (0 0 0 0) 0 //Fish factory  
    SETUP_ZONE_PED_INFO FISHFAC NIGHT ( 2) 0 1000 0 (0 0 0 0) 0
    SETUP_ZONE_CAR_INFO FISHFAC DAY   ( 6) 0 0 0 (0 0 0 0) 20 200 0 0 600 0	0
    SETUP_ZONE_CAR_INFO FISHFAC NIGHT ( 4) 0 0 0 (0 0 0 0) 10 200 0 0 600 0	0
	SET_ZONE_GROUP FISHFAC DAY INDUSTRIAL_PEDGRP
	SET_ZONE_GROUP FISHFAC NIGHT INDUSTRIAL_NIGHT_PEDGRP

    SETUP_ZONE_PED_INFO	FILLIN1 DAY   (10) 0 0 0 (0 0 0 0) 0 //Fills a gap in the zones
    SETUP_ZONE_PED_INFO FILLIN1 NIGHT ( 8) 0 0 0 (0 0 0 0) 0
    SETUP_ZONE_CAR_INFO FILLIN1 DAY   ( 8) 0 0 0 (0 0 0 0) 20 500 0 0 400 0	0
    SETUP_ZONE_CAR_INFO FILLIN1 NIGHT ( 6) 0 0 0 (0 0 0 0) 10 400 0 0 400 0	0
	SET_ZONE_GROUP FILLIN1 DAY INDUSTRIAL_PEDGRP
	SET_ZONE_GROUP FILLIN1 NIGHT INDUSTRIAL_NIGHT_PEDGRP

	SETUP_ZONE_PED_INFO MAIN_D1 DAY   (15) 0 300 0 (0 0 0 0) 20	//SOUTH CHINATOWN
    SETUP_ZONE_PED_INFO MAIN_D1 NIGHT (10) 0 500 0 (0 0 0 0) 10 //P R X  W   S	B
    SETUP_ZONE_CAR_INFO MAIN_D1 DAY   (24) 0 100 0 (0 0 0 0) 20 300 0 0 300 20	100
    SETUP_ZONE_CAR_INFO MAIN_D1 NIGHT (18) 0 150 0 (0 0 0 0) 10 300 0 0 300 20	100
	SET_ZONE_GROUP MAIN_D1 DAY CHINATOWN_PEDGRP
	SET_ZONE_GROUP MAIN_D1 NIGHT CHINATOWN_NIGHT_PEDGRP

	SETUP_ZONE_PED_INFO MAIN_D2 DAY   (15) 0 300 0 (0 0 0 0) 20	//CHINATOWN
    SETUP_ZONE_PED_INFO MAIN_D2 NIGHT (10) 0 400 0 (0 0 0 0) 10
    SETUP_ZONE_CAR_INFO MAIN_D2 DAY   (24) 0 100 0 (0 0 0 0) 20 300 0 0 300 20 100
    SETUP_ZONE_CAR_INFO MAIN_D2 NIGHT (18) 0 150 0 (0 0 0 0) 10 300 0 0 300 20 100
	SET_ZONE_GROUP MAIN_D2 DAY CHINATOWN_PEDGRP
	SET_ZONE_GROUP MAIN_D2 NIGHT CHINATOWN_NIGHT_PEDGRP

	SETUP_ZONE_PED_INFO MAIN_D3 DAY   (15) 0 300 0 (0 0 0 0) 20	//CHINATOWN
    SETUP_ZONE_PED_INFO MAIN_D3 NIGHT (10) 0 400 0 (0 0 0 0) 10
    SETUP_ZONE_CAR_INFO MAIN_D3 DAY   (24) 0 100 0 (0 0 0 0) 20 300 0 0 300 20 100
    SETUP_ZONE_CAR_INFO MAIN_D3 NIGHT (18) 0 150 0 (0 0 0 0) 10 300 0 0 300 20 100
	SET_ZONE_GROUP MAIN_D3 DAY CHINATOWN_PEDGRP
	SET_ZONE_GROUP MAIN_D3 NIGHT CHINATOWN_NIGHT_PEDGRP

	SETUP_ZONE_PED_INFO MAIN_D4 DAY   (15) 0 300 0 (0 0 0 0) 20	//NORTH CHINATOWN
    SETUP_ZONE_PED_INFO MAIN_D4 NIGHT (10) 0 400 0 (0 0 0 0) 10
    SETUP_ZONE_CAR_INFO MAIN_D4 DAY   (24) 0 100 0 (0 0 0 0) 20 300 0 0 300 20 100
    SETUP_ZONE_CAR_INFO MAIN_D4 NIGHT (18) 0 150 0 (0 0 0 0) 10 300 0 0 300 20 100
	SET_ZONE_GROUP MAIN_D4 DAY CHINATOWN_PEDGRP
	SET_ZONE_GROUP MAIN_D4 NIGHT CHINATOWN_NIGHT_PEDGRP

	SETUP_ZONE_PED_INFO MAIN_D5 DAY   (15) 0 0 0 (0 0 0 0) 20 //REDLIGHT
    SETUP_ZONE_PED_INFO MAIN_D5 NIGHT (10) 0 0 0 (0 0 0 0) 10
    SETUP_ZONE_CAR_INFO MAIN_D5 DAY   (24) 0 0 0 (0 0 0 0) 20 400 0 0 300 20 100
    SETUP_ZONE_CAR_INFO MAIN_D5 NIGHT (18) 0 0 0 (0 0 0 0) 10 300 0 0 400 20 100
	SET_ZONE_GROUP MAIN_D5 DAY REDLIGHT_PEDGRP
	SET_ZONE_GROUP MAIN_D5 NIGHT REDLIGHT_NIGHT_PEDGRP

	SETUP_ZONE_PED_INFO MAIN_D6 DAY   (15) 0 0 300 (0 0 0 0) 20	//TOWERS
    SETUP_ZONE_PED_INFO MAIN_D6 NIGHT (10) 0 0 400 (0 0 0 0) 10
    SETUP_ZONE_CAR_INFO MAIN_D6 DAY   (24) 0 0 100 (0 0 0 0) 20 300 0 0 300 20 100
    SETUP_ZONE_CAR_INFO MAIN_D6 NIGHT (18) 0 0 150 (0 0 0 0) 10 300 0 0 300 20 100
	SET_ZONE_GROUP MAIN_D6 DAY PROJECTS_PEDGRP
	SET_ZONE_GROUP MAIN_D6 NIGHT PROJECTS_NIGHT_PEDGRP

// ****************************Industrial switched off Road and Ped Nodes*******************

SWITCH_ROADS_OFF 619.6 -911.5 45.0 834.3 -954.5 32.0 //Industrial to commercial Bridge
MARK_ROADS_BETWEEN_LEVELS 619.6 -911.5 45.0 834.3 -954.5 32.0

SWITCH_ROADS_OFF 1381.0 -293.7 48.0 1435.8 -140.1 58.0 //Frankies Driveway
SWITCH_ROADS_OFF 1358.9 -901.9 10.0 1609.6 -615.1 16.0 //Docks 

SWITCH_ROADS_OFF 659.6 200.0 -20.0 945.8 147.5 5.0 //Tunnel
MARK_ROADS_BETWEEN_LEVELS 659.6 200.0 -20.0 945.8 147.5 5.0

SWITCH_PED_ROADS_OFF 659.6 200.0 -25.0 945.8 147.5 5.0	//Tunnel
MARK_ROADS_BETWEEN_LEVELS 659.6 200.0 -25.0 945.8 147.5 5.0

SWITCH_PED_ROADS_OFF 773.6 191.8 -25.0 819.7 182.8 5.0	//Tunnel
MARK_ROADS_BETWEEN_LEVELS 773.6 191.8 -25.0 819.7 182.8 5.0

SWITCH_PED_ROADS_OFF 1609.0 -896.0 8.0 1393.7 -967.4 30.0 //Colubian Boat

SWITCH_PED_ROADS_OFF 1048.3 -1103.4 5.0 1040.0 -1074.4 30.0 //Fish Factory

SWITCH_PED_ROADS_OFF 900.09 -297.05 6.0 842.83 -325.58 15.0	//Players hideout

SWITCH_PED_ROADS_OFF  900.5 -427.1 14.0 879.1 -404.2 17.0 //Luigis alleyway

SWITCH_PED_ROADS_OFF 847.9 -640.6 10.0 887.9 -685.8 20.0 //Toni2 alleyway

SWITCH_PED_ROADS_OFF_ANGLED 1222.9 -838.4 13.5 1256.3 -804.9 16.0 58.0 //Bitch'n Dog Food Factory

SWITCH_PED_ROADS_OFF 1005.59 -880.96 12.0 995.9 -893.34 20.0 //Fuzz Ball  

SWITCH_PED_ROADS_OFF 1070.6 -401.6 10.0 1067.8 -397.2 25.0 //AMMUNATION

// ***************************************Commercial City Zones*****************************

// Gang1 in industrial = MAFIA
// Gang2 in industrial = TRIADS
// Gang3 in industrial = DIABLOS
// Gang4 in commercial = YAKUZA
// Gang5 in commercial = YARDDIES
// Gang6 in commercial = COLUMBIANS
// Gang7 in commercial = HOODS
// PedDensity Gang1 Gang2 Gang3 Gang4 Gang5 Gang6 Gang7 Police
// CarDensity Gang1 Gang2 Gang3 Gang4 Gang5 Gang6 Gang7 Police PoorFamily RichFamily Executive Worker Special Big

//NAVIGATION ZONES

    SETUP_ZONE_PED_INFO STADIUM DAY   (30) (0 0 0) 0 0 0 0 0 //Aspatria 
    SETUP_ZONE_PED_INFO STADIUM NIGHT (16) (0 0 0) 0 0 0 0 0
    SETUP_ZONE_CAR_INFO STADIUM DAY   (20) (0 0 0) 0 0 0 0 20 300 150 0 250 0 200
    SETUP_ZONE_CAR_INFO STADIUM NIGHT (17) (0 0 0) 0 0 0 0 10 300 150 0 250 0 200
	SET_ZONE_GROUP STADIUM DAY STADIUM_PEDGRP
	SET_ZONE_GROUP STADIUM NIGHT STADIUM_NIGHT_PEDGRP

    SETUP_ZONE_PED_INFO HOSPI_2 DAY   (30) (0 0 0) 0 0 0 0 0  //Rockford
    SETUP_ZONE_PED_INFO HOSPI_2 NIGHT (16) (0 0 0) 0 0 0 0 0
    SETUP_ZONE_CAR_INFO HOSPI_2 DAY   (20) (0 0 0) 0 0 0 0 20 300 150 0 250 0 200
    SETUP_ZONE_CAR_INFO HOSPI_2 NIGHT (17) (0 0 0) 0 0 0 0 10 300 150 0 250 0 200
	SET_ZONE_GROUP HOSPI_2 DAY HOSPITAL_PEDGRP
	SET_ZONE_GROUP HOSPI_2 NIGHT HOSPITAL_NIGHT_PEDGRP

	SETUP_ZONE_PED_INFO UNIVERS DAY   (30) (0 0 0) 0 0 0 0 20 //Liberty Campus 
    SETUP_ZONE_PED_INFO UNIVERS NIGHT (16) (0 0 0) 0 0 0 0 10
    SETUP_ZONE_CAR_INFO UNIVERS DAY   (20) (0 0 0) 0 0 0 0 20 300 300 300 0 20 0
    SETUP_ZONE_CAR_INFO UNIVERS NIGHT (17) (0 0 0) 0 0 0 0 10 300 300 300 0 20 0
	SET_ZONE_GROUP UNIVERS DAY UNIVERSITY_PEDGRP
	SET_ZONE_GROUP UNIVERS NIGHT UNIVERSITY_NIGHT_PEDGRP

    SETUP_ZONE_PED_INFO CONSTRU DAY   (30) (0 0 0) 0 0 300 0 20  //Fort staunton
    SETUP_ZONE_PED_INFO CONSTRU NIGHT (16) (0 0 0) 0 0 400 0 10
    SETUP_ZONE_CAR_INFO CONSTRU DAY   (20) (0 0 0) 0 0 100 0 20 300 100 0 250 0 150
    SETUP_ZONE_CAR_INFO CONSTRU NIGHT (17) (0 0 0) 0 0 150 0 10 300 100 0 250 0 150
	SET_ZONE_GROUP CONSTRU DAY CONSTRUCTION_PEDGRP
	SET_ZONE_GROUP CONSTRU NIGHT CONSTRUCTION_NIGHT_PEDGRP				   

    SETUP_ZONE_PED_INFO PARK DAY   (30) (0 0 0) 0 0 0 0 20 //Belleville Park 
    SETUP_ZONE_PED_INFO PARK NIGHT (16) (0 0 0) 0 0 0 0 10
    SETUP_ZONE_CAR_INFO PARK DAY   (20) (0 0 0) 0 0 0 0 20 300 300 300 0 0 0
    SETUP_ZONE_CAR_INFO PARK NIGHT (17) (0 0 0) 0 0 0 0 10 300 300 300 0 0 0
	SET_ZONE_GROUP PARK DAY PARK_PEDGRP
	SET_ZONE_GROUP PARK NIGHT PARK_NIGHT_PEDGRP

    SETUP_ZONE_PED_INFO COM_EAS DAY   (30) (0 0 0) 0 300 0 0 20 // Newport
    SETUP_ZONE_PED_INFO COM_EAS NIGHT (16) (0 0 0) 0 400 0 0 10
    SETUP_ZONE_CAR_INFO COM_EAS DAY   (20) (0 0 0) 0 100 0 0 20 400 250 0 0 0 150
    SETUP_ZONE_CAR_INFO COM_EAS NIGHT (17) (0 0 0) 0 150 0 0 10 400 250 0 0 0 100
	SET_ZONE_GROUP COM_EAS DAY SHOPPING_PEDGRP
	SET_ZONE_GROUP COM_EAS NIGHT SHOPPING_NIGHT_PEDGRP

	SETUP_ZONE_PED_INFO SHOPING DAY   (30) (0 0 0) 0 0 0 0 20  //Bedford Point 
    SETUP_ZONE_PED_INFO SHOPING NIGHT (16) (0 0 0) 0 0 0 0 10
    SETUP_ZONE_CAR_INFO SHOPING DAY   (20) (0 0 0) 0 0 0 0 30 300 250 250 0 0 100
    SETUP_ZONE_CAR_INFO SHOPING NIGHT (17) (0 0 0) 0 0 0 0 20 300 250 250 0 0 100
	SET_ZONE_GROUP SHOPING DAY SHOPPING_PEDGRP
	SET_ZONE_GROUP SHOPING NIGHT SHOPPING_NIGHT_PEDGRP

    SETUP_ZONE_PED_INFO YAKUSA DAY   (30) (0 0 0) 300 0 0 0 20  //Torrington
    SETUP_ZONE_PED_INFO YAKUSA NIGHT (16) (0 0 0) 400 0 0 0 10
    SETUP_ZONE_CAR_INFO YAKUSA DAY   (20) (0 0 0) 100 0 0 0 40 350 200 250 0 0 0
    SETUP_ZONE_CAR_INFO YAKUSA NIGHT (17) (0 0 0) 150 0 0 0 20 350 200 200 0 0 0
	SET_ZONE_GROUP YAKUSA DAY SHOPPING_PEDGRP
	SET_ZONE_GROUP YAKUSA NIGHT SHOPPING_NIGHT_PEDGRP

//OTHER ZONES

    SETUP_ZONE_PED_INFO ROADBR2 DAY   (30) (0 0 0) 0 0 0 0 20  
    SETUP_ZONE_PED_INFO ROADBR2 NIGHT (20) (0 0 0) 0 0 0 0 10
    SETUP_ZONE_CAR_INFO ROADBR2 DAY   (20) (0 0 0) 0 0 0 0 30 300 250 250 0 0 100
    SETUP_ZONE_CAR_INFO ROADBR2 NIGHT (17) (0 0 0) 0 0 0 0 20 300 250 250 0 0 100
	SET_ZONE_GROUP ROADBR2 DAY SHOPPING_PEDGRP
	SET_ZONE_GROUP ROADBR2 NIGHT SHOPPING_NIGHT_PEDGRP


// ****************************Commercial switched off Road and Ped Nodes*******************

SWITCH_PED_ROADS_OFF 106.1 -1278.3 24.0 96.3 -1273.5 27.0 //Hyaku Dojo for Kenji one
SWITCH_PED_ROADS_OFF 120.0 170.0 10.0 190.0 246.0 25.0 //Phil's place
SWITCH_PED_ROADS_OFF 31.0 -317.0 14.0 91.0 -394.0 25.0 // Colombian compound 

SWITCH_ROADS_OFF 120.0 170.0 10.0 190.0 246.0 25.0 //Phil's place

SWITCH_ROADS_OFF 121.814 -46.429 14.0 363.858 54.312 20.0 //Ambulance
SWITCH_PED_ROADS_OFF 121.814 -46.429 14.0 363.858 54.312 20.0 //Ambulance

SWITCH_ROADS_OFF 353.5 -459.0 18.0 397.5 -431.6 30.0 // Witness protection house
  
SWITCH_ROADS_OFF 465.7 -634.3 10.0 429.9 -610.1 25.0 // By Asukas condo 

SWITCH_ROADS_OFF -46.8 -648.0 39.0 -69.1 -614.0 50.0 //Commercial to Suburbia Bridge
MARK_ROADS_BETWEEN_LEVELS -46.8 -648.0 39.0 -69.1 -614.0 50.0

SWITCH_PED_ROADS_OFF 56.5 -1544.2 10.0 87.9 -1556.0 30.0 // Loves building

SWITCH_PED_ROADS_OFF 413.5 -480.2 20.0 420.9 -499.0 36.0 //ped island
SWITCH_PED_ROADS_OFF 419.5 -708.1 20.0 412.5 -717.9 36.0 //ped island
SWITCH_PED_ROADS_OFF -76.9 -985.4 20.0 -68.8 -992.6 36.0 //ped island
SWITCH_PED_ROADS_OFF -76.5 -934.4 20.0 -70.4 -928.4 36.0 //ped island
SWITCH_PED_ROADS_OFF -55.9 -934.6 20.0 -46.4 -927.2 36.0 //ped island

SWITCH_PED_ROADS_OFF -76.4 -999.6 20.0 -68.8 -628.5 36.0 //ped island

SWITCH_PED_ROADS_OFF 199.3 -935.9 20.0 134.8 -927.4 40.0 //ped island

SWITCH_ROADS_OFF 529.6 106.5 -30.0 581.4 65.7 0.0 //tunnel from commercial to intersection for sub and ind

// ****************************************Suburban City Zones******************************

// Gang1 in industrial = MAFIA
// Gang2 in industrial = TRIADS
// Gang3 in industrial = DIABLOS
// Gang4 in commercial = YAKUZA
// Gang5 in commercial = YARDDIES
// Gang6 in commercial = COLUMBIANS
// Gang7 in commercial = HOODS
// PedDensity Gang1 Gang2 Gang3 Gang4 Gang5 Gang6 Gang7 Police
// CarDensity Gang1 Gang2 Gang3 Gang4 Gang5 Gang6 Gang7 Police PoorFamily RichFamily Executive Worker Special Big



//NAVIGATION ZONES

    SETUP_ZONE_PED_INFO AIRPORT DAY   (20) (0 0 0 0 0) 0 0 20 //FRANCIS INTI. AIRPORT 
    SETUP_ZONE_PED_INFO AIRPORT NIGHT (10) (0 0 0 0 0) 0 0 10
    SETUP_ZONE_CAR_INFO AIRPORT DAY   (15) (0 0 0 0 0) 0 0 40 300 300 300 0 0 0
    SETUP_ZONE_CAR_INFO AIRPORT NIGHT (13) (0 0 0 0 0) 0 0 20 300 300 300 0 0 0
	SET_ZONE_GROUP AIRPORT DAY AIRPORT_PEDGRP
	SET_ZONE_GROUP AIRPORT NIGHT AIRPORT_NIGHT_PEDGRP

    SETUP_ZONE_PED_INFO PROJECT DAY   (20) (0 0 0 0 0) 0 300 0 //WICHITA GARDENS 
    SETUP_ZONE_PED_INFO PROJECT NIGHT (10) (0 0 0 0 0) 0 400 0
    SETUP_ZONE_CAR_INFO PROJECT DAY   (15) (0 0 0 0 0) 0 100 20 500 150 0 150 0 0
    SETUP_ZONE_CAR_INFO PROJECT NIGHT (13) (0 0 0 0 0) 0 150 10 500 100 0 150 0 0
	SET_ZONE_GROUP PROJECT DAY PROJECTS_PEDGRP
	SET_ZONE_GROUP PROJECT NIGHT PROJECTS_NIGHT_PEDGRP

    SETUP_ZONE_PED_INFO SUB_IND DAY   (20) (0 0 0 0 0) 0 0 20 //PIKE CREEK 
    SETUP_ZONE_PED_INFO SUB_IND NIGHT (10) (0 0 0 0 0) 0 0 10
    SETUP_ZONE_CAR_INFO SUB_IND DAY   (15) (0 0 0 0 0) 0 0 20 300 300 300 0 0 0
    SETUP_ZONE_CAR_INFO SUB_IND NIGHT (13) (0 0 0 0 0) 0 0 10 300 300 300 0 0 0
	SET_ZONE_GROUP SUB_IND DAY DOCKS_PEDGRP
	SET_ZONE_GROUP SUB_IND NIGHT DOCKS_NIGHT_PEDGRP

    SETUP_ZONE_PED_INFO SWANKS DAY   (20) (0 0 0 0 0) 70 0 30 //CEDAR CROVE 
    SETUP_ZONE_PED_INFO SWANKS NIGHT (10) (0 0 0 0 0) 90 0 20
    SETUP_ZONE_CAR_INFO SWANKS DAY   (15) (0 0 0 0 0) 70 0 30 0 400 400 0 20 0
    SETUP_ZONE_CAR_INFO SWANKS NIGHT (13) (0 0 0 0 0) 90 0 20 0 400 400 0 20 0
	SET_ZONE_GROUP SWANKS DAY SWANKSVILLE_PEDGRP
	SET_ZONE_GROUP SWANKS NIGHT SWANKSVILLE_NIGHT_PEDGRP

    SETUP_ZONE_PED_INFO BIG_DAM DAY   ( 8) (0 0 0 0 0) 0 0 0  //COCHRANE DAM
    SETUP_ZONE_PED_INFO BIG_DAM NIGHT ( 6) (0 0 0 0 0) 0 0 0
    SETUP_ZONE_CAR_INFO BIG_DAM DAY   ( 8) (0 0 0 0 0) 0 0 20 300 300 0 300 0 0
    SETUP_ZONE_CAR_INFO BIG_DAM NIGHT ( 6) (0 0 0 0 0) 0 0 10 300 300 0 300 0 0
	SET_ZONE_GROUP BIG_DAM DAY INDUSTRIAL_PEDGRP
	SET_ZONE_GROUP BIG_DAM NIGHT INDUSTRIAL_NIGHT_PEDGRP

	SETUP_ZONE_PED_INFO SUB_ZO2 DAY   (20) (0 0 0 0 0) 0 0 20 //SHORESIDE VALE
    SETUP_ZONE_PED_INFO SUB_ZO2 NIGHT (10) (0 0 0 0 0) 0 0 10
    SETUP_ZONE_CAR_INFO SUB_ZO2 DAY   (15) (0 0 0 0 0) 0 0 20 0 500 450 0 0 0   
    SETUP_ZONE_CAR_INFO SUB_ZO2 NIGHT (13) (0 0 0 0 0) 0 0 10 0 500 450 0 0 0
	SET_ZONE_GROUP SUB_ZO2 DAY DEFAULT_PEDGRP
	SET_ZONE_GROUP SUB_ZO2 NIGHT DEFAULT_PEDGRP

	SETUP_ZONE_PED_INFO SUB_ZO3 DAY   (20) (0 0 0 0 0) 0 0 20 //SHORESIDE VALE
    SETUP_ZONE_PED_INFO SUB_ZO3 NIGHT (10) (0 0 0 0 0) 0 0 10
    SETUP_ZONE_CAR_INFO SUB_ZO3 DAY   (15) (0 0 0 0 0) 0 0 20 0 500 450 0 0 0   
    SETUP_ZONE_CAR_INFO SUB_ZO3 NIGHT (13) (0 0 0 0 0) 0 0 10 0 500 450 0 0 0
	SET_ZONE_GROUP SUB_ZO3 DAY DEFAULT_PEDGRP
	SET_ZONE_GROUP SUB_ZO3 NIGHT DEFAULT_PEDGRP

	SETUP_ZONE_PED_INFO WEE_DAM DAY   ( 8) (0 0 0 0 0) 100 0 0  
	SETUP_ZONE_PED_INFO WEE_DAM NIGHT ( 5) (0 0 0 0 0) 100 0 0
	SETUP_ZONE_CAR_INFO WEE_DAM DAY   ( 0) (0 0 0 0 0) 0 0 0 0 0 0 0 0 0
	SETUP_ZONE_CAR_INFO WEE_DAM NIGHT ( 0) (0 0 0 0 0) 0 0 0 0 0 0 0 0 0
	SET_ZONE_GROUP WEE_DAM DAY DOCKS_PEDGRP
	SET_ZONE_GROUP WEE_DAM NIGHT DOCKS_NIGHT_PEDGRP

// ****************************Suburban switched off Road and Ped Nodes*********************

SWITCH_ROADS_OFF -1052.6693 -78.0430 50.0 -988.0153 -67.1608 30.0 // warehouse in Suburbia
SWITCH_PED_ROADS_OFF -1052.6693 -78.0430 50.0 -988.0153 -67.1608 30.0 // warehouse in Suburbia 

SWITCH_ROADS_OFF -952.5 361.4 10.0 -939.3 374.0 30.0 // DAM

SWITCH_ROADS_OFF -241.7 251.8 0.0 -256.2 241.4 20.0 // park area (north east)

SWITCH_ROADS_OFF -1367.7690 -731.4872 20.0 -743.1906 -410.1961 5.0 // Airport
SWITCH_ROADS_OFF -1591.4 -931.5 10.0 -1572.9 -914.6 25.0 // Airport

SWITCH_PED_ROADS_OFF -1310.8053 -568.7556 5.0 -1224.9248 -483.4936 20.0 // Airport

SWITCH_ROADS_OFF 496.7 75.5 -30.0 484.0 44.2 0.0 //tunnel to suburbia
MARK_ROADS_BETWEEN_LEVELS 496.7 75.5 -30.0 484.0 44.2 0.0

SWITCH_ROADS_OFF -287.8 396.5 70.0 -269.0 418.0 100.0 //tunnel to Miami	(EAST)
SWITCH_ROADS_OFF -877.1 545.9 60.0 -901.3 575.0 100.0 //tunnel to Miami	(WEST)

SWITCH_ROADS_OFF -690.4 101.2 10.0 -704.4 78.9 30.0  // players savehouse

SWITCH_ROADS_OFF -1194.1 98.6 50.0 -1234.0 119.2 80.0  // 

// **************************************CAR GENERATORS**********************************************

GOSUB_FILE car_generators car_gen.sc

//SPECIAL CAR GENERATORS****************************************************************************
CREATE_CAR_GENERATOR 930.93 -267.63 -100.0 340.0 CAR_BFINJECT -1 -1 0 100 0 0 10000 joeys_buggy //Joeys Buggy
SWITCH_CAR_GENERATOR joeys_buggy 0

CREATE_CAR_GENERATOR 933.7 -65.6 -100.0 0.0 CAR_BORGNINE -1 -1 0 50 0 0 10000 swank_taxi //Car park behind radio station
SWITCH_CAR_GENERATOR swank_taxi 0

// *****************************************PICK_UPS**************************************************

GOSUB_FILE main_pickups pickups.sc

//AMMU NATION*****************************************************************************************
VAR_INT ammu_shop_bloke1
VAR_INT time_difference, current_time, time_since_murdering_shopkeeper1
VAR_INT SHOP_COLT45, SHOP_COLT45_2, SHOP_UZI, SHOP_UZI2
VAR_INT	SHOP_GRENADE2 SHOP_UZI_2 SHOP_SNIPER_2 SHOP_AK47_2 SHOP_ARMOUR																	  
VAR_INT out_of_stock_uzi out_of_stock_pistol SHOP_FLAME	SHOP_MOLOTOV

//Industrial
CREATE_PICKUP WEAPON_COLT45 PICKUP_IN_SHOP_OUT_OF_STOCK 1068.5 -400.8 15.2 SHOP_COLT45 //AMMUNATION
CREATE_PICKUP WEAPON_UZI PICKUP_IN_SHOP_OUT_OF_STOCK 1070.5 -400.8 15.2 SHOP_UZI //AMMUNATION

//Commercial
CREATE_PICKUP WEAPON_AK47 PICKUP_IN_SHOP 342.5 -713.0 26.4 SHOP_AK47_2 //AMMUNATION
CREATE_PICKUP WEAPON_SNIPER PICKUP_IN_SHOP 342.5 -716.0 26.4 SHOP_SNIPER_2 //AMMUNATION
CREATE_PICKUP WEAPON_GRENADE PICKUP_IN_SHOP 344.5 -719.0 26.4 SHOP_GRENADE2 //AMMUNATION
CREATE_PICKUP WEAPON_UZI PICKUP_IN_SHOP 346.5 -719.0 26.4 SHOP_UZI_2 //AMMUNATION
CREATE_PICKUP bodyarmour PICKUP_IN_SHOP 342.5 -719.0 26.4 SHOP_ARMOUR //AMMUNATION

//Suburbia
CREATE_PICKUP WEAPON_FLAME PICKUP_IN_SHOP -1206.6 -6.6 53.3 SHOP_FLAME //AMMUNATION
CREATE_PICKUP WEAPON_MOLOTOV PICKUP_IN_SHOP -1210.6 -6.6 53.3 SHOP_MOLOTOV //AMMUNATION

//BONUS PICKUPS**************************************************************************************
SET_COLLECTABLE1_TOTAL 0

//INDUSTRIAL*****************************************************************************************
CREATE_COLLECTABLE1 1105.3 -1020.0 25.1	//Trenton Sawmill (rooftop)
CREATE_COLLECTABLE1 877.6 -788.0 27.6  //chinatown (rooftop)
CREATE_COLLECTABLE1 1254.0 -611.2 22.8 //Supasave (rooftop)
CREATE_COLLECTABLE1 1045.8 -967.1 16.0 //power plant 
CREATE_COLLECTABLE1 942.1 -793.4 14.9  //chinatown (alleyway)

CREATE_COLLECTABLE1 934.0 -718.9 14.8  //chinatown (market)
CREATE_COLLECTABLE1 898.1 -414.7 26.5 //Redlight (Luigi's)
CREATE_COLLECTABLE1 846.9 -442.5 23.2 //Redlight (rooftop)
CREATE_COLLECTABLE1 927.1 -404.4 29.1 //Redlight (rooftop opposite Luigis)
CREATE_COLLECTABLE1 864.3 -171.5 3.5 //Towers

CREATE_COLLECTABLE1 1538.3 -174.4 19.2 //beach
CREATE_COLLECTABLE1 1213.1 -127.1 15.1 //Easy Credit Autos
CREATE_COLLECTABLE1 753.6  137.0  3.5 //Harwood
CREATE_COLLECTABLE1 1162.0 -101.8 12.0 //petrol station
CREATE_COLLECTABLE1 1155.6 -191.5 14.4 //Back of building behind petrol station

CREATE_COLLECTABLE1 1285.5 -247.5 42.4 //little Italy (park)
CREATE_COLLECTABLE1 1007.2 -219.6 6.7 //Towers (Between trees)
CREATE_COLLECTABLE1 1138.2 -250.0 24.3 //little Italy (building site)
CREATE_COLLECTABLE1 1023.6 -423.7 14.9 //Redlight In building (smash glass)
CREATE_COLLECTABLE1 1237.5 -854.1 20.6 //Liberty Pharmaceuticals (roof)

CREATE_COLLECTABLE1 1478.3 -1150.7 12.0 //docks	9 (pier)
CREATE_COLLECTABLE1 1018.9 -56.8  21.0 //Radio station (Rooftop)
CREATE_COLLECTABLE1 1465.7 -166.5 55.5 //Frankies mansion
CREATE_COLLECTABLE1 1120.2 -926.2 16.0 //chinatown (near the bridge behind some buildings)
CREATE_COLLECTABLE1 1206.5 -821.5 15.0 //dogfood factory

CREATE_COLLECTABLE1 940.2 -199.9 5.0 //Towers (in bushes)
CREATE_COLLECTABLE1 979.3 -1143.1 13.1 //fishfactory
CREATE_COLLECTABLE1 1195.5 -908.8 14.9 //Trenton (in front of Joeys)
CREATE_COLLECTABLE1 1470.4 -811.4 22.4 //Docks (rooftop)
CREATE_COLLECTABLE1 1320.5 -365.5 15.2 //tramp tunnel

CREATE_COLLECTABLE1 932.6 -477.3 -10.8 //Subway Industrial side
CREATE_COLLECTABLE1 1305.9 -380.9 39.5 //Little Italy (back alley)
CREATE_COLLECTABLE1 938.2 -1258.3 3.5 //Island south ofindustrial 

//COMMERCIAL********************************************************************************
CREATE_COLLECTABLE1 36.8 -530.2 26.0 //Top of Uncle BJs deli & groceries under suburban bridge
CREATE_COLLECTABLE1 414.4 -279.3 23.6 //Building site (small building)
CREATE_COLLECTABLE1 203.5 -1252.6 59.3 //Torrington (AMco Roof top) 
CREATE_COLLECTABLE1 77.7 -352.3 16.1 //Garage at save the OOG bit 
CREATE_COLLECTABLE1 120.9 243.7 11.4 //Far North of map (Phils bit)
 
CREATE_COLLECTABLE1 49.4 36.3 16.7 //Behind Stadium 
CREATE_COLLECTABLE1 68.1 -773.3 22.8 //Under bridge (In park) 
CREATE_COLLECTABLE1 -4.0 -1129.1 26.0 //Behind Church 
CREATE_COLLECTABLE1 -134.7 -1386.9 26.2 //Doorway Bedford point (South west)
CREATE_COLLECTABLE1 -23.5 -1472.4 19.7 //Underground carpark Bedford point (South west)

CREATE_COLLECTABLE1 112.1 -1227.6 26.0 //Alley way (South central) 
CREATE_COLLECTABLE1 218.3 -1237.8 20.4 //Underground carpark Torrington (South east) 
CREATE_COLLECTABLE1 308.0 -1533.4 23.6 //Behind star statue logo (South east) 
CREATE_COLLECTABLE1 468.6 -1457.2 44.3 //Top of Kenji's casino (heli Pad)
CREATE_COLLECTABLE1 355.1 -1085.7 25.9 //Behind Police station
 
CREATE_COLLECTABLE1 312.4 -483.8 29.0 //Multi story carpark (1st floor) 
CREATE_COLLECTABLE1 322.3 -447.1 23.4 //Garage next to multi story carpark 
CREATE_COLLECTABLE1 586.7 -795.0 1.6 // Jetty (North of industrial bridge)
CREATE_COLLECTABLE1 504.3 -1027.8 1.7 //Jetty (South of industrial bridge)
CREATE_COLLECTABLE1 174.1 -1259.5 32.1 //Upstairs in smashable glass building (Bedford point central) 
 
CREATE_COLLECTABLE1 248.8 -958.3 26.0 //L shaped alley way (Central near industrial bridge)
CREATE_COLLECTABLE1 54.8 -566.5 26.1	//Basketball court
CREATE_COLLECTABLE1 -77.0 -1490.1 26.0 //Behind building in Project like area (South)
CREATE_COLLECTABLE1 556.0 -231.4 22.8 //on top of small bridge (north east)
CREATE_COLLECTABLE1 -38.2 -1434.3 31.8 //on roof near poject area (south west)

CREATE_COLLECTABLE1 194.8 -0.5 19.8 //on top of hospital (north east)
CREATE_COLLECTABLE1 223.1 -272.2 16.1 //east side of university (north)
CREATE_COLLECTABLE1 -18.1 -222.3 29.8 //Stadium entrance 
CREATE_COLLECTABLE1 -69.3 -469.2 16.1 //alleyway south of stadium 
CREATE_COLLECTABLE1 -270.7 -631.6 72.3 //commercial to suburban bridge 

CREATE_COLLECTABLE1 -59.2 -579.8 15.9 //under road tunnel (far west) Bedford point 
CREATE_COLLECTABLE1 392.8 -1135.6 15.9 //just outside Police station 
CREATE_COLLECTABLE1 145.0 -1584.0 30.7 //ped walk way (south central) 
CREATE_COLLECTABLE1 428.1 -340.4 16.2 //Construction site 
CREATE_COLLECTABLE1 351.1 -980.5 33.1 //museum 

CREATE_COLLECTABLE1 -221.8 -1487.6 5.8 //Pier south west coast (behind rocks)

//SUBURBIA************************************************************************************

CREATE_COLLECTABLE1 -1193.1 -75.8 47.4 //Industrial estate  (Behind Burke)
CREATE_COLLECTABLE1 -1090.5 131.7 58.7 //Industrial estate  (Behind import/export garage)
CREATE_COLLECTABLE1 -1015.5 -13.0 49.1 //Industrial estate (Behind Liberty Pharmaceuticals)
CREATE_COLLECTABLE1 -821.8 -184.9 33.8 //Industrial estate  (Behind Turtel Head Fish Co)

CREATE_COLLECTABLE1 -849.1 -209.4 41.8 //Industrial estate on roof (Behind Turtel Head Fish Co)
CREATE_COLLECTABLE1 -736.4 304.7 54.1 //Behind the furthest west Swank house 
CREATE_COLLECTABLE1 -678.1 308.6 59.8 //Behind the 2nd furthest west Swank house
CREATE_COLLECTABLE1 -609.2 286.7 65.1 //I front of 3rd furthest west Swank house
CREATE_COLLECTABLE1 -329.6 320.1 60.7 //columbian mansion (swimming pool) 

CREATE_COLLECTABLE1 -1221.1 562.8 68.6 //Left Dam dome
CREATE_COLLECTABLE1 -1131.9 605.4 68.6 //right Dam dome
CREATE_COLLECTABLE1 -1098.4 471.3 35.5 //First lower Dam Tower
CREATE_COLLECTABLE1 -1208.1 325.2 3.4 //Just to the west of the Dam
CREATE_COLLECTABLE1 -1216.2 347.9 30.4 //Lower dam (last mission heli pad bit) 

CREATE_COLLECTABLE1 -1211.9 -166.9 58.7 //behind hospital
CREATE_COLLECTABLE1 -1195.2 -7.7 59.8 //behind cop station on roof
CREATE_COLLECTABLE1 -206.9 328.8 3.4 //Picnic Park (Shoreside vale) 
CREATE_COLLECTABLE1 -753.2 142.0 10.1 //in tunnel behind save house  
CREATE_COLLECTABLE1 -697.9 -182.1 9.2 //under twisted bridge 

CREATE_COLLECTABLE1 -748.4 -807.0 -13.6 //Subway 
CREATE_COLLECTABLE1 -489.9 -44.9 3.8 //Projects 
CREATE_COLLECTABLE1 -632.9 67.6 18.8 //Projects (behind save house) 
CREATE_COLLECTABLE1 -546.8 10.7 3.9 //Projects (door way)
CREATE_COLLECTABLE1 -1032.6 -573.4 10.9 //Airport (west side of Dome) 

CREATE_COLLECTABLE1 -542.0 -1046.6 3.4 //Airport (end of a runway)
CREATE_COLLECTABLE1 -1556.4 -905.8 14.5 //Airport (Heli Pad)
CREATE_COLLECTABLE1 -1327.0 -624.7 11.1 //Airport under plane (furthest west)
CREATE_COLLECTABLE1 -737.4 -745.4 9.7 //In front of Airport (behind billbords)
CREATE_COLLECTABLE1 -1278.7 -776.0 11.1 //Airport under plane (furthest south)

CREATE_COLLECTABLE1 -1494.7 -1097.3 3.4 //Airport Far south by shore
CREATE_COLLECTABLE1 -837.8 -469.2 10.8 //Airport next to car park (firestation) 


// ********************************************AUDIO*********************************************

VAR_INT sound_loop1	 sound_loop2  sound_loop3  sound_loop4  sound_loop5  sound_loop6  sound_loop7  sound_loop8  sound_loop9  sound_loop10
VAR_INT sound_loop11 sound_loop12 sound_loop13 sound_loop14 sound_loop15 sound_loop16 sound_loop17 sound_loop18 sound_loop19 sound_loop20
VAR_INT misty_joey_loop

//INDUSTRIAL

//China Town
ADD_CONTINUOUS_SOUND 850.8 -663.7 15.0 SOUND_LAUNDERETTE_LOOP_L sound_loop1	//Mr Wongs Laundrette
ADD_CONTINUOUS_SOUND 913.6 -805.5 15.0 SOUND_RESTAURANT_CHINATOWN_LOOP_S sound_loop2 // Chinese Restaurant1 
ADD_CONTINUOUS_SOUND 970.0 -674.8 15.0 SOUND_SHOP_LOOP_L sound_loop3 //China market
ADD_CONTINUOUS_SOUND 975.1 -724.0 15.0 SOUND_SHOP_LOOP_L sound_loop4 //China market

//Little Italy (St Marks)
ADD_CONTINUOUS_SOUND 1220.0 -310.0 32.0 SOUND_RESTAURANT_ITALY_LOOP_S sound_loop5 //Toni's Restaurant
ADD_CONTINUOUS_SOUND 1318.4 -463.6 57.0 SOUND_RESTAURANT_GENERIC_LOOP_2_S sound_loop6 //Lips Bistro

//docks
ADD_CONTINUOUS_SOUND 1579.8 -655.2 13.0 SOUND_DOCKS_LOOP_L sound_loop13 //Docks
ADD_CONTINUOUS_SOUND 1504.8 -873.2 19.0 SOUND_DOCKS_LOOP_L sound_loop14 //Docks2

//Towers
ADD_CONTINUOUS_SOUND 962.3 -259.7 10.0 SOUND_HOME_LOOP_1_L sound_loop15 //Tower Block1
ADD_CONTINUOUS_SOUND 952.5 -148.2 8.0 SOUND_CLUB_LOOP_2_L sound_loop16 //Tower Block2
ADD_CONTINUOUS_SOUND 861.5 -247.2 8.0 SOUND_CLUB_LOOP_1_L sound_loop17 //Tower Block3

//Unsecific Areas
ADD_CONTINUOUS_SOUND 1469.0 -181.0 56.0 SOUND_PIANO_BAR_LOOP_1_S sound_loop18 // Frankies Club
ADD_CONTINUOUS_SOUND 1120.7 -1023.3 23.0 SOUND_SAWMILL_LOOP_L sound_loop19 // Sawmills

//COMMERCIAL

//SUBURBIA

ADD_CONTINUOUS_SOUND -744.7 -604.1 10.0 SOUND_AIRPORT_LOOP_L sound_loop20 //Airport

// *****************************************SPECIAL CHARACTERS********************************

VAR_INT player
VAR_INT micky
VAR_INT luigi
VAR_INT joey
VAR_INT toni
VAR_INT frankie
VAR_INT maria
VAR_INT catalina
VAR_INT miguel
VAR_INT lips
VAR_INT chunky
VAR_INT	misty

VAR_INT asuka
VAR_INT kenji
VAR_INT ray
VAR_INT love
VAR_INT joeys_ride

// Cutscene stuff

VAR_INT cs_time  // timer for cutscenes
VAR_INT cs_player
VAR_INT cs_eight
VAR_INT cs_micky
VAR_INT cs_luigi
VAR_INT cs_joey
VAR_INT cs_tony
VAR_INT cs_frankie
VAR_INT cs_maria
VAR_INT cs_catalina
VAR_INT cs_miguel
VAR_INT cs_misty
VAR_INT cs_ludoor  //Luigi club door
VAR_INT cs_joedoor  //Joey door
VAR_INT cs_eitdoor  // Eightballs door
VAR_INT cs_mafia  //Mafia goon to be standing a Sals club
VAR_INT cs_ship
VAR_INT cs_gangplank
VAR_INT cs_catcar
VAR_INT cs_curly
VAR_INT	cs_shopdoor // Uncle BJ's shop door
VAR_INT cs_rifle  //Rifle 8-ball gives player
VAR_INT cs_bomb  //Bomb 8-ball places on boat 
VAR_INT cs_note
VAR_INT cs_troll
VAR_INT cs_case

VAR_INT cs_mickyhead
VAR_INT cs_playerhead
VAR_INT cs_eighthead
VAR_INT cs_luigihead
VAR_INT cs_joeyhead
VAR_INT cs_tonyhead
VAR_INT cs_mistyhead
VAR_INT cs_frankiehead
VAR_INT cs_mariahead

VAR_INT flag_failed_luigi1  //Don't remove

flag_failed_luigi1 = 0

VAR_INT cs_asuka
VAR_INT cs_kenji
VAR_INT cs_ray
VAR_INT cs_love
VAR_INT cs_phil
VAR_INT cs_yakuza //Yakuza goon to be standing at kenji's in cutscenes
VAR_INT cs_butler // Loves butler
VAR_INT cs_keeper

VAR_INT cs_asukahead
VAR_INT cs_kenjihead
VAR_INT cs_rayhead
VAR_INT cs_lovehead
VAR_INT cs_philhead
VAR_INT cs_butlerhead
VAR_INT cs_catalinahead
VAR_INT cs_miguelhead
VAR_INT cs_curlyhead
VAR_INT cs_keeperhead

VAR_INT cs_colub1 cs_colub2 cs_colub3 cs_colub4


// *****************************************CREATE PLAYER***************************************   

CREATE_PLAYER 0 811.90 -939.95 35.8 player //8Ball mission
SET_PLAYER_HEADING player 180.0
GET_PLAYER_CHAR player script_controlled_player
	 

// *****************************************Industrial Default Gangs****************************

SET_GANG_CAR_MODEL GANG_MAFIA CAR_MAFIA //The Mafia
SET_GANG_CAR_MODEL GANG_TRIAD CAR_BELLYUP //The Triads
SET_GANG_CAR_MODEL GANG_DIABLO CAR_DIABLOS //The Diablos

SET_GANG_WEAPONS GANG_MAFIA WEAPONTYPE_PISTOL WEAPONTYPE_PISTOL //The Mafia
SET_GANG_WEAPONS GANG_TRIAD WEAPONTYPE_PISTOL WEAPONTYPE_BASEBALLBAT //The Triads
SET_GANG_WEAPONS GANG_DIABLO WEAPONTYPE_BASEBALLBAT WEAPONTYPE_UNARMED //The Diablos

// *************************************Commercial Default Gangs****************************

SET_THREAT_FOR_PED_TYPE PEDTYPE_GANG_COLOMBIAN THREAT_PLAYER1	

SET_GANG_CAR_MODEL GANG_YAKUZA CAR_YAKUZA //The YAKUZA
SET_GANG_CAR_MODEL GANG_COLOMBIAN CAR_COLUMB //The COLUMBIANS
SET_GANG_CAR_MODEL GANG_YARDIE CAR_YARDIE //The YARDIES

SET_GANG_WEAPONS GANG_YAKUZA WEAPONTYPE_PISTOL WEAPONTYPE_UZI //The YAKUZA
SET_GANG_WEAPONS GANG_COLOMBIAN WEAPONTYPE_PISTOL WEAPONTYPE_UZI //The COLUMBIANS
SET_GANG_WEAPONS GANG_YARDIE WEAPONTYPE_BASEBALLBAT WEAPONTYPE_PISTOL //The YARDIES

// *************************************Suburban Default Gangs****************************

SET_GANG_CAR_MODEL GANG_HOOD CAR_HOODS //The HOODS

SET_GANG_WEAPONS GANG_HOOD WEAPONTYPE_UZI WEAPONTYPE_PISTOL //The HOODS

// **************************************Game variables*************************************

// Global variables for missions

VAR_INT flag_player_on_mission
VAR_INT flag_industrial_passed
VAR_INT flag_commercial_passed
VAR_INT flag_suburban_passed
 
flag_player_on_mission = 0
flag_industrial_passed = 0
flag_commercial_passed = 0
flag_suburban_passed = 0

// Radar Contact Blips

VAR_INT luigi_contact_blip 
VAR_INT joey_contact_blip
VAR_INT toni_contact_blip
VAR_INT frankie_contact_blip
VAR_INT diablo_contact_blip
VAR_INT asuka_contact_blip
VAR_INT kenji_contact_blip
VAR_INT ray_contact_blip
VAR_INT love_contact_blip
VAR_INT yardie_contact_blip
VAR_INT maria_contact_blip
VAR_INT eightball_contact_blip
VAR_INT hood_contact_blip
VAR_INT meat_contact_blip
VAR_INT industrail_save_blip commercial_save_blip suburban_save_blip
VAR_INT created_ind_blip_before	created_com_blip_before created_sub_blip_before

created_ind_blip_before = 0
created_com_blip_before	= 0
created_sub_blip_before	= 0

// Death Arrest Variables

VAR_INT flag_player_on_eightball_mission
VAR_INT flag_player_on_luigi_mission
VAR_INT flag_player_on_joey_mission
VAR_INT	flag_player_on_toni_mission
VAR_INT flag_player_on_frankie_mission
VAR_INT flag_player_on_diablo_mission
VAR_INT	flag_player_on_asuka_mission
VAR_INT	flag_player_on_kenji_mission
VAR_INT flag_player_on_love_mission
VAR_INT flag_player_on_yardie_mission
VAR_INT	flag_player_on_ray_mission
VAR_INT	flag_player_on_asuka_suburban_mission
VAR_INT flag_player_on_hood_mission
VAR_INT flag_player_on_meat_mission

flag_player_on_eightball_mission = 0
flag_player_on_luigi_mission = 0
flag_player_on_joey_mission = 0
flag_player_on_toni_mission = 0
flag_player_on_frankie_mission = 0
flag_player_on_diablo_mission = 0
flag_player_on_asuka_mission = 0
flag_player_on_kenji_mission = 0
flag_player_on_love_mission = 0
flag_player_on_yardie_mission = 0
flag_player_on_ray_mission = 0
flag_player_on_asuka_suburban_mission = 0
flag_player_on_hood_mission = 0
flag_player_on_meat_mission = 0

// Death Arrest Stuff

DECLARE_MISSION_FLAG flag_player_on_mission
DECLARE_MISSION_FLAG_FOR_CONTACT CONTACT_8BALL flag_player_on_eightball_mission
DECLARE_MISSION_FLAG_FOR_CONTACT CONTACT_LUIGI flag_player_on_luigi_mission
DECLARE_MISSION_FLAG_FOR_CONTACT CONTACT_JOEY flag_player_on_joey_mission
DECLARE_MISSION_FLAG_FOR_CONTACT CONTACT_TONI flag_player_on_toni_mission
DECLARE_MISSION_FLAG_FOR_CONTACT CONTACT_FRANKIE flag_player_on_frankie_mission
DECLARE_MISSION_FLAG_FOR_CONTACT CONTACT_HISPANIC flag_player_on_diablo_mission
DECLARE_MISSION_FLAG_FOR_CONTACT CONTACT_ASUKA flag_player_on_asuka_mission
DECLARE_MISSION_FLAG_FOR_CONTACT CONTACT_KENJI flag_player_on_kenji_mission
DECLARE_MISSION_FLAG_FOR_CONTACT CONTACT_LOVE flag_player_on_love_mission
DECLARE_MISSION_FLAG_FOR_CONTACT CONTACT_YARDIE flag_player_on_yardie_mission
DECLARE_MISSION_FLAG_FOR_CONTACT CONTACT_RAY flag_player_on_ray_mission
DECLARE_MISSION_FLAG_FOR_CONTACT CONTACT_ASUKA_SUBURBAN flag_player_on_asuka_suburban_mission
DECLARE_MISSION_FLAG_FOR_CONTACT CONTACT_HOODS flag_player_on_hood_mission
DECLARE_BASE_BRIEF_ID_FOR_CONTACT CONTACT_8BALL 1000
DECLARE_BASE_BRIEF_ID_FOR_CONTACT CONTACT_LUIGI 1000
DECLARE_BASE_BRIEF_ID_FOR_CONTACT CONTACT_JOEY 1000
DECLARE_BASE_BRIEF_ID_FOR_CONTACT CONTACT_TONI 1000
DECLARE_BASE_BRIEF_ID_FOR_CONTACT CONTACT_FRANKIE 1000
DECLARE_BASE_BRIEF_ID_FOR_CONTACT CONTACT_HISPANIC 1000
DECLARE_BASE_BRIEF_ID_FOR_CONTACT CONTACT_ASUKA 1000
DECLARE_BASE_BRIEF_ID_FOR_CONTACT CONTACT_KENJI 1000
DECLARE_BASE_BRIEF_ID_FOR_CONTACT CONTACT_LOVE 1000
DECLARE_BASE_BRIEF_ID_FOR_CONTACT CONTACT_YARDIE 1000
DECLARE_BASE_BRIEF_ID_FOR_CONTACT CONTACT_RAY 1000
DECLARE_BASE_BRIEF_ID_FOR_CONTACT CONTACT_ASUKA_SUBURBAN 1000
DECLARE_BASE_BRIEF_ID_FOR_CONTACT CONTACT_RAY_SUBURBAN 1000
DECLARE_BASE_BRIEF_ID_FOR_CONTACT CONTACT_HOODS 1000

// Death Arrest Setting

SET_DEATHARREST_STATE ON

// ***********************************Industrial Variables**********************************

// 8ball Missions

VAR_INT flag_eightball_mission_passed
VAR_INT flag_eightball_mission_launched
VAR_INT flag_eightball_switched_off

flag_eightball_mission_passed = 0
flag_eightball_mission_launched = 0
flag_eightball_switched_off = 0

// Luigi variables for missions

VAR_INT flag_luigi_mission1_passed
VAR_INT flag_luigi_mission2_passed
VAR_INT flag_luigi_mission3_passed
VAR_INT flag_luigi_mission4_passed
VAR_INT flag_luigi_mission5_passed					   
VAR_INT flag_all_luigi_missions_passed

flag_luigi_mission1_passed = 0
flag_luigi_mission2_passed = 0
flag_luigi_mission3_passed = 0
flag_luigi_mission4_passed = 0
flag_luigi_mission5_passed = 0
flag_all_luigi_missions_passed = 0


// Joey variables for missions

VAR_INT flag_joey_mission1_passed
VAR_INT flag_joey_mission2_passed
VAR_INT flag_joey_mission3_passed
VAR_INT flag_joey_mission4_passed
VAR_INT flag_joey_mission5_passed
VAR_INT flag_joey_mission6_passed					   
VAR_INT flag_all_joey_missions_passed

flag_joey_mission1_passed = 0
flag_joey_mission2_passed = 0
flag_joey_mission3_passed = 0
flag_joey_mission4_passed = 0
flag_joey_mission5_passed = 0
flag_joey_mission6_passed = 0
flag_all_joey_missions_passed = 0


// Toni variables for missions

VAR_INT flag_toni_mission1_passed
VAR_INT flag_toni_mission2_passed
VAR_INT flag_toni_mission3_passed
VAR_INT flag_toni_mission4_passed
VAR_INT flag_toni_mission5_passed					   
VAR_INT flag_all_toni_missions_passed

flag_toni_mission1_passed = 0
flag_toni_mission2_passed = 0
flag_toni_mission3_passed = 0
flag_toni_mission4_passed = 0
flag_toni_mission5_passed = 0
flag_all_toni_missions_passed = 0


// Frankie variables for missions

VAR_INT flag_frankie_mission1_passed
VAR_INT flag_frankie_mission2_passed
VAR_INT flag_frankie_mission2.1_passed
VAR_INT flag_frankie_mission3_passed
VAR_INT flag_frankie_mission4_passed					   
VAR_INT flag_frankie_switched_off
VAR_INT flag_all_frankie_missions_passed
VAR_INT flag_frankie_mission3_part2_launched
VAR_INT flag_player_had_cut1_fm3

flag_frankie_mission3_part2_launched = 0
flag_frankie_mission1_passed = 0
flag_frankie_mission2_passed = 0
flag_frankie_mission2.1_passed = 0
flag_frankie_mission3_passed = 0
flag_frankie_mission4_passed = 0
flag_frankie_switched_off = 0
flag_all_frankie_missions_passed = 0
flag_player_had_cut1_fm3 = 0

// Final Industrial Mission

VAR_INT flag_final_mission1_passed
VAR_INT flag_final_mission1_launched 

flag_final_mission1_passed = 0
flag_final_mission1_launched = 0

// Diablo Industrial Missions

VAR_INT flag_diablo_mission1_passed
VAR_INT flag_diablo_mission2_passed
VAR_INT flag_diablo_mission3_passed
VAR_INT flag_diablo_mission4_passed
VAR_INT flag_diablo_switched_off
VAR_INT flag_all_diablo_missions_passed
VAR_INT switch_gang_diablo_off
VAR_INT flag_diablo1_phone_message
VAR_INT flag_diablo2_phone_message
VAR_INT flag_diablo3_phone_message
VAR_INT flag_diablo4_phone_message

flag_diablo_mission1_passed = 0
flag_diablo_mission2_passed = 0
flag_diablo_mission3_passed = 0
flag_diablo_mission4_passed = 0
flag_diablo_switched_off = 0
flag_all_diablo_missions_passed = 0
flag_diablo1_phone_message = 0
flag_diablo2_phone_message = 0
flag_diablo3_phone_message = 0
flag_diablo4_phone_message = 0

// Dog Food Factory Mission

VAR_INT flag_meat_mission1_passed
VAR_INT flag_meat_mission2_passed
VAR_INT flag_meat_mission3_passed
VAR_INT flag_meat_mission4_passed
VAR_INT flag_meat_phone_ringing
VAR_INT flag_meat1_phone_message
VAR_INT flag_meat2_phone_message
VAR_INT flag_meat3_phone_message
VAR_INT flag_meat4_phone_message

flag_meat_mission1_passed = 0
flag_meat_mission2_passed = 0
flag_meat_mission3_passed = 0
flag_meat_mission4_passed = 0
flag_meat_phone_ringing = 0
flag_meat1_phone_message = 0
flag_meat2_phone_message = 0
flag_meat3_phone_message = 0
flag_meat4_phone_message = 0

// **************************Industrial phone Variables*************************************

VAR_INT Diablo_phone
VAR_INT blip_diablo_created_before 
VAR_INT	flag_diablo1_passed_before //So you can re-take the Diablo Race again

flag_diablo1_passed_before = 0 
blip_diablo_created_before = 0
GRAB_PHONE 937.9 -230.1 Diablo_phone

// Dog Food Phone
VAR_INT meat_phone

GRAB_PHONE 1224.46 -839.78 meat_phone

//--------------------YARDIE--------------------------------------------
VAR_INT yardie_phone pager_yardie_diplayed
VAR_INT blip_yardie_created_before

pager_yardie_diplayed = 0
GRAB_PHONE 120.0 -272.0 yardie_phone

//-------------------PAY DAY FOR RAY PHONES-----------------------------
VAR_INT Ray_phone1 Ray_phone2 Ray_phone3 Ray_phone4 //Ray_phone5 Ray_phone6 Ray_phone7 Ray_phone8 Ray_phone9  

GRAB_PHONE 229.1 -1537.6 Ray_phone1
GRAB_PHONE -53.5 -699.0 Ray_phone2
GRAB_PHONE 204.7 -135.1 Ray_phone3 
GRAB_PHONE 60.2 -964.8 Ray_phone4

// ********************************Suburban Phone Variables*********************************

VAR_INT hood_phone
VAR_INT flag_blip_hood_created
VAR_INT flag_hood1_phone_message
VAR_INT flag_hood2_phone_message
VAR_INT flag_hood3_phone_message
VAR_INT flag_hood4_phone_message
VAR_INT flag_hood5_phone_message

flag_blip_hood_created = 0
flag_hood1_phone_message = 0
flag_hood2_phone_message = 0
flag_hood3_phone_message = 0
flag_hood4_phone_message = 0
flag_hood5_phone_message = 0

GRAB_PHONE -443.5 -6.6 hood_phone

// ***********************************Commercial Variables**********************************

// Asuka variables for missions

VAR_INT flag_asuka_mission1_passed
VAR_INT flag_asuka_mission2_passed
VAR_INT flag_asuka_mission3_passed
VAR_INT flag_asuka_mission4_passed
VAR_INT flag_asuka_mission5_passed
VAR_INT flag_all_asuka_missions_passed

flag_asuka_mission1_passed = 0
flag_asuka_mission2_passed = 0
flag_asuka_mission3_passed = 0
flag_asuka_mission4_passed = 0
flag_asuka_mission5_passed = 0
flag_all_asuka_missions_passed = 0



// Ray variables for missions

VAR_INT flag_ray_mission1_passed
VAR_INT flag_ray_mission2_passed
VAR_INT flag_ray_mission3_passed
VAR_INT flag_ray_mission4_passed
VAR_INT flag_ray_mission5_passed
VAR_INT flag_ray_mission6_passed					   
VAR_INT flag_all_ray_missions_passed

flag_ray_mission1_passed = 0
flag_ray_mission2_passed = 0
flag_ray_mission3_passed = 0
flag_ray_mission4_passed = 0
flag_ray_mission5_passed = 0
flag_ray_mission6_passed = 0
flag_all_ray_missions_passed = 0


// Kenji variables for missions

VAR_INT flag_kenji_mission1_passed
VAR_INT flag_kenji_mission2_passed
VAR_INT flag_kenji_mission3_passed
VAR_INT flag_kenji_mission4_passed
VAR_INT flag_kenji_mission5_passed					   
VAR_INT flag_all_kenji_missions_passed

flag_kenji_mission1_passed = 0
flag_kenji_mission2_passed = 0
flag_kenji_mission3_passed = 0
flag_kenji_mission4_passed = 0
flag_kenji_mission5_passed = 0
flag_all_kenji_missions_passed = 0


// love variables for missions

VAR_INT flag_love_mission1_passed
VAR_INT flag_love_mission2_passed
VAR_INT flag_love_mission3_passed  
VAR_INT flag_love1_launched

flag_love1_launched = 0
flag_love_mission1_passed = 0
flag_love_mission2_passed = 0
flag_love_mission3_passed = 0

// Yardie Commercial Missions

VAR_INT flag_yardie_mission1_passed
VAR_INT flag_yardie_mission2_passed
VAR_INT flag_yardie_mission3_passed
VAR_INT flag_yardie_mission4_passed					   
VAR_INT flag_yardie_switched_off
VAR_INT flag_all_yardie_missions_passed
VAR_INT flag_yardie1_phone_message
VAR_INT flag_yardie2_phone_message
VAR_INT flag_yardie3_phone_message
VAR_INT flag_yardie4_phone_message

flag_yardie_mission1_passed = 0
flag_yardie_mission2_passed = 0
flag_yardie_mission3_passed = 0
flag_yardie_mission4_passed = 0
flag_yardie_switched_off = 0
flag_all_yardie_missions_passed = 0
flag_yardie1_phone_message = 0
flag_yardie2_phone_message = 0
flag_yardie3_phone_message = 0
flag_yardie4_phone_message = 0

// ***************************************Suburban Variables********************************

// Love Mission variables

VAR_INT flag_love_mission4_passed 
VAR_INT	flag_love_mission5_passed
VAR_INT	flag_love_mission6_passed
VAR_INT	flag_love_mission7_passed
VAR_INT flag_all_love_missions_passed

flag_love_mission4_passed = 0
flag_love_mission5_passed = 0
flag_love_mission6_passed = 0
flag_love_mission7_passed = 0
flag_all_love_missions_passed = 0

// Asuka Suburban variables for missions

VAR_INT flag_asuka_suburban_mission1_passed
VAR_INT flag_asuka_suburban_mission2_passed
VAR_INT flag_asuka_suburban_mission3_passed
VAR_INT flag_asuka_suburban_mission4_passed
VAR_INT flag_all_asuka_suburban_missions_passed

flag_asuka_suburban_mission1_passed = 0
flag_asuka_suburban_mission2_passed = 0
flag_asuka_suburban_mission3_passed = 0
flag_asuka_suburban_mission4_passed = 0
flag_all_asuka_suburban_missions_passed = 0


// Hood variables for missions

VAR_INT flag_hood_mission1_passed
VAR_INT flag_hood_mission2_passed
VAR_INT flag_hood_mission3_passed
VAR_INT flag_hood_mission4_passed
VAR_INT flag_hood_mission5_passed
VAR_INT flag_hood_switched_off
VAR_INT flag_all_hood_missions_passed
VAR_INT flag_done_drive_by_help 

flag_done_drive_by_help = 0
flag_hood_mission1_passed = 0
flag_hood_mission2_passed = 0
flag_hood_mission3_passed = 0
flag_hood_mission4_passed = 0
flag_hood_mission5_passed = 0
flag_hood_switched_off = 0
flag_all_hood_missions_passed = 0


//Final Strand variables

VAR_INT flag_player_on_cat_mission
VAR_INT flag_cat_mission1_passed
VAR_INT flag_cat_mission2_passed

flag_player_on_cat_mission = 0
flag_cat_mission1_passed = 0
flag_cat_mission2_passed = 0


// Odd job variables

VAR_INT	been_in_ambulance_before, flag_player_on_ambulance_mission // Ambulance Missions
VAR_INT	been_in_a_firetruk_before, flag_player_on_fire_mission // Fire Truck Missions
VAR_INT	been_in_a_copcar_before, flag_player_on_cop_mission	// Cop Car Missions
VAR_INT passed_usj_counter // Unique Stunt Jump Counter
VAR_INT got_siren_help_before

got_siren_help_before = 0
passed_usj_counter = 0

// 4x4/carpark Missions

VAR_INT	flag_4x4_mission1_passed flag_4x4_mission2_passed flag_4x4_mission3_passed flag_mayhem_mission1_passed
VAR_INT flag_4x4one_trigger flag_4x4two_trigger flag_4x4three_trigger flag_mayhem_trigger
VAR_INT record_4x4_one record_4x4_two record_4x4_three record_mayhem record_temp
VAR_INT flag_intro1_before flag_intro2_before flag_intro3_before flag_intro_mayhem_before

flag_intro1_before = 0
flag_intro2_before = 0
flag_intro3_before = 0
flag_intro_mayhem_before = 0

flag_4x4_mission1_passed = 0
flag_4x4_mission2_passed = 0
flag_4x4_mission3_passed = 0
flag_mayhem_mission1_passed = 0

flag_4x4one_trigger = 0
flag_4x4two_trigger = 0
flag_4x4three_trigger = 0
flag_mayhem_trigger	= 0


// Taxi mission

VAR_INT taxi_passed, been_in_a_taxi_before, flag_taxi1_mission_launched, been_in_taxi1_before, new_taxi_created_before 
VAR_INT spray_taxi done_taxi_help

flag_taxi1_mission_launched = 0
been_in_a_taxi_before = 0
been_in_taxi1_before = 0
taxi_passed = 0	
done_taxi_help = 0
new_taxi_created_before = 0


// RC Demolition

VAR_INT rec_rc1 rec_rc2 rec_rc3 rec_rc4 rec_rc5 rec_rc6
VAR_INT flag_just_done_rc_mission flag_rc1_passed flag_rc2_passed flag_rc3_passed flag_rc4_passed

flag_just_done_rc_mission = 0
rec_rc1 = 0
rec_rc2 = 0
rec_rc3 = 0
rec_rc4 = 0
rec_rc5 = 0
rec_rc6 = 0
flag_rc1_passed = 0
flag_rc2_passed	= 0
flag_rc3_passed	= 0
flag_rc4_passed	= 0

//OTHER STUFF

VAR_INT phils_guns_created_before 
VAR_INT started_buggy_generator_before
VAR_INT flag_joey_mission5_terminated flag_joey_mission6_terminated
VAR_INT	flag_luigi_mission4_terminated flag_luigi_mission5_terminated
VAR_INT the_scripts_started_again
VAR_INT	timer_help_message_displayed //TIMER HELP MESSAGE
VAR_INT	nicked_half_a_mil_before
VAR_INT flag_done_radio_8ball
VAR_INT van_once_a_day
VAR_INT breakout_timer breakout_timer_start breakout_diff
VAR_INT maria_exists barriers_been_added
VAR_INT door_crash_flag //Variables used to close Luigis Door in Asuka 1
VAR_FLOAT door_position_a1 
VAR_INT flag_bridge_created_8ball // Makes rubble on bridge
VAR_INT com_ammu_nation2 com_sprayshop2 ammu2_blip_added 

ammu2_blip_added = 0
flag_bridge_created_8ball = 0
flag_done_radio_8ball = 0
timer_help_message_displayed = 0
flag_joey_mission5_terminated = 0
flag_joey_mission6_terminated = 0
flag_luigi_mission4_terminated = 0
flag_luigi_mission5_terminated = 0
the_scripts_started_again = 0
phils_guns_created_before = 0
started_buggy_generator_before = 0
nicked_half_a_mil_before = 0
van_once_a_day = 0
breakout_timer = 0
breakout_timer_start = 0
breakout_diff = 0
maria_exists = 0
door_crash_flag = 0
door_position_a1 = 0.0
barriers_been_added = 0

// ********************************************Odd Jobs*************************************

START_NEW_SCRIPT t4x4_mission1_loop

START_NEW_SCRIPT t4x4_mission2_loop

START_NEW_SCRIPT t4x4_mission3_loop

START_NEW_SCRIPT multistorey_mission_loop

START_NEW_SCRIPT taxi_mission1_loop

START_NEW_SCRIPT fire_truck_mission_loop

START_NEW_SCRIPT ambulance_mission_loop

START_NEW_SCRIPT cop_mission_loop

START_NEW_SCRIPT rc_loop
	
LAUNCH_MISSION hj.sc

LAUNCH_MISSION usj.sc

LAUNCH_MISSION genstuf.sc

LAUNCH_MISSION rampage.sc

LAUNCH_MISSION import.sc

LAUNCH_MISSION camera.sc

LAUNCH_MISSION gates.sc

WAIT 0

// ********************************create and delete all the contact bips**************************

ADD_SPRITE_BLIP_FOR_CONTACT_POINT 892.8 -425.8 13.9 RADAR_SPRITE_LUIGI luigi_contact_blip
	REMOVE_BLIP	luigi_contact_blip
ADD_SPRITE_BLIP_FOR_CONTACT_POINT 1191.7 -870.0 -100.0 RADAR_SPRITE_JOEY joey_contact_blip
	REMOVE_BLIP	joey_contact_blip
ADD_SPRITE_BLIP_FOR_CONTACT_POINT 1219.6 -321.0 -100.0 RADAR_SPRITE_TONY toni_contact_blip
	REMOVE_BLIP toni_contact_blip
ADD_SPRITE_BLIP_FOR_CONTACT_POINT 1455.7 -187.3 -100.0 RADAR_SPRITE_SAL frankie_contact_blip
	REMOVE_BLIP	frankie_contact_blip
ADD_SPRITE_BLIP_FOR_CONTACT_POINT 1272.2 -92.9 -100.0 RADAR_SPRITE_EIGHT eightball_contact_blip
	REMOVE_BLIP	eightball_contact_blip
ADD_SPRITE_BLIP_FOR_CONTACT_POINT 938.4 -230.5 -100.0 RADAR_SPRITE_EL diablo_contact_blip
	REMOVE_BLIP	diablo_contact_blip

ADD_SPRITE_BLIP_FOR_CONTACT_POINT 523.6 -639.4 16.6 RADAR_SPRITE_ASUKA asuka_contact_blip
	REMOVE_BLIP	asuka_contact_blip
ADD_SPRITE_BLIP_FOR_CONTACT_POINT 459.1 -1413.0 26.1 RADAR_SPRITE_KENJI kenji_contact_blip
	REMOVE_BLIP	kenji_contact_blip
ADD_SPRITE_BLIP_FOR_CONTACT_POINT 38.8 -725.4 -100.0 RADAR_SPRITE_RAY ray_contact_blip
	REMOVE_BLIP	ray_contact_blip
ADD_SPRITE_BLIP_FOR_CONTACT_POINT 86.1 -1548.7 28.3 RADAR_SPRITE_DON love_contact_blip
	REMOVE_BLIP	love_contact_blip
ADD_SPRITE_BLIP_FOR_CONTACT_POINT 120.7 -272.1 16.1 RADAR_SPRITE_LIZ yardie_contact_blip
	REMOVE_BLIP	yardie_contact_blip

ADD_SPRITE_BLIP_FOR_CONTACT_POINT -363.7 246.1 60.0 RADAR_SPRITE_CAT maria_contact_blip
	REMOVE_BLIP	maria_contact_blip
ADD_SPRITE_BLIP_FOR_CONTACT_POINT -443.5 -6.1 3.8 RADAR_SPRITE_ICE hood_contact_blip
	REMOVE_BLIP	hood_contact_blip

ADD_SPRITE_BLIP_FOR_CONTACT_POINT 893.5 -306.1 -100.0 RADAR_SPRITE_SAVE industrail_save_blip
	REMOVE_BLIP	industrail_save_blip
ADD_SPRITE_BLIP_FOR_CONTACT_POINT 103.0 -484.2 -100.0 RADAR_SPRITE_SAVE commercial_save_blip
	REMOVE_BLIP	commercial_save_blip
ADD_SPRITE_BLIP_FOR_CONTACT_POINT -665.0 -6.5 -100.0 RADAR_SPRITE_SAVE suburban_save_blip
	REMOVE_BLIP	suburban_save_blip
ADD_SPRITE_BLIP_FOR_COORD 925.0 -359.5 -100.0 RADAR_SPRITE_SPRAY spray_taxi
	REMOVE_BLIP	spray_taxi

//Targettable objects

MAKE_OBJECT_TARGETTABLE target1
MAKE_OBJECT_TARGETTABLE target2
MAKE_OBJECT_TARGETTABLE target3

SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE 1027.26 -933.796 15.042 50.0 indhelix_barrier FALSE 
SWAP_NEAREST_BUILDING_MODEL 1027.26 -933.796 15.042 50.0 indhelix_barrier LOD_land014  

IF IS_PLAYER_PLAYING Player
	SET_PLAYER_CONTROL Player Off
ENDIF

SET_FADING_COLOUR 0 0 0

DO_FADE 0 FADE_OUT

//DEBUG SETUP*************************************************************************************
/*
SWITCH_WORLD_PROCESSING OFF //TEST!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! 
WAIT 1500 //TEST!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
SWITCH_WORLD_PROCESSING ON //TEST!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

LOAD_SCENE 916.3 -413.6 15.0  //START LUIGIS***************************************************************
flag_eightball_mission_passed = 1 //TEST SO SAVE HOUSE WORKS
IF IS_PLAYER_PLAYING player
	SET_INTRO_IS_PLAYING FALSE
	SET_TIME_OF_DAY 9 00
	SET_PLAYER_COORDINATES Player 916.3 -413.6 -100.0
	SET_PLAYER_HEADING player 140.0
	SET_CAMERA_BEHIND_PLAYER
	LAUNCH_MISSION debug.sc
	DO_FADE 1000 FADE_IN
	ADD_SCORE player 1000000
	
	//SWAP BRIDGE FROM FIXED TO DAMAGED
	SWAP_NEAREST_BUILDING_MODEL	525.362 -927.066 71.841	20.0 nbbridgcabls01 nbbridgfk2	
	SWAP_NEAREST_BUILDING_MODEL	706.432 -935.82  67.071	20.0 nbbridgcabls01 nbbridgfk2
	SWAP_NEAREST_BUILDING_MODEL	529.023 -920.098 43.504 20.0 nbbridgerdb damgbridgerdb 
	SWAP_NEAREST_BUILDING_MODEL	702.763 -939.963 38.736	20.0 nbbridgerdb damgbridgerdb 
	SWAP_NEAREST_BUILDING_MODEL	529.023 -942.94  43.504	20.0 nbbridgerda damgbbridgerda
	SWAP_NEAREST_BUILDING_MODEL	702.764 -919.963 38.736	20.0 nbbridgerda damgbbridgerda		

	SWAP_NEAREST_BUILDING_MODEL	525.362 -927.066 71.841	20.0 lodridgcabls01 lodridgfk2	
	SWAP_NEAREST_BUILDING_MODEL	706.432 -935.82  67.071	20.0 lodridgcabls01 lodridgfk2	
	SWAP_NEAREST_BUILDING_MODEL	521.146 -922.94  43.504 20.0 lodridgerdb lodgbridgerdb 
	SWAP_NEAREST_BUILDING_MODEL	702.763 -939.963 38.736	20.0 lodridgerdb lodgbridgerdb 
	SWAP_NEAREST_BUILDING_MODEL	529.023 -940.098 43.504	20.0 lodridgerda lodgbbridgerda	
	SWAP_NEAREST_BUILDING_MODEL	702.764 -919.963 38.736	20.0 lodridgerda lodgbbridgerda	
	
	GOSUB_FILE switch_car_generator switch.sc

	START_NEW_SCRIPT ind_save_loop
	START_NEW_SCRIPT sub_save_loop
	START_NEW_SCRIPT com_save_loop
	START_NEW_SCRIPT ind_restart
	START_NEW_SCRIPT com_restart
	START_NEW_SCRIPT sub_restart

	IF IS_PLAYER_PLAYING Player
		SET_PLAYER_CONTROL Player on
	ENDIF

	GOTO mission_start
ENDIF
*/

//FULL GAME LOAD***********************************************************************************************
LOAD_AND_LAUNCH_MISSION intro.sc

START_NEW_SCRIPT ind_save_loop
START_NEW_SCRIPT com_save_loop
START_NEW_SCRIPT sub_save_loop

START_NEW_SCRIPT ind_restart
START_NEW_SCRIPT com_restart
START_NEW_SCRIPT sub_restart

START_NEW_SCRIPT hospital_info_loop
START_NEW_SCRIPT police_info_loop

IF IS_PLAYER_PLAYING Player
	SET_PLAYER_CONTROL Player on
ENDIF

mission_start:

WAIT 1000

IF IS_PLAYER_PLAYING Player

//INDUSTRIAL BLOCK********************************************************************************************************

	IF IS_COLLISION_IN_MEMORY LEVEL_INDUSTRIAL 

		//HOSPITAL INFO PICKUPS
		IF flag_player_on_mission = 0
		AND heal_info_trip = 0
		AND flag_health_info = 0
			CREATE_PICKUP info PICKUP_ONCE 1144.2 -596.9 14.9 heal_info //hospital info cut
			heal_info_trip = 1
		ENDIF

		IF flag_player_on_mission = 1
		AND heal_info_trip = 1
			REMOVE_PICKUP heal_info //hospital info cut
			heal_info_trip = 0
		ENDIF

		//POLICE INFO PICKUPS
		IF flag_player_on_mission = 0
		AND wanted_info_trip = 0
		AND flag_wanted_info = 0
			CREATE_PICKUP info PICKUP_ONCE 1143.9 -675.2 15.0 wanted_info //police info cut
			wanted_info_trip = 1
		ENDIF

		IF flag_player_on_mission = 1
		AND wanted_info_trip = 1
			REMOVE_PICKUP wanted_info //police info cut
			wanted_info_trip = 0
		ENDIF
		/*
		IF IS_PLAYER_IN_ZONE Player LITTLEI
			IF are_objects_targettable = 0
				MAKE_OBJECT_TARGETTABLE target1
				MAKE_OBJECT_TARGETTABLE target2
				MAKE_OBJECT_TARGETTABLE target3
				are_objects_targettable = 1
			ENDIF
		ELSE
			IF are_objects_targettable = 1
				are_objects_targettable = 0
			ENDIF
		ENDIF
		*/
	ENDIF //IS_PLAYER_IN_ZONE	
	
ENDIF	//	IF IS_PLAYER_PLAYING Player

GOTO mission_start


//  ***********************wanted/health info************************************************


hospital_info_loop:
{
WAIT 0
 

IF IS_PLAYER_PLAYING player
	IF IS_PLAYER_IN_ZONE player S_VIEW
	AND flag_player_on_mission = 0
	AND heal_info_trip = 1
		IF HAS_PICKUP_BEEN_COLLECTED heal_info
			flag_player_on_mission = 1 // SCFIX
			SET_PLAYER_CONTROL player off
			WHILE GET_FADING_STATUS
				WAIT 0
			ENDWHILE
			LOAD_AND_LAUNCH_MISSION health.sc
			TERMINATE_THIS_SCRIPT
		ENDIF
	ENDIF
ENDIF
 
GOTO hospital_info_loop
} 
 
police_info_loop:
{
WAIT 0
 
IF IS_PLAYER_PLAYING player
	IF IS_PLAYER_IN_ZONE player S_VIEW
	AND flag_player_on_mission = 0
	AND wanted_info_trip = 1
		IF HAS_PICKUP_BEEN_COLLECTED wanted_info
			flag_player_on_mission = 1 // SCFIX
			SET_PLAYER_CONTROL player off
			WHILE GET_FADING_STATUS
				WAIT 0
			ENDWHILE
			LOAD_AND_LAUNCH_MISSION wanted.sc
			TERMINATE_THIS_SCRIPT
		ENDIF
	ENDIF
ENDIF
 
GOTO police_info_loop 
}

// *************************************RC Demolition****************************************

rc_loop:
{
	WAIT 0
	//SCRIPT_NAME rcloop
	IF IS_PLAYER_PLAYING player
	AND flag_just_done_rc_mission = 0
		IF IS_PLAYER_IN_MODEL player CAR_TOYZ
			IF flag_player_on_mission = 0
				IF LOCATE_PLAYER_ANY_MEANS_3D player 1014.0 -120.0 5.0 5.0 5.0 5.0 false
					flag_player_on_mission = 1 // SCFIX
					PRINT_BIG ( RC1 ) 15000 2
					WAIT 0
					LOAD_AND_LAUNCH_MISSION rc1.sc	//	this doesn't have a fade - maybe should always be loaded?
				ENDIF
				IF IS_PLAYER_PLAYING player
					IF LOCATE_PLAYER_ANY_MEANS_3D player 1158.0 -309.0 23.0 5.0 5.0 5.0 false
						flag_player_on_mission = 1 // SCFIX
						PRINT_BIG ( RC2 ) 15000 2
						WAIT 0
						LOAD_AND_LAUNCH_MISSION rc2.sc	//	this doesn't have a fade - maybe should always be loaded?
					ENDIF
				ENDIF
				IF IS_PLAYER_PLAYING player
					IF LOCATE_PLAYER_ANY_MEANS_3D player -636.0 65.0 19.0 5.0 5.0 5.0 false
						flag_player_on_mission = 1 // SCFIX
						PRINT_BIG ( RC4 ) 15000 2
						WAIT 0
						LOAD_AND_LAUNCH_MISSION rc3.sc	//	this doesn't have a fade - maybe should always be loaded?
					ENDIF
				ENDIF
				IF IS_PLAYER_PLAYING player
					IF LOCATE_PLAYER_ANY_MEANS_3D player 366.0 -1312.0 26.0 5.0 5.0 5.0 false
						flag_player_on_mission = 1 // SCFIX
						PRINT_BIG ( RC3 ) 15000 2
						WAIT 0
						LOAD_AND_LAUNCH_MISSION rc4.sc	//	this doesn't have a fade - maybe should always be loaded?
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF IS_PLAYER_PLAYING player
		IF NOT IS_PLAYER_IN_MODEL player CAR_TOYZ
			flag_just_done_rc_mission = 0
		ENDIF
	ENDIF

	GOTO rc_loop
}

// *******************************************4x4 Missions***********************************

t4x4_mission1_loop:
{
WAIT mission_trigger_wait_time

IF flag_4x4_mission1_passed = 0
	record_4x4_one = 300
ENDIF

IF IS_PLAYER_PLAYING player
	
	IF flag_player_on_mission = 0
	AND IS_PLAYER_IN_ZONE player S_VIEW
		
		IF IS_PLAYER_IN_MODEL player CAR_PATRIOT
		AND NOT IS_PLAYER_IN_AREA_2D player 1294.0 -656.0 1316.0 -638.0 false
			flag_4x4one_trigger = 1
		ENDIF
		 
		IF IS_PLAYER_IN_MODEL player CAR_PATRIOT
		AND flag_4x4one_trigger = 0
			flag_player_on_mission = 1 // SCFIX
			PRINT_BIG (T4X4_1) 15000 2
			WAIT 0
			LOAD_AND_LAUNCH_MISSION 4x4_1.sc	//	ask James about the fades in this one?
		ENDIF

		IF IS_PLAYER_PLAYING player
			IF NOT IS_PLAYER_IN_ANY_CAR player
				flag_4x4one_trigger = 0
			ENDIF
		ENDIF

	ENDIF

ENDIF

GOTO t4x4_mission1_loop
}

t4x4_mission2_loop:
{
WAIT mission_trigger_wait_time

IF flag_4x4_mission2_passed = 0
	record_4x4_two = 120
ENDIF

IF IS_PLAYER_PLAYING player

	IF flag_player_on_mission = 0
	AND IS_PLAYER_IN_ZONE player PARK

		IF IS_PLAYER_IN_MODEL player CAR_LANDSTALKER
		AND NOT IS_PLAYER_IN_AREA_2D player 58.0 -585.0 68.0 -595.0 false
			flag_4x4two_trigger = 1
		ENDIF
		 
		IF IS_PLAYER_IN_MODEL player CAR_LANDSTALKER
		AND flag_4x4two_trigger = 0
			flag_player_on_mission = 1 // SCFIX
			PRINT_BIG ( T4X4_2 ) 15000 2
			WAIT 0
			LOAD_AND_LAUNCH_MISSION 4x4_2.sc	//	ask James about the fades in this one?
		ENDIF

		IF IS_PLAYER_PLAYING player
			IF NOT IS_PLAYER_IN_ANY_CAR player
				flag_4x4two_trigger = 0
			ENDIF
		ENDIF

	ENDIF
ENDIF

GOTO t4x4_mission2_loop
}

t4x4_mission3_loop:
{
WAIT mission_trigger_wait_time

IF flag_4x4_mission3_passed = 0
	record_4x4_three = 300
ENDIF

IF IS_PLAYER_PLAYING player

	IF flag_player_on_mission = 0
	AND IS_PLAYER_IN_AREA_2D player -230.0 255.0 -210.0 275.0 false

		IF IS_PLAYER_IN_MODEL player CAR_PATRIOT
		AND NOT IS_PLAYER_IN_AREA_2D player -230.0 255.0 -210.0 275.0 false
			flag_4x4three_trigger = 1
		ENDIF
		 
		IF IS_PLAYER_IN_MODEL player CAR_PATRIOT
		AND flag_4x4three_trigger = 0
			flag_player_on_mission = 1 // SCFIX
			PRINT_BIG (T4X4_3) 15000 2
			WAIT 0
			LOAD_AND_LAUNCH_MISSION 4x4_3.sc	//	ask James about the fades in this one?
		ENDIF

		IF IS_PLAYER_PLAYING player
			IF NOT IS_PLAYER_IN_ANY_CAR player
				flag_4x4three_trigger = 0
			ENDIF
		ENDIF

	ENDIF

ENDIF
GOTO t4x4_mission3_loop
}


multistorey_mission_loop:
{
WAIT mission_trigger_wait_time

IF flag_mayhem_mission1_passed = 0
	record_mayhem = 120
ENDIF

IF IS_PLAYER_PLAYING player

	IF flag_player_on_mission = 0
	AND IS_PLAYER_IN_ZONE player COM_EAS

		IF IS_PLAYER_IN_MODEL player CAR_STALLION
		AND NOT LOCATE_PLAYER_IN_CAR_3D player 283.21 -566.47 25.9 3.0 3.0 2.0 FALSE // SCFIX: was AND NOT IS_PLAYER_IN_AREA_2D player 238.0 -612.0 267.0 -469.0 false
			flag_mayhem_trigger = 1
		ENDIF

		IF IS_PLAYER_IN_MODEL player CAR_STALLION
		AND flag_mayhem_trigger = 0
			flag_player_on_mission = 1 // SCFIX
			PRINT_BIG ( MM_1 ) 15000 2
			WAIT 0
			LOAD_AND_LAUNCH_MISSION mayhem1.sc	//	ask James about the fades in this one?
		ENDIF

		IF IS_PLAYER_PLAYING player
			IF NOT IS_PLAYER_IN_ANY_CAR player
				flag_mayhem_trigger = 0
			ENDIF
		ENDIF

	ENDIF
ENDIF
GOTO multistorey_mission_loop
}



// ********************************** Ambulance Mission **********************************
//
// Ambulance Mission


ambulance_mission_loop:
{
	WAIT 0
	
	IF IS_PLAYER_PLAYING player
		IF IS_PLAYER_IN_MODEL player CAR_AMBULANCE

			IF flag_player_on_mission = 0
			AND flag_player_on_ambulance_mission = 0

				GET_CONTROLLER_MODE controlmode
				IF been_in_ambulance_before = 0
					IF NOT controlmode = 3
						PRINT_HELP ( ATUTOR ) //Press RIGHTSHOCK to start
					ELSE
						PRINT_HELP ( ATUTOR3 ) //Press SQUARE to start
					ENDIF
					been_in_ambulance_before = 1
				ENDIF

				IF NOT controlmode = 3
					IF IS_BUTTON_PRESSED PAD1 RIGHTSHOCK
						WHILE IS_BUTTON_PRESSED PAD1 RIGHTSHOCK
							WAIT 0
							// SCFIX: START
							IF flag_player_on_mission = 1
								GOTO ambulance_mission_loop
							ENDIF
							// SCFIX: END
							IF NOT IS_PLAYER_PLAYING player
								GOTO ambulance_mission_loop
							ENDIF
						ENDWHILE

						flag_player_on_mission = 1 // SCFIX
						PRINT_BIG ( AMBUL_M ) 4000 5
						WAIT 0
						LOAD_AND_LAUNCH_MISSION ambulance.sc	//	this doesn't have a fade - maybe should always be loaded?
						been_in_ambulance_before = 1
					ENDIF
				ELSE
					IF IS_BUTTON_PRESSED PAD1 SQUARE
						WHILE IS_BUTTON_PRESSED PAD1 SQUARE
							WAIT 0
							// SCFIX: START
							IF flag_player_on_mission = 1
								GOTO ambulance_mission_loop
							ENDIF
							// SCFIX: END
							IF NOT IS_PLAYER_PLAYING player
								GOTO ambulance_mission_loop
							ENDIF
						ENDWHILE

						flag_player_on_mission = 1 // SCFIX
						PRINT_BIG ( AMBUL_M ) 4000 5
						WAIT 0
						LOAD_AND_LAUNCH_MISSION ambulance.sc	//	this doesn't have a fade - maybe should always be loaded?
						been_in_ambulance_before = 1
					ENDIF
				ENDIF
			ENDIF
		ELSE	// not in an ambulance
			IF been_in_ambulance_before = 1
				CLEAR_HELP
				been_in_ambulance_before = 0
			ENDIF
		ENDIF	//	IF IS_PLAYER_IN_MODEL player CAR_AMBULANCE
	ENDIF

	GOTO ambulance_mission_loop	
}


// ***************************************Fire Mission 1**********************************
//
// Fire Mission 1


fire_truck_mission_loop:
{
	WAIT 0

	IF IS_PLAYER_PLAYING player
		IF IS_PLAYER_IN_MODEL Player CAR_FIRETRUCK

			IF flag_player_on_mission = 0
			AND flag_player_on_fire_mission = 0

				GET_CONTROLLER_MODE controlmode
				IF been_in_a_firetruk_before = 0
					IF NOT controlmode = 3
						PRINT_HELP ( FTUTOR ) //Press RIGHTSHOCK to start
					ELSE
						PRINT_HELP ( FTUTOR2 ) //Press SQUARE to start
					ENDIF
					been_in_a_firetruk_before = 1
				ENDIF
				IF NOT controlmode = 3
					IF IS_BUTTON_PRESSED PAD1 RIGHTSHOCK
						WHILE IS_BUTTON_PRESSED PAD1 RIGHTSHOCK
							WAIT 0
							// SCFIX: START
							IF flag_player_on_mission = 1
								GOTO fire_truck_mission_loop
							ENDIF
							// SCFIX: END
							IF NOT IS_PLAYER_PLAYING player
								GOTO fire_truck_mission_loop
							ENDIF
						ENDWHILE

						flag_player_on_mission = 1 // SCFIX
						PRINT_BIG ( FIRE_M ) 4000 5
						WAIT 0
						LOAD_AND_LAUNCH_MISSION firetruck.sc	//	this doesn't have a fade - maybe should always be loaded?
						been_in_a_firetruk_before = 1
					ENDIF
				ELSE
					IF IS_BUTTON_PRESSED PAD1 SQUARE
						WHILE IS_BUTTON_PRESSED PAD1 SQUARE
							WAIT 0
							// SCFIX: START
							IF flag_player_on_mission = 1
								GOTO fire_truck_mission_loop
							ENDIF
							// SCFIX: END
							IF NOT IS_PLAYER_PLAYING player
								GOTO fire_truck_mission_loop
							ENDIF
						ENDWHILE

						flag_player_on_mission = 1 // SCFIX
						PRINT_BIG ( FIRE_M ) 4000 5
						WAIT 0
						LOAD_AND_LAUNCH_MISSION firetruck.sc	//	this doesn't have a fade - maybe should always be loaded?
						been_in_a_firetruk_before = 1
					ENDIF
				ENDIF
				
			ENDIF
		ELSE	//	not in a firetruck
			IF been_in_a_firetruk_before = 1
				CLEAR_HELP
				been_in_a_firetruk_before = 0
			ENDIF
		ENDIF	//	IF IS_PLAYER_IN_MODEL Player CAR_FIRETRUCK
	ENDIF

	GOTO fire_truck_mission_loop	
}


// ************************************** Cop Car Mission ***********************************
//
// Cop Car Mission


cop_mission_loop:
{
	WAIT 0

	IF IS_PLAYER_PLAYING player

		IF IS_PLAYER_IN_MODEL player CAR_POLICE
		OR IS_PLAYER_IN_MODEL player CAR_ENFORCER
		OR IS_PLAYER_IN_MODEL player CAR_RHINO
		OR IS_PLAYER_IN_MODEL player CAR_FBI
			IF flag_player_on_mission = 0
			AND flag_player_on_cop_mission = 0
				
				GET_CONTROLLER_MODE controlmode
				IF been_in_a_copcar_before = 0
					IF NOT controlmode = 3
						PRINT_HELP ( CTUTOR ) //Press RIGHTSHOCK to start
					ELSE
						PRINT_HELP ( CTUTOR2 ) //Press SQUARE to start
					ENDIF
					been_in_a_copcar_before = 1
				ENDIF

				IF NOT controlmode = 3
					IF IS_BUTTON_PRESSED PAD1 RIGHTSHOCK
						WHILE IS_BUTTON_PRESSED PAD1 RIGHTSHOCK
							WAIT 0
							// SCFIX: START
							IF flag_player_on_mission = 1
								GOTO cop_mission_loop
							ENDIF
							// SCFIX: END
							IF NOT IS_PLAYER_PLAYING player
								GOTO cop_mission_loop
							ENDIF
						ENDWHILE

						flag_player_on_mission = 1 // SCFIX
						PRINT_BIG ( COP_M ) 4000 5
						WAIT 0
						LOAD_AND_LAUNCH_MISSION copcar.sc	//	this doesn't have a fade - maybe should always be loaded?
						been_in_a_copcar_before = 1
					ENDIF
				ELSE
					IF IS_BUTTON_PRESSED PAD1 SQUARE
						WHILE IS_BUTTON_PRESSED PAD1 SQUARE
							WAIT 0
							// SCFIX: START
							IF flag_player_on_mission = 1
								GOTO cop_mission_loop
							ENDIF
							// SCFIX: END
							IF NOT IS_PLAYER_PLAYING player
								GOTO cop_mission_loop
							ENDIF
						ENDWHILE

						flag_player_on_mission = 1 // SCFIX
						PRINT_BIG ( COP_M ) 4000 5
						WAIT 0
						LOAD_AND_LAUNCH_MISSION copcar.sc	//	this doesn't have a fade - maybe should always be loaded?
						been_in_a_copcar_before = 1
					ENDIF
				ENDIF
				
			ENDIF
		ELSE	//	not in a copcar
			IF been_in_a_copcar_before = 1
				CLEAR_HELP
				been_in_a_copcar_before = 0
			ENDIF
		ENDIF // If in some kind of cop car
	ENDIF	

	GOTO cop_mission_loop	
}


// ***************************************Taxi Mission 1**********************************


// Taxi Mission 1


taxi_mission1_loop:
{

	WAIT 0

	IF IS_PLAYER_PLAYING player

		IF IS_PLAYER_IN_TAXI Player

			IF flag_player_on_mission = 0
			AND flag_taxi1_mission_launched = 0
				
				GET_CONTROLLER_MODE controlmode
				IF been_in_a_taxi_before = 0
					IF NOT controlmode = 3
						PRINT_HELP ( TTUTOR ) //Press RIGHTSHOCK to start
					ELSE
						PRINT_HELP ( TTUTOR2 ) //Press SQUARE to start
					ENDIF
					been_in_a_taxi_before = 1
				ENDIF
				IF NOT controlmode = 3
					IF IS_BUTTON_PRESSED PAD1 RIGHTSHOCK
						WHILE IS_BUTTON_PRESSED PAD1 RIGHTSHOCK
							WAIT 0
							// SCFIX: START
							IF flag_player_on_mission = 1
							OR flag_taxi1_mission_launched = 1
								GOTO taxi_mission1_loop
							ENDIF
							// SCFIX: END
							IF NOT IS_PLAYER_PLAYING player
							OR NOT IS_PLAYER_IN_TAXI player // SCFIX
								GOTO taxi_mission1_loop
							ENDIF
						ENDWHILE

						flag_player_on_mission = 1 // SCFIX
						PRINT_BIG ( TAXI_M ) 4000 5
						WAIT 0
						LOAD_AND_LAUNCH_MISSION taxi1.sc	//	this doesn't have a fade - maybe should always be loaded?
						flag_taxi1_mission_launched = 1
					ENDIF
				ELSE
					IF IS_BUTTON_PRESSED PAD1 SQUARE
						WHILE IS_BUTTON_PRESSED PAD1 SQUARE
							WAIT 0
							// SCFIX: START
							IF flag_player_on_mission = 1
							OR flag_taxi1_mission_launched = 1
								GOTO taxi_mission1_loop
							ENDIF
							// SCFIX: END
							IF NOT IS_PLAYER_PLAYING player
							OR NOT IS_PLAYER_IN_TAXI player // SCFIX
								GOTO taxi_mission1_loop
							ENDIF
						ENDWHILE

						flag_player_on_mission = 1 // SCFIX
						PRINT_BIG ( TAXI_M ) 4000 5
						WAIT 0
						LOAD_AND_LAUNCH_MISSION taxi1.sc	//	this doesn't have a fade - maybe should always be loaded?
						flag_taxi1_mission_launched = 1
					ENDIF
				ENDIF
				
			ENDIF
		ELSE	// not in a taxi
			IF been_in_a_taxi_before = 1
				CLEAR_HELP
				been_in_a_taxi_before = 0
			ENDIF
		ENDIF	// IF IS_PLAYER_IN_TAXI Player
	ENDIF 

GOTO taxi_mission1_loop
}



// *************************************Meat Factory Mission 1******************************

// Meat Factory Mission 1

meat_mission1_loop:
{

WAIT mission_trigger_wait_time


	IF flag_meat_mission1_passed = 1
		TURN_PHONE_OFF meat_phone
		//flag_diablo_phone_ringing = 0
		TERMINATE_THIS_SCRIPT
	ENDIF
	
	IF flag_player_on_mission = 0
		GET_TIME_OF_DAY hours minutes
		IF hours >= 9
		AND hours < 19
			TURN_PHONE_ON meat_phone
		ELSE
			TURN_PHONE_OFF meat_phone
		ENDIF 	
	ELSE
		TURN_PHONE_OFF meat_phone
	ENDIF
							
	IF IS_PLAYER_PLAYING player	
		IF LOCATE_STOPPED_PLAYER_ON_FOOT_3D	player 1224.6 -840.3 15.0 1.0 1.0 2.0 FALSE
			IF flag_player_on_mission = 0
				IF CAN_PLAYER_START_MISSION Player
					TURN_PHONE_OFF meat_phone
					GET_TIME_OF_DAY hours minutes
					IF hours >= 9
					AND hours < 19
						flag_player_on_mission = 1 // SCFIX

						MAKE_PLAYER_SAFE_FOR_CUTSCENE Player

						SET_FADING_COLOUR 0 0 0

						DO_FADE 1500 FADE_OUT

						PRINT_BIG ( MEA1 ) 15000 2 //"THE CROOK"	 

						WHILE GET_FADING_STATUS
							WAIT 0
						ENDWHILE

						LOAD_AND_LAUNCH_MISSION meat1.sc
					ENDIF
				ENDIF

				/* SCFIX: fix mission not starting if you jump onto the marker
				IF NOT IS_PLAYER_PLAYING player
					GOTO meat_mission1_loop
				ENDIF

				WHILE LOCATE_PLAYER_ON_FOOT_3D player 1224.6 -840.3 15.0 1.0 1.0 2.0 FALSE
					WAIT 0
						IF NOT IS_PLAYER_PLAYING player
							GOTO meat_mission1_loop
						ENDIF
				ENDWHILE
				*/
			ENDIF
		ENDIF
	ENDIF
			

	GOTO meat_mission1_loop

}

// Meat Factory Mission 2

meat_mission2_loop:
{

WAIT mission_trigger_wait_time


	IF flag_meat_mission2_passed = 1
		TURN_PHONE_OFF meat_phone
		TERMINATE_THIS_SCRIPT
	ENDIF
	
	IF flag_player_on_mission = 0
		GET_TIME_OF_DAY hours minutes
		IF hours >= 9
		AND hours < 19
			TURN_PHONE_ON meat_phone
		ELSE
			TURN_PHONE_OFF meat_phone
		ENDIF 	
	ELSE
		TURN_PHONE_OFF meat_phone
	ENDIF
			
	IF IS_PLAYER_PLAYING player	
		IF LOCATE_STOPPED_PLAYER_ON_FOOT_3D	player 1224.6 -840.3 15.0 1.0 1.0 2.0 FALSE
			IF flag_player_on_mission = 0
				IF CAN_PLAYER_START_MISSION Player
					TURN_PHONE_OFF meat_phone
					GET_TIME_OF_DAY hours minutes
					IF hours >= 9
					AND hours < 19
						flag_player_on_mission = 1 // SCFIX

						MAKE_PLAYER_SAFE_FOR_CUTSCENE Player

						SET_FADING_COLOUR 0 0 0

						DO_FADE 1500 FADE_OUT

						PRINT_BIG ( MEA2 ) 15000 2 //"THE THIEVES"

						WHILE GET_FADING_STATUS
							WAIT 0
						ENDWHILE

						LOAD_AND_LAUNCH_MISSION meat2.sc
					ENDIF
				ENDIF

				/* SCFIX: fix mission not starting if you jump onto the marker
				IF NOT IS_PLAYER_PLAYING player
					GOTO meat_mission2_loop
				ENDIF

				WHILE LOCATE_PLAYER_ON_FOOT_3D player 1224.6 -840.3 15.0 1.0 1.0 2.0 FALSE
					WAIT 0
						IF NOT IS_PLAYER_PLAYING player
							GOTO meat_mission2_loop
						ENDIF
				ENDWHILE
				*/
			ENDIF
		ENDIF
	ENDIF
			

	GOTO meat_mission2_loop

}

// Meat Factory Mission 3

meat_mission3_loop:
{

WAIT mission_trigger_wait_time


	IF flag_meat_mission3_passed = 1
		TURN_PHONE_OFF meat_phone
		TERMINATE_THIS_SCRIPT
	ENDIF
	
	IF flag_player_on_mission = 0
		GET_TIME_OF_DAY hours minutes
		IF hours >= 9
		AND hours < 19
			TURN_PHONE_ON meat_phone
		ELSE
			TURN_PHONE_OFF meat_phone
		ENDIF 	
	ELSE
		TURN_PHONE_OFF meat_phone
	ENDIF
			
	IF IS_PLAYER_PLAYING player	
		IF LOCATE_STOPPED_PLAYER_ON_FOOT_3D	player 1224.6 -840.3 15.0 1.0 1.0 2.0 FALSE
			IF flag_player_on_mission = 0
				IF CAN_PLAYER_START_MISSION Player
					TURN_PHONE_OFF meat_phone
					GET_TIME_OF_DAY hours minutes
					IF hours >= 9
					AND hours < 19
						flag_player_on_mission = 1 // SCFIX

						MAKE_PLAYER_SAFE_FOR_CUTSCENE Player

						SET_FADING_COLOUR 0 0 0

						DO_FADE 1500 FADE_OUT

						PRINT_BIG ( MEA3 ) 15000 2 //"THE WIFE"	

						WHILE GET_FADING_STATUS
							WAIT 0
						ENDWHILE

						LOAD_AND_LAUNCH_MISSION meat3.sc
					ENDIF
				ENDIF

				/* SCFIX: fix mission not starting if you jump onto the marker
				IF NOT IS_PLAYER_PLAYING player
					GOTO meat_mission3_loop
				ENDIF

				WHILE LOCATE_PLAYER_ON_FOOT_3D player 1224.6 -840.3 15.0 1.0 1.0 2.0 FALSE
					WAIT 0
						IF NOT IS_PLAYER_PLAYING player
							GOTO meat_mission3_loop
						ENDIF
				ENDWHILE
				*/
			ENDIF
		ENDIF
	ENDIF
			

	GOTO meat_mission3_loop

}

// Meat Factory Mission 4

meat_mission4_loop:
{

WAIT mission_trigger_wait_time


	IF flag_meat_mission4_passed = 1
		TURN_PHONE_OFF meat_phone
		TERMINATE_THIS_SCRIPT
	ENDIF
	
	IF flag_player_on_mission = 0
		GET_TIME_OF_DAY hours minutes
		IF hours >= 9
		AND hours < 19
			TURN_PHONE_ON meat_phone
		ELSE
			TURN_PHONE_OFF meat_phone
		ENDIF 	
	ELSE
		TURN_PHONE_OFF meat_phone
	ENDIF
			
	IF IS_PLAYER_PLAYING player	
		IF LOCATE_STOPPED_PLAYER_ON_FOOT_3D	player 1224.6 -840.3 15.0 1.0 1.0 2.0 FALSE
			IF flag_player_on_mission = 0
				IF CAN_PLAYER_START_MISSION Player
					TURN_PHONE_OFF meat_phone
					GET_TIME_OF_DAY hours minutes
					IF hours >= 9
					AND hours < 19
						flag_player_on_mission = 1 // SCFIX

						MAKE_PLAYER_SAFE_FOR_CUTSCENE Player

						SET_FADING_COLOUR 0 0 0

						DO_FADE 1500 FADE_OUT

						PRINT_BIG ( MEA4 ) 15000 2 //"HER LOVER"

						WHILE GET_FADING_STATUS
							WAIT 0
						ENDWHILE

						LOAD_AND_LAUNCH_MISSION meat4.sc
					ENDIF
				ENDIF

				/* SCFIX: fix mission not starting if you jump onto the marker
				IF NOT IS_PLAYER_PLAYING player
					GOTO meat_mission4_loop
				ENDIF

				WHILE LOCATE_PLAYER_ON_FOOT_3D player 1224.6 -840.3 15.0 1.0 1.0 2.0 FALSE
					WAIT 0
						IF NOT IS_PLAYER_PLAYING player
							GOTO meat_mission4_loop
						ENDIF
				ENDWHILE
				*/
			ENDIF
		ENDIF
	ENDIF
			

	GOTO meat_mission4_loop

}


// ***************************************Industrial Level**********************************

// ******************************************8Ball Mission**********************************

// 8Ball Mission


eightball_mission_loop:
{

WAIT 0

IF flag_industrial_passed = 1
AND flag_eightball_mission_passed = 0
	TERMINATE_THIS_SCRIPT
ENDIF

	IF flag_eightball_mission_passed = 1
		TERMINATE_THIS_SCRIPT
	ENDIF

	IF IS_PLAYER_PLAYING player
	AND flag_eightball_mission_launched = 0
	AND flag_player_on_mission = 0
		IF flag_reached_hideout = 0								    
			//IF LOCATE_PLAYER_ON_FOOT_2D player 811.90 -939.95 3.5 3.5 FALSE // SCFIX: commented
				IF CAN_PLAYER_START_MISSION Player
					flag_player_on_mission = 1 // SCFIX
					LOAD_AND_LAUNCH_MISSION 8ball.sc	//	Don't know what to do about fades with this one
					flag_eightball_mission_launched = 1
				ENDIF
			//ENDIF // SCFIX: commented
		ELSE
			//IF LOCATE_PLAYER_ON_FOOT_2D player 883.5 -308.2 3.5 3.5 FALSE  // SCFIX: commented
				IF CAN_PLAYER_START_MISSION Player
					flag_player_on_mission = 1 // SCFIX
					LOAD_AND_LAUNCH_MISSION 8ball.sc	//	Don't know what to do about fades with this one
					flag_eightball_mission_launched = 1
				ENDIF
			//ENDIF // SCFIX: commented
		ENDIF 
	ENDIF
   
GOTO eightball_mission_loop

}



// *******************************************Luigi Missions********************************

// Luigi Mission 2

luigi_mission2_loop:
{

WAIT mission_trigger_wait_time

IF flag_industrial_passed = 1
AND flag_luigi_mission2_passed = 0
	TERMINATE_THIS_SCRIPT
ENDIF

	IF flag_luigi_mission2_passed = 1
		TERMINATE_THIS_SCRIPT
	ENDIF
	
	IF IS_PLAYER_PLAYING player
		IF LOCATE_PLAYER_ON_FOOT_3D Player 892.8 -425.8 13.9 1.5 2.0 2.0 FALSE
			IF flag_player_on_mission = 0
				IF CAN_PLAYER_START_MISSION Player
					flag_player_on_mission = 1 // SCFIX

					MAKE_PLAYER_SAFE_FOR_CUTSCENE player

					SET_FADING_COLOUR 0 0 0

					DO_FADE 1500 FADE_OUT

					SWITCH_STREAMING OFF

					PRINT_BIG ( LM2 ) 15000 2 //"Don'a SPANK ma bitch up"

					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE

					LOAD_AND_LAUNCH_MISSION luigi2.sc
				ENDIF

				/* SCFIX: fix mission not starting if you jump onto the marker
				IF NOT IS_PLAYER_PLAYING player
					GOTO luigi_mission2_loop
				ENDIF

				WHILE LOCATE_PLAYER_ON_FOOT_3D Player 892.8 -425.8 13.9 1.5 2.0 2.0 FALSE
					WAIT 0
					IF NOT IS_PLAYER_PLAYING player
						GOTO luigi_mission2_loop
					ENDIF
				ENDWHILE
				*/
			ENDIF
		ENDIF
	ENDIF
	

	GOTO luigi_mission2_loop

}



// Luigi Mission 3

luigi_mission3_loop:
{

WAIT mission_trigger_wait_time

IF flag_industrial_passed = 1
AND flag_luigi_mission3_passed = 0
	TERMINATE_THIS_SCRIPT
ENDIF


	IF flag_luigi_mission3_passed = 1
		TERMINATE_THIS_SCRIPT
	ENDIF

	IF IS_PLAYER_PLAYING player
		IF LOCATE_PLAYER_ON_FOOT_3D Player 892.8 -425.8 13.9 1.5 2.0 2.0 FALSE
			IF flag_player_on_mission = 0
				IF CAN_PLAYER_START_MISSION Player
					flag_player_on_mission = 1 // SCFIX

					MAKE_PLAYER_SAFE_FOR_CUTSCENE player

					SET_FADING_COLOUR 0 0 0

					DO_FADE 1500 FADE_OUT

					SWITCH_STREAMING OFF

					PRINT_BIG ( LM3 ) 15000 2 //"Drive Misty For Me."

					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE

					LOAD_AND_LAUNCH_MISSION luigi3.sc
				ENDIF

				/* SCFIX: fix mission not starting if you jump onto the marker
				IF NOT IS_PLAYER_PLAYING player
					GOTO luigi_mission3_loop
				ENDIF

				WHILE LOCATE_PLAYER_ON_FOOT_3D Player 892.8 -425.8 13.9 1.5 2.0 2.0 FALSE
					WAIT 0
					IF NOT IS_PLAYER_PLAYING player
						GOTO luigi_mission3_loop
					ENDIF
				ENDWHILE
				*/
			ENDIF
		ENDIF
	ENDIF
	
	GOTO luigi_mission3_loop

}


// Luigi Mission 4

luigi_mission4_loop:
{

WAIT mission_trigger_wait_time

IF flag_industrial_passed = 1
AND flag_luigi_mission4_passed = 0
	TERMINATE_THIS_SCRIPT
ENDIF

	IF flag_luigi_mission4_passed = 1
		TERMINATE_THIS_SCRIPT
	ENDIF

	IF flag_toni_mission3_passed = 1
	AND flag_frankie_mission1_passed = 0
		flag_luigi_mission4_terminated = 1
		TERMINATE_THIS_SCRIPT
	ENDIF

	IF IS_PLAYER_PLAYING player
		IF LOCATE_PLAYER_ON_FOOT_3D Player 892.8 -425.8 13.9 1.5 2.0 2.0 FALSE
			IF flag_player_on_mission = 0
				IF CAN_PLAYER_START_MISSION Player
					flag_player_on_mission = 1 // SCFIX

					MAKE_PLAYER_SAFE_FOR_CUTSCENE player

					SET_FADING_COLOUR 0 0 0

					DO_FADE 1500 FADE_OUT

					SWITCH_STREAMING OFF

					PRINT_BIG ( LM4 ) 15000 2 //"Pump Action Pimp"

					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE

					LOAD_AND_LAUNCH_MISSION luigi4.sc
				ENDIF

				/* SCFIX: fix mission not starting if you jump onto the marker
				IF NOT IS_PLAYER_PLAYING player
					GOTO luigi_mission4_loop
				ENDIF

				WHILE LOCATE_PLAYER_ON_FOOT_3D Player 892.8 -425.8 13.9 1.5 2.0 2.0 FALSE
					WAIT 0
					IF NOT IS_PLAYER_PLAYING player
						GOTO luigi_mission4_loop
					ENDIF
				ENDWHILE
				*/
			ENDIF
		ENDIF
	ENDIF

	

	GOTO luigi_mission4_loop

}


// Luigi Mission 5

luigi_mission5_loop:
{

WAIT mission_trigger_wait_time

IF flag_industrial_passed = 1
AND flag_luigi_mission5_passed = 0
	TERMINATE_THIS_SCRIPT
ENDIF


	IF flag_luigi_mission5_passed = 1
		TERMINATE_THIS_SCRIPT
	ENDIF

	IF flag_toni_mission3_passed = 1
	AND flag_frankie_mission1_passed = 0
		flag_luigi_mission5_terminated = 1
		TERMINATE_THIS_SCRIPT
	ENDIF

	IF IS_PLAYER_PLAYING player
		IF LOCATE_PLAYER_ON_FOOT_3D Player 892.8 -425.8 13.9 1.5 2.0 2.0 FALSE
			IF flag_player_on_mission = 0
				IF CAN_PLAYER_START_MISSION Player
					flag_player_on_mission = 1 // SCFIX

					MAKE_PLAYER_SAFE_FOR_CUTSCENE player

					SET_FADING_COLOUR 0 0 0

					DO_FADE 1500 FADE_OUT

					SWITCH_STREAMING OFF

					PRINT_BIG ( LM5 ) 15000 2 //"Fuzz Ball"

					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE

					LOAD_AND_LAUNCH_MISSION luigi5.sc
				ENDIF

				/* SCFIX: fix mission not starting if you jump onto the marker
				IF NOT IS_PLAYER_PLAYING player
					GOTO luigi_mission5_loop
				ENDIF

				WHILE LOCATE_PLAYER_ON_FOOT_3D Player 892.8 -425.8 13.9 1.5 2.0 2.0 FALSE
					WAIT 0
					IF NOT IS_PLAYER_PLAYING player
						GOTO luigi_mission5_loop
					ENDIF
				ENDWHILE
				*/
			ENDIF
		ENDIF
	ENDIF
	
	
	GOTO luigi_mission5_loop

}

// ***************************************Joey Missions*************************************


// Joey Mission 1

joey_mission1_loop:
{

WAIT mission_trigger_wait_time

IF flag_industrial_passed = 1
AND flag_joey_mission1_passed = 0
	TERMINATE_THIS_SCRIPT
ENDIF

	IF flag_joey_mission1_passed = 1
		TERMINATE_THIS_SCRIPT
	ENDIF

	IF IS_PLAYER_PLAYING player
		IF LOCATE_PLAYER_ON_FOOT_3D Player 1191.7 -870.0 15.0 1.0 1.0 2.0 FALSE
			IF flag_player_on_mission = 0
				GET_TIME_OF_DAY hours minutes
				IF hours >= 5
				AND hours < 21
					IF CAN_PLAYER_START_MISSION Player
						flag_player_on_mission = 1 // SCFIX

						MAKE_PLAYER_SAFE_FOR_CUTSCENE Player

						SET_FADING_COLOUR 0 0 0

						DO_FADE 1500 FADE_OUT

						SWITCH_STREAMING OFF

						PRINT_BIG ( JM1 ) 15000 2 //"Joey Mission 1"

						WHILE GET_FADING_STATUS
							WAIT 0
						ENDWHILE
						LOAD_AND_LAUNCH_MISSION joey1.sc
					ENDIF

					/* SCFIX: fix mission not starting if you jump onto the marker
					IF NOT IS_PLAYER_PLAYING player
						GOTO joey_mission1_loop
					ENDIF

					WHILE LOCATE_PLAYER_ON_FOOT_3D Player 1191.7 -870.0 15.0 1.0 1.0 2.0 FALSE
						WAIT 0
						IF NOT IS_PLAYER_PLAYING player
							GOTO joey_mission1_loop
						ENDIF
					ENDWHILE
					*/
				ELSE
					PRINT_NOW ( WRONGT1 ) 5000 1 //" Wrong Time!"
					WHILE LOCATE_PLAYER_ON_FOOT_3D Player 1191.7 -870.0 15.0 1.0 1.0 2.0 FALSE
						WAIT 0
						IF NOT IS_PLAYER_PLAYING player
							GOTO joey_mission1_loop
						ENDIF

						GET_TIME_OF_DAY hours minutes
						IF hours >= 5
						AND hours < 21
							GOTO joey_mission1_loop
						ENDIF

					ENDWHILE
				ENDIF
			ENDIF
		ENDIF
	ENDIF
			
	GOTO joey_mission1_loop

}

// Joey Mission 2

joey_mission2_loop:
{

WAIT mission_trigger_wait_time

IF flag_industrial_passed = 1
AND flag_joey_mission2_passed = 0
	TERMINATE_THIS_SCRIPT
ENDIF

	IF flag_joey_mission2_passed = 1
		TERMINATE_THIS_SCRIPT
	ENDIF

	IF IS_PLAYER_PLAYING player
		IF LOCATE_PLAYER_ON_FOOT_3D Player 1191.7 -870.0 15.0 1.0 1.0 2.0 FALSE
			IF flag_player_on_mission = 0
				IF CAN_PLAYER_START_MISSION Player
					flag_player_on_mission = 1 // SCFIX

					MAKE_PLAYER_SAFE_FOR_CUTSCENE Player

					SET_FADING_COLOUR 0 0 0

					DO_FADE 1500 FADE_OUT

					SWITCH_STREAMING OFF

					PRINT_BIG ( JM2 ) 15000 2 //"Joey Mission 2"

					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE

					LOAD_AND_LAUNCH_MISSION joey2.sc
				ENDIF

				/* SCFIX: fix mission not starting if you jump onto the marker
				IF NOT IS_PLAYER_PLAYING player
					GOTO joey_mission2_loop
				ENDIF

				WHILE LOCATE_PLAYER_ON_FOOT_3D Player 1191.7 -870.0 15.0 1.0 1.0 2.0 FALSE
					WAIT 0
					IF NOT IS_PLAYER_PLAYING player
						GOTO joey_mission2_loop
					ENDIF
				ENDWHILE
				*/
			ENDIF
		ENDIF
	ENDIF
			
	GOTO joey_mission2_loop

}



// Joey Mission 3

joey_mission3_loop:
{

WAIT mission_trigger_wait_time

IF flag_industrial_passed = 1
AND flag_joey_mission3_passed = 0
	TERMINATE_THIS_SCRIPT
ENDIF

	IF flag_joey_mission3_passed = 1
		TERMINATE_THIS_SCRIPT
	ENDIF

	IF IS_PLAYER_PLAYING player
		IF LOCATE_PLAYER_ON_FOOT_3D Player 1191.7 -870.0 15.0 1.0 1.0 2.0 FALSE
			IF flag_player_on_mission = 0
				IF CAN_PLAYER_START_MISSION Player
					flag_player_on_mission = 1 // SCFIX

					MAKE_PLAYER_SAFE_FOR_CUTSCENE Player

					SET_FADING_COLOUR 0 0 0

					DO_FADE 1500 FADE_OUT

					SWITCH_STREAMING OFF

					PRINT_BIG ( JM3 ) 15000 2 //"Joey Mission 3"

					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE

					LOAD_AND_LAUNCH_MISSION joey3.sc
				ENDIF

				/* SCFIX: fix mission not starting if you jump onto the marker
				IF NOT IS_PLAYER_PLAYING player
					GOTO joey_mission3_loop
				ENDIF

				WHILE LOCATE_PLAYER_ON_FOOT_3D Player 1191.7 -870.0 15.0 1.0 1.0 2.0 FALSE
					WAIT 0
					IF NOT IS_PLAYER_PLAYING player
						GOTO joey_mission3_loop
					ENDIF
				ENDWHILE
				*/
			ENDIF
		ENDIF
	ENDIF
			
	GOTO joey_mission3_loop

}



// Joey Mission 4

joey_mission4_loop:
{

WAIT mission_trigger_wait_time

IF flag_industrial_passed = 1
AND flag_joey_mission4_passed = 0
	TERMINATE_THIS_SCRIPT
ENDIF

	IF flag_joey_mission4_passed = 1
		TERMINATE_THIS_SCRIPT
	ENDIF

	IF IS_PLAYER_PLAYING player
		IF LOCATE_PLAYER_ON_FOOT_3D Player 1191.7 -870.0 15.0 1.0 1.0 2.0 FALSE
			IF flag_player_on_mission = 0
				IF CAN_PLAYER_START_MISSION Player
					flag_player_on_mission = 1 // SCFIX

					MAKE_PLAYER_SAFE_FOR_CUTSCENE Player

					SET_FADING_COLOUR 0 0 0

					DO_FADE 1500 FADE_OUT

					SWITCH_STREAMING OFF

					PRINT_BIG ( JM4 ) 15000 2 //"Joey Mission 4!"

					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE

					LOAD_AND_LAUNCH_MISSION joey4.sc
				ENDIF

				/* SCFIX: fix mission not starting if you jump onto the marker
				IF NOT IS_PLAYER_PLAYING player
					GOTO joey_mission4_loop
				ENDIF

				WHILE LOCATE_PLAYER_ON_FOOT_3D Player 1191.7 -870.0 15.0 1.0 1.0 2.0 FALSE
					WAIT 0
					IF NOT IS_PLAYER_PLAYING player
						GOTO joey_mission4_loop
					ENDIF
				ENDWHILE
				*/
			ENDIF
		ENDIF
	ENDIF
	
	GOTO joey_mission4_loop

}


// Joey Mission 5

joey_mission5_loop:
{

WAIT mission_trigger_wait_time

IF flag_industrial_passed = 1
AND flag_joey_mission5_passed = 0
	TERMINATE_THIS_SCRIPT
ENDIF

	IF flag_joey_mission5_passed = 1
		TERMINATE_THIS_SCRIPT
	ENDIF

	IF flag_toni_mission3_passed = 1
	AND flag_frankie_mission1_passed = 0
		flag_joey_mission5_terminated = 1
		TERMINATE_THIS_SCRIPT
	ENDIF

	IF IS_PLAYER_PLAYING player
		IF LOCATE_PLAYER_ON_FOOT_3D Player 1191.7 -870.0 15.0 1.0 1.0 2.0 FALSE
			IF flag_player_on_mission = 0
				IF CAN_PLAYER_START_MISSION Player
					flag_player_on_mission = 1 // SCFIX

					MAKE_PLAYER_SAFE_FOR_CUTSCENE Player

					SET_FADING_COLOUR 0 0 0

					DO_FADE 1500 FADE_OUT

					SWITCH_STREAMING OFF

					PRINT_BIG ( JM5 ) 15000 2 //"Joey Mission 5"

					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE

					LOAD_AND_LAUNCH_MISSION joey5.sc
				ENDIF

				/* SCFIX: fix mission not starting if you jump onto the marker
				IF NOT IS_PLAYER_PLAYING player
					GOTO joey_mission5_loop
				ENDIF

				WHILE LOCATE_PLAYER_ON_FOOT_3D Player 1191.7 -870.0 15.0 1.0 1.0 2.0 FALSE
					WAIT 0
					IF NOT IS_PLAYER_PLAYING player
						GOTO joey_mission5_loop
					ENDIF
				ENDWHILE
				*/
			ENDIF
		ENDIF
	ENDIF
	
	GOTO joey_mission5_loop

}


// Joey Mission 6

joey_mission6_loop:
{

WAIT mission_trigger_wait_time

IF flag_industrial_passed = 1
AND flag_joey_mission6_passed = 0
	TERMINATE_THIS_SCRIPT
ENDIF

	IF flag_joey_mission6_passed = 1
		TERMINATE_THIS_SCRIPT
	ENDIF

	IF flag_toni_mission3_passed = 1
	AND flag_frankie_mission1_passed = 0
		flag_joey_mission6_terminated = 1
		TERMINATE_THIS_SCRIPT
	ENDIF 

	IF IS_PLAYER_PLAYING player
		IF LOCATE_PLAYER_ON_FOOT_3D Player 1191.7 -870.0 15.0 1.0 1.0 2.0 FALSE
			IF flag_player_on_mission = 0
				GET_TIME_OF_DAY hours minutes
				IF hours >= 6
				AND hours < 14
					IF CAN_PLAYER_START_MISSION Player
						flag_player_on_mission = 1 // SCFIX

						MAKE_PLAYER_SAFE_FOR_CUTSCENE Player

						SET_FADING_COLOUR 0 0 0

						DO_FADE 1500 FADE_OUT

						SWITCH_STREAMING OFF

						PRINT_BIG ( JM6 ) 15000 2 //"Joey Mission 6"

						WHILE GET_FADING_STATUS
							WAIT 0
						ENDWHILE

						LOAD_AND_LAUNCH_MISSION joey6.sc
					ENDIF

					/* SCFIX: fix mission not starting if you jump onto the marker
					IF NOT IS_PLAYER_PLAYING player
						GOTO joey_mission6_loop
					ENDIF

					WHILE LOCATE_PLAYER_ON_FOOT_3D Player 1191.7 -870.0 15.0 1.0 1.0 2.0 FALSE
						WAIT 0
						IF NOT IS_PLAYER_PLAYING player
							GOTO joey_mission6_loop
						ENDIF
					ENDWHILE				
					*/
				ELSE
					PRINT_NOW ( WRONGT2 ) 5000 1 //" Wrong Time!"
					WHILE LOCATE_PLAYER_ON_FOOT_3D Player 1191.7 -870.0 15.0 1.0 1.0 2.0 FALSE
						WAIT 0
						IF NOT IS_PLAYER_PLAYING player
							GOTO joey_mission6_loop
						ENDIF

						GET_TIME_OF_DAY hours minutes
						IF hours >= 6
						AND hours < 14
							GOTO joey_mission6_loop
						ENDIF

					ENDWHILE
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	GOTO joey_mission6_loop

}

// ********************************************Toni Missions********************************

// Toni Mission 1

toni_mission1_loop:
{

WAIT mission_trigger_wait_time

IF flag_industrial_passed = 1
AND flag_toni_mission1_passed = 0
	TERMINATE_THIS_SCRIPT
ENDIF

	IF flag_toni_mission1_passed = 1
		TERMINATE_THIS_SCRIPT
	ENDIF

	IF IS_PLAYER_PLAYING player
		IF LOCATE_PLAYER_ON_FOOT_3D Player 1219.8 -319.7 27.4 1.0 2.0 2.0 FALSE
			IF flag_player_on_mission = 0
				IF CAN_PLAYER_START_MISSION Player
					flag_player_on_mission = 1 // SCFIX

					MAKE_PLAYER_SAFE_FOR_CUTSCENE Player

					SET_FADING_COLOUR 0 0 0

					DO_FADE 1500 FADE_OUT

					SWITCH_STREAMING OFF

					PRINT_BIG ( TM1 ) 15000 2 //"Toni Mission 1"	 

					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE

					LOAD_AND_LAUNCH_MISSION toni1.sc
				ENDIF

				/* SCFIX: fix mission not starting if you jump onto the marker
				IF NOT IS_PLAYER_PLAYING player
					GOTO toni_mission1_loop
				ENDIF

				WHILE LOCATE_PLAYER_ON_FOOT_3D Player 1219.8 -319.7 27.4 1.0 2.0 2.0 FALSE
					WAIT 0
					IF NOT IS_PLAYER_PLAYING player
						GOTO toni_mission1_loop
					ENDIF
				ENDWHILE
				*/
			ENDIF
		ENDIF
	ENDIF
	
	GOTO toni_mission1_loop

}


// Toni Mission 2

toni_mission2_loop:
{

WAIT mission_trigger_wait_time

IF flag_industrial_passed = 1
AND flag_toni_mission2_passed = 0
	TERMINATE_THIS_SCRIPT
ENDIF

	IF flag_toni_mission2_passed = 1
		TERMINATE_THIS_SCRIPT
	ENDIF

	IF IS_PLAYER_PLAYING player
		IF LOCATE_PLAYER_ON_FOOT_3D Player 1219.8 -319.7 27.4 1.0 2.0 2.0 FALSE
			IF flag_player_on_mission = 0
				IF CAN_PLAYER_START_MISSION Player
					flag_player_on_mission = 1 // SCFIX

					MAKE_PLAYER_SAFE_FOR_CUTSCENE Player

					SET_FADING_COLOUR 0 0 0

					DO_FADE 1500 FADE_OUT

					SWITCH_STREAMING OFF

					PRINT_BIG ( TM2 ) 15000 2 //"Toni Mission 2"	 

					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE

					LOAD_AND_LAUNCH_MISSION toni2.sc
				ENDIF

				/* SCFIX: fix mission not starting if you jump onto the marker
				IF NOT IS_PLAYER_PLAYING player
					GOTO toni_mission2_loop
				ENDIF

				WHILE LOCATE_PLAYER_ON_FOOT_3D Player 1219.8 -319.7 27.4 1.0 2.0 2.0 FALSE
					WAIT 0
					IF NOT IS_PLAYER_PLAYING player
						GOTO toni_mission2_loop
					ENDIF
				ENDWHILE
				*/
			ENDIF
		ENDIF
	ENDIF
	
	GOTO toni_mission2_loop

}


// Toni Mission 3

toni_mission3_loop:
{

WAIT mission_trigger_wait_time

IF flag_industrial_passed = 1
AND flag_toni_mission3_passed = 0
	TERMINATE_THIS_SCRIPT
ENDIF

	IF flag_toni_mission3_passed = 1
		TERMINATE_THIS_SCRIPT
	ENDIF

	IF IS_PLAYER_PLAYING player
		IF LOCATE_PLAYER_ON_FOOT_3D Player 1219.8 -319.7 27.4 1.0 2.0 2.0 FALSE
			IF flag_player_on_mission = 0
				IF CAN_PLAYER_START_MISSION Player
					flag_player_on_mission = 1 // SCFIX

					MAKE_PLAYER_SAFE_FOR_CUTSCENE Player

					SET_FADING_COLOUR 0 0 0

					DO_FADE 1500 FADE_OUT

					SWITCH_STREAMING OFF

					PRINT_BIG ( TM3 ) 15000 2 //"Toni Mission 3"

					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE

					LOAD_AND_LAUNCH_MISSION toni3.sc
				ENDIF

				/* SCFIX: fix mission not starting if you jump onto the marker
				IF NOT IS_PLAYER_PLAYING player
					GOTO toni_mission3_loop
				ENDIF

				WHILE LOCATE_PLAYER_ON_FOOT_3D Player 1219.8 -319.7 27.4 1.0 2.0 2.0 FALSE
					WAIT 0
					IF NOT IS_PLAYER_PLAYING player
						GOTO toni_mission3_loop
					ENDIF
				ENDWHILE
				*/
			ENDIF
		ENDIF
	ENDIF
		
	GOTO toni_mission3_loop

}



// Toni Mission 4

toni_mission4_loop:
{

WAIT mission_trigger_wait_time

IF flag_industrial_passed = 1
AND flag_toni_mission4_passed = 0
	TERMINATE_THIS_SCRIPT
ENDIF

	IF flag_toni_mission4_passed = 1
		TERMINATE_THIS_SCRIPT
	ENDIF	

	IF IS_PLAYER_PLAYING player
		IF LOCATE_PLAYER_ON_FOOT_3D Player 1219.8 -319.7 27.4 1.0 2.0 2.0 FALSE
			IF flag_player_on_mission = 0
				IF CAN_PLAYER_START_MISSION Player
					flag_player_on_mission = 1 // SCFIX

					MAKE_PLAYER_SAFE_FOR_CUTSCENE Player

					SET_FADING_COLOUR 0 0 0

					DO_FADE 1500 FADE_OUT

					SWITCH_STREAMING OFF

					PRINT_BIG ( TM4 ) 15000 2 //"Toni Mission 4"

					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE

					LOAD_AND_LAUNCH_MISSION toni4.sc
				ENDIF

				/* SCFIX: fix mission not starting if you jump onto the marker
				IF NOT IS_PLAYER_PLAYING player
					GOTO toni_mission4_loop
				ENDIF

				WHILE LOCATE_PLAYER_ON_FOOT_3D Player 1219.8 -319.7 27.4 1.0 2.0 2.0 FALSE
					WAIT 0
					IF NOT IS_PLAYER_PLAYING player
						GOTO toni_mission4_loop
					ENDIF
				ENDWHILE
				*/
			ENDIF
		ENDIF
	ENDIF

	GOTO toni_mission4_loop

}

// Toni Mission 5

toni_mission5_loop:
{

WAIT mission_trigger_wait_time

IF flag_industrial_passed = 1
AND flag_toni_mission5_passed = 0
	TERMINATE_THIS_SCRIPT
ENDIF

	IF flag_toni_mission5_passed = 1
		TERMINATE_THIS_SCRIPT
	ENDIF

	IF IS_PLAYER_PLAYING player
		IF LOCATE_PLAYER_ON_FOOT_3D Player 1219.8 -319.7 27.4 1.0 2.0 2.0 FALSE
			IF flag_player_on_mission = 0
				IF CAN_PLAYER_START_MISSION Player
					flag_player_on_mission = 1 // SCFIX

					MAKE_PLAYER_SAFE_FOR_CUTSCENE Player

					SET_FADING_COLOUR 0 0 0

					DO_FADE 1500 FADE_OUT

					SWITCH_STREAMING OFF

					PRINT_BIG ( TM5 ) 15000 2 //"Toni Mission 5"

					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE

					LOAD_AND_LAUNCH_MISSION toni5.sc
				ENDIF

				/* SCFIX: fix mission not starting if you jump onto the marker
				IF NOT IS_PLAYER_PLAYING player
					GOTO toni_mission5_loop
				ENDIF

				WHILE LOCATE_PLAYER_ON_FOOT_3D Player 1219.8 -319.7 27.4 1.0 2.0 2.0 FALSE
					WAIT 0
					IF NOT IS_PLAYER_PLAYING player
						GOTO toni_mission5_loop
					ENDIF
				ENDWHILE
				*/
			ENDIF
		ENDIF
	ENDIF
	
	GOTO toni_mission5_loop

}



// ***************************************Frankie Missions**********************************



// Frankie Mission 1

frankie_mission1_loop:
{

WAIT mission_trigger_wait_time

IF flag_industrial_passed = 1
AND flag_frankie_mission1_passed = 0
	TERMINATE_THIS_SCRIPT
ENDIF

	IF flag_frankie_mission1_passed = 1
		TERMINATE_THIS_SCRIPT
	ENDIF

	IF IS_PLAYER_PLAYING player			   
		IF LOCATE_PLAYER_ON_FOOT_3D Player 1455.7 -187.3 55.6 1.0 1.0 2.0 FALSE
		OR IS_PLAYER_IN_ANGLED_AREA_ON_FOOT_3D player 1466.2 -175.0 50.0 1452.9 -172.1 60.0 11.6 FALSE
			IF flag_frankie_switched_off = 0
			AND flag_player_on_mission = 0
				IF CAN_PLAYER_START_MISSION Player
					flag_player_on_mission = 1 // SCFIX

					MAKE_PLAYER_SAFE_FOR_CUTSCENE player

					SET_FADING_COLOUR 0 0 0

					DO_FADE 1500 FADE_OUT

					SWITCH_STREAMING OFF

					PRINT_BIG FM1 15000 2 //"Pulp Friction"

					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE

					LOAD_AND_LAUNCH_MISSION frank1.sc
				ENDIF

				/* SCFIX: fix mission not starting if you jump onto the marker
				IF NOT IS_PLAYER_PLAYING player
					GOTO frankie_mission1_loop
				ENDIF

				WHILE LOCATE_PLAYER_ON_FOOT_3D Player 1455.7 -187.3 55.6 1.0 1.0 2.0 FALSE
					WAIT 0
					IF NOT IS_PLAYER_PLAYING player
						GOTO frankie_mission1_loop
					ENDIF
				ENDWHILE
				*/
			ENDIF
		ENDIF
	ENDIF
		
	GOTO frankie_mission1_loop

}



// Frankie Mission 2

frankie_mission2_loop:
{

WAIT mission_trigger_wait_time

IF flag_industrial_passed = 1
AND flag_frankie_mission2_passed = 0
	TERMINATE_THIS_SCRIPT
ENDIF

	IF flag_frankie_mission2_passed = 1
		TERMINATE_THIS_SCRIPT
	ENDIF
	
	IF IS_PLAYER_PLAYING player
		IF LOCATE_PLAYER_ON_FOOT_3D Player 1455.7 -187.3 55.6 1.0 1.0 2.0 FALSE
		OR IS_PLAYER_IN_ANGLED_AREA_ON_FOOT_3D player 1466.2 -175.0 50.0 1452.9 -172.1 60.0 11.6 FALSE
			IF flag_frankie_switched_off = 0
			AND flag_player_on_mission = 0
				IF CAN_PLAYER_START_MISSION Player
					flag_player_on_mission = 1 // SCFIX

					MAKE_PLAYER_SAFE_FOR_CUTSCENE player

					SET_FADING_COLOUR 0 0 0

					DO_FADE 1500 FADE_OUT

					SWITCH_STREAMING OFF

					PRINT_BIG ( FM2 ) 15000 2 //"Cuttin' The Grass"

					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE

					LOAD_AND_LAUNCH_MISSION frank2.sc
				ENDIF

				/* SCFIX: fix mission not starting if you jump onto the marker
				IF NOT IS_PLAYER_PLAYING player
					GOTO frankie_mission2_loop
				ENDIF

				WHILE LOCATE_PLAYER_ON_FOOT_3D Player 1455.7 -187.3 55.6 1.0 1.0 2.0 FALSE
					WAIT 0
					IF NOT IS_PLAYER_PLAYING player
						GOTO frankie_mission2_loop
					ENDIF
				ENDWHILE
				*/
			ENDIF
		ENDIF
	ENDIF
	
	GOTO frankie_mission2_loop

}


// Frankie Mission 2.1

frankie_mission2.1_loop:
{

WAIT mission_trigger_wait_time

IF flag_industrial_passed = 1
AND flag_frankie_mission2.1_passed = 0
	TERMINATE_THIS_SCRIPT
ENDIF

	IF flag_frankie_mission2.1_passed = 1
		TERMINATE_THIS_SCRIPT
	ENDIF
	
	IF IS_PLAYER_PLAYING player
		IF LOCATE_PLAYER_ON_FOOT_3D Player 1455.7 -187.3 55.6 1.0 1.0 2.0 FALSE
		OR IS_PLAYER_IN_ANGLED_AREA_ON_FOOT_3D player 1466.2 -175.0 50.0 1452.9 -172.1 60.0 11.6 FALSE
			IF flag_frankie_switched_off = 0
				IF flag_player_on_mission = 0
					IF CAN_PLAYER_START_MISSION Player
						flag_player_on_mission = 1 // SCFIX

						MAKE_PLAYER_SAFE_FOR_CUTSCENE player

						SET_FADING_COLOUR 0 0 0

						DO_FADE 1500 FADE_OUT

						SWITCH_STREAMING OFF

						PRINT_BIG ( FM21 ) 15000 2 //"Bomb Da Base Part 1"

						WHILE GET_FADING_STATUS
							WAIT 0
						ENDWHILE

						LOAD_AND_LAUNCH_MISSION frank2.1.sc
					ENDIF

					/* SCFIX: fix mission not starting if you jump onto the marker
					IF NOT IS_PLAYER_PLAYING player
						GOTO frankie_mission2.1_loop
					ENDIF

					WHILE LOCATE_PLAYER_ON_FOOT_3D Player 1455.7 -187.3 55.6 1.0 1.0 2.0 FALSE
						WAIT 0
						IF NOT IS_PLAYER_PLAYING player
							GOTO frankie_mission2.1_loop
						ENDIF
					ENDWHILE
					*/
				ENDIF
			ELSE
				PRINT_NOW ( FRANGO ) 5000 1 //"Frankie is not available at this time!"
				WHILE LOCATE_PLAYER_ON_FOOT_3D Player 1455.7 -187.3 55.6 1.0 1.0 2.0 FALSE
					WAIT 0
					IF NOT IS_PLAYER_PLAYING player
						GOTO frankie_mission2.1_loop
					ENDIF
				ENDWHILE
			ENDIF
		ENDIF
	ENDIF
	
	GOTO frankie_mission2.1_loop

}


// Frankie Mission 3 Starts at 8balls garage

frankie_mission3_loop:
{

WAIT mission_trigger_wait_time

IF flag_industrial_passed = 1
AND flag_frankie_mission3_passed = 0
	TERMINATE_THIS_SCRIPT
ENDIF

	IF flag_frankie_mission3_passed = 1
		TERMINATE_THIS_SCRIPT
	ENDIF

	IF flag_frankie_mission3_part2_launched = 1
		TERMINATE_THIS_SCRIPT
	ENDIF
	 												
	IF IS_PLAYER_PLAYING player
		IF LOCATE_PLAYER_ON_FOOT_3D	player 1272.2 -92.9 13.8 1.0 1.0 2.0 FALSE
			IF flag_eightball_switched_off = 0
			AND flag_player_on_mission = 0
				IF CAN_PLAYER_START_MISSION Player
					flag_player_on_mission = 1 // SCFIX

					MAKE_PLAYER_SAFE_FOR_CUTSCENE player

					SET_FADING_COLOUR 0 0 0

					DO_FADE 1500 FADE_OUT

					SWITCH_STREAMING OFF

					PRINT_BIG ( FM3 ) 15000 2 //"Bomb Da Base"

					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE

					LOAD_AND_LAUNCH_MISSION frank3.sc
				ENDIF

				/* SCFIX: fix mission not starting if you jump onto the marker
				IF NOT IS_PLAYER_PLAYING player
					GOTO frankie_mission3_loop
				ENDIF

				WHILE LOCATE_PLAYER_ON_FOOT_3D player 1272.2 -92.9 13.8 1.0 1.0 2.0 FALSE
					WAIT 0
					IF NOT IS_PLAYER_PLAYING player
						GOTO frankie_mission3_loop
					ENDIF
				ENDWHILE
				*/
			ENDIF
		ENDIF
	ENDIF
		
	GOTO frankie_mission3_loop

}


// Frankie Mission 4

frankie_mission4_loop:
{

WAIT mission_trigger_wait_time

IF flag_industrial_passed = 1
AND flag_frankie_mission4_passed = 0
	TERMINATE_THIS_SCRIPT
ENDIF

	IF flag_frankie_mission4_passed = 1
		TERMINATE_THIS_SCRIPT
	ENDIF

	IF IS_PLAYER_PLAYING player
		IF LOCATE_PLAYER_ON_FOOT_3D Player 1455.7 -187.3 55.6 1.0 1.0 2.0 FALSE
		OR IS_PLAYER_IN_ANGLED_AREA_ON_FOOT_3D player 1466.2 -175.0 50.0 1452.9 -172.1 60.0 11.6 FALSE
			IF flag_frankie_switched_off = 0
			AND flag_player_on_mission = 0
				IF CAN_PLAYER_START_MISSION Player
					flag_player_on_mission = 1 // SCFIX

					MAKE_PLAYER_SAFE_FOR_CUTSCENE Player

					SET_FADING_COLOUR 0 0 0

					DO_FADE 1500 FADE_OUT

					SWITCH_STREAMING OFF

					PRINT_BIG ( FM4 ) 15000 2 //"Frankie Mission 4"	 

					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE

					LOAD_AND_LAUNCH_MISSION frank4.sc
				ENDIF

				/* SCFIX: fix mission not starting if you jump onto the marker
				IF NOT IS_PLAYER_PLAYING player
					GOTO frankie_mission4_loop
				ENDIF

				WHILE LOCATE_PLAYER_ON_FOOT_3D Player 1455.7 -187.3 55.6 1.0 1.0 2.0 FALSE
					WAIT 0
					IF NOT IS_PLAYER_PLAYING player
						GOTO frankie_mission4_loop
					ENDIF
				ENDWHILE
				*/
			ENDIF
		ENDIF
	ENDIF
		
	GOTO frankie_mission4_loop

}


// *****************************************Diablo Missions*******************************


// Diablo Mission 1

diablo_mission1_loop:
{

WAIT mission_trigger_wait_time

IF flag_diablo_mission1_passed = 1
	TURN_PHONE_OFF diablo_phone
	TERMINATE_THIS_SCRIPT
ENDIF
	
	IF flag_player_on_mission = 0
	   TURN_PHONE_ON diablo_phone
	ELSE
		TURN_PHONE_OFF diablo_phone
	ENDIF
			
	IF IS_PLAYER_PLAYING player			   
		IF LOCATE_STOPPED_PLAYER_ON_FOOT_3D	player 938.4 -230.5 3.9 1.0 1.0 2.0 FALSE
			IF flag_player_on_mission = 0
				IF CAN_PLAYER_START_MISSION Player
					flag_player_on_mission = 1 // SCFIX
					TURN_PHONE_OFF diablo_phone

					MAKE_PLAYER_SAFE_FOR_CUTSCENE Player

					SET_FADING_COLOUR 0 0 0

					DO_FADE 1500 FADE_OUT

					PRINT_BIG ( DIAB1 ) 15000 2 //"Diablo Mission 1"

					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE

					LOAD_AND_LAUNCH_MISSION diablo1.sc
				ENDIF

				/* SCFIX: fix mission not starting if you jump onto the marker
				IF NOT IS_PLAYER_PLAYING player
					GOTO diablo_mission1_loop
				ENDIF

				WHILE LOCATE_PLAYER_ON_FOOT_3D player 938.4 -230.5 3.9 1.0 1.0 2.0 FALSE
					WAIT 0
						IF NOT IS_PLAYER_PLAYING player
							GOTO diablo_mission1_loop
						ENDIF
				ENDWHILE
				*/
			ENDIF
		ENDIF
	ENDIF
			
	GOTO diablo_mission1_loop

}


// Diablo Mission 2

diablo_mission2_loop:
{

WAIT mission_trigger_wait_time

	IF flag_diablo_mission2_passed = 1
		TURN_PHONE_OFF diablo_phone
		TERMINATE_THIS_SCRIPT
	ENDIF
	
	IF flag_player_on_mission = 0
	   TURN_PHONE_ON diablo_phone
	ELSE
		TURN_PHONE_OFF diablo_phone
	ENDIF
			
	IF IS_PLAYER_PLAYING player	
		IF LOCATE_STOPPED_PLAYER_ON_FOOT_3D	player 938.4 -230.5 3.9 1.0 1.0 2.0 FALSE
			IF flag_player_on_mission = 0
				IF CAN_PLAYER_START_MISSION Player
					flag_player_on_mission = 1 // SCFIX
					TURN_PHONE_OFF diablo_phone

					MAKE_PLAYER_SAFE_FOR_CUTSCENE Player

					SET_FADING_COLOUR 0 0 0

					DO_FADE 1500 FADE_OUT

					PRINT_BIG ( DIAB2 ) 15000 2 //"Diablo Mission 2"	 

					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE

					LOAD_AND_LAUNCH_MISSION diablo2.sc
				ENDIF

				/* SCFIX: fix mission not starting if you jump onto the marker
				IF NOT IS_PLAYER_PLAYING player
					GOTO diablo_mission2_loop
				ENDIF

				WHILE LOCATE_PLAYER_ON_FOOT_3D player 938.4 -230.5 3.9 1.0 1.0 2.0 FALSE
					WAIT 0
						IF NOT IS_PLAYER_PLAYING player
							GOTO diablo_mission2_loop
						ENDIF
				ENDWHILE
				*/
			ENDIF
		ENDIF
	ENDIF
			
 	GOTO diablo_mission2_loop

}



// Diablo Mission 3

diablo_mission3_loop:
{

WAIT mission_trigger_wait_time

	IF flag_diablo_mission3_passed = 1
		TURN_PHONE_OFF diablo_phone
		TERMINATE_THIS_SCRIPT
	ENDIF
	
	IF flag_player_on_mission = 0
	   TURN_PHONE_ON diablo_phone
	ELSE
		TURN_PHONE_OFF diablo_phone
	ENDIF
			
	IF IS_PLAYER_PLAYING player	
		IF LOCATE_STOPPED_PLAYER_ON_FOOT_3D	player 938.4 -230.5 3.9 1.0 1.0 2.0 FALSE
			IF flag_player_on_mission = 0
				IF CAN_PLAYER_START_MISSION Player
					flag_player_on_mission = 1 // SCFIX
					TURN_PHONE_OFF diablo_phone

					MAKE_PLAYER_SAFE_FOR_CUTSCENE Player

					SET_FADING_COLOUR 0 0 0

					DO_FADE 1500 FADE_OUT

					PRINT_BIG ( DIAB3 ) 15000 2 //"Diablo Mission 3"	 

					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE

					LOAD_AND_LAUNCH_MISSION diablo3.sc
				ENDIF

				/* SCFIX: fix mission not starting if you jump onto the marker
				IF NOT IS_PLAYER_PLAYING player
					GOTO diablo_mission3_loop
				ENDIF

				WHILE LOCATE_PLAYER_ON_FOOT_3D player 938.4 -230.5 3.9 1.0 1.0 2.0 FALSE
					WAIT 0
						IF NOT IS_PLAYER_PLAYING player
							GOTO diablo_mission3_loop
						ENDIF
				ENDWHILE
				*/
			ENDIF
		ENDIF
	ENDIF	

	GOTO diablo_mission3_loop

}


// Diablo Mission 4

diablo_mission4_loop:
{

WAIT mission_trigger_wait_time

	IF flag_diablo_mission4_passed = 1
		TURN_PHONE_OFF diablo_phone
		TERMINATE_THIS_SCRIPT
	ENDIF
	
	IF flag_player_on_mission = 0
	   TURN_PHONE_ON diablo_phone
	ELSE
		TURN_PHONE_OFF diablo_phone
	ENDIF
		
	IF IS_PLAYER_PLAYING player	
		IF LOCATE_STOPPED_PLAYER_ON_FOOT_3D	player 938.4 -230.5 3.9 1.0 1.0 2.0 FALSE
			IF flag_player_on_mission = 0
				IF CAN_PLAYER_START_MISSION Player
					flag_player_on_mission = 1 // SCFIX
					TURN_PHONE_OFF diablo_phone

					MAKE_PLAYER_SAFE_FOR_CUTSCENE Player

					SET_FADING_COLOUR 0 0 0

					DO_FADE 1500 FADE_OUT

					PRINT_BIG ( DIAB4 ) 15000 2 //"Diablo Mission 4"

					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE

					LOAD_AND_LAUNCH_MISSION diablo4.sc
				ENDIF

				/* SCFIX: fix mission not starting if you jump onto the marker
				IF NOT IS_PLAYER_PLAYING player
					GOTO diablo_mission4_loop
				ENDIF

				WHILE LOCATE_PLAYER_ON_FOOT_3D player 938.4 -230.5 3.9 1.0 1.0 2.0 FALSE
					WAIT 0
						IF NOT IS_PLAYER_PLAYING player
							GOTO diablo_mission4_loop
						ENDIF
				ENDWHILE
				*/
			ENDIF
		ENDIF
	ENDIF	

	GOTO diablo_mission4_loop

}


// ***************************************Commercial Level**********************************
 
// *****************************************Asuka Missions************************************
 
// Asuka Mission 1


asuka_mission1_loop:
{

WAIT mission_trigger_wait_time

	IF flag_asuka_mission1_passed = 1
		TERMINATE_THIS_SCRIPT
	ENDIF

	IF IS_PLAYER_PLAYING player
		IF LOCATE_PLAYER_ON_FOOT_3D Player 523.7 -639.0 16.1 1.0 4.5 2.0 FALSE
			IF flag_player_on_mission = 0
				IF CAN_PLAYER_START_MISSION Player
					flag_player_on_mission = 1 // SCFIX

					MAKE_PLAYER_SAFE_FOR_CUTSCENE player

					SET_FADING_COLOUR 0 0 0

					DO_FADE 1500 FADE_OUT

					SWITCH_STREAMING OFF

					PRINT_BIG AM1 15000 2

					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE

					LOAD_AND_LAUNCH_MISSION asuka1.sc
				ENDIF

				/* SCFIX: fix mission not starting if you jump onto the marker
				IF NOT IS_PLAYER_PLAYING player
					GOTO asuka_mission1_loop
				ENDIF

				WHILE LOCATE_PLAYER_ON_FOOT_3D Player 523.7 -639.0 16.1 1.0 4.5 2.0 FALSE
					WAIT 0
					IF NOT IS_PLAYER_PLAYING player
						GOTO asuka_mission1_loop
					ENDIF
				ENDWHILE
				*/
			ENDIF
		ENDIF
	ENDIF

	GOTO asuka_mission1_loop

}


// Asuka Mission 2

asuka_mission2_loop:
{

WAIT mission_trigger_wait_time

	IF flag_asuka_mission2_passed = 1
		TERMINATE_THIS_SCRIPT
	ENDIF

	IF IS_PLAYER_PLAYING player
		IF LOCATE_PLAYER_ON_FOOT_3D Player 523.7 -639.0 16.1 1.0 4.5 2.0 FALSE
			IF flag_player_on_mission = 0
				IF CAN_PLAYER_START_MISSION Player
					flag_player_on_mission = 1 // SCFIX

					MAKE_PLAYER_SAFE_FOR_CUTSCENE Player

					SET_FADING_COLOUR 0 0 0

					DO_FADE 1500 FADE_OUT

					SWITCH_STREAMING OFF

					PRINT_BIG ( AM2 ) 15000 2 //"Asuka Mission 2"	 

					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE

					LOAD_AND_LAUNCH_MISSION asuka2.sc
				ENDIF

				/* SCFIX: fix mission not starting if you jump onto the marker
				IF NOT IS_PLAYER_PLAYING player
					GOTO asuka_mission2_loop
				ENDIF

				WHILE LOCATE_PLAYER_ON_FOOT_3D Player 523.7 -639.0 16.1 1.0 4.5 2.0 FALSE
					WAIT 0
					IF NOT IS_PLAYER_PLAYING player
						GOTO asuka_mission2_loop
					ENDIF
				ENDWHILE
				*/
			ENDIF
		ENDIF
	ENDIF

	GOTO asuka_mission2_loop
}

 
 
// Asuka Mission 3

asuka_mission3_loop:
{

WAIT mission_trigger_wait_time

	IF flag_asuka_mission3_passed = 1
		TERMINATE_THIS_SCRIPT
	ENDIF

	IF IS_PLAYER_PLAYING player
		IF LOCATE_PLAYER_ON_FOOT_3D Player 523.7 -639.0 16.1 1.0 4.5 2.0 FALSE
			IF flag_player_on_mission = 0
				IF CAN_PLAYER_START_MISSION Player
					flag_player_on_mission = 1 // SCFIX

					MAKE_PLAYER_SAFE_FOR_CUTSCENE Player

					SET_FADING_COLOUR 0 0 0

					DO_FADE 1500 FADE_OUT

					SWITCH_STREAMING OFF

					PRINT_BIG ( AM3 ) 15000 2 //"Asuka Mission 3"

					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE

					LOAD_AND_LAUNCH_MISSION asuka3.sc
				ENDIF

				/* SCFIX: fix mission not starting if you jump onto the marker
				IF NOT IS_PLAYER_PLAYING player
					GOTO asuka_mission3_loop
				ENDIF

				WHILE LOCATE_PLAYER_ON_FOOT_3D Player 523.7 -639.0 16.1 1.0 4.5 2.0 FALSE
					WAIT 0
					IF NOT IS_PLAYER_PLAYING player
						GOTO asuka_mission3_loop
					ENDIF
				ENDWHILE
				*/
			ENDIF
		ENDIF
	ENDIF

	GOTO asuka_mission3_loop
}





// Asuka Mission 4

asuka_mission4_loop:
{

WAIT mission_trigger_wait_time

	IF flag_asuka_mission4_passed = 1
		TERMINATE_THIS_SCRIPT
	ENDIF

	IF IS_PLAYER_PLAYING player
		IF LOCATE_PLAYER_ON_FOOT_3D Player 523.7 -639.0 16.1 1.0 4.5 2.0 FALSE
			IF flag_player_on_mission = 0
				IF CAN_PLAYER_START_MISSION Player
					flag_player_on_mission = 1 // SCFIX

					MAKE_PLAYER_SAFE_FOR_CUTSCENE Player

					SET_FADING_COLOUR 0 0 0

					DO_FADE 1500 FADE_OUT

					SWITCH_STREAMING OFF

					PRINT_BIG ( AM4 ) 15000 2 //"Asuka Mission 4"	 

					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE

					LOAD_AND_LAUNCH_MISSION asuka4.sc
				ENDIF

				/* SCFIX: fix mission not starting if you jump onto the marker
				IF NOT IS_PLAYER_PLAYING player
					GOTO asuka_mission4_loop
				ENDIF

				WHILE LOCATE_PLAYER_ON_FOOT_3D Player 523.7 -639.0 16.1 1.0 4.5 2.0 FALSE
					WAIT 0
					IF NOT IS_PLAYER_PLAYING player
						GOTO asuka_mission4_loop
					ENDIF
				ENDWHILE
				*/
			ENDIF
		ENDIF
	ENDIF

	GOTO asuka_mission4_loop
}




// Asuka Mission 5

asuka_mission5_loop:
{

WAIT mission_trigger_wait_time

IF flag_love_mission4_passed = 1
	TERMINATE_THIS_SCRIPT
ENDIF

	IF flag_asuka_mission5_passed = 1 
		TERMINATE_THIS_SCRIPT
	ENDIF

	IF IS_PLAYER_PLAYING player
		IF LOCATE_PLAYER_ON_FOOT_3D Player 523.7 -639.0 16.1 1.0 4.5 2.0 FALSE
			IF flag_player_on_mission = 0
				IF CAN_PLAYER_START_MISSION Player
					flag_player_on_mission = 1 // SCFIX

					MAKE_PLAYER_SAFE_FOR_CUTSCENE Player

					SET_FADING_COLOUR 0 0 0

					DO_FADE 1500 FADE_OUT

					SWITCH_STREAMING OFF

					PRINT_BIG ( AM5 ) 15000 2 //"Asuka Mission 5"

					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE

					LOAD_AND_LAUNCH_MISSION asuka5.sc
				ENDIF

				/* SCFIX: fix mission not starting if you jump onto the marker
				IF NOT IS_PLAYER_PLAYING player
					GOTO asuka_mission5_loop
				ENDIF

				WHILE LOCATE_PLAYER_ON_FOOT_3D Player 523.7 -639.0 16.1 1.0 4.5 2.0 FALSE
					WAIT 0
					IF NOT IS_PLAYER_PLAYING player
						GOTO asuka_mission5_loop
					ENDIF
				ENDWHILE
				*/
			ENDIF
		ENDIF
	ENDIF

	GOTO asuka_mission5_loop
}


// ******************************************Kenji Missions*********************************

// Kenji Mission 1

kenji_mission1_loop:
{

WAIT mission_trigger_wait_time

	IF flag_kenji_mission1_passed = 1
	OR flag_love_mission2_passed = 1
		TERMINATE_THIS_SCRIPT
	ENDIF

	IF IS_PLAYER_PLAYING player
		IF LOCATE_PLAYER_ON_FOOT_3D Player 459.1 -1413.0 26.1 1.5 1.5 2.0 FALSE
			IF flag_player_on_mission = 0
				IF CAN_PLAYER_START_MISSION Player
					flag_player_on_mission = 1 // SCFIX

					MAKE_PLAYER_SAFE_FOR_CUTSCENE player

					SET_FADING_COLOUR 0 0 0

					DO_FADE 1500 FADE_OUT

					SWITCH_STREAMING OFF

					PRINT_BIG ( KM1 ) 15000 2 //"Kanbu Bust out"

					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE

					LOAD_AND_LAUNCH_MISSION kenji1.sc
				ENDIF

				/* SCFIX: fix mission not starting if you jump onto the marker
				IF NOT IS_PLAYER_PLAYING player
					GOTO kenji_mission1_loop
				ENDIF

				WHILE LOCATE_PLAYER_ON_FOOT_3D Player 459.1 -1413.0 26.1 1.5 1.5 2.0 FALSE
					WAIT 0
					IF NOT IS_PLAYER_PLAYING player
						GOTO kenji_mission1_loop
					ENDIF
				ENDWHILE
				*/
			ENDIF
		ENDIF
	ENDIF

	GOTO kenji_mission1_loop

}


// Kenji Mission 2

kenji_mission2_loop:
{

WAIT mission_trigger_wait_time

	IF flag_kenji_mission2_passed = 1
	OR flag_love_mission2_passed = 1
		TERMINATE_THIS_SCRIPT
	ENDIF

	IF IS_PLAYER_PLAYING player
		IF LOCATE_PLAYER_ON_FOOT_3D Player 459.1 -1413.0 26.1 1.5 1.5 2.0 FALSE
			IF flag_player_on_mission = 0
				IF CAN_PLAYER_START_MISSION Player
					flag_player_on_mission = 1 // SCFIX

					MAKE_PLAYER_SAFE_FOR_CUTSCENE player

					SET_FADING_COLOUR 0 0 0

					DO_FADE 1500 FADE_OUT

					SWITCH_STREAMING OFF

					PRINT_BIG ( KM2 ) 15000 2 //"Gone in Sixty"

					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE

					LOAD_AND_LAUNCH_MISSION kenji2.sc
				ENDIF

				/* SCFIX: fix mission not starting if you jump onto the marker
				IF NOT IS_PLAYER_PLAYING player
					GOTO kenji_mission2_loop
				ENDIF

				WHILE LOCATE_PLAYER_ON_FOOT_3D Player 459.1 -1413.0 26.1 1.5 1.5 2.0 FALSE
					WAIT 0
					IF NOT IS_PLAYER_PLAYING player
						GOTO kenji_mission2_loop
					ENDIF
				ENDWHILE
				*/
			ENDIF
		ENDIF
	ENDIF
   		
	GOTO kenji_mission2_loop

}

// Kenji Mission 3

kenji_mission3_loop:
{

WAIT mission_trigger_wait_time

	IF flag_kenji_mission3_passed = 1
	OR flag_love_mission2_passed = 1
		TERMINATE_THIS_SCRIPT
	ENDIF

	IF IS_PLAYER_PLAYING player
		IF LOCATE_PLAYER_ON_FOOT_3D Player 459.1 -1413.0 26.1 1.5 1.5 2.0 FALSE
			IF flag_player_on_mission = 0
				IF CAN_PLAYER_START_MISSION Player
					flag_player_on_mission = 1 // SCFIX

					MAKE_PLAYER_SAFE_FOR_CUTSCENE player

					SET_FADING_COLOUR 0 0 0

					DO_FADE 1500 FADE_OUT

					SWITCH_STREAMING OFF

					PRINT_BIG ( KM3 ) 15000 2  //"Kenji Mission 3"

					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE

					LOAD_AND_LAUNCH_MISSION kenji3.sc
				ENDIF

				/* SCFIX: fix mission not starting if you jump onto the marker
				IF NOT IS_PLAYER_PLAYING player
					GOTO kenji_mission3_loop
				ENDIF

				WHILE LOCATE_PLAYER_ON_FOOT_3D Player 459.1 -1413.0 26.1 1.5 1.5 2.0 FALSE
					WAIT 0
					IF NOT IS_PLAYER_PLAYING player
						GOTO kenji_mission3_loop
					ENDIF
				ENDWHILE
				*/
			ENDIF
		ENDIF
	ENDIF
			
	GOTO kenji_mission3_loop

}




// Kenji Mission 4

kenji_mission4_loop:
{

WAIT mission_trigger_wait_time

	IF flag_kenji_mission4_passed = 1
	OR flag_love_mission2_passed = 1
		TERMINATE_THIS_SCRIPT
	ENDIF

	IF IS_PLAYER_PLAYING player	
		IF LOCATE_PLAYER_ON_FOOT_3D Player 459.1 -1413.0 26.1 1.5 1.5 2.0 FALSE
			IF flag_player_on_mission = 0
				IF CAN_PLAYER_START_MISSION Player
					flag_player_on_mission = 1 // SCFIX

					MAKE_PLAYER_SAFE_FOR_CUTSCENE player

					SET_FADING_COLOUR 0 0 0

					DO_FADE 1500 FADE_OUT

					SWITCH_STREAMING OFF

					PRINT_BIG ( KM4 ) 15000 2  //"SHIMA"

					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE

					LOAD_AND_LAUNCH_MISSION kenji4.sc
				ENDIF

				/* SCFIX: fix mission not starting if you jump onto the marker
				IF NOT IS_PLAYER_PLAYING player
					GOTO kenji_mission4_loop
				ENDIF

				WHILE LOCATE_PLAYER_ON_FOOT_3D Player 459.1 -1413.0 26.1 1.5 1.5 2.0 FALSE
					WAIT 0
					IF NOT IS_PLAYER_PLAYING player
						GOTO kenji_mission4_loop
					ENDIF
				ENDWHILE
				*/
			ENDIF
		ENDIF
	ENDIF
			
	GOTO kenji_mission4_loop

}



// Kenji Mission 5

kenji_mission5_loop:
{

WAIT mission_trigger_wait_time

	IF flag_kenji_mission5_passed = 1
	OR flag_love_mission2_passed = 1
		TERMINATE_THIS_SCRIPT
	ENDIF

	IF IS_PLAYER_PLAYING player
		IF LOCATE_PLAYER_ON_FOOT_3D Player 459.1 -1413.0 26.1 1.5 1.5 2.0 FALSE
			IF flag_player_on_mission = 0
				IF CAN_PLAYER_START_MISSION Player
					flag_player_on_mission = 1 // SCFIX

					MAKE_PLAYER_SAFE_FOR_CUTSCENE player

					SET_FADING_COLOUR 0 0 0

					DO_FADE 1500 FADE_OUT

					SWITCH_STREAMING OFF

					PRINT_BIG KM5 15000 2 // "SMACK DOWN"

					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE

					LOAD_AND_LAUNCH_MISSION kenji5.sc
				ENDIF

				/* SCFIX: fix mission not starting if you jump onto the marker
				IF NOT IS_PLAYER_PLAYING player
					GOTO kenji_mission5_loop
				ENDIF

				WHILE LOCATE_PLAYER_ON_FOOT_3D Player 459.1 -1413.0 26.1 1.5 1.5 2.0 FALSE
					WAIT 0
					IF NOT IS_PLAYER_PLAYING player
						GOTO kenji_mission5_loop
					ENDIF
				ENDWHILE
				*/
			ENDIF
		ENDIF
	ENDIF

		
	GOTO kenji_mission5_loop

}




// ******************************************Ray Missions***********************************



// Ray Mission 1

ray_mission1_loop:
{

WAIT 0

	IF flag_ray_mission1_passed = 1
		TERMINATE_THIS_SCRIPT
	ENDIF

	IF IS_PLAYER_PLAYING player
		IF LOCATE_PLAYER_ON_FOOT_3D Player 38.8 -725.4 22.8 1.2 1.2 2.0 FALSE
			IF flag_player_on_mission = 0
				IF CAN_PLAYER_START_MISSION Player
					flag_player_on_mission = 1 // SCFIX

					rays_cutscene_flag = 1
					MAKE_PLAYER_SAFE_FOR_CUTSCENE player

					SET_FADING_COLOUR 0 0 0

					DO_FADE 1500 FADE_OUT

					SWITCH_STREAMING OFF

					PRINT_BIG RM1 15000 2 //"Silence the sneak"

					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE

					LOAD_AND_LAUNCH_MISSION ray1.sc
				ENDIF

				/* SCFIX: fix mission not starting if you jump onto the marker
				IF NOT IS_PLAYER_PLAYING player
					GOTO ray_mission1_loop
				ENDIF

				WHILE LOCATE_PLAYER_ON_FOOT_3D Player 38.8 -725.4 22.8 1.2 1.2 2.0 FALSE
					WAIT 0
					IF NOT IS_PLAYER_PLAYING player
						GOTO ray_mission1_loop
					ENDIF
				ENDWHILE
				*/
			ENDIF
		ENDIF
	ENDIF
		
	GOTO ray_mission1_loop

}



// Ray Mission 2

ray_mission2_loop:
{

WAIT 0

	IF flag_ray_mission2_passed = 1
		TERMINATE_THIS_SCRIPT
	ENDIF

	IF IS_PLAYER_PLAYING player
		IF LOCATE_PLAYER_ON_FOOT_3D Player 38.8 -725.4 22.8 1.2 1.2 2.0 FALSE
			IF flag_player_on_mission = 0
				IF CAN_PLAYER_START_MISSION Player
					flag_player_on_mission = 1 // SCFIX

					rays_cutscene_flag = 1
					MAKE_PLAYER_SAFE_FOR_CUTSCENE Player

					SET_FADING_COLOUR 0 0 0

					DO_FADE 1500 FADE_OUT	//	used to be 250

					SWITCH_STREAMING OFF

					PRINT_BIG RM2 15000 2 //"Arms Shortage"

					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE

					LOAD_AND_LAUNCH_MISSION ray2.sc
				ENDIF

				/* SCFIX: fix mission not starting if you jump onto the marker
				IF NOT IS_PLAYER_PLAYING player
					GOTO ray_mission2_loop
				ENDIF

				WHILE LOCATE_PLAYER_ON_FOOT_3D Player 38.8 -725.4 22.8 1.2 1.2 2.0 FALSE
					WAIT 0
					IF NOT IS_PLAYER_PLAYING player
						GOTO ray_mission2_loop
					ENDIF
				ENDWHILE
				*/
			ENDIF
		ENDIF
	ENDIF
		
	GOTO ray_mission2_loop

}


// Ray Mission 3

ray_mission3_loop:
{

WAIT 0

	IF flag_ray_mission3_passed = 1
		TERMINATE_THIS_SCRIPT
	ENDIF

	IF IS_PLAYER_PLAYING player
		IF LOCATE_PLAYER_ON_FOOT_3D Player 38.8 -725.4 22.8 1.2 1.2 2.0 FALSE
			IF flag_player_on_mission = 0
				IF CAN_PLAYER_START_MISSION Player
					flag_player_on_mission = 1 // SCFIX

					rays_cutscene_flag = 1
					MAKE_PLAYER_SAFE_FOR_CUTSCENE player

					SET_FADING_COLOUR 0 0 0

					DO_FADE 1500 FADE_OUT

					SWITCH_STREAMING OFF

					PRINT_BIG RM3 15000 2 //"Evidence Dash"

					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE

					LOAD_AND_LAUNCH_MISSION ray3.sc
				ENDIF

				/* SCFIX: fix mission not starting if you jump onto the marker
				IF NOT IS_PLAYER_PLAYING player
					GOTO ray_mission3_loop
				ENDIF

				WHILE LOCATE_PLAYER_ON_FOOT_3D Player 38.8 -725.4 22.8 1.2 1.2 2.0 FALSE
					WAIT 0
					IF NOT IS_PLAYER_PLAYING player
						GOTO ray_mission3_loop
					ENDIF
				ENDWHILE
				*/
			ENDIF
		ENDIF
	ENDIF
			
	GOTO ray_mission3_loop

}






// Ray Mission 4

ray_mission4_loop:
{

WAIT 0

	IF flag_ray_mission4_passed = 1
		TERMINATE_THIS_SCRIPT
	ENDIF
	
	IF IS_PLAYER_PLAYING player
		IF LOCATE_PLAYER_ON_FOOT_3D Player 38.8 -725.4 22.8 1.2 1.2 2.0 FALSE
			IF flag_player_on_mission = 0
				IF CAN_PLAYER_START_MISSION Player
					flag_player_on_mission = 1 // SCFIX

					rays_cutscene_flag = 1
					MAKE_PLAYER_SAFE_FOR_CUTSCENE player

					SET_FADING_COLOUR 0 0 0

					DO_FADE 1500 FADE_OUT

					SWITCH_STREAMING OFF

					PRINT_BIG RM4 15000 2 //"Gone Fishing"

					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE

					LOAD_AND_LAUNCH_MISSION ray4.sc
				ENDIF

				/* SCFIX: fix mission not starting if you jump onto the marker
				IF NOT IS_PLAYER_PLAYING player
					GOTO ray_mission4_loop
				ENDIF

				WHILE LOCATE_PLAYER_ON_FOOT_3D Player 38.8 -725.4 22.8 1.2 1.2 2.0 FALSE
					WAIT 0
					IF NOT IS_PLAYER_PLAYING player
						GOTO ray_mission4_loop
					ENDIF
				ENDWHILE
				*/
			ENDIF
		ENDIF
	ENDIF
      	
	GOTO ray_mission4_loop

}




// Ray Mission 5

ray_mission5_loop:
{

WAIT 0

	IF flag_ray_mission5_passed = 1
		TERMINATE_THIS_SCRIPT
	ENDIF

	IF IS_PLAYER_PLAYING player
		IF LOCATE_PLAYER_ON_FOOT_3D Player 38.8 -725.4 22.8 1.2 1.2 2.0 FALSE
			IF flag_player_on_mission = 0
				IF CAN_PLAYER_START_MISSION Player
					flag_player_on_mission = 1 // SCFIX

					rays_cutscene_flag = 1
					MAKE_PLAYER_SAFE_FOR_CUTSCENE Player

					SET_FADING_COLOUR 0 0 0

					DO_FADE 1500 FADE_OUT	//	used to be 250

					SWITCH_STREAMING OFF

					PRINT_BIG RM5 15000 2 //"Plaster Blaster"

					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE

					LOAD_AND_LAUNCH_MISSION ray5.sc
				ENDIF

				/* SCFIX: fix mission not starting if you jump onto the marker
				IF NOT IS_PLAYER_PLAYING player
					GOTO ray_mission5_loop
				ENDIF

				WHILE LOCATE_PLAYER_ON_FOOT_3D Player 38.8 -725.4 22.8 1.2 1.2 2.0 FALSE
					WAIT 0
					IF NOT IS_PLAYER_PLAYING player
						GOTO ray_mission5_loop
					ENDIF
				ENDWHILE
				*/
			ENDIF
		ENDIF
	ENDIF
			
	GOTO ray_mission5_loop

}

// Ray Mission 6

ray_mission6_loop:
{																					 

WAIT 0

	IF flag_ray_mission6_passed = 1
		TERMINATE_THIS_SCRIPT
	ENDIF
	
	IF IS_PLAYER_PLAYING player
		IF LOCATE_PLAYER_ON_FOOT_3D Player 38.8 -725.4 22.8 1.2 1.2 2.0 FALSE
			IF flag_player_on_mission = 0
				IF CAN_PLAYER_START_MISSION Player
					flag_player_on_mission = 1 // SCFIX

					MAKE_PLAYER_SAFE_FOR_CUTSCENE player

					SET_FADING_COLOUR 0 0 0

					DO_FADE 1500 FADE_OUT

					SWITCH_STREAMING OFF

					PRINT_BIG RM6 15000 2 //"Marked Man"

					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE

					LOAD_AND_LAUNCH_MISSION ray6.sc
				ENDIF

				/* SCFIX: fix mission not starting if you jump onto the marker
				IF NOT IS_PLAYER_PLAYING player
					GOTO ray_mission6_loop
				ENDIF

				WHILE LOCATE_PLAYER_ON_FOOT_3D Player 38.8 -725.4 22.8 1.2 1.2 2.0 FALSE
					WAIT 0
					IF NOT IS_PLAYER_PLAYING player
						GOTO ray_mission6_loop
					ENDIF
				ENDWHILE
				*/
			ENDIF
		ENDIF
	ENDIF
			
	GOTO ray_mission6_loop

}


// ***************************************love Missions**********************************



// love Mission 1

love_mission1_loop:
{

WAIT mission_trigger_wait_time

	IF flag_love_mission1_passed = 1
		TERMINATE_THIS_SCRIPT
	ENDIF
	
	IF IS_PLAYER_PLAYING player
		IF LOCATE_PLAYER_ON_FOOT_3D Player 87.3 -1548.6 28.3 2.0 1.0 2.0 FALSE
			IF flag_player_on_mission = 0
				IF CAN_PLAYER_START_MISSION Player
					flag_player_on_mission = 1 // SCFIX

					MAKE_PLAYER_SAFE_FOR_CUTSCENE player

					SET_FADING_COLOUR 0 0 0

					DO_FADE 1500 FADE_OUT

					SWITCH_STREAMING OFF

					PRINT_BIG ( LOVE1 ) 15000 2  //"Resue the Old Oriental Gentleman"

					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE

					LOAD_AND_LAUNCH_MISSION love1.sc
				ENDIF

				/* SCFIX: fix mission not starting if you jump onto the marker
				IF NOT IS_PLAYER_PLAYING player
					GOTO love_mission1_loop
				ENDIF

				WHILE LOCATE_PLAYER_ON_FOOT_3D Player 87.3 -1548.6 28.3 2.0 1.0 2.0 FALSE
					WAIT 0
					IF NOT IS_PLAYER_PLAYING player
						GOTO love_mission1_loop
					ENDIF
				ENDWHILE
				*/
			ENDIF
		ENDIF
	ENDIF

	GOTO love_mission1_loop

}


// love Mission 2

love_mission2_loop:
{

WAIT mission_trigger_wait_time

	IF flag_love_mission2_passed = 1
		TERMINATE_THIS_SCRIPT
	ENDIF

	IF IS_PLAYER_PLAYING player
		IF LOCATE_PLAYER_ON_FOOT_3D Player 87.3 -1548.6 28.3 2.0 1.0 2.0 FALSE
			IF flag_player_on_mission = 0
				IF CAN_PLAYER_START_MISSION Player
					flag_player_on_mission = 1 // SCFIX

					MAKE_PLAYER_SAFE_FOR_CUTSCENE Player

					SET_FADING_COLOUR 0 0 0

					DO_FADE 1500 FADE_OUT

					SWITCH_STREAMING OFF

					PRINT_BIG ( LOVE2 ) 15000 2	//"Love Mission 2"

					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE

					LOAD_AND_LAUNCH_MISSION love2.sc
				ENDIF

				/* SCFIX: fix mission not starting if you jump onto the marker
				IF NOT IS_PLAYER_PLAYING player
					GOTO love_mission2_loop
				ENDIF

				WHILE LOCATE_PLAYER_ON_FOOT_3D Player 87.3 -1548.6 28.3 2.0 1.0 2.0 FALSE
					WAIT 0
					IF NOT IS_PLAYER_PLAYING player
						GOTO love_mission2_loop
					ENDIF
				ENDWHILE
				*/
			ENDIF
		ENDIF
	ENDIF
			
	GOTO love_mission2_loop

}


// love Mission 3

love_mission3_loop:
{

WAIT mission_trigger_wait_time

	IF flag_love_mission3_passed = 1
		TERMINATE_THIS_SCRIPT
	ENDIF
	
	IF IS_PLAYER_PLAYING player
		IF LOCATE_PLAYER_ON_FOOT_3D Player 87.3 -1548.6 28.3 2.0 1.0 2.0 FALSE
			IF flag_player_on_mission = 0
				IF CAN_PLAYER_START_MISSION Player
					flag_player_on_mission = 1 // SCFIX

					MAKE_PLAYER_SAFE_FOR_CUTSCENE player

					SET_FADING_COLOUR 0 0 0

					DO_FADE 1500 FADE_OUT

					SWITCH_STREAMING OFF

					PRINT_BIG LOVE3 15000 2	//"love Mission 3"

					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE

					LOAD_AND_LAUNCH_MISSION love3.sc
				ENDIF

				/* SCFIX: fix mission not starting if you jump onto the marker
				IF NOT IS_PLAYER_PLAYING player
					GOTO love_mission3_loop
				ENDIF

				WHILE LOCATE_PLAYER_ON_FOOT_3D Player 87.3 -1548.6 28.3 2.0 1.0 2.0 FALSE
					WAIT 0
					IF NOT IS_PLAYER_PLAYING player
						GOTO love_mission3_loop
					ENDIF
				ENDWHILE
				*/
			ENDIF
		ENDIF
	ENDIF
			
	GOTO love_mission3_loop

}

// LOVE MISSION 4 AND 5 ARE IN SUBURBAIN MISSIONS AS THIS IS WHERE THEY ARE BASED 

// *****************************************Yardie Missions*********************************


// Yardie Mission 1

yardie_mission1_loop:
{

WAIT mission_trigger_wait_time


	IF flag_yardie_mission1_passed = 1
		TURN_PHONE_OFF yardie_phone
		TERMINATE_THIS_SCRIPT
	ENDIF
	
	IF flag_player_on_mission = 0
	   TURN_PHONE_ON yardie_phone
	ELSE
		TURN_PHONE_OFF yardie_phone
	ENDIF
				
	IF IS_PLAYER_PLAYING player	
		IF LOCATE_STOPPED_PLAYER_ON_FOOT_3D	player 120.7 -272.1 16.1 1.0 1.0 2.0 FALSE
			IF flag_player_on_mission = 0
				IF CAN_PLAYER_START_MISSION Player
					flag_player_on_mission = 1 // SCFIX
					TURN_PHONE_OFF yardie_phone

					MAKE_PLAYER_SAFE_FOR_CUTSCENE Player

					SET_FADING_COLOUR 0 0 0

					DO_FADE 1500 FADE_OUT

					PRINT_BIG ( YD1 ) 15000 2 //"Yardie Mission 1"	 

					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE

					LOAD_AND_LAUNCH_MISSION yard1.sc
				ENDIF

				/* SCFIX: fix mission not starting if you jump onto the marker
				IF NOT IS_PLAYER_PLAYING player
					GOTO yardie_mission1_loop
				ENDIF

				WHILE LOCATE_PLAYER_ON_FOOT_3D player 120.7 -272.1 16.1 1.0 1.0 2.0 FALSE
					WAIT 0
						IF NOT IS_PLAYER_PLAYING player
							GOTO yardie_mission1_loop
						ENDIF
				ENDWHILE
				*/
			ENDIF
		ENDIF
	ENDIF
			
	GOTO yardie_mission1_loop

}

// Yardie Mission 2

yardie_mission2_loop:
{

WAIT mission_trigger_wait_time


	IF flag_yardie_mission2_passed = 1
		TURN_PHONE_OFF yardie_phone
		TERMINATE_THIS_SCRIPT
	ENDIF
	
	IF flag_player_on_mission = 0
	   TURN_PHONE_ON yardie_phone
	ELSE
		TURN_PHONE_OFF yardie_phone
	ENDIF
				
	IF IS_PLAYER_PLAYING player	
		IF LOCATE_STOPPED_PLAYER_ON_FOOT_3D	player 120.7 -272.1 16.1 1.0 1.0 2.0 FALSE
			IF flag_player_on_mission = 0
				IF CAN_PLAYER_START_MISSION Player
					flag_player_on_mission = 1 // SCFIX
					TURN_PHONE_OFF yardie_phone

					MAKE_PLAYER_SAFE_FOR_CUTSCENE Player

					SET_FADING_COLOUR 0 0 0

					DO_FADE 1500 FADE_OUT

					PRINT_BIG ( YD2 ) 15000 2 //"Yardie Mission 2"

					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE

					LOAD_AND_LAUNCH_MISSION yard2.sc
				ENDIF

				/* SCFIX: fix mission not starting if you jump onto the marker
				IF NOT IS_PLAYER_PLAYING player
					GOTO yardie_mission2_loop
				ENDIF

				WHILE LOCATE_PLAYER_ON_FOOT_3D player 120.7 -272.1 16.1 1.0 1.0 2.0 FALSE
					WAIT 0
						IF NOT IS_PLAYER_PLAYING player
							GOTO yardie_mission2_loop
						ENDIF
				ENDWHILE
				*/
			ENDIF
		ENDIF
	ENDIF
			
	GOTO yardie_mission2_loop

}

// Yardie Mission 3

yardie_mission3_loop:
{

WAIT mission_trigger_wait_time


	IF flag_yardie_mission3_passed = 1
		TURN_PHONE_OFF yardie_phone
		TERMINATE_THIS_SCRIPT
	ENDIF
	
	IF flag_player_on_mission = 0
	   TURN_PHONE_ON yardie_phone
	ELSE
		TURN_PHONE_OFF yardie_phone
	ENDIF
				
	IF IS_PLAYER_PLAYING player	
		IF LOCATE_STOPPED_PLAYER_ON_FOOT_3D	player 120.7 -272.1 16.1 1.0 1.0 2.0 FALSE
			IF flag_player_on_mission = 0
				IF CAN_PLAYER_START_MISSION Player
					flag_player_on_mission = 1 // SCFIX
					TURN_PHONE_OFF yardie_phone

					MAKE_PLAYER_SAFE_FOR_CUTSCENE Player

					SET_FADING_COLOUR 0 0 0

					DO_FADE 1500 FADE_OUT

					PRINT_BIG ( YD3 ) 15000 2 //"Yardie Mission 3"

					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE

					LOAD_AND_LAUNCH_MISSION yard3.sc
				ENDIF

				/* SCFIX: fix mission not starting if you jump onto the marker
				IF NOT IS_PLAYER_PLAYING player
					GOTO yardie_mission3_loop
				ENDIF

				WHILE LOCATE_PLAYER_ON_FOOT_3D player 120.7 -272.1 16.1 1.0 1.0 2.0 FALSE
					WAIT 0
						IF NOT IS_PLAYER_PLAYING player
							GOTO yardie_mission3_loop
						ENDIF
				ENDWHILE
				*/
			ENDIF
		ENDIF
	ENDIF
			
	GOTO yardie_mission3_loop

}

// Yardie Mission 4

yardie_mission4_loop:
{

WAIT mission_trigger_wait_time


	IF flag_yardie_mission4_passed = 1
		TURN_PHONE_OFF yardie_phone
		TERMINATE_THIS_SCRIPT
	ENDIF
	
	IF flag_player_on_mission = 0
	   TURN_PHONE_ON yardie_phone
	ELSE
		TURN_PHONE_OFF yardie_phone
	ENDIF
				
	IF IS_PLAYER_PLAYING player	
		IF LOCATE_STOPPED_PLAYER_ON_FOOT_3D	player 120.7 -272.1 16.1 1.0 1.0 2.0 FALSE
			IF flag_player_on_mission = 0
				IF CAN_PLAYER_START_MISSION Player
					flag_player_on_mission = 1 // SCFIX
					TURN_PHONE_OFF yardie_phone

					MAKE_PLAYER_SAFE_FOR_CUTSCENE Player

					SET_FADING_COLOUR 0 0 0

					DO_FADE 1500 FADE_OUT

					PRINT_BIG ( YD4 ) 15000 2 //"Yardie Mission 4"	 

					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE

					LOAD_AND_LAUNCH_MISSION yard4.sc
				ENDIF

				/* SCFIX: fix mission not starting if you jump onto the marker
				IF NOT IS_PLAYER_PLAYING player
					GOTO yardie_mission4_loop
				ENDIF

				WHILE LOCATE_PLAYER_ON_FOOT_3D player 120.7 -272.1 16.1 1.0 1.0 2.0 FALSE
					WAIT 0
						IF NOT IS_PLAYER_PLAYING player
							GOTO yardie_mission4_loop
						ENDIF
				ENDWHILE
				*/
			ENDIF
		ENDIF
	ENDIF
			
	GOTO yardie_mission4_loop

}


// ***************************************Suburban Level************************************

// ********************************Donald Love Suburban Missions****************************

// Love Mission 4

love_mission4_loop:
{																					 

WAIT mission_trigger_wait_time

	IF flag_love_mission4_passed = 1
		TERMINATE_THIS_SCRIPT
	ENDIF
	
	IF IS_PLAYER_PLAYING player
		IF LOCATE_PLAYER_ON_FOOT_3D Player 87.3 -1548.6 28.3 2.0 1.0 2.0 FALSE
			IF flag_player_on_mission = 0
				IF CAN_PLAYER_START_MISSION Player
					flag_player_on_mission = 1 // SCFIX

					MAKE_PLAYER_SAFE_FOR_CUTSCENE player

					SET_FADING_COLOUR 0 0 0

					DO_FADE 1500 FADE_OUT

					SWITCH_STREAMING OFF

					PRINT_BIG LOVE4 15000 2

					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE

					LOAD_AND_LAUNCH_MISSION love4.sc
				ENDIF

				/* SCFIX: fix mission not starting if you jump onto the marker
				IF NOT IS_PLAYER_PLAYING player
					GOTO love_mission4_loop
				ENDIF

				WHILE LOCATE_PLAYER_ON_FOOT_3D Player 87.3 -1548.6 28.3 2.0 1.0 2.0 FALSE
					WAIT 0
					IF NOT IS_PLAYER_PLAYING player
						GOTO love_mission4_loop
					ENDIF
				ENDWHILE
				*/
			ENDIF
		ENDIF
	ENDIF
			
	GOTO love_mission4_loop

}



// Love Mission 5

love_mission5_loop:
{																					 

WAIT mission_trigger_wait_time

	IF flag_love_mission5_passed = 1
		TERMINATE_THIS_SCRIPT
	ENDIF
	
	IF IS_PLAYER_PLAYING player
		IF LOCATE_PLAYER_ON_FOOT_3D Player 87.3 -1548.6 28.3 2.0 1.0 2.0 FALSE
			IF flag_player_on_mission = 0
				IF CAN_PLAYER_START_MISSION Player
					flag_player_on_mission = 1 // SCFIX

					MAKE_PLAYER_SAFE_FOR_CUTSCENE player

					SET_FADING_COLOUR 0 0 0

					DO_FADE 1500 FADE_OUT

					SWITCH_STREAMING OFF

					PRINT_BIG LOVE5 15000 2

					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE

					LOAD_AND_LAUNCH_MISSION love5.sc
				ENDIF

				/* SCFIX: fix mission not starting if you jump onto the marker
				IF NOT IS_PLAYER_PLAYING player
					GOTO love_mission5_loop
				ENDIF

				WHILE LOCATE_PLAYER_ON_FOOT_3D Player 87.3 -1548.6 28.3 2.0 1.0 2.0 FALSE
					WAIT 0
					IF NOT IS_PLAYER_PLAYING player
						GOTO love_mission5_loop
					ENDIF
				ENDWHILE
				*/
			ENDIF
		ENDIF
	ENDIF
			
	GOTO love_mission5_loop
									
}

// Love Mission 6

love_mission6_loop:
{																					 

WAIT mission_trigger_wait_time

	IF flag_love_mission6_passed = 1
		TERMINATE_THIS_SCRIPT
	ENDIF
	
	IF IS_PLAYER_PLAYING player
		IF LOCATE_PLAYER_ON_FOOT_3D Player 87.3 -1548.6 28.3 2.0 1.0 2.0 FALSE
			IF flag_player_on_mission = 0
				IF CAN_PLAYER_START_MISSION Player
					flag_player_on_mission = 1 // SCFIX

					MAKE_PLAYER_SAFE_FOR_CUTSCENE player

					SET_FADING_COLOUR 0 0 0

					DO_FADE 1500 FADE_OUT

					SWITCH_STREAMING OFF

					PRINT_BIG LOVE6	15000 2

					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE

					LOAD_AND_LAUNCH_MISSION love6.sc
				ENDIF

				/* SCFIX: fix mission not starting if you jump onto the marker
				IF NOT IS_PLAYER_PLAYING player
					GOTO love_mission6_loop
				ENDIF

				WHILE LOCATE_PLAYER_ON_FOOT_3D Player 87.3 -1548.6 28.3 2.0 1.0 2.0 FALSE
					WAIT 0
					IF NOT IS_PLAYER_PLAYING player
						GOTO love_mission6_loop
					ENDIF
				ENDWHILE
				*/
			ENDIF
		ENDIF
	ENDIF
			
	GOTO love_mission6_loop

}

// Love Mission 7

love_mission7_loop:
{																					 

WAIT mission_trigger_wait_time

	IF flag_love_mission7_passed = 1
		TERMINATE_THIS_SCRIPT
	ENDIF
	
	IF IS_PLAYER_PLAYING player
		IF LOCATE_PLAYER_ON_FOOT_3D Player 87.3 -1548.6 28.3 2.0 1.0 2.0 FALSE
			IF flag_player_on_mission = 0	
				IF CAN_PLAYER_START_MISSION Player
					flag_player_on_mission = 1 // SCFIX

					MAKE_PLAYER_SAFE_FOR_CUTSCENE player

					SET_FADING_COLOUR 0 0 0

					DO_FADE 1500 FADE_OUT

					SWITCH_STREAMING OFF

					PRINT_BIG LOVE7	15000 2

					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE

					LOAD_AND_LAUNCH_MISSION love7.sc
				ENDIF

				/* SCFIX: fix mission not starting if you jump onto the marker
				IF NOT IS_PLAYER_PLAYING player
					GOTO love_mission7_loop
				ENDIF

				WHILE LOCATE_PLAYER_ON_FOOT_3D Player 87.3 -1548.6 28.3 2.0 1.0 2.0 FALSE
					WAIT 0
					IF NOT IS_PLAYER_PLAYING player
						GOTO love_mission7_loop
					ENDIF
				ENDWHILE
				*/
			ENDIF
		ENDIF
	ENDIF
			
	GOTO love_mission7_loop

}
  
// ****************************************Asuka Suburban Missions**************************


// Asuka Mission 1

asuka_suburban_mission1_loop:
{

WAIT mission_trigger_wait_time

	IF flag_asuka_suburban_mission1_passed = 1
		TERMINATE_THIS_SCRIPT
	ENDIF
	
	IF IS_PLAYER_PLAYING player			   
		IF LOCATE_PLAYER_ON_FOOT_3D player 367.3 -328.1 19.5 1.0 1.0 2.0 FALSE
			IF flag_player_on_mission = 0
				IF CAN_PLAYER_START_MISSION Player
					flag_player_on_mission = 1 // SCFIX

					MAKE_PLAYER_SAFE_FOR_CUTSCENE Player

					SET_FADING_COLOUR 0 0 0

					DO_FADE 1500 FADE_OUT

					SWITCH_STREAMING OFF

					PRINT_BIG ( AS1 ) 15000 2

					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE

					LOAD_AND_LAUNCH_MISSION asusb1.sc
				ENDIF

				/* SCFIX: fix mission not starting if you jump onto the marker
				IF NOT IS_PLAYER_PLAYING player
					GOTO asuka_suburban_mission1_loop
				ENDIF

				WHILE LOCATE_PLAYER_ON_FOOT_3D player 367.3 -328.1 19.5 1.0 1.0 2.0 FALSE
					WAIT 0
					IF NOT IS_PLAYER_PLAYING player
						GOTO asuka_suburban_mission1_loop
					ENDIF
				ENDWHILE
				*/
			ENDIF
		ENDIF
	ENDIF
			
	GOTO asuka_suburban_mission1_loop

}

// Asuka Mission 2

asuka_suburban_mission2_loop:
{

WAIT mission_trigger_wait_time

	IF flag_asuka_suburban_mission2_passed = 1
		TERMINATE_THIS_SCRIPT
	ENDIF
	
	IF IS_PLAYER_PLAYING player
		IF LOCATE_PLAYER_ON_FOOT_3D player 367.3 -328.1 19.5 1.0 1.0 2.0 FALSE
			IF flag_player_on_mission = 0
				IF CAN_PLAYER_START_MISSION Player
					flag_player_on_mission = 1 // SCFIX

					MAKE_PLAYER_SAFE_FOR_CUTSCENE Player

					SET_FADING_COLOUR 0 0 0

					DO_FADE 1500 FADE_OUT	//	used to be 250

					SWITCH_STREAMING OFF

					PRINT_BIG ( AS2 ) 15000 2

					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE

					LOAD_AND_LAUNCH_MISSION asusb2.sc
				ENDIF

				/* SCFIX: fix mission not starting if you jump onto the marker
				IF NOT IS_PLAYER_PLAYING player
					GOTO asuka_suburban_mission2_loop
				ENDIF

				WHILE LOCATE_PLAYER_ON_FOOT_3D player 367.3 -328.1 19.5 1.0 1.0 2.0 FALSE
					WAIT 0
					IF NOT IS_PLAYER_PLAYING player
						GOTO asuka_suburban_mission2_loop
					ENDIF
				ENDWHILE
				*/
			ENDIF
		ENDIF
	ENDIF
			
	GOTO asuka_suburban_mission2_loop

}


// Asuka Mission 3

asuka_suburban_mission3_loop:
{

WAIT mission_trigger_wait_time

	IF flag_asuka_suburban_mission3_passed = 1
		TERMINATE_THIS_SCRIPT
	ENDIF
	
	IF IS_PLAYER_PLAYING player
		IF LOCATE_PLAYER_ON_FOOT_3D player 367.3 -328.1 19.5 1.0 1.0 2.0 FALSE
			IF flag_player_on_mission = 0
				IF CAN_PLAYER_START_MISSION Player
					flag_player_on_mission = 1 // SCFIX

					MAKE_PLAYER_SAFE_FOR_CUTSCENE Player

					SET_FADING_COLOUR 0 0 0

					DO_FADE 1500 FADE_OUT	//	used to be 250

					SWITCH_STREAMING OFF

					PRINT_BIG ( AS3 ) 15000 2

					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE

					LOAD_AND_LAUNCH_MISSION asusb3.sc
				ENDIF

				/* SCFIX: fix mission not starting if you jump onto the marker
				IF NOT IS_PLAYER_PLAYING player
					GOTO asuka_suburban_mission3_loop
				ENDIF

				WHILE LOCATE_PLAYER_ON_FOOT_3D player 367.3 -328.1 19.5 1.0 1.0 2.0 FALSE
					WAIT 0
					IF NOT IS_PLAYER_PLAYING player
						GOTO asuka_suburban_mission3_loop
					ENDIF
				ENDWHILE
				*/
			ENDIF
		ENDIF
	ENDIF
			
	GOTO asuka_suburban_mission3_loop

}

// Asuka Mission 4
/*
asuka_suburban_mission4_loop:
{

WAIT mission_trigger_wait_time

	IF flag_asuka_suburban_mission4_passed = 1
		TERMINATE_THIS_SCRIPT
	ENDIF
	
	IF IS_PLAYER_PLAYING player
		IF LOCATE_PLAYER_ON_FOOT_3D player 367.3 -328.1 19.5 1.0 1.0 2.0 FALSE
			IF flag_player_on_mission = 0	
				IF CAN_PLAYER_START_MISSION Player

					MAKE_PLAYER_SAFE_FOR_CUTSCENE Player

					SET_FADING_COLOUR 0 0 0

					DO_FADE 1500 FADE_OUT

					SWITCH_STREAMING OFF

					PRINT_BIG ( AS4 ) 15000 2

					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE

					LOAD_AND_LAUNCH_MISSION asusb4.sc
				ENDIF

				IF NOT IS_PLAYER_PLAYING player
					GOTO asuka_suburban_mission4_loop
				ENDIF

				WHILE LOCATE_PLAYER_ON_FOOT_3D player 367.3 -328.1 19.5 1.0 1.0 2.0 FALSE
					WAIT 0
					IF NOT IS_PLAYER_PLAYING player
						GOTO asuka_suburban_mission4_loop
					ENDIF
				ENDWHILE
			ENDIF
		ENDIF
	ENDIF
			
	GOTO asuka_suburban_mission4_loop

}
*/

// **********************************************Hood Missions******************************

// Hood Mission 1

hood_mission1_loop:
{

WAIT mission_trigger_wait_time


	IF flag_hood_mission1_passed = 1
		TURN_PHONE_OFF hood_phone
		TERMINATE_THIS_SCRIPT
	ENDIF
	
	IF flag_player_on_mission = 0
	   TURN_PHONE_ON hood_phone
	ELSE
		TURN_PHONE_OFF hood_phone
	ENDIF
				
	IF IS_PLAYER_PLAYING player	
		IF LOCATE_STOPPED_PLAYER_ON_FOOT_3D	player -443.5 -6.1 3.8 1.0 1.0 2.0 FALSE
			IF flag_player_on_mission = 0
				IF CAN_PLAYER_START_MISSION Player
					flag_player_on_mission = 1 // SCFIX
					TURN_PHONE_OFF hood_phone

					MAKE_PLAYER_SAFE_FOR_CUTSCENE Player

					SET_FADING_COLOUR 0 0 0

					DO_FADE 1500 FADE_OUT

					PRINT_BIG ( HM_1 ) 15000 2 //"Uzi Driver"

					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE

					LOAD_AND_LAUNCH_MISSION hood1.sc
				ENDIF

				/* SCFIX: fix mission not starting if you jump onto the marker
				IF NOT IS_PLAYER_PLAYING player
					GOTO hood_mission1_loop
				ENDIF

				WHILE LOCATE_PLAYER_ON_FOOT_3D player -443.5 -6.1 3.8 1.0 1.0 2.0 FALSE
					WAIT 0
						IF NOT IS_PLAYER_PLAYING player
							GOTO hood_mission1_loop
						ENDIF
				ENDWHILE
				*/
			ENDIF
		ENDIF
	ENDIF
			
	GOTO hood_mission1_loop

}


// Hood Mission 2

hood_mission2_loop:
{

WAIT mission_trigger_wait_time


	IF flag_hood_mission2_passed = 1
		TURN_PHONE_OFF hood_phone
		TERMINATE_THIS_SCRIPT
	ENDIF
	
	IF flag_player_on_mission = 0
	   TURN_PHONE_ON hood_phone
	ELSE
		TURN_PHONE_OFF hood_phone
	ENDIF
				
	IF IS_PLAYER_PLAYING player	
		IF LOCATE_STOPPED_PLAYER_ON_FOOT_3D	player -443.5 -6.1 3.8 1.0 1.0 2.0 FALSE
			IF flag_player_on_mission = 0
				IF CAN_PLAYER_START_MISSION Player
					flag_player_on_mission = 1 // SCFIX
					TURN_PHONE_OFF hood_phone

					MAKE_PLAYER_SAFE_FOR_CUTSCENE Player

					SET_FADING_COLOUR 0 0 0

					DO_FADE 1500 FADE_OUT

					PRINT_BIG ( HM_2 ) 15000 2 //"TOYMINATOR"

					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE

					LOAD_AND_LAUNCH_MISSION hood2.sc
				ENDIF

				/* SCFIX: fix mission not starting if you jump onto the marker
				IF NOT IS_PLAYER_PLAYING player
					GOTO hood_mission2_loop
				ENDIF

				WHILE LOCATE_PLAYER_ON_FOOT_3D player -443.5 -6.1 3.8 1.0 1.0 2.0 FALSE
					WAIT 0
						IF NOT IS_PLAYER_PLAYING player
							GOTO hood_mission2_loop
						ENDIF
				ENDWHILE
				*/
			ENDIF
		ENDIF
	ENDIF
			
	GOTO hood_mission2_loop

}

// Hood Mission 3

hood_mission3_loop:
{

WAIT mission_trigger_wait_time


	IF flag_hood_mission3_passed = 1

		IF flag_hood_mission5_passed = 0 
			TURN_PHONE_OFF hood_phone
			TERMINATE_THIS_SCRIPT
		ENDIF

	ENDIF
	
	IF flag_player_on_mission = 0
	   TURN_PHONE_ON hood_phone
	ELSE
		TURN_PHONE_OFF hood_phone
	ENDIF
				
	IF IS_PLAYER_PLAYING player	
		IF LOCATE_STOPPED_PLAYER_ON_FOOT_3D	player -443.5 -6.1 3.8 1.0 1.0 2.0 FALSE
			IF flag_player_on_mission = 0
				IF CAN_PLAYER_START_MISSION Player
					flag_player_on_mission = 1 // SCFIX
					TURN_PHONE_OFF hood_phone

					MAKE_PLAYER_SAFE_FOR_CUTSCENE Player

					SET_FADING_COLOUR 0 0 0

					DO_FADE 1500 FADE_OUT

					PRINT_BIG ( HM_3 ) 15000 2 //"RIGGED TO BLOW"

					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE

					LOAD_AND_LAUNCH_MISSION hood3.sc
				ENDIF

				/* SCFIX: fix mission not starting if you jump onto the marker
				IF NOT IS_PLAYER_PLAYING player
					GOTO hood_mission3_loop
				ENDIF

				WHILE LOCATE_PLAYER_ON_FOOT_3D player -443.5 -6.1 3.8 1.0 1.0 2.0 FALSE
					WAIT 0
						IF NOT IS_PLAYER_PLAYING player
							GOTO hood_mission3_loop
						ENDIF
				ENDWHILE
				*/
			ENDIF
		ENDIF
	ENDIF
			
	GOTO hood_mission3_loop

}

// Hood Mission 4

hood_mission4_loop:
{

WAIT mission_trigger_wait_time


	IF flag_hood_mission4_passed = 1
		TURN_PHONE_OFF hood_phone
		TERMINATE_THIS_SCRIPT
	ENDIF
	
	IF flag_player_on_mission = 0
	   TURN_PHONE_ON hood_phone
	ELSE
		TURN_PHONE_OFF hood_phone
	ENDIF
				
	IF IS_PLAYER_PLAYING player	
		IF LOCATE_STOPPED_PLAYER_ON_FOOT_3D	player -443.5 -6.1 3.8 1.0 1.0 2.0 FALSE
			IF flag_player_on_mission = 0
				IF CAN_PLAYER_START_MISSION Player
					flag_player_on_mission = 1 // SCFIX
					TURN_PHONE_OFF hood_phone

					MAKE_PLAYER_SAFE_FOR_CUTSCENE Player

					SET_FADING_COLOUR 0 0 0

					DO_FADE 1500 FADE_OUT

					PRINT_BIG ( HM_4 ) 15000 2 //"GOLD GRAB"	

					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE

					LOAD_AND_LAUNCH_MISSION hood4.sc
				ENDIF

				/* SCFIX: fix mission not starting if you jump onto the marker
				IF NOT IS_PLAYER_PLAYING player
					GOTO hood_mission4_loop
				ENDIF

				WHILE LOCATE_PLAYER_ON_FOOT_3D player -443.5 -6.1 3.8 1.0 1.0 2.0 FALSE
					WAIT 0
						IF NOT IS_PLAYER_PLAYING player
							GOTO hood_mission4_loop
						ENDIF
				ENDWHILE
				*/
			ENDIF
		ENDIF
	ENDIF
			
	GOTO hood_mission4_loop

}

// Hood Mission 5

hood_mission5_loop:
{

WAIT mission_trigger_wait_time


	IF flag_hood_mission5_passed = 1
		TURN_PHONE_OFF hood_phone
		TERMINATE_THIS_SCRIPT
	ENDIF
	
	IF flag_player_on_mission = 0
	   TURN_PHONE_ON hood_phone
	ELSE
		TURN_PHONE_OFF hood_phone
	ENDIF
			
	IF IS_PLAYER_PLAYING player	
		IF LOCATE_STOPPED_PLAYER_ON_FOOT_3D	player -443.5 -6.1 3.8 1.0 1.0 2.0 FALSE
			IF flag_player_on_mission = 0
				IF CAN_PLAYER_START_MISSION Player
					flag_player_on_mission = 1 // SCFIX
					TURN_PHONE_OFF hood_phone

					MAKE_PLAYER_SAFE_FOR_CUTSCENE Player

					SET_FADING_COLOUR 0 0 0

					DO_FADE 1500 FADE_OUT

					PRINT_BIG ( HM_5 ) 15000 2 //"RUMBLE BLUES"

					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE

					LOAD_AND_LAUNCH_MISSION hood5.sc
				ENDIF

				/* SCFIX: fix mission not starting if you jump onto the marker
				IF NOT IS_PLAYER_PLAYING player
					GOTO hood_mission5_loop
				ENDIF

				WHILE LOCATE_PLAYER_ON_FOOT_3D player -443.5 -6.1 3.8 1.0 1.0 2.0 FALSE
					WAIT 0
						IF NOT IS_PLAYER_PLAYING player
							GOTO hood_mission5_loop
						ENDIF
				ENDWHILE
				*/
			ENDIF
		ENDIF
	ENDIF
			
	GOTO hood_mission5_loop

}


// Catalina Mission 1

cat_mission1_loop:
{

WAIT mission_trigger_wait_time

	IF flag_cat_mission1_passed = 1
		TERMINATE_THIS_SCRIPT
	ENDIF
	
	IF IS_PLAYER_PLAYING player
		IF LOCATE_PLAYER_ON_FOOT_3D Player -362.8 246.5 60.0 4.5 4.5 2.0 FALSE
			IF flag_player_on_mission = 0
				IF nicked_half_a_mil_before = 1
					GOTO payed_before
				ENDIF 

				IF IS_SCORE_GREATER Player 499999
					payed_before:
						IF CAN_PLAYER_START_MISSION Player
							flag_player_on_mission = 1 // SCFIX

							MAKE_PLAYER_SAFE_FOR_CUTSCENE Player

							SET_FADING_COLOUR 0 0 0

							DO_FADE 1500 FADE_OUT

							SWITCH_STREAMING OFF

							PRINT_BIG ( CAT2 ) 15000 2 //"Catalina"

							WHILE GET_FADING_STATUS
								WAIT 0
							ENDWHILE

							LOAD_AND_LAUNCH_MISSION cat1.sc
						ENDIF

						/* SCFIX: fix mission not starting if you jump onto the marker
						IF NOT IS_PLAYER_PLAYING player
							GOTO cat_mission1_loop
						ENDIF

						WHILE LOCATE_PLAYER_ON_FOOT_3D Player -362.8 246.5 60.0 4.5 4.5 2.0 FALSE
							WAIT 0
							IF NOT IS_PLAYER_PLAYING player
								GOTO cat_mission1_loop
							ENDIF
						ENDWHILE
						*/

				ELSE 
					PRINT_NOW ( CAT_MON ) 5000 1 //"You don't have enough money"
					WHILE LOCATE_PLAYER_ON_FOOT_3D Player -362.8 246.5 60.0 4.5 4.5 2.0 FALSE
						WAIT 0
						IF NOT IS_PLAYER_PLAYING player
							GOTO cat_mission1_loop
						ENDIF
					ENDWHILE
				ENDIF
			ENDIF
		ENDIF
	ENDIF
			
	GOTO cat_mission1_loop

}


ind_save_loop:
{
//	Should be called before main loop

	SCRIPT_NAME I_SAVE

ind_save_loop_inner:

	WAIT 250

	IF IS_PLAYER_PLAYING Player

		IF IS_COLLISION_IN_MEMORY LEVEL_INDUSTRIAL
						   
			//SAVE HOUSE BLIP
			IF created_ind_blip_before = 0 
				REMOVE_BLIP	industrail_save_blip
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT 870.0 -308.2 -100.0 RADAR_SPRITE_SAVE industrail_save_blip
				CHANGE_BLIP_DISPLAY industrail_save_blip BLIP_ONLY
				created_ind_blip_before = 1
			ENDIF		
	
		//SAVE HOUSE DOOR
			IF IS_PLAYER_IN_ZONE player REDLIGH

				IF flag_eightball_mission_passed = 1
					IF flag_player_on_mission = 0
						WHILE NOT ROTATE_OBJECT playersdoor 210.0 10.0 FALSE
							WAIT 0

						ENDWHILE
					ELSE
						WHILE NOT ROTATE_OBJECT playersdoor 0.0 10.0 FALSE
							WAIT 0

						ENDWHILE
					ENDIF
				ENDIF

				//INDUSTRIAL SAVE HOUSE
				IF IS_PLAYER_PLAYING Player
					IF CAN_PLAYER_START_MISSION Player // allowing the player to jump around inside
						IF flag_player_on_mission = 0
							IF IS_PLAYER_IN_AREA_ON_FOOT_3D player 891.2 -309.7 7.7 899.3 -303.3 12.7 FALSE //REAL ONE!!!!!!!
								flag_player_on_mission = 1 // SCFIX
								SET_PLAYER_CONTROL Player Off
								SET_FIXED_CAMERA_POSITION 884.56 -305.35 13.53 0.0 0.0 0.0
								POINT_CAMERA_AT_POINT 885.25 -305.85 13.0 JUMP_CUT
								
								LOAD_MISSION_AUDIO DOOR_1
								WHILE NOT HAS_MISSION_AUDIO_LOADED
									WAIT 0
								ENDWHILE
								PLAY_MISSION_AUDIO
								
								WHILE NOT ROTATE_OBJECT playersdoor 0.0 8.0 FALSE
									WAIT 0

								ENDWHILE
								
								WHILE NOT HAS_MISSION_AUDIO_FINISHED
									WAIT 0
								ENDWHILE
							
								ACTIVATE_SAVE_MENU //THE GAME SAVES/RE-LOADS HERE!!!!!
														
								WAIT 0
															
								WHILE NOT HAS_SAVE_GAME_FINISHED
									WAIT 0

								ENDWHILE

								SET_FADING_COLOUR 0 0 0
								DO_FADE 1000 FADE_OUT
								IF IS_PLAYER_PLAYING Player
									SET_PLAYER_CONTROL Player Off
								ENDIF

								WAIT 1000
								/*
								LOAD_MISSION_AUDIO DOOR_2
								WHILE NOT HAS_MISSION_AUDIO_LOADED
									WAIT 0
								ENDWHILE
								PLAY_MISSION_AUDIO
								*/
	 							WHILE NOT ROTATE_OBJECT playersdoor 210.0 10.0 FALSE
							 		WAIT 0

								ENDWHILE

								CLEAR_AREA 888.6 -308.4 -100.0 1.0 TRUE

								IF IS_PLAYER_PLAYING Player
			 		   				SET_PLAYER_COORDINATES player 888.6 -308.4 -100.0
									SET_PLAYER_HEADING player 90.0

									DO_FADE 1000 FADE_IN
									RESTORE_CAMERA_JUMPCUT
									SET_CAMERA_IN_FRONT_OF_PLAYER
								ENDIF

								WAIT 1000

								IF IS_PLAYER_PLAYING Player
									SET_PLAYER_CONTROL Player on
									flag_player_on_mission = 0 // SCFIX
								ENDIF
									
							ENDIF
						ENDIF
					ENDIF //	IF CAN_PLAYER_START_MISSION Player
				ENDIF

			ENDIF // IF IS_PLAYER_IN_ZONE player REDLIGH
		ELSE	// not in industrial

			IF created_ind_blip_before = 1
				REMOVE_BLIP industrail_save_blip
				created_ind_blip_before = 0
			ENDIF

		ENDIF	//	IF IS_COLLISION_IN_MEMORY LEVEL_INDUSTRIAL
	ENDIF // IF IS_PLAYER_PLAYING Player

	GOTO ind_save_loop_inner
}


ind_restart:
{
//	Should be called before main loop

	SCRIPT_NAME I_RSTRT

ind_restart_inner:

	WAIT 1000

	IF IS_PLAYER_PLAYING Player

		IF IS_COLLISION_IN_MEMORY LEVEL_INDUSTRIAL 

			ADD_HOSPITAL_RESTART 1144.3 -596.9 13.9	90.0
			ADD_POLICE_RESTART 1143.9 -675.2 -100.0	90.0
			TERMINATE_THIS_SCRIPT
		ENDIF

	ENDIF

	GOTO ind_restart_inner
}

diablo_phone_start:
{
//	Should be called in joey3 mission passed

	SCRIPT_NAME DIAB_PH

diablo_phone_start_inner:

	WAIT 10000

	IF IS_PLAYER_PLAYING Player
		IF IS_COLLISION_IN_MEMORY LEVEL_INDUSTRIAL

		// Diablo Phone
			IF flag_player_on_mission = 0

				ADD_PAGER_MESSAGE ( DIAB1_A ) 140 2 0  
				START_NEW_SCRIPT diablo_mission1_loop
				START_NEW_SCRIPT diablo_blip_loop
				TERMINATE_THIS_SCRIPT

			ENDIF
		ENDIF
	ENDIF

	GOTO diablo_phone_start_inner
}

diablo_blip_loop:
{
//	Should be called in diablo_phone_start

	SCRIPT_NAME DIAB_BP

diablo_blip_loop_inner:

	WAIT 1000

	IF IS_PLAYER_PLAYING Player
		IF IS_COLLISION_IN_MEMORY LEVEL_INDUSTRIAL

			// SCFIX: START
			IF flag_diablo_mission4_passed = 1
				TERMINATE_THIS_SCRIPT
			ENDIF
			// SCFIX: END

			IF blip_diablo_created_before = 0
				REMOVE_BLIP diablo_contact_blip
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT 938.4 -230.5 -100.0 RADAR_SPRITE_EL diablo_contact_blip
				blip_diablo_created_before = 1
			ENDIF
		ELSE

			IF blip_diablo_created_before = 1
				REMOVE_BLIP	diablo_contact_blip
				blip_diablo_created_before = 0
			ENDIF

		ENDIF

	ENDIF

	GOTO diablo_blip_loop_inner
}

joeys_buggy_loop:
{
// Should be called in asuka1 mission passed

	SCRIPT_NAME JOE_BUG

joeys_buggy_loop_inner:

	WAIT 500

	IF IS_PLAYER_PLAYING Player

		IF IS_COLLISION_IN_MEMORY LEVEL_INDUSTRIAL 

		//START JOEYS BUGGY GENERATOR AT MISTYS
	 		GET_TIME_OF_DAY hours minutes
			IF hours > 17
			AND hours < 24
				IF started_buggy_generator_before = 0
					SWITCH_CAR_GENERATOR joeys_buggy 101
					ADD_CONTINUOUS_SOUND 937.1 -275.5 8.9 SOUND_MISTYS_HOUSE_LOOP_L misty_joey_loop //misty and joey
					started_buggy_generator_before = 1
				ENDIF			
			ELSE
				IF started_buggy_generator_before = 1
					SWITCH_CAR_GENERATOR joeys_buggy 0
					REMOVE_SOUND misty_joey_loop
					started_buggy_generator_before = 0
				ENDIF
			ENDIF							
		ENDIF
	ENDIF

	GOTO joeys_buggy_loop_inner
}

toni5_flames_loop:
{
//	Should be called in toni5 mission passed

	SCRIPT_NAME TONI_FR

toni5_flames_loop_inner:

	WAIT 500

	IF IS_PLAYER_PLAYING Player
		//SWITCH OFF FLAMES AFTER TONI 5
		IF NOT IS_PLAYER_IN_ZONE Player PORT_W
			REMOVE_ALL_SCRIPT_FIRES
			TERMINATE_THIS_SCRIPT
		ENDIF
	ENDIF

	GOTO toni5_flames_loop_inner
}

blob_help_loop:
{
//	Should be called in eightball mission passed

	SCRIPT_NAME BLOB_HP

blob_help_loop_inner:

	WAIT 100

	IF IS_PLAYER_PLAYING Player
		//CONTACT BLOB HELP MESSAGE
		IF IS_PLAYER_IN_AREA_ON_FOOT_3D player 895.3 -428.0 12.0 900.3 -423.2 18.0 FALSE
			PRINT_HELP ( HELP12 ) // Tells player about contact blobs
			TERMINATE_THIS_SCRIPT
		ENDIF
	ENDIF

	GOTO blob_help_loop_inner
}

toni4_pager_loop:
{
//	Should be called in frankie2 mission passed

	SCRIPT_NAME TONI4PG

toni4_pager_loop_inner:

	WAIT 10000

	IF IS_PLAYER_PLAYING Player

		IF flag_player_on_mission = 0

			IF IS_COLLISION_IN_MEMORY LEVEL_INDUSTRIAL 

				//ADD MESSAGE AFTER FRANKIE 2 IS PASSED AND TONI 4 IS NOT COMPLETED
				IF flag_toni_mission4_passed = 0
					ADD_PAGER_MESSAGE ( TONI_P ) 140 2 0
				ENDIF

				START_NEW_SCRIPT toni5_pager_loop
				TERMINATE_THIS_SCRIPT

			ENDIF

		ENDIF
	ENDIF

	GOTO toni4_pager_loop_inner
}

toni5_pager_loop:
{
//	Should be called in toni4_pager_loop

	SCRIPT_NAME TONI5PG

toni5_pager_loop_inner:

	WAIT 10000

	IF IS_PLAYER_PLAYING Player

		IF flag_player_on_mission = 0

			IF IS_COLLISION_IN_MEMORY LEVEL_INDUSTRIAL 

				//ADD MESSAGE AFTER FRANKIE 2 IS PASSED AND TONI 5 IS NOT COMPLETED
				IF flag_toni_mission4_passed = 1

					IF flag_toni_mission5_passed = 0
						ADD_PAGER_MESSAGE ( TONI_P ) 140 2 0
					ENDIF

					TERMINATE_THIS_SCRIPT

				ENDIF
			ENDIF

		ENDIF
	ENDIF

	GOTO toni5_pager_loop_inner
}

close_fuzz_doors:
{
// Should be called in cleanup for luigi5

	SCRIPT_NAME FUZZ_DR

	WHILE flag_moved_door1_lm5 = 0
	OR flag_moved_door2_lm5 = 0

		WAIT 0
		   
  		IF counter_girls_trying_to_get_to_ball = 0
				
			IF NOT IS_AREA_OCCUPIED 1008.0 -899.0 14.0 996.5 -886.5 20.0 FALSE TRUE TRUE FALSE TRUE

				IF ROTATE_OBJECT fuzz_door1 180.0 10.0 FALSE
					flag_moved_door1_lm5 = 1
				ENDIF	
		
				IF ROTATE_OBJECT fuzz_door2 0.0 10.0 FALSE
					flag_moved_door2_lm5 = 1
				ENDIF

			ENDIF

		ENDIF

	ENDWHILE

	TERMINATE_THIS_SCRIPT
}


com_save_loop:
{
// Should be called before main loop

	SCRIPT_NAME C_SAVE

com_save_loop_inner:

	WAIT 250

	IF IS_PLAYER_PLAYING Player
		IF IS_COLLISION_IN_MEMORY LEVEL_COMMERCIAL
		 
			//SAVE HOUSE BLIP
			IF created_com_blip_before = 0
				REMOVE_BLIP	commercial_save_blip
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT 103.3 -469.2 -100.0 RADAR_SPRITE_SAVE commercial_save_blip
				CHANGE_BLIP_DISPLAY commercial_save_blip BLIP_ONLY
				created_com_blip_before = 1
			ENDIF

			//SAVE HOUSE DOORS
			IF IS_PLAYER_IN_ZONE player PARK 

				IF flag_player_on_mission = 0
					WHILE NOT SLIDE_OBJECT plysav_lftdr_lft 105.35 -482.8 16.25 0.1 0.0 0.0 FALSE
					OR NOT SLIDE_OBJECT plysav_lftdr_rght 100.692 -482.8 16.25 0.1 0.0 0.0 FALSE
						WAIT 0

					ENDWHILE

				ELSE
					WHILE NOT SLIDE_OBJECT plysav_lftdr_lft 103.85 -482.8 16.25 0.1 0.0 0.0 FALSE
					OR NOT SLIDE_OBJECT plysav_lftdr_rght 102.192 -482.8 16.25 0.1 0.0 0.0 FALSE
						WAIT 0

					ENDWHILE
				ENDIF

				//COMMERCIAL SAVE HOUSE
				IF IS_PLAYER_PLAYING Player
					IF CAN_PLAYER_START_MISSION Player
						IF flag_player_on_mission = 0
							IF IS_PLAYER_IN_AREA_ON_FOOT_3D player 105.7 -486.0 15.0 100.8 -483.4 18.0 FALSE
								flag_player_on_mission = 1 // SCFIX
								SET_PLAYER_CONTROL Player Off
								SET_FIXED_CAMERA_POSITION 98.53 -472.06 19.84 0.0 0.0 0.0
								POINT_CAMERA_AT_POINT 98.94 -472.90 19.47 JUMP_CUT

								LOAD_MISSION_AUDIO DOOR_3
								WHILE NOT HAS_MISSION_AUDIO_LOADED
									WAIT 0
								ENDWHILE
								PLAY_MISSION_AUDIO

								WHILE NOT SLIDE_OBJECT plysav_lftdr_lft 103.85 -482.8 16.25 0.0625 0.0 0.0 FALSE
								OR NOT SLIDE_OBJECT plysav_lftdr_rght 102.192 -482.8 16.25 0.0625 0.0 0.0 FALSE
									WAIT 0

								ENDWHILE

								WHILE NOT HAS_MISSION_AUDIO_FINISHED
									WAIT 0
								ENDWHILE

								ACTIVATE_SAVE_MENU //THE GAME SAVES/RE-LOADS HERE!!!!!

								WAIT 0
									
								WHILE NOT HAS_SAVE_GAME_FINISHED
									WAIT 0

								ENDWHILE

								SET_FADING_COLOUR 0 0 0
								DO_FADE 1000 FADE_OUT
				 				IF IS_PLAYER_PLAYING Player
									SET_PLAYER_CONTROL Player OFF
								ENDIF

								WAIT 1000
								/*
								LOAD_MISSION_AUDIO DOOR_4
								WHILE NOT HAS_MISSION_AUDIO_LOADED
									WAIT 0
								ENDWHILE
								PLAY_MISSION_AUDIO
								*/
								WHILE NOT SLIDE_OBJECT plysav_lftdr_lft 105.35 -482.8 16.25 0.1 0.0 0.0 FALSE
								OR NOT SLIDE_OBJECT plysav_lftdr_rght 100.692 -482.8 16.25 0.1 0.0 0.0 FALSE
									WAIT 0

								ENDWHILE
								
								CLEAR_AREA 103.0 -478.5 14.9 1.0 TRUE

								IF IS_PLAYER_PLAYING Player
					 		   		SET_PLAYER_COORDINATES player 103.0 -478.5 14.9
									SET_PLAYER_HEADING player 0.0

									DO_FADE 1000 FADE_IN
									RESTORE_CAMERA_JUMPCUT
									SET_CAMERA_IN_FRONT_OF_PLAYER
								ENDIF

								WAIT 1000

								IF IS_PLAYER_PLAYING Player
									SET_PLAYER_CONTROL Player on
									flag_player_on_mission = 0 // SCFIX
								ENDIF
										
							ENDIF
						ENDIF
					ENDIF	//	IF CAN_PLAYER_START_MISSION Player
				ENDIF

			ENDIF // IF IS_PLAYER_IN_ZONE player PARK
		ELSE	// not in commercial

			IF created_com_blip_before = 1
				REMOVE_BLIP commercial_save_blip
				created_com_blip_before = 0
			ENDIF

		ENDIF	//	IF IS_COLLISION_IN_MEMORY LEVEL_COMMERCIAL
	ENDIF // IF IS_PLAYER_PLAYING Player

	GOTO com_save_loop_inner
}

com_restart:
{
// Should be called before main loop

	SCRIPT_NAME C_RSTRT

com_restart_inner:

	WAIT 1000

	IF IS_PLAYER_PLAYING Player
		IF IS_COLLISION_IN_MEMORY LEVEL_COMMERCIAL
		 
			IF flag_industrial_passed = 1
				ADD_HOSPITAL_RESTART 183.5 -17.8 16.2 180.0
				ADD_POLICE_RESTART 340.3 -1123.4 25.0 180.0
				SET_MAX_WANTED_LEVEL 5
				TERMINATE_THIS_SCRIPT
			ENDIF
		ENDIF
	ENDIF

	GOTO com_restart_inner
}


yardie_phone_start:
{
//	Should be called in asuka1 mission passed

	SCRIPT_NAME YARD_PH

yardie_phone_start_inner:

	WAIT 10000

	IF IS_PLAYER_PLAYING Player
		IF IS_COLLISION_IN_MEMORY LEVEL_COMMERCIAL
			
			// Yardie Phone
			IF flag_player_on_mission = 0 

				ADD_PAGER_MESSAGE ( YD_P ) 140 2 0	 
				START_NEW_SCRIPT yardie_mission1_loop
				START_NEW_SCRIPT yardie_blip_loop
				TERMINATE_THIS_SCRIPT

			ENDIF	
		ENDIF //IS_PLAYER_IN_ZONE
	ENDIF //IS PLAYER PLAYING

	GOTO yardie_phone_start_inner
}

yardie_blip_loop:
{
//	Should be called in yardie_phone_start

	SCRIPT_NAME YARD_BP

yardie_blip_loop_inner:

	WAIT 1000

	IF IS_PLAYER_PLAYING Player
		IF IS_COLLISION_IN_MEMORY LEVEL_COMMERCIAL

			IF flag_yardie_mission4_passed = 1
				TERMINATE_THIS_SCRIPT
			ENDIF

			IF blip_yardie_created_before = 0
				REMOVE_BLIP	yardie_contact_blip
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT 120.7 -272.1 16.1 RADAR_SPRITE_LIZ yardie_contact_blip
				//FLASH_RADAR_BLIP yardie_contact_blip
				blip_yardie_created_before = 1
			ENDIF
		ELSE

//			IF flag_yardie_mission4_passed = 0
				IF blip_yardie_created_before = 1
					REMOVE_BLIP	yardie_contact_blip
					blip_yardie_created_before = 0
				ENDIF
//			ENDIF

		ENDIF
	ENDIF

	GOTO yardie_blip_loop_inner
}

close_asuka1_door:
{
// Should be called in cleanup for asuka1

	SCRIPT_NAME ASUK_DR

	IF DOES_OBJECT_EXIST backdoor
		GET_OBJECT_HEADING backdoor door_position_a1
		IF door_crash_flag = 1
			WHILE NOT door_position_a1 = 0.0
				
				IF IS_PLAYER_PLAYING player
					IF NOT IS_PLAYER_IN_AREA_3D player 889.618 -418.098 15.0 895.151 -412.675 18.0 0
					//IF NOT IS_PLAYER_IN_AREA_3D player 893.494 -417.093 14.943 894.934 -413.657 17.916 0
						IF door_position_a1 > -10.0
						AND door_position_a1 < 10.0
							door_position_a1 = 0.0
						ELSE
							door_position_a1 -= 10.0
						ENDIF
						SET_OBJECT_HEADING backdoor door_position_a1
					ENDIF
				ELSE
					door_position_a1 = 0.0
					SET_OBJECT_HEADING backdoor door_position_a1
				ENDIF

				WAIT 0
			ENDWHILE
		ENDIF
	ENDIF

	TERMINATE_THIS_SCRIPT
}



sub_save_loop:
{
//	Should be called before main loop

	SCRIPT_NAME S_SAVE

sub_save_loop_inner:

	WAIT 250

	IF IS_PLAYER_PLAYING Player
		IF IS_COLLISION_IN_MEMORY LEVEL_SUBURBAN
	
			//SAVE HOUSE BLIP
			IF created_sub_blip_before = 0
				REMOVE_BLIP	suburban_save_blip
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT -665.0 -6.5 -100.0 RADAR_SPRITE_SAVE suburban_save_blip
				CHANGE_BLIP_DISPLAY suburban_save_blip BLIP_ONLY
				created_sub_blip_before = 1
			ENDIF

			//SAVE HOUSE DOOR
			IF IS_PLAYER_IN_ZONE player PROJECT

				IF flag_player_on_mission = 0
					WHILE NOT ROTATE_OBJECT newtowerdoor1 250.0 10.0 FALSE
						WAIT 0

					ENDWHILE
				ELSE
					WHILE NOT ROTATE_OBJECT newtowerdoor1 180.0 10.0 FALSE
						WAIT 0

					ENDWHILE
				ENDIF

				//SUBURBAN SAVE HOUSE
				IF IS_PLAYER_PLAYING Player
					IF CAN_PLAYER_START_MISSION Player
						IF flag_player_on_mission = 0	
							IF IS_PLAYER_IN_AREA_ON_FOOT_3D player -670.5 3.9 18.0 -660.0 12.7 22.0 FALSE
									flag_player_on_mission = 1 // SCFIX
									SET_PLAYER_CONTROL Player Off
									SET_FIXED_CAMERA_POSITION -678.15 -6.46 24.49 0.0 0.0 0.0
									POINT_CAMERA_AT_POINT -677.39 -5.92 24.11 JUMP_CUT
									/*
									LOAD_MISSION_AUDIO DOOR_5
									WHILE NOT HAS_MISSION_AUDIO_LOADED
										WAIT 0
									ENDWHILE
									PLAY_MISSION_AUDIO
									*/
									WHILE NOT ROTATE_OBJECT newtowerdoor1 180.0 8.0 FALSE
										WAIT 0

									ENDWHILE
									/*
									WHILE NOT HAS_MISSION_AUDIO_FINISHED
										WAIT 0

									ENDWHILE
									*/
									ACTIVATE_SAVE_MENU //THE GAME SAVES/RE-LOADS HERE!!!!!
											
									WAIT 0
																
									WHILE NOT HAS_SAVE_GAME_FINISHED
										WAIT 0

									ENDWHILE

									SET_FADING_COLOUR 0 0 0
									DO_FADE 1000 FADE_OUT
					 				IF IS_PLAYER_PLAYING Player
										SET_PLAYER_CONTROL Player Off
									ENDIF

									WAIT 1000
									/*
									LOAD_MISSION_AUDIO DOOR_6
									WHILE NOT HAS_MISSION_AUDIO_LOADED
										WAIT 0
									ENDWHILE
									PLAY_MISSION_AUDIO
									*/
									WHILE NOT ROTATE_OBJECT newtowerdoor1 250.0 10.0 FALSE
										WAIT 0

									ENDWHILE

									CLEAR_AREA -666.8 -1.8 -100.0 1.0 TRUE

									IF IS_PLAYER_PLAYING Player
						 		   		SET_PLAYER_COORDINATES player -666.8 -1.8 -100.0
										SET_PLAYER_HEADING player 180.0

										DO_FADE 1000 FADE_IN
										RESTORE_CAMERA_JUMPCUT
										SET_CAMERA_IN_FRONT_OF_PLAYER
									ENDIF

									WAIT 1000
									
								IF IS_PLAYER_PLAYING Player
									SET_PLAYER_CONTROL Player on
									flag_player_on_mission = 0 // SCFIX
								ENDIF
										
							ENDIF
						ENDIF
					ENDIF	//	IF CAN_PLAYER_START_MISSION Player
				ENDIF

			ENDIF // IF IS_PLAYER_IN_ZONE player PROJECT
		ELSE //	not in suburban

			IF created_sub_blip_before = 1
				REMOVE_BLIP	suburban_save_blip
				created_sub_blip_before = 0
			ENDIF

		ENDIF	//	IF IS_COLLISION_IN_MEMORY LEVEL_SUBURBAN
	ENDIF // IF IS_PLAYER_PLAYING Player

	GOTO sub_save_loop_inner
}

sub_restart:
{
//	Should be called before main loop

	SCRIPT_NAME S_RSTRT

sub_restart_inner:

	WAIT 1000

	IF IS_PLAYER_PLAYING Player
		IF IS_COLLISION_IN_MEMORY LEVEL_SUBURBAN
	
			IF flag_commercial_passed = 1 
				ADD_HOSPITAL_RESTART -1253.0 -138.2 57.8 90.0
				ADD_POLICE_RESTART -1259.5 -44.5 57.8 90.0
				SET_MAX_WANTED_LEVEL 6
				TERMINATE_THIS_SCRIPT
			ENDIF
		ENDIF
	ENDIF

	GOTO sub_restart_inner
}


hood_phone_start:
{
//	Should be called in love3 mission passed

	SCRIPT_NAME HOOD_PH

hood_phone_start_inner:

	WAIT 10000

	IF IS_PLAYER_PLAYING Player
		IF IS_COLLISION_IN_MEMORY LEVEL_SUBURBAN

			// Hood Phone
			IF flag_player_on_mission = 0 

				ADD_PAGER_MESSAGE ( HOOD1_A ) 140 2 0 
				START_NEW_SCRIPT hood_mission1_loop
				START_NEW_SCRIPT hood_blip_loop
				TERMINATE_THIS_SCRIPT

			ENDIF	
		ENDIF	//	IF IS_COLLISION_IN_MEMORY LEVEL_SUBURBAN
	ENDIF // IF IS_PLAYER_PLAYING Player

	GOTO hood_phone_start_inner
}

hood_blip_loop:
{
//	Should be called in hood_phone_start

	SCRIPT_NAME HOOD_BP

hood_blip_loop_inner:

	WAIT 1000

	IF IS_PLAYER_PLAYING Player
		IF IS_COLLISION_IN_MEMORY LEVEL_SUBURBAN

			IF flag_hood_mission5_passed = 1
				TERMINATE_THIS_SCRIPT
			ENDIF

			IF flag_blip_hood_created = 0
				REMOVE_BLIP	hood_contact_blip
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT -443.5 -6.1 3.8 RADAR_SPRITE_ICE hood_contact_blip
				flag_blip_hood_created = 1
			ENDIF
		ELSE

			IF flag_blip_hood_created = 1
				REMOVE_BLIP	hood_contact_blip
				flag_blip_hood_created = 0
			ENDIF

		ENDIF //IS_PLAYER_IN_ZONE
	ENDIF //IS PLAYER PLAYING

	GOTO hood_blip_loop_inner
}


luigi_message:

// Called after Luigis Girls passed
{

	SCRIPT_NAME Luihelp

	WAIT 1000

	IF IS_PLAYER_PLAYING player

		IF flag_had_luigi_help_message = 0

			IF flag_luigi_mission1_passed = 1
				PRINT_HELP ( LM1_8 ) //"Work for Luigi or piss about!"
				flag_had_luigi_help_message = 1
			ENDIF

		ENDIF

		IF flag_had_luigi_help_message = 1
			timera = 0
			flag_had_luigi_help_message = 2
		ENDIF

		WHILE timera < 6000

			WAIT 0

		ENDWHILE
		
		IF flag_had_luigi_help_message = 2

			IF flag_player_on_mission = 0
				PRINT_HELP ( LM1_8A ) //"To earn some extra cash, why not 'borrow' a taxi..."  
				flag_had_luigi_help_message = 3
			ENDIF
				
		ENDIF	
		

	ENDIF

	TERMINATE_THIS_SCRIPT
	
}


pistol_message:

// Called after Luigis 4 or Joey 2 is passed
{

	SCRIPT_NAME pistol1

	pistol_create:

	WAIT 10000

	IF IS_PLAYER_PLAYING player

		IF flag_player_on_mission = 0

			IF out_of_stock_pistol = 0
				REMOVE_PICKUP SHOP_COLT45 
				CREATE_PICKUP WEAPON_COLT45 PICKUP_IN_SHOP 1068.5 -400.8 15.2 SHOP_COLT45_2	//AMMU NATION
   				ADD_PAGER_MESSAGE ( COLT_IN ) 140 2 0
   				out_of_stock_pistol = 1
			ENDIF

		ENDIF

	ENDIF

	IF out_of_stock_pistol = 1 
		TERMINATE_THIS_SCRIPT
	ENDIF

	GOTO pistol_create	
}



uzi_message:

// Called after Joey 4
{

	SCRIPT_NAME uzi1

	uzi_create:

	WAIT 5000

	IF IS_PLAYER_PLAYING player

		IF flag_player_on_mission = 0

			IF out_of_stock_uzi = 0
				ADD_PAGER_MESSAGE ( UZI_IN ) 140 2 0
   				out_of_stock_uzi = 1
			ENDIF

		ENDIF

	ENDIF

	IF out_of_stock_uzi = 1 
		TERMINATE_THIS_SCRIPT
	ENDIF
	
	GOTO uzi_create
}

imp_exp_pager:
{
//To be played after Pulp Friction

	WAIT 100000

	IF flag_player_on_mission = 0
		IF IS_PLAYER_PLAYING Player
			ADD_PAGER_MESSAGE IMPEXPP 140 2 0
			TERMINATE_THIS_SCRIPT
		ENDIF
	ENDIF

	GOTO imp_exp_pager
}

emergency_crane_pager:
{
//To be played after Bomb Da Base

	WAIT 200000

	IF flag_player_on_mission = 0
		IF IS_PLAYER_PLAYING Player
			ADD_PAGER_MESSAGE EMVHPUP 140 2 0
			TERMINATE_THIS_SCRIPT
		ENDIF
	ENDIF

	GOTO emergency_crane_pager
}

van_heist_garage_pager:
{
//To be played after Van Heist

	WAIT 300000

	IF flag_player_on_mission = 0
		IF IS_PLAYER_PLAYING Player
			ADD_PAGER_MESSAGE VANHSTP 140 2 0
			TERMINATE_THIS_SCRIPT
		ENDIF
	ENDIF

	GOTO van_heist_garage_pager
}
