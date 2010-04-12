LICENSE     = "GPL"
DESCRIPTION = "full-featured Jabber/XMPP client library."
SECTION = "networking"
PRIORITY    = "optional"
PR          = "r0"

DEPENDS = "iksemel libidn gnutls"

inherit autotools pkgconfig

SRC_URI = "http://camaya.net/download/${P}.tar.bz2"

do_stage () {
	autotools_stage_all
}

SRC_URI[md5sum] = "9054d072f5972d5e567c428531734ad5"
SRC_URI[sha256sum] = "7f836c8189b55ef4ec8f3387673687d0a5c1a713abc9617144638b28e6857bd2"
