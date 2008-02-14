LICENSE = "LGPL"
DESCRIPTION = "Nokia MCE headers"

inherit  pkgconfig 

do_compile() {
	# Nothing to compile in this recipe. These are just headers.
	:
}

do_install() {
	install -d ${D}${prefix}/include
	install -d ${D}${libdir}/pkgconfig

	cp -pPr include/* ${D}${prefix}/include
	cp *.pc ${D}${libdir}/pkgconfig/
}

do_stage() {
	cp -pPr include/* ${STAGING_INCDIR}/
}

