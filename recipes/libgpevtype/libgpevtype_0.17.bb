LICENSE     = "LGPL"
DESCRIPTION = "Data interchange library for GPE"
SECTION = "gpe/libs"
PRIORITY    = "optional"
DEPENDS     = "libmimedir libeventdb"
PR          = "r0"

DEFAULT_PREFERENCE = "-1"

inherit pkgconfig gpe autotools

SRC_URI = "${GPE_MIRROR}/${PN}-${PV}.tar.bz2"

headers = "tag-db.h vcard.h vevent.h vtodo.h"


do_stage () {
	autotools_stage_all
}



SRC_URI[md5sum] = "c9c031ee32bcdb3c8bf0d31083330d63"
SRC_URI[sha256sum] = "21c026c120861d8b1b1178e8744a3626a56ff231c35cce0a5176305a977949ff"
