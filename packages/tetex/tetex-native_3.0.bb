include tetex_${PV}.bb
inherit native
DEPENDS = ""
PR = "r1"

PACKAGES=""
RRECOMMENDS_${PN}=""

do_configure() {
	oe_runconf
}

BINARIES = "texk/web2c/tangle \
            texk/web2c/ctangle \
            texk/web2c/otangle \
            texk/web2c/tie \
            utils/texinfo/info/makedoc \
            utils/texinfo/makeinfo/makeinfo"

do_stage() {
	for binary in ${BINARIES}
	do
		install -m 0755 $binary ${STAGING_BINDIR}
	done
}

do_install () {
	:
}

