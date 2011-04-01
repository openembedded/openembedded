require gnome-mplayer.inc

SRC_URI += "file://default.patch"

SRC_URI[gnomemplayer.md5sum] = "2cbba8838ecaa03a4c3a0190dcabfade"
SRC_URI[gnomemplayer.sha256sum] = "06082073ffa1351566e9992a67d9309cd04b367fb3b62c6fa5024761c897b40d"

PR = "${INC_PR}.0"
