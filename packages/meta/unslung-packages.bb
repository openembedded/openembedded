DESCRIPTION = "Packages that are compatible with the Unslung firmware"
LICENSE = "MIT"
PR = "r5"
COMPATIBLE_MACHINE = "nslu2"

ALLOW_EMPTY = "1"
PACKAGES = "${PN}"

inherit meta

UNSLUNG_PACKAGES = "\
	"

BROKEN_PACKAGES = "\
	"

DEPENDS = 'unslung-image \
	${UNSLUNG_PACKAGES} \
	package-index'
