LICENSE = 	"LGPL"
DESCRIPTION = 	"Data interchange library for GPE"
SECTION = 	"gpe/libs"
PRIORITY = 	"optional"
MAINTAINER = 	"Koen Kooi <koen@handhelds.org>"
DEPENDS = 	"libmimedir"

DEFAULT_PREFERENCE = "-1"

S = "${WORKDIR}/${PN}"
PV = "0.17+cvs${SRCDATE}"
PR = "r0"

inherit pkgconfig gpe autotools

SRC_URI = "${HANDHELDS_CVS};module=gpe/base/${PN}"


headers = "tag-db.h vcard.h vevent.h vtodo.h"


do_stage () {
	oe_libinstall -so libgpevtype ${STAGING_LIBDIR}

	mkdir -p ${STAGING_INCDIR}/gpe
	for h in ${headers}; do
		install -m 0644 ${S}/gpe/$h ${STAGING_INCDIR}/gpe/${h}
	done
}


