require havp.inc

FILE_PR = "r3"

SRC_URI_append += " file://sysconfdir-is-etc.patch;patch=1"
