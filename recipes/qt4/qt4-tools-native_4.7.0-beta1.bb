DEFAULT_PREFERENCE = "-1"

require qt4-tools-native.inc
LICENSE = "LGPLv2.1 GPLv3"

SRCVER = "4.7.0-beta1"
PV = "4.6.2+${SRCVER}"
PR = "${INC_PR}.0"

SRC_URI = "ftp://ftp.trolltech.com/qt/source/qt-everywhere-opensource-src-${SRCVER}.tar.gz \
           file://fix.xlib-test.libs.patch \
           file://qt-config.patch \
           file://g++.conf \
           file://linux.conf"
S = "${WORKDIR}/qt-everywhere-opensource-src-${SRCVER}"

EXTRA_OECONF += " -no-fast -silent -no-rpath"

TOBUILD := "src/tools/bootstrap ${TOBUILD}"

SRC_URI[md5sum] = "1a863712da64dd2c1d08380075b74f39"
SRC_URI[sha256sum] = "32237307496b255bb95abdcd1754885947008a52c76f32c6843744d330f2b7b5"
