SECTION = "unknown"
require slugtool.bb
inherit native

PACKAGES = ""

do_stage () {
	install -m 0755 slugtool ${STAGING_BINDIR}/
}
