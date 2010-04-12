# libxfce4util OE build file

DESCRIPTION = "Basic utility library for Xfce4"
SECTION = "x11/libs"
LICENSE = "GPL"
DEPENDS = "glib-2.0 xfce4-dev-tools "
PR = "r1"

inherit xfce46

EXTRA_OECONF += "--disable-dependency-tracking --disable-static --with-broken-putenv=yes"

MACROS="m4/X11.m4 m4/debug.m4 m4/depends.m4 m4/i18n.m4"

do_stage() {
	install -d ${STAGING_LIBDIR} ${STAGING_INCDIR}/libxfce4util
	# The line below expands to the list of headers that native makefile
	# would install.  Complain and/or fix if it's not portable enough
	for file in  $(eval $(make -n -C libxfce4util install|grep "^list='[^.]\\+.h"|cut -d\; -f1); echo $list); do 
		install -m 644 libxfce4util/$file ${STAGING_INCDIR}/libxfce4util
	done

	oe_libinstall -C libxfce4util -so libxfce4util ${STAGING_LIBDIR}

}

FILES_${PN}-dev += " ${datadir}/xfce4/m4"

SRC_URI[md5sum] = "eac51d58179cbcadc3f802450a8ec9cd"
SRC_URI[sha256sum] = "ceecdc7d3c89f547606c2d77a8a42ccf9975c809374fab84ff0833a08510c16b"
