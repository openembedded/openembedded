LICENSE = "GPL"
DEPENDS = "libxml2 gconf gnutls avahi dbus dbus-glib bzip2 gnome-mime-data zlib gtk-doc-native"
RRECOMMENDS = "gnome-vfs-plugin-file shared-mime-info"
# Some legacy packages will require gnome-mime-data to be installed, but use of
# it is deprecated.
PR = "r2"

inherit gnome

SRC_URI += "file://gconftool-lossage.patch;patch=1;pnum=1 \
	    file://gnome-vfs-no-kerberos.patch;patch=1;pnum=0 \
	    file://03_gnutls27.patch;patch=1"

# This is to provide compatibility with the gnome-vfs DBus fork
PROVIDES = "gnome-vfs-plugin-dbus"
RREPLACES = "gnome-vfs-dbus"

EXTRA_OECONF = " \
                 --disable-openssl \
                 --enable-gnutls \
                 --enable-avahi \
                 --with-samba-includes=${STAGING_INCDIR} \
               "

do_configure_prepend() {
        sed -i -e 's:	doc	::g' Makefile.am
}

do_stage () {
	autotools_stage_all
}

PACKAGES_DYNAMIC = "gnome-vfs-plugin-*"

python populate_packages_prepend () {
	print bb.data.getVar('FILES_gnome-vfs', d, 1)

	plugindir = bb.data.expand('${libdir}/gnome-vfs-2.0/modules/', d)
	do_split_packages(d, plugindir, '^lib(.*)\.so$', 'gnome-vfs-plugin-%s', 'GNOME VFS plugin for %s')
}

FILES_${PN} += "${libdir}/vfs ${datadir}/dbus-1/services"
FILES_${PN}-dbg += "${libdir}/gnome-vfs-2.0/modules/.debug"
FILES_${PN}-dev += "${libdir}/gnome-vfs-2.0/include \
                    ${libdir}/gnome-vfs-2.0/modules/*.a \
                    ${libdir}/gnome-vfs-2.0/modules/*.la \
                   "
FILES_${PN}-doc += "${datadir}/gtk-doc"


