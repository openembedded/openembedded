require dpkg.inc
PR = "r6"
DEPENDS += "zlib bzip2"
SRC_URI += "file://noman.patch;patch=1"

EXTRA_OECONF = "--without-static-progs \
		--without-dselect \
		--with-start-stop-daemon \
		--with-zlib \
		--with-bz2lib \
		--without-sgml-doc \
		PERL=/usr/bin/perl"
<<<<<<< HEAD
=======

SRC_URI[md5sum] = "0fc9fffc2c2cfa7107d8f422815078c1"
SRC_URI[sha256sum] = "c33aeb300d93eaeac55927ce81dc6f3a1cf74b3b759b65182c9bfca31b75b98f"
>>>>>>> b6d0763... recipes: add missing checksums
