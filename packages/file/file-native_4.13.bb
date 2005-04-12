include file_${PV}.bb
inherit native

# avoid dependency loop
DEPENDS = ""

do_stage() {
	install -m 0755 src/file ${STAGING_BINDIR}/
	oe_libinstall -so -C src libmagic ${STAGING_LIBDIR}/
}

