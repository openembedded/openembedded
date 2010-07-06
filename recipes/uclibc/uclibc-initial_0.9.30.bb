SECTION = "base"
require uclibc_${PV}.bb

DEPENDS = "linux-libc-headers ncurses-native virtual/${TARGET_PREFIX}gcc-initial"
PROVIDES = "virtual/${TARGET_PREFIX}libc-initial"
PACKAGES = ""

do_install() {
	# Install initial headers into the cross dir
	make PREFIX=${D} DEVEL_PREFIX=${prefix}/ RUNTIME_PREFIX=/ \
		install_headers

	#ln -sf include ${CROSS_DIR}/${TARGET_SYS}/sys-include

	install -d ${D}${libdir}/
	install -m 644 lib/crt[1in].o lib/libc.so ${D}${libdir}/
}

do_compile () {
	make PREFIX=${D} DEVEL_PREFIX=${prefix}/ RUNTIME_PREFIX=/ \
		lib/crt1.o lib/crti.o lib/crtn.o
	${CC} -nostdlib -nostartfiles -shared -x c /dev/null \
		-o lib/libc.so
}
