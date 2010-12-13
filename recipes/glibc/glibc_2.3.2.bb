require glibc.inc

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
RDEPENDS_${PN}-dev = "linux-libc-headers-dev"
RPROVIDES_${PN}-dev += "libc-dev virtual-libc-dev"

SRC_URI = "ftp://ftp.gnu.org/gnu/glibc/glibc-${PV}.tar.gz;name=archive \
	   ftp://ftp.gnu.org/pub/gnu/glibc/glibc-linuxthreads-2.3.2.tar.gz;name=linuxthreads \
	   file://noinfo.patch \
	   file://10_cvs.patch \
 	   file://arm-ioperm.patch;striplevel=0 \
	   file://glibc-i686-timing.patch \
 	   file://makeconfig.patch;striplevel=0 \
	   file://locale-es_AR.patch;striplevel=0 \
	   file://ldconfig.patch;striplevel=0 \
 	   file://ldd.patch;striplevel=0 \
 	   file://fhs-linux-paths.patch \
	   file://glibc22-nss-upgrade.patch \
	   file://glibc22-eo_EO.patch \
	   file://glibc22-m68k-compat.patch \
	   file://glibc22-m68k-fpic.patch \
	   file://glibc22-locales.patch;striplevel=0 \
	   file://sparc64-fixups.patch \
	   file://glibc22-ttyname-devfs.patch;striplevel=0 \
	   file://powerpc-sysconf.patch \
 	   file://arm-no-hwcap.patch;striplevel=0 \
	   file://locales-stuff.patch \
	   file://librt-mips.patch;striplevel=0 \
	   file://glibc23-ctype-compat.patch \
	   file://glibc23-hppa-Rminkernel.patch;striplevel=0 \
	   file://glibc23-function-compat.patch \
	   file://glibc23-errno.patch \
	   file://glibc23-asserth-decls.patch;striplevel=0 \
	   file://alpha-pic.patch;striplevel=0 \
	   file://glibc23-cmov.patch \
	   file://libgcc-compat-all.patch;striplevel=0 \
	   file://locales-supported.patch;striplevel=0 \
	   file://libgcc-compat-other.patch \
	   file://s390-tls.patch;striplevel=0 \
	   file://hurd-enable-ldconfig.patch \
	   file://30_glibc232-base.patch;striplevel=0 \
	   file://sparcv8-target.patch;striplevel=0 \
	   file://50_glibc232-arm-dwarf2-buildfix.patch;striplevel=0 \
	   file://50_glibc232-m68k-dwarf2-buildfix.patch \
	   file://arm-output-format.patch;striplevel=0 \
	   file://pthread-cleanup.patch;striplevel=0 \
	   file://glibc-${PV}-ldconfig-tls.patch \
	   file://glibc23-mips-msq.patch;striplevel=0 \
	   file://glibc23-libio-compat.patch \
	   file://80_glibc232-locales-nb_NO-fix.patch;striplevel=0 \
	   file://ldso-disable-hwcap.patch \
	   file://11_shlib-lds.patch \
	   file://glibc23-version-sanity.patch \
	   file://glibc23-sse-oldkernel.patch \
	   file://glibc23-sparc-pread64.patch \
	   file://glibc23-powerpc-sigcontext.patch \
	   file://hppa-syscall.patch;striplevel=0 \
	   file://glibc23-errno-hack.patch \
	   file://90_glibc232-statvfs.patch;striplevel=0 \
	   file://90_glibc232-timezones.patch;striplevel=0 \
 	   file://arm-memcpy.patch;striplevel=0 \
 	   file://arm-longlong.patch;striplevel=0 \
 	   file://arm-machine-gmon.patch;striplevel=0 \
           file://dyn-ldconfig.diff;striplevel=0 \
	   file://glibc232-gcc34-i386-fixup-attribute.patch \
	   file://glibc232-gcc34-no-unit-at-a-time.patch \
	   file://etc/ld.so.conf \
 	   file://generate-supported.mk"

SRC_URI_append_mtx-1 = " file://mips-abio32.patch \
                         file://allow-gcc.patch "
SRC_URI_append_mtx-2 = " file://mips-abio32.patch \
                         file://allow-gcc.patch "

S = "${WORKDIR}/glibc-${PV}"
B = "${WORKDIR}/build-${TARGET_SYS}"

EXTRA_OECONF = "--enable-kernel=${OLDEST_KERNEL} \
	        --without-cvs --disable-profile --disable-debug --without-gd \
		--enable-clocale=gnu \
	        --enable-add-ons=${GLIBC_ADDONS} \
		--with-headers=${STAGING_INCDIR} \
		${GLIBC_EXTRA_OECONF}"

EXTRA_OECONF += "${@get_libc_fpu_setting(bb, d)}"

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

require glibc-stage.inc

require glibc-package.inc

SRC_URI[archive.md5sum] = "2d72df1e1dd599dbdf3835b7c2951860"
SRC_URI[archive.sha256sum] = "dbf0deb003531cbd2493986718a1b34a113c914238a90de8b5b3218217257d82"
SRC_URI[linuxthreads.md5sum] = "993efdb74f75990f4a5cb6f7e69c40b4"
SRC_URI[linuxthreads.sha256sum] = "74ec1a4a28f854a27deeb9dfd0673f9d8f8fb948b3db0b45503c287c1ec9d15f"
