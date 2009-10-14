PR = "r1"

INHIBIT_DEFAULT_DEPS = "1"

INSANE_SKIP_libgcc = True
INSANE_SKIP_libstdc++ = True
INSANE_SKIP_nscd = True
INSANE_SKIP_glibc-utils = True

PROVIDES = "\
	virtual/${TARGET_PREFIX}gcc \
	virtual/${TARGET_PREFIX}g++ \
	virtual/${TARGET_PREFIX}gcc-initial \
	virtual/${TARGET_PREFIX}gcc-intermediate \
	virtual/${TARGET_PREFIX}binutils \
	virtual/${TARGET_PREFIX}libc-for-gcc \
	virtual/${TARGET_PREFIX}libc-initial \
	virtual/libc \
	virtual/libintl \
	virtual/libiconv \
	glibc-thread-db \
	linux-libc-headers \
"

#	virtual/linux-libc-headers \

RPROVIDES = "glibc-utils libsegfault glibc-thread-db"
RPROVIDES_glibc-dev += "libc-dev"

LEAD_SONAME = "libc.so.6"

PACKAGES = "\
	libgcc \
	libgcc-dev \
	libstdc++ \
	libstdc++-dev \
	linux-libc-headers \
	glibc-dbg \
	glibc \
	catchsegv \
	sln \
	nscd \
	ldd \
	localedef \
	glibc-utils \
	glibc-dev \
	libsegfault \
	glibc-extra-nss \
	glibc-thread-db \
	glibc-pcprofile \
"

FILES_glibc = "\
	${sysconfdir} \
	${libexecdir}/* \
	${datadir}/zoneinfo \
	/lib/libc* \
	/lib/libm* \
	/lib/ld* \
	/lib/libpthread* \
	/lib/libresolv* \
	/lib/librt* \
	/lib/libutil* \
	/lib/libnsl* \
	/lib/libnss_files* \
	/lib/libnss_compat* \
	/lib/libnss_dns* \
	/lib/libdl* \
	/lib/libanl* \
	/lib/libBrokenLocale* \
	/sbin/ldconfig \
"

FILES_glibc-dev = "\
	${includedir} \
	${libdir}/*.o \
	${bindir}/rpcgen \
	${libdir}/*.so \
	${libdir}/*.a \
"

FILES_glibc-dbg += " ${libdir}/gconv/.debug ${libexecdir}/*/.debug ${base_libdir}/.debug ${libdir}/.debug"
FILES_glibc-utils = "${bindir}/* ${sbindir}/*"
FILES_glibc-extra-nss = "/lib/libnss*"
FILES_glibc-gconv = "${libdir}/gconv/*"
FILES_glibc-pcprofile = "/lib/libpcprofile.so"
FILES_glibc-thread-db = "/lib/libthread_db*"

FILES_libgcc = "${base_libdir}/libgcc_s.so.1"
FILES_libgcc-dev = "${base_libdir}/libgcc_s.so"

FILES_libstdc++ = "${libdir}/libstdc++.so.*"
FILES_libstdc++-dev = "\
	${includedir}/c++/* \
	${libdir}/libstdc++.so \
	${libdir}/libstdc++.la \
	${libdir}/libstdc++.a \
	${libdir}/libsupc++.la \
	${libdir}/libsupc++.a \
"

FILES_linux-libc-headers = "\
	${includedir}/asm* \
	${includedir}/linux \
	${includedir}/mtd \
	${includedir}/rdma \
	${includedir}/scsi \
	${includedir}/sound \
	${includedir}/video \
"

FILES_libsegfault = "/lib/libSegFault*"
FILES_catchsegv = "${bindir}/catchsegv"
RDEPENDS_catchsegv = "libsegfault"

FILES_ldd = "${bindir}/ldd"
FILES_nscd = "${sbindir}/nscd*"
FILES_sln = "${base_sbindir}/sln"
FILES_localedef = "${bindir}/localedef"

DESCRIPTION_glibc-utils = "glibc: misc utilities like iconf, local, gencat, tzselect, rpcinfo, ..."
DESCRIPTION_glibc-extra-nss = "glibc: nis, nisplus and hesiod search services"
DESCRIPTION_ldd = "glibc: print shared library dependencies"
DESCRIPTION_nscd = "glibc: name service cache daemon for passwd, group, and hosts"
DESCRIPTION_sln = "glibc: create symbolic links between files"
DESCRIPTION_localedef = "glibc: compile locale definition files"

def csl_get_main_version(d):
	import subprocess,os,bb
	if os.path.exists(bb.data.getVar('TOOLCHAIN_PATH', d, 1)+'/bin/'+bb.data.getVar('TARGET_PREFIX', d, 1)+'gcc'):
		return subprocess.Popen([bb.data.getVar('TOOLCHAIN_PATH', d, 1)+'/bin/'+bb.data.getVar('TARGET_PREFIX', d, 1)+'gcc', '-v'], stderr=subprocess.PIPE).communicate()[1].splitlines()[-1].split()[-1].rstrip(')')

def csl_get_gcc_version(d):
	import subprocess,os,bb
	if os.path.exists(bb.data.getVar('TOOLCHAIN_PATH', d, 1)+'/bin/'+bb.data.getVar('TARGET_PREFIX', d, 1)+'gcc'):
		return subprocess.Popen([bb.data.getVar('TOOLCHAIN_PATH', d, 1)+'/bin/'+bb.data.getVar('TARGET_PREFIX', d, 1)+'gcc', '-v'], stderr=subprocess.PIPE).communicate()[1].splitlines()[-1].split()[2]

