include embryo_${PV}.bb
inherit native

do_stage () {
	oe_libinstall -C src/lib libembryo ${STAGING_LIBDIR}/
	install -m 0644 ${S}/src/lib/Embryo.h ${STAGING_INCDIR}/
}
