HOMEPAGE = "http://schrodinger.sourceforge.net/"
LICENSE = "MPL GPL LGPL MIT"
DEPENDS = "liboil orc-native orc"

PR = "r0"

SRC_URI = "http://www.diracvideo.org/download/schroedinger/${P}.tar.gz;name=schroedingertargz"
SRC_URI[schroedingertargz.md5sum] = "d67ec48b7c506db8c8b49156bf409e60"
SRC_URI[schroedingertargz.sha256sum] = "345abcaa72ff0f2e9c1075e22f7141475ee4e6eea23a7f568b69ffc13cc1c723"
SRC_URI += "file://configure.ac.patch;patch=1"

EXTRA_OECONF += "STAGING_DIR=${STAGING_DIR_NATIVE}"

inherit autotools