def csl_get_libc_version(d):
	import os,bb
	if os.path.exists(bb.data.getVar('TOOLCHAIN_SYSPATH', d, 1)+'/libc/lib/'):
		for file in os.listdir(bb.data.getVar('TOOLCHAIN_SYSPATH', d, 1)+'/libc/lib/'):
			if file.find('libc-') == 0:
				return file[5:-3]
		return None

def csl_get_kernel_version(d):
	import os,bb
	if os.path.exists(bb.data.getVar('TOOLCHAIN_SYSPATH', d, 1)+'/libc/'):
		f = open(bb.data.getVar('TOOLCHAIN_SYSPATH', d, 1)+'/libc/usr/include/linux/version.h', 'r')
		l = f.readlines();
		f.close();
		for s in l:
			if s.find('LINUX_VERSION_CODE') > 0:
				ver = int(s.split()[2])
				maj = ver / 65536
				ver = ver % 65536
				min = ver / 256
				ver = ver % 256
				return str(maj)+'.'+str(min)+'.'+str(ver)
		return None

CSL_VER_MAIN := "${@csl_get_main_version(d)}"
CSL_VER_GCC := "${@csl_get_gcc_version(d)}"
CSL_VER_LIBC := "${@csl_get_libc_version(d)}"
CSL_VER_KERNEL := "${@csl_get_kernel_version(d)}"

PV = ${CSL_VER_MAIN}
PV_libgcc = ${CSL_VER_GCC}
PV_libgcc-dev = ${CSL_VER_GCC}
PV_libstdc++ = ${CSL_VER_GCC}
PV_libstdc++-dev = ${CSL_VER_GCC}
PV_libc = ${CSL_VER_LIBC}
PV_glibc = ${CSL_VER_LIBC}
PV_glibc-dev = ${CSL_VER_LIBC}
PV_glibc-dbg = ${CSL_VER_LIBC}
PV_glibc-utils = ${CSL_VER_LIBC}
PV_glibc-extra-nss = ${CSL_VER_LIBC}
PV_glibc-thread-db = ${CSL_VER_LIBC}
PV_glibc-pcprofile = ${CSL_VER_LIBC}
PV_catchsegv = ${CSL_VER_LIBC}
PV_sln = ${CSL_VER_LIBC}
PV_nscd = ${CSL_VER_LIBC}
PV_ldd = ${CSL_VER_LIBC}
PV_localedef = ${CSL_VER_LIBC}
PV_libsegfault = ${CSL_VER_LIBC}
PV_linux-libc-headers = ${CSL_VER_KERNEL}

do_unpack() {
	:
}

do_install() {
	install -d ${D}${sysconfdir}
	install -d ${D}${bindir}
	install -d ${D}${sbindir}
	install -d ${D}${base_bindir}
	install -d ${D}${libdir}
	install -d ${D}${base_libdir}
	install -d ${D}${base_sbindir}
	install -d ${D}${datadir}

	cp -a ${TOOLCHAIN_PATH}/${TARGET_SYS}/libc/lib/* ${D}${base_libdir}
	cp -a ${TOOLCHAIN_PATH}/${TARGET_SYS}/libc/etc/* ${D}${sysconfdir}
	cp -a ${TOOLCHAIN_PATH}/${TARGET_SYS}/libc/sbin/* ${D}${base_sbindir}
	cp -a ${TOOLCHAIN_PATH}/${TARGET_SYS}/libc/usr/* ${D}/usr
	cp -a ${TOOLCHAIN_PATH}/${TARGET_SYS}/include/* ${D}/usr/include
	rm -rf ${D}${datadir}/locale
	rm -rf ${D}${datadir}/i18n
	rm -rf ${D}${libdir}/locale
	rm -rf ${D}${libdir}/gconv
	rm -rf ${D}${bindir}/gdbserver
	rm -rf ${D}${sysconfdir}/rpc
	rm -rf ${D}${datadir}/zoneinfo
}

do_stage() {
	install -d ${STAGING_INCDIR}
	install -d ${STAGING_LIBDIR}
	install -d ${STAGING_DIR_TARGET}${base_libdir}

	cp -a ${TOOLCHAIN_PATH}/${TARGET_SYS}/libc/usr/include/* ${STAGING_INCDIR}
	cp -a ${TOOLCHAIN_PATH}/${TARGET_SYS}/include/* ${STAGING_INCDIR}
	cp -a ${TOOLCHAIN_PATH}/${TARGET_SYS}/libc/usr/lib/* ${STAGING_LIBDIR}
	cp -a ${TOOLCHAIN_PATH}/${TARGET_SYS}/libc/lib/* ${STAGING_DIR_TARGET}${base_libdir}

	sed -e "s# /lib# ../../lib#g" -e "s# /usr/lib# .#g" ${STAGING_LIBDIR}/libc.so > ${STAGING_LIBDIR}/temp
	mv ${STAGING_LIBDIR}/temp ${STAGING_LIBDIR}/libc.so

	sed -e "s# /lib# ../../lib#" -e "s# /usr/lib# .#g" ${STAGING_LIBDIR}/libpthread.so > ${STAGING_LIBDIR}/temp
	mv ${STAGING_LIBDIR}/temp ${STAGING_LIBDIR}/libpthread.so
}

python populate_packages_prepend () {
	if bb.data.getVar('DEBIAN_NAMES', d, 1):
		bb.data.setVar('PKG_glibc', 'libc6', d)
		bb.data.setVar('PKG_glibc-dev', 'libc6-dev', d)
		bb.data.setVar('PKG_libgcc', 'libgcc1', d)
		bb.data.setVar('PKG_libgcc-dev', 'libgcc1-dev', d)
}
