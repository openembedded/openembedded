MAINTAINER = "Philippe De Swert <philippedeswert@scarlet.be>"
LICENSE     = "LGPL"
DESCRIPTION = "Data interchange library for GPE"
SECTION     = "gpe/libs"
PRIORITY    = "optional"
DEPENDS     = "libmimedir libeventdb"
PR          = "r0"
PV = "0.17+svn${SRCDATE}"

DEFAULT_PREFERENCE = "-1"

inherit pkgconfig gpe autotools

SRC_URI = "svn://projects.linuxtogo.org/svn/gpe/trunk/base;module=${PN}"

S = "${WORKDIR}/${PN}"

headers = "tag-db.h vcard.h vevent.h vtodo.h"


do_stage () {
	oe_libinstall -so libgpevtype ${STAGING_LIBDIR}

	mkdir -p ${STAGING_INCDIR}/gpe
	for h in ${headers}; do
		install -m 0644 ${S}/gpe/$h ${STAGING_INCDIR}/gpe/${h}
	done
}


