LICENSE = "GPL"
inherit gpe

DEPENDS = "libgpewidget glib-2.0 gtk+"
SECTION = "gpe"

SRC_URI += "file://gpe-timesheet-makefile.patch;patch=0"
