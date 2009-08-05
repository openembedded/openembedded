DESCRIPTION = "An audio format Conversion library"
HOMEPAGE = "http://www.mega-nerd.com/libsndfile"
AUTHOR = "Erik de Castro Lopo"
SECTION = "libs/multimedia"
LICENSE = "LGPL"
DEPENDS = "sqlite3"
PR = "r1"


SRC_URI = "http://www.mega-nerd.com/libsndfile/libsndfile-${PV}.tar.gz \
          "

S = "${WORKDIR}/libsndfile-${PV}"

inherit autotools_stage  lib_package pkgconfig

do_configure_prepend_arm() {
	export ac_cv_sys_largefile_source=1
	export ac_cv_sys_file_offset_bits=64
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
