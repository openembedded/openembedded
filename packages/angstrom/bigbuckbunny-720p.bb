DESCRIPTION = "Big Buck Bunny movie"
LICENSE = "CC-BY"

SRC_URI = "http://mirror.bigbuckbunny.de/peach/bigbuckbunny_movies/big_buck_bunny_720p_surround.avi"

do_install() {
	install -d ${D}${datadir}/movie
	install -m 0644 big_buck_bunny_720p_surround.avi ${D}${datadir}/movies 
}

FILES_${PN} += "${datadir}/movie"
PACKAGE_ARCH = "all"


