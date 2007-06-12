DESCRIPTION = "The Enlightened Widget Library, \
a simple-to-use general purpose widget library based on the enlightenment foundation libraries."
DEPENDS = "edb virtual/evas virtual/ecore edje"
# emotion
RDEPENDS += "ewl-themes"
LICENSE = "MIT"
PR = "r1"

inherit efl

SRC_URI += "file://ewl-configure.patch;patch=1 \
            file://no-examples.patch;patch=1 \
            file://minmax.patch;patch=1 \
            ${E_CVS};module=e17/libs/evas/m4;date=20060501"

do_configure_prepend() {
	if [ -e "${WORKDIR}/m4" ]; then
		install -d "${S}/m4"
		install "${WORKDIR}/m4/"*.m4 "${S}/m4"
		aclocal -I m4
	fi
}

do_stage_append() {
	for i in src/lib/ewl_*.h
	do
		install -m 0644 $i ${STAGING_INCDIR}
	done
}
