include embryo_${PV}.bb
inherit native

do_stage_append() {
	install -d ${STAGING_DATADIR}/embryo/include
	install -m 0644 include/default.inc ${STAGING_DATADIR}/embryo/include
}