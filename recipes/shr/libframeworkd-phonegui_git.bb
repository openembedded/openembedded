DESCRIPTION = "Frameworkd phonegui library"
HOMEPAGE = "http://shr-project.org/"
LICENSE = "GPL"
SECTION = "libs"
PV = "0.0.2+gitr${SRCREV}"
PR = "r10"

DEPENDS="glib-2.0 dbus-glib libframeworkd-glib libphone-utils"

inherit pkgconfig autotools autotools_stage

SRC_URI = "git://git.shr-project.org/repo/shr.git;protocol=http;branch=master"
S = "${WORKDIR}/git/${PN}"

CONFFILES_${PN} = "${sysconfdir}/frameworkd-phonegui.conf"
