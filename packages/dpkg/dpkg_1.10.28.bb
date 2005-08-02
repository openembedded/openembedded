include dpkg.inc
DEPENDS += "bzip2"

SRC_URI += "file://autofoo.patch;patch=1"

inherit autotools gettext

EXTRA_OECONF = "--without-static-progs \
		--without-dselect \
		--with-start-stop-daemon \
		--with-zlib \
		--with-bz2lib \
		--without-sgml-doc"
