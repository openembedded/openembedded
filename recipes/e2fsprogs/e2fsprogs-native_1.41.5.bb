SECTION = "base"
require e2fsprogs.inc
inherit native

SRC_URI += "file://mkinstalldirs.patch;patch=1"

EXTRA_OECONF = ""

FILESPATH = "${@base_set_filespath([ '${FILE_DIRNAME}/e2fsprogs-${PV}', '${FILE_DIRNAME}/e2fsprogs', '${FILE_DIRNAME}/files', '${FILE_DIRNAME}' ], d)}"
PACKAGES = ""
DEPENDS = ""

do_stage () {
	autotools_stage_all
	install -d ${STAGING_BINDIR_NATIVE}/
	for b in ${e2miscbins}; do
		install -m 0755 misc/$b ${STAGING_BINDIR_NATIVE}/ || die "failed to install $b"
	done
}
