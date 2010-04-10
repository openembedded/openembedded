SECTION = "x11/base"
DESCRIPTION = "Industrial theme engine for GTK"
LICENSE = "GPLv2"
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


SRC_URI[md5sum] = "c0f131c265a585e5cfd84e2da6b6d3a0"
SRC_URI[sha256sum] = "5e58ce65e7fe08eb28bd258a5de9c56c75998cdb48c3867b392b5ea74160aa32"
