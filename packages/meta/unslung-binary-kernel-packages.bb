DESCRIPTION = "Packages that are compatible with the Unslung binary kernel firmware"
LICENSE = MIT
PR = "r0"

ALLOW_EMPTY = 1
PACKAGES = "${PN}"

UNSLUNG_PACKAGES = "\
	"

BROKEN_PACKAGES = "\
	"

DEPENDS = 'unslung-image \
	${UNSLUNG_PACKAGES} \
	package-index'
