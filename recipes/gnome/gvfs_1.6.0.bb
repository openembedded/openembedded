DESCRIPTION = "gvfs is a userspace virtual filesystem"
LICENSE = "LGPL"
DEPENDS = "gawk-native libimobiledevice gnome-keyring glib-2.0 obexftp fuse avahi fuse hal gconf samba gphoto2"

inherit gnome

SRC_URI[archive.md5sum] = "fb533047ddd894ec5c811b005cb88a07"
SRC_URI[archive.sha256sum] = "2e4c973e75c7af8d2d88232cd7742971f655fdbd7f5b687450b858484d88a0d3"

EXTRA_OECONF = "--enable-samba  --with-archive-includes=${STAGING_INCDIR} --with-samba-includes=${STAGING_INCDIR}"

PACKAGES =+ "gvfsd-ftp gvfsd-sftp gvfsd-trash"

FILES_${PN} += "${datadir}/dbus-1/services/* ${libdir}/gio/modules/*.so"
FILES_${PN}-dbg += "${libdir}/gio/modules/.debug/*"
FILES_${PN}-dev += "${libdir}/gio/modules/*.la"

FILES_gvfsd-ftp = "${libexecdir}/gvfsd-ftp ${sysconfdir}/gvfs/mounts/ftp.mount"
FILES_gvfsd-sftp = "${libexecdir}/gvfsd-sftp ${sysconfdir}/gvfs/mounts/sftp.mount"
FILES_gvfsd-trash = "${libexecdir}/gvfsd-trash ${sysconfdir}/gvfs/mounts/trash.mount"

