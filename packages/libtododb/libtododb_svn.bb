LICENSE = "LGPL"
DESCRIPTION = "Database access for GPE to-do list"
MAINTAINER = "Philippe De Swert <philippedeswert@scarlet.be>"
SECTION = "gpe/libs"
PRIORITY = "optional"
DEPENDS = "libgpewidget libgpepimc sqlite"
PR = "r0"
PV = "0.10+svn${SRCDATE}"

DEFAULT_PREFERENCE = "-1"

inherit pkgconfig gpe autotools
 
SRC_URI = "svn://projects.linuxtogo.org/svn/gpe/trunk/base;module=${PN}"

S = "${WORKDIR}/${PN}"

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
