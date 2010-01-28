DESCRIPTION = "gThumb is an image viewer and browser for the GNOME Desktop."
LICENSE = "GPL"

DEPENDS = "gtk+ libexif libgnome libgnomeui libgnomeprintui"

inherit gnome

SRC_URI += "file://pkg-config-hack.patch;patch=1"

PR = "r2"

FILES_${PN} += "${libdir}/*.so ${datadir}/gnome* ${datadir}/application-registry/*"
FILES_${PN}-dbg += "${libdir}/gthumb/modules/.debug"

do_configure_prepend() {
	sed -i "s|HACK_STAGING_DIR_HOST|${STAGING_DIR_HOST}|" ${S}/add-include-prefix
}
