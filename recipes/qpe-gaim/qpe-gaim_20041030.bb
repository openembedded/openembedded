DESCRIPTION = "A multi protocol instant messager application, Qt/Embedded based Palmtop Environments Edition"
SECTION = "opie/applications"
DEPENDS = "qpe-libgaim glib-2.0"
RDEPENDS = "libgaim-plugins glibc-gconv-iso8859-1"
LICENSE = "GPL"
HOMEPAGE = "http://qpe-gaim.sourceforge.net/"
APPNAME = "gaim"
APPTYPE = "binary"
LICENSE = "GPL"
APPDESKTOP = "${S}"
PR = "r2"

SRC_URI = "http://www.vanille.de/mirror/qpe-gaim_20041030.tar.bz2 \
           file://qpe-gaim.patch;patch=1 \
	   file://buzzer-notification.patch;patch=1;pnum=1 \
	   file://vit.patch;patch=1"
S = "${WORKDIR}/qpe-gaim"

inherit opie

EXTRA_QMAKEVARS_POST +="INCLUDEPATH-=${includedir}/glib-2.0 \
			INCLUDEPATH-=${libdir}/glib-2.0/include \
			INCLUDEPATH+=${STAGING_INCDIR}/glib-2.0 \
			LIBS-=-lopie LIBS+=-lopiecore2 LIBS+=-lopieui2"

do_configure_prepend() {
	ln -s ../libgaim/src libgaim
}

do_install() {
	for dir in 16x16 32x32 protocols status
	do
		install -d ${D}${palmtopdir}/pics/gaim/${dir}
		install -m 0644 data/images/${dir}/*.png ${D}${palmtopdir}/pics/gaim/${dir}/
	done
	install -m 0644 gaim.png ${D}${palmtopdir}/pics/
}

SRC_URI[md5sum] = "b61c7005301956e231feacff707c7b19"
SRC_URI[sha256sum] = "0b55004666e3353feef384c5795a05b5bf1a3b69a487aee5b8f8e9d66c133b86"
