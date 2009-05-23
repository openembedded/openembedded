DESCRIPTION = "A Contact View for GTK+"
SECTION = "x11/libs"
DEPENDS += " glib-2.0 gtk+ eds-dbus"
# eds-dbus provides libebook
SHR_PV = "0.6.0"
PR = "r1"

inherit shr pkgconfig autotools

do_stage () {
        oe_libinstall -so libhito ${STAGING_LIBDIR}

	autotools_stage_includes
}
