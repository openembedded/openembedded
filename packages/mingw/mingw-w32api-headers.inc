DEPENDS = ""
PROVIDES = "mingw-w32api-headers"

do_configure() {
	:
}

do_compile() {
	:
}

do_install() {
	:
}

do_stage() {
	mkdir -p ${STAGING_INCDIR}
	cp -r ${S}/include/* ${STAGING_INCDIR}/
}
