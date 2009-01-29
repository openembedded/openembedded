DESCRIPTION = "Big Buck Bunny movie"
LICENSE = "CC-BY"

SRC_URI = "http://download.blender.org/peach/bigbuckbunny_movies/big_buck_bunny_480p_surround-fix.avi"

do_install() {
	install -d ${D}${datadir}/movie
	install -m 0644 big_buck_bunny_480p_surround-fix.avi ${D}${datadir}/movies 
}

FILES_${PN} += "${datadir}/movie"
PACKAGE_ARCH = "all"

