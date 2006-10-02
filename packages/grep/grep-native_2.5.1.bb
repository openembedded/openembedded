require grep_${PV}.bb
inherit native

S = "${WORKDIR}/grep-${PV}"

do_stage () {
	install -d ${STAGING_BINDIR}
	install -m 755 src/grep ${STAGING_BINDIR}
	install -m 755 src/egrep ${STAGING_BINDIR}
	install -m 755 src/fgrep ${STAGING_BINDIR}
}
