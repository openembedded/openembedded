DESCRIPTION = "mRSS is a C library for parsing, writing and creating RSS (0.91, 0.92, 1.0, 2.0) files or streams"
LICENSE = "LGPL"
HOMEPAGE = "http://www2.autistici.org/bakunin/codes.php"

DEPENDS = "libnxml curl"

inherit autotools pkgconfig

SRC_URI = "http://www2.autistici.org/bakunin/libmrss/libmrss-${PV}.tar.gz;md5sum=28d0e78d736748e67f25ad99456f10c3 \
           file://atom-changes.patch;patch=1                                                                      \
           file://fix_atom_date_locale.patch;patch=1                                                              \
           file://bump-version.patch;patch=1 "

do_stage() {
    autotools_stage_all
}
