require connman.inc
PR       = "r0"

DEFAULT_PREFERENCE = "-1"

EXTRA_OECONF += " \
	--disable-gtk-doc "

SRC_URI  = "ftp://ftp.moblin.org/connman/releases/connman-${PV}.tar.gz \
            file://connman "

