LICENSE = "LGPL"
DESCRIPTION = "Database access for GPE to-do list"
SECTION = "gpe/libs"
PRIORITY = "optional"
MAINTAINER = "Philip Blundell <pb@handhelds.org>"
DEPENDS = "libgpewidget libgpepimc sqlite"


inherit pkgconfig gpe autotools

SRC_URI="${GPE_MIRROR}/${PN}-${PV}.tar.bz2"
headers = "todo-db.h"

do_stage () {
	oe_libinstall -so libtododb ${STAGING_LIBDIR}

	mkdir -p ${STAGING_INCDIR}/gpe
	for h in ${headers}; do
		install -m 0644 ${S}/gpe/$h ${STAGING_INCDIR}/gpe/$h
	done
}

do_install () {
	gpe_do_install
#	oe_runmake PREFIX=${prefix} DESTDIR=${D} install-devel
}
