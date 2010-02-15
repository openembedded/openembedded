require xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- Intel i8xx, i9xx display driver"
DEPENDS += " virtual/libx11 libxvmc drm xf86driproto "
RDEPENDS += "xserver-xorg-extension-dri \
             xserver-xorg-extension-dri2 \
	     xserver-xorg-extension-glx"
PE = "1"
