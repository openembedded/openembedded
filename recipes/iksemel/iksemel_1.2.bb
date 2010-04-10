LICENSE     = "LGPL"
DESCRIPTION = "A simple, powerful XML-parsing library written in C."
SECTION = "libs"
PRIORITY    = "optional"
DEPENDS     = "gnutls"
PR          = "r0"

inherit pkgconfig autotools

SRC_URI = "http://files.jabberstudio.org/iksemel/${P}.tar.gz"

do_stage () {
	autotools_stage_all
}

SRC_URI[md5sum] = "82e7c8fdb6211839246b788c040a796b"
SRC_URI[sha256sum] = "a606e230b22d9d029998b84e5d6311a8ba35a304fe457e254eb5fd19943cd639"
