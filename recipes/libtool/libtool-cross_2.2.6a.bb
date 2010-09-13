require libtool_${PV}.bb
PR = "${INC_PR}.1"

SRC_URI += "\
  file://cross_compile.patch \
  file://prefix.patch \
"

DEPENDS += "libtool-native"

DOLT_PATCH = ""
DOLT_PATCH_arm = " file://add_dolt.patch"
DOLT_PATCH_i586 = " file://add_dolt.patch"

#SRC_URI_append_linux = "${DOLT_PATCH}"
#SRC_URI_append_linux-gnueabi = "${DOLT_PATCH}"

prefix = "${STAGING_DIR_NATIVE}${prefix_native}"
exec_prefix = "${STAGING_DIR_NATIVE}${prefix_native}"
bindir = "${STAGING_BINDIR_NATIVE}"

do_compile () {
	:
}

do_install () {
	install -d ${D}${bindir}/
	install -m 0755 ${HOST_SYS}-libtool ${D}${bindir}/${HOST_SYS}-libtool
	install -d ${D}${datadir}/libtool/
	install -d ${D}${datadir}/aclocal/
	install -c ${S}/libltdl/config/config.guess ${D}${datadir}/libtool/
	install -c ${S}/libltdl/config/config.sub ${D}${datadir}/libtool/
	install -c -m 0644 ${S}/libltdl/config/ltmain.sh ${D}${datadir}/libtool/
	install -c -m 0644 ${S}/libltdl/m4/libtool.m4 ${D}${datadir}/aclocal/
	install -c -m 0644 ${S}/libltdl/m4/ltdl.m4 ${D}${datadir}/aclocal/
	if [ -e ${WORKDIR}/dolt.m4 ] ; then
		install -c -m 0644 ${WORKDIR}/dolt.m4 ${D}${datadir}/aclocal/
	fi
}

SYSROOT_PREPROCESS_FUNCS += "libtoolcross_sysroot_preprocess"

libtoolcross_sysroot_preprocess () {
	install -d ${SYSROOT_DESTDIR}${STAGING_BINDIR_CROSS}/
	install -m 755 ${D}${bindir}/${HOST_SYS}-libtool ${SYSROOT_DESTDIR}${STAGING_BINDIR_CROSS}/${HOST_SYS}-libtool
}

PACKAGES = ""
NATIVE_INSTALL_WORKS = "1"
