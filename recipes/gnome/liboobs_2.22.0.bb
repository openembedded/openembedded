LICENSE = "LGPL"
DEPENDS = "glib-2.0 dbus system-tools-backends"

inherit gnome lib_package

do_stage() {
	autotools_stage_all
}

SRC_URI[archive.md5sum] = "1b090ecd6c0df58b131795ff9a5c9057"
SRC_URI[archive.sha256sum] = "b35760855d7d1def532e9e808cecde29b75cec455b238590072abf4a8206536e"
