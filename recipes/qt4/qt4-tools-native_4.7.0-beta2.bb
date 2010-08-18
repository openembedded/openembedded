DEFAULT_PREFERENCE = "-1"

require qt4-tools-native.inc
LICENSE = "LGPLv2.1 GPLv3"

DEPENDS += "libxau-native libxdmcp-native"

SRCVER = "4.7.0-beta2"
PV = "4.6.3+${SRCVER}"
PR = "${INC_PR}.0"

SRC_URI = "ftp://ftp.trolltech.com/qt/source/qt-everywhere-opensource-src-${SRCVER}.tar.gz \
           file://fix.xlib-test.libs.patch \
           file://qt-config.patch \
           file://g++.conf \
           file://linux.conf"
S = "${WORKDIR}/qt-everywhere-opensource-src-${SRCVER}"

EXTRA_OECONF += " -no-fast -silent -no-rpath"

TOBUILD := "src/tools/bootstrap ${TOBUILD}"

SRC_URI[md5sum] = "1449443c2d33ab9fefbd37b7104d0cdf"
SRC_URI[sha256sum] = "e0196ee11f683a4ec2e3f85e52ab2f2455886a3bb3b711489176f97ecb9aacbf"
