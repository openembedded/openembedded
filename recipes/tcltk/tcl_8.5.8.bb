DESCRIPTION = "Tool Command Language"
LICENSE = "tcl"
SECTION = "devel/tcltk"
HOMEPAGE = "http://tcl.sourceforge.net"

SRC_URI = "\
  ${SOURCEFORGE_MIRROR}/tcl/tcl${PV}-src.tar.gz \
  file://confsearch.diff;patch=1;pnum=2 \
  file://manpages.diff;patch=1;pnum=2 \
  file://non-linux.diff;patch=1;pnum=2 \
  file://rpath.diff;patch=1;pnum=2 \
  file://tcllibrary.diff;patch=1;pnum=2 \
  file://tclpackagepath.diff;patch=1;pnum=2 \
  file://tclprivate.diff;patch=1;pnum=2 \
"

SRC_URI[md5sum] = "7f123e53b3daaaba2478d3af5a0752e3"
SRC_URI[sha256sum] = "6b090c1024038d0381e1ccfbd6d5c0f0e6ef205269ceb9d28bd7bd7ac5bbf4a7"

S = "${WORKDIR}/tcl${PV}/unix"

inherit autotools binconfig

EXTRA_OECONF = "--enable-threads"

do_compile_prepend() {
	echo > ../compat/fixstrtod.c
	sed -i -e 's:./tclsh :tclsh :g' Makefile
}

BINCONFIG_GLOB = "*Config.sh"

do_install() {
	autotools_do_install
	# Stage a few extra headers to make tk happy
	install -m 0644 ../generic/*.h ${D}${includedir}
	install -m 0644 *.h ${D}${includedir}
	ln -sf tclsh8.5 ${D}${bindir}/tclsh
}

SYSROOT_PREPROCESS_FUNCS =+ "tcl_sysroot"

tcl_sysroot() {
	sed -i 's:/usr/include/tcl-private:${STAGING_INCDIR}:' tclConfig.sh
}

PACKAGES =+ "${PN}-lib"
FILES_${PN}-lib = "${libdir}/libtcl8.5.so.*"
FILES_${PN} += "${libdir}/tcl*"
FILES_${PN}-dev += "${libdir}/tclConfig.sh"

