require libtool_${PV}.bb

PR = "${INC_PR}.0"
PACKAGES = ""
SRC_URI_append = " file://libdir-la.patch;patch=1 \
                   file://prefix.patch;patch=1 \
                   file://tag.patch;patch=1 \
                   file://tag1.patch;patch=1 \
                   file://install-path-check.patch;patch=1"
S = "${WORKDIR}/libtool-${PV}"

prefix = "${STAGING_DIR_NATIVE}${prefix_native}"
exec_prefix = "${STAGING_DIR_NATIVE}${prefix_native}"
bindir = "${STAGING_BINDIR_NATIVE}"

do_compile () {
	:
}

do_stage () {
        install -m 0755 ${HOST_SYS}-libtool ${bindir}/${HOST_SYS}-libtool
        install -m 0644 libltdl/ltdl.h ${STAGING_INCDIR}/
        install -d ${STAGING_DIR_HOST}${target_datadir}/libtool ${STAGING_DIR_HOST}${target_datadir}/aclocal
        install -c config.guess ${STAGING_DIR_HOST}${target_datadir}/libtool/
        install -c config.sub ${STAGING_DIR_HOST}${target_datadir}/libtool/
        install -c -m 0644 ltmain.sh ${STAGING_DIR_HOST}${target_datadir}/libtool/
        install -c -m 0644 libtool.m4 ${STAGING_DIR_HOST}${target_datadir}/aclocal/
        install -c -m 0644 ltdl.m4 ${STAGING_DIR_HOST}${target_datadir}/aclocal/
}

do_install () {
	:
}
