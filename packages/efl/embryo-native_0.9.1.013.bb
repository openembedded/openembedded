include embryo_${PV}.bb
inherit native

do_stage_append() {
	${HOST_SYS}-libtool --mode=install install -m 0755 src/bin/embryo_cc ${STAGING_BINDIR}
}
