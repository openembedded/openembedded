DEFAULT_PREFERENCE = "-1"

require qt4-tools-native.inc
LICENSE = "LGPLv2.1 GPLv3"

DEPENDS += "libxau-native libxdmcp-native"

PR = "${INC_PR}.0"

SRC_URI = "ftp://ftp.trolltech.com/qt/source/qt-everywhere-opensource-src-${PV}.tar.gz \
           file://fix.xlib-test.libs.patch \
           file://qt-config.patch \
           file://g++.conf \
           file://linux.conf"
S = "${WORKDIR}/qt-everywhere-opensource-src-${PV}"

EXTRA_OECONF += " -no-fast -silent -no-rpath"

TOBUILD := "src/tools/bootstrap ${TOBUILD}"

SRC_URI[md5sum] = "3a2f25b9b115037277f4fb759194a7a5"
SRC_URI[sha256sum] = "e05256d560ca7d674cd4310bb791748900ad14ad662cbfe22b6d72ada43e7955"

