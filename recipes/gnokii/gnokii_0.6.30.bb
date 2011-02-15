LICENSE = "GPLv2"
DESCRIPTION = "Cellphone tools and driver software"
SRC_URI = "http://www.gnokii.org/download/gnokii/gnokii-${PV}.tar.bz2 \
	"

DEPENDS = "libxpm gtk+"

inherit autotools pkgconfig

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


SRC_URI[md5sum] = "c90137d403febbc16712d64f0eb196de"
SRC_URI[sha256sum] = "337c75369901cc6665219e3b92e29949fc83823e8d63608979230d72fe2e1dd4"

