DESCRIPTION = "Low level protocol implementation for binary protocol spoken by some Qualcomm modems"
HOMEPAGE = "http://www.freesmartphone.org"
AUTHOR = "Simon Busch <morphis@gravedo.de>"
SECTION = "console/network"
LICENSE = "GPL"
DEPENDS = "libgee libfsotransport"
SRCREV = "cdbb26ba215cf314cf8ccf25a5e7cbdcb9f7bece"
PV = "0.1.0+gitr${SRCPV}"
PR = "r2"
PE = "1"

SRC_URI = "${FREESMARTPHONE_GIT}/msmcomm.git;protocol=git;branch=master"
S = "${WORKDIR}/git"

inherit autotools vala

PACKAGES =+ "${PN}-lib ${PN}-term"
FILES_${PN}-lib = "${libdir}/lib*.so.*"
FILES_${PN}-term = "${sbindir}/msmvterm"

