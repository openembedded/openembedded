DESCRIPTION = "GNU C Library"
HOMEPAGE = "http://www.gnu.org/software/libc/libc.html"
LICENSE = "LGPL"
SECTION = "libs"
PRIORITY = "required"
PR = "r6"

DEFAULT_PREFERENCE_sh3 = "-99"

GLIBC_ADDONS ?= "linuxthreads"
GLIBC_EXTRA_OECONF ?= ""

#
# For now, we will skip building of a gcc package if it is a uclibc one
# and our build is not a uclibc one, and we skip a glibc one if our build
# is a uclibc build.
#
# See the note in gcc/gcc_3.4.0.oe
#

python __anonymous () {
    import bb, re
    uc_os = (re.match('.*uclibc$', bb.data.getVar('TARGET_OS', d, 1)) != None)
    if uc_os:
        raise bb.parse.SkipPackage("incompatible with target %s" %
                                   bb.data.getVar('TARGET_OS', d, 1))
}

PACKAGES = "glibc catchsegv sln nscd ldd localedef glibc-utils glibc-dev glibc-doc glibc-locale libsegfault glibc-extra-nss glibc-thread-db glibc-pcprofile"
PROVIDES += "virtual/libintl virtual/libiconv"

# nptl needs unwind support in gcc, which can't be built without glibc.
PROVIDES = "virtual/libc ${@['virtual/${TARGET_PREFIX}libc-for-gcc', '']['nptl' in '${GLIBC_ADDONS}']}"
DEPENDS = "${@['virtual/${TARGET_PREFIX}gcc-initial', 'virtual/${TARGET_PREFIX}gcc']['nptl' in '${GLIBC_ADDONS}']} linux-libc-headers"
INHIBIT_DEFAULT_DEPS = "1"

libc_baselibs = "/lib/libc* /lib/libm* /lib/ld* /lib/libpthread* /lib/libresolv* /lib/librt* /lib/libutil* /lib/libnsl* /lib/libnss_files* /lib/libnss_compat* /lib/libnss_dns* /lib/libdl* /lib/libanl* /lib/libBrokenLocale*"

FILES_${PN} = "${sysconfdir} ${libc_baselibs} /sbin/ldconfig ${libexecdir} ${datadir}/zoneinfo"
FILES_ldd = "${bindir}/ldd"
FILES_libsegfault = "/lib/libSegFault*"
FILES_glibc-extra-nss = "/lib/libnss*"
FILES_sln = "/sbin/sln"
FILES_glibc-dev_append = " ${libdir}/*.o ${bindir}/rpcgen"
FILES_nscd = "${sbindir}/nscd*"
FILES_glibc-utils = "${bindir} ${sbindir}"
FILES_glibc-gconv = "${libdir}/gconv"
FILES_catchsegv = "${bindir}/catchsegv"
DEPENDS_catchsegv = "libsegfault"
FILES_glibc-pcprofile = "/lib/libpcprofile.so"
FILES_glibc-thread-db = "/lib/libthread_db*"
FILES_localedef = "${bindir}/localedef"
RPROVIDES_glibc-dev += "libc-dev"

