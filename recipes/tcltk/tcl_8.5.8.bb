DESCRIPTION = "Tool Command Language"
HOMEPAGE = "http://tcl.sourceforge.net"
SECTION = "devel/tcltk"
LICENSE = "tcl"
PR = "r8"

SRC_URI = "\
  ${SOURCEFORGE_MIRROR}/tcl/tcl${PV}-src.tar.gz \
  file://confsearch.diff;striplevel=2 \
  file://manpages.diff;striplevel=2 \
  file://non-linux.diff;striplevel=2 \
  file://rpath.diff;striplevel=2 \
  file://tcllibrary.diff;striplevel=2 \
  file://tclpackagepath.diff;striplevel=2 \
  file://tclprivate.diff;striplevel=2 \
  file://mips-tclstrtod.patch;patchdir=..;striplevel=0 \
"
SRC_URI[md5sum] = "7f123e53b3daaaba2478d3af5a0752e3"
SRC_URI[sha256sum] = "6b090c1024038d0381e1ccfbd6d5c0f0e6ef205269ceb9d28bd7bd7ac5bbf4a7"

S = "${WORKDIR}/tcl${PV}/unix"
SYSROOT_PREPROCESS_FUNCS =+ "tcl_sysroot"

inherit autotools binconfig

EXTRA_OECONF = "--enable-threads"

do_configure_append() {
        echo > ../compat/fixstrtod.c
}

do_compile_prepend_pn-tcl () {
        sed -i -e 's:./tclsh :tclsh :g' Makefile
}

do_install() {
        autotools_do_install
        # Stage a few extra headers to make tk happy
        install -d ${D}${includedir}/tcl-${PV}/generic
        install -m 0644 ../generic/*.h ${D}${includedir}/tcl-${PV}/generic
        install -m 0644 *.h ${D}${includedir}/tcl-${PV}/generic
        install -d ${D}${includedir}/tcl-${PV}/unix
        install -m 0644 *Unix*.h ${D}${includedir}/tcl-${PV}/unix/
        rm -f ${D}${includedir}/regex.h
        ln -sf tclsh8.5 ${D}${bindir}/tclsh
}

PACKAGES =+ "${PN}-lib"

FILES_${PN}-lib = "${libdir}/libtcl8.5.so.*"
FILES_${PN} += "${libdir}/tcl*"
FILES_${PN}-dev += "${libdir}/tclConfig.sh"

BINCONFIG_GLOB = "*Config.sh"
BBCLASSEXTEND = "native"

tcl_sysroot() {
        sed -i 's:${includedir}/tcl-private:${STAGING_INCDIR}/tcl-${PV}:' tclConfig.sh
}

