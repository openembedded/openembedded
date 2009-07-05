DESCRIPTION = "Robust and configurable e-mail client for GNOME"
HOMEPAGE = "http://pawsa.fedorapeople.org/balsa/"
SECTION = "x11/network"
LICENSE = "GPL"
SRC_URI = "http://pawsa.fedorapeople.org/balsa/${P}.tar.bz2 \
           file://balsa-touch.patch;patch=1 \
           file://balsa-no-spell.patch;patch=1"

DEPENDS = "glib-2.0 libgmime-2.4 gtk+ intltool-native libesmtp libxml-parser-perl-native"
# FIXME: It is possible to build several variants of balsa: lite (SSL, gqlite/GPE, maybe HTML),
# standard (GNOME, spell checking, HTML), full (Kerberos, LDAP, PGP, Rubrica, X-Face)

# Options for regular expressions are: NONE (POSIX) glib-2.0 (GRegex) libpcre (PCRE)
DEPENDS += ""

# Options for remote activation are: libbonobo libunique
DEPENDS += "libunique"

# Options for HTML view are: gtkhtml-2.0 gtkhtml-3.0 webkit-gtk NONE
DEPENDS += "webkit-gtk"

# Optional dependencies (missing in OE): Spell checking
#DEPENDS += "gtkspell"

# Optional dependencies: SSL support:
DEPENDS += "openssl"

# Optional dependencies: GPE addressbook:
DEPENDS += "sqlite"

# Optional dependencies: GNOME:
DEPENDS += "gconf libgnome libgnomeui"
#DEPENDS += "gnome-keyring"

# Optional dependencies: PGP support:
#DEPENDS += "gpgme"

# Optional dependencies: view source:
#DEPENDS += "gtksourceview2"

# Optional dependencies: LDAP:
#DEPENDS += "openldap"

# Options for optional Kerberos 5: heimdal (not in OE) krb5
#DEPENDS += "krb5"

# Optional dependencies: Rubrica addressbook:
#DEPENDS += "libxml2"

# Optional dependencies (not yet in OE): X-Face support:
#DEPENDS += "compface"

# FIXME: doc build requires docbook4 and gnome-doc-utils

inherit autotools

EXTRA_OECONF="--with-ssl \
	      --without-gnome \
	      --enable-touch-ui \
	      --disable-scrollkeeper \
	      --enable-smime \
	      --with-sqlite \
	      --with-ssl \
	      --with-webkit \
	      --with-unique \
#	      --without-gtkspell \
"
# Not enabled:
#	      --with-gtkspell \
#	      --with-gpgme \
#	      --with-gtksourceview \
#	      --with-rubrica \
#	      --with-gss \
#	      --with-ldap \
#	      --with-compface \

do_configure_prepend() {
	# aclocal seems to insist on looking in here.  Make sure it exists.
	mkdir -p ${S}/m4
}
