DESCRIPTION = "Basic X clients (meta package)"
MAINTAINER = "Rene Wagner <reenoo@gmx.de>"

ALLOW_EMPTY = 1
PACKAGES = "${PN}"

DEPENDS = 'xauth \
	xhost \
	xmodmap \
	xrdb \
	xset'

RDEPENDS = 'xauth \
	xhost \
	xmodmap \
	xrdb \
	xset'
LICENSE = MIT
