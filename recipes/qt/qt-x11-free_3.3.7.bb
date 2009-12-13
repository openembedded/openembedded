DEPENDS = "uicmoc3-native freetype virtual/libx11 libxmu xft libxext libxrender libxrandr libxcursor mysql virtual/libgl"
PROVIDES = "qt3x11"
PR = "r3"

SRC_URI = "ftp://ftp.trolltech.com/qt/source/qt-x11-free-${PV}.tar.bz2 \
	   file://configure.patch;patch=1 \
	   file://no-examples.patch;patch=1 \
           file://gcc4_1-HACK.patch;patch=1"

require qt-x11-free-common.inc
