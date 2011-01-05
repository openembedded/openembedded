DESCRIPTION = "A generic framework for phone ui"
HOMEPAGE = "http://shr-project.org/"
LICENSE = "GPL"
SECTION = "libs"
SRCREV = "24782b2c95c4c955db31ae5fcb4e2ed9ceebb0a7"
PV = "0.0.1+gitr${SRCPV}"
PR = "r0"

DEPENDS="glib-2.0 libshr-glib libfso-glib libfsoframework libphone-utils alsa-lib"

inherit pkgconfig autotools autotools

SRC_URI = "git://git.shr-project.org/repo/libphone-ui.git;protocol=http;branch=master"

S="${WORKDIR}/git"

CONFFILES_${PN} = "${sysconfdir}/libphoneui.conf"
