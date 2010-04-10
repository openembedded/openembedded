DEPENDS = "uicmoc3-native freetype virtual/libx11 libxmu xft libxext libxrender libxrandr libxcursor mysql virtual/libgl"
PROVIDES = "qt3x11"
PR = "r3"

SRC_URI = "ftp://ftp.trolltech.com/qt/source/qt-x11-free-${PV}.tar.bz2 \
	   file://configure.patch;patch=1 \
	   file://no-examples.patch;patch=1 \
           file://gcc4_1-HACK.patch;patch=1"

require qt-x11-free-common.inc

SRC_URI[md5sum] = "655e21cf6a7e66daf8ec6ceda81aae1e"
SRC_URI[sha256sum] = "48c05b501029f0640db665fbc7f981a0efbf69ad3cf87a43c5eea4872f4f7ba1"
