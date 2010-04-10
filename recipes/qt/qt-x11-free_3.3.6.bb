DEPENDS = "uicmoc3-native freetype virtual/libx11 xft libxext libxrender libxrandr libxcursor mysql virtual/libgl"
PROVIDES = "qt3x11"
PR = "r3"

SRC_URI = "ftp://ftp.trolltech.com/qt/source/qt-x11-free-${PV}.tar.bz2 \
	   file://configure.patch;patch=1 \
	   file://no-examples.patch;patch=1 \
           file://gcc4_1-HACK.patch;patch=1"

require qt-x11-free-common.inc

SRC_URI[md5sum] = "dc1384c03ac08af21f6fefab32d982cf"
SRC_URI[sha256sum] = "04f12083f6a6f7a8fd4d34a6c1efd37db76a67580c424f4fb7b7c43c0565e6ae"
