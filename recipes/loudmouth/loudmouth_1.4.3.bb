DESCRIPTION = "Loudmouth is a lightweight and easy-to-use C library for programming with the Jabber protocol."
HOMEPAGE = "http://www.loudmouth-project.org/"
LICENSE = "LGPL"
DEPENDS = "glib-2.0 gnutls check"
PR = "r1"

SRC_URI = "http://ftp.imendio.com/pub/imendio/${PN}/src/${PN}-${PV}.tar.gz \
           file://04-use-pkg-config-for-gnutls.patch;patch=1" 

inherit autotools pkgconfig
