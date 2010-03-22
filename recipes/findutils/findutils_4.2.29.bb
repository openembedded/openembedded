require findutils.inc
LICENSE = "GPLv2"

PR = "${INC_PR}.0"

SRC_URI += "file://mkinstalldirs.patch;patch=1"

EXTRA_OECONF += " ac_cv_path_SORT=/usr/bin/sort "
