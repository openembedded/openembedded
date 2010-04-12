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

SRC_URI[md5sum] = "5df2e1f7564d066dce6ec24344605528"
SRC_URI[sha256sum] = "bc3fb1a20ec97149f6e81285a22bdc48fea9c4fbc9abad6919b87ce2f44acbc3"
