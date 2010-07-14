DESCRIPTION = "A generic framework for phone ui"
HOMEPAGE = "http://shr-project.org/"
LICENSE = "GPL"
SECTION = "libs"
SRCREV = "cac36ceb360c457b8dce993f6363cf8688ab428a"
PV = "0.0.0+gitr${SRCPV}"
PR = "r0"

DEPENDS="glib-2.0 dbus-glib libframeworkd-glib libfso-glib libfsoframework libphone-utils alsa-lib"

inherit pkgconfig autotools autotools_stage

SRC_URI = "git://git.shr-project.org/repo/libphone-ui.git;protocol=http;branch=master"

S="${WORKDIR}/git"

CONFFILES_${PN} = "${sysconfdir}/libphoneui.conf"
