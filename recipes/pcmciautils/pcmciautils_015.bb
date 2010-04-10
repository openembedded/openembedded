require pcmciautils.inc

PR = "r0"

SRC_URI += "file://makefile_fix.patch;patch=1 \
            file://version_workaround.patch;patch=1 \
	    file://ccdv.patch;patch=1 \
	   "

SRC_URI[md5sum] = "9e12435c8b6cf7bf59894e90e480b4aa"
SRC_URI[sha256sum] = "4847485c412b47e3d88fa83ef811229e0e7941217303bc8449c30a3dc2128b6e"
