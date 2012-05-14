DESCRIPTION = "The MusicBrainz client is a library which can be built into other programs. \
It allows you to access the data held on the MusicBrainz server."
HOMEPAGE = "http://musicbrainz.org"
LICENSE = "LGPLv2.1+"

DEPENDS = "expat neon libdiscid"

SRC_URI = "ftp://ftp.musicbrainz.org/pub/musicbrainz/libmusicbrainz-${PV}.tar.gz"

inherit cmake pkgconfig

# Fight a compiler/link bug that leaks too many c++ symbols
TARGET_LDFLAGS += " -Wl,-rpath-link,${TOOLCHAIN_PATH}/${TARGET_SYS}/lib -ldl"

