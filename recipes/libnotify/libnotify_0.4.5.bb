DESCRIPTION = "Send desktop notifications to a notification daemon"
HOMEPAGE = "http://www.galago-project.org/"
SECTION = "libs"
LICENSE = "LGPL"
DEPENDS = "dbus gtk+"
PR = "r0"

SRC_URI = "http://www.galago-project.org/files/releases/source/${PN}/${PN}-${PV}.tar.gz"

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}

SRC_URI[md5sum] = "472e2c1f808848365572a9b024d9e8f5"
SRC_URI[sha256sum] = "0799db8ea1500b65a477421a8c930cc8c8b0bbc0596e55ea1601e2542f3fb0d9"
