SECTION = "libs"
DESCRIPTION = "library for extracting mime data from .desktop files."
DEPENDS = "glib-2.0"
LICENSE = "GPL"
inherit pkgconfig

SRC_URI = "${GPE_MIRROR}/libdotdesktop-${PV}.tar.gz \
	file://make_build_var.patch;patch=1"

headers = "dotdesktop.h"

do_stage () {
	oe_libinstall -so libdotdesktop ${STAGING_LIBDIR}
        mkdir -p ${STAGING_INCDIR}/gpe
        for h in ${headers}; do
                install -m 0644 ${S}/$h ${STAGING_INCDIR}/gpe/$h
        done
}

do_install () {
	oe_runmake PREFIX=${prefix} DESTDIR=${D} install-program
        oe_runmake PREFIX=${prefix} DESTDIR=${D} install-devel
}
