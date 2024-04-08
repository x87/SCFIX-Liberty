MISSION_START
// *****************************************************************************************
// ************************************   The Intro    ************************************* 
// *****************************************************************************************

// Mission start stuff

// SCFIX: START - uncomment this for SSU fix

GOSUB mission_start_intro

GOSUB mission_cleanup_intro // SCFIX: NOTE - separate cleanup subroutine is most likely useless, this is mostly a failsafe 

MISSION_END

// SCFIX: END
 
// Variables for mission

VAR_INT cs_cathead cs_robb robber cs_cs_ban cs_loot	cs_colt1 cs_colt2 cs_bankd csbexpos	skip_flag text_fading_flag
VAR_INT cs_colombian1 cs_colombian2 cs_cop1 cs_cop2	damagea damageb	brbomb cs_colombian1head text_alpha

VAR_FLOAT particle_x particle_y particle_z particle_target_x particle_target_y particle_target_z temp_var

// ****************************************Mission Start************************************

mission_start_intro:

flag_player_on_mission = 1
skip_flag = 0

SET_PLAYER_CONTROL player OFF // SCFIX: paranoid set before WAIT

WAIT 0

{
// SCFIX: START
LVAR_INT flag_intro_swap_bridge flag_intro_unload_models1 flag_intro_unload_models2 flag_intro_unload_models3
LVAR_INT flag_intro_load_splash flag_intro_set1 flag_intro_set2 flag_intro_set3
LVAR_INT flag_eight_loaded
flag_intro_swap_bridge = 0
flag_intro_unload_models1 = 0
flag_intro_unload_models2 = 0
flag_intro_unload_models3 = 0
flag_intro_load_splash = 0
flag_intro_set1 = 0
flag_intro_set2 = 0
flag_intro_set3 = 0
flag_eight_loaded = 0
// SCFIX: END
SCRIPT_NAME intro

SET_FADING_COLOUR 0 0 0

DO_FADE 0 FADE_OUT

SET_EVERYONE_IGNORE_PLAYER player TRUE
SET_PLAYER_CONTROL player OFF
SET_PLAYER_VISIBLE player FALSE
SWITCH_STREAMING OFF

//SET_DEATHARREST_STATE OFF

SWITCH_RUBBISH OFF

// **********************************START OF BANK CUTSCENE****************************

MAKE_PLAYER_SAFE_FOR_CUTSCENE Player

SET_INTRO_IS_PLAYING TRUE

LOAD_COLLISION LEVEL_GENERIC
LOAD_SPECIAL_CHARACTER 1 cat
LOAD_SPECIAL_CHARACTER 2 colrob
LOAD_SPECIAL_CHARACTER 3 miguel
LOAD_SPECIAL_CHARACTER 4 playerx
LOAD_SPECIAL_MODEL cut_obj1	cs_ban
LOAD_SPECIAL_MODEL cut_obj2 bankd
LOAD_SPECIAL_MODEL cut_obj3	cs_loot
LOAD_SPECIAL_MODEL cut_obj4	colt1
LOAD_SPECIAL_MODEL cut_obj5	cath

GET_PLAYER_CHAR	player script_controlled_player
IF NOT IS_CHAR_DEAD script_controlled_player
	
	UNDRESS_CHAR script_controlled_player player
	WHILE NOT HAS_MODEL_LOADED PED_PLAYER 
		WAIT 0
		
	ENDWHILE
	
	IF NOT IS_CHAR_DEAD script_controlled_player
		DRESS_CHAR script_controlled_player
	ENDIF
ENDIF

SET_MOTION_BLUR 5
FORCE_WEATHER_NOW WEATHER_FOGGY
SET_TIME_OF_DAY 12 00

SWITCH_WORLD_PROCESSING OFF

LOAD_ALL_MODELS_NOW

WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_MODEL_LOADED cut_obj1
OR NOT HAS_MODEL_LOADED cut_obj2
OR NOT HAS_MODEL_LOADED cut_obj3
OR NOT HAS_MODEL_LOADED cut_obj4
	WAIT 0
ENDWHILE

WHILE NOT HAS_MODEL_LOADED cut_obj5
OR NOT HAS_SPECIAL_CHARACTER_LOADED 3
OR NOT HAS_SPECIAL_CHARACTER_LOADED 4
	WAIT 0
ENDWHILE

LOAD_CUTSCENE bet
LOAD_SCENE -559.65 1030.56 40.0

SET_CUTSCENE_OFFSET -537.42 1051.204 36.884

CREATE_CUTSCENE_OBJECT PED_SPECIAL4 cs_player
SET_CUTSCENE_ANIM cs_player playerx

CREATE_CUTSCENE_OBJECT PED_SPECIAL1 cs_cat
SET_CUTSCENE_ANIM cs_cat cat

CREATE_CUTSCENE_OBJECT PED_SPECIAL2 cs_robb
SET_CUTSCENE_ANIM cs_robb colrob

CREATE_CUTSCENE_OBJECT PED_SPECIAL3 cs_miguel
SET_CUTSCENE_ANIM cs_miguel miguel

CREATE_CUTSCENE_HEAD cs_cat cut_obj5 cs_cathead
SET_CUTSCENE_HEAD_ANIM cs_cathead cat

CREATE_CUTSCENE_OBJECT cut_obj1 cs_cs_ban
SET_CUTSCENE_ANIM cs_cs_ban cs_ban

CREATE_CUTSCENE_OBJECT cut_obj2 cs_bankd
SET_CUTSCENE_ANIM cs_bankd bankd

CREATE_CUTSCENE_OBJECT cut_obj3 cs_loot
SET_CUTSCENE_ANIM cs_loot cs_loot

CREATE_CUTSCENE_OBJECT cut_obj4 cs_colt1
SET_CUTSCENE_ANIM cs_colt1 colt1

CREATE_CUTSCENE_OBJECT cut_obj4 cs_colt2
SET_CUTSCENE_ANIM cs_colt2 colt2

SET_OBJECT_DRAW_LAST cs_cs_ban TRUE

SWITCH_STREAMING ON

START_CUTSCENE

DO_FADE 2000 FADE_IN

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 17166//17033
	WAIT 0
	GOSUB skip_intro_button
	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF
	GET_CUTSCENE_TIME cs_time
ENDWHILE

SET_MOTION_BLUR 3 //SETS UP THE GREEN SECURITY CAMERA

WHILE cs_time < 18126//18266
	WAIT 0
	GOSUB skip_intro_button
	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF
	GET_CUTSCENE_TIME cs_time
ENDWHILE

SET_MUSIC_DOES_FADE FALSE
IF NOT HAS_CUTSCENE_FINISHED
	SET_FADING_COLOUR 255 255 255 //FLASH SCREEN FOR PLAYER SHOOTING CAMERA
	DO_FADE 100 FADE_OUT
	
	particle_x = -537.42 + 1.759
	particle_y = 1051.204 - 0.416
	particle_z = 36.884	+ 1.9891

	particle_target_x =	-537.42	+ 2.08
	particle_target_y =	1051.204 - 0.9842
	particle_target_z =	36.884 + 2.6714

	temp_var = particle_target_x
	particle_target_x =	particle_x - temp_var

	temp_var = particle_target_y
	particle_target_y =	particle_y - temp_var

	temp_var = particle_target_z
	particle_target_z =	particle_z - temp_var

	ADD_MOVING_PARTICLE_EFFECT POBJECT_CATALINAS_SHOTGUNFLASH particle_x particle_y particle_z particle_target_x particle_target_y particle_target_z 1.0 0 0 0 0

	WHILE GET_FADING_STATUS
		WAIT 0
		GOSUB skip_intro_button
		IF skip_flag = 2
			GOTO skip_intro_here
		ENDIF
	ENDWHILE
ENDIF

IF NOT skip_flag = 2 // SCFIX: was IF NOT HAS_CUTSCENE_FINISHED
	LOAD_SPLASH_SCREEN NEWS
ENDIF

IF NOT HAS_CUTSCENE_FINISHED
	SET_FADING_COLOUR 1 1 1
	DO_FADE 0 FADE_OUT
//	WHILE GET_FADING_STATUS
//		WAIT 0
//		GOSUB skip_intro_button
//		IF skip_flag = 2
//			GOTO skip_intro_here
//		ENDIF
//	ENDWHILE
ENDIF

WHILE cs_time < 18733
	WAIT 0
	GOSUB skip_intro_button
	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF
	GET_CUTSCENE_TIME cs_time
ENDWHILE

IF NOT HAS_CUTSCENE_FINISHED
	SET_FADING_COLOUR 1 1 1
	DO_FADE 0 FADE_IN
ENDIF

SET_MOTION_BLUR 5

WHILE cs_time < 25249
	WAIT 0
	GOSUB skip_intro_button
	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW BETRA_A 4000 1 //"Sorry babe."

WHILE cs_time < 26060
	WAIT 0
	GOSUB skip_intro_button
	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW BETRA_B 5000 1 //"I'm an ambituos girl and you,"

WHILE cs_time < 27000
	WAIT 0
	GOSUB skip_intro_button
	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF
	GET_CUTSCENE_TIME cs_time
ENDWHILE

particle_x = -537.42 - 1.3329
particle_y = 1051.204 + 25.8224
particle_z = 36.884	+ 1.367

particle_target_x =	-537.42	- 0.393
particle_target_y =	1051.204 + 25.8211
particle_target_z =	36.884 + 1.4532

temp_var = particle_target_x
particle_target_x =	particle_x - temp_var

temp_var = particle_target_y
particle_target_y =	particle_y - temp_var

temp_var = particle_target_z
particle_target_z =	particle_z - temp_var

ADD_MOVING_PARTICLE_EFFECT POBJECT_CATALINAS_GUNFLASH particle_x particle_y particle_z particle_target_x particle_target_y particle_target_z 1.0 0 0 0 0

WHILE cs_time < 27030
	WAIT 0
	GOSUB skip_intro_button
	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF
	GET_CUTSCENE_TIME cs_time
ENDWHILE

particle_x = -537.42 - 1.813
particle_y = 1051.204 + 26.0638
particle_z = 36.884	+ 1.369

particle_target_x =	-537.42	- 0.4432
particle_target_y =	1051.204 + 25.9765
particle_target_z =	36.884 + 1.4258

temp_var = particle_target_x
particle_target_x =	particle_x - temp_var

temp_var = particle_target_y
particle_target_y =	particle_y - temp_var

temp_var = particle_target_z
particle_target_z =	particle_z - temp_var

ADD_MOVING_PARTICLE_EFFECT POBJECT_CATALINAS_GUNFLASH particle_x particle_y particle_z particle_target_x particle_target_y particle_target_z 1.0 0 0 0 0

WHILE cs_time < 27100
	WAIT 0
	GOSUB skip_intro_button
	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF
	GET_CUTSCENE_TIME cs_time
ENDWHILE

SET_MOTION_BLUR 8 //PLAYER IS SHOT MOTION BLUR

IF NOT HAS_CUTSCENE_FINISHED
	SET_FADING_COLOUR 255 255 255
	DO_FADE 100 FADE_OUT
	WHILE GET_FADING_STATUS
		WAIT 0
		GOSUB skip_intro_button
		IF skip_flag = 2
			GOTO skip_intro_here
		ENDIF
	ENDWHILE
ENDIF

IF NOT HAS_CUTSCENE_FINISHED
	DO_FADE 600 FADE_IN
	WHILE GET_FADING_STATUS
		WAIT 0
		GOSUB skip_intro_button
		IF skip_flag = 2
			GOTO skip_intro_here
		ENDIF
	ENDWHILE
ENDIF

SET_FADING_COLOUR 0 0 0

WHILE cs_time < 28710
	WAIT 0
	GOSUB skip_intro_button
	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW BETRA_C 2282 1 //"you're just small time."

SET_MUSIC_DOES_FADE TRUE

WHILE cs_time < 29200
	WAIT 0
	GOSUB skip_intro_button
	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF
	GET_CUTSCENE_TIME cs_time
ENDWHILE

SET_MOTION_BLUR 5

WHILE cs_time < 30800
	WAIT 0
	GOSUB skip_intro_button
	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF
	GET_CUTSCENE_TIME cs_time
ENDWHILE

SET_MOTION_BLUR 8 //PLAYER IS SHOT MOTION BLUR

WHILE cs_time < 30992
	WAIT 0
	GOSUB skip_intro_button
	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_PRINTS
CLEAR_SMALL_PRINTS

WHILE cs_time < 33333//36000
	WAIT 0
	GOSUB skip_intro_button
	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF
	GET_CUTSCENE_TIME cs_time
ENDWHILE

SET_FADING_COLOUR 0 0 0
DO_FADE 4000 FADE_OUT

text_alpha = 0
text_fading_flag = 0

USE_TEXT_COMMANDS TRUE

GOSUB draw_intro_text

WHILE GET_FADING_STATUS
	WAIT 0
	GOSUB draw_intro_text
	GOSUB skip_intro_button
	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF
ENDWHILE

WHILE NOT HAS_CUTSCENE_FINISHED
	WAIT 0
	GOSUB draw_intro_text
	GOSUB skip_intro_button
	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF
ENDWHILE

//LOAD_TEXTURE_DICTIONARY INTRO
//LOAD_SPRITE 1 gtalogo
//LOAD_SPRITE 2 gta3bit
//DRAW_SPRITE 1 192.0 96.0 256.0 256.0 255 255 255 text_alpha
//DRAW_SPRITE 2 339.0 224.0 128.0 128.0 255 255 255 text_alpha
//REMOVE_TEXTURE_DICTIONARY

CLEAR_PRINTS
CLEAR_SMALL_PRINTS
CLEAR_CUTSCENE

MAKE_PLAYER_SAFE_FOR_CUTSCENE Player

FORCE_WEATHER_NOW WEATHER_RAINY
FORCE_RAIN TRUE

UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2
UNLOAD_SPECIAL_CHARACTER 3
UNLOAD_SPECIAL_CHARACTER 4
MARK_MODEL_AS_NO_LONGER_NEEDED cut_obj1
MARK_MODEL_AS_NO_LONGER_NEEDED cut_obj2
MARK_MODEL_AS_NO_LONGER_NEEDED cut_obj3
MARK_MODEL_AS_NO_LONGER_NEEDED cut_obj4
MARK_MODEL_AS_NO_LONGER_NEEDED cut_obj5

// **********************************END OF BANK CUTSCENE******************************

// ******************************START OF JAIL BREAK CUTSCENE**************************

SWITCH_STREAMING OFF

LOAD_COLLISION LEVEL_COMMERCIAL
SET_PLAYER_COORDINATES player 820.9 -941.1 -100.0

SET_FADING_COLOUR 0 0 0
SET_MOTION_BLUR 6

LOAD_SPECIAL_CHARACTER 1 eight
LOAD_SPECIAL_CHARACTER 2 OJG_P
LOAD_SPECIAL_CHARACTER 3 col1
LOAD_SPECIAL_CHARACTER 4 col2
LOAD_SPECIAL_MODEL cut_obj1	CS_TRUK
LOAD_SPECIAL_MODEL cut_obj2	REBEL
LOAD_SPECIAL_MODEL cut_obj3	brbomb
LOAD_SPECIAL_MODEL cut_obj4	COL1H
REQUEST_MODEL bridgefuka
REQUEST_MODEL bridgefukb

SET_TIME_OF_DAY 2 00

REQUEST_MODEL trafficlight1
REQUEST_MODEL rd_SrRoad2A50
REQUEST_MODEL rd_SrRoad2A20
REQUEST_MODEL rd_SrRoad2A10
REQUEST_MODEL rd_CrossRda1rw22
REQUEST_MODEL rd_CrossRoadsa24
REQUEST_MODEL com_cust_roads25
REQUEST_MODEL veg_tree3
REQUEST_MODEL doublestreetlght1
REQUEST_MODEL veg_treea3
REQUEST_MODEL veg_treenew17
REQUEST_MODEL Streetlamp1
REQUEST_MODEL bollardlight
REQUEST_MODEL kb_scrap_5
REQUEST_MODEL policetenkb1
REQUEST_MODEL scraperkb3_nit
REQUEST_MODEL chunk5land
REQUEST_MODEL policeally
REQUEST_MODEL police_com
REQUEST_MODEL rd_CrossRda1w22
REQUEST_MODEL treepatchkb7
REQUEST_MODEL roadplanterkb3
REQUEST_MODEL roadplanterkb1
REQUEST_MODEL rd_Road3A50
REQUEST_MODEL amco_floor

LOAD_ALL_MODELS_NOW

WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_SPECIAL_CHARACTER_LOADED 3
OR NOT HAS_SPECIAL_CHARACTER_LOADED 4
OR NOT HAS_MODEL_LOADED cut_obj1
OR NOT HAS_MODEL_LOADED cut_obj2
	WAIT 0
	GOSUB draw_intro_text
ENDWHILE

flag_eight_loaded = 1 // SCFIX

WHILE NOT HAS_MODEL_LOADED cut_obj3
OR NOT HAS_MODEL_LOADED cut_obj4
OR NOT HAS_MODEL_LOADED bridgefuka
OR NOT HAS_MODEL_LOADED bridgefukb
	WAIT 0
	GOSUB draw_intro_text
ENDWHILE

GET_PLAYER_CHAR	player script_controlled_player
IF NOT IS_CHAR_DEAD script_controlled_player
	
	UNDRESS_CHAR script_controlled_player playerp
	WHILE NOT HAS_MODEL_LOADED PED_PLAYER 
		WAIT 0
		GOSUB draw_intro_text
	ENDWHILE
	
	IF NOT IS_CHAR_DEAD script_controlled_player
		DRESS_CHAR script_controlled_player
	ENDIF
ENDIF

LOAD_CUTSCENE JB

SET_CUTSCENE_OFFSET 0.0 0.0 0.0

CREATE_CUTSCENE_OBJECT PED_PLAYER cs_player
SET_CUTSCENE_ANIM cs_player playerp

CREATE_CUTSCENE_OBJECT PED_SPECIAL1 cs_eight
SET_CUTSCENE_ANIM cs_eight eight

CREATE_CUTSCENE_OBJECT PED_SPECIAL2 cs_ojg
SET_CUTSCENE_ANIM cs_ojg ojg_p

CREATE_CUTSCENE_OBJECT PED_SPECIAL3 cs_colombian1
SET_CUTSCENE_ANIM cs_colombian1 col1

CREATE_CUTSCENE_OBJECT PED_SPECIAL4 cs_colombian2
SET_CUTSCENE_ANIM cs_colombian2 col2

CREATE_CUTSCENE_OBJECT PED_COP cs_cop1
SET_CUTSCENE_ANIM cs_cop1 cop

CREATE_CUTSCENE_OBJECT PED_COP cs_cop2
SET_CUTSCENE_ANIM cs_cop2 male01

CREATE_CUTSCENE_HEAD cs_colombian1 cut_obj4 cs_colombian1head
SET_CUTSCENE_HEAD_ANIM cs_colombian1head col1

CREATE_CUTSCENE_OBJECT cut_obj1 cs_colt1
SET_CUTSCENE_ANIM cs_colt1 CS_TRUK

CREATE_CUTSCENE_OBJECT cut_obj2 cs_colt2
SET_CUTSCENE_ANIM cs_colt2 REBEL

CREATE_CUTSCENE_OBJECT cut_obj3 brbomb
SET_CUTSCENE_ANIM brbomb brbomb

SET_OBJECT_DRAW_LAST cs_colt1 TRUE
SET_OBJECT_DRAW_LAST cs_colt2 TRUE

START_CUTSCENE
START_CHASE_SCENE 1.0

CLEAR_PRINTS
CLEAR_SMALL_PRINTS

DO_FADE 2000 FADE_IN

GET_CUTSCENE_TIME cs_time
					  
//REQUEST_MODEL rd_CrossRda1w22 // SCFIX: already loaded
REQUEST_MODEL rd_Road2A20
REQUEST_MODEL broadwaybuild2
REQUEST_MODEL broadwaybuild
REQUEST_MODEL area5build2
REQUEST_MODEL comswcentralbld7
REQUEST_MODEL papermachn01
REQUEST_MODEL comswcentralbld6
REQUEST_MODEL com_21way5
REQUEST_MODEL com_21way50
REQUEST_MODEL com_21way10
REQUEST_MODEL cm1waycrosscom
REQUEST_MODEL com_21way20
REQUEST_MODEL tw@t_cafe
REQUEST_MODEL veg_bush14
REQUEST_MODEL treepatchttwrs
REQUEST_MODEL flatiron1
//REQUEST_MODEL veg_tree3 // SCFIX: already loaded
//REQUEST_MODEL veg_treenew17 // SCFIX: already loaded
REQUEST_MODEL block4_ground01

WHILE cs_time < 9500
	WAIT 0
	text_fading_flag = 1
	GOSUB draw_intro_text
	GOSUB skip_intro_button
	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF
	DRAW_LIGHT 780.55 -942.901 39.022 235 255 250
	DRAW_LIGHT 196.077 -1126.984 25.626	235 255 250
	GET_CUTSCENE_TIME cs_time
ENDWHILE

MARK_MODEL_AS_NO_LONGER_NEEDED rd_SrRoad2A50
MARK_MODEL_AS_NO_LONGER_NEEDED rd_SrRoad2A20
MARK_MODEL_AS_NO_LONGER_NEEDED rd_SrRoad2A10
MARK_MODEL_AS_NO_LONGER_NEEDED rd_CrossRoadsa24
MARK_MODEL_AS_NO_LONGER_NEEDED com_cust_roads25
MARK_MODEL_AS_NO_LONGER_NEEDED veg_treea3
MARK_MODEL_AS_NO_LONGER_NEEDED Streetlamp1
MARK_MODEL_AS_NO_LONGER_NEEDED bollardlight
MARK_MODEL_AS_NO_LONGER_NEEDED kb_scrap_5
MARK_MODEL_AS_NO_LONGER_NEEDED policetenkb1
MARK_MODEL_AS_NO_LONGER_NEEDED scraperkb3_nit
MARK_MODEL_AS_NO_LONGER_NEEDED chunk5land
MARK_MODEL_AS_NO_LONGER_NEEDED policeally
MARK_MODEL_AS_NO_LONGER_NEEDED police_com
MARK_MODEL_AS_NO_LONGER_NEEDED treepatchkb7
MARK_MODEL_AS_NO_LONGER_NEEDED roadplanterkb3
MARK_MODEL_AS_NO_LONGER_NEEDED roadplanterkb1
MARK_MODEL_AS_NO_LONGER_NEEDED rd_Road3A50
MARK_MODEL_AS_NO_LONGER_NEEDED amco_floor


WHILE cs_time < 13007
	WAIT 0
	GOSUB draw_intro_text
	GOSUB skip_intro_button
	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF
	DRAW_LIGHT 780.55 -942.901 39.022 235 255 250
	DRAW_LIGHT 196.077 -1126.984 25.626	235 255 250
	GET_CUTSCENE_TIME cs_time
ENDWHILE

USE_TEXT_COMMANDS FALSE
PRINT_NOW JAILB_V 10000 1//"Liberty city is in shock today."

WHILE cs_time < 14500
	WAIT 0
	GOSUB skip_intro_button
	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF
	DRAW_LIGHT 780.55 -942.901 39.022 235 255 250
	DRAW_LIGHT 196.077 -1126.984 25.626	235 255 250
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW JAILB_A 10000 1//"As the police and emergency services deal with the aftermath..."

WHILE cs_time < 15933
	WAIT 0
	GOSUB skip_intro_button
	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF
	DRAW_LIGHT 780.55 -942.901 39.022 235 255 250
	DRAW_LIGHT 196.077 -1126.984 25.626	235 255 250
	GET_CUTSCENE_TIME cs_time
ENDWHILE

REQUEST_MODEL planter_short
REQUEST_MODEL com_rvroads52
REQUEST_MODEL road_broadway04
REQUEST_MODEL com_roadsrv
REQUEST_MODEL rd_Road1A20
REQUEST_MODEL rd_CrossRoads11
//REQUEST_MODEL doublestreetlght1 // SCFIX: already loaded
REQUEST_MODEL ofis_bildkb_4
REQUEST_MODEL rd_Road1A10
REQUEST_MODEL com_roadkb23
REQUEST_MODEL com_cust_roads57
//REQUEST_MODEL com_rvroads52 // SCFIX: remove duplicate

MARK_MODEL_AS_NO_LONGER_NEEDED rd_CrossRda1w22
MARK_MODEL_AS_NO_LONGER_NEEDED rd_Road2A20
MARK_MODEL_AS_NO_LONGER_NEEDED broadwaybuild2
MARK_MODEL_AS_NO_LONGER_NEEDED broadwaybuild
MARK_MODEL_AS_NO_LONGER_NEEDED area5build2
MARK_MODEL_AS_NO_LONGER_NEEDED papermachn01
MARK_MODEL_AS_NO_LONGER_NEEDED com_21way5
MARK_MODEL_AS_NO_LONGER_NEEDED tw@t_cafe
MARK_MODEL_AS_NO_LONGER_NEEDED treepatchttwrs
MARK_MODEL_AS_NO_LONGER_NEEDED flatiron1
//MARK_MODEL_AS_NO_LONGER_NEEDED veg_tree3  // SCFIX: still used
//MARK_MODEL_AS_NO_LONGER_NEEDED veg_treenew17 // SCFIX: still used
MARK_MODEL_AS_NO_LONGER_NEEDED block4_ground01
MARK_MODEL_AS_NO_LONGER_NEEDED comswcentralbld7
//MARK_MODEL_AS_NO_LONGER_NEEDED papermachn01 // SCFIX: remove duplicate

WHILE cs_time < 17514 
	WAIT 0
	GOSUB skip_intro_button
	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF
	DRAW_LIGHT 780.55 -942.901 39.022 235 255 250
	DRAW_LIGHT 196.077 -1126.984 25.626	235 255 250
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW JAILB_B 10000 1//"of a devastating attack on a police convoy this morning."

WHILE cs_time < 18933
	WAIT 0
	GOSUB skip_intro_button
	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF
	GET_CUTSCENE_TIME cs_time
ENDWHILE

//REQUEST_MODEL com_roadkb23 // SCFIX: already loaded
REQUEST_MODEL com_roadkb22
REQUEST_MODEL kb_underpass
REQUEST_MODEL museum
REQUEST_MODEL nbcom_roadkb01
REQUEST_MODEL bvbridgspprt01
REQUEST_MODEL flatiron1b
//REQUEST_MODEL veg_tree3 // SCFIX: remove duplicate
REQUEST_MODEL nbbridgcabls01
REQUEST_MODEL nbbridgerdb
REQUEST_MODEL nbbridgerda
//REQUEST_MODEL nbbridgcabls01 // SCFIX: remove duplicate
//REQUEST_MODEL bvbridgspprt01 // SCFIX: remove duplicate
REQUEST_MODEL overpass_comse
REQUEST_MODEL com_landnew221b
//REQUEST_MODEL nbcom_roadkb01 // SCFIX: remove duplicate
REQUEST_MODEL com_landnew221
//REQUEST_MODEL flatiron1b // SCFIX: remove duplicate
REQUEST_MODEL LODtiron1b
//REQUEST_MODEL veg_tree3 // SCFIX: remove duplicate
//REQUEST_MODEL ofis_bildkb_4  // SCFIX: already loaded
REQUEST_MODEL kb_ofis1
REQUEST_MODEL comtreepatchprk
REQUEST_MODEL Hotel2
REQUEST_MODEL underground_over7
REQUEST_MODEL rd_Road1A50
//REQUEST_MODEL kb_underpass // SCFIX: remove duplicate
REQUEST_MODEL kbplanter4
REQUEST_MODEL block4_scraperl0
REQUEST_MODEL com_roadkb12
REQUEST_MODEL planterbtm_1
REQUEST_MODEL LODridgspprt01
REQUEST_MODEL LODom_roadkb01
REQUEST_MODEL LODridgerda
REQUEST_MODEL LODridgerdb
REQUEST_MODEL LODridgcabls01
MARK_MODEL_AS_NO_LONGER_NEEDED com_21way20
MARK_MODEL_AS_NO_LONGER_NEEDED cm1waycrosscom
MARK_MODEL_AS_NO_LONGER_NEEDED com_21way10
//MARK_MODEL_AS_NO_LONGER_NEEDED comswcentralbld7 // SCFIX: already unloaded
MARK_MODEL_AS_NO_LONGER_NEEDED comswcentralbld6

SET_NEAR_CLIP 2.5

WHILE cs_time < 20667
	WAIT 0
	GOSUB skip_intro_button
	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW JAILB_C 10000 1//"No details have been released about the prisoners being transferred in the convoy,"

WHILE cs_time < 22181
	WAIT 0
	GOSUB skip_intro_button
	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF
	GET_CUTSCENE_TIME cs_time
ENDWHILE

SET_NEAR_CLIP 4.5

WHILE cs_time < 24522
	WAIT 0
	GOSUB skip_intro_button
	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW JAILB_D 10000 1//"And no group, terrorists or otherwise have claimed responsibility."

WHILE cs_time < 27208 
	WAIT 0
	GOSUB skip_intro_button
	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW JAILB_E 10000 1//"The convoy left Police head quarters early this morning..."

WHILE cs_time < 29793 
	WAIT 0
	GOSUB skip_intro_button
	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW JAILB_F 10000 1//"for a routine transfer to Liberty penitentiary."

WHILE cs_time < 30599 //VERY HIGH SHOT TOWARDS BRIDGE
	WAIT 0
	GOSUB skip_intro_button
	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF
	GET_CUTSCENE_TIME cs_time
ENDWHILE

SET_NEAR_CLIP 5.5
REQUEST_MODEL ind_customroad003

MARK_MODEL_AS_NO_LONGER_NEEDED planter_short
MARK_MODEL_AS_NO_LONGER_NEEDED com_rvroads52
MARK_MODEL_AS_NO_LONGER_NEEDED road_broadway04
MARK_MODEL_AS_NO_LONGER_NEEDED com_roadsrv
MARK_MODEL_AS_NO_LONGER_NEEDED rd_Road1A20
MARK_MODEL_AS_NO_LONGER_NEEDED rd_CrossRoads11
MARK_MODEL_AS_NO_LONGER_NEEDED com_21way50
MARK_MODEL_AS_NO_LONGER_NEEDED rd_Road1A10
MARK_MODEL_AS_NO_LONGER_NEEDED com_cust_roads57

WHILE cs_time < 32986
	WAIT 0
	GOSUB skip_intro_button
	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW JAILB_G 10000 1//"The attack took place on Callahan bridge,"

WHILE cs_time < 34817
	WAIT 0
	GOSUB skip_intro_button
	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW JAILB_H 10000 1//"leaving few witness', several dead officers and bridge itself severely damaged."

WHILE cs_time < 38590
	WAIT 0
	GOSUB skip_intro_button
	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW JAILB_I 10000 1//"Some of the convicts are thought to have perished in the explosion..."

WHILE cs_time < 40842
	WAIT 0
	GOSUB skip_intro_button
	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW JAILB_J 10000 1//"that followed the initial attack, although police divers are yet to find any remains."

WHILE cs_time < 42066
	WAIT 0
	GOSUB skip_intro_button
	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF
	GET_CUTSCENE_TIME cs_time
ENDWHILE

SET_NEAR_CLIP 4.5

REQUEST_MODEL kmricndo01
REQUEST_MODEL kmricndo02
//REQUEST_MODEL veg_treenew17 // SCFIX: already loaded
REQUEST_MODEL com_docksaa
REQUEST_MODEL com_pier3
REQUEST_MODEL gRD_overpass19kb
REQUEST_MODEL gRD_overpass19bkb

WHILE cs_time < 42535 
	WAIT 0
	GOSUB skip_intro_button
	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW JAILB_W 10000 1//"Revelations as to the professionalism of the attack struck police hours afterward,"

WHILE cs_time < 46683
	WAIT 0
	GOSUB skip_intro_button
	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW JAILB_K 10000 1//"When identification of the missing felons was further hampered..."

WHILE cs_time < 49483
	WAIT 0
	GOSUB skip_intro_button
	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW JAILB_L 10000 1//"by an attack by computer hackers on police head quarter databases."

WHILE cs_time < 53406
	WAIT 0
	GOSUB skip_intro_button
	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW JAILB_O 10000 1//"With the Porter tunnel project falling behind schedule,"

WHILE cs_time < 53666
	WAIT 0
	GOSUB skip_intro_button
	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF
	GET_CUTSCENE_TIME cs_time
ENDWHILE

SET_NEAR_CLIP 0.9

WHILE cs_time < 56077
	WAIT 0
	GOSUB skip_intro_button
	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW JAILB_P 5000 1//"this disaster leaves Portland isolated from the rest of the city."

WHILE cs_time < 64200
	WAIT 0
	GOSUB skip_intro_button
	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF
	DRAW_LIGHT 780.55 -942.901 39.022 235 255 250
	GET_CUTSCENE_TIME cs_time
ENDWHILE

REMOVE_CAR_FROM_CHASE 2

WHILE cs_time < 64333
	WAIT 0
	GOSUB skip_intro_button
	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF
	DRAW_LIGHT 780.55 -942.901 39.022 235 255 250
	GET_CUTSCENE_TIME cs_time
ENDWHILE

REMOVE_CAR_FROM_CHASE 1

WHILE cs_time < 64566
	WAIT 0
	GOSUB skip_intro_button
	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF
	DRAW_LIGHT 780.55 -942.901 39.022 235 255 250
	GET_CUTSCENE_TIME cs_time
ENDWHILE

REQUEST_MODEL com_docksb
REQUEST_MODEL newdockbuilding2
REQUEST_MODEL newdockbuilding
//REQUEST_MODEL block4_scraperl0 // SCFIX: already loaded

MARK_MODEL_AS_NO_LONGER_NEEDED com_roadkb22
MARK_MODEL_AS_NO_LONGER_NEEDED com_roadkb23
MARK_MODEL_AS_NO_LONGER_NEEDED nbcom_roadkb01
MARK_MODEL_AS_NO_LONGER_NEEDED com_landnew221
MARK_MODEL_AS_NO_LONGER_NEEDED doublestreetlght1
MARK_MODEL_AS_NO_LONGER_NEEDED museum
MARK_MODEL_AS_NO_LONGER_NEEDED ofis_bildkb_4
MARK_MODEL_AS_NO_LONGER_NEEDED kb_ofis1
MARK_MODEL_AS_NO_LONGER_NEEDED comtreepatchprk
MARK_MODEL_AS_NO_LONGER_NEEDED Hotel2
MARK_MODEL_AS_NO_LONGER_NEEDED underground_over7
MARK_MODEL_AS_NO_LONGER_NEEDED trafficlight1
MARK_MODEL_AS_NO_LONGER_NEEDED rd_Road1A50
MARK_MODEL_AS_NO_LONGER_NEEDED veg_bush14
MARK_MODEL_AS_NO_LONGER_NEEDED kb_underpass
//MARK_MODEL_AS_NO_LONGER_NEEDED ofis_bildkb_4 // SCFIX: remove duplicate
MARK_MODEL_AS_NO_LONGER_NEEDED kbplanter4
MARK_MODEL_AS_NO_LONGER_NEEDED planterbtm_1
//MARK_MODEL_AS_NO_LONGER_NEEDED com_rvroads52 // SCFIX: already unloaded

WHILE cs_time < 66171
	WAIT 0
	GOSUB skip_intro_button
	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF
	DRAW_LIGHT 780.55 -942.901 39.022 235 255 250
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW JAILB_Q 1200 1//"Come on."

WHILE cs_time < 69378
	WAIT 0
	GOSUB skip_intro_button
	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF
	DRAW_LIGHT 780.55 -942.901 39.022 235 255 250
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW JAILB_R 1600 1//"Senor dickhead."

WHILE cs_time < 71994
	WAIT 0
	GOSUB skip_intro_button
	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF
	DRAW_LIGHT 780.55 -942.901 39.022 235 255 250
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW JAILB_S 2000 1//"It's no problem to kill you."

WHILE cs_time < 75623
	WAIT 0
	GOSUB skip_intro_button
	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF
	DRAW_LIGHT 780.55 -942.901 39.022 235 255 250
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW JAILB_T 1800 1//"You gonna be sorry."

WHILE cs_time < 79633
	WAIT 0
	GOSUB skip_intro_button
	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF
	DRAW_LIGHT 780.55 -942.901 39.022 235 255 250
	GET_CUTSCENE_TIME cs_time
ENDWHILE

MARK_MODEL_AS_NO_LONGER_NEEDED kmricndo01
MARK_MODEL_AS_NO_LONGER_NEEDED kmricndo02
MARK_MODEL_AS_NO_LONGER_NEEDED veg_tree3
MARK_MODEL_AS_NO_LONGER_NEEDED veg_treenew17
MARK_MODEL_AS_NO_LONGER_NEEDED com_docksaa
MARK_MODEL_AS_NO_LONGER_NEEDED com_pier3
MARK_MODEL_AS_NO_LONGER_NEEDED gRD_overpass19kb
MARK_MODEL_AS_NO_LONGER_NEEDED gRD_overpass19bkb

WHILE cs_time < 86089
	WAIT 0
	GOSUB skip_intro_button
	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF
	DRAW_LIGHT 780.55 -942.901 39.022 235 255 250
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW JAILB_U 1800 1//"A'right, a'right. Get lost."

WHILE cs_time < 87592
	WAIT 0
	GOSUB skip_intro_button
	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF
	DRAW_LIGHT 780.55 -942.901 39.022 235 255 250
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_PRINTS
CLEAR_SMALL_PRINTS

WHILE cs_time < 98766
	WAIT 0
	GOSUB skip_intro_button
	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF
	DRAW_LIGHT 780.55 -942.901 39.022 205 255 230
	GET_CUTSCENE_TIME cs_time
ENDWHILE

WHILE cs_time < 101866//102256
	WAIT 0
	GOSUB skip_intro_button
	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF
	DRAW_LIGHT 780.55 -942.901 39.022 205 255 230
	GET_CUTSCENE_TIME cs_time
ENDWHILE
 								
SET_MUSIC_DOES_FADE FALSE
SET_MOTION_BLUR 7 //THE EXPLOSION

IF NOT HAS_CUTSCENE_FINISHED 
	SET_FADING_COLOUR 255 255 255
	DO_FADE 100 FADE_OUT
	CLEAR_PRINTS
	WHILE GET_FADING_STATUS
		WAIT 0
	ENDWHILE

ENDIF

skip_intro_here:

GOSUB intro_load_splash // SCFIX: moved to a subroutine

IF skip_flag = 2
	WAIT 0
	USE_TEXT_COMMANDS FALSE
	SET_MUSIC_DOES_FADE TRUE
	SET_FADING_COLOUR 0 0 0 
	DO_FADE 0 FADE_OUT
ENDIF

//FADE OUT AFTER EXPLOSION....
//SWAP BRIDGE FROM FIXED TO DAMAGED
GOSUB intro_unload_models1 // SCFIX: moved stuff into a subroutine

// SCFIX: START
REQUEST_MODEL nbbridgfk2
REQUEST_MODEL damgbridgerdb
REQUEST_MODEL damgbbridgerda
REQUEST_MODEL lodridgfk2
REQUEST_MODEL lodgbridgerdb
REQUEST_MODEL lodgbbridgerda

LOAD_ALL_MODELS_NOW

WHILE NOT HAS_MODEL_LOADED nbbridgfk2
OR NOT HAS_MODEL_LOADED damgbridgerdb
OR NOT HAS_MODEL_LOADED damgbbridgerda
OR NOT HAS_MODEL_LOADED lodridgfk2
OR NOT HAS_MODEL_LOADED lodgbridgerdb
OR NOT HAS_MODEL_LOADED lodgbbridgerda
	WAIT 0
ENDWHILE
// SCFIX: END

GOSUB intro_swap_bridge // SCFIX: moved to subroutine

GOSUB intro_unload_models2 // SCFIX

SET_PLAYER_COORDINATES player 811.90 -939.95 35.8
SET_PLAYER_HEADING player 180.0

GOSUB intro_set2 // SCFIX: moved to subroutine

USE_TEXT_COMMANDS FALSE

//ADD_PARTICLE_EFFECT 4 791.661 -936.916 38.313 TRUE //SMOKE ON CARS
//ADD_PARTICLE_EFFECT 4 788.337 -938.467 38.073 TRUE
//ADD_PARTICLE_EFFECT	4 786.493 -942.398 39.8 TRUE
//
//ADD_PARTICLE_EFFECT 10 783.572 -938.549 38.448 TRUE //FIRE ON CARS
//ADD_PARTICLE_EFFECT 10 790.537 -935.67  38.005 TRUE
//ADD_PARTICLE_EFFECT 10 789.295 -938.882 38.127 TRUE

TIMERA = 6001
GOSUB do_bridge_particles

ADD_CONTINUOUS_SOUND 790.537 -935.67  38.005 SOUND_PRETEND_FIRE_LOOP fire_sound_8ball

USE_TEXT_COMMANDS FALSE

IF NOT skip_flag = 2

	SET_PLAYER_VISIBLE player TRUE
	REQUEST_MODEL CAR_KURUMA
	LOAD_ALL_MODELS_NOW
	WHILE NOT HAS_MODEL_LOADED CAR_KURUMA
		WAIT 0
		GOSUB do_bridge_particles
	ENDWHILE
	CREATE_CAR CAR_KURUMA 812.0131 -945.5528 35.7889 car_eightball
	CHANGE_CAR_COLOUR car_eightball 58 1
	SET_CAR_HEADING car_eightball 262.3871

	CREATE_CHAR PEDTYPE_SPECIAL PED_SPECIAL1 811.90 -942.47 -100.0 eightball
	SET_ANIM_GROUP_FOR_CHAR eightball ANIM_GANG2_PED
	CLEAR_CHAR_THREAT_SEARCH eightball
	TURN_CHAR_TO_FACE_COORD eightball 811.90 -939.95 35.8
	CHAR_LOOK_AT_PLAYER_ALWAYS eightball player

	STOP_CHASE_SCENE
//	REMOVE_CAR_FROM_CHASE 0
//	REMOVE_CAR_FROM_CHASE 3
//	REMOVE_CAR_FROM_CHASE 4
//	REMOVE_CAR_FROM_CHASE 5
//	REMOVE_CAR_FROM_CHASE 6
//	REMOVE_CAR_FROM_CHASE 7
//	REMOVE_CAR_FROM_CHASE 8
//	REMOVE_CAR_FROM_CHASE 9
//	REMOVE_CAR_FROM_CHASE 10
//	REMOVE_CAR_FROM_CHASE 11
//	REMOVE_CAR_FROM_CHASE 12
//	REMOVE_CAR_FROM_CHASE 13
//	REMOVE_CAR_FROM_CHASE 14
//	REMOVE_CAR_FROM_CHASE 15
//	REMOVE_CAR_FROM_CHASE 16
//	REMOVE_CAR_FROM_CHASE 17
//	REMOVE_CAR_FROM_CHASE 18
//	REMOVE_CAR_FROM_CHASE 19
	GOSUB intro_unload_models3 // SCFIX

	WHILE cs_time < 107172//111172 //103333//3100
		WAIT 0
		GOSUB do_bridge_particles
		GOSUB skip_intro_button
		IF skip_flag = 2
			GOTO skip_intro_here
		ENDIF
		DRAW_LIGHT 780.55 -942.901 39.022 205 255 230
		GET_CUTSCENE_TIME cs_time
	ENDWHILE
 								
	IF NOT HAS_CUTSCENE_FINISHED 
		SET_FADING_COLOUR 255 255 255
		DO_FADE 6000 FADE_IN
		CLEAR_PRINTS
		WHILE GET_FADING_STATUS
			WAIT 0
		GOSUB do_bridge_particles
			// SCFIX: START
			GOSUB skip_intro_button
			IF skip_flag = 2
				GOTO skip_intro_here
			ENDIF
			// SCFIX: END
		ENDWHILE
	ENDIF
	
	WHILE cs_time < 121666//3650
		WAIT 0
		GOSUB do_bridge_particles
		GOSUB skip_intro_button
		IF skip_flag = 2
			GOTO skip_intro_here
		ENDIF
		DRAW_LIGHT 780.55 -942.901 39.022 205 255 230
		GET_CUTSCENE_TIME cs_time
	ENDWHILE
 								
	IF NOT HAS_CUTSCENE_FINISHED 
		SET_MUSIC_DOES_FADE TRUE
		SET_FADING_COLOUR 0 0 0
		DO_FADE 500 FADE_OUT
		CLEAR_PRINTS
		WHILE GET_FADING_STATUS
			WAIT 0
			GOSUB do_bridge_particles
			// SCFIX: START
			GOSUB skip_intro_button
			IF skip_flag = 2
				GOTO skip_intro_here
			ENDIF
			// SCFIX: END
		ENDWHILE
	ENDIF
ENDIF

GOSUB intro_unload_models3 // SCFIX

WHILE NOT HAS_CUTSCENE_FINISHED
	WAIT 0
GOSUB do_bridge_particles
ENDWHILE

SET_MUSIC_DOES_FADE TRUE


GOSUB intro_set1 // SCFIX: moved to a subroutine
CLEAR_CUTSCENE

SET_FADING_COLOUR 0 0 0 
DO_FADE 0 FADE_OUT

SWITCH_RUBBISH ON
GOSUB intro_set2 // SCFIX: moved to a subroutine
SET_EVERYONE_IGNORE_PLAYER player FALSE
SET_PLAYER_CONTROL player ON
SET_PLAYER_VISIBLE player TRUE

GOSUB intro_set3 // SCFIX: moved to a subroutine
SET_PLAYER_COORDINATES player 811.90 -939.95 35.8
SET_PLAYER_HEADING player 180.0

GET_PLAYER_CHAR	player script_controlled_player
IF NOT IS_CHAR_DEAD script_controlled_player
	
	UNDRESS_CHAR script_controlled_player playerp
	WHILE NOT HAS_MODEL_LOADED PED_PLAYER 
		WAIT 0
GOSUB do_bridge_particles
		
	ENDWHILE
	
	IF NOT IS_CHAR_DEAD script_controlled_player
		DRESS_CHAR script_controlled_player
	ENDIF
ENDIF

SET_CAMERA_BEHIND_PLAYER
RETURN // SCFIX

mission_cleanup_intro: // SCFIX
IF flag_eight_loaded = 0 // SCFIX
UNLOAD_SPECIAL_CHARACTER 1 // SCFIX: uncomment
ENDIF // SCFIX
UNLOAD_SPECIAL_CHARACTER 2
UNLOAD_SPECIAL_CHARACTER 3
UNLOAD_SPECIAL_CHARACTER 4
MARK_MODEL_AS_NO_LONGER_NEEDED cut_obj1
MARK_MODEL_AS_NO_LONGER_NEEDED cut_obj2
MARK_MODEL_AS_NO_LONGER_NEEDED cut_obj3
MARK_MODEL_AS_NO_LONGER_NEEDED cut_obj4
MARK_MODEL_AS_NO_LONGER_NEEDED cut_obj5

// SCFIX: START
GOSUB intro_load_splash
GOSUB intro_set1
GOSUB intro_unload_models1
GOSUB intro_swap_bridge
GOSUB intro_unload_models2
GOSUB intro_unload_models3
SWITCH_RUBBISH ON
GOSUB intro_set2
GOSUB intro_set3
// SCFIX: END

// *******************************END OF JAIL BREAK CUTSCENE***************************

SET_INTRO_IS_PLAYING FALSE

SET_MUSIC_DOES_FADE TRUE

FORCE_RAIN FALSE

START_NEW_SCRIPT eightball_mission_loop

flag_player_on_mission = 0
MISSION_HAS_FINISHED
//MISSION_END // SCFIX: moved up
RETURN // SCFIX




skip_intro_button://////////////////////////////////////////////////////////
IF skip_flag = 0
	IF NOT IS_BUTTON_PRESSED PAD1 CROSS
	AND NOT IS_BUTTON_PRESSED PAD1 START
		skip_flag = 1
	ENDIF
ENDIF

IF skip_flag = 1
	IF IS_BUTTON_PRESSED PAD1 CROSS
	OR IS_BUTTON_PRESSED PAD1 START
		skip_flag = 2
	ENDIF
ENDIF
RETURN//////////////////////////////////////////////////////////////////////



draw_intro_text://///////////////////////////////////////////////////////

SET_TEXT_CENTRE_SIZE 580.0
SET_TEXT_FONT FONT_BANK//FONT_PAGER//FONT_HEADING
SET_TEXT_CENTRE ON
SET_TEXT_COLOUR 190 190 190 text_alpha
SET_TEXT_SCALE 0.8 1.0//0.5 0.75
SET_TEXT_PROPORTIONAL ON
SET_TEXT_BACKGROUND_COLOUR 0 0 0 text_alpha
SET_TEXT_BACKGROUND ON

DISPLAY_TEXT 320.0 400.0 PAPER1

IF text_fading_flag	= 0
	text_alpha += 2
	IF text_alpha > 255
		text_alpha = 255
	ENDIF
ELSE
	text_alpha -= 3
	IF text_alpha < 1
		text_alpha = 0
	ENDIF
ENDIF

RETURN//////////////////////////////////////////////////////////////////////



do_bridge_particles:////////////////////////////////////////////////////////
IF TIMERA > 6000
	TIMERA = 0
	ADD_MOVING_PARTICLE_EFFECT 10 791.661 -936.916 38.313 0.0 0.0 0.0 1.0 0 0 0 6000
	ADD_MOVING_PARTICLE_EFFECT 10 788.337 -938.467 38.073 0.0 0.0 0.0 1.0 0 0 0 6000
	ADD_MOVING_PARTICLE_EFFECT 10 786.493 -942.398 39.8 0.0 0.0 0.0 1.0 0 0 0 6000
ENDIF
RETURN//////////////////////////////////////////////////////////////////////

// SCFIX: START
intro_swap_bridge:
IF flag_intro_swap_bridge = 0
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

	CREATE_OBJECT_NO_OFFSET bridgefuka 715.746 -937.908 40.194 damagea
	CREATE_OBJECT_NO_OFFSET bridgefukb 787.835 -939.24 38.971 damageb
	DONT_REMOVE_OBJECT damagea // SCFIX
	DONT_REMOVE_OBJECT damageb // SCFIX
	flag_bridge_created_8ball = 1 // SCFIX
	flag_intro_swap_bridge = 1
ENDIF
RETURN

intro_unload_models1:
IF flag_intro_unload_models1 = 0
	MARK_MODEL_AS_NO_LONGER_NEEDED trafficlight1
	MARK_MODEL_AS_NO_LONGER_NEEDED rd_SrRoad2A50
	MARK_MODEL_AS_NO_LONGER_NEEDED rd_SrRoad2A20
	MARK_MODEL_AS_NO_LONGER_NEEDED rd_SrRoad2A10
	MARK_MODEL_AS_NO_LONGER_NEEDED rd_CrossRda1rw22
	MARK_MODEL_AS_NO_LONGER_NEEDED rd_CrossRoadsa24
	MARK_MODEL_AS_NO_LONGER_NEEDED com_cust_roads25
	MARK_MODEL_AS_NO_LONGER_NEEDED veg_tree3
	MARK_MODEL_AS_NO_LONGER_NEEDED doublestreetlght1
	MARK_MODEL_AS_NO_LONGER_NEEDED veg_treea3
	MARK_MODEL_AS_NO_LONGER_NEEDED veg_treenew17
	MARK_MODEL_AS_NO_LONGER_NEEDED Streetlamp1
	MARK_MODEL_AS_NO_LONGER_NEEDED bollardlight
	MARK_MODEL_AS_NO_LONGER_NEEDED kb_scrap_5
	MARK_MODEL_AS_NO_LONGER_NEEDED policetenkb1
	MARK_MODEL_AS_NO_LONGER_NEEDED scraperkb3_nit
	MARK_MODEL_AS_NO_LONGER_NEEDED chunk5land
	MARK_MODEL_AS_NO_LONGER_NEEDED policeally
	MARK_MODEL_AS_NO_LONGER_NEEDED police_com
	MARK_MODEL_AS_NO_LONGER_NEEDED rd_CrossRda1w22
	MARK_MODEL_AS_NO_LONGER_NEEDED treepatchkb7
	MARK_MODEL_AS_NO_LONGER_NEEDED roadplanterkb3
	MARK_MODEL_AS_NO_LONGER_NEEDED roadplanterkb1
	MARK_MODEL_AS_NO_LONGER_NEEDED rd_Road3A50
	//MARK_MODEL_AS_NO_LONGER_NEEDED rd_CrossRda1w22 // SCFIX: remove duplicate
	MARK_MODEL_AS_NO_LONGER_NEEDED rd_Road2A20
	MARK_MODEL_AS_NO_LONGER_NEEDED broadwaybuild2
	MARK_MODEL_AS_NO_LONGER_NEEDED broadwaybuild
	MARK_MODEL_AS_NO_LONGER_NEEDED area5build2
	MARK_MODEL_AS_NO_LONGER_NEEDED comswcentralbld7
	MARK_MODEL_AS_NO_LONGER_NEEDED papermachn01
	MARK_MODEL_AS_NO_LONGER_NEEDED comswcentralbld6
	MARK_MODEL_AS_NO_LONGER_NEEDED com_21way5
	MARK_MODEL_AS_NO_LONGER_NEEDED com_21way50
	MARK_MODEL_AS_NO_LONGER_NEEDED com_21way10
	MARK_MODEL_AS_NO_LONGER_NEEDED cm1waycrosscom
	MARK_MODEL_AS_NO_LONGER_NEEDED com_21way20
	MARK_MODEL_AS_NO_LONGER_NEEDED tw@t_cafe
	MARK_MODEL_AS_NO_LONGER_NEEDED veg_bush14
	MARK_MODEL_AS_NO_LONGER_NEEDED treepatchttwrs
	MARK_MODEL_AS_NO_LONGER_NEEDED flatiron1
	//MARK_MODEL_AS_NO_LONGER_NEEDED veg_tree3 // SCFIX: remove duplicate
	//MARK_MODEL_AS_NO_LONGER_NEEDED veg_treenew17 // SCFIX: remove duplicate
	MARK_MODEL_AS_NO_LONGER_NEEDED block4_ground01
	MARK_MODEL_AS_NO_LONGER_NEEDED planter_short
	MARK_MODEL_AS_NO_LONGER_NEEDED com_rvroads52
	MARK_MODEL_AS_NO_LONGER_NEEDED road_broadway04
	MARK_MODEL_AS_NO_LONGER_NEEDED com_roadsrv
	MARK_MODEL_AS_NO_LONGER_NEEDED rd_Road1A20
	MARK_MODEL_AS_NO_LONGER_NEEDED rd_CrossRoads11
	MARK_MODEL_AS_NO_LONGER_NEEDED doublestreetlght1
	MARK_MODEL_AS_NO_LONGER_NEEDED ofis_bildkb_4
	MARK_MODEL_AS_NO_LONGER_NEEDED rd_Road1A10
	MARK_MODEL_AS_NO_LONGER_NEEDED com_roadkb23
	MARK_MODEL_AS_NO_LONGER_NEEDED com_cust_roads57
	//MARK_MODEL_AS_NO_LONGER_NEEDED com_rvroads52 // SCFIX: remove duplicate
	//MARK_MODEL_AS_NO_LONGER_NEEDED com_roadkb23 // SCFIX: remove duplicate
	MARK_MODEL_AS_NO_LONGER_NEEDED com_roadkb22
	MARK_MODEL_AS_NO_LONGER_NEEDED kb_underpass
	MARK_MODEL_AS_NO_LONGER_NEEDED museum
	MARK_MODEL_AS_NO_LONGER_NEEDED nbcom_roadkb01
	MARK_MODEL_AS_NO_LONGER_NEEDED bvbridgspprt01
	MARK_MODEL_AS_NO_LONGER_NEEDED flatiron1b
	MARK_MODEL_AS_NO_LONGER_NEEDED LODtiron1b
	//MARK_MODEL_AS_NO_LONGER_NEEDED veg_tree3 // SCFIX: remove duplicate
	MARK_MODEL_AS_NO_LONGER_NEEDED nbbridgcabls01
	MARK_MODEL_AS_NO_LONGER_NEEDED nbbridgerdb
	MARK_MODEL_AS_NO_LONGER_NEEDED nbbridgerda
	//MARK_MODEL_AS_NO_LONGER_NEEDED nbbridgcabls01 // SCFIX: remove duplicate
	//MARK_MODEL_AS_NO_LONGER_NEEDED bvbridgspprt01 // SCFIX: remove duplicate
	MARK_MODEL_AS_NO_LONGER_NEEDED overpass_comse
	MARK_MODEL_AS_NO_LONGER_NEEDED com_landnew221b
	//MARK_MODEL_AS_NO_LONGER_NEEDED nbcom_roadkb01 // SCFIX: remove duplicate
	MARK_MODEL_AS_NO_LONGER_NEEDED com_landnew221
	//MARK_MODEL_AS_NO_LONGER_NEEDED flatiron1b // SCFIX: remove duplicate
	//MARK_MODEL_AS_NO_LONGER_NEEDED veg_tree3 // SCFIX: remove duplicate
	//MARK_MODEL_AS_NO_LONGER_NEEDED museum // SCFIX: remove duplicate
	//MARK_MODEL_AS_NO_LONGER_NEEDED ofis_bildkb_4 // SCFIX: remove duplicate
	MARK_MODEL_AS_NO_LONGER_NEEDED kb_ofis1
	MARK_MODEL_AS_NO_LONGER_NEEDED comtreepatchprk
	MARK_MODEL_AS_NO_LONGER_NEEDED Hotel2
	MARK_MODEL_AS_NO_LONGER_NEEDED underground_over7
	MARK_MODEL_AS_NO_LONGER_NEEDED rd_Road1A50
	//MARK_MODEL_AS_NO_LONGER_NEEDED kb_underpass // SCFIX: remove duplicate
	MARK_MODEL_AS_NO_LONGER_NEEDED kbplanter4
	MARK_MODEL_AS_NO_LONGER_NEEDED block4_scraperl0
	MARK_MODEL_AS_NO_LONGER_NEEDED com_roadkb12
	MARK_MODEL_AS_NO_LONGER_NEEDED planterbtm_1
	//MARK_MODEL_AS_NO_LONGER_NEEDED flatiron1b // SCFIX: remove duplicate
	MARK_MODEL_AS_NO_LONGER_NEEDED ind_customroad003
	MARK_MODEL_AS_NO_LONGER_NEEDED kmricndo01
	MARK_MODEL_AS_NO_LONGER_NEEDED kmricndo02
	//MARK_MODEL_AS_NO_LONGER_NEEDED veg_treenew17 // SCFIX: remove duplicate
	MARK_MODEL_AS_NO_LONGER_NEEDED com_docksaa
	MARK_MODEL_AS_NO_LONGER_NEEDED com_pier3
	MARK_MODEL_AS_NO_LONGER_NEEDED gRD_overpass19kb
	MARK_MODEL_AS_NO_LONGER_NEEDED gRD_overpass19bkb
	MARK_MODEL_AS_NO_LONGER_NEEDED com_docksb
	MARK_MODEL_AS_NO_LONGER_NEEDED newdockbuilding2
	MARK_MODEL_AS_NO_LONGER_NEEDED newdockbuilding
	//MARK_MODEL_AS_NO_LONGER_NEEDED block4_scraperl0 // SCFIX: remove duplicate
	MARK_MODEL_AS_NO_LONGER_NEEDED LODridgcabls01
	MARK_MODEL_AS_NO_LONGER_NEEDED amco_floor // SCFIX: missing model
	flag_intro_unload_models1 = 1
ENDIF
RETURN

intro_unload_models2:
IF flag_intro_unload_models2 = 0
	MARK_MODEL_AS_NO_LONGER_NEEDED nbbridgfk2
	MARK_MODEL_AS_NO_LONGER_NEEDED damgbridgerdb
	MARK_MODEL_AS_NO_LONGER_NEEDED damgbbridgerda
	MARK_MODEL_AS_NO_LONGER_NEEDED lodridgfk2
	MARK_MODEL_AS_NO_LONGER_NEEDED lodgbridgerdb
	MARK_MODEL_AS_NO_LONGER_NEEDED lodgbbridgerda
	MARK_MODEL_AS_NO_LONGER_NEEDED bridgefuka
	MARK_MODEL_AS_NO_LONGER_NEEDED bridgefukb
	flag_intro_unload_models2 = 1
ENDIF
RETURN

intro_unload_models3:
IF flag_intro_unload_models3 = 0
	MARK_MODEL_AS_NO_LONGER_NEEDED  LODridgspprt01
	MARK_MODEL_AS_NO_LONGER_NEEDED  LODom_roadkb01
	MARK_MODEL_AS_NO_LONGER_NEEDED  LODridgerda
	MARK_MODEL_AS_NO_LONGER_NEEDED  LODridgerdb
	flag_intro_unload_models3 = 1
ENDIF
RETURN

intro_load_splash:
IF flag_intro_load_splash = 0
	LOAD_SPLASH_SCREEN splash1
	flag_intro_load_splash = 1
ENDIF
RETURN

intro_set1:
IF flag_intro_set1 = 0
	SET_MOTION_BLUR 0
	SET_NEAR_CLIP 0.9
	STOP_CHASE_SCENE
	CLEAR_PRINTS
	CLEAR_SMALL_PRINTS
	flag_intro_set1 = 1
ENDIF
RETURN

intro_set2:
IF flag_intro_set2 = 0
	SWITCH_WORLD_PROCESSING ON
	SWITCH_STREAMING ON
	flag_intro_set2 = 1
ENDIF
RETURN

intro_set3:
IF flag_intro_set3 = 0
	LOAD_COLLISION LEVEL_INDUSTRIAL
	flag_intro_set3 = 1
ENDIF
RETURN

// SCFIX: END
}