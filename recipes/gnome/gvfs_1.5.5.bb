DESCRIPTION = "gvfs is a userspace virtual filesystem"
LICENSE = "LGPL"
DEPENDS = "gawk-native libimobiledevice gnome-keyring glib-2.0 obexftp fuse avahi fuse hal gconf samba gphoto2"

inherit gnome

SRC_URI += " \
            file://imobile-fix.patch;patch=1 \
            file://imobile-fix2.patch;patch=1 \
"

SRC_URI[archive.md5sum] = "d4ae94acdea317d8a8bf88a793b8df3f"
SRC_URI[archive.sha256sum] = "e6c3c54ddbf5be75836e69c6d847500201b1b95b54d9bea8f9f51d2bc9617c8a"

EXTRA_OECONF = "--enable-samba  --with-archive-includes=${STAGING_INCDIR} --with-samba-includes=${STAGING_INCDIR}"

PACKAGES =+ "gvfsd-ftp gvfsd-sftp gvfsd-trash"

FILES_${PN} += "${datadir}/dbus-1/services/* ${libdir}/gio/modules/*.so"
FILES_${PN}-dbg += "${libdir}/gio/modules/.debug/*"
FILES_${PN}-dev += "${libdir}/gio/modules/*.la"

FILES_gvfsd-ftp = "${libexecdir}/gvfsd-ftp ${sysconfdir}/gvfs/mounts/ftp.mount"
FILES_gvfsd-sftp = "${libexecdir}/gvfsd-sftp ${sysconfdir}/gvfs/mounts/sftp.mount"
FILES_gvfsd-trash = "${libexecdir}/gvfsd-trash ${sysconfdir}/gvfs/mounts/trash.mount"

