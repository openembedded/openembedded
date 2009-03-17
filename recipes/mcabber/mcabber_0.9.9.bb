DESCRIPTION = "Jabber ncurses client"
HOMEPAGE = "http://www.lilotux.net/~mikael/mcabber/"
AUTHOR = "Mikael Berthe"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "ncurses openssl gpgme"

SRC_URI = "http://www.lilotux.net/~mikael/mcabber/files/mcabber-${PV}.tar.bz2"

inherit autotools

do_configure() {
  export ac_cv_func_malloc_0_nonnull=yes
  export ac_cv_func_realloc_0_nonnull=yes
  oe_runconf
}
