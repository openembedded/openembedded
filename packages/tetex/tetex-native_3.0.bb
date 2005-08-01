include tetex_${PV}.bb
inherit native

DEPENDS = ""

do_configure() {
	oe_runconf
}

BINARIES = "texk/web2c/tangle utils/texinfo/info/makedoc utils/texinfo/makeinfo/makeinfo"

do_stage() {
	for binary in ${BINARIES}
	do
		install -m 0755 texk/web2c/tangle ${STAGING_BINDIR}
	done
}

