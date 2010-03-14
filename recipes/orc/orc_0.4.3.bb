DESCRIPTION = "orc - The Oil Runtime Compiler"
HOMEPAGE = "http://code.entropywave.com/projects/orc/"
PR = "r0"

SRC_URI = "http://code.entropywave.com/download/orc/orc-0.4.3.tar.gz;name=orc043targz"
SRC_URI[orc043targz.md5sum] = "9b2e7030c8df8a0d371115869fe5685a"
SRC_URI[orc043targz.sha256sum] = "4c0266d81da67fef0b2abd5e624a9ab0db5de04eb23c3ab24e22f5f9ceeefbfe"

SRC_URI += "file://03_orcutils.patch;patch=1 \
	file://99_autoreconf.patch;patch=1"

inherit autotools pkgconfig

BBCLASSEXTEND = "native"

PACKAGES += "liborc"

PACKAGES_liborc = ${libdir}
