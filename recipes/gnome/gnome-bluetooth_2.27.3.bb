LICENSE = "GPL"
SECTION = "x11/gnome"

inherit autotools gnome pkgconfig

GBTREV = "607"
SRC_URI = "svn://svn.gnome.org/svn/${PN};module=trunk;rev=${GBTREV};proto=http"
S = "${WORKDIR}/trunk"
PV = "2.27.3+svnr${GBTREV}"

DEPENDS = "obexd obex-data-server gconf-dbus gtk+ dbus-glib libunique libnotify hal bluez4 gnome-keyring"
RRECOMMENDS_${PN} += "obexd obex-data-server"
RCONFLICTS_${PN} = "bluez-gnome"

EXTRA_OECONF = "--enable-debug"
CFLAGS += " -g "

do_configure_prepend() {
    sed -i -e s:docs::g ${S}/Makefile.am
	echo "EXTRA_DIST = version.xml" > gnome-doc-utils.make
	echo "EXTRA_DIST = version.xml" > gtk-doc.make
}

