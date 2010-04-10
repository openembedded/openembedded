LICENSE     = "GPL"
DESCRIPTION = "full-featured Jabber/XMPP client library."
SECTION = "networking"
PRIORITY    = "optional"
PR          = "r0"

DEPENDS = "iksemel libidn gnutls"

inherit autotools pkgconfig

SRC_URI = "http://camaya.net/download/${P}.tar.bz2 \
	   file://gloox-fix-pc.diff;patch=1"

do_stage () {
	autotools_stage_all
}

SRC_URI[md5sum] = "dc590e34107de5cb296c238afa8e843b"
SRC_URI[sha256sum] = "9d9ef356cc4478499442573556787125dc76c8acd1e55e5001fb11f1e224d27f"
