LICENSE = "LGPL"
DESCRIPTION = "Database access for GPE to-do list"
SECTION = "gpe/libs"
PRIORITY = "optional"
DEPENDS = "libgpewidget libgpepimc sqlite"

GPE_TARBALL_SUFFIX = "bz2"
inherit pkgconfig gpe autotools

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

SRC_URI[md5sum] = "9d2fe77ad48a31476896dddc55eddda5"
SRC_URI[sha256sum] = "f4e06f992f3237ad974a931c8c86e43b1025ffdc1fddc1f2cc98b77c8315b0ad"
