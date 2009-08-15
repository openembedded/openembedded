require libtool.inc
PR = "${INC_PR}.0"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "${GNU_MIRROR}/libtool/libtool-${PV}.tar.gz"
S = "${WORKDIR}/${BPN}-2.2.6"

PACKAGES =+ "libltdl libltdl-dev libltdl-dbg"
FILES_${PN} += "${datadir}/aclocal*"
FILES_libltdl = "${libdir}/libltdl.so.*"
FILES_libltdl-dev = "${libdir}/libltdl.* ${includedir}/ltdl.h"
FILES_libltdl-dbg = "${libdir}/.debug/"

inherit autotools

EXTRA_AUTORECONF = "--exclude=libtoolize"

do_configure_prepend () {
	# Skip this for native build:
	if test -n "$CONFIG_SITE" ; then
	if test -z "$LIBTOOL_BB_DO_NOT_SET_PATHS" ; then
			export ac_cv_path_SED="${ac_cv_path_SED=/bin/sed}"
			export ac_cv_path_GREP="${ac_cv_path_GREP=/bin/grep}"
			export ac_cv_path_EGREP="${ac_cv_path_EGREP=/bin/grep -E}"
			export ac_cv_path_FGREP="${ac_cv_path_FGREP=/bin/grep -F}"
		fi
	fi
}

do_stage () {
       install -d ${STAGING_INCDIR}/libltdl
       install -m 0644 libltdl/ltdl.h ${STAGING_INCDIR}/
       install -m 0644 libltdl/libltdl/*.h ${STAGING_INCDIR}/libltdl/
       oe_libinstall -a -so -C libltdl libltdl ${STAGING_LIBDIR}
}
