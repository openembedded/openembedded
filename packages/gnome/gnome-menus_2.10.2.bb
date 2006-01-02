DEPENDS = "gnome-vfs libxml2 gconf popt gtk+"
LICENSE = "GPL"

MAINTAINER = "Koen Kooi <koen@handhelds.org>"

inherit gnome pkgconfig

FILES_${PN} += "${datadir}"
