DEPENDS = "curl db"
RDEPENDS = "dpkg"

require apt.inc

SRC_URI += "file://no-ko-translation.patch;patch=1 \
            file://use-host.patch;patch=1 "
PR = "r3"

SRC_URI += "file://nodoc.patch;patch=1"

require apt-package.inc

FILES_${PN} += "${bindir}/apt-key"
apt-manpages += "doc/apt-key.8"

do_stage() {
	install -d ${STAGING_LIBDIR} ${STAGING_INCDIR}/apt-pkg
	eval `cat environment.mak | grep ^GLIBC_VER | sed -e's, = ,=,'`
	oe_libinstall -so -C bin libapt-pkg$GLIBC_VER-6 ${STAGING_LIBDIR}/
	ln -sf libapt-pkg$GLIBC_VER-6.so ${STAGING_LIBDIR}/libapt-pkg.so
	oe_libinstall -so -C bin libapt-inst$GLIBC_VER-6 ${STAGING_LIBDIR}/
	ln -sf libapt-inst$GLIBC_VER-6.so ${STAGING_LIBDIR}/libapt-inst.so

	install -m 0644 include/apt-pkg/*.h ${STAGING_INCDIR}/apt-pkg/
}

SRC_URI[md5sum] = "19efa18fb1ef20c58b9b44e94258b814"
SRC_URI[sha256sum] = "8fc06effaf8a4e4333308eedcdc6840f1c8056f2e924210f151dfc076bcd4045"