SRC_URI = "ftp://ftp.gnu.org/gnu/glibc/glibc-${PV}.tar.gz \
	   ftp://ftp.gnu.org/pub/gnu/glibc/glibc-linuxthreads-2.3.2.tar.gz \
	   file://noinfo.patch;patch=1 \
	   file://10_cvs.patch;patch=1 \
 	   file://arm-ioperm.patch;patch=1;pnum=0 \
	   file://glibc-i686-timing.patch;patch=1;pnum=1 \
 	   file://makeconfig.patch;patch=1;pnum=0 \
	   file://locale-es_AR.patch;patch=1;pnum=0 \
	   file://ldconfig.patch;patch=1;pnum=0 \
 	   file://ldd.patch;patch=1;pnum=0 \
 	   file://fhs-linux-paths.patch;patch=1;pnum=1 \
	   file://glibc22-nss-upgrade.patch;patch=1;pnum=1 \
	   file://glibc22-eo_EO.patch;patch=1;pnum=1 \
	   file://glibc22-m68k-compat.patch;patch=1;pnum=1 \
	   file://glibc22-m68k-fpic.patch;patch=1;pnum=1 \
	   file://glibc22-locales.patch;patch=1;pnum=0 \
	   file://sparc64-fixups.patch;patch=1;pnum=1 \
	   file://glibc22-ttyname-devfs.patch;patch=1;pnum=0 \
	   file://powerpc-sysconf.patch;patch=1;pnum=1 \
 	   file://arm-no-hwcap.patch;patch=1;pnum=0 \
	   file://locales-stuff.patch;patch=1;pnum=1 \
	   file://librt-mips.patch;patch=1;pnum=0 \
	   file://glibc23-ctype-compat.patch;patch=1;pnum=1 \
	   file://glibc23-hppa-Rminkernel.patch;patch=1;pnum=0 \
	   file://glibc23-function-compat.patch;patch=1;pnum=1 \
	   file://glibc23-errno.patch;patch=1;pnum=1 \
	   file://glibc23-asserth-decls.patch;patch=1;pnum=0 \
	   file://alpha-pic.patch;patch=1;pnum=0 \
	   file://glibc23-cmov.patch;patch=1;pnum=1 \
	   file://libgcc-compat-all.patch;patch=1;pnum=0 \
	   file://locales-supported.patch;patch=1;pnum=0 \
	   file://libgcc-compat-other.patch;patch=1;pnum=1 \
	   file://s390-tls.patch;patch=1;pnum=0 \
	   file://hurd-enable-ldconfig.patch;patch=1;pnum=1 \
	   file://30_glibc232-base.patch;patch=1;pnum=0 \
	   file://sparcv8-target.patch;patch=1;pnum=0 \
	   file://50_glibc232-arm-dwarf2-buildfix.patch;patch=1;pnum=0 \
	   file://50_glibc232-m68k-dwarf2-buildfix.patch;patch=1;pnum=1 \
	   file://arm-output-format.patch;patch=1;pnum=0 \
	   file://pthread-cleanup.patch;patch=1;pnum=0 \
	   file://glibc-${PV}-ldconfig-tls.patch;patch=1;pnum=1 \
	   file://glibc23-mips-msq.patch;patch=1;pnum=0 \
	   file://glibc23-libio-compat.patch;patch=1;pnum=1 \
	   file://80_glibc232-locales-nb_NO-fix.patch;patch=1;pnum=0 \
	   file://ldso-disable-hwcap.patch;patch=1;pnum=1 \
	   file://11_shlib-lds.patch;patch=1;pnum=1 \
	   file://glibc23-version-sanity.patch;patch=1;pnum=1 \
	   file://glibc23-sse-oldkernel.patch;patch=1;pnum=1 \
	   file://glibc23-sparc-pread64.patch;patch=1;pnum=1 \
	   file://glibc23-powerpc-sigcontext.patch;patch=1;pnum=1 \
	   file://hppa-syscall.patch;patch=1;pnum=0 \
	   file://glibc23-errno-hack.patch;patch=1;pnum=1 \
	   file://90_glibc232-statvfs.patch;patch=1;pnum=0 \
	   file://90_glibc232-timezones.patch;patch=1;pnum=0 \
 	   file://arm-memcpy.patch;patch=1;pnum=0 \
 	   file://arm-longlong.patch;patch=1;pnum=0 \
 	   file://arm-machine-gmon.patch;patch=1;pnum=0 \
           file://dyn-ldconfig.diff;patch=1;pnum=0 \
	   file://glibc232-gcc34-i386-fixup-attribute.patch;patch=1;pnum=1 \
	   file://glibc232-gcc34-no-unit-at-a-time.patch;patch=1;pnum=1 \
	   file://etc/ld.so.conf \
 	   file://generate-supported.mk"

S = "${WORKDIR}/glibc-${PV}"
B = "${WORKDIR}/build-${TARGET_SYS}"

inherit autotools

EXTRA_OECONF = "--enable-kernel=${OLDEST_KERNEL} \
	        --without-cvs --disable-profile --disable-debug --without-gd \
		--enable-clocale=gnu \
	        --enable-add-ons=${GLIBC_ADDONS} \
		--with-headers=${CROSS_DIR}/${TARGET_SYS}/include \
		${GLIBC_EXTRA_OECONF}"

EXTRA_OECONF += "${@get_glibc_fpu_setting(bb, d)}"

def get_glibc_fpu_setting(bb, d):
	if bb.data.getVar('TARGET_FPU', d, 1) in [ 'soft' ]:
		return "--without-fp"
	return ""

glibc_do_unpack () {
	mv "${WORKDIR}/linuxthreads" "${WORKDIR}/linuxthreads_db" "${S}/"
}

python do_unpack () {
	bb.build.exec_func('base_do_unpack', d)
	bb.build.exec_func('glibc_do_unpack', d)
}

