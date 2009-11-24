require glibc.inc

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/glibc-cvs"
PR = "${INC_PR}.0"

DEFAULT_PREFERENCE_sh3 = "-99"

GLIBC_ADDONS ?= "linuxthreads"

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

libc_baselibs = "/lib/libc* /lib/libm* /lib/ld* /lib/libpthread* /lib/libresolv* /lib/librt* /lib/libutil* /lib/libnsl* /lib/libnss_files* /lib/libnss_compat* /lib/libnss_dns* /lib/libdl* /lib/libanl* /lib/libBrokenLocale*"

FILES_${PN} = "${sysconfdir} ${libc_baselibs} /sbin/ldconfig ${libexecdir} ${datadir}/zoneinfo ${libdir}/locale"
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
RDEPENDS_${PN}-dev = "linux-libc-headers-dev"
RPROVIDES_${PN}-dev += "libc-dev virtual-libc-dev"

#	   file://noinfo.patch;patch=1 \
#	   file://ldconfig.patch;patch=1;pnum=0 \

SRC_URI = "${GNU_MIRROR}/glibc/glibc-${PV}.tar.gz \
	   ${GNU_MIRROR}/glibc/glibc-linuxthreads-${PV}.tar.gz \
	   file://alpha-build-failure.patch;patch=1 \
	   file://arm-asm-clobber.patch;patch=1 \
	   file://arm-ctl_bus_isa.patch;patch=1 \
	   file://cris-libc-symbols.patch;patch=1 \
	   file://cris-stack-direction.patch;patch=1 \
	   file://dl-machine-alpha.patch;patch=1 \
	   file://dl-machine-arm.patch;patch=1 \
	   file://dl-machine-m68k.patch;patch=1 \
	   file://dl-machine-mips.patch;patch=1 \
	   file://dl-machine-sh.patch;patch=1 \
	   file://dl-machine-sparc.patch;patch=1 \
	   file://errlist-1.9.patch;patch=1 \
	   file://errlist-arm.patch;patch=1 \
	   file://glibc-2.2.5-allow-gcc-3.4-fixup.patch;patch=1 \
	   file://glibc-2.2.5-allow-gcc-3.4-grp.patch;patch=1 \
	   file://glibc-2.2.5-allow-gcc-4.x-configure.patch;patch=1 \
	   file://glibc-2.2.5-alpha-pwrite64.patch;patch=1 \
	   file://glibc-2.2.5-arm-pwrite64.patch;patch=1 \
	   file://glibc-2.2.5-crosstest.patch;patch=1 \
	   file://glibc-2.2.5-crossyes.patch;patch=1 \
	   file://glibc-2.2.5-cygwin.patch;patch=1 \
	   file://glibc-2.2.5-hhl-powerpc-fpu.patch;patch=1 \
	   file://glibc-2.2.5-mips-build-gmon.patch;patch=1 \
	   file://glibc-2.2.5-mips-clone-local-label.patch;patch=1 \
	   file://glibc-2.2.5-ppc405erratum77.patch;patch=1 \
	   file://glibc-drow-sh.patch;patch=1 \
	   file://glibc-test-lowram.patch;patch=1 \
	   file://initfini-alpha.patch;patch=1 \
	   file://initfini-sh.patch;patch=1 \
	   file://longjmp-sparc.patch;patch=1 \
	   file://sh-setjmp-fix.patch;patch=1 \
	   file://sprintf-prototype.patch;patch=1 \
	   file://sscanf.patch;patch=1 \
	   file://unwind-arm.patch;patch=1 \
	   file://ldd.patch;patch=1;pnum=0 \
	   file://fhs-linux-paths.patch;patch=1;pnum=1 \
	   file://arm-no-hwcap.patch;patch=1;pnum=0 \
	   file://arm-memcpy.patch;patch=1;pnum=0 \
	   file://arm-longlong.patch;patch=1;pnum=0 \
	   file://arm-machine-gmon.patch;patch=1;pnum=0 \
	   file://glibc-2.2.5-allow-gcc-3.4-td.patch;patch=1 \
	   file://glibc-2.2.5-alpha-self-clobber.patch;patch=1 \
	   file://pt-initfini-alpha.patch;patch=1 \
	   file://pt-initfini-sh.patch;patch=1 \
	   file://linuxthreads-2.2.5-ppc405erratum77.patch;patch=1 \
	   file://threadparam.patch;patch=1 \
	   file://initfini-flags.patch;patch=1 \
	   file://pt-initfini-flags.patch;patch=1 \
	   file://glibc-2.3.2-allow-solaris.patch;patch=1 \
	   \
           file://etc/ld.so.conf \
	   file://generate-supported.mk"
