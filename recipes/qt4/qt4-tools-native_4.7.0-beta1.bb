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

SRC_URI[md5sum] = "128dae41b23bb427b735548c7864703a"
SRC_URI[sha256sum] = "1107de986e4dda7795d094a2a3b5d85027d780b9b63e9860957cb1d6c56c8929"
