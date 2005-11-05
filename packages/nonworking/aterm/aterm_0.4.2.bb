DEPENDS = x11-cvs xproto-cvs

SRC_URI = ${SOURCEFORGE_MIRROR}/aterm/aterm-${PV}.tar.bz2

inherit autotools

do_configure_prepend () {
	cp autoconf/* .
}
