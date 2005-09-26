DESCRIPTION = "Tool Command Language ToolKit Extension"
LICENSE = "tcl"
SECTION = "devel/tcltk"
HOMEPAGE = "http://tcl.sourceforge.net"
DEPENDS = "tcl x11"
RDEPENDS = "tcl"
PR = "r2"

SRC_URI = "${SOURCEFORGE_MIRROR}/tcl/tk${PV}-src.tar.gz \
           file://disable-xim.patch;patch=1;pnum=0 \
           file://tk-add-soname.patch;patch=1"
S = "${WORKDIR}/tk${PV}/unix"

inherit autotools

EXTRA_OECONF = "--enable-threads --with-tcl=${STAGING_BINDIR} \
		--x-includes=${STAGING_INCDIR} --x-libraries=${STAGING_LIBDIR}"

do_configure() {
	gnu-configize
	oe_runconf
}

do_stage() {
        oe_libinstall -a libtkstub8.4 ${STAGING_LIBDIR}
        oe_libinstall -so libtk8.4 ${STAGING_LIBDIR}
        install -m 0755 tkConfig.sh ${STAGING_BINDIR}
	cd ..
	#for dir in compat generic unix
	#do
	#	install -d ${STAGING_INCDIR}/tk${PV}/$dir
	#install -m 0644 $dir/*.h ${STAGING_INCDIR}/tk${PV}/$dir/
	#done
	install -m 0644 generic/tk.h ${STAGING_INCDIR}
	install -m 0644 generic/tkDecls.h ${STAGING_INCDIR}
	install -m 0644 generic/tkPlatDecls.h ${STAGING_INCDIR}

}

do_install() {
	autotools_do_install
	oe_libinstall -so libtk8.4 ${D}${libdir}
	ln -sf ./wish8.4 ${D}${bindir}/wish
}

FILES_${PN} += "${libdir}/tk8.4 ${libdir}/libtk8.4.so"
