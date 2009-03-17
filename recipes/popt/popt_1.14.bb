require popt.inc
DEPENDS = "gettext virtual/libintl"
PR = "r1"

inherit autotools_stage

SRC_URI = "\
  http://rpm5.org/files/popt/popt-${PV}.tar.gz \
"
