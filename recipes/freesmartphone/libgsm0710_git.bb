DESCRIPTION = "A GSM 07.10 Protocol Engine"
AUTHOR = "TROLLTECH ASA, Michael Lauer"
HOMEPAGE = "http://www.freesmartphone.org/index.php/Implementations/libgsm0710"
LICENSE = "GPL"
SECTION = "devel"
PV = "1.1.1+gitr${SRCPV}"
PR = "r0"
PE = "1"

SRC_URI = "${FREESMARTPHONE_GIT}/libgsm0710.git;protocol=git;branch=master"
S = "${WORKDIR}/git"

inherit autotools_stage pkgconfig

# ship vala bindings
FILES_${PN}-dev += "${datadir}/vala"
