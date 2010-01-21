DESCRIPTION = "Tool Command Language"
LICENSE = "tcl"
SECTION = "devel/tcltk"
HOMEPAGE = "http://tcl.sourceforge.net"
PR = "r4"

SRC_URI = "\
  ${SOURCEFORGE_MIRROR}/tcl/tcl${PV}-src.tar.gz \
  file://tcl-add-soname.patch;patch=1;pnum=2 \
#  file://fix-configure.patch;patch=1;pnum=2 \
"
S = "${WORKDIR}/tcl${PV}/unix"

inherit autotools

EXTRA_OECONF = "--enable-threads"

FILES_${PN} += "${prefix}/lib"

do_configure() {
	gnu-configize
	oe_runconf
}

do_compile_prepend() {
	echo > ../compat/fixstrtod.c
}

do_stage() {
	oe_libinstall -a libtclstub8.4 ${STAGING_LIBDIR}
	oe_libinstall -so libtcl8.4 ${STAGING_LIBDIR}
	sed -i "s+${WORKDIR}+${STAGING_INCDIR}+g" tclConfig.sh
	sed -i "s,-L${libdir},," tclConfig.sh
	install -d ${STAGING_BINDIR_CROSS}/
	install -m 0755 tclConfig.sh ${STAGING_BINDIR_CROSS}
	cd ..
	for dir in compat generic unix
	do
		install -d ${STAGING_INCDIR}/tcl${PV}/$dir
		install -m 0644 $dir/*.h ${STAGING_INCDIR}/tcl${PV}/$dir/
	done
	install -m 0644 generic/tcl.h ${STAGING_INCDIR}
	install -m 0644 generic/tclDecls.h ${STAGING_INCDIR}
	install -m 0644 generic/tclPlatDecls.h ${STAGING_INCDIR}
}

do_install() {
	autotools_do_install
	ln -sf ./tclsh8.4 ${D}${bindir}/tclsh
}

PACKAGES =+ "${PN}-lib"
FILES_${PN}-lib = "${libdir}/libtcl8.4.so.*"
FILES_${PN} += "${libdir}/tcl8.4"
FILES_${PN}-dev += "${libdir}/tclConfig.sh"