do_configure () {
# override this function to avoid the autoconf/automake/aclocal/autoheader
# calls for now
# don't pass CPPFLAGS into configure, since it upsets the kernel-headers
# version check and doesn't really help with anything
        if [ -z "`which rpcgen`" ]; then
		echo "rpcgen not found.  Install glibc-devel."
		exit 1
	fi
	(cd ${S} && gnu-configize) || die "failure in running gnu-configize"
	CPPFLAGS="" oe_runconf
}

rpcsvc = "bootparam_prot.x nlm_prot.x rstat.x \
	  yppasswd.x klm_prot.x rex.x sm_inter.x mount.x \
	  rusers.x spray.x nfs_prot.x rquota.x key_prot.x"

do_compile () {
	# this really is arm specific
	touch ${S}/sysdeps/arm/framestate.c
	# -Wl,-rpath-link <staging>/lib in LDFLAGS can cause breakage if another glibc is in staging
	unset LDFLAGS
	base_do_compile
	(
		cd ${S}/sunrpc/rpcsvc
		for r in ${rpcsvc}; do
			h=`echo $r|sed -e's,\.x$,.h,'`
			rpcgen -h $r -o $h || oewarn "unable to generate header for $r"
		done
	)
}

do_stage() {
	rm -f ${STAGING_LIBDIR}/libc.so.6
	oe_runmake 'install_root=${STAGING_DIR}/${HOST_SYS}' \
		   'includedir=/include' 'libdir=/lib' 'slibdir=/lib' \
		   '${STAGING_LIBDIR}/libc.so.6' \
		   install-headers install-lib

	install -d ${STAGING_INCDIR}/gnu \
		   ${STAGING_INCDIR}/bits \
		   ${STAGING_INCDIR}/rpcsvc
	install -m 0644 ${S}/include/gnu/stubs.h ${STAGING_INCDIR}/gnu/
	install -m 0644 ${B}/bits/stdio_lim.h ${STAGING_INCDIR}/bits/
	install -m 0644 misc/syscall-list.h ${STAGING_INCDIR}/bits/syscall.h
	for r in ${rpcsvc}; do
		h=`echo $r|sed -e's,\.x$,.h,'`
		install -m 0644 ${S}/sunrpc/rpcsvc/$h ${STAGING_INCDIR}/rpcsvc/
	done
	for i in libc.a libc_pic.a libc_nonshared.a; do
		install -m 0644 ${B}/$i ${STAGING_LIBDIR}/ || die "failed to install $i"
	done
	echo 'GROUP ( libpthread.so.0 libpthread_nonshared.a )' > ${STAGING_LIBDIR}/libpthread.so
	echo 'GROUP ( libc.so.6 libc_nonshared.a )' > ${STAGING_LIBDIR}/libc.so

	rm -f ${CROSS_DIR}/${TARGET_SYS}/lib/libc.so.6
	oe_runmake 'install_root=${CROSS_DIR}/${TARGET_SYS}' \
		   'includedir=/include' 'libdir=/lib' 'slibdir=/lib' \
		   '${CROSS_DIR}/${TARGET_SYS}/lib/libc.so.6' \
		   install-headers install-lib

	install -d ${CROSS_DIR}/${TARGET_SYS}/include/gnu \
		   ${CROSS_DIR}/${TARGET_SYS}/include/bits \
		   ${CROSS_DIR}/${TARGET_SYS}/include/rpcsvc
	install -m 0644 ${S}/include/gnu/stubs.h ${CROSS_DIR}/${TARGET_SYS}/include/gnu/
	install -m 0644 ${B}/bits/stdio_lim.h ${CROSS_DIR}/${TARGET_SYS}/include/bits/
	install -m 0644 misc/syscall-list.h ${CROSS_DIR}/${TARGET_SYS}/include/bits/syscall.h
	for r in ${rpcsvc}; do
		h=`echo $r|sed -e's,\.x$,.h,'`
		install -m 0644 ${S}/sunrpc/rpcsvc/$h ${CROSS_DIR}/${TARGET_SYS}/include/rpcsvc/
	done

	for i in libc.a libc_pic.a libc_nonshared.a; do
		install -m 0644 ${B}/$i ${CROSS_DIR}/${TARGET_SYS}/lib/ || die "failed to install $i"
	done
	echo 'GROUP ( libpthread.so.0 libpthread_nonshared.a )' > ${CROSS_DIR}/${TARGET_SYS}/lib/libpthread.so
	echo 'GROUP ( libc.so.6 libc_nonshared.a )' > ${CROSS_DIR}/${TARGET_SYS}/lib/libc.so
}

include glibc-package.bbclass
