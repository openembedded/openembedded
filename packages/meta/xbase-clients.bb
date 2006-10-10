DESCRIPTION = "Basic X clients (meta package)"
PR = "r1"

ALLOW_EMPTY = 1
PACKAGES = "${PN}"

RDEPENDS = 'xauth \
	xhost \
	xmodmap \
	xrdb \
	xset'
LICENSE = MIT
