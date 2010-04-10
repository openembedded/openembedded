require e2fsprogs.inc

PR = "${INC_PR}"

SRC_URI += "file://mkinstalldirs.patch;patch=1"

SRC_URI[md5sum] = "59033388df36987d2b9c9bbf7e19bd57"
SRC_URI[sha256sum] = "2cc10fee2b29add737e454eb634513135b34a638f7ca2b18364864fe089020dc"
