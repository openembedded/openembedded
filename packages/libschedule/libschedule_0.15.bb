LICENSE = "LGPL"
PR = "r3"
DESCRIPTION = "RTC alarm handling library for GPE"
SECTION = "gpe/libs"
PRIORITY = "optional"
MAINTAINER = "Philip Blundell <pb@handhelds.org>"
DEPENDS = "glib-2.0 sqlite"
GPE_TARBALL_SUFFIX = "gz"

inherit autotools libtool pkgconfig gpe 

headers = "schedule.h"

do_stage () {
	oe_libinstall -so libschedule ${STAGING_LIBDIR}

	mkdir -p ${STAGING_INCDIR}/gpe
	for h in ${headers}; do
		install -m 0644 ${S}/gpe/$h ${STAGING_INCDIR}/gpe/$h
	done
}

