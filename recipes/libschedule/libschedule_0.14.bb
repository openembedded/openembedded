LICENSE = "LGPL"
PR = "r1"
DESCRIPTION = "RTC alarm handling library for GPE"
SECTION = "gpe/libs"
PRIORITY = "optional"
DEPENDS = "glib-2.0"

inherit pkgconfig gpe

headers = "schedule.h"

do_stage () {
	oe_libinstall -so libschedule ${STAGING_LIBDIR}

	mkdir -p ${STAGING_INCDIR}/gpe
	for h in ${headers}; do
		install -m 0644 ${S}/gpe/$h ${STAGING_INCDIR}/gpe/$h
	done
}

do_install () {
	gpe_do_install
	oe_runmake PREFIX=${prefix} DESTDIR=${D} install-devel
}

SRC_URI[md5sum] = "f4fd8f525e2cd4100db89bd6b4f92934"
SRC_URI[sha256sum] = "d86d490bada35c041b1134b15f1abc94364c798dedc974d2c5ff2127d1b80487"
