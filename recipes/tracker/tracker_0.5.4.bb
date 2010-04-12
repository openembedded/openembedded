DESCRIPTION = "Tracker is a tool designed to extract information and metadata about your personal data so that it can be searched easily and quickly."
LICENSE = "GPLv2"
DEPENDS = "file gtk+ gstreamer gamin libgmime dbus poppler libexif libgsf libgnomecanvas"

PR = "r3"

SRC_URI = "http://www.gnome.org/~jamiemcc/tracker/tracker-${PV}.tar.gz \
           file://no-ioprio.patch;patch=1 \
           file://90tracker " 

inherit autotools pkgconfig

do_install_append() {
	cp -dPr ${D}${STAGING_DATADIR}/* ${D}${datadir}/ || true 
	install -d ${D}/${sysconfdir}/X11/Xsession.d/
	install -m 0755 ${WORKDIR}/90tracker  ${D}/${sysconfdir}/X11/Xsession.d/
}

do_stage() {
	autotools_stage_all
}

FILES_${PN} += "${datadir}/dbus-1/"
CONFFILES_${PN} += "${sysconfdir}/X11/Xsession.d/90tracker"


SRC_URI[md5sum] = "724208e1b2d235148499672b44181298"
SRC_URI[sha256sum] = "ad214a2692041f423d2150777c233b21cab2d108f849edc513192587ac63c9c2"
