DESCRIPTION = "GNOME control center"
LICENSE = "GPL"

PR = "r1"

DEPENDS = "metacity eel gstreamer libcanberra gnome-settings-daemon libgnomeui gnome-doc-utils gtk+ libglade libgnomecanvas librsvg libxml2 libart-lgpl atk"

inherit gnome

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





SRC_URI[archive.md5sum] = "c0e009ed5d94d12a183b61136dd908de"
SRC_URI[archive.sha256sum] = "d7e925a6247ff03b5c1bbb50aedc8bcf69e7497d6a47c42e1b867e5c6c3b1f54"
