DESCRIPTION = "Packages that are to be compiled nativly for the OpenSlug firmware"
LICENSE = MIT
PR = "r2"

INHIBIT_DEFAULT_DEPS = "1"
ALLOW_EMPTY = 1
PACKAGES = "${PN}"

# Just something the test with
OPENSLUG_NATIVE_PACKAGES = "\
	gzip \
	vlan \
	"

BROKEN_PACKAGES = "\
	"

DEPENDS = '${OPENSLUG_NATIVE_PACKAGES} \
	package-index'
