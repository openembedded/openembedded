DESCRIPTION = "QPDF2 is a Viewer for PDF documents. An unnecessary fork based on opie-qpdf."
PRIORITY = "optional"
SECTION = "opie/applications"
LICENSE = "GPL"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
NOTE = "This is so hacky you won't believe it until you look at the source..."
DEPENDS = "t1lib freetype"
APPNAME = "qpdf"
APPTYPE = "binary"
APPDESKTOP = "${S}/ipkg-render-freetype/opt/QtPalmtop/apps/Applications"
PR = "r2"

SRC_URI = "${SOURCEFORGE_MIRROR}/qpdf2/qpdf2_2.2.1_20040217b.tgz \
           file://hack-the-hack.patch;patch=1 \
           file://fix-sigsegv.patch;patch=1 \
	   file://fix_qtversion_check.patch;patch=1"
S = "${WORKDIR}/qpdf2_${PV}"

inherit opie

QMAKE_PROFILES = "qpdf_render-freetype.pro"
EXTRA_QMAKEVARS_POST = "TARGET=qpdf"
export OE_QMAKE_LINK="${CXX}"

do_configure_prepend() {
	find . -name "Makefile"|xargs rm -f
	find . -name "*.o"|xargs rm -f
	find . -name "*.a"|xargs rm -f
	find . -name "*.la"|xargs rm -f
}

do_install() {
	install -d ${D}${palmtopdir}/pics/qpdf
	install -m 0644 ipkg-render-freetype/opt/QtPalmtop/pics/qpdf/*.* ${D}${palmtopdir}/pics/qpdf/
}

