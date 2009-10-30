inherit native

require squashfs-tools_${PV}.bb
PR = "${INC_PR}.1"

PACKAGES = ""

do_stage () {
	install -m 0755 mksquashfs ${STAGING_BINDIR}/
}
