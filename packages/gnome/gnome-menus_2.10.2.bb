DEPENDS = "gnome-vfs libxml2 gconf popt gtk+"
LICENSE = "GPL"

MAINTAINER = "Koen Kooi <koen@handhelds.org>"

inherit gnome pkgconfig

do_stage() {
autotools_stage_all
}

FILES_${PN} += "${datadir}"
