DESCRIPTION = "The Enlightened Widget Library, \
a simple-to-use general purpose widget library based on the enlightenment foundation libraries."
DEPENDS = "edb eet virtual/evas virtual/ecore etox edje"
LICENSE = "MIT"
PR = "r0"

inherit efl

SRC_URI += "file://ewl-configure.patch;patch=1"

do_configure() {
	gnu-configize
	oe_runconf
}
