require flex_${PV}.bb
inherit native
PR = "r3"

do_stage () {
	install -m 0755 flex ${STAGING_BINDIR}
	oe_libinstall -a libfl ${STAGING_LIBDIR}
	ln -sf ./flex ${STAGING_BINDIR}/flex++
	ln -sf ./flex ${STAGING_BINDIR}/lex
}
