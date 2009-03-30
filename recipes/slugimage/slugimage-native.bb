# slugimage - a program to construct NSLU2 image files
require slugimage.bb

# slugimage depends on perl, we assume that this is installed.
RDEPENDS = ""

inherit native

FILESPATH = "${@base_set_filespath([ '${FILE_DIRNAME}/slugimage-${PV}', '${FILE_DIRNAME}/slugimage', '${FILE_DIRNAME}/files', '${FILE_DIRNAME}' ], d)}"

do_stage () {
	install -m 0755 slugimage ${STAGING_BINDIR}/
}
