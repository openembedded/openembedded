include swig_${PV}.bb
inherit native

do_stage() {
	oe_runmake install PREFIX=${STAGING_BINDIR}/..
}

