require recipes/gcc/gcc-common.inc
SECTION = "libs"
DESCRIPTION = "Foreign Function Interface library"
LICENSE = "libffi"
PRIORITY = "optional"

inherit autotools gettext

PR = "r1"

PACKAGES = "${PN}-dbg ${PN} ${PN}-dev"

FILES_${PN} = "${libdir}/libffi.so.*"

FILES_${PN}-dev = "${includedir}/${TARGET_SYS}/ffi* \
		   ${libdir}/libffi.a \
		   ${libdir}/libffi.la \
		   ${libdir}/libffi.so"

GCC_VER = "${@bb.data.getVar('PV',d,1).split('gcc')[1]}"

SRC_URI = "${GNU_MIRROR}/gcc/gcc-${GCC_VER}/gcc-${GCC_VER}.tar.bz2 \
	   "

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
                ${EXTRA_OECONF_FPU} \
                ${EXTRA_OECONF_PATHS}"

EXTRA_OECONF_PATHS = "--with-local-prefix=${prefix}/local \
                      --with-gxx-include-dir=${includedir}/c++/${PV}"

# Build uclibc compilers without cxa_atexit support
EXTRA_OECONF_append_linux               = " --enable-__cxa_atexit"
EXTRA_OECONF_append_linux-gnueabi       = " --enable-__cxa_atexit"
EXTRA_OECONF_append_linux-uclibc        = " --disable-__cxa_atexit"
EXTRA_OECONF_append_linux-uclibceabi    = " --disable-__cxa_atexit"
EXTRA_OECONF_FPU = "${@get_gcc_fpu_setting(bb, d)}"

#Somehow gcc doesn't set __SOFTFP__ when passing -mfloatabi=softp :(
TARGET_CC_ARCH_append_armv6 = " -D__SOFTFP__"
TARGET_CC_ARCH_append_armv7a = " -D__SOFTFP__"


do_configure () {
	(cd ${S}/.. && gnu-configize) || die "failure running gnu-configize"
	oe_runconf
}

do_install_append() {
	install_libffi_headers
}

# Separate function which can be disabled in the -native recipe.
install_libffi_headers() {
	# follow Debian and move this to $includedir/${TARGET_SYS}
	install -d ${D}${includedir}/${TARGET_SYS}
	mv ${D}${libdir}/gcc/${TARGET_SYS}/${GCC_VER}/include/ffitarget.h ${D}${includedir}/${TARGET_SYS}
	mv ${D}${libdir}/gcc/${TARGET_SYS}/${GCC_VER}/include/ffi.h ${D}${includedir}/${TARGET_SYS}
}

ffi_include = "ffi.h ffitarget.h"

do_stage () {
	oe_libinstall -so -C .libs libffi ${STAGING_LIBDIR}

	mkdir -p ${STAGING_INCDIR}/
	for i in ${ffi_include}; do
		install -m 0644 include/$i ${STAGING_INCDIR}/
	done
}

SRC_URI[md5sum] = "5dfac5da961ecd5f227c3175859a486d"
SRC_URI[sha256sum] = "bfbf487731ad5dca37efe480a837417de071bd67e685d5c1df6a290707575165"
