require qtopia-core.inc

PROVIDES += "qtopia-core"
RPROVIDES_${PN} = "qtopia-core"

PR = "r1"

SRC_URI = "ftp://ftp.trolltech.com/qt/source/qt-embedded-linux-opensource-src-${PV}.tar.bz2 \
           file://qconfig-oe.h \
           file://0001-cross-compile.patch;patch=1 \
           file://0003-no-tools.patch;patch=1 \
           file://0004-no-qmake.patch;patch=1 \
           file://0005-fix-mkspecs.patch;patch=1 \
           file://build-tools.patch;patch=1"
S = "${WORKDIR}/qt-embedded-linux-opensource-src-${PV}"

SRC_URI += " \
           file://0006-freetype-host-includes.patch;patch=1 \
           file://0007-openssl-host-includes.patch;patch=1 \
#           file://0008-backport-qt-lib-infix.patch;patch=1 \
#           file://allow-configure-plugins.patch;patch=1 \
"

QT_CONFIG_FLAGS += " \
    -no-phonon -webkit \
	-DQT_KEYPAD_NAVIGATION \
 "

QT_BASE_NAME = "qt-embedded"
QT_BASE_LIB  = "libqt-embedded"


