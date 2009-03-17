DESCRIPTION = "Big Buck Bunny movie"
LICENSE = "CC-BY"

SRC_URI = "http://mirror.bigbuckbunny.de/peach/bigbuckbunny_movies/big_buck_bunny_720p_surround.avi"

do_install() {
	install -d ${D}${datadir}/movies
	install -m 0644 ${WORKDIR}/big_buck_bunny_720p_surround.avi ${D}${datadir}/movies/ 
}

FILES_${PN} += "${datadir}/movies"
PACKAGE_ARCH = "all"


