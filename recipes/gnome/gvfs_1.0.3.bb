DESCRIPTION = "gvfs is a userspace virtual filesystem"
LICENSE = "LGPL"
DEPENDS = "glib-2.0 fuse"
PR = "r0"

inherit gnome

EXTRA_OECONF = "--disable-samba  --with-archive-includes=${STAGING_INCDIR}"

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

SRC_URI[archive.md5sum] = "a41e8b7d99e390cef8312f7ce5f312a5"
SRC_URI[archive.sha256sum] = "17eccded6e096208181e2c7625802526112af23f5b2c7b2a672ab9ccff3a55fd"
