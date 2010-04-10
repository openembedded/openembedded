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

SRC_URI[md5sum] = "189fb9d23f5a8412bc660884528475ea"
SRC_URI[sha256sum] = "2a231c9241211d33745f110f35cfa6bdb051b32791461b9579794b6623863bb1"
