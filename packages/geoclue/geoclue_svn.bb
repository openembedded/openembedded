DESCRIPTION = "GeoClue is a project that provide all kinds of geography information to an application"
HOMEPAGE = "http://live.gnome.org/GeoClue"

DEPENDS = "gpsd libsoup dbus-glib"

PV = "0.0+svn${SRCDATE}"
PR = "r1"

inherit autotools pkgconfig

SRC_URI = "svn://svn.foinse-project.org/geoclue;module=trunk;proto=http"

S = "${WORKDIR}/trunk"


EXTRA_OECONF = "--disable-panel-applet"

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
