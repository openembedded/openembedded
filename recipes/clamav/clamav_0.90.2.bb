require clamav.inc

SRC_URI += "file://cross-compile-fix.patch;patch=1"

PR = "${INC_PR}.0"
SRC_URI[clamav-0.90.2.md5sum] = "39d1f07a399b551b55096b6ec7325c33"
SRC_URI[clamav-0.90.2.sha256sum] = "30df6a5d4a591dcd4acd7d4cce54dcfd260280fce6bbc9d19d240967bcdabbfa"
