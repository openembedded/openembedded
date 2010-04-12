DESCRIPTION = "Conway's Game of Life for GPE"
LICENSE = "GPL"
PRIORITY = "optional"
SECTION = "gpe/games"
PR = "r1"

DEPENDS = "glib-2.0 gtk+ libglade"

inherit gpe autotools

SRC_URI[md5sum] = "dbba547ab6ec998ea35e110fa4daf823"
SRC_URI[sha256sum] = "37cc3abf96ccbc2fc1e5d2691144154d80ad911d63614d6baa65b016268ebccd"
