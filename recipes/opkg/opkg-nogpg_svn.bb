require opkg_svn.bb

DEPENDS = "curl"
PROVIDES += "opkg"

PR = "${INC_PR}.1"

SRCREV = "${SRCREV_pn-opkg}"

EXTRA_OECONF += " --disable-gpg \ 
                  --disable-openssl \ 
                  --disable-ssl-curl \
                  --enable-gpg=no \
                  --enable-ssl-curl=no \
                  --enable-openssl=no"

LDFLAGS_append = " -Wl,--as-needed"

# The nogpg version isn't getting much love and has an unused variable which trips up -Werror
do_configure_prepend() {
	sed -i -e s:-Werror::g ${S}/libopkg/Makefile.am
}
do_configure_prepend_nylon() {
	LDFLAGS="`echo "$LDFLAGS" | sed "s/ -Wl,--as-needed//"`"
}

DEFAULT_PREFERENCE = "-1"
