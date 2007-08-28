FILESPATH =. "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/qemu-${PV}:"
# prefix = "${STAGING_DIR}/${BUILD_SYS}"
DEPENDS = "libsdl-native zlib-native"

require qemu-gcc3-check.inc

do_stage() {
	find . -name "qemu-*" -type f -perm -755 -exec install -m 0755 {} ${STAGING_BINDIR} \;
}
