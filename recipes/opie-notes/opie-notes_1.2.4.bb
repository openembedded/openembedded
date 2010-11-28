require ${PN}.inc
PR = "r2"

SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_core_pim_notes.tar.bz2 \
           http://sources.openembedded.org/opie-1.2.4-split_pics.tar.bz2 \
           http://sources.openembedded.org/opie-1.2.4-split_apps.tar.bz2 \
	   file://gcc-4.5-non-trivially-copyable-fix.patch \
	  "
