DESCRIPTION = "Sofia-SIP is an open-source SIP User-Agent library, compliant with the IETF RFC3261 specification."
HOMEPAGE = "http://sofia-sip.sourceforge.net/"
LICENSE = "LGPL"
DEPENDS = "glib-2.0 openssl"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${P}.tar.gz"

inherit autotools pkgconfig
