DESCRIPTION = "The Openmoko Dialer"
HOMEPAGE = "http://shr-project.org/"
LICENSE = "GPL"
SECTION = "x11/applications"
DEPENDS += " libmokoui2 libmokojournal2 pulseaudio dbus-glib libnotify libjana libframeworkd-glib libhito"
PV = "0.0.1+gitr${SRCPV}"
PR = "r2"

inherit pkgconfig autotools

SRC_URI = "git://git.shr-project.org/repo/shr.git;protocol=http;branch=master"
S = "${WORKDIR}/git/${PN}"

do_stage () {
        oe_libinstall -so libframeworkd-phonegui-gtk ${STAGING_LIBDIR}

        autotools_stage_includes
}
