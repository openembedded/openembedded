require pcmciautils.inc

PR = "r1"

SRC_URI += "file://makefile_fix.patch;apply=yes \
            file://version_workaround.patch;apply=yes \
	    file://modalias_update.patch;apply=yes"

SRC_URI[md5sum] = "3f07c926875f6c5dcb83240f39725177"
SRC_URI[sha256sum] = "6bef7c05ba9fad231fe7a188043c61c116c24bab5fa79d9d72c1d8e11ff38925"
