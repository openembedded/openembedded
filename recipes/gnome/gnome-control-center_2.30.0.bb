DESCRIPTION = "GNOME control center"
LICENSE = "GPL"

DEPENDS = "metacity gstreamer libcanberra gnome-settings-daemon libgnomeui gnome-doc-utils gtk+ libglade libgnomecanvas librsvg libxml2 libart-lgpl atk"

inherit gnome

SRC_URI[archive.md5sum] = "ff7a638c2aa733997c7062449c02ccca"
SRC_URI[archive.sha256sum] = "aa279706d7a1a4f5a4ba4767cc80ac3cae2855d3bc6600b5c039dc650d754828"


LDFLAGS += "-lgthread-2.0 -lxml2"

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




