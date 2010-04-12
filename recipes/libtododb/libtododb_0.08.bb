LICENSE = "LGPL"
DESCRIPTION = "Database access for GPE to-do list"
SECTION = "gpe/libs"
PRIORITY = "optional"
DEPENDS = "libgpewidget libgpepimc sqlite"

inherit pkgconfig gpe

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
	oe_runmake PREFIX=${prefix} DESTDIR=${D} install-devel
}

SRC_URI[md5sum] = "90b0b326aea78019aff9b85b37b99cc2"
SRC_URI[sha256sum] = "4dc7c72cf11407ab6e7edddf09273d82fa46b3662077473503b75a69972140b1"
