require gpe-what.inc

SRC_URI += "file://makefile-fix.patch;patch=1"

DEPENDS = "virtual/libx11 libxpm libmatchbox"
