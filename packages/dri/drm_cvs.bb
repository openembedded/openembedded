SECTION = "x11/base"
LICENSE = "MIT"
SRC_URI = "cvs://anoncvs@dri.freedesktop.org/cvs/dri;module=drm;method=pserver"

PV = "0.0+cvs${SRCDATE}"
PR = "r2"

S = "${WORKDIR}/drm"

do_compile() {
	oe_runmake -C libdrm
}

do_stage() {
	oe_libinstall -so -C libdrm libdrm ${STAGING_LIBDIR}
	ln -sf libdrm.so ${STAGING_LIBDIR}/libdrm.so.1
	for i in xf86drmCompat.h xf86drm.h; do
		install -m 0644 libdrm/$i ${STAGING_INCDIR}
	done
	for i in drm.h; do
		install -m 0644 shared-core/$i ${STAGING_INCDIR}
	done
}

do_install() {
	install -d ${D}${includedir}
	install -d ${D}/lib
	oe_runmake -C libdrm DESTDIR="${D}" install
	install -d ${D}${libdir}
	mv ${D}/lib/libdrm.so ${D}${libdir}/libdrm.so.1
	ln -sf libdrm.so.1 ${D}${libdir}/libdrm.so
	rmdir ${D}/lib
}

