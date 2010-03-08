require git.inc

SRC_URI[src.md5sum] = "76518fa774b36de81d160b85fa4f19c1"
SRC_URI[src.sha256sum] = "5601df7fc282fdd66de196b282694eb77dcfc50438f01587de144b3ead1a6b2f"

EXTRA_OECONF += "ac_cv_snprintf_returns_bogus=no ac_cv_c_c99_format=yes"


DEPENDS = "openssl curl zlib expat"
RDEPENDS = "perl perl-module-file-path cpio findutils sed"
PR = "r4"

FILES_${PN}-dbg += "${libexecdir}/git-core/.debug"
