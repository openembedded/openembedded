DEPENDS = x11-cvs xproto-cvs

SRC_URI = ${SOURCEFORGE_MIRROR}/aterm/aterm-${PV}.tar.bz2

inherit autotools

do_configure_prepend () {
	cp autoconf/* .
}

SRC_URI[md5sum] = "5c29d0cde4225bdbd63ccb6a4dd94c56"
SRC_URI[sha256sum] = "88f3b807f918630ed338a44d854d10af83e103336ac41517cf003dd9c0f389bb"
