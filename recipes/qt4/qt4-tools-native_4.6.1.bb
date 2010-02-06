DEFAULT_PREFERENCE = "-1"

require qt4-tools-native.inc
LICENSE = "LGPLv2.1 GPLv3"
PR = "${INC_PR}.0"

SRC_URI = "ftp://ftp.trolltech.com/qt/source/qt-everywhere-opensource-src-${PV}.tar.gz \
           file://configure-lflags.patch;patch=1 \
           file://qt-config.patch;patch=1 \
           file://g++.conf \
           file://linux.conf"

S = "${WORKDIR}/qt-everywhere-opensource-src-${PV}"

TOBUILD := "src/tools/bootstrap ${TOBUILD}"
