DESCRIPTION = "gThumb is an image viewer and browser for the GNOME Desktop."
LICENSE = "GPL"

DEPENDS = "gtk+ libexif libgnome libgnomeui libgnomeprintui"

inherit gnome

FILES_${PN} += "${datadir}/gnome* ${datadir}/application-registry/*"
FILES_${PN}-dbg += "${libdir}/gthumb/modules/.debug"



