SECTION = "x11/base"
DESCRIPTION = "Industrial theme engine for GTK"
MAINTAINER = "Phil Blundell <pb@handhelds.org>"
LICENSE = "GPL2"
DEPENDS = "gtk+"

SRC_URI = "${DEBIAN_MIRROR}/main/g/gtk-industrial-engine/gtk-industrial-engine_${PV}.tar.gz \
	file://no-gtk1.patch;patch=1"

PACKAGES += "gtk-theme-industrial"
FILES_${PN} = "${libdir}/gtk-2.0/*/engines/*.so"
FILES_${PN}-dev = "${libdir}/gtk-2.0/*/engines/*"
FILES_gtk-theme-industrial = "${datadir}/icons ${datadir}/themes"

inherit autotools

do_configure_prepend() {
	for i in `ls gtk-common`; do
		ln -sf ../gtk-common/$i gtk2-engine/$i
	done
}

