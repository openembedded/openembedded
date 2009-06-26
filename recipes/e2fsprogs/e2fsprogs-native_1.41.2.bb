SECTION = "base"
require e2fsprogs.inc
inherit native

PR = "r2"
DEFAULT_PREFERENCE = "-1"

EXTRA_OECONF = ""

PACKAGES = ""
DEPENDS = ""

do_stage () {
	oe_runmake install
	install -d ${STAGING_BINDIR_NATIVE}/
	for b in ${e2miscbins}; do
	install -m 0755 misc/$b ${STAGING_BINDIR_NATIVE}/ || die "failed to install $b"
	done
}