#	   file://makeconfig.patch;patch=1;pnum=0


# seems to break on TLS platforms
# SRC_URI_append_arm = " file://dyn-ldconfig.patch;patch=1;pnum=0"

S = "${WORKDIR}/glibc-${PV}"
B = "${WORKDIR}/build-${TARGET_SYS}"

EXTRA_OECONF = "--enable-kernel=${OLDEST_KERNEL} \
	        --without-cvs --disable-profile --disable-debug --without-gd \
		--enable-clocale=gnu \
	        --enable-add-ons=${GLIBC_ADDONS} \
		--with-headers=${STAGING_INCDIR} \
		${GLIBC_EXTRA_OECONF}"

EXTRA_OECONF += "${@get_glibc_fpu_setting(bb, d)}"

glibc_do_unpack () {
	mv ${WORKDIR}/linuxthreads ${WORKDIR}/linuxthreads_db ${S}/
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
	rm -f ${STAGING_DIR_HOST}${layout_base_libdir}/libc.so.6
	oe_runmake 'install_root=${STAGING_DIR_HOST}' \
		   'includedir=${layout_includedir}' 'libdir=${layout_libdir}' 'slibdir=${layout_base_libdir}' \
		   '${STAGING_DIR_HOST}${layout_base_libdir}/libc.so.6' \
		   '${STAGING_INCDIR}/bits/errno.h' \
		   '${STAGING_INCDIR}/bits/libc-lock.h' \
		   '${STAGING_INCDIR}/gnu/stubs.h' \
		   install-headers install-lib

	install -d ${STAGING_INCDIR}/gnu \
		   ${STAGING_INCDIR}/bits \
		   ${STAGING_INCDIR}/sys \
		   ${STAGING_INCDIR}/rpcsvc
	install -m 0644 ${B}/bits/stdio_lim.h ${STAGING_INCDIR}/bits/
	install -m 0644 misc/syscall-list.h ${STAGING_INCDIR}/bits/syscall.h
	install -m 0644 ${S}/include/bits/xopen_lim.h ${STAGING_INCDIR}/bits/
	install -m 0644 ${B}/gnu/lib-names.h ${STAGING_INCDIR}/gnu/
	install -m 0644 ${S}/include/limits.h ${STAGING_INCDIR}/
	install -m 0644 ${S}/include/gnu/libc-version.h ${STAGING_INCDIR}/gnu/
	install -m 0644 ${S}/include/gnu-versions.h ${STAGING_INCDIR}/
	install -m 0644 ${S}/include/values.h ${STAGING_INCDIR}/
	install -m 0644 ${S}/include/errno.h ${STAGING_INCDIR}/
	install -m 0644 ${S}/include/sys/errno.h ${STAGING_INCDIR}/sys/
	install -m 0644 ${S}/include/features.h ${STAGING_INCDIR}/
	for r in ${rpcsvc}; do
		h=`echo $r|sed -e's,\.x$,.h,'`
		install -m 0644 ${S}/sunrpc/rpcsvc/$h ${STAGING_INCDIR}/rpcsvc/
	done
	for i in libc.a libc_pic.a libc_nonshared.a; do
		install -m 0644 ${B}/$i ${STAGING_DIR_HOST}/${layout_base_libdir}/ || die "failed to install $i"
	done
	echo 'GROUP ( libc.so.6 libc_nonshared.a )' > ${STAGING_DIR_HOST}/${layout_base_libdir}/libc.so
}

require glibc-package.inc
