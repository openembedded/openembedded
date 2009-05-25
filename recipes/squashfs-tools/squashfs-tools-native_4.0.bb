require squashfs-tools_${PV}.bb
PR = "r0"

inherit native

PACKAGES = ""

do_stage () {
	install -m 0755 mksquashfs ${STAGING_BINDIR}/
}
