DESCRIPTION = "Tracker is a tool designed to extract information and metadata about your personal data so that it can be searched easily and quickly."
LICENSE = "GPLv2"
DEPENDS = "file gtk+ gstreamer gamin gmime dbus poppler libexif libgsf libgnomecanvas gettext"
HOMEPAGE="http://www.tracker-project.org/"

PR = "r2"

inherit autotools pkgconfig gnome

SRC_URI = "http://ftp.gnome.org/pub/GNOME/sources/tracker/0.6/tracker-${PV}.tar.bz2 \
           file://munge-configure.ac-cross-compile.patch;patch=1 \
           file://05-tracker-ioprio-cross.patch;patch=1 \
           file://10-drop-bogus-version-info.patch;patch=1 \
           file://20-tracker-defaults.patch;patch=1 \
           file://30-gmime-2.4.patch;patch=1 \
           file://99-autoreconf.patch;patch=1 \           
           file://90tracker \
" 

EXTRA_OECONF += " tracker_cv_have_ioprio=yes"

LEAD_SONAME = "libtrackerclient.so.0"

do_install_append() {
   cp -dPr ${D}${STAGING_DATADIR}/* ${D}${datadir}/ || true 
   install -d ${D}/${sysconfdir}/X11/Xsession.d/
   install -m 0755 ${WORKDIR}/90tracker  ${D}/${sysconfdir}/X11/Xsession.d/
}

do_stage() {
   autotools_stage_all
}

FILES_${PN} += "${datadir}/dbus-1/"
FILES_${PN}-dbg += "${libdir}/*/*/.debug"

CONFFILES_${PN} += "${sysconfdir}/X11/Xsession.d/90tracker"

SRC_URI[md5sum] = "a4edc8aa830070bd3f1d80a7df07c80c"
SRC_URI[sha256sum] = "0fe42353117c62ccc9de3b3c9c11acf707a0702d30cd24b8d1cd1e2581dec339"
