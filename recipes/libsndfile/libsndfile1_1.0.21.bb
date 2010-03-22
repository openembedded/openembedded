DESCRIPTION = "An audio format Conversion library"
HOMEPAGE = "http://www.mega-nerd.com/libsndfile"
AUTHOR = "Erik de Castro Lopo"
SECTION = "libs/multimedia"
LICENSE = "LGPL"
DEPENDS = "sqlite3"
PR = "r0"

SRC_URI = "http://www.mega-nerd.com/libsndfile/files/libsndfile-${PV}.tar.gz;name=libsndfile1021targz"
SRC_URI[libsndfile1021targz.md5sum] = "880a40ec636ab2185b97f8927299b292"
SRC_URI[libsndfile1021targz.sha256sum] = "7e9083a2551ff347276d82cdb61f2b4f9cd137c0b76433800e991583ded8ea67"

S = "${WORKDIR}/libsndfile-${PV}"

inherit autotools_stage  lib_package pkgconfig

do_configure_prepend_arm() {
	ac_cv_sizeof_off_t=8
}

do_configure_prepend_chinook-compat () {

        for i in  lt~obsolete.m4 ltsugar.m4 libtool.m4 ltoptions.m4 ltversion.m4
        do
                rm ${S}/M4/${i}
        done
}

PACKAGES =+ "${PN}-octave"
FILES_${PN}-octave += "/usr/share/octave/site/m"
