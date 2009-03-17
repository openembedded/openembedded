require oprofile.inc

PR = "r3"

SRC_URI = "${SOURCEFORGE_MIRROR}/oprofile/oprofile-${PV}.tar.gz \
	   file://no_arm_mapping_syms.patch;patch=1 \
           file://opcontrol_bashisms.patch;patch=1 \
	   file://acinclude.m4"
