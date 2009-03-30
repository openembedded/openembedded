SUMMARY = "Qt is a versatile cross-platform application framework -- this is the embedded version."
SECTION = "libs"
LICENSE = "GPL QPL"
PRIORITY = "optional"
HOMEPAGE = "http://www.trolltech.com"
DEPENDS += "tslib"
PR = "r10"

SRC_URI = "ftp://ftp.trolltech.com/qt/source/qt-embedded-linux-opensource-src-${PV}.tar.bz2 \
           file://0001-cross-compile.patch;patch=1 \
           file://0002-fix-resinit-declaration.patch;patch=1 \
           file://0003-no-tools.patch;patch=1 \
           file://0004-no-qmake.patch;patch=1 \
           file://0006-freetype-host-includes.patch;patch=1 \
           file://0007-openssl-host-includes.patch;patch=1 \
           file://0008-qt-lib-infix.patch;patch=1 \
           file://0009-support-2bpp.patch;patch=1 \
           file://g++.conf \
           file://linux.conf \
           "
S = "${WORKDIR}/qt-embedded-linux-opensource-src-${PV}"

QT_CONFIG_FLAGS += " \
    -qtlibinfix E \
    -qt-decoration-styled -plugin-decoration-default -plugin-decoration-windows \
    -plugin-gfx-transformed -plugin-gfx-qvfb -plugin-gfx-vnc \
    -plugin-mouse-tslib -qt-mouse-pc -qt-mouse-qvfb \
    -qt-kbd-tty -qt-kbd-usb -qt-kbd-qvfb \
    -DQT_KEYPAD_NAVIGATION \
    "

QT_BASE_NAME = "qt-embedded"
QT_BASE_LIB  = "libqt-embedded"
QT_DIR_NAME = "qtopia"
QT_LIBINFIX="E"

require qt4.inc

inherit qt4e
