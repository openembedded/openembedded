#
# For now, we will skip building of a gcc package if it is a uclibc one
# and our build is not a uclibc one, and we skip a glibc one if our build
# is a uclibc build.
#
# See the note in gcc/gcc_3.4.0.oe
#

PACKAGES = " \
	glibc-${ARCH_MULTILIB}-dbg glibc-${ARCH_MULTILIB} glibc-${ARCH_MULTILIB}-dev \
	libsegfault-${ARCH_MULTILIB} \
	glibc-${ARCH_MULTILIB}-extra-nss glibc-${ARCH_MULTILIB}-thread-db \
	glibc-${ARCH_MULTILIB}-pcprofile \
	"
PACKAGES_DYNAMIC = "glibc-${ARCH_MULTILIB}-gconv-*"

libc_baselibs = "${layout_base_libdir}/libc* ${layout_base_libdir}/libm* ${layout_base_libdir}/ld* ${layout_base_libdir}/libpthread* ${layout_base_libdir}/libresolv* ${layout_base_libdir}/librt* ${layout_base_libdir}/libutil* ${layout_base_libdir}/libnsl* ${layout_base_libdir}/libnss_files* ${layout_base_libdir}/libnss_compat* ${layout_base_libdir}/libnss_dns* ${layout_base_libdir}/libdl* ${layout_base_libdir}/libanl* ${layout_base_libdir}/libBrokenLocale*"

libc_baselibs_i686 += "/lib/ld-linux.so.2"

FILES_glibc-${ARCH_MULTILIB} = "${libc_baselibs} ${libdir}/pt_chown ${libdir}/getconf/* ${datadir}/zoneinfo"
FILES_libsegfault-${ARCH_MULTILIB} = "${layout_base_libdir}/libSegFault*"
FILES_glibc-${ARCH_MULTILIB}-extra-nss = "${layout_base_libdir}/libnss*"
FILES_glibc-${ARCH_MULTILIB}-dev_append = " ${libdir}/*.o ${includedir} ${libdir}/*.so ${libdir}/*.a"
FILES_glibc-${ARCH_MULTILIB}-pcprofile = "${layout_base_libdir}/libpcprofile.so"
FILES_glibc-${ARCH_MULTILIB}-thread-db = "${layout_base_libdir}/libthread_db*"
RPROVIDES_glibc-${ARCH_MULTILIB}-dev += "libc-${ARCH_MULTILIB}-dev"
FILES_glibc-${ARCH_MULTILIB}-gconv = "${libdir}/gconv/*"
FILES_glibc-${ARCH_MULTILIB}-dbg += " ${libdir}/*/.debug ${layout_base_libdir}/.debug"

DESCRIPTION_glibc-extra-nss = "glibc: nis, nisplus and hesiod search services"

EXTRA_OECONF += "${@get_glibc_fpu_setting(bb, d)}"

OVERRIDES_append = ":${TARGET_ARCH}-${TARGET_OS}"

do_install() {
	oe_runmake install_root=${D} install
	for r in ${rpcsvc}; do
		h=`echo $r|sed -e's,\.x$,.h,'`
		install -m 0644 ${S}/sunrpc/rpcsvc/$h ${D}/${includedir}/rpcsvc/
	done
	rm -f ${D}/etc/rpc
}

# Compatiblity with 32-bit ABI
do_install_append_x86_64 () {
	mkdir ${D}/lib
	ln -s /${layout_base_libdir}/ld-linux.so.2 ${D}/lib/ld-linux.so.2
}

python package_do_split_gconvs () {
	import os, re
	if (bb.data.getVar('PACKAGE_NO_GCONV', d, 1) == '1'):
		bb.note("package requested not splitting gconvs")
		return

	if not bb.data.getVar('PACKAGES', d, 1):
		return

	libdir = bb.data.getVar('layout_libdir', d, 1)
	if not libdir:
		bb.error("libdir not defined")
		return
	arch = bb.data.getVar('ARCH_MULTILIB', d, 1)
	if not arch:
		bb.error("Multilib packaging requested, but no ARCH_MULTILIB defined")
		return

	gconv_libdir = base_path_join(libdir, "gconv")

	do_split_packages(d, gconv_libdir, file_regex='^(.*)\.so$', output_pattern='glibc-'+arch+'-gconv-%s', description='gconv module for character set %s', extra_depends='glibc-gconv')
}

# We want to do this indirection so that we can safely 'return'
# from the called function even though we're prepending
python populate_packages_prepend () {
	if bb.data.getVar('DEBIAN_NAMES', d, 1):
		arch = bb.data.getVar('ARCH_MULTILIB', d, 1)
		if not arch:
			bb.error("Multilib packaging requested, but no ARCH_MULTILIB defined")
			return
		bb.data.setVar('PKG_glibc-'+arch, 'libc6-'+arch, d)
		bb.data.setVar('PKG_glibc-'+arch+'-dev', 'libc6-'+arch+'-dev', d)
	bb.build.exec_func('package_do_split_gconvs', d)
	bb.data.setVar('PACKAGES', bb.data.getVar('PACKAGES', d) + ' glibc-${ARCH_MULTILIB}-gconv', d)
}
