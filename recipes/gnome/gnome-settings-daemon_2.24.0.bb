DESCRIPTION = "GNOME settings daemon"
LICENSE = "GPL"

PR = "r1"

DEPENDS = "libxklavier libgnomekbd libgnomeui gnome-doc-utils gtk+ libglade libgnomecanvas librsvg libxml2 libart-lgpl"

inherit gnome

FILES_${PN} += "${libdir}/gnome-settings-daemon-2.0/*.so ${libdir}/gnome-settings-daemon-2.0/*plugin \
                ${datadir}/dbus-1/ \
                ${datadir}/icon* \
                ${datadir}/xsession*"

FILES_${PN}-dbg += "${libdir}/gnome-settings-daemon-2.0/.debug"
FILES_${PN}-dev += "${libdir}/gnome-settings-daemon-2.0/*.a ${libdir}/gnome-settings-daemon-2.0/*.la"

do_stage() {    
	autotools_stage_all
}


SRC_URI[archive.md5sum] = "2e30e9d17b810103d493e474fbfd20e5"
SRC_URI[archive.sha256sum] = "98377ed6d7c4abb75b746570f07e00a4346ba6f5924574130211beca764bb99d"
