DESCRIPTION = "The Enlightened Widget Library, \
a simple-to-use general purpose widget library based on the enlightenment foundation libraries."
# as of recent CVS HEAD, ewl no longer needs etox and no longer needs edb
DEPENDS = "edb virtual/evas virtual/ecore edje emotion"
RDEPENDS += "libewl-themes"
LICENSE = "MIT"
PR = "r1"

inherit efl

SRC_URI += "file://ewl-configure.patch;patch=1"

do_stage_append() {
	for i in src/lib/ewl_*.h
	do
		install -m 0644 $i ${STAGING_INCDIR}
	done
}

