LICENSE = "GPL"
DEPENDS = "libxml2 gconf gnutls avahi dbus dbus-glib bzip2 gnome-mime-data zlib"
RRECOMMENDS = "gnome-vfs-plugin-file shared-mime-info"
# Some legacy packages will require gnome-mime-data to be installed, but use of
# it is deprecated.
PR = "r1"

inherit gnome

SRC_URI += "file://gconftool-lossage.patch;patch=1;pnum=1 \
	    file://gnome-vfs-no-kerberos.patch;patch=1;pnum=0"

# This is to provide compatibility with the gnome-vfs DBus fork
PROVIDES = "gnome-vfs-plugin-dbus"
RREPLACES = "gnome-vfs-dbus"

EXTRA_OECONF = " \
                 --disable-openssl \
                 --enable-gnutls \
                 --enable-avahi \
                 --with-samba-includes=${STAGING_INCDIR} \
               "

FILES_${PN} += "${libdir}/vfs ${datadir}/dbus-1/services"
FILES_${PN}-dbg += "${libdir}/gnome-vfs-2.0/modules/.debug"
FILES_${PN}-dev += "\
  ${libdir}/gnome-vfs-2.0/include \
  ${libdir}/gnome-vfs-2.0/modules/*.a \
  ${libdir}/gnome-vfs-2.0/modules/*.la \
"
FILES_${PN}-doc += "${datadir}/gtk-doc"

do_stage () {
autotools_stage_all
}

PACKAGES_DYNAMIC = "gnome-vfs-plugin-*"

python populate_packages_prepend () {
	print bb.data.getVar('FILES_gnome-vfs', d, 1)

	plugindir = bb.data.expand('${libdir}/gnome-vfs-2.0/modules/', d)
	do_split_packages(d, plugindir, '^lib(.*)\.so$', 'gnome-vfs-plugin-%s', 'GNOME VFS plugin for %s')
}



SRC_URI[archive.md5sum] = "369105fd82cb99e69e63acab8f3b89b7"
SRC_URI[archive.sha256sum] = "622cf50cefa2c4187e0a23f29d665f010f7a0815864fc35a61caefd5a7d4ebb1"
