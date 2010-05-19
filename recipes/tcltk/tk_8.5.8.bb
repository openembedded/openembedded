DESCRIPTION = "Tool Command Language ToolKit Extension"
LICENSE = "tcl"
SECTION = "devel/tcltk"
HOMEPAGE = "http://tcl.sourceforge.net"
DEPENDS = "tcl virtual/libx11 libxt"

PR = "r1"

SRC_URI = "\
  ${SOURCEFORGE_MIRROR}/tcl/tk${PV}-src.tar.gz \
  file://confsearch.diff;patch=1;pnum=2 \
  file://manpages.diff;patch=1;pnum=2 \
  file://non-linux.diff;patch=1;pnum=2 \
  file://rpath.diff;patch=1;pnum=2 \
  file://tklibrary.diff;patch=1;pnum=2 \
  file://tkprivate.diff;patch=1;pnum=2 \
  file://fix-xft.diff;patch=1 \
"

SRC_URI[md5sum] = "13bf90602e16fc530e05196431021dc6"
SRC_URI[sha256sum] = "9737da5c30e631281062b6acbb4753840f9e95657c78e37657d9c520589ab2d4"

S = "${WORKDIR}/tk${PV}/unix"

inherit autotools

EXTRA_OECONF = "\
  --enable-threads \
  --with-tcl=${STAGING_BINDIR_CROSS} \
  --x-includes=${STAGING_INCDIR} \
  --x-libraries=${STAGING_LIBDIR} \
"

BINCONFIG_GLOB = "*Config.sh"

do_install() {
	autotools_do_install
	mv libtk8.5.so libtk8.5.so.0
	oe_libinstall -so libtk8.5 ${D}${libdir}
	ln -sf wish8.5 ${D}${bindir}/wish
}

PACKAGES =+ "${PN}-lib"
FILES_${PN}-lib = "${libdir}/libtk8.5.so.*"
FILES_${PN} += "${libdir}/tk*"

