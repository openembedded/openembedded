require freetype_${PV}.bb
inherit pkgconfig native
DEPENDS = ""

EXTRA_OEMAKE=

do_configure() {
	(cd builds/unix && gnu-configize) || die "failure running gnu-configize"
	oe_runconf
}

do_stage() {
	autotools_stage_all
}

do_install() {
	:
}

