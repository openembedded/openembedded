SECTION = "base"
PN_BASE = "squashfs-tools"
include ${PN_BASE}_${PV}.bb
inherit native

FILESPATH = "${@base_set_filespath([ '${FILE_DIRNAME}/${PN_BASE}-${PV}', '${FILE_DIRNAME}/${PN_BASE}', '${FILE_DIRNAME}/files', '${FILE_DIRNAME}' ], d)}"
PACKAGES = ""

do_stage () {
	install -m 0755 mksquashfs ${STAGING_BINDIR}/
}
