CVSDATE = "20060609"
include enigma_cvs.bb
SRC_URI_append = " file://network_fix.diff;patch=1;pnum=1 \
	file://rotor_fix.diff;patch=1;pnum=1 \
	file://disable_boot.diff;patch=1;pnum=1"
CXXFLAGS_append = " -DHAVE_DREAMBOX_HARDWARE"
EXTRA_OECONF_append = " --with-webif=standard --with-epg=private --with-enigma-debug=yes --with-reiserfs=no"
