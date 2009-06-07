LICENSE = "GPL"
SECTION = "x11/gnome"

DEFAULT_PREFERENCE = "-1"

inherit autotools gnome pkgconfig

SRC_URI = "git://git.gnome.org/gnome-bluetooth;protocol=git \
           file://gtk-doc.make \
"

S = "${WORKDIR}/git"

SRCREV = "097aef044ced5937dd7e288bfee58b6138939117"
PV = "2.27.5"
PR_append = "+gitr${SRCREV}"

DEPENDS = "obexd obex-data-server gconf-dbus gtk+ dbus-glib libunique libnotify hal bluez4 gnome-keyring"
RRECOMMENDS_${PN} += "obexd obex-data-server"
RCONFLICTS_${PN} = "bluez-gnome"

do_configure_prepend() {
	cp ${WORKDIR}/gtk-doc.make ${S}/
    sed -i -e s:docs::g ${S}/Makefile.am
	echo "EXTRA_DIST = version.xml" > gnome-doc-utils.make
}

