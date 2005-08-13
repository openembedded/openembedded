DESCRIPTION = "The Enlightened Widget Library, \
a simple-to-use general purpose widget library based on the enlightenment foundation libraries."
DEPENDS = "edb virtual/evas virtual/ecore edje emotion"
LICENSE = "MIT"
PR = "r0"

inherit efl

SRC_URI += "file://ewl-configure.patch;patch=1"

do_stage_append() {
	for i in src/lib/ewl_*.h
	do
		install -m 0644 $i ${STAGING_INCDIR}
	done
}

