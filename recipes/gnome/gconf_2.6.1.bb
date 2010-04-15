DESCRIPTION = "GNOME configuration database system"
SECTION = "x11/gnome"
LICENSE = "LGPL"
DEPENDS = "orbit2 glib-2.0  libxml2"
ORBIT_IDL_SRC = "${STAGING_BINDIR_NATIVE}/orbit-idl-2"
PR = "r2"

S = "${WORKDIR}/GConf-${PV}"

SRC_URI = "http://ftp.gnome.org/pub/GNOME/sources/GConf/2.6/GConf-${PV}.tar.bz2 \
	   file://backends.patch;patch=1"

EXTRA_OECONF = "--disable-gtk-doc"

inherit autotools pkgconfig gettext

do_compile() {
	oe_runmake ORBIT_IDL="${ORBIT_IDL_SRC}"
}

do_stage() {
	install -d ${D}${datadir}/aclocal
	install -m 0644 gconf.m4 ${D}${datadir}/aclocal/gconf-2.m4
}

do_install() {
	oe_runmake ORBIT_IDL="${ORBIT_IDL_SRC}" DESTDIR="${D}" install
}

FILES_${PN} += " ${libdir}/GConf/*"
FILES_${PN}-dbg += "${libdir}/*/*/.debug"

SRC_URI[md5sum] = "194fab4e2e87c7ae3c7fea926fd281bc"
SRC_URI[sha256sum] = "31d894960e0d2eba8fa2746e4fde31983a1e49dc856a880adb59d5f251a690cf"
