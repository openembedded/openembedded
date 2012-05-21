DESCRIPTION = "An audio format Conversion library"
HOMEPAGE = "http://www.mega-nerd.com/libsndfile"
AUTHOR = "Erik de Castro Lopo"
SECTION = "libs/multimedia"
LICENSE = "LGPLv2.1"
DEPENDS = "sqlite3"
PR = "r1"

SRC_URI = "http://www.mega-nerd.com/libsndfile/files/libsndfile-${PV}.tar.gz"

S = "${WORKDIR}/libsndfile-${PV}"

inherit autotools lib_package pkgconfig

do_configure_prepend_arm() {
	ac_cv_sizeof_off_t=8
	# they are not in one of site/ files because they are common with
	# glib-2.0 if they are moved to common site files then they break
	# glib-2.0 build if largefile support is not available (.e.g. uclibc
	# can be tuned to not have it.
	export ac_cv_sys_largefile_source=1
	export ac_cv_sys_file_offset_bits=64
}

do_configure_prepend_chinook-compat () {
	for i in  lt~obsolete.m4 ltsugar.m4 libtool.m4 ltoptions.m4 ltversion.m4
	do
		rm ${S}/M4/${i}
	done
}

PACKAGES =+ "${PN}-octave"
FILES_${PN}-octave += "/usr/share/octave/site/m"

SRC_URI[md5sum] = "8f823c30c1d8d44830db6ab845d6679e"
SRC_URI[sha256sum] = "b6050e6fbfbb72c8bfbc895104697a4af1d49077a64e4846e0be7af87c9e56a4"
