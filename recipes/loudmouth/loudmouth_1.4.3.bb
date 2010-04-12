DESCRIPTION = "Loudmouth is a lightweight and easy-to-use C library for programming with the Jabber protocol."
HOMEPAGE = "http://www.loudmouth-project.org/"
LICENSE = "LGPL"
DEPENDS = "glib-2.0 gnutls check"
PR = "r1"

SRC_URI = "http://ftp.imendio.com/pub/imendio/${PN}/src/${PN}-${PV}.tar.gz \
           file://04-use-pkg-config-for-gnutls.patch;patch=1" 

inherit autotools pkgconfig

SRC_URI[md5sum] = "7ca8bf7c2313d7b7f27088c373d195e2"
SRC_URI[sha256sum] = "db252747e974b6be3e31d1b11089dc6aec3780989083df9bd75d76ddae7fb613"
