SECTION = "console/network"
require php_${PV}.bb
inherit native
FILESPATH = "${FILE_DIRNAME}/php-${PV}:${FILE_DIRNAME}/php:${FILE_DIRNAME}/files"
DEPENDS = "zlib-native"
PR = "r2"

S = "${WORKDIR}/php-${PV}"

SRC_URI[md5sum] = "bc6fa8908e2ac36e93bab9f7d42cda3a"
SRC_URI[sha256sum] = "9f0742fce014a255f8453c1264afee5de289a9e9dcd57c448c77b46978f6a76b"