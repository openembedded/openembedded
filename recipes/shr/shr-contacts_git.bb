DESCRIPTION = "The SHR Contacts application"
HOMEPAGE = "http://shr-project.org/"
LICENSE = "GPL"
SECTION = "x11/applications"
DEPENDS += "dbus-glib libframeworkd-glib libframeworkd-phonegui"
PV = "0.0.2+gitr${SRCREV}"
PR = "r6"

inherit pkgconfig autotools

SRC_URI = "git://git.shr-project.org/repo/shr.git;protocol=http;branch=master"
S = "${WORKDIR}/git/${PN}"

