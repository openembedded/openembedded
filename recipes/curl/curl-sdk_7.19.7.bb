require curl-common.inc
inherit sdk
DEPENDS = "zlib-sdk"

SRC_URI[tarball.md5sum] = "79a8fbb2eed5464b97bdf94bee109380"
SRC_URI[tarball.sha256sum] = "1a15f94ae3401e3bd6208ce64155c2577815019824bceae7fd3221a12bc54a70"

EXTRA_OECONF = " --without-gnutls "

PR = "${INC_PR}.0"
