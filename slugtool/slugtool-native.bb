SECTION = "unknown"
include slugtool.bb
inherit native

FILESPATH = "${@base_set_filespath([ '${FILE_DIRNAME}/slugtool-${PV}', '${FILE_DIRNAME}/slugtool', '${FILE_DIRNAME}/files', '${FILE_DIRNAME}' ], d)}"
PACKAGES = ""

do_stage () {
	install -m 0755 slugtool ${STAGING_BINDIR}/
}
