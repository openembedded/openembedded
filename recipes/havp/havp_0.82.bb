require havp.inc

PR = "r3"

SRC_URI_append += " file://sysconfdir-is-etc.patch;patch=1"
