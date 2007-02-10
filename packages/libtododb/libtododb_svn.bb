DESCRIPTION = "Database access for GPE to-do list"
SECTION = "gpe/libs"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "libgpewidget libgpepimc sqlite"
PV = "0.10+svn${SRCDATE}"
PR = "r0"

inherit pkgconfig gpe autotools

SRC_URI = "${GPE_SVN}"

S = "${WORKDIR}/${PN}"

do_install () {
        gpe_do_install
#       oe_runmake PREFIX=${prefix} DESTDIR=${D} install-devel
}
do_stage () {
        oe_libinstall -so libtododb ${STAGING_LIBDIR}
        mkdir -p ${STAGING_INCDIR}/gpe
        for h in ${headers}; do
                install -m 0644 ${S}/gpe/$h ${STAGING_INCDIR}/gpe/$h
        done
}

headers = "todo-db.h"

DEFAULT_PREFERENCE = "-1"
