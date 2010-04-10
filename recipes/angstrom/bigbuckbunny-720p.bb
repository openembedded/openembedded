DESCRIPTION = "Big Buck Bunny movie"
LICENSE = "CC-BY"

SRC_URI = "http://mirror.bigbuckbunny.de/peach/bigbuckbunny_movies/big_buck_bunny_720p_surround.avi"

do_install() {
	install -d ${D}${datadir}/movies
	install -m 0644 ${WORKDIR}/big_buck_bunny_720p_surround.avi ${D}${datadir}/movies/ 
}

FILES_${PN} += "${datadir}/movies"
PACKAGE_ARCH = "all"



SRC_URI[md5sum] = "0da8fe124595f5b206d64cb1400bbefc"
SRC_URI[sha256sum] = "b957d6e6212638441b52d3b620af157cc8d40c2a0342669294854a06edcd528c"
