DESCRIPTION = "Tool Command Language ToolKit Extension"
LICENSE = "tcl"
SECTION = "devel/tcltk"
HOMEPAGE = "http://tcl.sourceforge.net"
DEPENDS = "tcl virtual/libx11 libxt"
PR = "r0"

SRC_URI = "\
  ${SOURCEFORGE_MIRROR}/tcl/tk${PV}-src.tar.gz \
  file://disable-xim.patch;patch=1;pnum=0 \
  file://tk-add-soname.patch;patch=1;pnum=2 \
#  file://fix-configure.patch;patch=1;pnum=2 \
"
S = "${WORKDIR}/tk${PV}/unix"

inherit autotools

EXTRA_OECONF = "\
  --enable-threads \
  --with-tcl=${STAGING_BINDIR_CROSS} \
  --x-includes=${STAGING_INCDIR} \
  --x-libraries=${STAGING_LIBDIR} \
"

do_configure() {
	gnu-configize
	oe_runconf
}

do_stage() {
	oe_libinstall -a libtkstub8.4 ${STAGING_LIBDIR}
	oe_libinstall -so libtk8.4 ${STAGING_LIBDIR}
	sed -i "s+${WORKDIR}+${STAGING_INCDIR}+g" tkConfig.sh
	install -m 0755 tkConfig.sh ${STAGING_BINDIR_CROSS}
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
	mv libtk8.4.so libtk8.4.so.0
	oe_libinstall -so libtk8.4 ${D}${libdir}
	ln -sf ./wish8.4 ${D}${bindir}/wish
}

PACKAGES =+ "${PN}-lib"
FILES_${PN}-lib = "${libdir}/libtk8.4.so.*"
FILES_${PN} += "${libdir}"

SRC_URI[md5sum] = "9b998d0456d1b956eb9da610837a9c47"
SRC_URI[sha256sum] = "d056fe6c204ac31539616e1069522dd5864a580b64e521fe1a49bc895ca8699f"
