SUMMARY = "Qt is a versatile cross-platform application framework -- this is the QtopiaCore/Embedded version."
SECTION = "libs"
LICENSE = "GPL"
PRIORITY = "optional"
HOMEPAGE = "http://www.trolltech.com"
DEPENDS += "tslib"

SRC_URI = "ftp://ftp.trolltech.com/qt/source/qtopia-core-opensource-src-${PV}.tar.gz \
           file://0003-no-tools.patch;patch=1 \
           file://0004-no-qmake.patch;patch=1 \
           file://0005-fix-mkspecs.patch;patch=1"
S = "${WORKDIR}/qtopia-core-opensource-src-${PV}"


QT_CONFIG_FLAGS += " \
    -nomake demos -nomake examples -nomake tools \
    -qt-mouse-tslib -qt-gfx-transformed -embedded ${QT_ARCH}"
QT_BASE_NAME = "qtopiacore"
QT_BASE_LIB  = "libqtopiacore"
QT_LIBRARY_NAME = "libQt"
QT_DIR_NAME = "qtopia"
require qt_depends.inc
require qt_packaging.inc
require qt_staging.inc

inherit qtopia4core
