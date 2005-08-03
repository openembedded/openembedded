DESCRIPTION = "Packages that are to be compiled nativly for the OpenSlug firmware"
LICENSE = MIT
PR = "r1"

INHIBIT_DEFAULT_DEPS = "1"
ALLOW_EMPTY = 1
PACKAGES = "${PN}"

OPENSLUG_NATIVE_PACKAGES = "\
	"

BROKEN_PACKAGES = "\
	"

DEPENDS = '${OPENSLUG_NATIVE_PACKAGES} \
	package-index'
