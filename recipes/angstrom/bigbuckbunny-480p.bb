DESCRIPTION = "Big Buck Bunny movie"
LICENSE = "CC-BY"

SRC_URI = "http://download.blender.org/peach/bigbuckbunny_movies/big_buck_bunny_480p_surround-fix.avi"

do_install() {
	install -d ${D}${datadir}/movies
	install -m 0644 ${WORKDIR}/big_buck_bunny_480p_surround-fix.avi ${D}${datadir}/movies/ 
}

FILES_${PN} += "${datadir}/movies"
PACKAGE_ARCH = "all"

