DESCRIPTION = "A generic framework for phone ui"
HOMEPAGE = "http://shr-project.org/"
LICENSE = "GPL"
SECTION = "libs"
SRCREV = "0c94c694c46a1f97d23c0f98a78dd5b3961fcff6"
PV = "0.0.0+gitr${SRCPV}"
PR = "r0"

DEPENDS="glib-2.0 dbus-glib libframeworkd-glib libfso-glib libfsoframework libphone-utils alsa-lib"

inherit pkgconfig autotools autotools_stage

SRC_URI = "git://git.shr-project.org/repo/libphone-ui.git;protocol=http;branch=master"
S="${WORKDIR}/git"

CONFFILES_${PN} = "${sysconfdir}/libphoneui.conf"
