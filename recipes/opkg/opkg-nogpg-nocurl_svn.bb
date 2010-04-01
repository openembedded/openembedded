require opkg-nogpg_svn.bb

DEPENDS = ""
PROVIDES += "opkg"

PR = "${INC_PR}"

EXTRA_OECONF += " --disable-curl --enable-static --disable-shared"

# The nogpg version isn't getting much love and has an unused variable which trips up -Werror
do_configure_prepend() {
	sed -i -e s:-Werror::g ${S}/libopkg/Makefile.am
}

DEFAULT_PREFERENCE = "-1"
