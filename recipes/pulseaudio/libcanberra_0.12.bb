DESCRIPTION = "Libcanberra is an implementation of the XDG Sound Theme and Name Specifications, for generating event sounds on free desktops."
LICENSE = "LGPL"
DEPENDS = "gtk+ pulseaudio alsa-lib gstreamer"

PR = "r2"

inherit gnome

SRC_URI = "http://0pointer.de/lennart/projects/libcanberra/libcanberra-${PV}.tar.gz"

EXTRA_OECONF = " --disable-oss " 
# This needs autoconf 2.62, which isn't used by any distro in OE atm
do_configure() {
	gnu-configize --force
	oe_runconf
}

FILES_${PN} += "${libdir}/gtk-2.0/modules/ ${datadir}/gnome ${libdir}/*/*.so"
FILES_${PN}-dbg += "${libdir}/gtk-2.0/modules/.debug ${libdir}/*/.debug"
FILES_${PN}-dev += "${libdir}/*/*.a"

AUTOTOOLS_STAGE_PKGCONFIG = "1"

do_stage() {
	autotools_stage_all
}

SRC_URI[md5sum] = "01a1952e861defa6de9d193558f2a732"
SRC_URI[sha256sum] = "04a70135de89ec7971a7ffa6516cf7699329cc01056595d524a6250a9d049709"
