require php.inc

PR = "r1"

SRC_URI = "http://museum.php.net/php4/php-${PV}.tar.bz2 \
           file://${FILESDIR}/autotools.patch;patch=1 \
           file://${FILESDIR}/pear.patch;patch=1"


SRC_URI[md5sum] = "bc6fa8908e2ac36e93bab9f7d42cda3a"
SRC_URI[sha256sum] = "9f0742fce014a255f8453c1264afee5de289a9e9dcd57c448c77b46978f6a76b"