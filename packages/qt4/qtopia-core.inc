SUMMARY = "Qt is a versatile cross-platform application framework -- this is the QtopiaCore/Embedded version."
SECTION = "libs"
LICENSE = "GPL"
PRIORITY = "optional"
HOMEPAGE = "http://www.trolltech.com"
DEPENDS += "tslib"
PR = "r3"

SRC_URI = "ftp://ftp.trolltech.com/qt/source/qtopia-core-opensource-src-${PV}.tar.gz \
           file://qconfig-oe.h \
           file://0001-cross-compile.patch;patch=1 \
           file://0003-no-tools.patch;patch=1 \
           file://0004-no-qmake.patch;patch=1 \
           file://0005-fix-mkspecs.patch;patch=1 \
           file://build-tools.patch;patch=1"
S = "${WORKDIR}/qtopia-core-opensource-src-${PV}"


QT_CONFIG_FLAGS += " \
    -nomake demos -nomake examples -nomake tools -qtlibinfix E\
    -embedded ${QT_ARCH} \
    -qt-decoration-styled -plugin-decoration-default -plugin-decoration-windows \
    -plugin-gfx-transformed -plugin-gfx-qvfb -plugin-gfx-vnc\
    -plugin-mouse-tslib -qt-mouse-pc -qt-mouse-qvfb\
    -qt-kbd-tty -qt-kbd-usb -qt-kbd-qvfb\
    ${QT_QCONFIG} \
    "

do_configure_prepend() {
    cp ${WORKDIR}/qconfig-oe.h ${S}/src/corelib/global
}

QT_QCONFIG = ""
QT_BASE_NAME = "qtopiacore"
QT_BASE_LIB  = "libqtopiacore"
QT_DIR_NAME = "qtopia"
QT_LIBINFIX="E"
require qt_depends.inc
require qt_configuration.inc
require qt_packaging.inc
require qt_staging.inc

inherit qtopia4core
