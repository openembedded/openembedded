LICENSE = "GPL"
DESCRIPTION = "Cellphone tools and driver software"
SRC_URI = "http://www.gnokii.org/download/gnokii/gnokii-${PV}.tar.bz2 \
	file://configure.patch;patch=1"

DEPENDS = "libxpm gtk+"

inherit autotools pkgconfig

PARALLEL_MAKE = ""

PACKAGES += "libgnokii libgnokii-dev"

FILES_${PN} = "${bindir} ${sbindir}"
FILES_libgnokii-dev = "${includedir} ${libdir}/lib*.so ${libdir}/*.la \
                ${libdir}/*.a ${libdir}/*.o ${libdir}/pkgconfig \
	        /lib/*.a /lib/*.o ${datadir}/aclocal"
FILES_${PN}-dev = ""
FILES_libgnokii = "${libdir}/libgnokii.so.*"

do_stage() {
	autotools_stage_includes

	oe_libinstall -C common -so libgnokii ${STAGING_LIBDIR}
}

