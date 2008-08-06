require postgresql.inc

PR = "r3"
DEFAULT_PREFERENCE = "-1"

SRC_URI = "http://ftp.de.postgresql.org/mirror/postgresql/source/v${PV}/${P}.tar.bz2 \
           file://no-ecpg-test.patch;patch=1"
