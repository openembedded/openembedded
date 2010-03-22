require expat.inc
PR = "r2"

SRC_URI += "file://autotools.patch;patch=1"
SRC_URI[src.md5sum] = "ee8b492592568805593f81f8cdf2a04c"
SRC_URI[src.sha256sum] = "847660b4df86e707c9150e33cd8c25bc5cd828f708c7418e765e3e983a2e5e93"

inherit lib_package

do_configure() {
	rm -f ${S}/conftools/libtool.m4
	touch ${S}/conftools/libtool.m4
	autotools_do_configure
}

do_stage() {
	install -m 0644 ${S}/lib/expat.h ${STAGING_INCDIR}/
	install -m 0644 ${S}/lib/expat_external.h ${STAGING_INCDIR}/
	oe_libinstall -so libexpat ${STAGING_LIBDIR}
}

do_install() {
	oe_runmake prefix="${D}${prefix}" \
		bindir="${D}${bindir}" \
		libdir="${D}${libdir}" \
		includedir="${D}${includedir}" \
		man1dir="${D}${mandir}/man1" \
		install
}
