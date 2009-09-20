SECTION = "base"
require uclibc_nptl.bb

DEPENDS = "linux-libc-headers ncurses-native virtual/${TARGET_PREFIX}gcc-initial"
PROVIDES = "virtual/${TARGET_PREFIX}libc-initial"
PACKAGES = ""

do_stage() {
	# Install initial headers into the cross dir
	make PREFIX= DEVEL_PREFIX=${UCLIBC_STAGE_PREFIX}/ \
		RUNTIME_PREFIX=${UCLIBC_STAGE_PREFIX}/ \
		install_headers V=1

	ln -sf include ${CROSS_DIR}/${TARGET_SYS}/sys-include

	# This conflicts with the c++ version of this header

	rm -f ${UCLIBC_STAGE_PREFIX}/include/bits/atomicity.h
	install -d ${UCLIBC_STAGE_PREFIX}/lib
	install -m 644 lib/crt[1in].o ${UCLIBC_STAGE_PREFIX}/lib
	install -m 644 lib/libc.so ${UCLIBC_STAGE_PREFIX}/lib

}

do_install() {
	:
}

do_compile () {
	make PREFIX= DEVEL_PREFIX=${UCLIBC_STAGE_PREFIX}/ \
		RUNTIME_PREFIX=${UCLIBC_STAGE_PREFIX}/ \
		lib/crt1.o lib/crti.o lib/crtn.o V=1
	${CC} -nostdlib -nostartfiles -shared -x c /dev/null \
		-o lib/libc.so
}
