LICENSE = "GPLv2+ LGPLv2+"
DEPENDS = "libxml2 gconf gnutls avahi dbus dbus-glib bzip2 gnome-mime-data zlib gtk-doc-native"
RRECOMMENDS_${PN} = "gnome-vfs-plugin-file shared-mime-info"
# Some legacy packages will require gnome-mime-data to be installed, but use of
# it is deprecated.
PR = "r4"

inherit gnome

SRC_URI += "file://gconftool-lossage.patch \
	    file://gnome-vfs-no-kerberos.patch;striplevel=0 \
	    file://03_gnutls27.patch"

# This is to provide compatibility with the gnome-vfs DBus fork
PROVIDES = "gnome-vfs-plugin-dbus"
RREPLACES_${PN} = "gnome-vfs-dbus"

EXTRA_OECONF = " \
                 --disable-openssl \
                 --enable-gnutls \
                 --enable-avahi \
                 --with-samba-includes=${STAGING_INCDIR} \
               "

do_nolargefile() {
	for file in ${S}/modules/Makefile.am \
			${S}/daemon/Makefile.am \
			${S}/libgnomevfs/Makefile.am; do
		sed -i -e '/_FILE_OFFSET_BITS/d' $file
		sed -i -e '/_LARGEFILE64_SOURCE/d' $file
	done
	sed -i -e '/_LARGEFILE64_SOURCE/,/#endif/d' ${S}/libgnomevfs/gnome-vfs-module-shared.h
}

do_configure_prepend() {
        sed -i -e 's:	doc	::g' Makefile.am
	${@base_contains('DISTRO_FEATURES', 'largefile', '', 'do_nolargefile', d)}
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



SRC_URI[archive.md5sum] = "100f9af16dc659e375ee8da45175a28d"
SRC_URI[archive.sha256sum] = "bc59144e303b152b84b86f209347a3e87a91d5ed7172d8503ee19c232dcabeb6"
