DEFAULT_PREFERENCE = "-1"

require libtool_${PV}.bb

PR = "${INC_PR}.0"
SRC_URI_append = " file://libdir-la.patch \
                   file://prefix.patch \
                   file://tag.patch \
                   file://tag1.patch \
                   file://install-path-check.patch"
S = "${WORKDIR}/libtool-${PV}"

inherit native

do_stage () {
	install -m 0755 ${HOST_SYS}-libtool ${STAGING_BINDIR}/${HOST_SYS}-libtool
	install -m 0755 libtoolize ${STAGING_BINDIR}/libtoolize
	oe_libinstall -a -so -C libltdl libltdl ${STAGING_LIBDIR}
	install -m 0644 libltdl/ltdl.h ${STAGING_INCDIR}/
	install -d ${STAGING_DATADIR}/libtool ${STAGING_DATADIR}/aclocal
	install -c config.guess ${STAGING_DATADIR}/libtool/
	install -c config.sub ${STAGING_DATADIR}/libtool/
	install -c -m 0644 ltmain.sh ${STAGING_DATADIR}/libtool/
	install -c -m 0644 libtool.m4 ${STAGING_DATADIR}/aclocal/
	install -c -m 0644 ltdl.m4 ${STAGING_DATADIR}/aclocal/
}

do_install () {
	:
}

SRC_URI[md5sum] = "8e0ac9797b62ba4dcc8a2fb7936412b0"
SRC_URI[sha256sum] = "88e9ffaaade21c1ddaf6297723dd2fb4ca18ccaef0499a28b6e672f02c8ceb5d"
