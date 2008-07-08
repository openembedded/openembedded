require uicmoc4-native.inc

SRC_URI = "ftp://ftp.trolltech.com/qt/source/qt-embedded-linux-opensource-src-${PV}.tar.bz2 \
           file://configure-fix.patch;patch=1"
S = "${WORKDIR}/qt-embedded-linux-opensource-src-${PV}"


