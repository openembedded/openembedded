require gpe-what.inc

SRC_URI += "file://makefile-fix.patch;apply=yes"

DEPENDS = "virtual/libx11 libxpm libmatchbox"
