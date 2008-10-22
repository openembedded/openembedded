DESCRIPTION = "GeoClue is a project that provide all kinds of geography information to an application"
HOMEPAGE = "http://live.gnome.org/GeoClue"

DEPENDS = "libgpsmgr libgpsbt  gtk+ gpsd libxml2 gconf-dbus libsoup dbus-glib"

PV = "0.0+git${SRCDATE}"
PR = "r1"
PE = "1"

inherit autotools pkgconfig

SRC_URI = "git://anongit.freedesktop.org/git/geoclue;protocol=git"

S = "${WORKDIR}/git"


LDFLAGS_append = " -lgthread-2.0 "

EXTRA_OECONF = " --enable-applet=no \
                 --enable-gpsd \
		 --enable-system-bus"

do_stage() {
	autotools_stage_all
}

do_install_append() {
	mkdir -p ${D}/usr/share/
	cp -pPr ${D}${STAGING_DATADIR}/* ${D}/usr/share
	rm -rf ${D}${STAGING_DATADIR}/
}

PACKAGES =+ "geoclue-applet"

FILES_geoclue-applet += " \
			${libdir}/bonobo/servers/* \
			${libdir}/gnome-panel/*"


FILES_${PN} += " \
		${libdir}/gnome-panel/* \
		${datadir}/dbus-1"
