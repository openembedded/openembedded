require quilt-package.inc

do_configure_prepend() {
	# Ugly hack! These tests should be protected by AC_CACHE_CHECK, not deleted.
	sed -i '/^\(AC_MSG_CHECKING.*\(whether\|version of\)\|if.*_version\)/,/^fi/d' configure.ac
}

PR="${INC_PR}.1"

SRC_URI[md5sum] = "f77adda60039ffa753f3c584a286f12b"
SRC_URI[sha256sum] = "73fd760d3b5cbf06417576591dc37d67380d189392db9000c21b7cbebee49ffc"
