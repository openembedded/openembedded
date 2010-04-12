require glibc.inc

PR = "${INC_PR}.0"

GLIBC_ADDONS ?= "linuxthreads"

#           ${CROSSTOOL_PATCH_URL}glibc-2.3.5-cygwin.patch;patch=1

CROSSTOOL_PATCH_URL = "http://www.kegel.com/crosstool/crosstool-0.43/patches/glibc-2.3.6/"
SRC_URI = "ftp://ftp.gnu.org/pub/gnu/glibc/glibc-${PV}.tar.bz2;name=archive \
           ftp://ftp.gnu.org/pub/gnu/glibc/glibc-linuxthreads-${PV}.tar.bz2;name=linuxthreads \
           ${CROSSTOOL_PATCH_URL}glibc-2.3.5-sh-lowlevellock.patch;patch=1;name=crosspatch1 \
           ${CROSSTOOL_PATCH_URL}glibc-2.3.5-sh-memset.patch;patch=1;name=crosspatch2 \
           ${CROSSTOOL_PATCH_URL}glibc-2.3.6-allow-gcc-4.0-arm.patch;patch=1;name=crosspatch3 \
           ${CROSSTOOL_PATCH_URL}glibc-2.3.6-allow-gcc-4.0-elf.patch;patch=1;name=crosspatch4 \
           ${CROSSTOOL_PATCH_URL}glibc-2.3.6-configure-apple-as.patch;patch=1;name=crosspatch5 \
           ${CROSSTOOL_PATCH_URL}glibc-2.3.6-fix-pr631.patch;patch=1;name=crosspatch6 \
           ${CROSSTOOL_PATCH_URL}glibc-fp-byteorder.patch;patch=1;name=crosspatch7 \
           ${CROSSTOOL_PATCH_URL}glibc-mips-bootstrap-gcc-header-install.patch;patch=1;name=crosspatch8 \
           ${CROSSTOOL_PATCH_URL}arm-ctl_bus_isa.patch;patch=1;name=crosspatch9 \
           ${CROSSTOOL_PATCH_URL}make-install-lib-all.patch;patch=1;name=crosspatch10 \
           ${CROSSTOOL_PATCH_URL}maybe/glibc-2.3.6-allow-gcc-4.0-powerpc32.patch;patch=1;name=crosspatch11 \
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

SRC_URI[archive.md5sum] = "bfdce99f82d6dbcb64b7f11c05d6bc96"
SRC_URI[archive.sha256sum] = "e73ff5eddea95d09238b41d3c9c4d9ccddcf99fcc93d04956599c91c704f4a8e"
SRC_URI[linuxthreads.md5sum] = "d4eeda37472666a15cc1f407e9c987a9"
SRC_URI[linuxthreads.sha256sum] = "6c3bc4a247d1e5308fb14f81956802f09095d3683219859fcad5795aa3aea638"
SRC_URI[crosspatch1.md5sum] = "bb8da838930b8c6d06bafdbaad5dab1a"
SRC_URI[crosspatch1.sha256sum] = "43cb2a382f30d189f0cacb71cbfa0b153a45a49e5fd73330893d24731fca4eb6"
SRC_URI[crosspatch2.md5sum] = "1acb1e6c444ad45bb1390e7800dc4d7c"
SRC_URI[crosspatch2.sha256sum] = "b301918536819d00b824e134fbdeba3cf4048da060e70e75c8ea56fd92689ad9"
SRC_URI[crosspatch3.md5sum] = "709cb2283068145e557912b0907341a3"
SRC_URI[crosspatch3.sha256sum] = "9dba644da5db0ec5104698706854dcd4ae8d6a10e9419eb049e3d6fcad9d81fe"
SRC_URI[crosspatch4.md5sum] = "79ddbf5e5721442c5753344e4ecdda1c"
SRC_URI[crosspatch4.sha256sum] = "c1ab6923fa4388407cd1dcb2ed441f25c2b9fa18cacf6aad549c31fed3c08f8c"
SRC_URI[crosspatch5.md5sum] = "c4d41a712bf40dfb852e7bc18e1b6c52"
SRC_URI[crosspatch5.sha256sum] = "81611592bf30b4c1fa0c58d170d74c970dbc145127e16cb90d648663e2970cbf"
SRC_URI[crosspatch6.md5sum] = "336ce18c81fe8d7c17d2f7a0dbd62766"
SRC_URI[crosspatch6.sha256sum] = "9487f1d4c05b9c94d94f8bcb34541ef04b77cfc0526dbb0b344c67f2ab388c5b"
SRC_URI[crosspatch7.md5sum] = "c89aac92d100761a767b9d5619fe582f"
SRC_URI[crosspatch7.sha256sum] = "3033d84fd9a62d20a8cb0d42645d7cd5a28d2d108afcb4cc2d89db3dc1e328df"
SRC_URI[crosspatch8.md5sum] = "dc31c9e01df62cba9457af7e9b9c968e"
SRC_URI[crosspatch8.sha256sum] = "a69760ed0ea54b66c31d58cb32c7b23185a6b1d16f38dab8380ec4f2183b122d"
SRC_URI[crosspatch9.md5sum] = "88fa901c9a85633ab62365b0ee9df3b1"
SRC_URI[crosspatch9.sha256sum] = "6651eb15c9f6dabf21af4067b723cb29a87827f66570bfab74fdc00d80cab129"
SRC_URI[crosspatch10.md5sum] = "b94605c3b7ba90bc01648ca6e5cc1aaf"
SRC_URI[crosspatch10.sha256sum] = "16ff3ea972065925338da1a1f37322dc4d8774f6d34d2dde2ce85121c08c99e0"
SRC_URI[crosspatch11.md5sum] = "b89be3e1653ec6df317e30a10a0933b5"
SRC_URI[crosspatch11.sha256sum] = "0b5dd58a5240440ab6dcc0e2278bb99ebb20d0b558578652da59007bf27ae2fe"
