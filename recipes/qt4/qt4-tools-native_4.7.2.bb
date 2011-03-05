DEFAULT_PREFERENCE = "-1"

require qt4-tools-native.inc
LICENSE = "LGPLv2.1 GPLv3"

PR = "${INC_PR}.0"

# Find the g++.conf/linux.conf in the right directory.
FILESPATHPKG =. "qt-${PV}:"
SRC_URI = "ftp://ftp.trolltech.com/qt/source/qt-everywhere-opensource-src-${PV}.tar.gz \
           file://qt-config.patch \
           file://g++.conf \
           file://linux.conf"
S = "${WORKDIR}/qt-everywhere-opensource-src-${PV}"

EXTRA_OECONF += " -no-fast -silent -no-rpath"

TOBUILD := "src/tools/bootstrap ${TOBUILD}"

SRC_URI[md5sum] = "66b992f5c21145df08c99d21847f4fdb"
SRC_URI[sha256sum] = "d4783b524b90bcd270ccf6e7a30d5fb51696c47eb5de49ebc2d553cd3eb49336"
