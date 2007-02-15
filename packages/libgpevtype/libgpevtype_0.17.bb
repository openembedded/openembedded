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


