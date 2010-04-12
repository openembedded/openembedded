PR = "r3"

SRC_URI = "http://ftp.sudo.ws/sudo/dist/sudo-${PV}.tar.gz \
           file://nonrootinstall.patch;patch=1 \
           file://nostrip.patch;patch=1 \
           file://autofoo.patch;patch=1 \
           file://noexec-link.patch;patch=1"

require sudo.inc

SRC_URI[md5sum] = "b29893c06192df6230dd5f340f3badf5"
SRC_URI[sha256sum] = "56f7d86032538a4a98d90af3742903a09ba16d6db82b593e4a47605f87fa581a"
