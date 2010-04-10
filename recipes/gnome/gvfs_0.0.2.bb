DESCRIPTION = "gvfs is a userspace virtual filesystem"
LICENSE = "LGPL"
DEPENDS = "glib-2.0 gio-standalone fuse"
PR = "r0"

inherit gnome

EXTRA_OECONF = "--disable-samba"

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

SRC_URI[archive.md5sum] = "1267b82b481340eadf212cf47b735b62"
SRC_URI[archive.sha256sum] = "7249197b75a61c36398f7458f12c0318ccf03639ae8404771fb4ff414fa17683"
