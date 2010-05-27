require gpe-what.inc

SRC_URI += "file://makefile-fix.patch"

DEPENDS = "virtual/libx11 libxpm libmatchbox"
