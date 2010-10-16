DEPENDS = "mingw-w32api-headers"
PROVIDES = "virtual/${TARGET_PREFIX}libc-initial"

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
	cp -R ${S}/include/* ${STAGING_INCDIR}/
}
