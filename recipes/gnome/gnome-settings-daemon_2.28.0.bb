DESCRIPTION = "GNOME settings daemon"
SECTION = "x11/gnome"
LICENSE = "GPL"

DEPENDS = "libxklavier libgnomekbd libgnomeui gnome-desktop gnome-doc-utils gtk+ libglade libgnomecanvas librsvg libxml2 libart-lgpl"

PR = "r1"

inherit gnome

LDFLAGS += "-lgthread-2.0"

FILES_${PN} += "${libdir}/gnome-settings-daemon-2.0/*.so \
                ${libdir}/gnome-settings-daemon-2.0/*plugin \
                ${datadir}/dbus-1/ \
                ${datadir}/gnome-control-center \
                ${datadir}/icons \
               "

FILES_${PN}-dbg += "${libdir}/gnome-settings-daemon-2.0/.debug"
FILES_${PN}-dev += "${libdir}/gnome-settings-daemon-2.0/*.a ${libdir}/gnome-settings-daemon-2.0/*.la"

do_configure_prepend () {
	sed -i 's:$CPPFLAGS -I$includedir:$CPPFLAGS:' ${S}/configure.ac
}



SRC_URI[archive.md5sum] = "66c4e3651cb0e022b114d30ac217b095"
SRC_URI[archive.sha256sum] = "df3203d804c6522f5c76a0e4d7d900595ac5942308fcd924ffcc8c3af436a4d5"
