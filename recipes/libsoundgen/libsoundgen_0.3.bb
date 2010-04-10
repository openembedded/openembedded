SECTION = "x11/libs"
inherit gpe
LICENSE = "LGPL"
DEPENDS = "esound"

do_stage() {
	install -d ${STAGING_INCDIR}/gpe
	install -m 0644 gpe/soundgen.h ${STAGING_INCDIR}/gpe/soundgen.h
	oe_libinstall -so libsoundgen ${STAGING_LIBDIR}
}

do_install_append() {
	oe_runmake DESTDIR="${D}" PREFIX="${prefix}" install-devel
}

SRC_URI[md5sum] = "5a36bc38b8b70a0951fb3acc479503f5"
SRC_URI[sha256sum] = "d74ed600fab1bf5bab86a4815a5170157607317030bd9316e587486e29e815f8"
