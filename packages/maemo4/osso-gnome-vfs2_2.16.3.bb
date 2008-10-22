LICENSE = "GPL"
DEPENDS = "libxml2 gconf gnutls avahi dbus bzip2 gnome-mime-data zlib"
RRECOMMENDS = "gnome-vfs-plugin-file gnome-mime-data shared-mime-info"

DESCRIPTION = "gnomevfs - osso variant"

PR = "r0"

inherit gnome

SRC_URI = "\
  http://repository.maemo.org/pool/maemo4.0/free/source/o/${PN}/${PN}_${PV}-1osso31.tar.gz \
  file://gnome-vfs-no-kerberos.patch;patch=1;pnum=0 \
  "


EXTRA_OECONF = " \
	--disable-openssl \
	--enable-gnutls \
	--enable-avahi \
	--with-samba-includes=${STAGING_INCDIR} \
	--enable-more-warnings=no \
	"

do_configure_prepend() {
	# remove Werror from VFS_CFLAGS
	sed -i s:-Werror::g configure.in

	# G_GNUC_FUNCTION is deprecated
	sed -i -e s,-DG_DISABLE_DEPRECATED,-DSED_ROCKS_DUDE, */Makefile.am

	touch gtk-doc.make
}

do_stage() {
  autotools_stage_all
}

PACKAGES_DYNAMIC = "osso-gnome-vfs-plugin-*"

python populate_packages_prepend () {
	print bb.data.getVar('FILES_osso-gnome-vfs', d, 1)

	plugindir = bb.data.expand('${libdir}/gnome-vfs-2.0/modules/', d)
	do_split_packages(d, plugindir, '^lib(.*)\.so$', 'osso-gnome-vfs-plugin-%s', 'OSSO GNOME VFS plugin for %s')
}

FILES_${PN} += "${datadir}/dbus-1"
FILES_${PN}-dbg += " ${libdir}/gnome-vfs-2.0/modules/.debug/lib*.so"
FILES_${PN}-dev += " ${libdir}/gnome-vfs-2.0/include ${libdir}/gnome-vfs-2.0/modules/lib*.a ${libdir}/gnome-vfs-2.0/modules/lib*.la"
FILES_${PN}-doc += " ${datadir}/gtk-doc"
