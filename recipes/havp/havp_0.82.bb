require havp.inc

PR = "r3"

SRC_URI_append += " file://sysconfdir-is-etc.patch;patch=1"

SRC_URI[md5sum] = "9e6a16b7d074782d1c62f1f7316e56ab"
SRC_URI[sha256sum] = "e2db8d3383cd8eca6a18ebee85875de895f3ac7414eab091a87f052d79a87b09"
