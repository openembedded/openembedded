SECTION = "base"
require uclibc_${PV}.bb

FILESPATH = "${@base_set_filespath([ '${FILE_DIRNAME}/uclibc-${PV}', '${FILE_DIRNAME}/uclibc', '${FILE_DIRNAME}/files', '${FILE_DIRNAME}' ], d)}"

DEPENDS = "linux-libc-headers  ncurses-native virtual/${TARGET_PREFIX}gcc-initial"
PROVIDES = "virtual/${TARGET_PREFIX}libc-initial"
PACKAGES = ""

do_install() {
	# Install initial headers into the cross dir
	make V=1 CC="${CC}" PREFIX=${D} DEVEL_PREFIX=${prefix}/ RUNTIME_PREFIX=/ \
		install_headers #pregen install_dev
	#ln -sf include ${CROSS_DIR}/${TARGET_SYS}/sys-include

	# This conflicts with the c++ version of this header
	rm -f ${D}${includedir}/bits/atomicity.h
	install -d ${D}${libdir}/
	install -m 644 lib/crt[1in].o ${D}${libdir}/
	install -d ${D}${libdir}/
	install -m 644 lib/libc.so ${D}${libdir}/
}

do_compile () {
	make -j1 V=1 CC="${CC}" PREFIX=${D} DEVEL_PREFIX=${prefix}/ RUNTIME_PREFIX=/ \
		lib/crt1.o lib/crti.o lib/crtn.o
#               libc/sysdeps/linux/${TARGET_ARCH}/crt1.o \
#               libc/sysdeps/linux/${TARGET_ARCH}/crti.o \
#               libc/sysdeps/linux/${TARGET_ARCH}/crtn.o
	${CC} -nostdlib -nostartfiles -shared -x c /dev/null \
		-o lib/libc.so
}
