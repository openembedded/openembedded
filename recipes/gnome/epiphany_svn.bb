DESCRIPTION = "GNOME default webbrowser"
DEPENDS = "gnome-desktop gnome-vfs libgnomeui webkit-gtk iso-codes startup-notification"
RDEPENDS = "gnome-vfs-plugin-http iso-codes"

SRCREV = "7837"
PV = "2.20.1+svnr${SRCPV}"
PR = "r1"

inherit gnome

SRC_URI = "svn://svn.gnome.org/svn/epiphany;module=trunk;proto=http"
S = "${WORKDIR}/trunk"

EXTRA_OECONF = "--with-engine=webkit --with-distributor-name=${DISTRO}"

do_configure_prepend() {
        touch ${S}/gnome-doc-utils.make
}

FILES_${PN} += "${datadir}/icons ${datadir}/dbus-1"


