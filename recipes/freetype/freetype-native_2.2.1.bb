require freetype_${PV}.bb
inherit native
DEPENDS = ""

EXTRA_OEMAKE=

DEFAULT_PREFERENCE = "-1"

do_configure() {
	(cd builds/unix && gnu-configize) || die "failure running gnu-configize"
	oe_runconf
}

do_stage() {
	autotools_stage_includes
	oe_libinstall -so -a -C objs libfreetype ${STAGING_LIBDIR}
}

do_install() {
	:
}

