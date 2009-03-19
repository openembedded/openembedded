require php.inc

PR = "r1"

SRC_URI = "http://museum.php.net/php4/php-${PV}.tar.bz2 \
           file://${FILESDIR}/autotools.patch;patch=1 \
           file://${FILESDIR}/pear.patch;patch=1"

