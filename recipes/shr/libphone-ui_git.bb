DESCRIPTION = "A generic framework for phone ui"
HOMEPAGE = "http://shr-project.org/"
LICENSE = "GPL"
SECTION = "libs"
SRCREV = "4ad47c4db9ad766ad2b38ffc3bd181a85575fd75"
PV = "0.0.1+gitr${SRCPV}"
PR = "r1"

DEPENDS="glib-2.0 libshr-glib libfso-glib libfsoframework libphone-utils alsa-lib"

SRC_URI = " \
 git://git.shr-project.org/repo/libphone-ui.git;protocol=http;branch=master \
 file://libphoneui.conf \
"

S = "${WORKDIR}/git"

inherit autotools pkgconfig

do_install_append() {
	install -d ${D}${sysconfdir}
	install -m 0644 ${WORKDIR}/libphoneui.conf ${D}${sysconfdir}/libphoneui.conf
}

PACKAGES =+ "${PN}-config"
PACKAGE_ARCH_${PN}-config = "${MACHINE_ARCH}"

FILES_${PN}-config = " \
  ${sysconfdir}/libphoneui.conf \
"

CONFFILES_${PN}-config = "\
  ${sysconfdir}/libphoneui.conf \
"
