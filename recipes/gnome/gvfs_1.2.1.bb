DESCRIPTION = "gvfs is a userspace virtual filesystem"
LICENSE = "LGPL"
DEPENDS = "gawk-native gnome-keyring glib-2.0 obexftp fuse avahi fuse hal gconf samba gphoto2"

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

SRC_URI[archive.md5sum] = "df8f624587adfabe7009838ce6d8d5fd"
SRC_URI[archive.sha256sum] = "0e3c3469721ff1d4296bf4af7e1f131201d2dc6a36c772d99e1630f8cce31da2"
