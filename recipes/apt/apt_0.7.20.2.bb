DEPENDS = "curl db"
RDEPENDS_${PN} = "dpkg"

require apt.inc

SRC_URI += "file://no-doxygen.patch \
            file://no-ko-translation.patch \
            file://fix-gcc-4.4-compile.patch \
            file://use-host.patch "
PR = "r3"

require apt-package.inc

FILES_${PN} += "${bindir}/apt-key"

do_stage() {
	install -d ${STAGING_LIBDIR} ${STAGING_INCDIR}/apt-pkg
	eval `cat environment.mak | grep ^GLIBC_VER | sed -e's, = ,=,'`
	oe_libinstall -so -C bin libapt-pkg$GLIBC_VER-6 ${STAGING_LIBDIR}/
	ln -sf libapt-pkg$GLIBC_VER-6.so ${STAGING_LIBDIR}/libapt-pkg.so
	oe_libinstall -so -C bin libapt-inst$GLIBC_VER-6 ${STAGING_LIBDIR}/
	ln -sf libapt-inst$GLIBC_VER-6.so ${STAGING_LIBDIR}/libapt-inst.so

	install -m 0644 include/apt-pkg/*.h ${STAGING_INCDIR}/apt-pkg/
}

SRC_URI[md5sum] = "e6ee1b594f6ed5fab5cb593ee46cfc21"
SRC_URI[sha256sum] = "4dc935a520c65705795ada5942b658f6e86b22eefc7032342267272bd6566b05"
