DESCRIPTION = "slang is a library of text functions used in editors like slrn etc."
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "pcre"
PR = "r2"
LICENSE = "GPL Artistic"
SRC_URI = "ftp://space.mit.edu/pub/davis/slang/v2.2/slang-${PV}.tar.bz2 \
           file://fix-uclibc.patch"

inherit autotools

SRC_URI[md5sum] = "974437602a781cfe92ab61433dd16d03"
SRC_URI[sha256sum] = "cfaf8551fa3855f9b0043309bb553ef6d457f931b404df5a6ba6a5a69371fc42"
