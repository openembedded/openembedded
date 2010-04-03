DESCRIPTION = "OBEX Server and Client"
DEPENDS = "openobex glib-2.0 dbus bluez4"
DEPENDS_append_shr = " libframeworkd-glib "

LICENSE = "GPLv2"

SRC_URI = "http://www.kernel.org/pub/linux/bluetooth/obexd-${PV}.tar.gz;name=archive"
SRC_URI_append_shr = " file://obexd-add-fso-support.patch;patch=1 "
SRC_URI[archive.md5sum] = "ed59a0e357b56d2a2ba0d1de6a0cc109"
SRC_URI[archive.sha256sum] = "b6a0217abafd2fd78c33ef8b9d64bb83da014c67c1ed594c475129a1b326e137"

inherit autotools_stage

EXTRA_OECONF_append_shr = " --with-telephony=fso --with-phonebook=fso "

FILES_${PN} += "${datadir}/dbus-1/"
