DESCRIPTION = "Loudmouth is a lightweight and easy-to-use C library for programming with the Jabber protocol."
HOMEPAGE = "http://www.loudmouth-project.org/"
LICENSE = "LGPL"
DEPENDS = "glib-2.0 gnutls check"

SRC_URI = "http://ftp.imendio.com/pub/imendio/${PN}/src/${PN}-${PV}.tar.gz"

inherit autotools pkgconfig

do_stage() {
        autotools_stage_all
}

SRC_URI[md5sum] = "459fc597caea350951f647a92c9c272f"
SRC_URI[sha256sum] = "361a2861a5cd5bc7bd3320b60165c3bede06056ade7d75ab370d13a6b203d629"
