SECTION = "devel"
include binutils_cvs.bb
inherit sdk
DEPENDS += "flex-native bison-native"
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/binutils-cvs"
EXTRA_OECONF = "--with-sysroot=${CROSS_DIR}/${TARGET_SYS} \
		--program-prefix=${TARGET_PREFIX}"

do_stage() {
	:
}
