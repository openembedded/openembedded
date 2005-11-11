# Only list packages which will not build 'cross' in here.
DESCRIPTION = "Packages that are to be compiled natively for the SlugOS firmware"
LICENSE = "MIT"
PR = "r0"

INHIBIT_DEFAULT_DEPS = "1"
EXCLUDE_FROM_WORLD = "1"
ALLOW_EMPTY = "1"
PACKAGES = "${PN}"

SLUGOS_NATIVE_PACKAGES = "\
	apache \
	"

SLUGOS_BROKEN_NATIVE_PACKAGES = "\
	"

DEPENDS = '${SLUGOS_NATIVE_PACKAGES} \
	package-index'
