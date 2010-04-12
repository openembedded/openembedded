DESCRIPTION = "Loudmouth is a lightweight and easy-to-use C library for programming with the Jabber protocol."
HOMEPAGE = "http://www.loudmouth-project.org/"
LICENSE = "LGPL"
DEPENDS = "glib-2.0 gnutls check"

SRC_URI = "http://ftp.imendio.com/pub/imendio/${PN}/src/${PN}-${PV}.tar.gz"

inherit autotools pkgconfig

do_stage() {
        autotools_stage_all
}

SRC_URI[md5sum] = "b80fb99e263dc67c2e8270bc22db8155"
SRC_URI[sha256sum] = "d7efb5a6c777ed0f375444a57e4de75e8406adb61d1f52829f84bc5404cfb03b"
