Function Shutdown()
	;DeInitExt
	;alDestroy()
	;FMOD_Pause(MusicCHN)
	;FMOD_CloseStream(CurrMusicStream)
	;FMOD_Close()
	;FMOD_StopStream(CurrMusicStream)
	FSOUND_Stream_Stop(CurrMusicStream)
	;FSOUND_Close()
	If ENABLE_STEAM 
		DebugLog("Shutting down Steamworks")
		Steamworks_Shutdown()
	EndIf
	End
End Function