DESCRIPTION = "gvfs is a userspace virtual filesystem"
LICENSE = "LGPL"
DEPENDS = "gawk-native gnome-keyring glib-2.0 obexftp fuse avahi fuse hal gconf-dbus samba gphoto2"

inherit gnome

EXTRA_OECONF = "--enable-samba  --with-archive-includes=${STAGING_INCDIR} --with-samba-includes=${STAGING_INCDIR}"

PACKAGES =+ "gvfsd-ftp gvfsd-sftp gvfsd-trash"

FILES_${PN} += "${datadir}/dbus-1/services/* ${libdir}/gio/modules/*.so"
FILES_${PN}-dbg += "${libdir}/gio/modules/.debug/*"
FILES_${PN}-dev += "${libdir}/gio/modules/*.la"

FILES_gvfsd-ftp = "${libexecdir}/gvfsd-ftp ${sysconfdir}/gvfs/mounts/ftp.mount"
FILES_gvfsd-sftp = "${libexecdir}/gvfsd-sftp ${sysconfdir}/gvfs/mounts/sftp.mount"
FILES_gvfsd-trash = "${libexecdir}/gvfsd-trash ${sysconfdir}/gvfs/mounts/trash.mount"

do_stage() {
	autotools_stage_all
}
