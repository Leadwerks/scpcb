Global ark_blur_image%, ark_blur_texture%, ark_sw%, ark_sh%
Global ark_blur_cam%

Function CreateBlurImage()
	;Create blur Camera
	Local cam% = CreateCamera()
	CameraProjMode cam,2
	CameraZoom cam,0.1
	CameraClsMode cam, 0, 0
	CameraRange cam, 0.1, 1.5
	MoveEntity cam, 0, 0, 10000
	ark_blur_cam = cam
	
	ark_sw = GraphicsWidth()
	ark_sh = GraphicsHeight()
	CameraViewport cam,0,0,ark_sw,ark_sh
	
	;Create sprite
	Local spr% = CreateMesh(cam)
	Local sf% = CreateSurface(spr)
	AddVertex sf, -1, 1, 0, 0, 0
	AddVertex sf, 1, 1, 0, 1, 0
	AddVertex sf, -1, -1, 0, 0, 1
	AddVertex sf, 1, -1, 0, 1, 1
	AddTriangle sf, 0, 1, 2
	AddTriangle sf, 3, 2, 1
	EntityFX spr, 17
	
	Local tw% = Pow2(GraphicsWidth())
	Local th% = Pow2(GraphicsHeight())
	Local aspect# = Float(th) / Float(tw)
	
	ScaleEntity spr, Float(tw) / Float(GraphicsWidth()), (Float(tw) / Float(GraphicsWidth())) * aspect, 1
	
	PositionEntity spr, 0, 0, 1.0001
	EntityOrder spr, -100000
	EntityBlend spr, 1
	ark_blur_image = spr
	
	;Create blur texture
	ark_blur_texture = CreateTexture(tw, th, 256 + 16 + 32); Added UV clamping to prevent bleeding on edges - Josh
	
	;I suspect the texture is being created as a power-of-two image, but these commands result in a MAV. The texture handle is not zero. - Josh
	;Stop
	;Local tex = ark_blur_texture
	;Local tw = TextureWidth(tex)
	;Local th = TextureHeight(tex)
	
	EntityTexture spr, ark_blur_texture
End Function

Function UpdateBlur(power#)
	
	EntityAlpha ark_blur_image, power#
	
	Local tw% = Pow2(GraphicsWidth())
	Local th% = Pow2(GraphicsHeight())
	
	Local x% = (tw - GraphicsWidth()) / 2
	Local y% = (th - GraphicsHeight()) / 2
	
	CopyRect 0, 0, GraphicsWidth(), GraphicsHeight(), x, y, BackBuffer(), TextureBuffer(ark_blur_texture)
	
End Function
;~IDEal Editor Parameters:
;~C#Blitz3D