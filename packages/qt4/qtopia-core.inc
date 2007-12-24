SUMMARY = "Qt is a versatile cross-platform application framework -- this is the QtopiaCore/Embedded version."
SECTION = "libs"
LICENSE = "GPL"
PRIORITY = "optional"
HOMEPAGE = "http://www.trolltech.com"
DEPENDS += "tslib"

SRC_URI = "ftp://ftp.trolltech.com/qt/source/qtopia-core-opensource-src-${PV}.tar.gz \
           file://linux-oe-qmake.conf"
S = "${WORKDIR}/qtopia-core-opensource-src-${PV}"


QT_BASE_NAME = "qtopiacore"
QT_BASE_LIB  = "libqtopiacore"
QT_LIBRARY_NAME = "libQt"
QT_DIR_NAME = "qtopia"
require qt_packaging.inc
require qt_depends.inc

inherit qtopia4core
