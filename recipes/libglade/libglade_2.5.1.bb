require libglade.inc

PR = "r2"

inherit gnome

SRC_URI += "file://glade-cruft.patch;patch=1 file://no-xml2.patch;patch=1 \
	    file://no-deprecation.patch;patch=1"

EXTRA_OECONF += "--without-libxml2"

LDFLAGS += "-lz"

SRC_URI[archive.md5sum] = "e4734a59f1f2308d7714dc0ebf8163f1"
SRC_URI[archive.sha256sum] = "15e4c95402caa3c97394189a6b1b693eced23d80e292fcca12585317434adc2e"
