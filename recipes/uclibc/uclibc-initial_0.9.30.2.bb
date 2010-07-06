SECTION = "base"
require uclibc_${PV}.bb

DEPENDS = "linux-libc-headers ncurses-native virtual/${TARGET_PREFIX}gcc-initial"
PROVIDES = "virtual/${TARGET_PREFIX}libc-initial"
PACKAGES = ""

do_install() {
	# Install initial headers into the cross dir
	make PREFIX=${D} install_headers
	#ln -sf include ${CROSS_DIR}/${TARGET_SYS}/sys-include

	install -d ${D}${layout_libdir}/
	install -m 644 lib/crt[1in].o lib/libc.so ${D}${layout_libdir}/
}

do_compile () {
	make PREFIX=${D} \
		lib/crt1.o lib/crti.o lib/crtn.o
	${CC} -nostdlib -nostartfiles -shared -x c /dev/null \
		-o lib/libc.so
}
