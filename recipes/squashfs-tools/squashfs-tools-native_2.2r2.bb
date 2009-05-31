require squashfs-tools_${PV}.bb

DEPENDS = "lzma-native"

inherit native

PACKAGES = ""

do_stage () {
	install -m 0755 mksquashfs ${STAGING_BINDIR}/
	install -m 0755 mksquashfs-lzma ${STAGING_BINDIR}/
}
