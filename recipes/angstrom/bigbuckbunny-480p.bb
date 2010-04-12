DESCRIPTION = "Big Buck Bunny movie"
LICENSE = "CC-BY"

SRC_URI = "http://download.blender.org/peach/bigbuckbunny_movies/big_buck_bunny_480p_surround-fix.avi"

do_install() {
	install -d ${D}${datadir}/movies
	install -m 0644 ${WORKDIR}/big_buck_bunny_480p_surround-fix.avi ${D}${datadir}/movies/ 
}

FILES_${PN} += "${datadir}/movies"
PACKAGE_ARCH = "all"


SRC_URI[md5sum] = "ed7ed01e9aefba8ddd77c13332cec120"
SRC_URI[sha256sum] = "40d1cf5bc8e1b0e55dac7bb2e3fbc2aea05b6679444864781299b24db044634f"
