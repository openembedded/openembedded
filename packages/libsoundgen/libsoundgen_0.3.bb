SECTION = "x11/libs"
inherit gpe
LICENSE = "LGPL"
DEPENDS = "esound-gpe"

do_stage() {
	install -d ${STAGING_INCDIR}/gpe
	install -m 0644 gpe/soundgen.h ${STAGING_INCDIR}/gpe/soundgen.h
	oe_libinstall -so libsoundgen ${STAGING_LIBDIR}
}

do_install_append() {
	oe_runmake DESTDIR="${D}" PREFIX="${prefix}" install-devel
}
