require libtool_${PV}.bb

PR = "${INC_PR}.0"
SRC_URI_append = " file://rpath-control.patch;patch=1 \
                   file://libdir-la.patch;patch=1 \
                   file://libdir-la2.patch;patch=1 \
                   file://prefix.patch;patch=1 \
                   file://tag.patch;patch=1 \
                   file://install-path-check.patch;patch=1 \
                   file://nousrlib.patch;patch=1 \
                   file://add_sysroot_function.patch;patch=1 \
                   "

S = "${WORKDIR}/libtool-${PV}"

inherit sdk

do_configure_prepend () {
	rm -f ltmain.shT
	date=`/bin/sh ./mkstamp < ./ChangeLog` && \
        sed -e 's/@''PACKAGE@/libtool/' -e 's/@''VERSION@/1.5.10/' \
            -e "s%@""TIMESTAMP@%$date%" ./ltmain.in > ltmain.shT
	mv -f ltmain.shT ltmain.sh || \
	        (rm -f ltmain.sh && cp ltmain.shT ltmain.sh && rm -f ltmain.shT)
	cp ltmain.sh ./libltdl/
}

do_install () {
	install -d ${D}${bindir}/
	install -m 0755 ${HOST_SYS}-libtool ${D}${bindir}/
	install -m 0755 libtoolize ${D}${bindir}/

	install -d ${D}${libdir}/
	oe_libinstall -a -so -C libltdl libltdl ${D}${libdir}

	install -d ${D}${includedir}/
	install -m 0644 libltdl/ltdl.h ${D}${includedir}

	install -d ${D}${datadir}/libtool/
	install -c config.guess ${D}${datadir}/libtool/
	install -c config.sub ${D}${datadir}/libtool/
	install -c -m 0644 ltmain.sh ${D}${datadir}/libtool/

	install -d ${D}${datadir}/info/
	install -c -m 0644 doc/libtool.info ${D}${datadir}/info/

	install -d ${D}${datadir}/aclocal/
	install -c -m 0645 libtool.m4 ${D}${datadir}/aclocal/
	install -c -m 0644 ltdl.m4 ${D}${datadir}/aclocal/
}


SRC_URI[md5sum] = "e2093a85f6d48f1562c36920087502d6"
SRC_URI[sha256sum] = "6524e6d7a4adbda7fcda27ecd7b08bbeab88ad59d81bc6b166c617530f3dee1a"
