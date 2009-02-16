require popt.inc

DEPENDS = "gettext virtual/libintl"

inherit autotools autotools_stage

SRC_URI = "\
  http://rpm.org/releases/historical/rpm-4.1.x/popt-${PV}.tar.gz \
  file://m4.patch;patch=1 \
  file://intl.patch;patch=1 \
"
