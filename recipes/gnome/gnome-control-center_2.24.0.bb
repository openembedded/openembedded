DESCRIPTION = "GNOME control center"
LICENSE = "GPL"

PR = "r1"

DEPENDS = "eel gstreamer libcanberra gnome-settings-daemon libgnomeui gnome-doc-utils gtk+ libglade libgnomecanvas librsvg libxml2 libart-lgpl"

inherit gnome

do_configure_prepend() {
	sed -i s:help::g Makefile.am
}

FILES_${PN} += "${datadir}/icon* \
                ${datadir}/xsession* \
                ${libdir}/window-manager-settings/*.so \
                ${datadir}/gnome \
                ${datadir}/desktop-directories \
               "
FILES_${PN}-dbg += "${libdir}/window-manager-settings/.debug"
FILES_${PN}-dev += "${libdir}/window-manager-settings/*a"





SRC_URI[archive.md5sum] = "6a4f4037a386bb8988e88033d8251488"
SRC_URI[archive.sha256sum] = "dac690bc6806603fe9e9b9979b0cc8d80c2449c3a8b9f4964f378567d31e06cc"
