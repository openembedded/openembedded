require libgpg-error.inc

PR = "${INC_PR}.1"

SRC_URI = "ftp://ftp.gnupg.org/gcrypt/alpha/libgpg-error/libgpg-error-${PV}.tar.gz \
	   file://pkgconfig.patch;patch=1"

SRC_URI[md5sum] = "5340fa28c365049c995996e8dc0f880c"
SRC_URI[sha256sum] = "e8eb2c3a844a080144cbb994118e5110b08bc0f608f8c3f2f1977211167bda76"
