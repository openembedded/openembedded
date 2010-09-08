DESCRIPTION = "Touchscreen management daemon - manages the touchscreen of the palm pre machine"
HOMEPAGE = "http://www.freesmartphone.org"
AUTHOR = "Valéry Febvre <vfebvre@easter-eggs.com>
SECTION = "base"
LICENSE = "GPL"

DEPENDS = "tslib"

PR = "r0"
PV = "1.0.0+gitr${SRCPV}"

SRCREV = "798c26a7022decaebdaa829ec30852fdcf08f061"
SRC_URI = " \
 ${FREESMARTPHONE_GIT}/utilities.git;protocol=git;branch=master \
 file://tsmd \
"

S = "${WORKDIR}/git/palmpre/tsmd"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit autotools update-rc.d

INITSCRIPT_NAME = "tsmd"
INITSCRIPT_PARAMS = "defaults 00"

do_install_append() {
	install -d 0644 ${D}${sysconfdir}/init.d/
	install -m 0755 ${WORKDIR}/${INITSCRIPT_NAME} ${D}${sysconfdir}/init.d/
}
