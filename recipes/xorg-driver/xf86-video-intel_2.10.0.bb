require xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- Intel i8xx, i9xx display driver"
DEPENDS += " virtual/libx11 libxvmc drm xf86driproto "
RDEPENDS += "xserver-xorg-extension-dri \
             xserver-xorg-extension-dri2 \
	     xserver-xorg-extension-glx"
PE = "1"
SRC_URI[archive.md5sum] = "78309d4f04dd8ae6585d120377042741"
SRC_URI[archive.sha256sum] = "e46dd691dc93db7cd6f5f22b84fea7e9f4bfd34f28026cfd680993b3ccfc48ab"
