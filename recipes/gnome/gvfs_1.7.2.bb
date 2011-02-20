DESCRIPTION = "gvfs is a userspace virtual filesystem"
LICENSE = "LGPLv2"
DEPENDS = "libcdio gawk-native libimobiledevice gnome-keyring glib-2.0 obexftp fuse avahi fuse hal gconf samba gphoto2"

inherit gnome

SRC_URI[archive.md5sum] = "d8a57290a5d090b07cd2f23914f20f4e"
SRC_URI[archive.sha256sum] = "edea9b41ab8756c893528c398f609517adfd66b50a51d8e93b44c74febe310c0"

EXTRA_OECONF = "--enable-samba  --with-archive-includes=${STAGING_INCDIR} --with-samba-includes=${STAGING_INCDIR}"

PACKAGES =+ "gvfsd-ftp gvfsd-sftp gvfsd-trash"

FILES_${PN} += "${datadir}/dbus-1/services/* ${libdir}/gio/modules/*.so"
FILES_${PN}-dbg += "${libdir}/gio/modules/.debug/*"
FILES_${PN}-dev += "${libdir}/gio/modules/*.la"

FILES_gvfsd-ftp = "${libexecdir}/gvfsd-ftp ${sysconfdir}/gvfs/mounts/ftp.mount"
FILES_gvfsd-sftp = "${libexecdir}/gvfsd-sftp ${sysconfdir}/gvfs/mounts/sftp.mount"
FILES_gvfsd-trash = "${libexecdir}/gvfsd-trash ${sysconfdir}/gvfs/mounts/trash.mount"

