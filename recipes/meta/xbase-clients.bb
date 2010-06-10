DESCRIPTION = "Basic X clients (meta package)"
LICENSE = "MIT"
PR = "r2"

ALLOW_EMPTY = "1"
PACKAGES = "${PN}"

RDEPENDS_${PN} = 'xauth \
	xhost \
	xmodmap \
	xrdb \
	xset'

