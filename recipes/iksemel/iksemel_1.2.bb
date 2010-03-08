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
