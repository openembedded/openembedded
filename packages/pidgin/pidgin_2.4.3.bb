require pidgin.inc

DEFAULT_PREFERENCE = "-1"

SRC_URI = "${SOURCEFORGE_MIRROR}/pidgin/pidgin-${PV}.tar.bz2 \
           file://sanitize-configure.ac.patch;patch=1 \
           file://gconf-no-errors.patch;patch=1 \
	   file://pidgin.desktop-set-icon.patch;patch=1 \
	   file://purple-OE-branding.patch;patch=1 \
	   file://pidgin-cross-python.patch;patch=1 \
	  " 

EXTRA_OECONF += " --disable-gtkspell \
                  --disable-meanwhile \
                  --disable-nm \ 
                "

PR = "r0"
