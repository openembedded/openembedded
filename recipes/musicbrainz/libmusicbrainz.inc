DESCRIPTION = "The MusicBrainz client is a library which can be built into other programs. \
It allows you to access the data held on the MusicBrainz server."
HOMEPAGE = "http://musicbrainz.org"
LICENSE = "LGPL"

DEPENDS = "expat neon libdiscid"

SRC_URI = "ftp://ftp.musicbrainz.org/pub/musicbrainz/libmusicbrainz-${PV}.tar.gz"

inherit cmake pkgconfig

# Fight a compiler/link bug that leaks too many c++ symbols
TARGET_LDFLAGS += " -Wl,-rpath-link,${CROSS_DIR}/${TARGET_SYS}/lib -ldl"

do_stage() {
	autotools_stage_all
}

