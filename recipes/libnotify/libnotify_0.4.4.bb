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

SRC_URI[md5sum] = "ba76f68b7e3bd284ac2c2a1b9c5ecb06"
SRC_URI[sha256sum] = "2389a9b8220f776033f728a8d46352cfee5c8705066e34887bfb188f9f0d3856"
