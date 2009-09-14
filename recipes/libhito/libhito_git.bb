DESCRIPTION = "A Contact View for GTK+"
SECTION = "x11/libs"
DEPENDS += " glib-2.0 gtk+ eds-dbus"
# eds-dbus provides libebook
PR = "r1"

SRC_URI = "git://git.shr-project.org/repo/libhito.git;protocol=git;branch=master"

inherit pkgconfig autotools

do_stage () {
        oe_libinstall -so libhito ${STAGING_LIBDIR}

	autotools_stage_includes
}
