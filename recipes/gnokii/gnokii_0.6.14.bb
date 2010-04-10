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


SRC_URI[md5sum] = "89449d613c7a7e765a0d8da57ef1bb88"
SRC_URI[sha256sum] = "cea63cddf79864d306198c7a84091af0b4685816b352ae253a3e2bfac5e67cb7"
