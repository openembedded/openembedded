SECTION = "unknown"
include slugimage.bb
inherit native

FILESPATH = "${@base_set_filespath([ '${FILE_DIRNAME}/slugimage-${PV}', '${FILE_DIRNAME}/slugimage', '${FILE_DIRNAME}/files', '${FILE_DIRNAME}' ], d)}"
PACKAGES = ""

do_stage () {
	install -m 0755 slugimage/slugimage ${STAGING_BINDIR}/
}
