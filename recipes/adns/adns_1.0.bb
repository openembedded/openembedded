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

SRC_URI[md5sum] = "af4411ee10875b96c0d61f903018f438"
SRC_URI[sha256sum] = "bed27a4ec5b71acc08333368e842a1248e83328018b582caf644985539967c5d"
