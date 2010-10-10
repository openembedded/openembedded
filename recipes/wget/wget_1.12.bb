PR="${INC_PR}.0"

SRC_URI = "${GNU_MIRROR}/wget/wget-${PV}.tar.gz"

SRC_URI[md5sum] = "141461b9c04e454dc8933c9d1f2abf83"
SRC_URI[sha256sum] = "7578ed0974e12caa71120581fa3962ee5a69f7175ddc3d6a6db0ecdcba65b572"

require wget.inc
