SECTION = "base"
require uclibc_${PV}.bb

DEPENDS = "linux-libc-headers virtual/${TARGET_PREFIX}gcc-initial"
PROVIDES = "virtual/${TARGET_PREFIX}libc-initial"
PACKAGES = ""

do_stage() {
	# Install initial headers into the cross dir
	make PREFIX= DEVEL_PREFIX=${UCLIBC_STAGE_PREFIX}/ \
		RUNTIME_PREFIX=${UCLIBC_STAGE_PREFIX}/ \
		pregen install_dev
	make PREFIX= DEVEL_PREFIX=${UCLIBC_STAGE_PREFIX}/ \
		RUNTIME_PREFIX=${UCLIBC_STAGE_PREFIX}/ \
                libc/sysdeps/linux/${TARGET_ARCH}/crt0.o \
                libc/sysdeps/linux/${TARGET_ARCH}/crti.o \
                libc/sysdeps/linux/${TARGET_ARCH}/crtn.o

	ln -sf include ${CROSS_DIR}/${TARGET_SYS}/sys-include

	# This conflicts with the c++ version of this header
	rm -f ${UCLIBC_STAGE_PREFIX}/include/bits/atomicity.h
	install -m 644 libc/sysdeps/linux/${TARGET_ARCH}/crt[0in].o ${UCLIBC_STAGE_PREFIX}/lib
	${CC} -nostdlib -nostartfiles -shared -x c /dev/null \
		-o ${UCLIBC_STAGE_PREFIX}/lib/libc.so

}

do_install() {
	:
}

do_compile () {
	:
}
