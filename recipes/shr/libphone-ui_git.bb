DESCRIPTION = "A generic framework for phone ui"
HOMEPAGE = "http://shr-project.org/"
LICENSE = "GPL"
SECTION = "libs"
SRCREV = "2a87a548f004d7e7c7a45cdca5816b552e2b1796"
PV = "0.0.0+gitr${SRCPV}"
PR = "r0"

DEPENDS="glib-2.0 dbus-glib libframeworkd-glib libfso-glib libfsoframework libphone-utils alsa-lib"

inherit pkgconfig autotools autotools_stage

SRC_URI = "git://git.shr-project.org/repo/libphone-ui.git;protocol=http;branch=master \
           file://0001-libphoneui.conf-update-alsa-control-name-for-2.6.31.patch"

S="${WORKDIR}/git"

CONFFILES_${PN} = "${sysconfdir}/libphoneui.conf"
