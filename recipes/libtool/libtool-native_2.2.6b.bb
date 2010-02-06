require libtool_${PV}.bb
PR = "${INC_PR}.0"

SRC_URI += "\
  file://cross_compile.patch;patch=1 \
  file://prefix.patch;patch=1 \
"

inherit native

do_configure_prepend () {
	# Remove any existing libtool m4 since old stale versions would break
	# any upgrade
	rm -f ${STAGING_DATADIR}/aclocal/libtool.m4
	rm -f ${STAGING_DATADIR}/aclocal/lt*.m4
}

do_stage () {
	install -m 0755 ${HOST_SYS}-libtool ${STAGING_BINDIR}/${HOST_SYS}-libtool
	install -m 0755 libtoolize ${STAGING_BINDIR}/libtoolize
	oe_libinstall -a -so -C libltdl libltdl ${STAGING_LIBDIR}
	install -m 0644 libltdl/ltdl.h ${STAGING_INCDIR}/
	install -d ${STAGING_INCDIR}/libltdl/
	install -m 0644 libltdl/libltdl/*.h ${STAGING_INCDIR}/libltdl/
	install -d ${STAGING_DATADIR}/libtool/config/ ${STAGING_DATADIR}/aclocal/
	install -c ${S}/libltdl/config/config.guess ${STAGING_DATADIR}/libtool/
	install -c ${S}/libltdl/config/config.sub ${STAGING_DATADIR}/libtool/
	for i in config.guess config.sub compile depcomp general.m4sh getopt.m4sh install-sh ltmain.m4sh ltmain.sh mdate-sh missing mkstamp ; do \
		install -c -m 0644 ${S}/libltdl/config/$i ${STAGING_DATADIR}/libtool/config/
	done
	install -c -m 0644 ${S}/libltdl/m4/libtool.m4 ${STAGING_DATADIR}/aclocal/
	install -c -m 0644 ${S}/libltdl/m4/ltdl.m4 ${STAGING_DATADIR}/aclocal/
	install -c -m 0644 ${S}/libltdl/m4/ltoptions.m4 ${STAGING_DATADIR}/aclocal/
	install -c -m 0644 ${S}/libltdl/m4/ltversion.m4 ${STAGING_DATADIR}/aclocal/
	install -c -m 0644 ${S}/libltdl/m4/ltsugar.m4 ${STAGING_DATADIR}/aclocal/
	install -c -m 0644 ${S}/libltdl/m4/lt~obsolete.m4 ${STAGING_DATADIR}/aclocal/
	install -c -m 0644 ${S}/libltdl/m4/argz.m4 ${STAGING_DATADIR}/aclocal/

	install -d ${STAGING_DATADIR}/libtool/libltdl
	cp -pfPr  ${S}/libltdl/* ${STAGING_DATADIR}/libtool/libltdl/
}

do_install () {
	:
}
