require rdiff-backup.inc
PR = "r1"

# 1.1.x added the use of sha which we get from python-crypt
RDEPENDS_${PN} += "python-crypt"

SRC_URI[md5sum] = "37478b1d3e76ea521aac22216582ec58"
SRC_URI[sha256sum] = "0cbfb4b3940ecc9e351bbd72b5a9c53af050f2f5f63d500e8ff714ab6c91e447"
