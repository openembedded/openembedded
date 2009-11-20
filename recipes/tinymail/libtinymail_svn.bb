DESCRIPTION = "TinyMail is an attempt to create an E-mail framework for mobile devices"
SECTION = "x11/utils"
LICENSE = "LGPL"
DEPENDS = "gtk+ glib-2.0 gnome-vfs gconf libgnomeui"
PV = "0.0.5+svnr${SRCPV}"
PR = "r4"

DEFAULT_PREFERENCE = "-1"

EXTRA_OECONF=" --disable-gnome --with-platform=gpe --with-html-component=none"

SRC_URI = "svn://svn.tinymail.org/svn/tinymail/;module=trunk;proto=http \
	   file://camel-lite-configure-hack.patch;patch=1;maxdate=20061113 \
	   file://no-iconv-detect.patch;patch=1;mindate=20061114 \
	   file://iconv-detect.h \
	   file://gtk-doc.m4 \
           file://gtk-doc.make"

inherit pkgconfig autotools
S = "${WORKDIR}/trunk"

do_configure_prepend() {
        mkdir -p m4
        install ${WORKDIR}/gtk-doc.m4 ./m4/
        install ${WORKDIR}/gtk-doc.make ./

	cp ${WORKDIR}/iconv-detect.h ${S}/libtinymail-camel/camel-lite/
}


PACKAGES =+ 	"lib${PN}-gpe lib${PN}-gpe-dev \
		 tinymail-camel-lite tinymail-camel-lite-dev tinymail-camel-lite-dbg \
		 libtinymailui-gtk libtinymailui libtinymail-camel lib${PN}"

FILES_lib${PN} =		  "${libdir}/lib*.so.*"
FILES_libtinymailui =		  "${libdir}/libtinymailui*.so.*"
FILES_libtinymailui-gtk	=	  "${libdir}/libtinymailui-gtk*.so.*"

FILES_libtinymail-camel = 	  "${libdir}/libtinymail-camel*.so.*"

FILES_lib${PN}-gpe = 		  "${libdir}/libtinymail-gpe*.so.*"
FILES_lib${PN}-gpe-dev = 	  "${libdir}/libtinymail-gpe*.so \
                                   ${libdir}/libtinymail-gpe*.a \
				   ${libdir}/libtinymail-gpe*.la"

LEAD_SONAME_tinymail-camel-lite = "libcamel-lite"
FILES_tinymail-camel-lite += 	  "${libdir}/libcamel*.so.* \
				   ${libdir}/camel-lite-1.2/camel-providers/*.so \
			      	   ${libdir}/camel-lite-1.2/camel-providers/*.urls "
FILES_tinymail-camel-lite-dev +=  "${libdir}/libcamel-lite*.so \
				   ${libdir}/libcamel-lite*.a \
				   ${libdir}/libcamel-lite*.la \
				   ${libdir}/camel-lite-1.2/camel-providers/*.la \
				   ${libdir}/camel-lite-1.2/camel-providers/*.a "
FILES_tinymail-camel-lite-dbg +=  "${libdir}/camel-lite-1.2/camel-providers/.debug"


