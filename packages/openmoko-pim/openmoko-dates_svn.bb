DESCRIPTION = "The OpenMoko Dates Application"
SECTION = "openmoko/pim"
LICENSE = "GPL"
DEPENDS = "glib-2.0 gtk+ libglade eds-dbus openmoko-libs"
RDEPENDS = "libedata-cal"
PV = "0.1+svnr${SRCREV}"
PR = "r9"

inherit gnome autotools pkgconfig gtk-icon-cache

SRC_URI = "svn://svn.o-hand.com/repos/dates/branches/;module=openmoko;proto=http \
           file://openmoko-dates.png \
           file://openmoko-dates.desktop"

S = "${WORKDIR}/openmoko"

EXTRA_OECONF = "--enable-omoko"

do_install_append () {
    rm -rf ${D}${datadir}/icons
    rm -rf ${D}${datadir}/applications/dates.desktop
	install -d ${D}/${datadir}/pixmaps
	install -m 0644 ${WORKDIR}/openmoko-dates.png ${D}/${datadir}/pixmaps/
	install -m 0644 ${WORKDIR}/openmoko-dates.desktop ${D}${datadir}/applications/
}

FILES_${PN} += "${datadir}/pixmaps \
                ${datadir}/dates/"

