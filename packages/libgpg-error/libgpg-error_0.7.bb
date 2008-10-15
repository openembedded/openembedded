require libgpg-error.inc

PR = "r4"

SRC_URI = "ftp://ftp.gnupg.org/gcrypt/alpha/libgpg-error/libgpg-error-${PV}.tar.gz \
	   file://pkgconfig.patch;patch=1"
