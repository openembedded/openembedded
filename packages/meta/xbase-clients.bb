DESCRIPTION = "Basic X clients (meta package)"
MAINTAINER = "Rene Wagner <rw@handhelds.org>"
PR = "r1"

ALLOW_EMPTY = 1
PACKAGES = "${PN}"

RDEPENDS = 'xauth \
	xhost \
	xmodmap \
	xrdb \
	xset'
LICENSE = MIT
