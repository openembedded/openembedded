require libglade.inc

PR = "r2"

inherit gnome

SRC_URI += "file://glade-cruft.patch;patch=1 file://no-xml2.patch;patch=1"

EXTRA_OECONF += "--without-libxml2"

LDFLAGS += "-lz"

SRC_URI[archive.md5sum] = "da4f9d1c6cd1337f6ef5e2db768d8557"
SRC_URI[archive.sha256sum] = "7c79a2afaef4fd6726bad0530e29d2bc19689e07720a05c3ad32012e5aed3138"
