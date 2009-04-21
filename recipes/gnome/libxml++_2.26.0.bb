LICENSE = "LGPL"
DESCRIPTION = "C++ bindings for libxml2"
DEPENDS = "glibmm libxml2"

inherit gnome autotools_stage

FILES_${PN}-dev += "${libdir}/libxml++-2.6/include/libxml++config.h"
