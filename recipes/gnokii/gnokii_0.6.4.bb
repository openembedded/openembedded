LICENSE = "GPL"
DESCRIPTION = "Cellphone tools and driver software"
SRC_URI = "http://www.gnokii.org/download/gnokii/0.6.x/gnokii-${PV}.tar.bz2 \
	file://configure.patch;patch=1"

DEPENDS = "libxpm"

inherit autotools pkgconfig

PACKAGES += "libgnokii libgnokii-dev"

FILES_${PN} = "${bindir} ${sbindir}"
FILES_libgnokii-dev = "${includedir} ${libdir}/lib*.so ${libdir}/*.la \
                ${libdir}/*.a ${libdir}/*.o ${libdir}/pkgconfig \
	        /lib/*.a /lib/*.o ${datadir}/aclocal"
FILES_${PN}-dev = ""
FILES_libgnokii = "${libdir}/libgnokii.so.*"

do_compile_prepend() {
	sed -i s:foo::g Makefile.global
}

do_stage() {
	autotools_stage_includes

	oe_libinstall -C common -so libgnokii ${STAGING_LIBDIR}
}


SRC_URI[md5sum] = "7f2a8cee97e62ebfa284363dc93b3178"
SRC_URI[sha256sum] = "9605f7aee1b8d58cac10dd514c2bdfa340089d85b149db828816d18ac3ebaff8"
