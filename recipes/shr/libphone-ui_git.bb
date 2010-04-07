DESCRIPTION = "A generic framework for phone ui"
HOMEPAGE = "http://shr-project.org/"
LICENSE = "GPL"
SECTION = "libs"
SRCREV = "08ccc9710b1f33c93cc8f1c20be9c658ef5040dd"
PV = "0.0.0+gitr${SRCREV}"
PR = "r0"

DEPENDS="glib-2.0 dbus-glib libframeworkd-glib libphone-utils alsa-lib"

inherit pkgconfig autotools autotools_stage

SRC_URI = "git://git.shr-project.org/repo/libphone-ui.git;protocol=http;branch=master"
S="${WORKDIR}/git"

CONFFILES_${PN} = "${sysconfdir}/libphoneui.conf"
