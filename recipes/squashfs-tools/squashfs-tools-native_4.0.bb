require squashfs-tools_4.0.bb

inherit native

DEPENDS = "zlib-native"

PACKAGES = ""

do_stage () {
	install -m 0755 mksquashfs ${STAGING_BINDIR}/
}

