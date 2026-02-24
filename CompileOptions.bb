;-----------------------------------------------------------------------
; Compile options - Josh

; Blitz3D userlibs do not load DLLs until the first time they are needed. Setting any of these values to 0 allows you to ship
; the game without the specified DLLs, without extensive changes to the source code.

; Steamworks integration
Global ENABLE_STEAM% = 1
If FileType("SteamLib.dll") = 0 ENABLE_STEAM = 0
	
; Detect window close, to fix crash when intro movies are playing
Global ENABLE_CLOSEHANDLER% = 1; Prevents program from crashing if window is closed while intro movies are playing
Global CLOSEHANDLERKEY% = 255; Indicates scan code that should be used
If FileType("blitzclose.dll") = 0 ENABLE_CLOSEHANDLER = 0
	
; Various features
Global ENABLE_SCPLIB = True
If Not FileType("SCPLib.dll") ENABLE_SCPLIB = False