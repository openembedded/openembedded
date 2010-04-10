require findutils.inc
LICENSE = "GPLv2"

PR = "${INC_PR}.0"

SRC_URI += "file://mkinstalldirs.patch;patch=1"

EXTRA_OECONF += " ac_cv_path_SORT=/usr/bin/sort "

SRC_URI[archive.md5sum] = "24e76434ca74ba3c2c6ad621eb64e1ff"
SRC_URI[archive.sha256sum] = "1a9ed8db0711f8419156e786b6aecd42dd05df29e53e380d8924e696f7071ae0"
