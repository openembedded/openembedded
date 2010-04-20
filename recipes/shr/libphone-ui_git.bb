DESCRIPTION = "A generic framework for phone ui"
HOMEPAGE = "http://shr-project.org/"
LICENSE = "GPL"
SECTION = "libs"
SRCREV = "1e5b5bb3cb8de11a068ca43e20b9481c51e7a26f"
PV = "0.0.0+gitr${SRCPV}"
PR = "r0"

DEPENDS="glib-2.0 dbus-glib libframeworkd-glib libphone-utils alsa-lib"

inherit pkgconfig autotools autotools_stage

SRC_URI = "git://git.shr-project.org/repo/libphone-ui.git;protocol=http;branch=master"
S="${WORKDIR}/git"

CONFFILES_${PN} = "${sysconfdir}/libphoneui.conf"
