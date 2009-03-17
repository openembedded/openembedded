SECTION = "x11/base"
LICENSE = "BSD-X"
PR = "r1"
SRC_URI = "${SOURCEFORGE_MIRROR}/xprint/xprint_mozdev_org_source-2004-07-07-release_009_001.tar.gz \
	file://imake-staging.patch;patch=1"

S = "${WORKDIR}/xprint/src/xprint_main/xc"

FILES_${PN} += "${datadir}/Xprint ${prefix}/X11R6"

do_compile() {
	make -C config/imake -f Makefile.ini CC="${BUILD_CC}" BOOTSTRAPCFLAGS="${BUILD_CFLAGS}" clean imake
	make CC="${BUILD_CC}" xmakefile
	make Makefiles
	make clean
	#make depend
	make includes
	for l in xtrans X11 Xau Xdmcp font lbxutil zlib; do make -C lib/$l CC="${CC}" LD="${LD}"; done
	make -C programs/Xserver/Xprint/ps CC="${CC}" LD="${LD}" CC_STAGING="-I${STAGING_INCDIR}"
	make -C programs/Xserver Xprt CC="${CC}" LD="${LD}" CC_STAGING="-I${STAGING_INCDIR}"
}

do_install() {
	make -C programs/Xserver DESTDIR="${D}" install
	install -d ${D}${bindir}/
	mv ${D}/usr/X11R6/bin/* ${D}${bindir}/
	rmdir ${D}/usr/X11R6/bin/
}

