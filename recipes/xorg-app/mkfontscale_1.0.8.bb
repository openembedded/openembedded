require xorg-app-common.inc
DESCRIPTION = "a program to create an index of scalable font files for X"
DEPENDS += " zlib libfontenc freetype "
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "5210c9385c6cc4a00ce829d8dc9c819b"
SRC_URI[archive.sha256sum] = "6eb57786cd79eebfbaca386fe24dcfe50689dbf433d052e58291c2925f2050f9"

BBCLASSEXTEND = "native"
