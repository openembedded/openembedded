require libtool_${PV}.bb

PR = "${INC_PR}.0"
SRC_URI_append = " file://libdir-la.patch;patch=1 \
                   file://libdir-la2.patch;patch=1 \
                   file://prefix.patch;patch=1 \
                   file://tag.patch;patch=1 \
                   file://install-path-check.patch;patch=1 \
		   file://nousrlib.patch;patch=1"

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

SRC_URI[md5sum] = "e2093a85f6d48f1562c36920087502d6"
SRC_URI[sha256sum] = "6524e6d7a4adbda7fcda27ecd7b08bbeab88ad59d81bc6b166c617530f3dee1a"
