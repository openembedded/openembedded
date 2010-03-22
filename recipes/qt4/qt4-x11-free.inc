DESCRIPTION = "Qt is a versatile cross-platform application framework -- this is the X11 version."
SECTION = "x11/libs"
PRIORITY = "optional"
HOMEPAGE = "http://www.trolltech.com"
LICENSE = "GPL QPL"
DEPENDS += "virtual/libx11 fontconfig xft libxext libxrender libxrandr libxcursor"

INC_PR = "r16"

SRC_URI = "ftp://ftp.trolltech.com/qt/source/qt-x11-opensource-src-${PV}.tar.gz \
           file://0001-cross-compile.patch;patch=1 \
           file://0002-fix-resinit-declaration.patch;patch=1 \
           file://0003-no-tools.patch;patch=1 \
           file://0004-no-qmake.patch;patch=1 \
           file://0006-freetype-host-includes.patch;patch=1 \
           file://0007-openssl-host-includes.patch;patch=1 \ 
           file://0008-qt-lib-infix.patch;patch=1 \
           file://fix-config-tests.patch;patch=1 \
           file://g++.conf \
           file://linux.conf \
           "
S = "${WORKDIR}/qt-x11-opensource-src-${PV}"

QT_GLFLAGS ?= "-no-opengl"
QT_CONFIG_FLAGS += "-no-xinerama -no-xkb ${QT_GLFLAGS}"
QT_BASE_NAME ?= "qt4"
QT_BASE_LIB  ?= "libqt"
QT_DIR_NAME = "qt4"
QT_LIBINFIX = ""

require qt4.inc

inherit qt4x11

