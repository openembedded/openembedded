require libglade.inc

PR = "r1"

inherit gnome

SRC_URI += "file://glade-cruft.patch;patch=1 file://no-xml2.patch;patch=1"

EXTRA_OECONF += "--without-libxml2"

LDFLAGS += "-lz"

SRC_URI[archive.md5sum] = "83d08f9ab485a10454bd5171d2d53fb0"
SRC_URI[archive.sha256sum] = "c08209650ac1d0f94cf7e4bf692bb3ce61beeeab62b6f375ac652947a386655f"
