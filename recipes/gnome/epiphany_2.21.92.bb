DESCRIPTION = "GNOME default webbrowser"
DEPENDS = "gnome-desktop gnome-vfs libgnomeui webkit-gtk iso-codes startup-notification"
RDEPENDS = "gnome-vfs-plugin-http iso-codes"
PR ="r2"

inherit gnome

SRC_URI_append = " file://file_contains.patch;patch=1"

EXTRA_OECONF = "--with-engine=webkit --with-distributor-name=${DISTRO}"

do_configure_prepend() {
        touch ${S}/gnome-doc-utils.make
        sed -i -e s:help::g Makefile.am
}

FILES_${PN} += "${datadir}/icons ${datadir}/dbus-1"



SRC_URI[archive.md5sum] = "2e0199851122ecb9d5f2863d92e18aa8"
SRC_URI[archive.sha256sum] = "904275567e54f5fcdb068d544b42da34c0361d3b8d143dfecd878950850a54c9"
