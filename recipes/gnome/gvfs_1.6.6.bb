DESCRIPTION = "gvfs is a userspace virtual filesystem"
LICENSE = "LGPLv2"
DEPENDS = "libcdio gawk-native libimobiledevice gnome-keyring glib-2.0 obexftp fuse avahi fuse hal gconf samba gphoto2"

PR = "r1"

inherit gnome

SRC_URI += "file://async.patch"

SRC_URI[archive.md5sum] = "e1f324c45ea07d630f85bd3199865fd9"
SRC_URI[archive.sha256sum] = "902890deb6a670f642180ea958406ebb02af1d5867a464c87e493d56f1dde7bd"

EXTRA_OECONF = "--enable-samba  --with-archive-includes=${STAGING_INCDIR} --with-samba-includes=${STAGING_INCDIR}"

PACKAGES =+ "gvfsd-ftp gvfsd-sftp gvfsd-trash"

FILES_${PN} += "${datadir}/dbus-1/services/* ${libdir}/gio/modules/*.so"
FILES_${PN}-dbg += "${libdir}/gio/modules/.debug/*"
FILES_${PN}-dev += "${libdir}/gio/modules/*.la"

FILES_gvfsd-ftp = "${libexecdir}/gvfsd-ftp ${sysconfdir}/gvfs/mounts/ftp.mount"
FILES_gvfsd-sftp = "${libexecdir}/gvfsd-sftp ${sysconfdir}/gvfs/mounts/sftp.mount"
FILES_gvfsd-trash = "${libexecdir}/gvfsd-trash ${sysconfdir}/gvfs/mounts/trash.mount"

