require libglade.inc

inherit gnome

SRC_URI += "file://glade-cruft.patch;patch=1 file://no-xml2.patch;patch=1"

EXTRA_OECONF += "--without-libxml2"

LDFLAGS += "-lz"

SRC_URI[archive.md5sum] = "d1776b40f4e166b5e9c107f1c8fe4139"
SRC_URI[archive.sha256sum] = "64361e7647839d36ed8336d992fd210d3e8139882269bed47dc4674980165dec"
