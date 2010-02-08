require git.inc

SRC_URI += "file://autotools.patch;patch=1 \
            file://snprintf-returns-bogus.patch;patch=1"

DEPENDS = "openssl curl zlib expat"
RDEPENDS = "perl perl-module-file-path cpio findutils sed"
PR = "r4"

FILES_${PN}-dbg += "${libexecdir}/git-core/.debug"
