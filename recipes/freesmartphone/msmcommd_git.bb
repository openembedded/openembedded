DESCRIPTION = "Low level protocol implementation for binary protocol spoken by some Qualcomm modems"
HOMEPAGE = "http://www.freesmartphone.org"
AUTHOR = "Simon Busch <morphis@gravedo.de>"
SECTION = "console/network"
LICENSE = "GPL"
DEPENDS = "libgee libfsotransport"
SRCREV = "f029e181dbcf6b83bcebc24fb7d5dff113e70e63"
PV = "0.1.0+gitr${SRCPV}"
PR = "r2"
PE = "1"

SRC_URI = "${FREESMARTPHONE_GIT}/msmcomm.git;protocol=git;branch=master"
S = "${WORKDIR}/git"

inherit autotools vala

PACKAGES =+ "${PN}-lib ${PN}-term"
FILES_${PN}-lib = "${libdir}/lib*.so.*"
FILES_${PN}-term = "${sbindir}/msmvterm"

