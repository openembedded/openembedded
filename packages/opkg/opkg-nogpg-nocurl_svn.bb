require opkg_svn.bb

DEPENDS = ""
PROVIDES += "opkg"

SRC_URI += "file://opkg_wget.patch;patch=1 \
	    file://reduce-nogpg-noise.patch;patch=1 \
	   "
PR = "r0"

SRCREV = "${SRCREV_pn-opkg}"

EXTRA_OECONF += "--disable-gpg"

# The nogpg version isn't getting much love and has an unused variable which trips up -Werror
do_configure_prepend() {
	sed -i -e s:-Werror::g ${S}/libopkg/Makefile.am
}

DEFAULT_PREFERENCE = "-1"
