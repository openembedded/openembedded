DESCRIPTION = "An advanced alternative, asynchronous resolver."
SECTION = "console/network"
LICENSE="GPL"

SRC_URI = "ftp://ftp.gnu.org/gnu/adns/adns-${PV}.tar.gz \
	   file://configure.patch;patch=1 \
	   file://fixparsedomainflags.patch;patch=1"

inherit autotools

acpaths = ""
do_configure_prepend () {
	if ! test -e acinclude.m4; then
		cp aclocal.m4 acinclude.m4
	fi
}

do_stage () {
	install -m 0644 ${S}/src/adns.h ${STAGING_INCDIR}/
	oe_libinstall -so -C dynamic libadns ${STAGING_LIBDIR}/
	oe_libinstall -a -C src libadns ${STAGING_LIBDIR}/
}

do_install () {
	install -d ${D}${prefix} ${D}${exec_prefix} \
		   ${D}${bindir} ${D}${libdir} ${D}${includedir}
	oe_runmake 'prefix=${D}${prefix}' 'exec_prefix=${D}${exec_prefix}' \
		   'bin_dir=${D}${bindir}' 'lib_dir=${D}${libdir}' \
		   'include_dir=${D}${includedir}' install
}
