SECTION = "base"
require e2fsprogs.inc
inherit native

EXTRA_OECONF = ""

PACKAGES = ""
DEPENDS = ""

do_configure() {
        oe_runconf
}

do_stage () {
	autotools_stage_all
	install -d ${STAGING_BINDIR_NATIVE}/
	for b in ${e2miscbins}; do
		install -m 0755 misc/$b ${STAGING_BINDIR_NATIVE}/ || die "failed to install $b"
	done
}
