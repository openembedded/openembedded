DESCRIPTION = "TinyMail is an attempt to create an E-mail framework for mobile devices"
SECTION = "x11/utils"
LICENSE = "LGPL"
DEPENDS = "gtk+ glib-2.0 gnome-vfs gconf libgnomeui"
PR = "r1"

EXTRA_OECONF=" --disable-gnome --with-platform=gpe --with-html-component=none"

SRC_URI = "http://tinymail.org/files/releases/pre-releases/v0.0.1/libtinymail-0.0.1.tar.bz2 \
	   file://no-iconv-detect.patch;patch=1 \
	   file://iconv-detect.h \
	   file://gtk-doc.m4 \
           file://gtk-doc.make"

inherit pkgconfig autotools

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



SRC_URI[md5sum] = "fea9081686f1157157fd2b0e68b9aeee"
SRC_URI[sha256sum] = "40bc855073422f893a919896a915e1f3d98f24a269c4c38be0072ad76feb5ca4"
