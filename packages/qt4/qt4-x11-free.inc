DESCRIPTION = "Qt is a versatile cross-platform application framework -- this is the X11 version."
SECTION = "x11/libs"
PRIORITY = "optional"
HOMEPAGE = "http://www.trolltech.com"
LICENSE = "GPL QPL"
DEPENDS += "virtual/libx11 xft libxext libxrender libxrandr libxcursor"
PROVIDES = "qt4x11"
PR = "r6"

SRC_URI = "ftp://ftp.trolltech.com/qt/source/qt-x11-opensource-src-${PV}.tar.gz \
           file://0001-cross-compile.patch;patch=1 \
           file://0003-no-tools.patch;patch=1 \
           file://0004-no-qmake.patch;patch=1 \
           file://0005-fix-mkspecs.patch;patch=1"
S = "${WORKDIR}/qt-x11-opensource-src-${PV}"


QT_CONFIG_FLAGS += "-no-xinerama -no-tablet -no-xkb -no-opengl"
QT_BASE_NAME = "qt4"
QT_BASE_LIB  = "libqt"
QT_LIBRARY_NAME = "libQt"
QT_DIR_NAME = "qt4"
require qt_depends.inc
require qt_packaging.inc

inherit qt4x11
