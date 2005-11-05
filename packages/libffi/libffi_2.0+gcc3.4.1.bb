SECTION = "libs"
DESCRIPTION = "Foreign Function Interface library"
LICENSE = "libffi"
PRIORITY = "optional"
MAINTAINER = "Rene Wagner <rw@handhelds.org>"
PR = "r1"

inherit autotools gettext

PACKAGES = "${PN} ${PN}-dev"

FILES_${PN} = "${libdir}/libffi.so.*"

FILES_${PN}-dev = "${includedir}/ffi* \
		   ${libdir}/libffi.a \
		   ${libdir}/libffi.la \
		   ${libdir}/libffi.so"

GCC_VER = "${@bb.data.getVar('PV',d,1).split('gcc')[1]}"

SRC_URI = "${GNU_MIRROR}/gcc/gcc-${GCC_VER}/gcc-${GCC_VER}.tar.bz2 \
	   file://soname.patch;patch=1"

MIRRORS_prepend () {
${GNU_MIRROR}/gcc/	http://gcc.get-software.com/releases/
${GNU_MIRROR}/gcc/	http://mirrors.rcn.net/pub/sourceware/gcc/releases/
}

S = "${WORKDIR}/gcc-${GCC_VER}/libffi"
B = "${S}/build.${HOST_SYS}.${TARGET_SYS}"

EXTRA_OECONF = "--with-gnu-ld \
                --enable-shared \
                --enable-target-optspace \
                --enable-languages=c,c++,f77 \
                --enable-threads=posix \
                --enable-multilib \
                --enable-c99 \
                --enable-long-long \
                --enable-symvers=gnu \
                --program-prefix=${TARGET_PREFIX} \
                ${EXTRA_OECONF_PATHS}"

EXTRA_OECONF_PATHS = "--with-local-prefix=${prefix}/local \
                      --with-gxx-include-dir=${includedir}/c++/${PV}"

do_configure () {
	(cd ${S}/.. && gnu-configize) || die "failure running gnu-configize"
	oe_runconf
}

do_install_append() {
	# follow debian and move this to $includedir
	mv ${D}${libdir}/gcc/${TARGET_SYS}/${GCC_VER}/include/libffi/ffitarget.h ${D}${includedir}/
}

ffi_include = "ffi.h ffitarget.h"

do_stage () {
	oe_libinstall -so -C .libs libffi ${STAGING_LIBDIR}

	mkdir -p ${STAGING_INCDIR}/
	for i in ${ffi_include}; do
		install -m 0644 include/$i ${STAGING_INCDIR}/
	done
}
