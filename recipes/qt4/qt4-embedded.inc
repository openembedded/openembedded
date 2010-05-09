SUMMARY = "Qt is a versatile cross-platform application framework -- this is the embedded version."
SECTION = "libs"
LICENSE = "GPL QPL"
PRIORITY = "optional"
HOMEPAGE = "http://www.trolltech.com"
DEPENDS += "directfb tslib"
INC_PR = "r19"

QT_BASE_NAME ?= "qt4-embedded"
QT_BASE_LIB  ?= "libqt-embedded"
QT_DIR_NAME = "qtopia"
QT_LIBINFIX = "E"

SRC_URI = "ftp://ftp.trolltech.com/qt/source/qt-embedded-linux-opensource-src-${PV}.tar.bz2 \
           file://0001-cross-compile.patch;patch=1 \
           file://0002-fix-resinit-declaration.patch;patch=1 \
           file://0003-no-tools.patch;patch=1 \
           file://0004-no-qmake.patch;patch=1 \
           file://0006-freetype-host-includes.patch;patch=1 \
           file://0007-openssl-host-includes.patch;patch=1 \
           file://0008-qt-lib-infix.patch;patch=1 \
           file://0009-support-2bpp.patch;patch=1 \
           file://fix-config-tests.patch;patch=1 \
           file://g++.conf \
           file://linux.conf \
           "

# Set necessary variables in the profile
SRC_URI += "file://qte.sh"

S = "${WORKDIR}/qt-embedded-linux-opensource-src-${PV}"

QT_CONFIG_FLAGS += " \
    -qtlibinfix ${QT_LIBINFIX} \
    -plugin-gfx-transformed -plugin-gfx-qvfb -plugin-gfx-vnc -plugin-gfx-directfb \
    -plugin-mouse-tslib -qt-mouse-pc -qt-mouse-qvfb -qt-mouse-linuxinput \
    -qt-kbd-tty \
    -DQT_KEYPAD_NAVIGATION \
    "

require qt4.inc

do_install_append() {
	install -d ${D}${sysconfdir}/profile.d/
	install -m 0755 ${WORKDIR}/qte.sh ${D}${sysconfdir}/profile.d/
}

FILES_qt4-embedded += " ${sysconfdir}/profile.d/qte.sh"

inherit qt4e

