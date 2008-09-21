require pcmciautils.inc

PR = "r0"

SRC_URI += "file://makefile_fix.patch;patch=1 \
            file://version_workaround.patch;patch=1 \
	    file://ccdv.patch;patch=1 \
	   "
