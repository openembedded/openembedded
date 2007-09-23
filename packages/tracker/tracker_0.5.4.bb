DESCRIPTION = "Tracker is a tool designed to extract information and metadata about your personal data so that it can be searched easily and quickly."
LICENSE = "GPLv2"
DEPENDS = "file gtk+ gstreamer gamin libgmime dbus poppler libexif libgsf"

PR = "r1"

SRC_URI = "http://www.gnome.org/~jamiemcc/tracker/tracker-${PV}.tar.gz \
           file://no-ioprio.patch;patch=1" 

inherit autotools pkgconfig

do_install_append() {
	cp -dPr ${D}${STAGING_DATADIR}/* ${D}${datadir}/ 
}

FILES_${PN} += "${datadir}/dbus-1/"
