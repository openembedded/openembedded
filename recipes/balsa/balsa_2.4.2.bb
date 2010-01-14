DESCRIPTION = "Robust and configurable e-mail client for GNOME"
HOMEPAGE = "http://pawsa.fedorapeople.org/balsa/"
SECTION = "x11/network"
LICENSE = "GPL"
SRC_URI = "http://pawsa.fedorapeople.org/balsa/${P}.tar.bz2 \
	   file://libbalsa-gpe-corruption.patch;patch=1"
PR = "r1"

DEPENDS = "glib-2.0 gmime gnome-icon-theme gtk+ intltool-native libesmtp libxml-parser-perl-native"
RDEPENDS_${PN} = "gnome-icon-theme"
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

# Optional dependencies: desktop notification:
DEPENDS += "libnotify"

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

# Optional dependencies: automatic online/offline with NetworkManager:
#DEPENDS += "networkmanager"

# Optional dependencies: Rubrica addressbook:
#DEPENDS += "libxml2"

# Optional dependencies (not yet in OE): X-Face support:
#DEPENDS += "compface"

# Optional dependencies: sound support:
#DEPENDS += "libcanberra"

# FIXME: doc build requires docbook4 and gnome-doc-utils

inherit autotools gtk-icon-cache

EXTRA_OECONF="--with-ssl \
	      --without-gnome \
	      --disable-scrollkeeper \
	      --enable-smime \
	      --with-sqlite \
	      --with-ssl \
	      --with-webkit \
	      --with-unique \
	      --without-gtkspell \
	      --without-nm \
"
# Broken (does not compile, crashes after symbol fix):
#	      --enable-touch-ui \
# Not enabled:
#	      --with-gtkspell \
#	      --with-gpgme \
#	      --with-gtksourceview \
#	      --with-rubrica \
#	      --with-gss \
#	      --with-ldap \
#	      --with-compface \
#	      --with-canberra \

do_configure_prepend() {
	# aclocal seems to insist on looking in here.  Make sure it exists.
	mkdir -p ${S}/m4
}
