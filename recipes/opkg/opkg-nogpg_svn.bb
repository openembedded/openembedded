require opkg_svn.bb

DEPENDS = "curl"
PROVIDES += "opkg"

PR = "r14"

SRCREV = "${SRCREV_pn-opkg}"

EXTRA_OECONF += "--disable-gpg"

# The nogpg version isn't getting much love and has an unused variable which trips up -Werror
do_configure_prepend() {
	sed -i -e s:-Werror::g ${S}/libopkg/Makefile.am
}

DEFAULT_PREFERENCE = "-1"
