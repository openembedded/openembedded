DESCRIPTION = "GNOME settings daemon"
SECTION = "x11/gnome"
LICENSE = "GPL"

DEPENDS = "libxklavier libgnomekbd libgnomeui gnome-desktop gnome-doc-utils gtk+ libglade libgnomecanvas librsvg libxml2 libart-lgpl"

inherit gnome

SRC_URI[archive.md5sum] = "a21485e7deca785f2ffb8ded58c4ae6a"
SRC_URI[archive.sha256sum] = "cb759f2aa403ad10f7b0a196c523fa0b3842cf4432b26a4b308ed1e5bf67e6aa"

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

