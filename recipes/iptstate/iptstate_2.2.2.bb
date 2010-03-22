include iptstate.inc

PR = "${INC_PR}.0"

SRC_URI += "file://iptstate-use-ldflags.patch;patch=1"

SRC_URI[iptstate-2.2.2.md5sum] = "b3f2e89ef38d6e8a85c8ab88a9c514d8"
SRC_URI[iptstate-2.2.2.sha256sum] = "2d9654a30a1e22159d93b2988c140571d048d08370b4869b1cb91562c29e1c39"
