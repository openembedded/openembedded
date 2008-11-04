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
