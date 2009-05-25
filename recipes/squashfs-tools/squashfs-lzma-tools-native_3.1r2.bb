require squashfs-lzma-tools_${PV}.bb

DEPENDS = "lzma-native"

inherit native

FILESPATHPKG =. "squashfs-tools-${PV}:squashfs-tools:"
PACKAGES = ""

do_stage () {
	install -m 0755 mksquashfs-lzma ${STAGING_BINDIR}/
}
