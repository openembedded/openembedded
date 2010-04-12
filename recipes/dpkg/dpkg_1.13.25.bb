require dpkg.inc
PR = "r2"
DEPENDS += "zlib bzip2"
SRC_URI += "file://noman.patch;patch=1"

EXTRA_OECONF = "--without-static-progs \
		--without-dselect \
		--with-start-stop-daemon \
		--with-zlib \
		--with-bz2lib \
		--without-sgml-doc \
		PERL=/usr/bin/perl"

SRC_URI[md5sum] = "88effb358aa04d25036b662d588433a6"
SRC_URI[sha256sum] = "a525f321e875a8c16f5b6942bc02ac66b0d284cc6c61704f93e74789ef89d817"
