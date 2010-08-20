DESCRIPTION = "full-featured Jabber/XMPP client library."
SECTION = "networking"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "iksemel libidn gnutls"
PR = "r0"

SRC_URI = "http://camaya.net/download/${P}.tar.bz2 \
          "
SRC_URI[md5sum] = "f8eacf1c6476e0a309b453fd04f90e31"
SRC_URI[sha256sum] = "b53f3e83e97f2f8d46e482620389b7778b7b0d95b2518ce5e1ae6d81bb2bcde8"

inherit autotools pkgconfig

