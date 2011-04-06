DESCRIPTION = "A GSM 07.10 Protocol Engine"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=59530bdf33659b29e73d4adb9f9f6552"
SECTION = "devel"
SRCREV = "52eea64bdbb79c09002b46e98a5e656509884f72"
PV = "1.2.0+gitr${SRCPV}"
PE = "1"
PR = "r0"

SRC_URI = "${FREESMARTPHONE_GIT}/libgsm0710.git;protocol=git;branch=master"
S = "${WORKDIR}/git"

inherit autotools vala
