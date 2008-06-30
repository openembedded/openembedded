require autoconf.inc

DEPENDS += "m4-native"
RDEPENDS_${PN} = "m4 gnu-config"
PR = "r6"

SRC_URI += "file://autoreconf-include.patch;patch=1 \
	   file://autoreconf-exclude.patch;patch=1 \
	   file://autoreconf-foreign.patch;patch=1 \
	   file://autoreconf-gnuconfigize.patch;patch=1 \
	   file://autoconf259-update-configscripts.patch;patch=1 \
	   file://autoheader-nonfatal-warnings.patch;patch=1 \
	   file://sizeof_types.patch;patch=1 \
	   file://autoconf-x.patch;patch=1 \
	   file://autoconf-sh.patch;patch=1 \
	   ${@['file://path_prog_fixes.patch;patch=1', ''][bb.data.inherits_class('native', d)]}"
