DESCRIPTION = "FSO's variant of the qdbusxml2cpp utility"
SECTION = "devel"
DEPENDS = "qt4-native"
LICENSE = "LGPLv2"
INC_PR = "r0"

SRCREV = "de705c0b633c612aedb1273340c36fae59be9511"

SRC_URI = "${FREESMARTPHONE_GIT}/qfsodbusxml2cpp.git;protocol=git;branch=master"
S = "${WORKDIR}/git"

inherit autotools native
