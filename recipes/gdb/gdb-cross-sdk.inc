require gdb-cross.inc
LICENSE = "GPLv3"

INC_PR = "r4"

inherit sdk

DEPENDS = "ncurses-sdk zlib-sdk flex-native"

do_stage() {
	:
}

do_install_append() {
	# these mo files from gdb-cross-sdk clash with files from binutils-cross-sdk
	# when building sdk archives. Drop them for now as a way to restore toolchains.
	rm ${D}/${datadir}/locale/*/LC_MESSAGES/{bfd,opcodes}.mo
}

