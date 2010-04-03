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


