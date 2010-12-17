DESCRIPTION = "libisi is a library implementing the PhoNet protocol"
SECTION = "libs/network"
AUTHOR = "Sebastian Reichel <sre@ring0.de>"
LICENSE = "GPLv2"
DEPENDS = "glib-2.0"
SRC_URI = "${FREESMARTPHONE_GIT}/libisi.git;protocol=git;branch=master"
SRCREV = "49809e4107fac3c8cf5f1e3ffce37030213e7e99"
PV = "0.0.0+gitr${SRCPV}"

inherit pkgconfig vala autotools

EXTRA_OECONF = "--enable-tests"

S = "${WORKDIR}/git"

PACKAGES =+ "${PN}-tests"

FILES_${PN}-tests = "${sbindir}/*"
DESCRIPTION_${PN}-tests = "${PN} runtime tests"
