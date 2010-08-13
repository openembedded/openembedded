DESCRIPTION = "A generic framework for phone ui"
HOMEPAGE = "http://shr-project.org/"
LICENSE = "GPL"
SECTION = "libs"
SRCREV = "e031bdc36168da3c821c36fe470eb920c41ea92b"
PV = "0.0.1+gitr${SRCPV}"
PR = "r0"

DEPENDS="glib-2.0 dbus-glib libframeworkd-glib libfso-glib libfsoframework libphone-utils alsa-lib"

inherit pkgconfig autotools autotools

SRC_URI = "git://git.shr-project.org/repo/libphone-ui.git;protocol=http;branch=master"

S="${WORKDIR}/git"

CONFFILES_${PN} = "${sysconfdir}/libphoneui.conf"
