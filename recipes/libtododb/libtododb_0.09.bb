LICENSE = "LGPL"
DESCRIPTION = "Database access for GPE to-do list"
SECTION = "gpe/libs"
PRIORITY = "optional"
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

SRC_URI[md5sum] = "5a45e6b0a84b1ad0bb7fddb2d11cd9ad"
SRC_URI[sha256sum] = "8b8ed9c5d14330b5f6c79def8b54656b3e5241f2c5bd22e8fdc975af028f8f89"
