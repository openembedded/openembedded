DESCRIPTION = "Dates is a calendar application."
SECTION = "openmoko/pim"
LICENSE = "GPL"
DEPENDS = "glib-2.0 gtk+ libglade eds-dbus openmoko-libs"
PV = "0.1+svn${SRCDATE}"
PR = "r2"

SRC_URI = "svn://svn.o-hand.com/repos/dates/branches/private;module=omoko;proto=https \
           file://compile-fix.patch;patch=1;maxdate=20070213 \   
           file://remove-bogus-include.patch;patch=1 \
           file://intltool-update.in"

S = "${WORKDIR}/omoko"

inherit autotools pkgconfig gtk-icon-cache

EXTRA_OECONF = "--enable-omoko"

do_configure_prepend() {
        install -m 644 ${WORKDIR}/intltool-update.in ${S}
}
	

do_install_append () {
	install -d ${D}/${datadir}/pixmaps
	install -m 0644 ${D}/${datadir}/icons/hicolor/48x48/apps/dates.png ${D}/${datadir}/pixmaps/
}

FILES_${PN} += "${datadir}/pixmaps/dates.png"

