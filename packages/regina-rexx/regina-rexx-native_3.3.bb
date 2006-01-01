include regina-rexx_${PV}.bb
inherit native
DEPENDS = ""

do_compile() {
	oe_runmake CEXTRA='-DREGINA_SHARE_DIRECTORY=\"$(sharedir)\"'
}

do_stage_append() {
	install -m 0644 ./msgcmp ${STAGING_BINDIR}/msgcmp-multi-input
}

