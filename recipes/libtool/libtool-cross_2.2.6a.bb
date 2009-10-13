require libtool_${PV}.bb
PR = "${INC_PR}.0"

SRC_URI += "\
  file://cross_compile.patch;patch=1 \
  file://prefix.patch;patch=1 \
"

DEPENDS += "libtool-native"

DOLT_PATCH = ""
DOLT_PATCH_arm = " file://add_dolt.patch;patch=1"
DOLT_PATCH_i586 = " file://add_dolt.patch;patch=1"

#SRC_URI_append_linux = "${DOLT_PATCH}"
#SRC_URI_append_linux-gnueabi = "${DOLT_PATCH}"

prefix = "${STAGING_DIR_NATIVE}${layout_prefix}"
exec_prefix = "${STAGING_DIR_NATIVE}${layout_exec_prefix}"
bindir = "${STAGING_BINDIR_NATIVE}"

do_compile () {
	:
}

do_stage () {
	install -m 0755 ${HOST_SYS}-libtool ${bindir}/${HOST_SYS}-libtool
	install -d ${STAGING_DATADIR}/libtool ${STAGING_DATADIR}/aclocal
	install -c ${S}/libltdl/config/config.guess ${STAGING_DATADIR}/libtool/
	install -c ${S}/libltdl/config/config.sub ${STAGING_DATADIR}/libtool/
	install -c -m 0644 ${S}/libltdl/config/ltmain.sh ${STAGING_DATADIR}/libtool/
	install -c -m 0644 ${S}/libltdl/m4/libtool.m4 ${STAGING_DATADIR}/aclocal/
	install -c -m 0644 ${S}/libltdl/m4/ltdl.m4 ${STAGING_DATADIR}/aclocal/
	if [ -e ${WORKDIR}/dolt.m4 ] ; then
		install -c -m 0644 ${WORKDIR}/dolt.m4 ${STAGING_DATADIR}/aclocal/
	fi
}


do_install () {
	:
}

PACKAGES = ""
