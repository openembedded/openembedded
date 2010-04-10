require libglade.inc

PR = "r3"

inherit gnome

SRC_URI += "file://glade-cruft.patch;patch=1 file://no-xml2.patch;patch=1"

EXTRA_OECONF += "--without-libxml2"

SRC_URI[archive.md5sum] = "c8367c58b2f2c98b76ca0667f0f13bf5"
SRC_URI[archive.sha256sum] = "33b82b27b63368c2022af4f5697905ee704d847730d6a7d078fe862ce28618cc"
