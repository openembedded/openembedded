require gdb-cross.inc
LICENSE = "GPLv3"

INC_PR = "r6"

inherit sdk

DEPENDS = "ncurses-sdk zlib-sdk flex-native"

do_stage() {
	:
}

do_install_append() {
	# these mo files from gdb-cross-sdk clash with files from binutils-cross-sdk
	# when building sdk archives. Drop them for now as a way to restore toolchains.
	rm ${D}/${datadir}/locale/*/LC_MESSAGES/{bfd,opcodes}.mo

	# we don't care about these infos, installed from binutils
	rm -f ${D}/${infodir}/{configure,standards,bfd}.info
    rm -f ${D}/${infodir}/dir

	# We use libiberty from binutils
	rm -f ${D}${prefix}/${TARGET_SYS}/lib/libiberty.a
	rm -f ${D}${libdir}/libiberty.a

}

