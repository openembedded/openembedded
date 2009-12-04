require glibc.inc

DEFAULT_PREFERENCE_sh3 = "-99"

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/glibc-cvs"
PR = "${INC_PR}.0"

GLIBC_ADDONS ?= "linuxthreads"

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_i686 = "0"
DEFAULT_PREFERENCE_sh3 = "0"
DEFAULT_PREFERENCE_sh4 = "0"

#	   file://noinfo.patch;patch=1
#	   file://ldconfig.patch;patch=1;pnum=0
SRC_URI = "cvs://anoncvs@sources.redhat.com/cvs/glibc;module=libc;date=${@bb.data.getVar('PV', d, 1)[9:]} \
	   file://arm-ioperm.patch;patch=1;pnum=0 \
	   file://fhs-linux-paths.patch;patch=1 \
	   file://arm-no-hwcap.patch;patch=1;pnum=0 \
	   file://arm-memcpy.patch;patch=1;pnum=0 \
	   file://arm-longlong.patch;patch=1;pnum=0 \
	   file://arm-machine-gmon.patch;patch=1;pnum=0 \
	   file://trampoline.patch;patch=1;pnum=0 \
	   file://dl-cache-libcmp.patch;patch=1 \
	   \
           file://etc/ld.so.conf \
	   file://generate-supported.mk"

# seems to fail on tls platforms
SRC_URI_append_arm = " file://dyn-ldconfig-20041128.patch;patch=1"

SRC_URI_append_openmn = " file://ldsocache-varrun.patch;patch=1"

S = "${WORKDIR}/libc"
B = "${WORKDIR}/build-${TARGET_SYS}"

RDEPENDS_${PN}-dev = "linux-libc-headers-dev"
RPROVIDES_${PN}-dev += "libc-dev virtual-libc-dev"

EXTRA_OECONF = "--enable-kernel=${OLDEST_KERNEL} \
	        --without-cvs --disable-profile --disable-debug --without-gd \
		--enable-clocale=gnu \
	        --enable-add-ons=${GLIBC_ADDONS} \
		--with-headers=${STAGING_INCDIR} \
		--without-selinux \
		${GLIBC_EXTRA_OECONF}"

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
