require glibc.inc

PR = "${INC_PR}.0"

GLIBC_ADDONS ?= "linuxthreads"

#           ${CROSSTOOL_PATCH_URL}glibc-2.3.5-cygwin.patch;patch=1

CROSSTOOL_PATCH_URL = "http://www.kegel.com/crosstool/crosstool-0.43/patches/glibc-2.3.6/"
SRC_URI = "ftp://ftp.gnu.org/pub/gnu/glibc/glibc-${PV}.tar.bz2 \
           ftp://ftp.gnu.org/pub/gnu/glibc/glibc-linuxthreads-${PV}.tar.bz2 \
           ${CROSSTOOL_PATCH_URL}glibc-2.3.5-sh-lowlevellock.patch;patch=1 \
           ${CROSSTOOL_PATCH_URL}glibc-2.3.5-sh-memset.patch;patch=1 \
           ${CROSSTOOL_PATCH_URL}glibc-2.3.6-allow-gcc-4.0-arm.patch;patch=1 \
           ${CROSSTOOL_PATCH_URL}glibc-2.3.6-allow-gcc-4.0-elf.patch;patch=1 \
           ${CROSSTOOL_PATCH_URL}glibc-2.3.6-configure-apple-as.patch;patch=1 \
           ${CROSSTOOL_PATCH_URL}glibc-2.3.6-fix-pr631.patch;patch=1 \
           ${CROSSTOOL_PATCH_URL}glibc-fp-byteorder.patch;patch=1 \
           ${CROSSTOOL_PATCH_URL}glibc-mips-bootstrap-gcc-header-install.patch;patch=1 \
           ${CROSSTOOL_PATCH_URL}arm-ctl_bus_isa.patch;patch=1 \
           ${CROSSTOOL_PATCH_URL}make-install-lib-all.patch;patch=1 \
           ${CROSSTOOL_PATCH_URL}maybe/glibc-2.3.6-allow-gcc-4.0-powerpc32.patch;patch=1 \
           file://glibc-2.3.6-bind-already-defined-on-powerpc.patch;patch=1 \
           file://glibc-2.3.6-allow-gcc-4.1-powerpc32-initfini.s.patch;patch=1 \
           file://glibc-2.3.6-linuxthreads-allow-gcc-4.1-powerpc32-initfini.s.patch;patch=1 \
           file://late-install-loop-break.patch;patch=1 \
           file://glibc-arm-socket-weakalias.patch;patch=1 \
           file://glibc-2.3.6-linuxthreads-pthread-raise.patch;patch=1 \
           file://glibc-cross_sunrpc.patch;patch=1 \
           file://etc/ld.so.conf \
	   file://generate-supported.mk"

S = "${WORKDIR}/glibc-${PV}"
B = "${WORKDIR}/build-${TARGET_SYS}"

RDEPENDS_${PN}-dev = "linux-libc-headers-dev"
RPROVIDES_${PN}-dev += "libc-dev virtual-libc-dev"

EXTRA_OECONF = "--enable-kernel=${OLDEST_KERNEL} \
	        --without-cvs --disable-profile --disable-debug --without-gd \
		--enable-clocale=gnu \
	        --enable-add-ons=${GLIBC_ADDONS} \
		--with-headers=${STAGING_INCDIR} \
		${GLIBC_EXTRA_OECONF}"

EXTRA_OECONF += "${@get_glibc_fpu_setting(bb, d)}"

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
	CPPFLAGS="" libc_cv_forced_unwind=yes libc_cv_c_cleanup=yes oe_runconf
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

do_stage_prepend() {
	( cd ${S} ; patch -p1 < ${WORKDIR}/late-install-loop-break.patch )
}

require glibc-stage.inc

require glibc-package.inc
