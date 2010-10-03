require libffi_${PV}.bb

inherit native

EXTRA_OECONF = "--with-gnu-ld \
                --enable-shared \
                --enable-target-optspace \
                --enable-languages=c,c++,f77 \
                --enable-threads=posix \
                --disable-multilib \
                --enable-c99 \
                --enable-long-long \
                --enable-symvers=gnu \
                --program-prefix=${TARGET_PREFIX} \
                ${EXTRA_OECONF_PATHS}"

ffi_include = "ffi.h ffitarget.h"

install_libffi_headers() {
	:
}

do_install () {
	install -d ${D}${libdir} ${D}${includedir}
	oe_libinstall -so -C .libs libffi ${D}${libdir}

	for i in ${ffi_include}; do
		install -m 0644 include/$i ${D}${includedir}/
	done
}

NATIVE_INSTALL_WORKS = "1"
