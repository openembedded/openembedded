DESCRIPTION = "The Openmoko Dialer"
SECTION = "x11/applications"
DEPENDS += " libmokoui2 libmokojournal2 pulseaudio dbus-glib libnotify libjana libframeworkd-glib libhito"
SHR_PV = "0.0.1"
PR = "r1"

inherit shr pkgconfig autotools

do_stage () {
        oe_libinstall -so libframeworkd-phonegui-gtk ${STAGING_LIBDIR}

        autotools_stage_includes
}
