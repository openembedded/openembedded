DESCRIPTION = "Touchscreen management daemon - manages the touchscreen of the palm pre machine"
HOMEPAGE = "http://www.freesmartphone.org"
AUTHOR = "Valéry Febvre <vfebvre@easter-eggs.com>
SECTION = "base"
LICENSE = "GPL"

DEPENDS = "tslib"

PR = "r4"
PV = "1.0.0+gitr${SRCPV}"

SRCREV = "9262a2e4f8f6e6c7bcacf1eeae0ad348cbfcce06"
SRC_URI = " \
 ${FREESMARTPHONE_GIT}/utilities.git;protocol=git;branch=master \
 file://tsmd \
 file://tsmd_control \
"

S = "${WORKDIR}/git/palmpre/tsmd"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit autotools update-rc.d

INITSCRIPT_NAME = "tsmd"
INITSCRIPT_PARAMS = "defaults 10"

do_install_append() {
	install -d 0644 ${D}${sysconfdir}/init.d/
	install -m 0755 ${WORKDIR}/${INITSCRIPT_NAME} ${D}${sysconfdir}/init.d/
	install -d 0644 ${D}${base_bindir}/
	install -m 0755 ${WORKDIR}/tsmd_control ${D}${exec_prefix}/bin/tsmd_control
}
