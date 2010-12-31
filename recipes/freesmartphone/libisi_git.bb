DESCRIPTION = "libisi is a library implementing the Nokia ISI protocol"
SECTION = "libs/network"
AUTHOR = "Sebastian Reichel <sre@ring0.de>"
LICENSE = "GPLv2"
DEPENDS = "glib-2.0"
SRC_URI = "${FREESMARTPHONE_GIT}/libisi.git;protocol=git;branch=master"
S = "${WORKDIR}/git"

SRCREV = "04f40b06bc8398715c53aa11ebf16799d4da6c6e"
PV = "0.0.1+gitr${SRCPV}"

inherit vala autotools

EXTRA_OECONF = "--enable-tests"

PACKAGES =+ "${PN}-tests"
FILES_${PN}-tests = "${sbindir}/*"
DESCRIPTION_${PN}-tests = "${PN} runtime tests"
