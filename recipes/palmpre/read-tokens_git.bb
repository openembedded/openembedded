DESCRIPTION = "Little utility to read 'tokens' from internal flash and store them in a smartkeyfile; specific for palmpre machine"
HOMEPAGE = "http://www.freesmartphone.org"
AUTHOR = "Simon Busch <morphis@gravedo.de>
SECTION = "console/utils"
LICENSE = "GPL"
PR = "r1"
PV = "1.0.0+gitr${SRCPV}"

SRCREV = "704b7965ad1936bf935b576d4663590bdaab09b1"
SRC_URI = " \
 ${FREESMARTPHONE_GIT}/utilities.git;protocol=git;branch=master \
 file://read_tokens \
"
S = "${WORKDIR}/git/palmpre/read_tokens"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit autotools update-rc.d

INITSCRIPT_NAME = "read_tokens"
INITSCRIPT_PARAMS = "defaults 23"

do_install_append() {
	install -d ${D}${sysconfdir}/init.d/
	install -m 0755 ${WORKDIR}/read_tokens ${D}${sysconfdir}/init.d/
}

