DESCRIPTION = "A GSM 07.10 Protocol Engine"
LICENSE = "GPL"
SECTION = "devel"
SRCREV = "52eea64bdbb79c09002b46e98a5e656509884f72"
PV = "1.2.0+gitr${SRCREV}"
PR = "r0"

SRC_URI = "${FREESMARTPHONE_GIT}/libgsm0710.git;protocol=git;branch=master"
S = "${WORKDIR}/git"

inherit autotools_stage pkgconfig vala
