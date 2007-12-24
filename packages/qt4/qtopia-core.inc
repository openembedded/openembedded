SUMMARY = "QtopiaCore"
SECTION = "libs"
LICENSE = "GPL"
PRIORITY = "optional"
HOMEPAGE = "http://www.trolltech.com"
DEPENDS = "freetype tslib"

SRC_URI = "ftp://ftp.trolltech.com/qt/source/qtopia-core-opensource-src-${PV}.tar.gz \
           file://linux-oe-qmake.conf"
S = "${WORKDIR}/qtopia-core-opensource-src-${PV}"
inherit pkgconfig


QT_BASE_NAME = "qtopiacore"
QT_BASE_LIB  = "libqtopiacore"
QT_LIBRARY_NAME = "libQt"
require qt_packaging.inc
