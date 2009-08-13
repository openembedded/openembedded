DESCRIPTION = "A GSM 07.10 Protocol Engine"
LICENSE = "GPL"
SECTION = "devel"
PV = "1.1.1+gitr${SRCPV}"
PR = "r1"

SRC_URI = "${FREESMARTPHONE_GIT}/libgsm0710.git;protocol=git;branch=master"
S = "${WORKDIR}/git"

inherit autotools_stage pkgconfig vala
